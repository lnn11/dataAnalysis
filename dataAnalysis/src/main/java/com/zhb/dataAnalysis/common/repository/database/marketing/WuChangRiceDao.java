package com.zhb.dataAnalysis.common.repository.database.marketing;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository("wuChangRiceDao")
public interface WuChangRiceDao {

	List<Map<String, String>> getChannel(@Param("startTime") String startTime, @Param("endTime") String endTime);

	BigDecimal getChannelCount(@Param("startTime") String startTime, @Param("endTime") String endTime);

	Map<String, BigDecimal> getTicketCount(@Param("startTime") String startTime, @Param("endTime") String endTime,
										   @Param("data") String data, @Param("activityId") String activityId);

	Map<String, BigDecimal> getRegisterUser(@Param("startTime") String startTime, @Param("endTime") String endTime,
											@Param("data") String data, @Param("activityId") String activityId);

	Map<String, BigDecimal> getBuyNumPayCash(@Param("startTime") String startTime, @Param("endTime") String endTime,
											 @Param("data") String data, @Param("activityId") String activityId);

	String getChannelName(@Param("data") String data);

	Map<String, BigDecimal> getRedeemCode();

	Map<String, BigDecimal> getRedeemCodeCount(@Param("startTime") String startTime, @Param("endTime") String endTime,
											   @Param("data") String data);

	List<Map<String, String>> getChannelRice(@Param("startTime") String startTime, @Param("endTime") String endTime);

	Map<String, BigDecimal> getRedeemCount(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("data") String data);

	/**
	 * 优惠券的数量
	 * @param date 
	 * @return
	 */
	Map<String, BigDecimal> getCouponUser(@Param("status") Integer status);
	
}
