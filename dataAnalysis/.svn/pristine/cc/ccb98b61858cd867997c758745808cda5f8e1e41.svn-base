package com.zhb.dataAnalysis.marketing.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhb.dataAnalysis.common.repository.database.marketing.DuanWuDao;
import com.zhb.dataAnalysis.common.repository.database.marketing.HouseHomeDao;
import com.zhb.dataAnalysis.common.repository.database.marketing.MomInfantDao;
import com.zhb.dataAnalysis.common.repository.database.marketing.NanguaGirlDao;
import com.zhb.dataAnalysis.common.repository.database.marketing.SummerSpecialDao;
import com.zhb.dataAnalysis.common.repository.database.marketing.SuperMarketDao;
import com.zhb.dataAnalysis.common.repository.database.marketing.ZhouNianQingDao;
import com.zhb.dataAnalysis.marketing.api.IActivityTemplateService;

@Service("activityTemplateService")
public class ActivityTemplateServiceImpl implements IActivityTemplateService{

	@Resource(name="nanguaGirlDao")
	private NanguaGirlDao nanguaGirlDao;
	
	@Resource(name="momInfantDao")
	private MomInfantDao momInfantDao;
	
	@Resource(name="duanWuDao")
	private DuanWuDao duanWuDao;
	 
	@Resource(name="houseHomeDao")
	private HouseHomeDao houseHomeDao;
	
	@Resource(name="superMarketDao")
	private SuperMarketDao superMarketDao;
	
	@Resource(name="zhouNianQingDao")
	private ZhouNianQingDao zhouNianQingDao;
	
	@Resource(name="summerSpecialDao")
	private SummerSpecialDao summerSpecialDao;


	@Override
	public Map<String, BigDecimal> getActivitySPU(String startTime, String endTime, String data, String activityId) {
		Map<String,BigDecimal> mapTotal = new HashMap<String, BigDecimal>();
		Map<String,BigDecimal> mapApp = new HashMap<String, BigDecimal>();
		Map<String,BigDecimal> mapWebChat = new HashMap<String, BigDecimal>();
		Map<String,BigDecimal> mapMicro = new HashMap<String, BigDecimal>();
		Map<String,BigDecimal> mapM = new HashMap<String, BigDecimal>();
		Map<String,BigDecimal> mapTotal1 = new HashMap<String, BigDecimal>();
		Map<String,BigDecimal> mapApp1 = new HashMap<String, BigDecimal>();
		Map<String,BigDecimal> mapWebChat1 = new HashMap<String, BigDecimal>();
		Map<String,BigDecimal> mapMicro1 = new HashMap<String, BigDecimal>();
		Map<String,BigDecimal> mapM1 = new HashMap<String, BigDecimal>();
		String[] productId = null;
		if(startTime.compareTo("2017-07-01 00:00:00") < 0) {
			if(activityId.equals("ZHB20170419001")) {//南瓜姑娘
				mapTotal = nanguaGirlDao.getNanguaGirlSPU(startTime, endTime, activityId,null);
				mapApp = nanguaGirlDao.getNanguaGirlSPU(startTime, endTime, activityId,"1");
				mapWebChat = nanguaGirlDao.getNanguaGirlSPU(startTime, endTime, activityId,"2");
				mapMicro = nanguaGirlDao.getNanguaGirlSPU(startTime, endTime, activityId,"");		
			}else if(activityId.equals("ZHB20170502001")) {//母婴
				mapTotal = momInfantDao.getMomInfantSPUSKU(startTime, endTime, data, activityId, null);
				mapApp = momInfantDao.getMomInfantSPUSKU(startTime, endTime, data, activityId, "1");
				mapWebChat = momInfantDao.getMomInfantSPUSKU(startTime, endTime, data, activityId, "2");
				mapMicro = momInfantDao.getMomInfantSPUSKU(startTime, endTime, data, activityId, "");
			}else if(activityId.equals("ZHB20170503001")) {//端午节福利活动
				mapTotal = duanWuDao.getDuanWuSPUSKU(startTime, endTime, data, activityId, null);
				mapApp = duanWuDao.getDuanWuSPUSKU(startTime, endTime, data, activityId, "1");
				mapWebChat = duanWuDao.getDuanWuSPUSKU(startTime, endTime, data, activityId, "2");
				mapMicro = duanWuDao.getDuanWuSPUSKU(startTime, endTime, data, activityId, "");
			}else if(activityId.equals("ZHB20170523001")) {//618家居家电活动
				mapTotal = houseHomeDao.getHouseHomeSPUSKU(startTime, endTime, data, activityId, null);
				mapApp = houseHomeDao.getHouseHomeSPUSKU(startTime, endTime, data, activityId, "1");
				mapWebChat = houseHomeDao.getHouseHomeSPUSKU(startTime, endTime, data, activityId, "2");
				mapMicro = houseHomeDao.getHouseHomeSPUSKU(startTime, endTime, data, activityId, "");
			}else if(activityId.equals("ZHB20170523002")) {//618超市节活动
				mapTotal = superMarketDao.getSuperMarketSPUSKU(startTime, endTime, data, activityId, null);
				mapApp = superMarketDao.getSuperMarketSPUSKU(startTime, endTime, data, activityId, "1");
				mapWebChat = superMarketDao.getSuperMarketSPUSKU(startTime, endTime, data, activityId, "2");
				mapMicro = superMarketDao.getSuperMarketSPUSKU(startTime, endTime, data, activityId, "");
			}else if(activityId.equals("ZHB20170607001")) {//周年庆活动
				mapTotal = zhouNianQingDao.getZhouNianQingSPUSKU(startTime, endTime, data, activityId, null);
				mapApp = zhouNianQingDao.getZhouNianQingSPUSKU(startTime, endTime, data, activityId, "1");
				mapWebChat = zhouNianQingDao.getZhouNianQingSPUSKU(startTime, endTime, data, activityId, "2");
				mapMicro = zhouNianQingDao.getZhouNianQingSPUSKU(startTime, endTime, data, activityId, "");
			}
		}else {
			if(activityId.equals("ZHB20170713001")) {
				productId = new String[]{"d262e0b51a754066a90d9e2bc8acc16d","c2127ce3fa574092a9e13436d140da92","31cab09d028844f4866550062cb03355","32bf3a49b33145f5b0261a922bcb9020"};
			}else if(activityId.equals("ZHB20170815001")) {
				productId = new String[]{"f397450c749149118dbfa7cae432b370","8ebd882dba524bd69dbe3e86e06d43cb","c5da4cbf983347138e074243e56056f6","a19d19af19e54a67a8a01cac3aefcad2"};
			}
			if(data.equals("全部")) {
				mapTotal = summerSpecialDao.getSummerSpecialSPUSKU(startTime, endTime, data, activityId, null);
				mapApp = summerSpecialDao.getSummerSpecialSPUSKU(startTime, endTime, data, activityId, "1");
				mapWebChat = summerSpecialDao.getSummerSpecialSPUSKU(startTime, endTime, data, activityId, "2");
				mapMicro = summerSpecialDao.getSummerSpecialSPUSKU(startTime, endTime, data, activityId, "3");
				mapM = summerSpecialDao.getSummerSpecialSPUSKU(startTime, endTime, data, activityId, "4");
				if(productId != null) {
					mapTotal1 = summerSpecialDao.getGroupSpuSku(startTime, endTime, productId, null);
					mapApp1 = summerSpecialDao.getGroupSpuSku(startTime, endTime, productId, "1");
					mapWebChat1 = summerSpecialDao.getGroupSpuSku(startTime, endTime, productId, "2");
					mapMicro1 = summerSpecialDao.getGroupSpuSku(startTime, endTime, productId, "3");
					mapM1 = summerSpecialDao.getGroupSpuSku(startTime, endTime, productId, "4");
				}
			}else if(data.equals("团购")) {
				mapTotal = summerSpecialDao.getGroupSpuSku(startTime, endTime, productId, null);
				mapApp = summerSpecialDao.getGroupSpuSku(startTime, endTime, productId, "1");
				mapWebChat = summerSpecialDao.getGroupSpuSku(startTime, endTime, productId, "2");
				mapMicro = summerSpecialDao.getGroupSpuSku(startTime, endTime, productId, "3");
				mapM = summerSpecialDao.getGroupSpuSku(startTime, endTime, productId, "4");
			}else{
				mapTotal = summerSpecialDao.getSummerSpecialSPUSKU(startTime, endTime, data, activityId, null);
				mapApp = summerSpecialDao.getSummerSpecialSPUSKU(startTime, endTime, data, activityId, "1");
				mapWebChat = summerSpecialDao.getSummerSpecialSPUSKU(startTime, endTime, data, activityId, "2");
				mapMicro = summerSpecialDao.getSummerSpecialSPUSKU(startTime, endTime, data, activityId, "3");
				mapM = summerSpecialDao.getSummerSpecialSPUSKU(startTime, endTime, data, activityId, "4");
			}
		}
		Map<String,BigDecimal> finalMap = new HashMap<String, BigDecimal>();
		if(data.equals("全部") && productId != null) {
			finalMap.put("saleSpuTotal", mapTotal.get("PRODUCTCOUNT").add(mapTotal1.get("PRODUCTCOUNT")));
			finalMap.put("saleSpuAppTotal",mapApp.get("PRODUCTCOUNT").add(mapApp1.get("PRODUCTCOUNT")));
			if(startTime.compareTo("2017-09-13 00:00:00") >= 0) {
				finalMap.put("saleSpuWebChatTotal",mapWebChat.get("PRODUCTCOUNT").add(mapWebChat1.get("PRODUCTCOUNT")).add(mapM.get("PRODUCTCOUNT")).add(mapM1.get("PRODUCTCOUNT")));
				finalMap.put("saleSkuWebChatTotal", mapWebChat.get("PRODUCTDETAILCOUNT").add(mapWebChat1.get("PRODUCTDETAILCOUNT")).add(mapM.get("PRODUCTDETAILCOUNT")).add(mapM1.get("PRODUCTDETAILCOUNT")));
			}else{
				finalMap.put("saleSpuWebChatTotal",mapWebChat.get("PRODUCTCOUNT").add(mapWebChat1.get("PRODUCTCOUNT")));
				finalMap.put("saleSkuWebChatTotal", mapWebChat.get("PRODUCTDETAILCOUNT").add(mapWebChat1.get("PRODUCTDETAILCOUNT")));
			}
			finalMap.put("saleSpuMicroTotal",mapMicro.get("PRODUCTCOUNT").add(mapMicro1.get("PRODUCTCOUNT")));
			finalMap.put("saleSpuMTotal", mapM.get("PRODUCTCOUNT").add(mapM1.get("PRODUCTCOUNT")));
			
			finalMap.put("saleSkuTotal", mapTotal.get("PRODUCTDETAILCOUNT").add(mapTotal1.get("PRODUCTDETAILCOUNT")));
			finalMap.put("saleSkuAppTotal", mapApp.get("PRODUCTDETAILCOUNT").add(mapApp1.get("PRODUCTDETAILCOUNT")));
			finalMap.put("saleSkuMicroTotal", mapMicro.get("PRODUCTDETAILCOUNT").add(mapMicro1.get("PRODUCTDETAILCOUNT")));
			finalMap.put("saleSkuMTotal", mapM.get("PRODUCTDETAILCOUNT").add(mapM1.get("PRODUCTDETAILCOUNT")));
		}else{
			if(startTime.compareTo("2017-09-13 00:00:00") >= 0) {//微网站和M站合并
				finalMap.put("saleSpuWebChatTotal",mapWebChat.get("PRODUCTCOUNT").add(mapM.get("PRODUCTCOUNT")));
				finalMap.put("saleSkuWebChatTotal", mapWebChat.get("PRODUCTDETAILCOUNT").add(mapM.get("PRODUCTDETAILCOUNT")));
			}else{
				finalMap.put("saleSpuWebChatTotal",mapWebChat.get("PRODUCTCOUNT"));
				finalMap.put("saleSkuWebChatTotal", mapWebChat.get("PRODUCTDETAILCOUNT"));
			}
			
			finalMap.put("saleSpuTotal", mapTotal.get("PRODUCTCOUNT"));
			finalMap.put("saleSpuAppTotal",mapApp.get("PRODUCTCOUNT"));
			finalMap.put("saleSpuMicroTotal",mapMicro.get("PRODUCTCOUNT"));
			finalMap.put("saleSpuMTotal", mapM.get("PRODUCTCOUNT"));
			
			finalMap.put("saleSkuTotal", mapTotal.get("PRODUCTDETAILCOUNT"));
			finalMap.put("saleSkuAppTotal", mapApp.get("PRODUCTDETAILCOUNT"));
			finalMap.put("saleSkuMicroTotal", mapMicro.get("PRODUCTDETAILCOUNT"));
			finalMap.put("saleSkuMTotal", mapM.get("PRODUCTDETAILCOUNT"));
		}
		return finalMap;
	}
	
