package com.zhb.dataAnalysis.common.shiro.database;

import com.zhb.dataAnalysis.common.shiro.model.TRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("tRoleDao")
public interface TRoleDao {

	List<TRole> getRoleList();

	List<TRole> getRoleLists(@Param("rows") int rows, @Param("page") int page);

	int getCount();

	int insertRole(TRole role);

	TRole getRoleById(@Param("id") String id);

	int updateRole(TRole role);

	int delRole(@Param("id") String id);

	void delRoleUrl(@Param("id") String id);

	List<TRole> getByRoleName(@Param("roleName") String roleName);

	List<String> getUserIdByRoleId(@Param("roleId") String roleId);

}
