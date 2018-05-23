package com.zhb.dataAnalysis.common.shiro.service;

import com.alibaba.fastjson.JSON;
import com.zhb.dataAnalysis.common.repository.redis.RDict;
import com.zhb.dataAnalysis.common.shiro.api.TUrlService;
import com.zhb.dataAnalysis.common.shiro.database.TAuthorizedDao;
import com.zhb.dataAnalysis.common.shiro.database.TRoleDao;
import com.zhb.dataAnalysis.common.shiro.database.TUrlDao;
import com.zhb.dataAnalysis.common.shiro.model.PrivilegeVo;
import com.zhb.dataAnalysis.common.shiro.model.TRole;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service("tUrlServiceImpl")
public class TUrlServiceImpl implements TUrlService {
	
	@Resource(name="tUrlDao")
	private TUrlDao tUrlDao;
	
	@Resource(name="tRoleDao")
	private TRoleDao tRoleDao;
	
	@Resource(name = "rDict")
	private RDict rDict;
	
	@Resource(name = "tAuthorizedDao")
	private TAuthorizedDao tAuthorizedDao;
	
	@Override
	public void test() {
		System.out.println("sdfdsfds");
	}

	/**
	 * 权限路径列表
	 */
	@Override
	public List<PrivilegeVo> getUrlList() {
		List<Map<String,Object>> role = tUrlDao.getUrlList();
		List<PrivilegeVo> list = new ArrayList<PrivilegeVo>();
		for (Map<String, Object> map : role) {
			PrivilegeVo privilegeVo = new PrivilegeVo();
			privilegeVo.setId(map.get("ID").toString());			
			privilegeVo.setName(map.get("URLNAME").toString());
			
			if(map.get("PARENTID") != null){
				privilegeVo.setPid(map.get("PARENTID").toString());
			}			
			if(map.get("URL") != null){
				privilegeVo.setUrlVal(map.get("URL").toString());
			}			
			if(map.get("SORT") != null){
				privilegeVo.setSortVal(((BigDecimal)map.get("SORT")).intValue());
			}
			privilegeVo.setOpen(true);
			list.add(privilegeVo);
		}
		return list;
	}

	/**
	 * 给角色赋权限
	 */
	@Override
	public Boolean insertRoleUrl(String roleId, String urlIds) {
		String[] urlId = urlIds.split(",");
		tRoleDao.delRoleUrl(roleId);
		TRole tRole = new TRole();
		tRole.setId(roleId);
		List<TRole> list = new ArrayList<TRole>();
		list.add(tRole);
		List<String> userId = tRoleDao.getUserIdByRoleId(roleId);
		if(userId.size() == 0) {
			return false;
		}
		int i = 0;
		for (String id : urlId) {
			i = tUrlDao.insertRoleUrl(roleId, id);
		}
		for (String string : userId) {
			List<String> list1 = tAuthorizedDao.getPermissions(string, list);
			String jsonArray = JSON.toJSONString(list1);
			rDict.setAuthorizedHash(RDict.PERMISSIONS, string, jsonArray);
			
		}
		if (i>0) {
			return true;
		}
		return false;
	}

	/**
	 * 根据角色id查找权限
	 */
	@Override
	public List<Map<String, Object>> getRoleUrlById(String roleId) {
		return tUrlDao.getRoleUrlById(roleId);
	}

	@Override
	public String updateMenu(String uid, String menuName, String parent, String url, Integer sort,String oper) {
		if(StringUtils.isNotBlank(oper)){
			if(oper.equals("edit")){
				tUrlDao.updateMenu(uid, menuName, parent, url, null, sort);
				return uid;
			}else if(oper.equals("add")){
				String pk = UUID.randomUUID().toString().replaceAll("-", "");
				tUrlDao.addMenu(pk,menuName, uid, url, null, sort);
				return pk;
			}
		}
		return null;
	}
	
	@Override
	public boolean deleteMenu(String uid) {
		return tUrlDao.deleteMenu(uid);
	}
}
