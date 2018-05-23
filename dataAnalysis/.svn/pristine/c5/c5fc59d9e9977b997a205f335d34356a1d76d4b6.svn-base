package com.zhb.dataAnalysis.common.repository.database.marketing;

import java.math.BigDecimal;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository("momInfantDao")
public interface MomInfantDao {

	Map<String, BigDecimal> getMomInfantSPUSKU(@Param("startTime") String startTime, @Param("endTime") String endTime,
											   @Param("data") String data, @Param("activityId") String activityId, @Param("orderSource") String orderSource);

	Map<String, BigDecimal> getMomInfantTotal(@Param("startTime") String startTime, @Param("endTime") String endTime,
											  @Param("data") String data, @Param("activityId") String activityId, @Param("orderSource") String orderSource);

	Map<String, BigDecimal> getMomInfantUsertotal(@Param("startTime") String startTime, @Param("endTime") String endTime,
												  @Param("data") String data, @Param("activityId") String activityId, @Param("orderSource") String orderSource);

	Map<String, BigDecimal> getMomInfantUserRepeat(@Param("startTime") String startTime, @Param("endTime") String endTime,
												   @Param("data") String data, @Param("activityId") String activityId, @Param("orderSource") String orderSource);

}
