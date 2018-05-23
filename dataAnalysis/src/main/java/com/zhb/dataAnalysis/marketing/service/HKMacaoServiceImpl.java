package com.zhb.dataAnalysis.marketing.service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import com.zhb.dataAnalysis.common.repository.database.marketing.HKMacaoDao;
import com.zhb.dataAnalysis.common.repository.database.model.ActivityModel;
import com.zhb.dataAnalysis.marketing.api.HKMacaoService;

@Service("hKMacalService")
public class HKMacaoServiceImpl implements HKMacaoService{
	
	@Resource(name="hKMacaoDao")
	private HKMacaoDao hKMacaoDao;
	
	@Resource(name="taskExecutor")
	private ThreadPoolTaskExecutor taskExecutor;

	@Override
	public Map<String, Object> getActivity(int rows, int page) {
		Map<String,Object> map = new HashMap<String, Object>();
		List<ActivityModel> activityList = hKMacaoDao.getActivityList();
		String startTime = "";
		String endTime = "";
		int status = 0;
		for (ActivityModel activityModel : activityList) {
			if (activityModel.getActivityId().equals("ZHB20170402001")) {
				startTime = activityModel.getStartTime();
				endTime = activityModel.getEndTime();
				status = activityModel.getStatus();
			}else if(activityModel.getActivityId().equals("ZHB20170001016")){
				activityModel.setActivityName("老用户邀请新用户活动");
			}
		}
		ActivityModel am = new ActivityModel();
		am.setActivityId("ZHB20170402001-2");
		am.setActivityName("万事利丝绸活动-杭州三绝");
		am.setEndTime(endTime);
		am.setStartTime(startTime);
		am.setStatus(status);		
		activityList.add(am);
		Collections.sort(activityList);
		if(activityList != null && activityList.size() > 0 ) {
			if(rows > 0 && page > 0){
				int lastIndex = rows*page;
				int index = (page-1)*rows;
				int size = activityList.size();
				if (lastIndex <= size) {
					activityList = activityList.subList(index, lastIndex);
				} else {
					activityList = activityList.subList(index, size);
				}
			}
		}
		int count = hKMacaoDao.getCount();
		map.put("rows", activityList);
		map.put("total", count + 1);
		return map;
	}

	@Override
	public ActivityModel getActivityInfo(String id) {
		ActivityModel info = hKMacaoDao.getActivityInfo(id);
		return info;
	}
	
	class SaleTask implements Callable<Map<String, Object>>{
		private String startTime; 
		private String endTime; 
		private String orderSource;
		private String methodStr;
		private final CountDownLatch controller;
		
		public SaleTask(String startTime, String endTime, String orderSource, String methodStr,CountDownLatch controller){
			this.startTime = startTime;
			this.endTime = endTime;
			this.orderSource = orderSource;
			this.methodStr = methodStr;
			this.controller = controller; 
		}
		
