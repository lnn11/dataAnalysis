package com.zhb.dataAnalysis.common.repository.database.marketing;

import java.math.BigDecimal;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository("duanWuDao")
public interface DuanWuDao {
	/**
	 * 端午节活动SPU SKU
	 * @param startTime
	 * @param endTime
	 * @param data
	 * @param activityId
	 * @param object
	 * @return
	 */
	Map<String, BigDecimal> getDuanWuSPUSKU(@Param("startTime") String startTime, @Param("endTime") String endTime,
											@Param("data") String data, @Param("activityId") String activityId, @Param("orderSource") String orderSource);
	/**
	 * 端午节活动 活动商品总销量   活动主订单总数  活动子订单总数   现金支付总金额  实际支付总积分  福利券支付总积分
	 * @param startTime
	 * @param endTime
	 * @param data
	 * @param activityId
	 * @param object
	 * @return
	 */
	Map<String, BigDecimal> getDuanWuTotal(@Param("startTime") String startTime, @Param("endTime") String endTime,
										   @Param("data") String data, @Param("activityId") String activityId, @Param("orderSource") String orderSource);
	/**
	 * 活动参与人数
	 * @param startTime
	 * @param endTime
	 * @param data
	 * @param activityId
	 * @param object
	 * @return
	 */
	Map<String, BigDecimal> getDuanWuUserTotal(@Param("startTime") String startTime, @Param("endTime") String endTime,
											   @Param("data") String data, @Param("activityId") String activityId, @Param("orderSource") String orderSource);
	/**
	 * 重复参与人数
	 * @param startTime
	 * @param endTime
	 * @param data
	 * @param activityId
	 * @param object
	 * @return
	 */
	Map<String, BigDecimal> getDuanWuUserRepeat(@Param("startTime") String startTime, @Param("endTime") String endTime,
												@Param("data") String data, @Param("activityId") String activityId, @Param("orderSource") String orderSource);

}
