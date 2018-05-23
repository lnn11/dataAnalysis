package com.zhb.dataAnalysis.common.repository.database.order;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zhb.dataAnalysis.common.repository.database.model.OrderModel;

@Repository("orderDao")
public interface OrderDao {

	List<OrderModel> orderTotalList(@Param("orderYear") String orderYear);

	List<Map<String, String>> orderSupplierList(@Param("prevDateOrder") String prevDateOrder,
												@Param("nextDateOrder") String nextDateOrder);

	List<OrderModel> orderTotalSaleList(@Param("orderYear") String orderYear);

	List<Map<String, String>> orderSupplierSaleList(@Param("prevDateOrder") String prevDateOrder,
													@Param("nextDateOrder") String nextDateOrder);

	int getCount(@Param("prevDateOrder") String prevDateOrder, @Param("nextDateOrder") String nextDateOrder);

	List<Map<String, String>> supplierList(@Param("prevDateOrder") String prevDateOrder,
										   @Param("nextDateOrder") String nextDateOrder);

	int orderCount(@Param("prevDateOrder") String prevDateOrder,
				   @Param("nextDateOrder") String nextDateOrder);

	List<Map<String, Integer>> orderSaleCount(@Param("prevDateOrder") String prevDateOrder,
											  @Param("nextDateOrder") String nextDateOrder);

	List<Map<String, String>> orderListBySup(@Param("supList") List<Map<String, String>> supList,
											 @Param("prevDateOrder") String prevDateOrder, @Param("nextDateOrder") String nextDateOrder);

	List<Map<String, String>> orderSaleListBySup(@Param("supList") List<Map<String, String>> supList,
												 @Param("prevDateOrder") String prevDateOrder, @Param("nextDateOrder") String nextDateOrder);
	
	/**
	 * 订单函数
	 * @param startTime 开始时间
	 * @param overTime 结束时间
	 * @return int
	 */
	int getReturnedOrder(@Param("startTime") String startTime, @Param("overTime") String overTime, @Param("status") int i);
	
	/**
	 * 查询总体销售业绩指标
	 * @param startTime 开始时间
	 * @param overTime 结束时间
	 * @return Map<String,Object>
	 */
	Map<String,Object> getAreadyPaidOrder(@Param("startTime") String startTime, @Param("overTime") String overTime);
	
	/**
	 * 已售出商品总数
	 * @param startTime 开始时间
	 * @param overTime 结束时间
	 * @return int
	 */
	int getAreadySaled(@Param("startTime") String startTime, @Param("overTime") String overTime);

}
