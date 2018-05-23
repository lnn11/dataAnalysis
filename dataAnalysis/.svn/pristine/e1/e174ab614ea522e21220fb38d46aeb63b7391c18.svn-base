package com.zhb.dataAnalysis.common.shiro.database;

import com.zhb.dataAnalysis.common.shiro.model.TRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 权限验证
 * @author nerowu
 *
 */
@Repository("tAuthorizedDao")
public interface TAuthorizedDao {
	
	/**
	 * 返回id,用户名,密码
	 * @param userName
	 * @return
	 */
	public List<Map<String,String>> findUser(@Param("userName") String userName);
	
	/**
	 * 查找用户对应的角色,存储id,roleName
	 * @param userName
	 * @return
	 */
	public List<Map<String,String>> getRoleNamesForUser(@Param("userId") String userId);
	
	/**
	 * 
	 * @param userName
	 * @param roleNames
	 * @return
	 */
	public List<String> getPermissions(@Param("userId") String userId, @Param("roles") List<TRole> roles);
}
