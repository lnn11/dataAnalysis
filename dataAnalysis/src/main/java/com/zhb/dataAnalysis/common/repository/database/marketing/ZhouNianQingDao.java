package com.zhb.dataAnalysis.common.repository.database.marketing;

import java.math.BigDecimal;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository("zhouNianQingDao")
public interface ZhouNianQingDao {

	Map<String, BigDecimal> getZhouNianQingSPUSKU(@Param("startTime") String startTime, @Param("endTime") String endTime,
												  @Param("data") String data, @Param("activityId") String activityId, @Param("orderSource") String orderSource);

	Map<String, BigDecimal> getZhouNianQingTotal(@Param("startTime") String startTime, @Param("endTime") String endTime,
												 @Param("data") String data, @Param("activityId") String activityId, @Param("orderSource") String orderSource);

	Map<String, BigDecimal> getZhouNianQingUserTotal(@Param("startTime") String startTime, @Param("endTime") String endTime,
													 @Param("data") String data, @Param("activityId") String activityId, @Param("orderSource") String orderSource);

	Map<String, BigDecimal> getZhouNianQingUserRepeat(@Param("startTime") String startTime, @Param("endTime") String endTime,
													  @Param("data") String data, @Param("activityId") String activityId, @Param("orderSource") String orderSource);

}
