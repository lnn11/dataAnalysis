package com.zhb.dataAnalysis.commodity.service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.zhb.dataAnalysis.commodity.api.OrderService;
import com.zhb.dataAnalysis.common.repository.database.model.OrderModel;
import com.zhb.dataAnalysis.common.repository.database.order.OrderDao;

@Service("orderServiceImpl")
public class OrderServiceImpl implements OrderService{
	
	@Resource(name="orderDao")
	private OrderDao orderDao;

	/**
	 * 订单总数分析   按月分析
	 */
	@Override
	public List<OrderModel> orderTotalList(String orderYear) {
		List<OrderModel> list = orderDao.orderTotalList(orderYear);
		List<OrderModel> list1 = orderDao.orderTotalSaleList(orderYear);
		for (OrderModel orderModel : list) {
			for (OrderModel orderModel1 : list1) {
				if (orderModel.getOrderMonth()==orderModel1.getOrderMonth()) {
					orderModel.setOrderSumIntegral(orderModel1.getOrderSumIntegral());
					orderModel.setSumNum(orderModel1.getSumNum());
				}
			}
		}
		int array[] = {1,2,3,4,5,6,7,8,9,10,11,12};
		List<OrderModel> list2 = new ArrayList<OrderModel>(); 
		for (int i = 1; i <= array.length; i++) {
			Boolean flag = false;
			for (OrderModel orderModel : list) {
				if (orderModel.getOrderMonth()==i) {
					flag = true;
				}
			}
			if(flag == false){
				OrderModel orderModel = new OrderModel();
				orderModel.setOrderMonth(i);
				orderModel.setOrderNum(0);
				orderModel.setOrderSumIntegral(0.00);
				orderModel.setSumNum(0);
				list2.add(orderModel);
			}
		}
		list2.addAll(list);
		DecimalFormat df = (DecimalFormat) NumberFormat.getInstance();
		df.setMaximumFractionDigits(2);//保留两位小数
		Double orderSum = 0.00;//订单总数
		Double orderIntegralSum = 0.00;//销售额总数
		Double orderSumNum = 0.00;//销量总数
		for (OrderModel orderModel : list2) {
			orderSum +=orderModel.getOrderNum();
			orderSumNum += orderModel.getSumNum();
			orderIntegralSum += orderModel.getOrderSumIntegral();
		}
		for (OrderModel orderModel : list2) {
			if (orderSum == 0.00) {
				orderModel.setOrderProp("0");
				orderModel.setSumNumProp("0");
				orderModel.setOrderIntegralProp("0");
			}else {
				orderModel.setOrderProp(df.format(orderModel.getOrderNum()/orderSum*100));
				orderModel.setSumNumProp(df.format(orderModel.getSumNum()/orderSumNum*100));
				orderModel.setOrderIntegralProp(df.format(orderModel.getOrderSumIntegral()/orderIntegralSum*100));
			}
		}
		//对结果集进行排序处理
		List<OrderModel> list3 = new ArrayList<OrderModel>();
		for(int i=1; i<=12; i++){
			for (OrderModel orderModel : list2) {
				if(orderModel.getOrderMonth()==i){
					list3.add(orderModel);
				}
			}
		}
		return list3;
	}

	/**
	 * 订单总数分析  按供应商
	 */
	@Override
	public Map<String,Object> orderSupplierList(String prevDateOrder, String nextDateOrder, int currentPage,int pageSize) {
		//统计订单总数   按供应商   订单总数
		List<Map<String, String>>  orderSupplierList= orderDao.orderSupplierList(prevDateOrder,nextDateOrder);
		// 销量   销售额
		List<Map<String, String>> orderSupplierSaleList = orderDao.orderSupplierSaleList(prevDateOrder, nextDateOrder);
		// 统计所有供应商某时间段的所有供应商的名称，id
		List<Map<String, String>> supplierList = orderDao.supplierList(prevDateOrder, nextDateOrder);
		//统计所有供应商的某时间段的订单总数
		int orderCount = orderDao.orderCount(prevDateOrder, nextDateOrder);
		//统计所有供应商的某时间段销售额总数 销量总数 
		List<Map<String , Integer>> orderSaleCount= orderDao.orderSaleCount(prevDateOrder, nextDateOrder);
		//页数
		int pageCount = 0;
		if (supplierList.size()%pageSize==0) {
			pageCount = supplierList.size()/pageSize;
		}else {
			pageCount = supplierList.size()/pageSize+1;
		}
		if(pageCount==0) {
			pageCount=1;
		}
		Map<String,Object> map = new HashMap<String,Object>(6);
		//供应商，订单总数，销售额，销量,总页数
		map.put("pageCount", pageCount);//总页数
		map.put("orderSupplierList", orderSupplierList);//每个供应商订单总数
		map.put("supplierList", supplierList);//统计所有供应商某时间段的所有供应商的名称，id
		map.put("supplierJSON", JSON.toJSONString(supplierList, true));
		map.put("orderSupplierSaleList", orderSupplierSaleList);//每个供应商的销量   销售额
		map.put("orderCount", orderCount);//统计所有供应商的某时间段的订单总数
		map.put("orderSaleCount", orderSaleCount);//统计所有供应商的某时间段销售额总数 销量总数 
		//查出第一页的数据
		Map<String, Object> supplierByPage = getSupplierByPage(supplierList,currentPage,pageSize,prevDateOrder, nextDateOrder);
		map.put("firstpageSupplier",supplierByPage);
		return map;
	}
	