	@Override
	public Map<String, BigDecimal> getActivityTotal(String startTime,String endTime, String data, String activityId) {
		Map<String,BigDecimal> mapTotal = new HashMap<String, BigDecimal>();
		Map<String,BigDecimal> mapApp = new HashMap<String, BigDecimal>();
		Map<String,BigDecimal> mapWebChat = new HashMap<String, BigDecimal>();
		Map<String,BigDecimal> mapMicro = new HashMap<String, BigDecimal>();
		Map<String,BigDecimal> mapM = new HashMap<String, BigDecimal>();
		Map<String,BigDecimal> mapTotal1 = new HashMap<String, BigDecimal>();
		Map<String,BigDecimal> mapApp1 = new HashMap<String, BigDecimal>();
		Map<String,BigDecimal> mapWebChat1 = new HashMap<String, BigDecimal>();
		Map<String,BigDecimal> mapMicro1 = new HashMap<String, BigDecimal>();
		Map<String,BigDecimal> mapM1 = new HashMap<String, BigDecimal>();
		String[] productId = null;
		if(startTime.compareTo("2017-07-01 00:00:00") < 0) {
			if(activityId.equals("ZHB20170419001")) {//南瓜姑娘
				mapTotal = nanguaGirlDao.getNanguaGirlTotal(startTime, endTime, activityId, null);
				mapApp = nanguaGirlDao.getNanguaGirlTotal(startTime, endTime, activityId, "1");
				mapWebChat = nanguaGirlDao.getNanguaGirlTotal(startTime, endTime, activityId, "2");
				mapMicro = nanguaGirlDao.getNanguaGirlTotal(startTime, endTime, activityId, "");
			}else if(activityId.equals("ZHB20170502001")) {//母婴
				mapTotal = momInfantDao.getMomInfantTotal(startTime, endTime, data, activityId, null);
				mapApp = momInfantDao.getMomInfantTotal(startTime, endTime, data, activityId, "1");
				mapWebChat = momInfantDao.getMomInfantTotal(startTime, endTime, data, activityId, "2");
				mapMicro = momInfantDao.getMomInfantTotal(startTime, endTime, data, activityId, "");
			}else if(activityId.equals("ZHB20170503001")) {//端午节福利活动
				mapTotal = duanWuDao.getDuanWuTotal(startTime, endTime, data, activityId, null);
				mapApp = duanWuDao.getDuanWuTotal(startTime, endTime, data, activityId, "1");
				mapWebChat = duanWuDao.getDuanWuTotal(startTime, endTime, data, activityId, "2");
				mapMicro = duanWuDao.getDuanWuTotal(startTime, endTime, data, activityId, "");
			}else if(activityId.equals("ZHB20170523001")) {//618家居家电活动
				mapTotal = houseHomeDao.getHouseHomeTotal(startTime, endTime, data, activityId, null);
				mapApp = houseHomeDao.getHouseHomeTotal(startTime, endTime, data, activityId, "1");
				mapWebChat = houseHomeDao.getHouseHomeTotal(startTime, endTime, data, activityId, "2");
				mapMicro = houseHomeDao.getHouseHomeTotal(startTime, endTime, data, activityId, "");
			}else if(activityId.equals("ZHB20170523002")) {//618超市节活动
				mapTotal = superMarketDao.getSuperMarketTotal(startTime, endTime, data, activityId, null);
				mapApp = superMarketDao.getSuperMarketTotal(startTime, endTime, data, activityId, "1");
				mapWebChat = superMarketDao.getSuperMarketTotal(startTime, endTime, data, activityId, "2");
				mapMicro = superMarketDao.getSuperMarketTotal(startTime, endTime, data, activityId, "");
			}else if(activityId.equals("ZHB20170607001")) {//周年庆活动
				mapTotal = zhouNianQingDao.getZhouNianQingTotal(startTime, endTime, data, activityId, null);
				mapApp = zhouNianQingDao.getZhouNianQingTotal(startTime, endTime, data, activityId, "1");
				mapWebChat = zhouNianQingDao.getZhouNianQingTotal(startTime, endTime, data, activityId, "2");
				mapMicro = zhouNianQingDao.getZhouNianQingTotal(startTime, endTime, data, activityId, "");
			}
		}else{
			if(activityId.equals("ZHB20170713001")) {
				productId = new String[]{"d262e0b51a754066a90d9e2bc8acc16d","c2127ce3fa574092a9e13436d140da92","31cab09d028844f4866550062cb03355","32bf3a49b33145f5b0261a922bcb9020"};
			}else if(activityId.equals("ZHB20170815001")) {
				productId = new String[]{"f397450c749149118dbfa7cae432b370","8ebd882dba524bd69dbe3e86e06d43cb","c5da4cbf983347138e074243e56056f6","a19d19af19e54a67a8a01cac3aefcad2"};
			}
			if(data.equals("全部")) {
				mapTotal = summerSpecialDao.getSummerSpecialTotal(startTime, endTime, data, activityId, null);
				mapApp = summerSpecialDao.getSummerSpecialTotal(startTime, endTime, data, activityId, "1");
				mapWebChat = summerSpecialDao.getSummerSpecialTotal(startTime, endTime, data, activityId, "2");
				mapMicro = summerSpecialDao.getSummerSpecialTotal(startTime, endTime, data, activityId, "3");
				mapM = summerSpecialDao.getSummerSpecialTotal(startTime, endTime, data, activityId, "4");
				if(productId != null) {
					mapTotal1 = summerSpecialDao.getGroupSpecialTotal(startTime, endTime, productId, null);
					mapApp1 = summerSpecialDao.getGroupSpecialTotal(startTime, endTime, productId, "1");
					mapWebChat1 = summerSpecialDao.getGroupSpecialTotal(startTime, endTime, productId, "2");
					mapMicro1 = summerSpecialDao.getGroupSpecialTotal(startTime, endTime, productId, "3");
					mapM1 = summerSpecialDao.getGroupSpecialTotal(startTime, endTime, productId, "4");
				}
			}else if(data.equals("团购")) {
				mapTotal = summerSpecialDao.getGroupSpecialTotal(startTime, endTime, productId, null);
				mapApp = summerSpecialDao.getGroupSpecialTotal(startTime, endTime, productId, "1");
				mapWebChat = summerSpecialDao.getGroupSpecialTotal(startTime, endTime, productId, "2");
				mapMicro = summerSpecialDao.getGroupSpecialTotal(startTime, endTime, productId, "3");
				mapM = summerSpecialDao.getGroupSpecialTotal(startTime, endTime, productId, "4");
			}else{
				mapTotal = summerSpecialDao.getSummerSpecialTotal(startTime, endTime, data, activityId, null);
				mapApp = summerSpecialDao.getSummerSpecialTotal(startTime, endTime, data, activityId, "1");
				mapWebChat = summerSpecialDao.getSummerSpecialTotal(startTime, endTime, data, activityId, "2");
				mapMicro = summerSpecialDao.getSummerSpecialTotal(startTime, endTime, data, activityId, "3");
				mapM = summerSpecialDao.getSummerSpecialTotal(startTime, endTime, data, activityId, "4");
			}	
		}
		
		Map<String,BigDecimal> finalMap = new HashMap<String, BigDecimal>();
		if(data.equals("全部") && productId != null) {
			if(startTime.compareTo("2017-09-13 00:00:00") >= 0) {//微网站和M站合并
				finalMap.put("saleProductWebChatTotal", mapWebChat.get("活动商品总销量").add(mapWebChat1.get("活动商品总销量")).add(mapM.get("活动商品总销量")).add(mapM1.get("活动商品总销量")));
				finalMap.put("saleMainOrderWebChatTotal", mapWebChat.get("活动主订单总数").add(mapWebChat1.get("活动主订单总数")).add(mapM.get("活动主订单总数")).add(mapM1.get("活动主订单总数")));
				finalMap.put("saleSubOrderWebChatTotal", mapWebChat.get("活动子订单总数").add(mapWebChat1.get("活动子订单总数")).add(mapM.get("活动子订单总数")).add(mapM1.get("活动子订单总数")));
				finalMap.put("saleCashTotalWebChatSub", mapWebChat.get("现金支付总金额").add(mapWebChat1.get("现金支付总金额")).add(mapM.get("现金支付总金额")).add(mapM1.get("现金支付总金额")));
				finalMap.put("actualPayPointWebChatTotal", mapWebChat.get("实际支付总积分").add(mapWebChat1.get("实际支付总积分")).add(mapM.get("实际支付总积分")).add(mapM1.get("实际支付总积分")));
				finalMap.put("specialCashWebChatTotal", mapWebChat.get("福利券支付总积分").add(mapWebChat1.get("福利券支付总积分")).add(mapM.get("福利券支付总积分")).add(mapM1.get("福利券支付总积分")));
			}else{
				finalMap.put("saleProductWebChatTotal", mapWebChat.get("活动商品总销量").add(mapWebChat1.get("活动商品总销量")));
				finalMap.put("saleMainOrderWebChatTotal", mapWebChat.get("活动主订单总数").add(mapWebChat1.get("活动主订单总数")));
				finalMap.put("saleSubOrderWebChatTotal", mapWebChat.get("活动子订单总数").add(mapWebChat1.get("活动子订单总数")));
				finalMap.put("saleCashTotalWebChatSub", mapWebChat.get("现金支付总金额").add(mapWebChat1.get("现金支付总金额")));
				finalMap.put("actualPayPointWebChatTotal", mapWebChat.get("实际支付总积分").add(mapWebChat1.get("实际支付总积分")));
				finalMap.put("specialCashWebChatTotal", mapWebChat.get("福利券支付总积分").add(mapWebChat1.get("福利券支付总积分")));
			}
			
			finalMap.put("saleProductTotal", mapTotal.get("活动商品总销量").add(mapTotal1.get("活动商品总销量")));
			finalMap.put("saleProductAppTotal", mapApp.get("活动商品总销量").add(mapApp1.get("活动商品总销量")));
			
			finalMap.put("saleProductMicroTotal", mapMicro.get("活动商品总销量").add(mapMicro1.get("活动商品总销量")));
			finalMap.put("saleProductMTotal", mapM.get("活动商品总销量").add(mapM1.get("活动商品总销量")));
			
			finalMap.put("saleMainOrderTotal", mapTotal.get("活动主订单总数").add(mapTotal1.get("活动主订单总数")));
			finalMap.put("saleMainOrderAppTotal", mapApp.get("活动主订单总数").add(mapApp1.get("活动主订单总数")));
			
			finalMap.put("saleMainOrderMicroTotal", mapMicro.get("活动主订单总数").add(mapMicro1.get("活动主订单总数")));
			finalMap.put("saleMainOrderMTotal", mapM.get("活动主订单总数").add(mapM1.get("活动主订单总数")));
			
			finalMap.put("saleSubOrderTotal", mapTotal.get("活动子订单总数").add(mapTotal1.get("活动子订单总数")));
			finalMap.put("saleSubOrderAppTotal", mapApp.get("活动子订单总数").add(mapApp1.get("活动子订单总数")));
			
			finalMap.put("saleSubOrderMicroTotal", mapMicro.get("活动子订单总数").add(mapMicro1.get("活动子订单总数")));
			finalMap.put("saleSubOrderMTotal", mapM.get("活动子订单总数").add(mapM1.get("活动子订单总数")));
			
			
			finalMap.put("saleCashTotalSub", mapTotal.get("现金支付总金额").add(mapTotal1.get("现金支付总金额")));
			finalMap.put("saleCashTotalAppSub", mapApp.get("现金支付总金额").add(mapApp1.get("现金支付总金额")));

			finalMap.put("saleCashTotalMicroSub", mapMicro.get("现金支付总金额").add(mapMicro1.get("现金支付总金额")));
			finalMap.put("saleCashTotalMSub", mapM.get("现金支付总金额").add(mapM1.get("现金支付总金额")));
			
			
			finalMap.put("actualPayPointTotal", mapTotal.get("实际支付总积分").add(mapTotal1.get("实际支付总积分")));
			finalMap.put("actualPayPointAppTotal", mapApp.get("实际支付总积分").add(mapApp1.get("实际支付总积分")));
			
			finalMap.put("actualPayPointMicroTotal", mapMicro.get("实际支付总积分").add(mapMicro1.get("实际支付总积分")));
			finalMap.put("actualPayPointMTotal", mapM.get("实际支付总积分").add(mapM1.get("实际支付总积分")));
			
			finalMap.put("specialCashTotal", mapTotal.get("福利券支付总积分").add(mapTotal1.get("福利券支付总积分")));
			finalMap.put("specialCashAppTotal", mapApp.get("福利券支付总积分").add(mapApp1.get("福利券支付总积分")));
			
			finalMap.put("specialCashMicroTotal", mapMicro.get("福利券支付总积分").add(mapMicro1.get("福利券支付总积分")));
			finalMap.put("specialCashMTotal", mapM.get("福利券支付总积分").add(mapM1.get("福利券支付总积分")));
		}else{
			if(startTime.compareTo("2017-09-13 00:00:00") >= 0) {//微网站和M站合并
				finalMap.put("saleProductWebChatTotal", mapWebChat.get("活动商品总销量").add(mapM.get("活动商品总销量")));
				finalMap.put("saleMainOrderWebChatTotal", mapWebChat.get("活动主订单总数").add(mapM.get("活动主订单总数")));
				finalMap.put("saleSubOrderWebChatTotal", mapWebChat.get("活动子订单总数").add(mapM.get("活动子订单总数")));
				finalMap.put("saleCashTotalWebChatSub", mapWebChat.get("现金支付总金额").add(mapM.get("现金支付总金额")));
				finalMap.put("actualPayPointWebChatTotal", mapWebChat.get("实际支付总积分").add(mapM.get("实际支付总积分")));
				finalMap.put("specialCashWebChatTotal", mapWebChat.get("福利券支付总积分").add(mapM.get("福利券支付总积分")));
			}else{
				finalMap.put("saleProductWebChatTotal", mapWebChat.get("活动商品总销量"));
				finalMap.put("saleMainOrderWebChatTotal", mapWebChat.get("活动主订单总数"));
				finalMap.put("saleSubOrderWebChatTotal", mapWebChat.get("活动子订单总数"));
				finalMap.put("saleCashTotalWebChatSub", mapWebChat.get("现金支付总金额"));
				finalMap.put("actualPayPointWebChatTotal", mapWebChat.get("实际支付总积分"));
				finalMap.put("specialCashWebChatTotal", mapWebChat.get("福利券支付总积分"));
			}
			
			finalMap.put("saleProductTotal", mapTotal.get("活动商品总销量"));
			finalMap.put("saleProductAppTotal", mapApp.get("活动商品总销量"));
			
			finalMap.put("saleProductMicroTotal", mapMicro.get("活动商品总销量"));
			finalMap.put("saleProductMTotal", mapM.get("活动商品总销量"));
			
			finalMap.put("saleMainOrderTotal", mapTotal.get("活动主订单总数"));
			finalMap.put("saleMainOrderAppTotal", mapApp.get("活动主订单总数"));
			
			finalMap.put("saleMainOrderMicroTotal", mapMicro.get("活动主订单总数"));
			finalMap.put("saleMainOrderMTotal", mapM.get("活动主订单总数"));
			
			finalMap.put("saleSubOrderTotal", mapTotal.get("活动子订单总数"));
			finalMap.put("saleSubOrderAppTotal", mapApp.get("活动子订单总数"));
			
			finalMap.put("saleSubOrderMicroTotal", mapMicro.get("活动子订单总数"));
			finalMap.put("saleSubOrderMTotal", mapM.get("活动子订单总数"));
			
			finalMap.put("saleCashTotalSub", mapTotal.get("现金支付总金额"));
			finalMap.put("saleCashTotalAppSub", mapApp.get("现金支付总金额"));
			
			finalMap.put("saleCashTotalMicroSub", mapMicro.get("现金支付总金额"));
			finalMap.put("saleCashTotalMSub", mapM.get("现金支付总金额"));
			
			finalMap.put("actualPayPointTotal", mapTotal.get("实际支付总积分"));
			finalMap.put("actualPayPointAppTotal", mapApp.get("实际支付总积分"));
			
			finalMap.put("actualPayPointMicroTotal", mapMicro.get("实际支付总积分"));
			finalMap.put("actualPayPointMTotal", mapM.get("实际支付总积分"));
			
			finalMap.put("specialCashTotal", mapTotal.get("福利券支付总积分"));
			finalMap.put("specialCashAppTotal", mapApp.get("福利券支付总积分"));
			
			finalMap.put("specialCashMicroTotal", mapMicro.get("福利券支付总积分"));
			finalMap.put("specialCashMTotal", mapM.get("福利券支付总积分"));
		}
		return finalMap;
	}

