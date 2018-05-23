package com.zhb.dataAnalysis.common.shiro.service;

import com.alibaba.fastjson.JSON;
import com.zhb.dataAnalysis.common.repository.redis.RDict;
import com.zhb.dataAnalysis.common.shiro.api.TUserService;
import com.zhb.dataAnalysis.common.shiro.database.TAuthorizedDao;
import com.zhb.dataAnalysis.common.shiro.database.TUserDao;
import com.zhb.dataAnalysis.common.shiro.model.TRole;
import com.zhb.dataAnalysis.common.shiro.model.TUser;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("tUserServiceImpl")
public class TUserServiceImpl implements TUserService {
	
	@Resource(name = "tUserDao")
	private TUserDao tUserDao;
	
	@Resource(name = "rDict")
	private RDict rDict;
	
	@Resource(name = "tAuthorizedDao")
	private TAuthorizedDao tAuthorizedDao;
	

	/**
	 * 用户列表
	 */
	@Override
	public List<TUser> getUserList(int rows, int page) {
		List<TUser> userList = tUserDao.userList(rows, page);
		return userList;
	}

	/**
	 * 用户总条数
	 */
	@Override
	public int getCount() {
		return tUserDao.getCount();
	}

	/**
	 * 用户删除
	 */
	@Override
	public Boolean delUser(String id) {
		int i = tUserDao.delUser(id);
		if (i>0) {
			tUserDao.delUserRole(id);
			return true;
		}
		return false;
	}

	/**
	 * 用户添加
	 */
	@Override
	public Boolean insertUser(TUser user) {
		int i = tUserDao.insertUser(user);
		if (i>0) { 
			if(user.getRoleName() != null && user.getRoleName() != "") { 
				List<TUser> list= tUserDao.getLastUser(); 
				TUser u = list.get(0); 
				String[] roles = user.getRoleName().split(","); 
				int j = 0;
				for (String role : roles) { 
					j = tUserDao.insertUserRole(role,u.getId()); 
				} 
				if (j>0) {
					return true;
				}
			} 
			return true; 
		}
		return false;
	}

	/**
	 * 用户根据id进行回显
	 */
	@Override
	public TUser getUserById(String id) {
		TUser t = tUserDao.getUserById(id);
		List<Map<String, Object>> list = tUserDao.getUserRoleById(id);
		for (Map<String, Object> map : list) {
			if (map != null) {
				t.setRoleName(map.get("ROLENAME").toString());
				t.setRoles(map.get("ROLES").toString());
			}
		}
		return t;
	}
	/** 
	 * 用户修改
	 * 
	 */

	@Override
	public Boolean updateUser(TUser user) {
		int i = tUserDao.updateUser(user);
		tUserDao.delUserRole(user.getId());
		if (i>0) {
			if (user.getRoleName()!=null && user.getRoleName() != "") {
				String[] roles = user.getRoleName().split(","); 
				List<TRole> list = new ArrayList<TRole>();
				int j = 0;
				for (String role : roles) {
					TRole tRole = new TRole();
					tRole.setId(role);
					list.add(tRole);
					j = tUserDao.insertUserRole(role,user.getId()); 
				} 
				List<Map<String,String>> listMap = tAuthorizedDao.getRoleNamesForUser(user.getId());
				if(listMap != null && listMap.size() > 0){
					String jsonArray = JSON.toJSONString(listMap);
					rDict.setAuthorizedHash(RDict.ROLENAMESFORUSER,user.getId(),jsonArray);
				}
				List<String> list1 = tAuthorizedDao.getPermissions(user.getId(), list);
				String jsonArray = JSON.toJSONString(list1);
				rDict.setAuthorizedHash(RDict.PERMISSIONS, user.getId(), jsonArray);
				if (j>0) {
					return true;
				}
			}
			return true;
		}
		return false;
	}

	/**
	 * 验证用户名唯一
	 */
	@Override
	public List<TUser> getByName(String userName) {
		
		return tUserDao.getByName(userName);
	}

	//根据用户名查找用户信息
	@Override
	public TUser getUserByName(String username) {
		
		return tUserDao.getUserByName(username);
	}
	//修改用户密码
	@Override
	public Boolean updateUserPassword(TUser tUser) {
		int i = tUserDao.updateUser(tUser);
		if(i>0) {
			return true;
		}
		return false;
	}

	/**
	 *验证旧密码是否正确 
	 */
	public Boolean checkPassword(String id, String password) {
		List<TUser> tUser = tUserDao.checkPassword(id,password);
		if(tUser.size()>0) {
			return true;
		}
		return false;
	}

}
