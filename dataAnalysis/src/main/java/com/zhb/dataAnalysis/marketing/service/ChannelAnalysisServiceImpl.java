package com.zhb.dataAnalysis.marketing.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhb.dataAnalysis.common.repository.database.channelanalysis.ChannelAnalysisDao;
import com.zhb.dataAnalysis.marketing.api.IChannelAnalysisService;
import com.zhb.dataAnalysis.marketing.beans.ChannelDataAnalysis;

@Service(value="channelAnalysisService")
@SuppressWarnings("unchecked")
public class ChannelAnalysisServiceImpl implements IChannelAnalysisService {
	
	private static final Logger log = LoggerFactory.getLogger(ChannelAnalysisServiceImpl.class);
	
	@Autowired
	private ChannelAnalysisDao channelAnalysisDao;	

	@Override
	public <T> T channelDataAnalysis(ChannelDataAnalysis cda,int rows,int curPage,int channelTotal){		
		try {
			String startTime = cda.getStartTime();
			String endTime = cda.getEndTime();
			Date startDate = DateUtils.parseDate(startTime, "yyyy/MM/dd");
			Date endDate = DateUtils.parseDate(endTime, "yyyy/MM/dd");
			
			List<ChannelDataAnalysis> list = null,reBuyList = null,registerList = null;
			List<ChannelDataAnalysis> result = new ArrayList<ChannelDataAnalysis>(1);
			
			int days = 0;//一共多少天(初始)
			int pageTotal = 0;//一共多少页(初始)
			int size = (channelTotal == 0) ? rows : rows/channelTotal;//每页显示多少天的数据
			if(cda != null && StringUtils.isNotBlank(cda.getChannelId())){//选择具体渠道时,数据变为一天显示一条数据。
				size = rows;
			}
						
			days = (int) ((endDate.getTime() - startDate.getTime()) / (1000*3600*24)+1);
			pageTotal = days/size+(days%size == 0 ? 0:1);
			
			if(curPage >= pageTotal){
				curPage = pageTotal;
				if(pageTotal == 1){
					size = days;
				}else{
					startDate = DateUtils.addDays(startDate, (curPage-1)*size);
				}
			}else{
				startDate = DateUtils.addDays(startDate, (curPage-1)*size);
			}			
			
			for(int c = 1;c <= size;c++){//按天查
				cda.setDate(startDate);
				list = channelAnalysisDao.getOrderSum(cda);
				reBuyList = channelAnalysisDao.getRepeatBuyers(cda.getChannelId(), cda.getReBuyersMin(),cda.getReBuyersMax(),cda.getDate());
				registerList = channelAnalysisDao.getRegisterUser(cda.getChannelId(),cda.getRegisterMin(),cda.getRegisterMax(),cda.getDate());
				if(list != null && list.size() > 0){
					for (int i = 0; i < list.size(); i++) {					
						ChannelDataAnalysis channel = list.get(i);
						channel.setReBuyers(reBuyList.get(i).getReBuyers());
						channel.setRegisters(registerList.get(i).getRegisters());
						channel.setStartTime(DateFormatUtils.format(startDate, "yyyy/MM/dd"));
					}
					result.addAll(list);
				}
				startDate = DateUtils.addDays(startDate, 1);
				int compare = DateUtils.toCalendar(startDate).compareTo(DateUtils.toCalendar(endDate));
				if(compare > 0){
					break;
				}
			}
			
			int total = 0;
			Map<String,Object> map = new HashMap<String,Object>(1);
			map.put("rows", result);
			if(result.size() > 0){
				total = days*channelTotal;
			}
			map.put("total", total);			
			return (T)map;
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("渠道参数传递有误:{%}", e.getMessage());
		}
		return null;
	}
	
	@Override
	public <T> T countChannelInfo(ChannelDataAnalysis cda) {
		try {
			Map<String,BigDecimal> map = null; 
			//订单总数,订单总金额（元）,实际支付总金额（元）
			Map<String,BigDecimal> aboutOrderSum = channelAnalysisDao.getAboutOrderSum(cda);
			if(aboutOrderSum != null){
				map = aboutOrderSum;
			}else{
				map = new HashMap<String,BigDecimal>();				
				map.put("ORDERS", BigDecimal.ZERO);
				map.put("AMOUNTS", BigDecimal.ZERO);
				map.put("ACTUALPAY", BigDecimal.ZERO);
			}
			
			//复购用户总数（人）
			Map<String,BigDecimal> reBuyersSum = channelAnalysisDao.getReBuyers(cda.getChannelId(), cda.getReBuyersMin(), cda.getReBuyersMax(), cda.getStartTime(), cda.getEndTime());
			if(reBuyersSum != null){
				BigDecimal reBuyers = reBuyersSum.get("REBUYERS");
				map.put("REBUYERS", reBuyers);
			}else{
				map.put("REBUYERS", BigDecimal.ZERO);
			}
			
			//注册用户总数
			Map<String,BigDecimal> registersSum = channelAnalysisDao.getRegisterUsers(cda.getChannelId(), cda.getRegisterMin(), cda.getRegisterMax(), cda.getStartTime(), cda.getEndTime());
			if(registersSum != null){
				BigDecimal registers = registersSum.get("REGISTERS");
				map.put("REGISTERS", registers);
			}else{
				map.put("REGISTERS", BigDecimal.ZERO);
			}			
			return (T)map;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("渠道参数传递有误:{%}", e.getMessage());
		}
		return null;
	}
	
	@Override
	public <T> T getChannelAll() {
		return (T)channelAnalysisDao.getChannelAll();
	}
}