	@Override
	public Map<String, BigDecimal> getActivityUserTotal(String startTime,String endTime, String data, String activityId) {
		Map<String,BigDecimal> mapTotal = new HashMap<String, BigDecimal>();
		Map<String,BigDecimal> mapApp = new HashMap<String, BigDecimal>();
		Map<String,BigDecimal> mapWebChat = new HashMap<String, BigDecimal>();
		Map<String,BigDecimal> mapMicro = new HashMap<String, BigDecimal>();
		Map<String,BigDecimal> mapM = new HashMap<String, BigDecimal>();
		Map<String,BigDecimal> mapTotal1 = new HashMap<String, BigDecimal>();
		Map<String,BigDecimal> mapApp1 = new HashMap<String, BigDecimal>();
		Map<String,BigDecimal> mapWebChat1 = new HashMap<String, BigDecimal>();
		Map<String,BigDecimal> mapMicro1 = new HashMap<String, BigDecimal>();
		Map<String,BigDecimal> mapM1 = new HashMap<String, BigDecimal>();
		String[] productId = null;
		if(startTime.compareTo("2017-07-01 00:00:00") < 0) {
			if(activityId.equals("ZHB20170419001")) {//南瓜姑娘
				mapTotal = nanguaGirlDao.getNanguaGirlUserTotal(startTime, endTime, activityId, null);
				mapApp = nanguaGirlDao.getNanguaGirlUserTotal(startTime, endTime, activityId, "1");
				mapWebChat = nanguaGirlDao.getNanguaGirlUserTotal(startTime, endTime, activityId, "2");
				mapMicro = nanguaGirlDao.getNanguaGirlUserTotal(startTime, endTime, activityId, "");
			}else if(activityId.equals("ZHB20170502001")) {//母婴
				mapTotal = momInfantDao.getMomInfantUsertotal(startTime, endTime, data, activityId, null);
				mapApp = momInfantDao.getMomInfantUsertotal(startTime, endTime, data, activityId, "1");
				mapWebChat = momInfantDao.getMomInfantUsertotal(startTime, endTime, data, activityId, "2");
				mapMicro = momInfantDao.getMomInfantUsertotal(startTime, endTime, data, activityId, "");
			}else if(activityId.equals("ZHB20170503001")) {//端午节福利活动
				mapTotal = duanWuDao.getDuanWuUserTotal(startTime, endTime, data, activityId, null);
				mapApp = duanWuDao.getDuanWuUserTotal(startTime, endTime, data, activityId, "1");
				mapWebChat = duanWuDao.getDuanWuUserTotal(startTime, endTime, data, activityId, "2");
				mapMicro = duanWuDao.getDuanWuUserTotal(startTime, endTime, data, activityId, "");
			}else if(activityId.equals("ZHB20170523001")) {//618家居家电活动
				mapTotal = houseHomeDao.getHouseHomeUserTotal(startTime, endTime, data, activityId, null);
				mapApp = houseHomeDao.getHouseHomeUserTotal(startTime, endTime, data, activityId, "1");
				mapWebChat = houseHomeDao.getHouseHomeUserTotal(startTime, endTime, data, activityId, "2");
				mapMicro = houseHomeDao.getHouseHomeUserTotal(startTime, endTime, data, activityId, "");
			}else if(activityId.equals("ZHB20170523002")) {//618超市节活动
				mapTotal = superMarketDao.getSuperMarketUserTotal(startTime, endTime, data, activityId, null);
				mapApp = superMarketDao.getSuperMarketUserTotal(startTime, endTime, data, activityId, "1");
				mapWebChat = superMarketDao.getSuperMarketUserTotal(startTime, endTime, data, activityId, "2");
				mapMicro = superMarketDao.getSuperMarketUserTotal(startTime, endTime, data, activityId, "");
			}else if(activityId.equals("ZHB20170607001")) {//周年庆活动
				mapTotal = zhouNianQingDao.getZhouNianQingUserTotal(startTime, endTime, data, activityId, null);
				mapApp = zhouNianQingDao.getZhouNianQingUserTotal(startTime, endTime, data, activityId, "1");
				mapWebChat = zhouNianQingDao.getZhouNianQingUserTotal(startTime, endTime, data, activityId, "2");
				mapMicro = zhouNianQingDao.getZhouNianQingUserTotal(startTime, endTime, data, activityId, "");
			}
		}else{
			if(activityId.equals("ZHB20170713001")) {
				productId = new String[]{"d262e0b51a754066a90d9e2bc8acc16d","c2127ce3fa574092a9e13436d140da92","31cab09d028844f4866550062cb03355","32bf3a49b33145f5b0261a922bcb9020"};
			}else if(activityId.equals("ZHB20170815001")) {
				productId = new String[]{"f397450c749149118dbfa7cae432b370","8ebd882dba524bd69dbe3e86e06d43cb","c5da4cbf983347138e074243e56056f6","a19d19af19e54a67a8a01cac3aefcad2"};
			}
			if(data.equals("全部")) {
				mapTotal = summerSpecialDao.getSummerSpecialUserTotal(startTime, endTime, data, activityId, null);
				mapApp = summerSpecialDao.getSummerSpecialUserTotal(startTime, endTime, data, activityId, "1");
				mapMicro = summerSpecialDao.getSummerSpecialUserTotal(startTime, endTime, data, activityId, "3");
				if(startTime.compareTo("2017-09-13 00:00:00") >= 0) {//微网站和M站合并
					mapWebChat = summerSpecialDao.getSummerSpecialUserTotals(startTime, endTime, data, activityId, "2");
				}else{
					mapWebChat = summerSpecialDao.getSummerSpecialUserTotal(startTime, endTime, data, activityId, "2");
					mapM = summerSpecialDao.getSummerSpecialUserTotal(startTime, endTime, data, activityId, "4");
				}
				if(productId != null) {
					mapTotal1 = summerSpecialDao.getGroupUserTotal(startTime, endTime, productId, null);
					mapApp1 = summerSpecialDao.getGroupUserTotal(startTime, endTime, productId, "1");
					mapMicro1 = summerSpecialDao.getGroupUserTotal(startTime, endTime, productId, "3");
					if(startTime.compareTo("2017-09-13 00:00:00") >= 0) {//微网站和M站合并
						mapWebChat1 = summerSpecialDao.getGroupUserTotals(startTime, endTime, productId, "2");
					}else{
						mapWebChat1 = summerSpecialDao.getGroupUserTotal(startTime, endTime, productId, "2");
						mapM1 = summerSpecialDao.getGroupUserTotal(startTime, endTime, productId, "4");
					}
				}
			}else if(data.equals("团购")) {
				mapTotal = summerSpecialDao.getGroupUserTotal(startTime, endTime, productId, null);
				mapApp = summerSpecialDao.getGroupUserTotal(startTime, endTime, productId, "1");
				mapMicro = summerSpecialDao.getGroupUserTotal(startTime, endTime, productId, "3");
				if(startTime.compareTo("2017-09-13 00:00:00") >= 0) {//微网站和M站合并
					mapWebChat = summerSpecialDao.getGroupUserTotals(startTime, endTime, productId, "2");
				}else{
					mapWebChat = summerSpecialDao.getGroupUserTotal(startTime, endTime, productId, "2");
					mapM = summerSpecialDao.getGroupUserTotal(startTime, endTime, productId, "4");
				}
			}else{
				mapTotal = summerSpecialDao.getSummerSpecialUserTotal(startTime, endTime, data, activityId, null);
				mapApp = summerSpecialDao.getSummerSpecialUserTotal(startTime, endTime, data, activityId, "1");
				mapMicro = summerSpecialDao.getSummerSpecialUserTotal(startTime, endTime, data, activityId, "3");
				if(startTime.compareTo("2017-09-13 00:00:00") >= 0) {//微网站和M站合并
					mapWebChat = summerSpecialDao.getSummerSpecialUserTotals(startTime, endTime, data, activityId, "2");
				}else{
					mapWebChat = summerSpecialDao.getSummerSpecialUserTotal(startTime, endTime, data, activityId, "2");
					mapM = summerSpecialDao.getSummerSpecialUserTotal(startTime, endTime, data, activityId, "4");
				}
			}
		}
		
		Map<String,BigDecimal> finalMap = new HashMap<String, BigDecimal>();
		
		if(data.equals("全部") && productId != null) {
			if(startTime.compareTo("2017-09-13 00:00:00") >= 0) {//微网站和M站合并
				finalMap.put("travelUserCountMicroMall", mapWebChat.get("USERID").add(mapWebChat1.get("USERID")));
			}else{
				finalMap.put("travelUserCountMicroMall", mapWebChat.get("USERID").add(mapWebChat1.get("USERID")));
				finalMap.put("travelUserCountM", mapM.get("USERID").add(mapM1.get("USERID")));
			}
			
			finalMap.put("travelUserCount", mapTotal.get("USERID").add(mapTotal1.get("USERID")));
			finalMap.put("travelUserCountAPP", mapApp.get("USERID").add(mapApp1.get("USERID")));
			finalMap.put("travelUserCountMicro", mapMicro.get("USERID").add(mapMicro1.get("USERID")));
		}else{
			if(startTime.compareTo("2017-09-13 00:00:00") >= 0) {//微网站和M站合并
				finalMap.put("travelUserCountMicroMall", mapWebChat.get("USERID"));
			}else{
				finalMap.put("travelUserCountMicroMall", mapWebChat.get("USERID"));
				finalMap.put("travelUserCountM", mapM.get("USERID"));
			}
			finalMap.put("travelUserCount", mapTotal.get("USERID"));
			finalMap.put("travelUserCountAPP", mapApp.get("USERID"));
			finalMap.put("travelUserCountMicro", mapMicro.get("USERID"));
		}
		
		return finalMap;
	}
	
