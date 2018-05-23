package com.zhb.dataAnalysis.common.repository.database.marketing;

import java.math.BigDecimal;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository("nanguaGirlDao")
public interface NanguaGirlDao {
	/**
	 * 南瓜姑娘活动，获取SPU,SKU
	 * 
	 * @param startTime
	 * @param endTime
	 * @param activityId
	 * @return
	 */
	Map<String, BigDecimal> getNanguaGirlSPU(@Param("startTime") String startTime, @Param("endTime") String endTime,
											 @Param("activityId") String activityId, @Param("platform") String platform);
	
	/**
	 * [活动商品总销量] [活动主订单总数] [活动子订单总数] [现金支付总金额] [实际支付总积分] [福利券支付总积分]
	 * @param startTime
	 * @param endTime
	 * @param activityId
	 * @return
	 */
	Map<String,BigDecimal> getNanguaGirlTotal(@Param("startTime") String startTime, @Param("endTime") String endTime,
											  @Param("activityId") String activityId, @Param("platform") String platform);
	
	/**
	 * [活动参与总人数]
	 * @param startTime
	 * @param endTime
	 * @param activityId
	 * @param platform
	 * @return
	 */
	Map<String,BigDecimal> getNanguaGirlUserTotal(@Param("startTime") String startTime, @Param("endTime") String endTime,
												  @Param("activityId") String activityId, @Param("platform") String platform);
	
	/**
	 * [重复参与人数]
	 * @param startTime
	 * @param endTime
	 * @param activityId
	 * @return
	 */
	public Map<String,BigDecimal> getNanguaGirlUserRepeat(@Param("startTime") String startTime, @Param("endTime") String endTime,
														  @Param("activityId") String activityId, @Param("platform") String platform);
	
	/**
	 * [新增会员数]
	 * @param startTime
	 * @param endTime
	 * @param activityId
	 * @return
	 */
	public Map<String,BigDecimal> getNanguaGirlUserAdd(@Param("startTime") String startTime, @Param("endTime") String endTime);
}