	public Map<String,Object> getSupplierByPage(List<Map<String, String>> supplierList,int currentPage,int pageSize, String prevDateOrder, String nextDateOrder){
		Map<String,Object> map = new HashMap<String,Object>(6);
		int lastIndex = currentPage*pageSize;
		int index = (currentPage-1)*pageSize;
		int supplierSize = supplierList.size();
		
		List<Map<String,String>> supList;
		//获取对应的供应商
		if (lastIndex <= supplierSize) {
			supList = supplierList.subList(index, lastIndex);
		} else {
			supList = supplierList.subList(index, supplierSize);
		}
		List<Map<String, String>> orderListBySup = null;
		List<Map<String, String>> orderSaleListBySup = null;
		//根据供应商查出list1,list2
		if (supList != null & supList.size()>0) {
			orderListBySup = orderDao.orderListBySup(supList,prevDateOrder, nextDateOrder);
			orderSaleListBySup = orderDao.orderSaleListBySup(supList,prevDateOrder, nextDateOrder);
		}
		
		map.put("orderListBySup", orderListBySup);
		map.put("orderSaleListBySup", orderSaleListBySup);
		return map;
	}
	
	@Override
	public Map<String, Object> getReturnedOrder(String startTime, String overTime) {
		Map<String,Object> map = new HashMap<String, Object>();
		for(int i = 1; i <= 5; i++){
			int order = orderDao.getReturnedOrder(startTime, overTime, i);
			map.put("order"+i, order);
		}
		return map;
	}

	@Override
	public Map<String, Double> getAreadyPaidOrder(String startTime,
			String overTime) {
		Map<String, Object> order = orderDao.getAreadyPaidOrder(startTime, overTime);
		Double actualmoney = ((BigDecimal)order.get("ACTUALMONEY")).doubleValue();//实际支付总积分对应总金额
		Double vouchermoney = ((BigDecimal)order.get("VOUCHERMONEY")).doubleValue();//福利券支付总积分对应总金额
		Double vouchertomoney = ((BigDecimal)order.get("VOUCHERTOMONEY")).doubleValue();//福利券支付总金额
		Double paidmoney = ((BigDecimal)order.get("PAIDMONEY")).doubleValue();//现金支付总金额
		Double activitmoney = ((BigDecimal)order.get("ACTIVITMONEY")).doubleValue();//活动抵扣总积分对应金额
		Double activittomoney = ((BigDecimal)order.get("ACTIVITTOMONEY")).doubleValue();//活动抵扣总金额
		Double actualintegral = ((BigDecimal)order.get("ACTUALINTEGRAL")).doubleValue();//实际支付总积分
		Double costmoney = ((BigDecimal)order.get("COSTMONEY")).doubleValue();//成本
		Double productMoney = ((BigDecimal)order.get("SUMPRODUCTPRICE")).doubleValue();
		BigDecimal actualmoney1 = new BigDecimal(actualmoney.toString());
		BigDecimal vouchermoney1 = new BigDecimal(vouchermoney.toString());
		BigDecimal vouchertomoney1 = new BigDecimal(vouchertomoney.toString());
		BigDecimal paidmoney1 = new BigDecimal(paidmoney.toString());
		BigDecimal activitmoney1 = new BigDecimal(activitmoney.toString());
		BigDecimal activittomoney1 = new BigDecimal(activittomoney.toString());
		BigDecimal costmoney1 = new BigDecimal(costmoney.toString());
		Double actualEndMoney = actualmoney1.add(vouchermoney1).add(vouchertomoney1).add(paidmoney1).doubleValue();//实际支付对应总金额
		Double activitEndMoney = activitmoney1.add(activittomoney1).doubleValue();//活动抵扣对应总金额
//		BigDecimal actualEndMoney1 = new BigDecimal(actualEndMoney.toString());
//		BigDecimal activitEndMoney1 = new BigDecimal(activitEndMoney.toString());
//		Double productMoney = actualEndMoney1.add(activitEndMoney1).doubleValue();//商品总价
		BigDecimal productMoney1 = new BigDecimal(productMoney.toString());
		Double grossprofit = productMoney1.subtract(costmoney1).doubleValue();//毛利润
		Map<String,Double> map = new HashMap<String,Double>();
		map.put("productMoney", productMoney);/**商品总价*/
		map.put("costmoney", costmoney);/**成本*/
		map.put("grossprofit", grossprofit);/**毛利润*/
		map.put("actualintegral", actualintegral);/**实际支付总积分*/
		map.put("paidmoney", paidmoney);/**现金支付金额*/
		map.put("actualEndMoney", actualEndMoney);/**实际支付对应总金额*/
		map.put("activitEndMoney", activitEndMoney);/**活动抵扣对应总金额*/
		return map;
	}
	
	@Override
	public int getAreadySaled(String startTime, String overTime) {
		return orderDao.getAreadySaled(startTime, overTime);
	}
}
