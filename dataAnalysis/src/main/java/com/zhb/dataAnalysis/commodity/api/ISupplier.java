package com.zhb.dataAnalysis.commodity.api;

import java.util.List;
import java.util.Map;

/**
 * @author chunjie.huo
 * @time 2016年12月7日 下午2:09:27
 * 作用:供应商接口
 */
public interface ISupplier {

	/**
	 * 各供应商的销量
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @param currentPage 当前页码
	 * @param size 每页显示数据量
	 * @return List<Map<String,Object>>
	 */
	List<Map<String,Object>> getSupplierSalesNum(
			String startTime, String overTime, int currentPage, int pageSize);
	/**
	 * 各供应商的总数据量
	 * @param startTime 开始时间
	 * @param overTime 结束时间
	 * @return int
	 */
	int getSupplierCount(String startTime, String overTime);
	
	/**
	* 某时间段内所有供应商销量之和
	* @param startTime 开始时间
	* @param overTime 结束时间
	* @return int
	*/
	int getAllSupplierSumSales(String startTime, String overTime);
	
	/**
	 * 各供应商的销售额
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @param currentPage 当前页码
	 * @param size 每页显示数据量
	 * @return List<Map<String,Object>>
	 */
	List<Map<String,Object>> getSupplierSalesVoles(
			String startTime, String overTime, int currentPage, int pageSize);
	/**
	 * 各供应商的销售额总数据量
	 * @param startTime 开始时间
	 * @param overTime 结束时间
	 * @return int
	 */
	int getSupplierSalesCount(String startTime, String overTime);
	
	/**
	 * 某时间段内所有供应商销售额之和
	 * @param startTime 开始时间
	 * @param overTime 结束时间
	 * @return int
	 */
	double getAllSupplierSalesVolues(String startTime, String overTime);
	
	/**
	 * 查询相应发货时段的各供应商销售额之和以及订单总数
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @param currentPage 当前页码
	 * @param size 每页显示数据量
	 * @param workingDayNum 超过工作日天数
	 * @return List<Map<String,Object>>
	 */
	List<Map<String,Object>> getSupplierDeliverGoodsSpeed(
			int workingDayNum, String startTime, String overTime, int currentPage, int pageSize);
	
	/**
	 * 相应发货时段的各供应商销售额之和以及订单总数的总条数
	 * @param startTime 开始时间
	 * @param overTime 结束时间
	 * @return int
	 */
	int getSupplierDeliverGoodsSpeedCount(String startTime, String overTime);
	
	/**
	 * 供应商总数
	 * @param startTime 开始时间
	 * @param overTime 结束时间
	 * @return int
	 */
	int getSupplierCountNum(String startTime, String overTime);
}
