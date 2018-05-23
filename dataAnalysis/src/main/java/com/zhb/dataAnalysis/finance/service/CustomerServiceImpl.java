package com.zhb.dataAnalysis.finance.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.zhb.dataAnalysis.common.repository.database.customerService.AccountStatementDao;
import com.zhb.dataAnalysis.common.repository.database.model.CustomerServiceBean;
import com.zhb.dataAnalysis.finance.api.CustomerService;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService{

	private static final String XH_JK = "XH_JK";
	private static final String XH_CF = "XH_CF";
	private static final String XH_JX = "XH_JX";
	private static final String XH_DJR = "XH_DJR";
	
	
	@Resource(name = "accountStatementDao")
	private AccountStatementDao accountStatementDao;

	public Map<String, Object> getAccountStatement(String startTime,String endTime,int currentPage,int pageSize,String company){
		String curUserId="";
		String lastOrderCreateTime="";
		String lastMainOrderNo = "";
		String timestamp = "";
		Map<String,CustomerServiceBean> platformConsume = new HashMap<String, CustomerServiceBean>();
		List<Map<String,String>> list = accountStatementDao.getData(startTime, endTime);// 第一步: 查询该时间段内的有效订单
		if(list != null && list.size() > 0){
			List<String> companyList = new ArrayList<String>();
			List<Map<String, String>> pointRecord = new ArrayList<Map<String,String>>();
			if(StringUtils.isNotBlank(company)){
				if("金信网".indexOf(company) >= 0){
					companyList.add(XH_JX);
				}
				if("信和大金融".indexOf(company) >= 0){
					companyList.add(XH_DJR);
				}
				if("信和汇金".indexOf(company) >= 0){
					companyList.add(XH_JK);
				}
				if("信和财富".indexOf(company) >= 0){
					companyList.add(XH_CF);
				}
			}
			for (Map<String, String> map : list) { // 循环时间段内的有效订单
				String userId = map.get("USER_ID");
				String productName = map.get("PRODUCT_NAME");
				int exchangeRate = Integer.parseInt(formatObject(map.get("EXCHANGE_RATE")));
				BigDecimal payPoints = new BigDecimal(formatObject(map.get("PAY_POINTS")));
				BigDecimal singlePoints = new BigDecimal(formatObject(map.get("SINGLE_POINTS")));
				String createTime = formatObject(map.get("CREATE_TIME"));
				String mainOrderNo = formatObject(map.get("ORDER_NO_MAIN"));
				if(!curUserId.equals(userId)){
    	    	    curUserId=userId;
    	    	    lastOrderCreateTime=formatObject(map.get("MINDATE"));
    	    	    pointRecord.clear();
	    	    }else{
	    	    	if(!lastMainOrderNo.equals(mainOrderNo)){
	    	    		lastOrderCreateTime=timestamp;
	    	    	}
	    	    	timestamp=createTime;
	    	    }
				if(StringUtils.isNotBlank(lastOrderCreateTime) && lastOrderCreateTime.contains(".")){
	    	      lastOrderCreateTime=lastOrderCreateTime.split("\\.")[0];
	    	    }else{
	    	    	continue;
	    	    }
    	        if(StringUtils.isNotBlank(createTime) && createTime.contains(".")){
    	    	  createTime=createTime.split("\\.")[0];
    	        }else{
	    	    	continue;
	    	    }
				if(!lastMainOrderNo.equals(mainOrderNo)){// 第二步: 不是同一个主订单,重新查询积分明细
					pointRecord = accountStatementDao.getPointsRecord(lastOrderCreateTime, endTime, userId,companyList.size() > 0 ? companyList:null );
				}
				int ii = 0;
				for (int i = 0,size = pointRecord.size(); i < size; i++) { // 第三步: 循环积分明细,针对商品消费的平台积分进行计算
					ii = i;
					Map<String, String> pointMap = pointRecord.get(i);
					CustomerServiceBean bean = new CustomerServiceBean();
					BigDecimal point = new BigDecimal(formatObject(pointMap.get("POINT"))); // 积分明细的积分
					BigDecimal productNum = BigDecimal.valueOf(0); // 商品数量 = 支付积分/单价
					String sysfrom = pointMap.get("SYSFROM");
					String consumeKey = sysfrom+"@"+productName+"@"+singlePoints;
					BigDecimal subtraction = point.subtract(payPoints);
					bean.setGoodsName(productName);
					bean.setCompanyName(sysfrom);
					bean.setActualSellPrice(singlePoints.divide(BigDecimal.valueOf(exchangeRate)));
					if(subtraction.compareTo(BigDecimal.ZERO)==-1){ // 当前的积分明细积分 小于 消费积分
						productNum = point.divide(singlePoints, 4, BigDecimal.ROUND_HALF_EVEN); // 消费积分 / 单价 = 数量
						payPoints = payPoints.subtract(point);
						if(platformConsume.containsKey(consumeKey)){ // 如果map里有这个对象就做相加
							bean = platformConsume.get(consumeKey);
							BigDecimal sum = bean.getNum().add(productNum);// 通过key拿到map里的对象做相加数量
							bean.setNum(sum);
							bean.setActualPayPoints(bean.getActualPayPoints().add(point));
							bean.setActualPayMoney(bean.getActualPayMoney().add(point.divide(BigDecimal.valueOf(exchangeRate))));
						}else{
							bean.setNum(productNum);
							bean.setActualPayPoints(point);
							bean.setActualPayMoney(point.divide(BigDecimal.valueOf(exchangeRate)));
						}
						platformConsume.put(consumeKey, bean);
					}else if(subtraction.compareTo(BigDecimal.ZERO)==1){ // 当前的积分明细积分 大于 消费积分
						productNum = payPoints.divide(singlePoints, 4, BigDecimal.ROUND_HALF_EVEN);
						if(platformConsume.containsKey(consumeKey)){ // 如果map里有这个对象就做相加
							bean = platformConsume.get(consumeKey);
							BigDecimal add = bean.getNum().add(productNum);// 通过key拿到map里的对象做相加数量
							bean.setNum(add);
							bean.setActualPayPoints(bean.getActualPayPoints().add(payPoints));
							bean.setActualPayMoney(bean.getActualPayMoney().add(payPoints.divide(BigDecimal.valueOf(exchangeRate))));
						}else{
							bean.setNum(productNum);
							bean.setActualPayPoints(payPoints);
							bean.setActualPayMoney(payPoints.divide(BigDecimal.valueOf(exchangeRate)));
						}
						platformConsume.put(consumeKey, bean);
						pointMap.put("SYSFROM", sysfrom);
						pointMap.put("POINT", point.subtract(payPoints).toString());
						pointRecord.set(i, pointMap);
						break;
					}else if(subtraction.compareTo(BigDecimal.ZERO)==0){ // 当前的积分明细积分 等于 消费积分
						productNum = point.divide(singlePoints, 4, BigDecimal.ROUND_HALF_EVEN);
						if(platformConsume.containsKey(consumeKey)){ // 如果map里有这个对象就做相加
							bean = platformConsume.get(consumeKey);
							BigDecimal add = bean.getNum().add(productNum); // 通过key拿到map里的对象做相加数量
							bean.setNum(add);
							bean.setActualPayPoints(bean.getActualPayPoints().add(point));
							bean.setActualPayMoney(bean.getActualPayMoney().add(point.divide(BigDecimal.valueOf(exchangeRate))));
						}else{
							bean.setNum(productNum);
							bean.setActualPayPoints(point);
							bean.setActualPayMoney(point.divide(BigDecimal.valueOf(exchangeRate)));
						}
						platformConsume.put(consumeKey, bean);
						break;
					}
				}
				lastMainOrderNo = mainOrderNo;
				pointRecord = pointRecord.subList(ii, pointRecord.size());
			}
		}
		return getCustomerServiceLisit(platformConsume, currentPage, pageSize);
	}
	
	public Map<String, Object> getAccountStatement2(String startTime,String endTime,int currentPage,int pageSize,String company){
		String lastOrderCreateTime="";
		String currentUserId = "";
		Map<String,CustomerServiceBean> platformConsume = new HashMap<String, CustomerServiceBean>();
		List<Map<String,String>> list = accountStatementDao.getData2(startTime, endTime);// 第一步: 查询该时间段内的有效商品
		if(list != null && list.size() > 0){
			List<String> companyList = new ArrayList<String>();
			List<Map<String, String>> pointRecord = new ArrayList<Map<String,String>>();
			if(StringUtils.isNotBlank(company)){
				if("金信网".indexOf(company) >= 0){
					companyList.add(XH_JX);
				}
				if("信和大金融".indexOf(company) >= 0){
					companyList.add(XH_DJR);
				}
				if("信和汇金".indexOf(company) >= 0){
					companyList.add(XH_JK);
				}
				if("信和财富".indexOf(company) >= 0){
					companyList.add(XH_CF);
				}
			}
			for (Map<String, String> map : list) { //时段内下单的商品
				String productName = map.get("PRODUCT_NAME");
				String userId = map.get("USER_ID");
				int exchangeRate = Integer.parseInt(formatObject(map.get("EXCHANGE_RATE")));
				BigDecimal payPoints = new BigDecimal(formatObject(map.get("PAY_POINTS")));
				BigDecimal singlePoints = new BigDecimal(formatObject(map.get("SINGLE_POINTS")));
				int ii = 0;
//				List<String> user = accountStatementDao.getDownOrderUser(exchangeRate, productName, singlePoints);//查询时间段内的有效用户
//				for (String string : user) {
				if(!currentUserId.equals(userId)){
					currentUserId=userId;
					lastOrderCreateTime = accountStatementDao.getMinDate(userId);
					pointRecord.clear();
				}
				if(StringUtils.isNotBlank(lastOrderCreateTime) && lastOrderCreateTime.contains(".")){
					lastOrderCreateTime=lastOrderCreateTime.split("\\.")[0];
					pointRecord = accountStatementDao.getPointsRecord(lastOrderCreateTime, endTime, userId,companyList.size() > 0 ? companyList:null);
					for (int i = 0,size = pointRecord.size(); i < size; i++) {
						ii = i;
						Map<String, String> pointMap = pointRecord.get(i);
						CustomerServiceBean bean = new CustomerServiceBean();
						BigDecimal point = new BigDecimal(formatObject(pointMap.get("POINT"))); // 积分明细的积分
						BigDecimal productNum = BigDecimal.valueOf(0); // 商品数量 = 支付积分/单价
						String sysfrom = pointMap.get("SYSFROM");
						String consumeKey = sysfrom+"@"+productName+"@"+singlePoints;
						BigDecimal subtraction = point.subtract(payPoints);
						bean.setGoodsName(productName);
						bean.setCompanyName(sysfrom);
						bean.setActualSellPrice(singlePoints.divide(BigDecimal.valueOf(exchangeRate)));
						if(subtraction.compareTo(BigDecimal.ZERO)==-1){ // 小于
							productNum = point.divide(singlePoints, 4, BigDecimal.ROUND_HALF_EVEN); // 消费积分 / 单价 = 数量
							payPoints = payPoints.subtract(point);
							if(platformConsume.containsKey(consumeKey)){ // 如果map里有这个对象就做相加
								bean = platformConsume.get(consumeKey);
								BigDecimal sum = bean.getNum().add(productNum);// 通过key拿到map里的对象做相加数量
								bean.setNum(sum);
								bean.setActualPayPoints(bean.getActualPayPoints().add(point));
								bean.setActualPayMoney(bean.getActualPayMoney().add(point.divide(BigDecimal.valueOf(exchangeRate))));
							}else{
								bean.setNum(productNum);
								bean.setActualPayPoints(point);
								bean.setActualPayMoney(point.divide(BigDecimal.valueOf(exchangeRate)));
							}
							platformConsume.put(consumeKey, bean);
						}else if(subtraction.compareTo(BigDecimal.ZERO)==1){ // 大于
							productNum = payPoints.divide(singlePoints, 4, BigDecimal.ROUND_HALF_EVEN);
							if(platformConsume.containsKey(consumeKey)){ // 如果map里有这个对象就做相加
								bean = platformConsume.get(consumeKey);
								BigDecimal add = bean.getNum().add(productNum);// 通过key拿到map里的对象做相加数量
								bean.setNum(add);
								bean.setActualPayPoints(bean.getActualPayPoints().add(payPoints));
								bean.setActualPayMoney(bean.getActualPayMoney().add(payPoints.divide(BigDecimal.valueOf(exchangeRate))));
							}else{
								bean.setNum(productNum);
								bean.setActualPayPoints(payPoints);
								bean.setActualPayMoney(payPoints.divide(BigDecimal.valueOf(exchangeRate)));
							}
							platformConsume.put(consumeKey, bean);
							pointMap.put("SYSFROM", sysfrom);
							pointMap.put("POINT", point.subtract(payPoints).toString());
							pointRecord.set(i, pointMap);
							break;
						}else if(subtraction.compareTo(BigDecimal.ZERO)==0){ // 等于
							productNum = point.divide(singlePoints, 4, BigDecimal.ROUND_HALF_EVEN);
							if(platformConsume.containsKey(consumeKey)){ // 如果map里有这个对象就做相加
								bean = platformConsume.get(consumeKey);
								BigDecimal add = bean.getNum().add(productNum); // 通过key拿到map里的对象做相加数量
								bean.setNum(add);
								bean.setActualPayPoints(bean.getActualPayPoints().add(point));
								bean.setActualPayMoney(bean.getActualPayMoney().add(point.divide(BigDecimal.valueOf(exchangeRate))));
							}else{
								bean.setNum(productNum);
								bean.setActualPayPoints(point);
								bean.setActualPayMoney(point.divide(BigDecimal.valueOf(exchangeRate)));
							}
							platformConsume.put(consumeKey, bean);
							break;
						}
					}
					pointRecord = pointRecord.subList(ii, pointRecord.size());
				}else{
					continue;
				}
//				}
			}
		}
		return getCustomerServiceLisit(platformConsume, currentPage, pageSize);
	}
	
	public Map<String, Object> getCustomerServiceLisit(Map<String,CustomerServiceBean> platformConsume,int currentPage,int pageSize){
		Map<String,Object> map = new HashMap<String, Object>();
		BigDecimal sumNum = BigDecimal.valueOf(0);
		BigDecimal sumPoints = BigDecimal.valueOf(0);
		BigDecimal sumMoney = BigDecimal.valueOf(0);
		List<CustomerServiceBean> list = new ArrayList<CustomerServiceBean>();
		if(platformConsume.size() > 0){
			for(String key:platformConsume.keySet()){
				CustomerServiceBean bean = platformConsume.get(key);
				sumNum = sumNum.add(bean.getNum());
				sumPoints = sumPoints.add(bean.getActualPayPoints());
				sumMoney = sumMoney.add(bean.getActualPayMoney());
				list.add(bean);
			}
			map.put("total", list.size());
			if(currentPage > 0 && pageSize > 0){
				int lastIndex = currentPage*pageSize;
				int index = (currentPage-1)*pageSize;
				int size = list.size();
				if (lastIndex <= size) {
					list = list.subList(index, lastIndex);
				} else {
					list = list.subList(index, size);
				}
			}
			map.put("rows", list);
			map.put("sumNum", sumNum);
			map.put("sumSellPoints", sumPoints);
			map.put("sumSellMoney", sumMoney);
		}else{
			map.put("total", 1);
			map.put("rows", list);
			map.put("sumNum", sumNum);
			map.put("sumSellPoints", sumPoints);
			map.put("sumSellMoney", sumMoney);
		}
		return map;
	}
	
	public String formatObject(Object param){
		return String.valueOf(param);
	}
	
	public static void main(String[] args) {
//		BigDecimal divide = BigDecimal.valueOf(10).divide(BigDecimal.valueOf(6), 2,BigDecimal.ROUND_HALF_EVEN);
//		System.out.println(divide);
//		String name = "金信网";
//		int i = 1;
//		System.out.println(i++);
		String time = "2017-3-12 12:43:21";
		System.out.println(time.contains("."));
	}
}