	@Override
	public Map<String, BigDecimal> getActivityUserRepeat(String startTime, String endTime, String data, String activityId) {
		Map<String,BigDecimal> mapTotal = new HashMap<String, BigDecimal>();
		Map<String,BigDecimal> mapApp = new HashMap<String, BigDecimal>();
		Map<String,BigDecimal> mapWebChat = new HashMap<String, BigDecimal>();
		Map<String,BigDecimal> mapMicro = new HashMap<String, BigDecimal>();
		Map<String,BigDecimal> mapM = new HashMap<String, BigDecimal>();
		Map<String,BigDecimal> mapTotal1 = new HashMap<String, BigDecimal>();
		Map<String,BigDecimal> mapApp1 = new HashMap<String, BigDecimal>();
		Map<String,BigDecimal> mapWebChat1 = new HashMap<String, BigDecimal>();
		Map<String,BigDecimal> mapMicro1 = new HashMap<String, BigDecimal>();
		Map<String,BigDecimal> mapM1 = new HashMap<String, BigDecimal>();
		String[] productId = null;
		if(startTime.compareTo("2017-07-01 00:00:00") < 0) {
			if(activityId.equals("ZHB20170419001")) {//南瓜姑娘
				mapTotal = nanguaGirlDao.getNanguaGirlUserRepeat(startTime, endTime, activityId, null);
				mapApp = nanguaGirlDao.getNanguaGirlUserRepeat(startTime, endTime, activityId, "1");
				mapWebChat = nanguaGirlDao.getNanguaGirlUserRepeat(startTime, endTime, activityId, "2");
				mapMicro = nanguaGirlDao.getNanguaGirlUserRepeat(startTime, endTime, activityId, "");
			}else if(activityId.equals("ZHB20170502001")) {//母婴
				mapTotal = momInfantDao.getMomInfantUserRepeat(startTime, endTime, data, activityId, null);
				mapApp = momInfantDao.getMomInfantUserRepeat(startTime, endTime, data, activityId, "1");
				mapWebChat = momInfantDao.getMomInfantUserRepeat(startTime, endTime, data, activityId, "2");
				mapMicro = momInfantDao.getMomInfantUserRepeat(startTime, endTime, data, activityId, "");
			}else if(activityId.equals("ZHB20170503001")) {//端午节福利活动
				mapTotal = duanWuDao.getDuanWuUserRepeat(startTime, endTime, data, activityId, null);
				mapApp = duanWuDao.getDuanWuUserRepeat(startTime, endTime, data, activityId, "1");
				mapWebChat = duanWuDao.getDuanWuUserRepeat(startTime, endTime, data, activityId, "2");
				mapMicro = duanWuDao.getDuanWuUserRepeat(startTime, endTime, data, activityId, "");
			}else if(activityId.equals("ZHB20170523001")) {//618家居家电活动
				mapTotal = houseHomeDao.getHouseHomeUserRepeat(startTime, endTime, data, activityId, null);
				mapApp = houseHomeDao.getHouseHomeUserRepeat(startTime, endTime, data, activityId, "1");
				mapWebChat = houseHomeDao.getHouseHomeUserRepeat(startTime, endTime, data, activityId, "2");
				mapMicro = houseHomeDao.getHouseHomeUserRepeat(startTime, endTime, data, activityId, "");
			}else if(activityId.equals("ZHB20170523002")) {//618超市节活动
				mapTotal = superMarketDao.getSuperMarketUserRepeat(startTime, endTime, data, activityId, null);
				mapApp = superMarketDao.getSuperMarketUserRepeat(startTime, endTime, data, activityId, "1");
				mapWebChat = superMarketDao.getSuperMarketUserRepeat(startTime, endTime, data, activityId, "2");
				mapMicro = superMarketDao.getSuperMarketUserRepeat(startTime, endTime, data, activityId, "");
			}else if(activityId.equals("ZHB20170607001")) {//周年庆活动
				mapTotal = zhouNianQingDao.getZhouNianQingUserRepeat(startTime, endTime, data, activityId, null);
				mapApp = zhouNianQingDao.getZhouNianQingUserRepeat(startTime, endTime, data, activityId, "1");
				mapWebChat = zhouNianQingDao.getZhouNianQingUserRepeat(startTime, endTime, data, activityId, "2");
				mapMicro = zhouNianQingDao.getZhouNianQingUserRepeat(startTime, endTime, data, activityId, "");
			}
		}else{
			if(activityId.equals("ZHB20170713001")) {
				productId = new String[]{"d262e0b51a754066a90d9e2bc8acc16d","c2127ce3fa574092a9e13436d140da92","31cab09d028844f4866550062cb03355","32bf3a49b33145f5b0261a922bcb9020"};
			}else if(activityId.equals("ZHB20170815001")) {
				productId = new String[]{"f397450c749149118dbfa7cae432b370","8ebd882dba524bd69dbe3e86e06d43cb","c5da4cbf983347138e074243e56056f6","a19d19af19e54a67a8a01cac3aefcad2"};
			}
			if(data.equals("全部")) {
				mapTotal = summerSpecialDao.getSummerSpecialUserRepeat(startTime, endTime, data, activityId, null);
				mapApp = summerSpecialDao.getSummerSpecialUserRepeat(startTime, endTime, data, activityId, "1");
				mapMicro = summerSpecialDao.getSummerSpecialUserRepeat(startTime, endTime, data, activityId, "3");
				if(startTime.compareTo("2017-09-13 00:00:00") >= 0) {
					mapWebChat = summerSpecialDao.getSummerSpecialUserRepeats(startTime, endTime, data, activityId, "2");
				}else{
					mapWebChat = summerSpecialDao.getSummerSpecialUserRepeat(startTime, endTime, data, activityId, "2");
					mapM = summerSpecialDao.getSummerSpecialUserRepeat(startTime, endTime, data, activityId, "4");
				}
				if(productId != null) {
					mapTotal1 = summerSpecialDao.getGroupUserRepeat(startTime, endTime, productId, null);
					mapApp1 = summerSpecialDao.getGroupUserRepeat(startTime, endTime, productId, "1");
					mapMicro1 = summerSpecialDao.getGroupUserRepeat(startTime, endTime, productId, "3");
					if(startTime.compareTo("2017-09-13 00:00:00") >= 0) {
						mapWebChat1 = summerSpecialDao.getGroupUserRepeats(startTime, endTime, productId, "2");
					}else{
						mapWebChat1 = summerSpecialDao.getGroupUserRepeat(startTime, endTime, productId, "2");
						mapM1 = summerSpecialDao.getGroupUserRepeat(startTime, endTime, productId, "4");
					}
				}
			}else if(data.equals("团购")) {
				mapTotal = summerSpecialDao.getGroupUserRepeat(startTime, endTime, productId, null);
				mapApp = summerSpecialDao.getGroupUserRepeat(startTime, endTime, productId, "1");
				mapMicro = summerSpecialDao.getGroupUserRepeat(startTime, endTime, productId, "3");
				if(startTime.compareTo("2017-09-13 00:00:00") >= 0) {
					mapWebChat = summerSpecialDao.getGroupUserRepeats(startTime, endTime, productId, "2");
				}else{
					mapWebChat = summerSpecialDao.getGroupUserRepeat(startTime, endTime, productId, "2");
					mapM = summerSpecialDao.getGroupUserRepeat(startTime, endTime, productId, "4");
				}
			}else{
				mapTotal = summerSpecialDao.getSummerSpecialUserRepeat(startTime, endTime, data, activityId, null);
				mapApp = summerSpecialDao.getSummerSpecialUserRepeat(startTime, endTime, data, activityId, "1");
				mapMicro = summerSpecialDao.getSummerSpecialUserRepeat(startTime, endTime, data, activityId, "3");
				if(startTime.compareTo("2017-09-13 00:00:00") >= 0) {
					mapWebChat = summerSpecialDao.getSummerSpecialUserRepeats(startTime, endTime, data, activityId, "2");
				}else{
					mapWebChat = summerSpecialDao.getSummerSpecialUserRepeat(startTime, endTime, data, activityId, "2");
					mapM = summerSpecialDao.getSummerSpecialUserRepeat(startTime, endTime, data, activityId, "4");
				}
			}
		}
		
		Map<String,BigDecimal> finalMap = new HashMap<String, BigDecimal>();
		if(data.equals("全部") && productId != null) {
			if(startTime.compareTo("2017-09-13 00:00:00") >= 0) {//微网站和M站合并
				finalMap.put("travelRepeUserCountMicroMall", mapWebChat.get("USERCOUNT").add(mapWebChat1.get("USERCOUNT")));
			}else{
				finalMap.put("travelRepeUserCountMicroMall", mapWebChat.get("USERCOUNT").add(mapWebChat1.get("USERCOUNT")));
				finalMap.put("travelRepeUserCountM", mapM.get("USERCOUNT").add(mapM1.get("USERCOUNT")));
			}
			
			finalMap.put("travelRepeUserCount", mapTotal.get("USERCOUNT").add(mapTotal1.get("USERCOUNT")));
			finalMap.put("travelRepeUserCountAPP", mapApp.get("USERCOUNT").add(mapApp1.get("USERCOUNT")));
			
			finalMap.put("travelRepeUserCountMicro", mapMicro.get("USERCOUNT").add(mapMicro1.get("USERCOUNT")));
			
		}else{
			if(startTime.compareTo("2017-09-13 00:00:00") >= 0) {//微网站和M站合并
				finalMap.put("travelRepeUserCountMicroMall", mapWebChat.get("USERCOUNT"));
			}else{
				finalMap.put("travelRepeUserCountMicroMall", mapWebChat.get("USERCOUNT"));
				finalMap.put("travelRepeUserCountM", mapM.get("USERCOUNT"));
			}
			
			finalMap.put("travelRepeUserCount", mapTotal.get("USERCOUNT"));
			finalMap.put("travelRepeUserCountAPP", mapApp.get("USERCOUNT"));
			
			finalMap.put("travelRepeUserCountMicro", mapMicro.get("USERCOUNT"));
			
		}
		return finalMap;
	}
	
	@Override
	public Map<String, BigDecimal> getActivityUserAdd(String startTime, String endTime) {
		return nanguaGirlDao.getNanguaGirlUserAdd(startTime, endTime);
	}

	@Override
	public Map<String, BigDecimal> getActivityUserCount(String startTime, String endTime, String activityId) {
		Map<String, BigDecimal> activityUserCount = summerSpecialDao.getActivityUserCount(startTime, endTime, activityId, null);
		Map<String, BigDecimal> activityUserCounMicroMallt = summerSpecialDao.getActivityUserCount(startTime, endTime, activityId, "2");
		Map<String, BigDecimal> activityUserCountM = summerSpecialDao.getActivityUserCount(startTime, endTime, activityId, "4");
		Map<String, BigDecimal> activityUserApp = summerSpecialDao.getActivityUserCount(startTime, endTime, activityId, "1");
		Map<String, BigDecimal> activityUserCountW = summerSpecialDao.getActivityUserCount(startTime, endTime, activityId, "3");


		Map<String,BigDecimal> finalMap = new HashMap<String, BigDecimal>();
		if(startTime.compareTo("2017-09-13 00:00:00") >= 0) {//微网站和M站合并
			finalMap.put("activityMicroMallTotal", activityUserCounMicroMallt.get("ACTIVITYUSERCOUNT").add(activityUserCountM.get("ACTIVITYUSERCOUNT")));
		}else{
			finalMap.put("activityMicroMallTotal", activityUserCounMicroMallt.get("ACTIVITYUSERCOUNT"));
			finalMap.put("activityMTotal", activityUserCountM.get("ACTIVITYUSERCOUNT"));
		}
		finalMap.put("activityUserApp",activityUserApp.get("ACTIVITYUSERCOUNT"));
		finalMap.put("activityUserCountW",activityUserCountW.get("ACTIVITYUSERCOUNT"));

		finalMap.put("activityTotals", activityUserCount.get("ACTIVITYUSERCOUNT"));
		
		return finalMap;
	}

	@Override
	public Map<String, BigDecimal> getParticipationData(String startTime, String endTime, String activityId) {
		int activityType = 0;
		if(activityId.equals("ZHB20170721001")) {
			activityType = 1;
		}else if(activityId.equals("ZHB20170904001")) {
			activityType = 2;
		}else if(activityId.equals("ZHB20171123001")){
			activityType=4;
		}else if(activityId.equals("ZHB20171212001")){
			activityType=5;
		}else if(activityId.equals("ZHB20180212001")){
			activityType=6;
		}
		return summerSpecialDao.getParticipationData(startTime, endTime, activityType);
	}

