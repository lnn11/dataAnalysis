package com.zhb.dataAnalysis.common.shiro.database;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("tUrlDao")
public interface TUrlDao {

	List<Map<String, Object>> getUrlList();

	int insertRoleUrl(@Param("roleId") String roleId, @Param("id") String id);

	List<Map<String, Object>> getRoleUrlById(@Param("roleId") String roleId);

	/**
	 * 更新菜单
	 * @param menuName
	 * @param parent
	 * @param url
	 * @param sort
	 * @return
	 */
	boolean addMenu(@Param("pk") String pk, @Param("menuName") String menuName, @Param("parent") String parent, @Param("url") String url, @Param("urlType") Integer urlType, @Param("sort") Integer sort);
	boolean updateMenu(@Param("uid") String uid, @Param("menuName") String menuName, @Param("parent") String parent, @Param("url") String url, @Param("urlType") Integer urlType, @Param("sort") Integer sort);
	
	/**
	 * 删除uid对应的节点及子节点
	 * @param uid
	 * @return
	 */
	boolean deleteMenu(@Param("uid") String uid);
}
