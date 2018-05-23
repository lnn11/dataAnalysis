package com.zhb.dataAnalysis.common.shiro.api;

import com.zhb.dataAnalysis.common.shiro.model.TRole;

import java.util.List;

public interface TAuthorizedService {
	
	/**
	 * 通过用户id获取对应的角色名称
	 * @param userId
	 * @return
	 */
	public List<TRole> getRoleNamesForUser(String userId);
	
	/**
	 * 通过用户id获取可访问的url
	 * @param userId
	 * @return
	 */
	public List<String> getPermissions(String userId, List<TRole> roles);
}
