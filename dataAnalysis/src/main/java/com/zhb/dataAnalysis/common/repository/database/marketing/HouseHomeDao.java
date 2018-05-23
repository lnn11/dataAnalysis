package com.zhb.dataAnalysis.common.repository.database.marketing;

import java.math.BigDecimal;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository("houseHomeDao")
public interface HouseHomeDao {

	Map<String, BigDecimal> getHouseHomeSPUSKU(@Param("startTime") String startTime, @Param("endTime") String endTime,
											   @Param("data") String data, @Param("activityId") String activityId, @Param("orderSource") String orderSource);

	Map<String, BigDecimal> getHouseHomeTotal(@Param("startTime") String startTime, @Param("endTime") String endTime,
											  @Param("data") String data, @Param("activityId") String activityId, @Param("orderSource") String orderSource);

	Map<String, BigDecimal> getHouseHomeUserTotal(@Param("startTime") String startTime, @Param("endTime") String endTime,
												  @Param("data") String data, @Param("activityId") String activityId, @Param("orderSource") String orderSource);

	Map<String, BigDecimal> getHouseHomeUserRepeat(@Param("startTime") String startTime, @Param("endTime") String endTime,
												   @Param("data") String data, @Param("activityId") String activityId, @Param("orderSource") String orderSource);

}
