package com.zhb.dataAnalysis.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.zhb.dataAnalysis.marketing.api.IChannelAnalysisService;
import com.zhb.dataAnalysis.marketing.beans.ChannelDataAnalysis;

@Controller
@RequestMapping(value="marketing/channelAnalysis")
public class ChannelController {	
	
	@Autowired
	private IChannelAnalysisService channelAnalysisService;
	

	/**
	 * 跳转 渠道数据分析 页面
	 * @return
	 */
	@RequestMapping(path = {"channel"},method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView loadChannelAnalysisPage(){
		ModelAndView mav = new ModelAndView("aiPinXuan/center/marketing/channelAnalysis");
		List<Map<String,String>> list = channelAnalysisService.getChannelAll();
		int count = 0;String result = "[]";
		if(list != null && list.size() > 0){
			count = list.size();
			result = JSON.toJSONString(list);
		}
		mav.addObject("channelMap", result);
		mav.addObject("channelTotal", count);
		Calendar c = Calendar.getInstance(); 
		c.add(Calendar.MONTH, 0);
	    c.set(Calendar.DAY_OF_MONTH,1);
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	    mav.addObject("startTime", sdf.format(c.getTime()));	    
	    mav.addObject("endTime", sdf.format(new Date()));
		return mav;
	}
	
	/**
	 * 点击"查询" 渠道数据分析
	 * @param cda
	 * @param currentPage
	 * @return
	 */
	@ResponseBody
	@RequestMapping(path = "list",method = {RequestMethod.GET,RequestMethod.POST})	
	public Map<String,Object> loadChannelAnalysisData(ChannelDataAnalysis cda,int rows,int page,int channelTotal){
		return channelAnalysisService.channelDataAnalysis(cda,rows,page,channelTotal);
	}
	
	/**
	 * 渠道数据统计
	 * @param cda
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "countData",method = {RequestMethod.GET,RequestMethod.POST})
	public Map<String,BigDecimal> loadTotalChannelData(ChannelDataAnalysis cda){
		return channelAnalysisService.countChannelInfo(cda);
	}
}
