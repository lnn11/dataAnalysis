package com.zhb.dataAnalysis.marketing.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.bson.Document;
import org.springframework.stereotype.Service;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.zhb.dataAnalysis.common.repository.database.marketing.SummerSpecialDao;
import com.zhb.dataAnalysis.common.repository.database.marketing.WuChangRiceDao;
import com.zhb.dataAnalysis.marketing.api.IWuChangRiceService;

@Service("wuChangRiceService")
public class WuChangRiceServiceImpl implements IWuChangRiceService{

	@Resource(name = "wuChangRiceDao")
	private WuChangRiceDao wuChangRiceDao;
	
	@Resource(name="summerSpecialDao")
	private SummerSpecialDao summerSpecialDao;
	
	@Override
	public Map<String, BigDecimal> getWuChangRiceData(String startTime, String endTime, String data, String activityId) {
		BigDecimal count = null;
		Map<String, BigDecimal> ticketCount = new HashMap<String, BigDecimal>();
		Map<String, BigDecimal> redeem = new HashMap<String, BigDecimal>();
		Map<String, BigDecimal> ticket = new HashMap<String, BigDecimal>();
		if(!activityId.equals("ZHB20170001016")) {
			if(data == ""){
//				if(activityId.equals("ZHB20170524001")) {
					count = wuChangRiceDao.getChannelCount(startTime, endTime).add(new BigDecimal(1));
//				}else{
//					count = new BigDecimal(wuChangRiceDao.getChannelRice(startTime,endTime).size());
//				}
			}else{
				count = new BigDecimal(1);
			}
			
			if(data == "") {
				if(activityId.equals("ZHB20170524001")) {
					redeem = wuChangRiceDao.getRedeemCode();
					ticket = wuChangRiceDao.getTicketCount(startTime,endTime,data,activityId);
				}else {
					ticket = wuChangRiceDao.getTicketCount(startTime,endTime,data,activityId);
				}
			}else{
				if(data.equals("兑换码")) {
					ticketCount = wuChangRiceDao.getRedeemCode();
				}else{
					ticketCount = wuChangRiceDao.getTicketCount(startTime,endTime,data,activityId);
				}
			}
		}
		
		Map<String, BigDecimal> registerUser = new HashMap<String, BigDecimal>();
		if(activityId.equals("ZHB20170001016")) {
			registerUser = summerSpecialDao.getActivityUserCount(startTime, endTime, activityId, null);
		}else{
			registerUser = wuChangRiceDao.getRegisterUser(startTime,endTime,data,activityId);
		}
		Map<String, BigDecimal> buyNumPayCash = wuChangRiceDao.getBuyNumPayCash(startTime,endTime,data,activityId);
		
		Map<String,BigDecimal> finalMap = new HashMap<String, BigDecimal>();
		if(data == ""){
			if(activityId.equals("ZHB20170524001")) {
				finalMap.put("ticketCount", redeem.get("TICKETCOUNT").add(ticket.get("TICKETCOUNT")));
			}else {
				finalMap.put("ticketCount", redeem.get("TICKETCOUNT"));
			}
		}else{
			finalMap.put("ticketCount", ticketCount.get("TICKETCOUNT"));
		}
		if(activityId.equals("ZHB20170001016")) {
			finalMap.put("registerUser", registerUser.get("ACTIVITYUSERCOUNT"));
		}else{
			finalMap.put("registerUser", registerUser.get("REGISTERUSER"));
			finalMap.put("channelCount", count);
		}
		finalMap.put("buyNum", buyNumPayCash.get("BUYNUM"));
		finalMap.put("payCash", buyNumPayCash.get("PAYCASH"));
		return finalMap;
	}

	@Override
	public List<Map<String, String>> getChannel(String startTime, String endTime, String data,String activityId) {
		List<Map<String,String>> channel = new ArrayList<Map<String, String>>();
//		if(activityId.equals("ZHB20170524001")) {
			 channel = wuChangRiceDao.getChannel(startTime,endTime);
//		}else{
//			channel = wuChangRiceDao.getChannelRice(startTime,endTime);
//		}
		return channel;
	}

	@Override
	public String getChannelName(String data) {
		return wuChangRiceDao.getChannelName(data);
	}

	/**
	 * 	万年贡大米获取购买数量特权，兑换码领取数量，去注册按钮点击数统计
	 */
	@Override
	public Map<String, BigDecimal> getRedeemCode(String startTime, String endTime, String data, String activityId) {
		//	获取购买特权数量
		Map<String, BigDecimal> getSpecialRedeemCode = wuChangRiceDao.getRedeemCodeCount(startTime,endTime,data);
		//兑换码领取数量
		Map<String, BigDecimal> getRedeemCode = wuChangRiceDao.getRedeemCount(startTime,endTime,data);
		
		BasicDBObject q  = new BasicDBObject();
		q.put("time", BasicDBObjectBuilder.start("$gte", startTime).add("$lt", endTime).get());
		if(!"".equals(data)) {
			if(data.equals("null")) {
				data = "";
			}
			q.put("channelNo", data);
		}
		List<Document> docList = MongoDBUtil.findAll(q, "ricePullNew");
		for (Document document : docList) {
			System.out.println(document);
		}
		
		
		Map<String,BigDecimal> finalMap = new HashMap<String, BigDecimal>();
		finalMap.put("specialCounts", getSpecialRedeemCode.get("TICKETCOUNT"));
		finalMap.put("ticketCountes", getRedeemCode.get("TICKETCOUNT"));
		finalMap.put("longinCounts", new BigDecimal(docList.size()));
		return finalMap;
	}

	/**
	 * 老用户邀请新用户优惠券
	 */
	@Override
	public Map<String, BigDecimal> getCouponUser() {
		Map<String,BigDecimal> finalMap = new HashMap<String, BigDecimal>();
		//优惠券的数量
		Map<String, BigDecimal> couponCount = wuChangRiceDao.getCouponUser(0);
		Map<String, BigDecimal> couponCount2 = wuChangRiceDao.getCouponUser(2);
		Map<String, BigDecimal> couponCount3 = wuChangRiceDao.getCouponUser(3);
		finalMap.put("specialCounts", couponCount.get("TICKETCOUNT"));
		finalMap.put("ticketCountes", couponCount2.get("TICKETCOUNT"));
		finalMap.put("pastTicketCountes", couponCount3.get("TICKETCOUNT"));
		return finalMap;
	}

}
