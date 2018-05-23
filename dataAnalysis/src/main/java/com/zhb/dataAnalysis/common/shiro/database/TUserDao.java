package com.zhb.dataAnalysis.common.shiro.database;

import com.zhb.dataAnalysis.common.shiro.model.TUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("tUserDao")
public interface TUserDao {
	List<TUser> queryTest();

	List<TUser> userList(@Param("rows") int rows, @Param("page") int page);

	int getCount();

	int delUser(@Param("id") String id);

	int insertUser(TUser user);

	List<TUser> getLastUser();

	int insertUserRole(@Param("role") String role, @Param("id") String id);

	TUser getUserById(@Param("id") String id);

	List<Map<String, Object>> getUserRoleById(@Param("id") String id);

	int updateUser(TUser user);

	int delUserRole(@Param("id") String id);

	List<TUser> getByName(@Param("userName") String userName);

	TUser getUserByName(@Param("username") String username);

	List<TUser> checkPassword(@Param("id") String id, @Param("password") String password);
}