	@Override
	public Map<String, BigDecimal> getPrizeData(String startTime, String endTime, String activityId) {
		int activityType = 0;
		if(activityId.equals("ZHB20170721001")) {
			activityType = 1;
		}else if(activityId.equals("ZHB20170904001")) {
			activityType = 2;
		}else if(activityId.equals("ZHB20171123001")){
			activityType=4;
		}else if(activityId.equals("ZHB20171212001")){
			activityType=5;
		}else if(activityId.equals("ZHB20180212001")){
			activityType=6;
		}
		return summerSpecialDao.getPrizeData(startTime, endTime, activityType);
	}

	@Override
	public Map<String, BigDecimal> getEnjoyData(String startTime, String endTime, String activityId) {
		return summerSpecialDao.getEnjoyData(startTime, endTime, activityId);
	}

	@Override
	public Map<String, BigDecimal> getExpendIntegral(String startTime, String endTime, String activityId) {
		int activityType = 0;
		if(activityId.equals("ZHB20170721001")) {
			activityType = 1;
		}else if(activityId.equals("ZHB20170904001")) {
			activityType = 2;
		}
		return summerSpecialDao.getExpendIntegral(startTime, endTime, activityType);
	}

	@Override
	public Map<String, BigDecimal> getThanksCount(String startTime, String endTime, String activityId) {
		int activityType = 0;
		if(activityId.equals("ZHB20170721001")) {
			activityType = 1;
		}else if(activityId.equals("ZHB20170904001")) {
			activityType = 2;
		}
		return summerSpecialDao.getThanksCount(startTime, endTime, activityType);
	}

	@Override
	public Map<String, BigDecimal> getPrizeInterger(String startTime, String endTime) {
		Map<String, BigDecimal> prizeIntergerCount = summerSpecialDao.getPrizeIntergerCount(startTime, endTime, "30" );
		Map<String, BigDecimal> prizeIntergerHundredCount = summerSpecialDao.getPrizeIntergerCount(startTime, endTime, "100");
		Map<String, BigDecimal> prizeIntergerTwoHundredCount = summerSpecialDao.getPrizeIntergerCount(startTime, endTime, "200");
		Map<String, BigDecimal> prizeIntergerFiveHundredCount = summerSpecialDao.getPrizeIntergerCount(startTime, endTime, "500");
		
		Map<String,BigDecimal> finalMap = new HashMap<String, BigDecimal>();
		finalMap.put("thirtyCount", prizeIntergerCount.get("COUNT"));
		finalMap.put("hundredCount", prizeIntergerHundredCount.get("COUNT"));
		finalMap.put("twoHundredCount", prizeIntergerTwoHundredCount.get("COUNT"));
		finalMap.put("FiveHundredCount", prizeIntergerFiveHundredCount.get("COUNT"));
		
		finalMap.put("thirtyCountTimes", prizeIntergerCount.get("COUNTTIMES"));
		finalMap.put("hundredCountTimes", prizeIntergerHundredCount.get("COUNTTIMES"));
		finalMap.put("twoHundredCountTimes", prizeIntergerTwoHundredCount.get("COUNTTIMES"));
		finalMap.put("FiveHundredCountTimes", prizeIntergerFiveHundredCount.get("COUNTTIMES"));
		
		finalMap.put("thirtyCountNumber", prizeIntergerCount.get("COUNTNUMBER"));
		finalMap.put("hundredCountNumber", prizeIntergerHundredCount.get("COUNTNUMBER"));
		finalMap.put("twoHundredCountNumber", prizeIntergerTwoHundredCount.get("COUNTNUMBER"));
		finalMap.put("FiveHundredCountNumber", prizeIntergerFiveHundredCount.get("COUNTNUMBER"));
		return finalMap;
	}


	@Override
	public Map<String, BigDecimal> getPrizeIntergerV2(String startTime, String endTime) {
		Map<String, BigDecimal> prizeIntergerCount = summerSpecialDao.getPrizeIntergerCount(startTime, endTime, "1" );
		Map<String, BigDecimal> prizeIntergerHundredCount = summerSpecialDao.getPrizeIntergerCount(startTime, endTime, "2");
		Map<String, BigDecimal> prizeIntergerTwoHundredCount = summerSpecialDao.getPrizeIntergerCount(startTime, endTime, "3");
		Map<String, BigDecimal> prizeIntergerFiveHundredCount = summerSpecialDao.getPrizeIntergerCount(startTime, endTime, "4");

		Map<String,BigDecimal> finalMap = new HashMap<String, BigDecimal>();
		finalMap.put("thirtyCount", prizeIntergerCount.get("COUNT"));
		finalMap.put("hundredCount", prizeIntergerHundredCount.get("COUNT"));
		finalMap.put("twoHundredCount", prizeIntergerTwoHundredCount.get("COUNT"));
		finalMap.put("FiveHundredCount", prizeIntergerFiveHundredCount.get("COUNT"));

		finalMap.put("thirtyCountTimes", prizeIntergerCount.get("COUNTTIMES"));
		finalMap.put("hundredCountTimes", prizeIntergerHundredCount.get("COUNTTIMES"));
		finalMap.put("twoHundredCountTimes", prizeIntergerTwoHundredCount.get("COUNTTIMES"));
		finalMap.put("FiveHundredCountTimes", prizeIntergerFiveHundredCount.get("COUNTTIMES"));

		finalMap.put("thirtyCountNumber", prizeIntergerCount.get("COUNTNUMBER"));
		finalMap.put("hundredCountNumber", prizeIntergerHundredCount.get("COUNTNUMBER"));
		finalMap.put("twoHundredCountNumber", prizeIntergerTwoHundredCount.get("COUNTNUMBER"));
		finalMap.put("FiveHundredCountNumber", prizeIntergerFiveHundredCount.get("COUNTNUMBER"));
		return finalMap;
	}


	@Override
	public Map<String, BigDecimal> getOtherCount(String startTime, String endTime, String activityId) {
		Map<String, BigDecimal> weileCount = summerSpecialDao.getOtherCount(startTime, endTime, 2, 1);
		Map<String, BigDecimal> summerCount = summerSpecialDao.getOtherCount(startTime, endTime, 3, 1);
		Map<String, BigDecimal> iPadCount = summerSpecialDao.getOtherCount(startTime, endTime, 4, 1);
		
		Map<String,BigDecimal> finalMap = new HashMap<String, BigDecimal>();
		finalMap.put("weileCount", weileCount.get("COUNT"));
		finalMap.put("summerCount", summerCount.get("COUNT"));
		finalMap.put("iPadCount", iPadCount.get("COUNT"));
		
		finalMap.put("weileCountTimes", weileCount.get("COUNTTIMES"));
		finalMap.put("summerCountTimes", summerCount.get("COUNTTIMES"));
		finalMap.put("iPadCountTimes", iPadCount.get("COUNTTIMES"));
		
		finalMap.put("weileCountNumber", weileCount.get("COUNTNUMBER"));
		finalMap.put("summerCountNumber", summerCount.get("COUNTNUMBER"));
		finalMap.put("iPadCountNumber", iPadCount.get("COUNTNUMBER"));
		return finalMap;
	}

	/**
	 * 优惠券
	 */
	@Override
	public Map<String, BigDecimal> getCoupon(String startTime, String endTime) {
		//优惠券发放数量，发放人数
		Map<String, BigDecimal> getCouponCount = summerSpecialDao.getCouponCount(startTime, endTime, 0);
		//优惠券使用数量，使用人数
		Map<String, BigDecimal> getCouponUseCount = summerSpecialDao.getCouponCount(startTime, endTime, 2);
		//优惠券过期数量，过期人数
		Map<String, BigDecimal> getCouponPastCount = summerSpecialDao.getCouponCount(startTime,endTime,3);
		
		Map<String,BigDecimal> finalMap = new HashMap<String, BigDecimal>();
		//发放数量，人数
		finalMap.put("couponGrantCounts", getCouponCount.get("COUPONCOUNTS"));
		finalMap.put("couponGrantUserCounts", getCouponCount.get("COUPONUSERCOUNTS"));
		//使用数量，人数
		finalMap.put("couponUseCounts", getCouponUseCount.get("COUPONCOUNTS"));
		finalMap.put("couponUseUserCounts", getCouponUseCount.get("COUPONUSERCOUNTS"));
		//过期数量，人数
		finalMap.put("couponPastCounts", getCouponPastCount.get("COUPONCOUNTS"));
		finalMap.put("couponPastUserCounts", getCouponPastCount.get("COUPONUSERCOUNTS"));
		
		return finalMap;
	}


