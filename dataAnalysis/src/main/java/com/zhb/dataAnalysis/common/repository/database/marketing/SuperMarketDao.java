package com.zhb.dataAnalysis.common.repository.database.marketing;

import java.math.BigDecimal;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository("superMarketDao")
public interface SuperMarketDao {

	Map<String, BigDecimal> getSuperMarketSPUSKU(@Param("startTime") String startTime, @Param("endTime") String endTime,
												 @Param("data") String data, @Param("activityId") String activityId, @Param("orderSource") String orderSource);

	Map<String, BigDecimal> getSuperMarketTotal(@Param("startTime") String startTime, @Param("endTime") String endTime,
												@Param("data") String data, @Param("activityId") String activityId, @Param("orderSource") String orderSource);

	Map<String, BigDecimal> getSuperMarketUserTotal(@Param("startTime") String startTime, @Param("endTime") String endTime,
													@Param("data") String data, @Param("activityId") String activityId, @Param("orderSource") String orderSource);

	Map<String, BigDecimal> getSuperMarketUserRepeat(@Param("startTime") String startTime, @Param("endTime") String endTime,
													 @Param("data") String data, @Param("activityId") String activityId, @Param("orderSource") String orderSource);


}
