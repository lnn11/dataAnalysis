package com.zhb.dataAnalysis.common.shiro.service;


import com.zhb.dataAnalysis.common.shiro.api.TRoleService;
import com.zhb.dataAnalysis.common.shiro.database.TRoleDao;
import com.zhb.dataAnalysis.common.shiro.model.TRole;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.List;

@Service("tRoleServiceImpl")
public class TRoleServiceImpl implements TRoleService {

	@Resource(name="tRoleDao")
	private TRoleDao tRoleDao;
	
	/**
	 * 角色下拉框
	 */
	@Override
	public List<TRole> getRoleList() {
		List<TRole> list= tRoleDao.getRoleList();
		return list;
	}

	/**
	 * 角色列表
	 */
	@Override
	public List<TRole> getRoleLists(int rows, int page) {
		List<TRole> list= tRoleDao.getRoleLists(rows, page);
		return list;
	}

	/**
	 * 角色总数
	 */
	@Override
	public int getCount() {
		return tRoleDao.getCount();
	}

	/**
	 * 角色添加
	 */
	@Override
	public Boolean insertRole(TRole role) {
		int i = tRoleDao.insertRole(role);
		if(i>0){
			return true;
		}
		return false;
	}

	/**
	 * 根据角色id查找角色
	 */
	@Override
	public TRole getRoleById(String id) {
		return tRoleDao.getRoleById(id);
	}

	/**
	 * 修改角色
	 */
	@Override
	public Boolean updateRole(TRole role) {
		int i = tRoleDao.updateRole(role);
		if(i>0) {
			return true;
		}
		return false;
	}

	/**
	 * 角色删除
	 */
	@Override
	public Boolean delRole(String id) {
		int i = tRoleDao.delRole(id);
		if (i>0) {
			tRoleDao.delRoleUrl(id);
			return true;
		}
		return false;
	}

	/**
	 * 验证角色名唯一
	 */
	@Override
	public List<TRole> getByRoleName(String roleName) {

		return tRoleDao.getByRoleName(roleName);
	}


}