	/**
	 * 优惠券 双旦
	 */
	@Override
	public Map<String, BigDecimal> getCouponV2(String startTime, String endTime) {
		//('vvv3137af2a349d38833b6468785yuan','vvv3137af2a349d38833b6468720yuan','vvv3137af2a349d38833b6468750yuan')
		//优惠券发放数量，发放人数
		Map<String, BigDecimal> getCouponCount = summerSpecialDao.getCouponCountV2(startTime, endTime, 0,null);
		Map<String, BigDecimal> getCouponFiveCount = summerSpecialDao.getCouponCountV2(startTime, endTime, 0,"vvv3137af2a349d38833b6468785yuan");
		Map<String, BigDecimal> getCouponTwentyCount = summerSpecialDao.getCouponCountV2(startTime, endTime, 0,"vvv3137af2a349d38833b6468720yuan");
		Map<String, BigDecimal> getCouponFiftyCount = summerSpecialDao.getCouponCountV2(startTime, endTime, 0,"vvv3137af2a349d38833b6468750yuan");

		//优惠券使用数量，使用人数
		Map<String, BigDecimal> getCouponUseCount = summerSpecialDao.getCouponCountV2(startTime, endTime, 2,null);
		Map<String, BigDecimal> getCouponUseFiveCount = summerSpecialDao.getCouponCountV2(startTime, endTime, 2,"vvv3137af2a349d38833b6468785yuan");
		Map<String, BigDecimal> getCouponUseTwentyCount = summerSpecialDao.getCouponCountV2(startTime, endTime, 2,"vvv3137af2a349d38833b6468720yuan");
		Map<String, BigDecimal> getCouponUseFiftyCount = summerSpecialDao.getCouponCountV2(startTime, endTime, 2,"vvv3137af2a349d38833b6468750yuan");


		//优惠券过期数量，过期人数
		Map<String, BigDecimal> getCouponPastCount = summerSpecialDao.getCouponCountV2(startTime,endTime,3,null);
		Map<String, BigDecimal> getCouponPastFiveCount = summerSpecialDao.getCouponCountV2(startTime,endTime,3,"vvv3137af2a349d38833b6468785yuan");
		Map<String, BigDecimal> getCouponPastTwentyCount = summerSpecialDao.getCouponCountV2(startTime,endTime,3,"vvv3137af2a349d38833b6468720yuan");
		Map<String, BigDecimal> getCouponPastFiftyCount = summerSpecialDao.getCouponCountV2(startTime,endTime,3,"vvv3137af2a349d38833b6468750yuan");

		//优惠券订单总金额
		Map<String,BigDecimal> getOrderCouponPastPrice=summerSpecialDao.getOrderCouponPastPrice(startTime, endTime,null);
		Map<String,BigDecimal> getOrderCouponPastFivePrice=summerSpecialDao.getOrderCouponPastPrice(startTime, endTime,"vvv3137af2a349d38833b6468785yuan");
		Map<String,BigDecimal> getOrderCouponPastTwentyPrice=summerSpecialDao.getOrderCouponPastPrice(startTime, endTime,"vvv3137af2a349d38833b6468720yuan");
		Map<String,BigDecimal> getOrderCouponPastFiftyPrice=summerSpecialDao.getOrderCouponPastPrice(startTime, endTime,"vvv3137af2a349d38833b6468750yuan");


		Map<String,BigDecimal> finalMap = new HashMap<String, BigDecimal>();
		//发放数量，人数
		finalMap.put("couponGrantCounts", getCouponCount.get("COUPONCOUNTS"));
		finalMap.put("getCouponFiveCount",getCouponFiveCount.get("COUPONCOUNTS"));
		finalMap.put("getCouponTwentyCount",getCouponTwentyCount.get("COUPONCOUNTS"));
		finalMap.put("getCouponFiftyCount",getCouponFiftyCount.get("COUPONCOUNTS"));
		finalMap.put("couponGrantUserCounts", getCouponCount.get("COUPONUSERCOUNTS"));
		finalMap.put("couponGrantUserFiveCounts", getCouponFiveCount.get("COUPONUSERCOUNTS"));
		finalMap.put("couponGrantUserTwentyCounts", getCouponTwentyCount.get("COUPONUSERCOUNTS"));
		finalMap.put("couponGrantUserFiftyCounts", getCouponFiftyCount.get("COUPONUSERCOUNTS"));

		//使用数量，人数
		finalMap.put("couponUseCounts", getCouponUseCount.get("COUPONCOUNTS"));
		finalMap.put("getCouponUseFiveCount", getCouponUseFiveCount.get("COUPONCOUNTS"));
		finalMap.put("getCouponUseTwentyCount", getCouponUseTwentyCount.get("COUPONCOUNTS"));
		finalMap.put("getCouponUseFiftyCount", getCouponUseFiftyCount.get("COUPONCOUNTS"));

		finalMap.put("couponUseUserCounts", getCouponUseCount.get("COUPONUSERCOUNTS"));
		finalMap.put("couponUseUserFiveCounts", getCouponUseFiveCount.get("COUPONUSERCOUNTS"));
		finalMap.put("couponUseUserTwentyCounts", getCouponUseTwentyCount.get("COUPONUSERCOUNTS"));
		finalMap.put("couponUseUseFiftyCounts", getCouponUseFiftyCount.get("COUPONUSERCOUNTS"));

		//过期数量，人数
		finalMap.put("couponPastCounts", getCouponPastCount.get("COUPONCOUNTS"));
		finalMap.put("getCouponPastFiveCount", getCouponPastFiveCount.get("COUPONCOUNTS"));
		finalMap.put("getCouponPastTwentyCount", getCouponPastTwentyCount.get("COUPONCOUNTS"));
		finalMap.put("getCouponPastFiftyCount", getCouponPastFiftyCount.get("COUPONCOUNTS"));

		finalMap.put("couponPastUserCounts", getCouponPastCount.get("COUPONUSERCOUNTS"));
		finalMap.put("couponPastUserFiveCounts", getCouponPastFiveCount.get("COUPONUSERCOUNTS"));
		finalMap.put("couponPastUserTwentyCounts", getCouponPastTwentyCount.get("COUPONUSERCOUNTS"));
		finalMap.put("couponPastUserFiftyCounts", getCouponPastFiftyCount.get("COUPONUSERCOUNTS"));

		finalMap.put("orderCouponPastPrice",getOrderCouponPastPrice.get("PRICE"));
		finalMap.put("getOrderCouponPastFivePrice",getOrderCouponPastFivePrice.get("PRICE"));
		finalMap.put("getOrderCouponPastTwentyPrice",getOrderCouponPastTwentyPrice.get("PRICE"));
		finalMap.put("getOrderCouponPastFiftyPrice",getOrderCouponPastFiftyPrice.get("PRICE"));

		return finalMap;
	}
	/**
	 * 中奖详情
	 */
	@Override
	public Map<String, BigDecimal> getPrizeCount(String startTime,String endTime) {
		Map<String, BigDecimal> prizeCount2 = summerSpecialDao.getOtherCount(startTime, endTime ,2 ,2);
		Map<String, BigDecimal> prizeCount3 = summerSpecialDao.getOtherCount(startTime, endTime ,3 ,2);
		Map<String, BigDecimal> prizeCount4 = summerSpecialDao.getOtherCount(startTime, endTime ,4 ,2);
		Map<String, BigDecimal> prizeCount5 = summerSpecialDao.getOtherCount(startTime, endTime ,5 ,2);
		Map<String, BigDecimal> prizeCount6 = summerSpecialDao.getOtherCount(startTime, endTime ,6 ,2);
		Map<String, BigDecimal> prizeCount7 = summerSpecialDao.getOtherCount(startTime, endTime ,7 ,2);
		Map<String, BigDecimal> prizeCount8 = summerSpecialDao.getOtherCount(startTime, endTime ,8 ,2);
		
		Map<String,BigDecimal> finalMap = new HashMap<String, BigDecimal>();
		finalMap.put("thirtyCount", prizeCount2.get("COUNT").multiply(new BigDecimal("30")));
		finalMap.put("fiftyCount", prizeCount3.get("COUNT").multiply(new BigDecimal("50")));
		finalMap.put("hundredCount", prizeCount4.get("COUNT").multiply(new BigDecimal("100")));
		finalMap.put("twoHundredCount", prizeCount5.get("COUNT").multiply(new BigDecimal("200")));
		finalMap.put("FiveHundredCount", prizeCount6.get("COUNT").multiply(new BigDecimal("500")));
		finalMap.put("OneThousandCount", prizeCount7.get("COUNT").multiply(new BigDecimal("1000")));
		finalMap.put("summerCount", prizeCount8.get("COUNT"));
		
		finalMap.put("thirtyCountTimes", prizeCount2.get("COUNTTIMES"));
		finalMap.put("fiftyCountTimes", prizeCount3.get("COUNTTIMES"));
		finalMap.put("hundredCountTimes", prizeCount4.get("COUNTTIMES"));
		finalMap.put("twoHundredCountTimes", prizeCount5.get("COUNTTIMES"));
		finalMap.put("FiveHundredCountTimes", prizeCount6.get("COUNTTIMES"));
		finalMap.put("OneThousandCountTimes", prizeCount7.get("COUNTTIMES"));
		finalMap.put("summerCountTimes", prizeCount8.get("COUNTTIMES"));
		
		finalMap.put("thirtyCountNumber", prizeCount2.get("COUNTNUMBER"));
		finalMap.put("fiftyCountNumber", prizeCount3.get("COUNTNUMBER"));
		finalMap.put("hundredCountNumber", prizeCount4.get("COUNTNUMBER"));
		finalMap.put("twoHundredCountNumber", prizeCount5.get("COUNTNUMBER"));
		finalMap.put("FiveHundredCountNumber", prizeCount6.get("COUNTNUMBER"));
		finalMap.put("OneThousandCountNumber", prizeCount7.get("COUNTNUMBER"));
		finalMap.put("summerCountNumber", prizeCount8.get("COUNTNUMBER"));
		return finalMap;
	}

	/**
	 *
	 * v2
	 * 中奖详情
	 */
	@Override
	public Map<String, BigDecimal> getPrizeCountV2(String startTime,String endTime) {
		Map<String, BigDecimal> prizeCount1 = summerSpecialDao.getOtherCount(startTime, endTime ,1 ,4);
		Map<String, BigDecimal> prizeCount2 = summerSpecialDao.getOtherCount(startTime, endTime ,2 ,4);
		Map<String, BigDecimal> prizeCount3 = summerSpecialDao.getOtherCount(startTime, endTime ,3 ,4);
		Map<String, BigDecimal> prizeCount4 = summerSpecialDao.getOtherCount(startTime, endTime ,4 ,4);
		Map<String, BigDecimal> prizeCount5 = summerSpecialDao.getOtherCount(startTime, endTime ,5 ,4);
		Map<String, BigDecimal> prizeCount6 = summerSpecialDao.getOtherCount(startTime, endTime ,6 ,4);
		Map<String, BigDecimal> prizeCount7 = summerSpecialDao.getOtherCount(startTime, endTime ,7 ,4);
		Map<String, BigDecimal> prizeCount8 = summerSpecialDao.getOtherCount(startTime, endTime ,8 ,4);


		Map<String,BigDecimal> finalMap = new HashMap<String, BigDecimal>();

		finalMap.put("thanksCount", prizeCount1.get("COUNT"));
		finalMap.put("twentyCount", prizeCount2.get("COUNT").multiply(new BigDecimal("20")));
		finalMap.put("oneHundredCount", prizeCount3.get("COUNT").multiply(new BigDecimal("100")));
		finalMap.put("fiveHundredCount", prizeCount4.get("COUNT").multiply(new BigDecimal("500")));
		finalMap.put("fiveCount", prizeCount5.get("COUNT").multiply(new BigDecimal("5")));
		finalMap.put("twentysCount", (prizeCount6.get("COUNT").add(prizeCount7.get("COUNT"))).multiply(new BigDecimal("20")));
		finalMap.put("fiftyCount", prizeCount8.get("COUNT").multiply(new BigDecimal("50")));


		finalMap.put("thanksCountTimes", prizeCount1.get("COUNTTIMES"));
		finalMap.put("thirtyCountTimes", prizeCount2.get("COUNTTIMES"));
		finalMap.put("oneHundredCountTimes", prizeCount3.get("COUNTTIMES"));
		finalMap.put("fiveHundredCountTimes", prizeCount4.get("COUNTTIMES"));
		finalMap.put("fiveCountTimes", prizeCount5.get("COUNTTIMES"));
		finalMap.put("twentysCountTimes", prizeCount6.get("COUNTTIMES").add(prizeCount7.get("COUNTTIMES")));
		finalMap.put("fiftyCountTimes", prizeCount8.get("COUNTTIMES"));

		finalMap.put("thanksCountNumber", prizeCount1.get("COUNTNUMBER"));
		finalMap.put("thirtyCountNumber", prizeCount2.get("COUNTNUMBER"));
		finalMap.put("oneHundredCountNumber", prizeCount3.get("COUNTNUMBER"));
		finalMap.put("fiveHundredCountNumber", prizeCount4.get("COUNTNUMBER"));
		finalMap.put("fiveCountNumber", prizeCount5.get("COUNTNUMBER"));
		finalMap.put("twentysCountNumber", prizeCount6.get("COUNTNUMBER").add(prizeCount7.get("COUNTNUMBER")));
		finalMap.put("fiftyCountNumber", prizeCount8.get("COUNTNUMBER"));

		return finalMap;
	}

	public Map<String,Object>  getLuckDrawCount(String  startTime,String endTime,String activityId){
		Map<String,Object> finalMap=new HashMap<>();
		Map<String,Object> count=summerSpecialDao.getLuckDrawCount(startTime, endTime, "0");
		Map<String,Object> sum=summerSpecialDao.getIntegralSum(startTime,endTime);
		//参与数
		finalMap.put("luckDrawCounts",count.get("COUNTS"));
//		参与人数
		finalMap.put("luckDrawCountUser",count.get("COUNTUSER"));
		//消耗总积分
		finalMap.put("SCOREBOARD",new BigDecimal(0).subtract(new BigDecimal(String.valueOf(sum.get("POINT")))));
		return finalMap;
	}


