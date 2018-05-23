package com.zhb.dataAnalysis.common.repository.database.marketing;

import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository("silkActivityDao")
public interface SilkActivityDao {

	Map<String, Object> getSilkSPUSKUData(@Param("startTime") String startTime, @Param("endTime") String endTime,
										  @Param("data") String data, @Param("activityId") String activityId, @Param("orderSource") String orderSource);

	Map<String, Object> getSilkOrderData(@Param("startTime") String startTime, @Param("endTime") String endTime,
										 @Param("data") String data, @Param("activityId") String activityId, @Param("orderSource") String orderSource);

	Map<String, Object> getSilkPayData(@Param("startTime") String startTime, @Param("endTime") String endTime,
									   @Param("data") String data, @Param("activityId") String activityId, @Param("orderSource") String orderSource);

	Map<String, Object> getSilkRepeData(@Param("startTime") String startTime, @Param("endTime") String endTime,
										@Param("data") String data, @Param("activityId") String activityId, @Param("orderSource") String orderSource);
	
	Map<String, Object> getSilkNewUserData(@Param("startTime") String startTime, @Param("endTime") String endTime,
										   @Param("activityId") String activityId);

	
	
	Map<String, Object> getSilksSPUSKUData(@Param("startTime") String startTime, @Param("endTime") String endTime,
										   @Param("data") String data, @Param("activityId") String activityId, @Param("orderSource") String orderSource);

	Map<String, Object> getSilksOrderData(@Param("startTime") String startTime, @Param("endTime") String endTime,
										  @Param("data") String data, @Param("activityId") String activityId, @Param("orderSource") String orderSource);

	Map<String, Object> getSilksRepeData(@Param("startTime") String startTime, @Param("endTime") String endTime,
										 @Param("data") String data, @Param("activityId") String activityId, @Param("orderSource") String orderSource);

	Map<String, Object> getSilksPayData(@Param("startTime") String startTime, @Param("endTime") String endTime,
										@Param("data") String data, @Param("activityId") String activityId, @Param("orderSource") String orderSource);
}
