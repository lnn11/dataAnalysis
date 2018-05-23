package com.zhb.dataAnalysis.commodity.api;

import java.util.List;
import java.util.Map;

import com.zhb.dataAnalysis.common.repository.database.model.OrderModel;

public interface OrderService {

	List<OrderModel> orderTotalList(String orderYear);

	Map<String,Object> orderSupplierList(String prevDateOrder, String nextDateOrder, int currentPage, int pageSize);

	Map<String,Object> getSupplierByPage(List<Map<String, String>> supplierList, int currentPage, int pageSize, String prevDateOrder, String nextDateOrder);
	
	/**
	 * 订单函数
	 * @param startTime 开始时间
	 * @param overTime 结束时间
	 * @return int
	 */
	Map<String, Object> getReturnedOrder(String startTime, String overTime);
	
	/**
	 * 总体销售业绩指标
	 * @param startTime 开始时间
	 * @param overTime 结束时间
	 * @return Map<String, Double>
	 */
	Map<String, Double> getAreadyPaidOrder(String startTime, String overTime);
	
	/**
	 * 已售出商品总数
	 * @param startTime 开始时间
	 * @param overTime 结束时间
	 * @return int
	 */
	int getAreadySaled(String startTime, String overTime);
}
