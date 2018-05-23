package com.zhb.dataAnalysis.common.shiro.api;

import com.zhb.dataAnalysis.common.shiro.model.TUser;

import java.util.List;


/**
 * 用户接口
 * @author nerowu
 *
 */
public interface TUserService {

	List<TUser> getUserList(int rows, int page);

	int getCount();
	
	Boolean delUser(String id);
	
	Boolean insertUser(TUser user);
	
	TUser getUserById(String id);
	
	Boolean updateUser(TUser user);

	List<TUser> getByName(String userName);

	//根据用户名查找用户信息
	TUser getUserByName(String username);
	//修改用户密码
	Boolean updateUserPassword(TUser tUser);
	//验证旧密码是否正确
	Boolean checkPassword(String id, String password);
	
}