		@Override
		public Map<String, Object> call() throws Exception {
			Map<String, Object> result = null;
			if(methodStr.equals("getTravelSales")){
				result = hKMacaoDao.getTravelSales(startTime, endTime, orderSource);
			}else if(methodStr.equals("getTravelSaleSPUCount")){
				result = hKMacaoDao.getTravelSaleSPUCount(startTime, endTime, orderSource);
			}else if(methodStr.equals("getTravelProductCount")){
				result = hKMacaoDao.getTravelProductCount(startTime, endTime, orderSource);
			}else if(methodStr.equals("getTravelSalesCash")){
				result = hKMacaoDao.getTravelSalesCash(startTime, endTime, orderSource);
			}else if(methodStr.equals("getTravelSaleSPUCash")){
				result = hKMacaoDao.getTravelSaleSPUCash(startTime, endTime, orderSource);
			}else if(methodStr.equals("getTravelSaleCash")){
				result = hKMacaoDao.getTravelSaleCash(startTime, endTime, orderSource);
			}else if(methodStr.equals("getTravelOrderMainCount")){
				result = hKMacaoDao.getTravelOrderMainCount(startTime, endTime, orderSource);
			}else if(methodStr.equals("getTravelOrderCount")){
				result = hKMacaoDao.getTravelOrderCount(startTime, endTime, orderSource);
			}else if(methodStr.equals("getTravelOrderMainCash")){
				result = hKMacaoDao.getTravelOrderMainCash(startTime, endTime, orderSource);
			}else if(methodStr.equals("getTravelOrderCash")){
				result = hKMacaoDao.getTravelOrderCash(startTime, endTime, orderSource);
			}else if(methodStr.equals("getTravelUserCount")){
				result = hKMacaoDao.getTravelUserCount(startTime, endTime, orderSource);
			}else if(methodStr.equals("getTravelRepeUserCount")){
				result = hKMacaoDao.getTravelRepeUserCount(startTime, endTime, orderSource);
			}else if(methodStr.equals("getTravelNewUserCount")){
				result = hKMacaoDao.getTravelNewUserCount(startTime, endTime);
			}else if(methodStr.equals("getPayTotal")){
				result = hKMacaoDao.getPayTotal(startTime, endTime, orderSource);
			}else if(methodStr.equals("getBuyCardPayTotal")){
				result = hKMacaoDao.getBuyCardPayTotal(startTime, endTime, orderSource);
			}else if(methodStr.equals("getActualPayTotalPoint")){
				result = hKMacaoDao.getActualPayTotalPoint(startTime, endTime, orderSource);
			}else if(methodStr.equals("getBuyCardPayTotalPoint")){
				result = hKMacaoDao.getBuyCardPayTotalPoint(startTime, endTime, orderSource);
			}
			controller.countDown();
			return result;
		}
	}	
	
