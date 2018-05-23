package com.zhb.dataAnalysis.common.repository.database.userInfo;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository("userInfoDao")
public interface UserInfoDao {

	/**
	 * 激活会员总数
	 * @param startTime 开始时间
	 * @param overTime 结束时间
	 * @return int
	 */
	int activationMemberCount(@Param("startTime") String startTime, @Param("overTime") String overTime);
	
	/**
	 * 注册会员总数
	 * @param startTime 开始时间
	 * @param overTime 结束时间
	 * @return int
	 */
	int registernMemberCount(@Param("startTime") String startTime, @Param("overTime") String overTime);
	
	/**
	 * 已认证会员总数
	 * @param startTime 开始时间
	 * @param overTime 结束时间
	 * @return int
	 */
	int authenticationMemberCount(@Param("startTime") String startTime, @Param("overTime") String overTime);
	
	/**
	 * 会员总数
	 * @param startTime 开始时间
	 * @param overTime 结束时间
	 * @return int
	 */
	int memberCount(@Param("startTime") String startTime, @Param("overTime") String overTime, @Param("identifi") int i);
}