	/**
	 * 优惠券 年货提前购
	 */
	@Override
	public Map<String, BigDecimal> getCouponAdvance(String startTime, String endTime) {
//		5元 t_activity_gift 主键id： vvv3137af2a349d38833b64year5yuan
//		15元 t_activity_gift 主键id： vvv3137af2a349d38833b4year15yuan
//		30元 t_activity_gift 主键id： vvv3137af2a349d38833b4year30yuan
//		50元 t_activity_gift 主键id： vvv3137af2a349d38833b4year50yuan//优惠券发放数量，发放人数
		Map<String, BigDecimal> getCouponCount = summerSpecialDao.getCouponCountAdvance(startTime, endTime, 0, null);
		Map<String, BigDecimal> getCouponCount1 = summerSpecialDao.getCouponCountAdvance(startTime, endTime, 0, "vvv3137af2a349d38833b64year5yuan");
		Map<String, BigDecimal> getCouponCount2 = summerSpecialDao.getCouponCountAdvance(startTime, endTime, 0, "vvv3137af2a349d38833b4year15yuan");
		Map<String, BigDecimal> getCouponCount3 = summerSpecialDao.getCouponCountAdvance(startTime, endTime, 0, "vvv3137af2a349d38833b4year30yuan");
		Map<String, BigDecimal> getCouponCount4 = summerSpecialDao.getCouponCountAdvance(startTime, endTime, 0, "vvv3137af2a349d38833b4year50yuan");

		Map<String,BigDecimal> finalMap = new HashMap<String, BigDecimal>();
		//许愿池消耗总积分
		Map<String, BigDecimal> getAdvanceSum = summerSpecialDao.getAdvanceSum(startTime, endTime,5,1);
		finalMap.put("SCOREBOARD",getAdvanceSum.get("SCOREBOARD"));
		//分享数据  T_USRE_GIFT_TIMES 清空表 人数不准确 没人一条记录
		Map<String, BigDecimal> shares = summerSpecialDao.getShares(startTime, endTime);
		finalMap.put("shareCount",shares.get("COUNT"));
		finalMap.put("shareDisCount",shares.get("DISCOUNT"));
		//中奖数据 优惠券 1 2 3  4 5
		Map<String, BigDecimal> prizeCount1 = summerSpecialDao.getOtherCount(startTime, endTime ,1 ,5);
		Map<String, BigDecimal> prizeCount2 = summerSpecialDao.getOtherCount(startTime, endTime ,2 ,5);
		Map<String, BigDecimal> prizeCount3 = summerSpecialDao.getOtherCount(startTime, endTime ,3 ,5);
		Map<String, BigDecimal> prizeCount4 = summerSpecialDao.getOtherCount(startTime, endTime ,4 ,5);
		Map<String, BigDecimal> prizeCount5 = summerSpecialDao.getOtherCount(startTime, endTime ,5 ,5);

		//参与数 与 人数
		//谢谢 5 15 30 50 总和
		finalMap.put("thanksCount", prizeCount1.get("COUNT"));
		finalMap.put("thanksCountNumber", prizeCount1.get("COUNTNUMBER"));

		finalMap.put("thirtyCountTimes", prizeCount2.get("COUNTTIMES"));
		finalMap.put("oneHundredCountTimes", prizeCount3.get("COUNTTIMES"));
		finalMap.put("fiveHundredCountTimes", prizeCount4.get("COUNTTIMES"));
		finalMap.put("fiveCountTimes", prizeCount5.get("COUNTTIMES"));

		finalMap.put("thirtyCountNumber", prizeCount2.get("COUNTNUMBER"));
		finalMap.put("oneHundredCountNumber", prizeCount3.get("COUNTNUMBER"));
		finalMap.put("fiveHundredCountNumber", prizeCount4.get("COUNTNUMBER"));
		finalMap.put("fiveCountNumber", prizeCount5.get("COUNTNUMBER"));

		//优惠券使用数  人数 订单积分
		//优惠券使用数量，使用人数
		Map<String, BigDecimal> getCouponUseCount = summerSpecialDao.getCouponCountAdvance(startTime, endTime, 2, "vvv3137af2a349d38833b64year5yuan");
		Map<String, BigDecimal> getCouponUseFiveCount = summerSpecialDao.getCouponCountAdvance(startTime, endTime, 2, "vvv3137af2a349d38833b4year15yuan");
		Map<String, BigDecimal> getCouponUseTwentyCount = summerSpecialDao.getCouponCountAdvance(startTime, endTime, 2, "vvv3137af2a349d38833b4year30yuan");
		Map<String, BigDecimal> getCouponUseFiftyCount = summerSpecialDao.getCouponCountAdvance(startTime, endTime, 2, "vvv3137af2a349d38833b4year50yuan");

		//优惠券订单总金额
//		Map<String,BigDecimal> getOrderCouponPastPrice=summerSpecialDao.getOrderCouponPastPriceAdvance(startTime, endTime, null);
		Map<String,BigDecimal> getOrderCouponPastFivePrice=summerSpecialDao.getOrderCouponPastPriceAdvance(startTime, endTime, "vvv3137af2a349d38833b64year5yuan");
		Map<String,BigDecimal> getOrderCouponPastTwentyPrice=summerSpecialDao.getOrderCouponPastPriceAdvance(startTime, endTime, "vvv3137af2a349d38833b4year15yuan");
		Map<String,BigDecimal> getOrderCouponPastFiftyPrice=summerSpecialDao.getOrderCouponPastPriceAdvance(startTime, endTime, "vvv3137af2a349d38833b4year30yuan");
		Map<String,BigDecimal> getOrderCouponPastFiftyPrice5=summerSpecialDao.getOrderCouponPastPriceAdvance(startTime, endTime, "vvv3137af2a349d38833b4year50yuan");

		finalMap.put("orderCouponPastPrice",getOrderCouponPastFivePrice.get("PRICE"));
		finalMap.put("getOrderCouponPastFivePrice",getOrderCouponPastTwentyPrice.get("PRICE"));
		finalMap.put("getOrderCouponPastTwentyPrice",getOrderCouponPastFiftyPrice.get("PRICE"));
		finalMap.put("getOrderCouponPastFiftyPrice",getOrderCouponPastFiftyPrice5.get("PRICE"));

		//使用数量，人数
		finalMap.put("couponUseCounts", getCouponUseCount.get("COUPONCOUNTS"));
		finalMap.put("getCouponUseFiveCount", getCouponUseFiveCount.get("COUPONCOUNTS"));
		finalMap.put("getCouponUseTwentyCount", getCouponUseTwentyCount.get("COUPONCOUNTS"));
		finalMap.put("getCouponUseFiftyCount", getCouponUseFiftyCount.get("COUPONCOUNTS"));

		finalMap.put("couponUseUserCounts", getCouponUseCount.get("COUPONUSERCOUNTS"));
		finalMap.put("couponUseUserFiveCounts", getCouponUseFiveCount.get("COUPONUSERCOUNTS"));
		finalMap.put("couponUseUserTwentyCounts", getCouponUseTwentyCount.get("COUPONUSERCOUNTS"));
		finalMap.put("couponUseUseFiftyCounts", getCouponUseFiftyCount.get("COUPONUSERCOUNTS"));

		//2018积分发放数量  lx修改为49
		Map<String, BigDecimal> getAdvanceIntegralRecord = summerSpecialDao.getAdvanceIntegralRecord(startTime, endTime, "", "49");
		finalMap.put("2018count", getAdvanceIntegralRecord.get("COUNT"));
		finalMap.put("2018DisCount", getAdvanceIntegralRecord.get("DISCOUNT"));
		//2018积分订单
		Map<String, BigDecimal> getAdvance2018Integral = summerSpecialDao.getAdvance2018Integral(startTime, endTime);
		finalMap.put("cash2018",getAdvance2018Integral.get("CASH"));
		//发放数量，人数
		finalMap.put("couponCountAdvanceCounts", getCouponCount.get("COUPONCOUNTS"));
		finalMap.put("couponAdvanceGrantUserCounts", getCouponCount.get("COUPONUSERCOUNTS"));

		finalMap.put("couponGrantAdvanceCounts", getCouponCount1.get("COUPONCOUNTS"));
		finalMap.put("getCouponFiveAdvanceCount", getCouponCount2.get("COUPONCOUNTS"));
		finalMap.put("getCouponTwentyAdvanceCount",getCouponCount3.get("COUPONCOUNTS"));
		finalMap.put("getCouponFiftyAdvanceCount",getCouponCount4.get("COUPONCOUNTS"));

		finalMap.put("couponUseUseAdvancerCounts", getCouponCount1.get("COUPONUSERCOUNTS"));
		finalMap.put("couponUseUserFiveAdvanceCounts", getCouponCount2.get("COUPONUSERCOUNTS"));
		finalMap.put("couponUseUserTwentyAdvanceCounts", getCouponCount3.get("COUPONUSERCOUNTS"));
		finalMap.put("couponUseUseFiftyAdvanceCounts", getCouponCount4.get("COUPONUSERCOUNTS"));

		return finalMap;
	}


	public Map<String,BigDecimal>  newSpringGetCollarRed(String  startTime,String endTime,String activityId){


		Map<String,BigDecimal> finalMap = new HashMap<String, BigDecimal>();
		//优惠券发放数量
		Map<String, BigDecimal> getCouponCount = summerSpecialDao.getCouponGetCollarRed(startTime, endTime, 0, null);
		Map<String, BigDecimal> getCouponCount1 = summerSpecialDao.getCouponGetCollarRed(startTime, endTime, 0, "vvv3137a201849d38833b6468785yuan");
		Map<String, BigDecimal> getCouponCount2 = summerSpecialDao.getCouponGetCollarRed(startTime, endTime, 0, "vvv3137a201849d38833b6468715yuan");
		Map<String, BigDecimal> getCouponCount3 = summerSpecialDao.getCouponGetCollarRed(startTime, endTime, 0, "vvv3137a201849d38833b6468720yuan");
		Map<String, BigDecimal> getCouponCount4 = summerSpecialDao.getCouponGetCollarRed(startTime, endTime, 0, "vvv3137a201849d38833b6468750yuan");


		//发放数量，人数
		finalMap.put("couponCountAdvanceCounts", getCouponCount.get("COUPONCOUNTS"));
		finalMap.put("couponAdvanceGrantUserCounts", getCouponCount.get("COUPONUSERCOUNTS"));


		finalMap.put("getCouponFiveAdvanceCount", getCouponCount1.get("COUPONCOUNTS"));
		finalMap.put("couponGrantFifteenAdvanceCounts", getCouponCount2.get("COUPONCOUNTS"));
		finalMap.put("getCouponTwentyAdvanceCount",getCouponCount3.get("COUPONCOUNTS"));
		finalMap.put("getCouponFiftyAdvanceCount",getCouponCount4.get("COUPONCOUNTS"));


		finalMap.put("couponUseUserFiveAdvanceCounts", getCouponCount1.get("COUPONUSERCOUNTS"));
		finalMap.put("couponUseUseFifteenAdvancerCounts", getCouponCount2.get("COUPONUSERCOUNTS"));
		finalMap.put("couponUseUserTwentyAdvanceCounts", getCouponCount3.get("COUPONUSERCOUNTS"));
		finalMap.put("couponUseUseFiftyAdvanceCounts", getCouponCount4.get("COUPONUSERCOUNTS"));


		//优惠券使用数量，使用人数
		Map<String, BigDecimal> getCoupon = summerSpecialDao.getCouponGetCollarRed(startTime, endTime, 2, null);
		Map<String, BigDecimal> getCouponUseFiveCount = summerSpecialDao.getCouponGetCollarRed(startTime, endTime, 2, "vvv3137a201849d38833b6468785yuan");
		Map<String, BigDecimal> getCouponUseFifteenCount = summerSpecialDao.getCouponGetCollarRed(startTime, endTime, 2, "vvv3137a201849d38833b6468715yuan");
		Map<String, BigDecimal> getCouponUseTwentyCount = summerSpecialDao.getCouponGetCollarRed(startTime, endTime, 2, "vvv3137a201849d38833b6468720yuan");
		Map<String, BigDecimal> getCouponUseFiftyCount = summerSpecialDao.getCouponGetCollarRed(startTime, endTime, 2, "vvv3137a201849d38833b6468750yuan");


		//使用数量，人数
		finalMap.put("couponUseCounts", getCoupon.get("COUPONCOUNTS"));
		finalMap.put("getCouponUseFiveCount", getCouponUseFiveCount.get("COUPONCOUNTS"));
		finalMap.put("getCouponUseFifteenCount",getCouponUseFifteenCount.get("COUPONCOUNTS"));
		finalMap.put("getCouponUseTwentyCount", getCouponUseTwentyCount.get("COUPONCOUNTS"));
		finalMap.put("getCouponUseFiftyCount", getCouponUseFiftyCount.get("COUPONCOUNTS"));

		finalMap.put("couponUseUserCounts", getCoupon.get("COUPONUSERCOUNTS"));
		finalMap.put("couponUseUserFiveCounts", getCouponUseFiveCount.get("COUPONUSERCOUNTS"));
		finalMap.put("couponUseUserFifteenCounts", getCouponUseFifteenCount.get("COUPONUSERCOUNTS"));
		finalMap.put("couponUseUserTwentyCounts", getCouponUseTwentyCount.get("COUPONUSERCOUNTS"));
		finalMap.put("couponUseUseFiftyCounts", getCouponUseFiftyCount.get("COUPONUSERCOUNTS"));

//优惠券订单总金额
		Map<String,BigDecimal> getOrderCouponPastPrice=summerSpecialDao.getOrderCouponPastPriceAdvanceByGetCollarRed(startTime, endTime, null);
		Map<String,BigDecimal> getOrderCouponPastFivePrice=summerSpecialDao.getOrderCouponPastPriceAdvanceByGetCollarRed(startTime, endTime, "vvv3137a201849d38833b6468785yuan");
		Map<String,BigDecimal> getOrderCouponPastTwentyPrice=summerSpecialDao.getOrderCouponPastPriceAdvanceByGetCollarRed(startTime, endTime, "vvv3137a201849d38833b6468715yuan");
		Map<String,BigDecimal> getOrderCouponPastFiftyPrice=summerSpecialDao.getOrderCouponPastPriceAdvanceByGetCollarRed(startTime, endTime, "vvv3137a201849d38833b6468720yuan");
		Map<String,BigDecimal> getOrderCouponPastFiftyPrice5=summerSpecialDao.getOrderCouponPastPriceAdvanceByGetCollarRed(startTime, endTime, "vvv3137a201849d38833b6468750yuan");

		finalMap.put("getOrderCouponPastPrice",getOrderCouponPastPrice.get("PRICE"));
		finalMap.put("orderCouponPastFivePrice",getOrderCouponPastFivePrice.get("PRICE"));
		finalMap.put("getOrderCouponPastFifteenPrice",getOrderCouponPastTwentyPrice.get("PRICE"));
		finalMap.put("getOrderCouponPastTwentyPrice",getOrderCouponPastFiftyPrice.get("PRICE"));
		finalMap.put("getOrderCouponPastFiftyPrice",getOrderCouponPastFiftyPrice5.get("PRICE"));


		//优惠券过期数量，过期人数
		Map<String, BigDecimal> getCouponPast = summerSpecialDao.getCouponGetCollarRed(startTime, endTime, 3, null);
		Map<String, BigDecimal> getCouponPastFiveCount = summerSpecialDao.getCouponGetCollarRed(startTime, endTime, 3, "vvv3137a201849d38833b6468785yuan");
		Map<String, BigDecimal> getCouponPastFifteenCount = summerSpecialDao.getCouponGetCollarRed(startTime, endTime, 3, "vvv3137a201849d38833b6468715yuan");
		Map<String, BigDecimal> getCouponPastTwentyCount = summerSpecialDao.getCouponGetCollarRed(startTime, endTime, 3, "vvv3137a201849d38833b6468720yuan");
		Map<String, BigDecimal> getCouponPastFiftyCount = summerSpecialDao.getCouponGetCollarRed(startTime, endTime, 3, "vvv3137a201849d38833b6468750yuan");


		//过期数量，人数
		finalMap.put("getCouponPast",getCouponPast.get("COUPONCOUNTS"));
		finalMap.put("getCouponPastFiveCount", getCouponPastFiveCount.get("COUPONCOUNTS"));
		finalMap.put("couponPastFifteenCounts", getCouponPastFifteenCount.get("COUPONCOUNTS"));
		finalMap.put("getCouponPastTwentyCount", getCouponPastTwentyCount.get("COUPONCOUNTS"));
		finalMap.put("getCouponPastFiftyCount", getCouponPastFiftyCount.get("COUPONCOUNTS"));

		finalMap.put("couponPastUser",getCouponPast.get("COUPONUSERCOUNTS"));
		finalMap.put("couponPastUserFiveCounts", getCouponPastFiveCount.get("COUPONUSERCOUNTS"));
		finalMap.put("couponPastUserFifteenCounts", getCouponPastFifteenCount.get("COUPONUSERCOUNTS"));
		finalMap.put("couponPastUserTwentyCounts", getCouponPastTwentyCount.get("COUPONUSERCOUNTS"));
		finalMap.put("couponPastUserFiftyCounts", getCouponPastFiftyCount.get("COUPONUSERCOUNTS"));


//中奖数据详细
		Map<String, BigDecimal> prizeCount1 = summerSpecialDao.getOtherCount(startTime, endTime ,1 ,6);
		Map<String, BigDecimal> prizeCount2 = summerSpecialDao.getOtherCount(startTime, endTime ,2 ,6);
		Map<String, BigDecimal> prizeCount3 = summerSpecialDao.getOtherCount(startTime, endTime ,3 ,6);
		Map<String, BigDecimal> prizeCount4 = summerSpecialDao.getOtherCount(startTime, endTime ,4 ,6);
		Map<String, BigDecimal> prizeCount5 = summerSpecialDao.getOtherCount(startTime, endTime ,5 ,6);
		Map<String, BigDecimal> prizeCount6 = summerSpecialDao.getOtherCount(startTime, endTime ,6 ,6);
		Map<String, BigDecimal> prizeCount7 = summerSpecialDao.getOtherCount(startTime, endTime, 7, 6);


		finalMap.put("thanksCountTimes", prizeCount1.get("COUNTTIMES"));
		finalMap.put("thirtyCountTimes", prizeCount2.get("COUNTTIMES"));
		finalMap.put("fiftyCountTimes", prizeCount3.get("COUNTTIMES"));
		finalMap.put("oneHundredCountTimes", prizeCount4.get("COUNTTIMES"));
		finalMap.put("fiveHundredCountTimes", prizeCount5.get("COUNTTIMES"));
		finalMap.put("oneThousandCountTimes", prizeCount6.get("COUNTTIMES"));
		finalMap.put("2018CountTimes", prizeCount7.get("COUNTTIMES"));


		finalMap.put("thanksCountNumber", prizeCount1.get("COUNTNUMBER"));
		finalMap.put("thirtyCountNumber", prizeCount2.get("COUNTNUMBER"));
		finalMap.put("fiftyCountNumber", prizeCount3.get("COUNTTIMES"));
		finalMap.put("oneHundredCountNumber", prizeCount4.get("COUNTNUMBER"));
		finalMap.put("fiveHundredCountNumber", prizeCount5.get("COUNTNUMBER"));
		finalMap.put("oneThousandCountNumber", prizeCount6.get("COUNTNUMBER"));
		finalMap.put("2018CountNumber", prizeCount7.get("COUNTNUMBER"));


		//中奖数据=中奖积分数据+福利券数据
		BigDecimal winningData=prizeCount2.get("COUNTTIMES").add(prizeCount3.get("COUNTTIMES")).add(prizeCount4.get("COUNTTIMES")).add(prizeCount5.get("COUNTTIMES")).add(prizeCount6.get("COUNTTIMES")).add(getCouponCount.get("COUPONCOUNTS"));
		finalMap.put("winningData",winningData);
		BigDecimal disWinningData=prizeCount2.get("COUNTNUMBER").add(prizeCount3.get("COUNTNUMBER")).add(prizeCount4.get("COUNTNUMBER")).add(prizeCount5.get("COUNTNUMBER")).add(prizeCount6.get("COUNTNUMBER")).add(getCouponCount.get("COUPONUSERCOUNTS"));
		finalMap.put("disWinningData",disWinningData);
		//抽奖数据=谢谢+中奖积分数据+福利券数据
		BigDecimal luckDraw=prizeCount1.get("COUNTTIMES").add(winningData);
		finalMap.put("luckDraw",luckDraw);
		BigDecimal disLuckDraw=prizeCount1.get("COUNTNUMBER").add(disWinningData);
		finalMap.put("disLuckDraw",disLuckDraw);
		//参与数据=抽奖数据+未抽奖数据
		Map<String,BigDecimal> playGames=summerSpecialDao.getPlayGamesTotal("ZHB20180212001",startTime, endTime);
		finalMap.put("participateInData",playGames.get("COUNT"));
		finalMap.put("disParticipateInData",playGames.get("DISCOU"));

		return finalMap;
	}



