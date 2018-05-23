package com.zhb.dataAnalysis.common.repository.database.user;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public interface UserDao {
	/**
	 * 不带分页的查询
	 * 
	 * @return
	 */
	public List<Map<String, Object>> queryTest();

	/**
	 * 带分页的查询
	 * @param startIndex 当前页
	 * @param size 每页显示的条数
	 * @return
	 */
	public List<Map<String, Object>> pageQueryTest(
			@Param("startIndex") int startIndex, @Param("size") int size);
}
