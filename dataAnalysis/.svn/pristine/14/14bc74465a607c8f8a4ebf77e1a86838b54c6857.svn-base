package com.zhb.dataAnalysis.common.repository.database.marketing;

import java.math.BigDecimal;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository("summerSpecialDao")
public interface SummerSpecialDao {

	Map<String, BigDecimal> getSummerSpecialSPUSKU(@Param("startTime") String startTime, @Param("endTime") String endTime,
												   @Param("data") String data, @Param("activityId") String activityId, @Param("orderSource") String orderSource);

	Map<String, BigDecimal> getSummerSpecialTotal(@Param("startTime") String startTime, @Param("endTime") String endTime,
												  @Param("data") String data, @Param("activityId") String activityId, @Param("orderSource") String orderSource);

	Map<String, BigDecimal> getSummerSpecialUserTotal(@Param("startTime") String startTime, @Param("endTime") String endTime,
													  @Param("data") String data, @Param("activityId") String activityId, @Param("orderSource") String orderSource);

	Map<String, BigDecimal> getSummerSpecialUserRepeat(@Param("startTime") String startTime, @Param("endTime") String endTime,
													   @Param("data") String data, @Param("activityId") String activityId, @Param("orderSource") String orderSource);

	Map<String, BigDecimal> getGroupSpuSku(@Param("startTime") String startTime, @Param("endTime") String endTime,
										   @Param("productId") String[] productId, @Param("orderSource") String orderSource);

	Map<String, BigDecimal> getGroupSpecialTotal(@Param("startTime") String startTime, @Param("endTime") String endTime,
												 @Param("productId") String[] productId, @Param("orderSource") String orderSource);

	Map<String, BigDecimal> getGroupUserTotal(@Param("startTime") String startTime, @Param("endTime") String endTime,
											  @Param("productId") String[] productId, @Param("orderSource") String orderSource);

	Map<String, BigDecimal> getGroupUserRepeat(@Param("startTime") String startTime, @Param("endTime") String endTime,
											   @Param("productId") String[] productId, @Param("orderSource") String orderSource);

	Map<String, BigDecimal> getActivityUserCount(@Param("startTime") String startTime, @Param("endTime") String endTime,
												 @Param("activityId") String activityId, @Param("plat") String plat);

	Map<String, BigDecimal> getParticipationData(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("activityType") int activityType);

	Map<String, BigDecimal> getPrizeData(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("activityType") int activityType);

	Map<String, BigDecimal> getEnjoyData(@Param("startTime") String startTime, @Param("endTime") String endTime,
										 @Param("activityId") String activityId);

	Map<String, BigDecimal> getExpendIntegral(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("activityType") int activityType);

	Map<String, BigDecimal> getThanksCount(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("activityType") int activityType);

	Map<String, BigDecimal> getPrizeIntergerCount(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("scoreBoard") String scoreBoard);

	Map<String, BigDecimal> getOtherCount(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("scoreBoard") int scoreBoard, @Param("activityType") int activityType);

	Map<String, BigDecimal> getCouponCount(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("data") int data);

	Map<String, BigDecimal> getCouponCountV2(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("data") int data, @Param("giftId") String giftId);

	Map<String, BigDecimal> getSummerSpecialUserRepeats(@Param("startTime") String startTime, @Param("endTime") String endTime,
														@Param("data") String data, @Param("activityId") String activityId, @Param("orderSource") String orderSource);

	Map<String, BigDecimal> getGroupUserRepeats(@Param("startTime") String startTime, @Param("endTime") String endTime,
												@Param("productId") String[] productId, @Param("orderSource") String orderSource);

	Map<String, BigDecimal> getSummerSpecialUserTotals(@Param("startTime") String startTime, @Param("endTime") String endTime,
													   @Param("data") String data, @Param("activityId") String activityId, @Param("orderSource") String orderSource);

	Map<String, BigDecimal> getGroupUserTotals(@Param("startTime") String startTime, @Param("endTime") String endTime,
											   @Param("productId") String[] productId, @Param("orderSource") String orderSource);

	Map<String, BigDecimal> getOrderCouponPastPrice(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("giftId") String giftId);

	Map<String, Object> getLuckDrawCount(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("type") String type);

	Map<String, Object> getIntegralSum(@Param("startTime") String startTime, @Param("endTime") String endTime);

	Map<String, BigDecimal> getCouponCountAdvance(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("data") int data, @Param("giftId") String giftId);

	Map<String, BigDecimal> getCouponGetCollarRed(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("data") int data, @Param("giftId") String giftId);

	Map<String, BigDecimal> getCouponGetCollar315mini(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("data") int data, @Param("giftId") String giftId);

	Map<String, BigDecimal> getAdvanceSum(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("type") int type, @Param("freeType") int freeType);

	Map<String, BigDecimal> getShares(@Param("startTime") String startTime, @Param("endTime") String endTime);

	Map<String, BigDecimal> getAdvanceIntegralRecord(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("activityType") String activityType, @Param("lx") String lx);

	Map<String, BigDecimal> getAdvance2018Integral(@Param("startTime") String startTime, @Param("endTime") String endTime);

	Map<String, BigDecimal> getOrderCouponPastPriceAdvance(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("giftId") String giftId);

	Map<String, BigDecimal> getOrderCouponPastPriceAdvanceByGetCollarRed(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("giftId") String giftId);

	Map<String, BigDecimal> getOrderCouponPastPriceAdvanceByGet315mini(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("giftId") String giftId);

	Map<String,BigDecimal> getPlayGamesTotal(@Param("activityId") String activityId, @Param("startTime") String startTime, @Param("endTime") String endTime);
}
