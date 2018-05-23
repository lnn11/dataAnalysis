package com.zhb.dataAnalysis.common.repository.database.supplier;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository("supplierDao")
public interface SupplierDao {

	/**
	 * 各供应商的销量
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @param currentPage 当前页码
	 * @param pageSize 每页显示数据量
	 * @return List<Map<String,Object>>
	 */
	List<Map<String,Object>> getSupplierSalesNum(
			@Param("startTime") String startTime, @Param("overTime") String overTime,
			@Param("currentPage") int currentPage, @Param("pageSize") int pageSize);
	
	/**
	 * 各供应商销量的总条数
	 * @param startTime 起始时间
	 * @param overTime 结束时间
	 * @return int
	 */
	int getSupplierCount(
			@Param("startTime") String startTime, @Param("overTime") String overTime);
	
	/**
	 * 某时间段内所有供应商销量之和
	 * @param startTime 起始时间
	 * @param overTime 结束时间
	 * @return int
	 */
	int getAllSupplierSumSales(
			@Param("startTime") String startTime, @Param("overTime") String overTime);
	
	/**
	 * 各供应商的销售额之和
	 * @param startTime 开始时间
	 * @param overTime 结束时间
	 * @param currentPage 当前页码
	 * @param pageSize 每页数据量
	 * @return List<Map<String,Object>>
	 */
	List<Map<String,Object>> getSupplierSalesVoles(
			@Param("startTime") String startTime, @Param("overTime") String overTime,
			@Param("currentPage") int currentPage, @Param("pageSize") int pageSize);
	
	/**
	 * 某时间段内所有供应商销售额之和
	 * @param startTime 起始时间
	 * @param overTime 结束时间
	 * @return int
	 */
	double getAllSupplierSalesVolues(
			@Param("startTime") String startTime, @Param("overTime") String overTime);
	
	/**
	 * 各供应商销售额的总条数
	 * @param startTime 起始时间
	 * @param overTime 结束时间
	 * @return int
	 */
	int getSupplierSalesCount(
			@Param("startTime") String startTime, @Param("overTime") String overTime);
	
	/**
	 * 查询相应发货时段的各供应商销售额之和以及订单总数
	 * @param startTime 开始时间
	 * @param overTime 结束时间
	 * @param workingDayNum 超过工作日天数
	 * @param currentPage 当前页码
	 * @param pageSize 每页显示数据量
	 * @return List<Map<String,Object>>
	 */
	List<Map<String,Object>> getSupplierDeliverGoodsSpeed(@Param("workingDayNum") int workingDayNum,
														  @Param("startTime") String startTime, @Param("overTime") String overTime,
														  @Param("currentPage") int currentPage, @Param("pageSize") int pageSize);
	
	/**
	 * 相应发货时段的各供应商有订单的总条数
	 * @param startTime 起始时间
	 * @param overTime 结束时间
	 * @return int
	 */
	int getSupplierDeliverGoodsSpeedCount(
			@Param("startTime") String startTime, @Param("overTime") String overTime);
	
	/**
	 * 审核通过的供应商总数
	 * @param startTime 起始时间
	 * @param overTime 结束时间
	 * @return int
	 */
	int getSupplierCountNum(
			@Param("startTime") String startTime, @Param("overTime") String overTime);
}