	@Override
	public Map<String, Double> getHKMacaoData(String startTime, String endTime, String activityId) {		
		CountDownLatch controller = new CountDownLatch(65);		
		//销售额
		Future<Map<String, Object>> travelSales = taskExecutor.submit(new SaleTask(startTime,endTime,null,"getTravelSales",controller));
		Future<Map<String, Object>> travelSalesAPP = taskExecutor.submit(new SaleTask(startTime,endTime,"1","getTravelSales",controller));
		Future<Map<String, Object>> travelSalesMicroMall = taskExecutor.submit(new SaleTask(startTime,endTime,"2","getTravelSales",controller));
		Future<Map<String, Object>> travelSalesMicro = taskExecutor.submit(new SaleTask(startTime,endTime,"","getTravelSales",controller));

		//活动销售SPU种类总数  活动销售SKU种类总数		
		Future<Map<String,Object>> travelSaleSPUCount = taskExecutor.submit(new SaleTask(startTime, endTime, null,"getTravelSaleSPUCount",controller));
		Future<Map<String,Object>> travelSaleSPUCountAPP = taskExecutor.submit(new SaleTask(startTime, endTime, "1","getTravelSaleSPUCount",controller));
		Future<Map<String,Object>> travelSaleSPUCountMicroMall = taskExecutor.submit(new SaleTask(startTime, endTime, "2","getTravelSaleSPUCount",controller));
		Future<Map<String,Object>> travelSaleSPUCountMicro = taskExecutor.submit(new SaleTask(startTime, endTime, "","getTravelSaleSPUCount",controller));
		
		//活动商品总销量  活动期间，满99、199、299的销售子商品总销量
		Future<Map<String,Object>> travelProductCount = taskExecutor.submit(new SaleTask(startTime, endTime, null,"getTravelProductCount",controller));
		Future<Map<String,Object>> travelProductCountAPP = taskExecutor.submit(new SaleTask(startTime, endTime, "1","getTravelProductCount",controller));
		Future<Map<String,Object>> travelProductCountMicroMall = taskExecutor.submit(new SaleTask(startTime, endTime, "2","getTravelProductCount",controller));
		Future<Map<String,Object>> travelProductCountMicro = taskExecutor.submit(new SaleTask(startTime, endTime, "","getTravelProductCount",controller));
		
		//现金满额销售额   活动期间，满99、199、299且使用购卡权限的销售额（订单总额）
		Future<Map<String,Object>> travelSalesCash = taskExecutor.submit(new SaleTask(startTime, endTime, null,"getTravelSalesCash",controller));
		Future<Map<String,Object>> travelSalesCashAPP = taskExecutor.submit(new SaleTask(startTime, endTime, "1","getTravelSalesCash",controller));
		Future<Map<String,Object>> travelSalesCashMicroMall = taskExecutor.submit(new SaleTask(startTime, endTime, "2","getTravelSalesCash",controller));
		Future<Map<String,Object>> travelSalesCashMicro = taskExecutor.submit(new SaleTask(startTime, endTime, "","getTravelSalesCash",controller));
		
		//现金满额销售SPU SKU种类总数  活动期间，满99、199、299且使用购卡权限的销售SPU种类总数
		Future<Map<String, Object>> travelSaleSPUCash = taskExecutor.submit(new SaleTask(startTime, endTime, null,"getTravelSaleSPUCash",controller));
		Future<Map<String, Object>> travelSaleSPUCashAPP = taskExecutor.submit(new SaleTask(startTime, endTime, "1","getTravelSaleSPUCash",controller));
		Future<Map<String, Object>> travelSaleSPUCashMicroMall = taskExecutor.submit(new SaleTask(startTime, endTime, "2","getTravelSaleSPUCash",controller));
		Future<Map<String, Object>> travelSaleSPUCashMicro = taskExecutor.submit(new SaleTask(startTime, endTime, "","getTravelSaleSPUCash",controller));
		
		//现金满额总销量  活动期间，满99、199、299且使用购卡权限的的销售子商品总销量
		Future<Map<String, Object>> travelSaleCash = taskExecutor.submit(new SaleTask(startTime, endTime, null,"getTravelSaleCash",controller));
		Future<Map<String, Object>> travelSaleCashAPP= taskExecutor.submit(new SaleTask(startTime, endTime, "1","getTravelSaleCash",controller));
		Future<Map<String, Object>> travelSaleCashMicroMall = taskExecutor.submit(new SaleTask(startTime, endTime, "2","getTravelSaleCash",controller));
		Future<Map<String, Object>> travelSaleCashMicro = taskExecutor.submit(new SaleTask(startTime, endTime, "","getTravelSaleCash",controller));
		
		//活动订单总数    活动期间，满99、199、299的活动主订单总数
		Future<Map<String, Object>> travelOrderMainCount = taskExecutor.submit(new SaleTask(startTime, endTime, null,"getTravelOrderMainCount",controller));
		Future<Map<String, Object>> travelOrderMainCountAPP = taskExecutor.submit(new SaleTask(startTime, endTime, "1","getTravelOrderMainCount",controller));
		Future<Map<String, Object>> travelOrderMainCountMicroMall = taskExecutor.submit(new SaleTask(startTime, endTime, "2","getTravelOrderMainCount",controller));
		Future<Map<String, Object>> travelOrderMainCountMicro = taskExecutor.submit(new SaleTask(startTime, endTime, "","getTravelOrderMainCount",controller));
		
		//活动子订单总数  活动期间，满99、199、299的活动子订单总数
		Future<Map<String, Object>> travelOrderCount = taskExecutor.submit(new SaleTask(startTime, endTime, null,"getTravelOrderCount",controller));
		Future<Map<String, Object>> travelOrderCountAPP = taskExecutor.submit(new SaleTask(startTime, endTime, "1","getTravelOrderCount",controller));
		Future<Map<String, Object>> travelOrderCountMicroMall = taskExecutor.submit(new SaleTask(startTime, endTime, "2","getTravelOrderCount",controller));
		Future<Map<String, Object>> travelOrderCountMicro = taskExecutor.submit(new SaleTask(startTime, endTime, "","getTravelOrderCount",controller));
		
		//现金满额订单总数   活动期间，满99、199、299且使用购卡权限主订单总数
		Future<Map<String, Object>> travelOrderMainCash = taskExecutor.submit(new SaleTask(startTime, endTime, null,"getTravelOrderMainCash",controller));
		Future<Map<String, Object>> travelOrderMainCashAPP = taskExecutor.submit(new SaleTask(startTime, endTime, "1","getTravelOrderMainCash",controller));
		Future<Map<String, Object>> travelOrderMainCashMicroMall = taskExecutor.submit(new SaleTask(startTime, endTime, "2","getTravelOrderMainCash",controller));
		Future<Map<String, Object>> travelOrderMainCashMicro = taskExecutor.submit(new SaleTask(startTime, endTime, "","getTravelOrderMainCash",controller));
		
		//现金满额子订单总数   活动期间，满99、199、299且使用购卡权限子订单总数
		Future<Map<String, Object>> travelOrderCash = taskExecutor.submit(new SaleTask(startTime, endTime, null,"getTravelOrderCash",controller));
		Future<Map<String, Object>> travelOrderCashAPP = taskExecutor.submit(new SaleTask(startTime, endTime, "1","getTravelOrderCash",controller));
		Future<Map<String, Object>> travelOrderCashMicroMall = taskExecutor.submit(new SaleTask(startTime, endTime, "2","getTravelOrderCash",controller));
		Future<Map<String, Object>> travelOrderCashMicro = taskExecutor.submit(new SaleTask(startTime, endTime, "","getTravelOrderCash",controller));
		
		//支付数据---->[现金支付总金额]
		Future<Map<String, Object>> payTotal = taskExecutor.submit(new SaleTask(startTime, endTime, null,"getPayTotal",controller));
		Future<Map<String, Object>> payTotalApp = taskExecutor.submit(new SaleTask(startTime, endTime, "1","getPayTotal",controller));
		Future<Map<String, Object>> payTotalWebChat = taskExecutor.submit(new SaleTask(startTime, endTime, "2","getPayTotal",controller));
		Future<Map<String, Object>> payTotalMicro = taskExecutor.submit(new SaleTask(startTime, endTime, "","getPayTotal",controller));
		
		//支付数据---->[现金满额现金支付总金额]
		Future<Map<String, Object>> buyCardPayTotal = taskExecutor.submit(new SaleTask(startTime, endTime, null,"getBuyCardPayTotal",controller));
		Future<Map<String, Object>> buyCardPayTotalApp = taskExecutor.submit(new SaleTask(startTime, endTime, "1","getBuyCardPayTotal",controller));
		Future<Map<String, Object>> buyCardPayTotalWebChat = taskExecutor.submit(new SaleTask(startTime, endTime, "2","getBuyCardPayTotal",controller));
		Future<Map<String, Object>> buyCardPayTotalMicro = taskExecutor.submit(new SaleTask(startTime, endTime, "","getBuyCardPayTotal",controller));
		
		//支付数据---->[实际支付总积分] [福利券支付总积分]
		Future<Map<String, Object>> actualPayTotalPoint = taskExecutor.submit(new SaleTask(startTime, endTime, null,"getActualPayTotalPoint",controller));
		Future<Map<String, Object>> actualPayTotalPointApp = taskExecutor.submit(new SaleTask(startTime, endTime, "1","getActualPayTotalPoint",controller));
		Future<Map<String, Object>> actualPayTotalPointWebChat = taskExecutor.submit(new SaleTask(startTime, endTime, "2","getActualPayTotalPoint",controller));
		Future<Map<String, Object>> actualPayTotalPointMicro = taskExecutor.submit(new SaleTask(startTime, endTime, "","getActualPayTotalPoint",controller));
		
		//支付数据---->[现金满额实际支付总积分] [现金满额褔利券支付总积分]
		Future<Map<String, Object>> buyCardPayTotalPoint = taskExecutor.submit(new SaleTask(startTime, endTime, null,"getBuyCardPayTotalPoint",controller));
		Future<Map<String, Object>> buyCardPayTotalPointApp = taskExecutor.submit(new SaleTask(startTime, endTime, "1","getBuyCardPayTotalPoint",controller));
		Future<Map<String, Object>> buyCardPayTotalPointWebChat = taskExecutor.submit(new SaleTask(startTime, endTime, "2","getBuyCardPayTotalPoint",controller));
		Future<Map<String, Object>> buyCardPayTotalPointMicro = taskExecutor.submit(new SaleTask(startTime, endTime, "","getBuyCardPayTotalPoint",controller));
		
		//活动参与总人数  活动期间，参加99、199、299满额活动的总人数
		Future<Map<String, Object>> travelUserCount = taskExecutor.submit(new SaleTask(startTime, endTime, null,"getTravelUserCount",controller));
		Future<Map<String, Object>> travelUserCountAPP = taskExecutor.submit(new SaleTask(startTime, endTime, "1","getTravelUserCount",controller));
		Future<Map<String, Object>> travelUserCountMicroMall = taskExecutor.submit(new SaleTask(startTime, endTime, "2","getTravelUserCount",controller));
		Future<Map<String, Object>> travelUserCountMicro = taskExecutor.submit(new SaleTask(startTime, endTime, "","getTravelUserCount",controller));
		
		//重复参与人数  参与活动两次以上的人，去重数据
		Future<Map<String, Object>> travelRepeUserCount = taskExecutor.submit(new SaleTask(startTime, endTime, null,"getTravelRepeUserCount",controller));
		Future<Map<String, Object>> travelRepeUserCountAPP = taskExecutor.submit(new SaleTask(startTime, endTime, "1","getTravelRepeUserCount",controller));
		Future<Map<String, Object>> travelRepeUserCountMicroMall = taskExecutor.submit(new SaleTask(startTime, endTime, "2","getTravelRepeUserCount",controller));
		Future<Map<String, Object>> travelRepeUserCountMicro = taskExecutor.submit(new SaleTask(startTime, endTime, "","getTravelRepeUserCount",controller));
		
		//新增会员数  活动期间新增的会员人数
		Future<Map<String, Object>> travelNewUserCount = taskExecutor.submit(new SaleTask(startTime, endTime, null,"getTravelNewUserCount",controller));

		try {
			controller.await(5,TimeUnit.SECONDS);			
			HashMap<String, Double> finalMap = new HashMap<String, Double>();

			//销售额
			finalMap.put("saleTotal", ((BigDecimal)travelSales.get().get("PAYCASH")).doubleValue());
			finalMap.put("saleAppTotal", ((BigDecimal)travelSalesAPP.get().get("PAYCASH")).doubleValue());
			finalMap.put("saleWebChatTotal", ((BigDecimal)travelSalesMicroMall.get().get("PAYCASH")).doubleValue());
			finalMap.put("saleMicroTotal", ((BigDecimal)travelSalesMicro.get().get("PAYCASH")).doubleValue());
			//活动销售SPU
			finalMap.put("saleSpuTotal", ((BigDecimal)travelSaleSPUCount.get().get("PRODUCTCOUNT")).doubleValue());
			finalMap.put("saleSpuAppTotal", ((BigDecimal)travelSaleSPUCountAPP.get().get("PRODUCTCOUNT")).doubleValue());
			finalMap.put("saleSpuWebChatTotal", ((BigDecimal)travelSaleSPUCountMicroMall.get().get("PRODUCTCOUNT")).doubleValue());
			finalMap.put("saleSpuMicroTotal", ((BigDecimal)travelSaleSPUCountMicro.get().get("PRODUCTCOUNT")).doubleValue());
			//活动销售SKU
			finalMap.put("saleSkuTotal", ((BigDecimal)travelSaleSPUCount.get().get("PRODUCTDETAILCOUNT")).doubleValue());
			finalMap.put("saleSkuAppTotal", ((BigDecimal)travelSaleSPUCountAPP.get().get("PRODUCTDETAILCOUNT")).doubleValue());
			finalMap.put("saleSkuWebChatTotal", ((BigDecimal)travelSaleSPUCountMicroMall.get().get("PRODUCTDETAILCOUNT")).doubleValue());
			finalMap.put("saleSkuMicroTotal", ((BigDecimal)travelSaleSPUCountMicro.get().get("PRODUCTDETAILCOUNT")).doubleValue());
			//活动商品总销量
			finalMap.put("productTotal", ((BigDecimal)travelProductCount.get().get("BUYNUM")).doubleValue());
			finalMap.put("productAppTotal", ((BigDecimal)travelProductCountAPP.get().get("BUYNUM")).doubleValue());
			finalMap.put("productWebChatTotal", ((BigDecimal)travelProductCountMicroMall.get().get("BUYNUM")).doubleValue());
			finalMap.put("productMicroTotal", ((BigDecimal)travelProductCountMicro.get().get("BUYNUM")).doubleValue());
			//现金满额销售额
			finalMap.put("saleCashTotal", ((BigDecimal)travelSalesCash.get().get("PAYCASH")).doubleValue());
			finalMap.put("saleCashAppTotal", ((BigDecimal)travelSalesCashAPP.get().get("PAYCASH")).doubleValue());
			finalMap.put("saleCashWebChatTotal", ((BigDecimal)travelSalesCashMicroMall.get().get("PAYCASH")).doubleValue());
			finalMap.put("saleCashMicroTotal", ((BigDecimal)travelSalesCashMicro.get().get("PAYCASH")).doubleValue());
			//现金满额销售SPU
			finalMap.put("saleSpuCashTotal", ((BigDecimal)travelSaleSPUCash.get().get("PRODUCTCOUNT")).doubleValue());
			finalMap.put("saleSpuCashAppTotal", ((BigDecimal)travelSaleSPUCashAPP.get().get("PRODUCTCOUNT")).doubleValue());
			finalMap.put("saleSpuCashWebChatTotal", ((BigDecimal)travelSaleSPUCashMicroMall.get().get("PRODUCTCOUNT")).doubleValue());
			finalMap.put("saleSpuCashMicroTotal", ((BigDecimal)travelSaleSPUCashMicro.get().get("PRODUCTCOUNT")).doubleValue());
			//现金满额销售SKU
			finalMap.put("saleSkuCashTotal", ((BigDecimal)travelSaleSPUCash.get().get("PRODUCTDETAILCOUNT")).doubleValue());
			finalMap.put("saleSkuCashAppTotal", ((BigDecimal)travelSaleSPUCashAPP.get().get("PRODUCTDETAILCOUNT")).doubleValue());
			finalMap.put("saleSkuCashWebChatTotal", ((BigDecimal)travelSaleSPUCashMicroMall.get().get("PRODUCTDETAILCOUNT")).doubleValue());
			finalMap.put("saleSkuCashMicroTotal", ((BigDecimal)travelSaleSPUCashMicro.get().get("PRODUCTDETAILCOUNT")).doubleValue());
			//现金满额总销量
			finalMap.put("saleCashTotalSub", ((BigDecimal)travelSaleCash.get().get("BUYNUM")).doubleValue());
			finalMap.put("saleCashTotalAppSub", ((BigDecimal)travelSaleCashAPP.get().get("BUYNUM")).doubleValue());
			finalMap.put("saleCashTotalWebChatSub", ((BigDecimal)travelSaleCashMicroMall.get().get("BUYNUM")).doubleValue());
			finalMap.put("saleCashTotalMicroSub", ((BigDecimal)travelSaleCashMicro.get().get("BUYNUM")).doubleValue());
			//活动订单总数
			finalMap.put("orderMainTotal", ((BigDecimal)travelOrderMainCount.get().get("ORDERNOMAIN")).doubleValue());
			finalMap.put("orderMainAppTotal", ((BigDecimal)travelOrderMainCountAPP.get().get("ORDERNOMAIN")).doubleValue());
			finalMap.put("orderMainWebChatTotal", ((BigDecimal)travelOrderMainCountMicroMall.get().get("ORDERNOMAIN")).doubleValue());
			finalMap.put("orderMainMicroTotal", ((BigDecimal)travelOrderMainCountMicro.get().get("ORDERNOMAIN")).doubleValue());
			//活动子订单总数
			finalMap.put("orderSubTotal", ((BigDecimal)travelOrderCount.get().get("ORDERNO")).doubleValue());
			finalMap.put("orderSubAppTotal", ((BigDecimal)travelOrderCountAPP.get().get("ORDERNO")).doubleValue());
			finalMap.put("orderSubWebChatTotal", ((BigDecimal)travelOrderCountMicroMall.get().get("ORDERNO")).doubleValue());
			finalMap.put("orderSubMicroTotal", ((BigDecimal)travelOrderCountMicro.get().get("ORDERNO")).doubleValue());
			//现金满额订单总数
			finalMap.put("orderMainCashTotal", ((BigDecimal)travelOrderMainCash.get().get("ORDERNOMAIN")).doubleValue());
			finalMap.put("orderMainCashAppTotal", ((BigDecimal)travelOrderMainCashAPP.get().get("ORDERNOMAIN")).doubleValue());
			finalMap.put("orderMainCashWebChatTotal", ((BigDecimal)travelOrderMainCashMicroMall.get().get("ORDERNOMAIN")).doubleValue());
			finalMap.put("orderMainCashMicroTotal", ((BigDecimal)travelOrderMainCashMicro.get().get("ORDERNOMAIN")).doubleValue());
			//现金满额子订单总数
			finalMap.put("orderSubCashTotal", ((BigDecimal)travelOrderCash.get().get("ORDERNO")).doubleValue());
			finalMap.put("orderSubCashAppTotal", ((BigDecimal)travelOrderCashAPP.get().get("ORDERNO")).doubleValue());
			finalMap.put("orderSubCashWebChatTotal", ((BigDecimal)travelOrderCashMicroMall.get().get("ORDERNO")).doubleValue());
			finalMap.put("orderSubCashMircoTotal", ((BigDecimal)travelOrderCashMicro.get().get("ORDERNO")).doubleValue());
			//现金支付总金额
			finalMap.put("payTotal", ((BigDecimal)payTotal.get().get("PAYCASH")).doubleValue());
			finalMap.put("payTotalApp", ((BigDecimal)payTotalApp.get().get("PAYCASH")).doubleValue());
			finalMap.put("payTotalWebChat", ((BigDecimal)payTotalWebChat.get().get("PAYCASH")).doubleValue());
			finalMap.put("payTotalMicro", ((BigDecimal)payTotalMicro.get().get("PAYCASH")).doubleValue());
			//现金满额现金支付总金额
			finalMap.put("buyCardPayTotal", ((BigDecimal)buyCardPayTotal.get().get("PAYCASH")).doubleValue());
			finalMap.put("buyCardPayTotalApp", ((BigDecimal)buyCardPayTotalApp.get().get("PAYCASH")).doubleValue());
			finalMap.put("buyCardPayTotalWebChat", ((BigDecimal)buyCardPayTotalWebChat.get().get("PAYCASH")).doubleValue());
			finalMap.put("buyCardPayTotalMicro", ((BigDecimal)buyCardPayTotalMicro.get().get("PAYCASH")).doubleValue());
			//实际支付总积分
			finalMap.put("actualPayTotalPoint", ((BigDecimal)actualPayTotalPoint.get().get("PAYPOINTS")).doubleValue());
			finalMap.put("actualPayTotalPointApp", ((BigDecimal)actualPayTotalPointApp.get().get("PAYPOINTS")).doubleValue());
			finalMap.put("actualPayTotalPointWebChat", ((BigDecimal)actualPayTotalPointWebChat.get().get("PAYPOINTS")).doubleValue());
			finalMap.put("actualPayTotalPointMicro", ((BigDecimal)actualPayTotalPointMicro.get().get("PAYPOINTS")).doubleValue());
			//福利券支付总积分
			finalMap.put("specialPointTotal", ((BigDecimal)actualPayTotalPoint.get().get("SPECIALPOINTS")).doubleValue());
			finalMap.put("specialPointAppTotal", ((BigDecimal)actualPayTotalPointApp.get().get("SPECIALPOINTS")).doubleValue());
			finalMap.put("specialPointWebChatTotal", ((BigDecimal)actualPayTotalPointWebChat.get().get("SPECIALPOINTS")).doubleValue());
			finalMap.put("specialPointMicroTotal", ((BigDecimal)actualPayTotalPointMicro.get().get("SPECIALPOINTS")).doubleValue());
			//现金满额实际支付总积分
			finalMap.put("buyCardPayTotalPoint", ((BigDecimal)buyCardPayTotalPoint.get().get("PAYPOINTS")).doubleValue());
			finalMap.put("buyCardPayTotalPointApp", ((BigDecimal)buyCardPayTotalPointApp.get().get("PAYPOINTS")).doubleValue());
			finalMap.put("buyCardPayTotalPointWebChat", ((BigDecimal)buyCardPayTotalPointWebChat.get().get("PAYPOINTS")).doubleValue());
			finalMap.put("buyCardPayTotalPointMicro", ((BigDecimal)buyCardPayTotalPointMicro.get().get("PAYPOINTS")).doubleValue());
			//现金满额褔利券支付总积分
			finalMap.put("buyCardSpecialTotal", ((BigDecimal)buyCardPayTotalPoint.get().get("SPECIALPOINTS")).doubleValue());
			finalMap.put("buyCardSpecialAppTotal", ((BigDecimal)buyCardPayTotalPointApp.get().get("SPECIALPOINTS")).doubleValue());
			finalMap.put("buyCardSpecialWebChatTotal", ((BigDecimal)buyCardPayTotalPointWebChat.get().get("SPECIALPOINTS")).doubleValue());
			finalMap.put("buyCardSpecialMicroTotal", ((BigDecimal)buyCardPayTotalPointMicro.get().get("SPECIALPOINTS")).doubleValue());
			
			//计算客单价		
			finalMap.put("custSingleTotal", getCustSinglePrice(travelSales, travelOrderMainCount));
			finalMap.put("custSingleAppTotal", getCustSinglePrice(travelSalesAPP, travelOrderMainCountAPP));
			finalMap.put("custSingleWebChatTotal", getCustSinglePrice(travelSalesMicroMall, travelOrderMainCountMicroMall));
			finalMap.put("custSingleMicroTotal", getCustSinglePrice(travelSalesMicro, travelOrderMainCountMicro));
			//现金满额客单价
			finalMap.put("cashSingle", getCustSinglePrice(travelSalesCash,travelOrderMainCash));
			finalMap.put("cashSingleApp", getCustSinglePrice(travelSalesCashAPP,travelOrderMainCashAPP));
			finalMap.put("cashSingleWebChat", getCustSinglePrice(travelSalesCashMicroMall,travelOrderMainCashMicroMall));
			finalMap.put("cashSingleMicro", getCustSinglePrice(travelSalesCashMicro,travelOrderMainCashMicro));
			//活动参与总人数
			finalMap.put("travelUserCount", ((BigDecimal)travelUserCount.get().get("USERID")).doubleValue());		
			finalMap.put("travelUserCountAPP", ((BigDecimal)travelUserCountAPP.get().get("USERID")).doubleValue());		
			finalMap.put("travelUserCountMicroMall", ((BigDecimal)travelUserCountMicroMall.get().get("USERID")).doubleValue());		
			finalMap.put("travelUserCountMicro", ((BigDecimal)travelUserCountMicro.get().get("USERID")).doubleValue());
			
			//重复参与人数
			finalMap.put("travelRepeUserCount", ((BigDecimal)travelRepeUserCount.get().get("USERCOUNT")).doubleValue());
			finalMap.put("travelRepeUserCountAPP", ((BigDecimal)travelRepeUserCountAPP.get().get("USERCOUNT")).doubleValue());
			finalMap.put("travelRepeUserCountMicroMall", ((BigDecimal)travelRepeUserCountMicroMall.get().get("USERCOUNT")).doubleValue());
			finalMap.put("travelRepeUserCountMicro", ((BigDecimal)travelRepeUserCountMicro.get().get("USERCOUNT")).doubleValue());
			//新增会员数
			finalMap.put("travelNewUserCount", ((BigDecimal)travelNewUserCount.get().get("TUIID")).doubleValue());
			
			return finalMap;
			
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	private Double getCustSinglePrice(Future<Map<String, Object>> travelSales, Future<Map<String, Object>> travelOrderMainCount) throws InterruptedException, ExecutionException {
		BigDecimal saleValues = (BigDecimal)travelSales.get().get("PAYCASH");
		BigDecimal saleOrderTotal = (BigDecimal)travelOrderMainCount.get().get("ORDERNOMAIN");
		Double custSinglePrice = 0.0;
		if(saleOrderTotal.intValue() != 0)
			custSinglePrice = saleValues.divide(saleOrderTotal,BigDecimal.ROUND_HALF_UP).doubleValue();
		return custSinglePrice;
	}
}