	public Map<String,BigDecimal>  query315miniHouseEleAppliances(String  startTime,String endTime,String activityId){

		Map<String,BigDecimal> finalMap = new HashMap<String, BigDecimal>();
		//优惠券发放数量
		Map<String, BigDecimal> getCouponCount = summerSpecialDao.getCouponGetCollar315mini(startTime, endTime, 0, null);
		Map<String, BigDecimal> getCouponCount1 = summerSpecialDao.getCouponGetCollar315mini(startTime, endTime, 0, "vvv3137a231549d38833b6468710yuan");
		Map<String, BigDecimal> getCouponCount2 = summerSpecialDao.getCouponGetCollar315mini(startTime, endTime, 0, "vvv3137a231549d38833b6468778yuan");
		Map<String, BigDecimal> getCouponCount3 = summerSpecialDao.getCouponGetCollar315mini(startTime, endTime, 0, "vvv3137a231549d38833b6468725yuan");
		Map<String, BigDecimal> getCouponCount4 = summerSpecialDao.getCouponGetCollar315mini(startTime, endTime, 0, "vvv3137a231549d38833b6468745yuan");


		//发放数量，人数
		finalMap.put("couponCountAdvanceCounts", getCouponCount.get("COUPONCOUNTS"));
		finalMap.put("couponAdvanceGrantUserCounts", getCouponCount.get("COUPONUSERCOUNTS"));


		finalMap.put("getCouponFiveAdvanceCount", getCouponCount1.get("COUPONCOUNTS"));
		finalMap.put("couponGrantFifteenAdvanceCounts", getCouponCount2.get("COUPONCOUNTS"));
		finalMap.put("getCouponTwentyAdvanceCount",getCouponCount3.get("COUPONCOUNTS"));
		finalMap.put("getCouponFiftyAdvanceCount",getCouponCount4.get("COUPONCOUNTS"));


		finalMap.put("couponUseUserFiveAdvanceCounts", getCouponCount1.get("COUPONUSERCOUNTS"));
		finalMap.put("couponUseUseFifteenAdvancerCounts", getCouponCount2.get("COUPONUSERCOUNTS"));
		finalMap.put("couponUseUserTwentyAdvanceCounts", getCouponCount3.get("COUPONUSERCOUNTS"));
		finalMap.put("couponUseUseFiftyAdvanceCounts", getCouponCount4.get("COUPONUSERCOUNTS"));



		//优惠券使用数量，使用人数
		Map<String, BigDecimal> getCoupon = summerSpecialDao.getCouponGetCollar315mini(startTime, endTime, 2, null);
		Map<String, BigDecimal> getCouponUseFiveCount = summerSpecialDao.getCouponGetCollar315mini(startTime, endTime, 2, "vvv3137a231549d38833b6468710yuan");
		Map<String, BigDecimal> getCouponUseFifteenCount = summerSpecialDao.getCouponGetCollar315mini(startTime, endTime, 2, "vvv3137a231549d38833b6468778yuan");
		Map<String, BigDecimal> getCouponUseTwentyCount = summerSpecialDao.getCouponGetCollar315mini(startTime, endTime, 2, "vvv3137a231549d38833b6468725yuan");
		Map<String, BigDecimal> getCouponUseFiftyCount = summerSpecialDao.getCouponGetCollar315mini(startTime, endTime, 2, "vvv3137a231549d38833b6468745yuan");


		//使用数量，人数
		finalMap.put("couponUseCounts", getCoupon.get("COUPONCOUNTS"));
		finalMap.put("getCouponUseFiveCount", getCouponUseFiveCount.get("COUPONCOUNTS"));
		finalMap.put("getCouponUseFifteenCount",getCouponUseFifteenCount.get("COUPONCOUNTS"));
		finalMap.put("getCouponUseTwentyCount", getCouponUseTwentyCount.get("COUPONCOUNTS"));
		finalMap.put("getCouponUseFiftyCount", getCouponUseFiftyCount.get("COUPONCOUNTS"));

		finalMap.put("couponUseUserCounts", getCoupon.get("COUPONUSERCOUNTS"));
		finalMap.put("couponUseUserFiveCounts", getCouponUseFiveCount.get("COUPONUSERCOUNTS"));
		finalMap.put("couponUseUserFifteenCounts", getCouponUseFifteenCount.get("COUPONUSERCOUNTS"));
		finalMap.put("couponUseUserTwentyCounts", getCouponUseTwentyCount.get("COUPONUSERCOUNTS"));
		finalMap.put("couponUseUseFiftyCounts", getCouponUseFiftyCount.get("COUPONUSERCOUNTS"));

//优惠券订单总金额
		Map<String,BigDecimal> getOrderCouponPastPrice=summerSpecialDao.getOrderCouponPastPriceAdvanceByGet315mini(startTime, endTime, null);
		Map<String,BigDecimal> getOrderCouponPastFivePrice=summerSpecialDao.getOrderCouponPastPriceAdvanceByGet315mini(startTime, endTime, "vvv3137a231549d38833b6468710yuan");
		Map<String,BigDecimal> getOrderCouponPastTwentyPrice=summerSpecialDao.getOrderCouponPastPriceAdvanceByGet315mini(startTime, endTime, "vvv3137a231549d38833b6468778yuan");
		Map<String,BigDecimal> getOrderCouponPastFiftyPrice=summerSpecialDao.getOrderCouponPastPriceAdvanceByGet315mini(startTime, endTime, "vvv3137a231549d38833b6468725yuan");
		Map<String,BigDecimal> getOrderCouponPastFiftyPrice5=summerSpecialDao.getOrderCouponPastPriceAdvanceByGet315mini(startTime, endTime, "vvv3137a231549d38833b6468745yuan");

		finalMap.put("getOrderCouponPastPrice",getOrderCouponPastPrice.get("PRICE"));
		finalMap.put("orderCouponPastFivePrice",getOrderCouponPastFivePrice.get("PRICE"));
		finalMap.put("getOrderCouponPastFifteenPrice",getOrderCouponPastTwentyPrice.get("PRICE"));
		finalMap.put("getOrderCouponPastTwentyPrice",getOrderCouponPastFiftyPrice.get("PRICE"));
		finalMap.put("getOrderCouponPastFiftyPrice",getOrderCouponPastFiftyPrice5.get("PRICE"));


		//优惠券过期数量，过期人数
		Map<String, BigDecimal> getCouponPast = summerSpecialDao.getCouponGetCollar315mini(startTime, endTime, 3, null);
		Map<String, BigDecimal> getCouponPastFiveCount = summerSpecialDao.getCouponGetCollar315mini(startTime, endTime, 3, "vvv3137a231549d38833b6468710yuan");
		Map<String, BigDecimal> getCouponPastFifteenCount = summerSpecialDao.getCouponGetCollar315mini(startTime, endTime, 3, "vvv3137a231549d38833b6468778yuan");
		Map<String, BigDecimal> getCouponPastTwentyCount = summerSpecialDao.getCouponGetCollar315mini(startTime, endTime, 3, "vvv3137a231549d38833b6468725yuan");
		Map<String, BigDecimal> getCouponPastFiftyCount = summerSpecialDao.getCouponGetCollar315mini(startTime, endTime, 3, "vvv3137a231549d38833b6468745yuan");


		//过期数量，人数
		finalMap.put("getCouponPast",getCouponPast.get("COUPONCOUNTS"));
		finalMap.put("getCouponPastFiveCount", getCouponPastFiveCount.get("COUPONCOUNTS"));
		finalMap.put("couponPastFifteenCounts", getCouponPastFifteenCount.get("COUPONCOUNTS"));
		finalMap.put("getCouponPastTwentyCount", getCouponPastTwentyCount.get("COUPONCOUNTS"));
		finalMap.put("getCouponPastFiftyCount", getCouponPastFiftyCount.get("COUPONCOUNTS"));

		finalMap.put("couponPastUser",getCouponPast.get("COUPONUSERCOUNTS"));
		finalMap.put("couponPastUserFiveCounts", getCouponPastFiveCount.get("COUPONUSERCOUNTS"));
		finalMap.put("couponPastUserFifteenCounts", getCouponPastFifteenCount.get("COUPONUSERCOUNTS"));
		finalMap.put("couponPastUserTwentyCounts", getCouponPastTwentyCount.get("COUPONUSERCOUNTS"));
		finalMap.put("couponPastUserFiftyCounts", getCouponPastFiftyCount.get("COUPONUSERCOUNTS"));


		return finalMap;
	}
}
