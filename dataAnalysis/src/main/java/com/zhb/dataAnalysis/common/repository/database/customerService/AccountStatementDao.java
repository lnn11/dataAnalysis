package com.zhb.dataAnalysis.common.repository.database.customerService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author chunjie.huo
 * @time 2017年3月7日 上午9:59:36
 */
@Repository("accountStatementDao")
public interface AccountStatementDao {

	/**
	 * 获取用户的积分明细
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @param userId 用户id
	 * @return List<Map<String,Object>>
	 */
	List<Map<String,String>> getPointsRecord(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("userId") String userId, @Param("company") List<String> company);
	
	/**
	 * 查询下单的用户
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @param currentPage 当前页码
	 * @param pageSize 每页显示多少条数据
	 * @return List<String>
	 */
	List<String> getDownOrderUser(@Param("exchangRate") int exchangRate, @Param("productName") String productName, @Param("singlePoints") BigDecimal singlePoints);
	
	String getMinDate(@Param("userId") String userId);
	
	/**
	 * 查询数据
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @param currentPage 当前页码
	 * @param pageSize 每页显示多少条数据
	 * @return List<String>
	 */
	List<Map<String,String>> getData(@Param("startTime") String startTime, @Param("endTime") String endTime);
	
	List<Map<String,String>> getData2(@Param("startTime") String startTime, @Param("endTime") String endTime);
}
