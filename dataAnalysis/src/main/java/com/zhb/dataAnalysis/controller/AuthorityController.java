package com.zhb.dataAnalysis.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhb.dataAnalysis.common.shiro.api.TRoleService;
import com.zhb.dataAnalysis.common.shiro.api.TUrlService;
import com.zhb.dataAnalysis.common.shiro.api.TUserService;
import com.zhb.dataAnalysis.common.shiro.model.PrivilegeVo;
import com.zhb.dataAnalysis.common.shiro.model.TRole;
import com.zhb.dataAnalysis.common.shiro.model.TUser;


@Controller
@RequestMapping("/authority")
public class AuthorityController {
	
	@Resource(name="tUrlServiceImpl")
	private TUrlService tUrlService;
	
	@Resource(name="tUserServiceImpl")
	private TUserService tUserService;
	
	@Resource(name="tRoleServiceImpl")
	private TRoleService tRoleService;

	@RequestMapping("/authorized")
	public String toAuthorized(){
		return "aiPinXuan/authority";
	}
	
	/**
	 * 用户列表
	 * @return
	 */
	
	@RequestMapping("getUserList")
	@ResponseBody
	public Map<String,Object> getUserList(int rows, int page) {
		Map<String,Object> map = new HashMap<String, Object>();
		int count = tUserService.getCount();
		List<TUser> list = tUserService.getUserList(rows,page);
		map.put("total", count);
		map.put("rows", list);
		return map;
	}
	/**
	 * 用户添加
	 */
	@RequestMapping("insertUser")
	@ResponseBody
	public boolean insertUser(TUser user) {
		user.setPassword(new Sha256Hash(user.getPassword(), user.getUserName()).toBase64());
		Boolean flag = tUserService.insertUser(user);
		return flag;
	}
	/**
	 * 验证用户名唯一
	 */
	@RequestMapping("getByName")
	@ResponseBody
	public Boolean getByName(String userName) {
		List<TUser> list = tUserService.getByName(userName);
		if (list.size()>0) {
			return false;
		}
		return true;
	}
	/**
	 * 用户修改
	 */
	@RequestMapping("updateUser")
	@ResponseBody
	public boolean updateUser(TUser user) {
		if(StringUtils.isNotBlank(user.getPassword())) {
			user.setPassword(new Sha256Hash(user.getPassword(), user.getUserName()).toBase64());
		}else{
			user.setPassword(null);
		}
		Boolean flag = tUserService.updateUser(user);
		return flag;
	}
	/**
	 * 用户删除
	 */
	@RequestMapping("delUser")
	@ResponseBody
	public boolean delUser(String id) {
		Boolean flag = tUserService.delUser(id);
		return flag;
	}
	/**
	 * 根据id查询用户
	 */
	@RequestMapping("getUserById")
	@ResponseBody
	public TUser getUserById(String id) {
		TUser user = tUserService.getUserById(id);
		return user;
	}
	/**
	 * 角色下拉框
	 * @return
	 */
	@RequestMapping("getRoleList")
	@ResponseBody
	public List<TRole> getRoleList() {
		List<TRole> list = tRoleService.getRoleList();
		return list;
	}
	/**
	 * 角色列表
	 */
	@RequestMapping("getRoleLists")
	@ResponseBody
	public Map<String,Object> getRoleLists(int rows, int page) {
		Map<String,Object> map = new HashMap<String, Object>();
		int count = tRoleService.getCount();
		List<TRole> list = tRoleService.getRoleLists(rows,page);
		map.put("total", count);
		map.put("rows", list);
		return map;
	}
	/**
	 * 角色添加
	 */
	@RequestMapping("insertRole")
	@ResponseBody
	public Boolean insertRole(TRole role) {
		return tRoleService.insertRole(role);
	}
	/**
	 * 根据id查新角色
	 */
	@RequestMapping("getRoleById")
	@ResponseBody
	public TRole getRoleById(String id) {
		return tRoleService.getRoleById(id);
	}
	/**
	 * 验证角色名唯一
	 */
	@RequestMapping("getByRoleName")
	@ResponseBody
	public Boolean getByRoleName(String roleName) {
		List<TRole> list = tRoleService.getByRoleName(roleName);
		if(list.size()>0){
			return false;
		}
		return true;
	}
	/**
	 * 角色修改
	 */
	@RequestMapping("updateRole")
	@ResponseBody
	public Boolean updateRole(TRole role) {
		return tRoleService.updateRole(role);
	}
	/**
	 * 角色删除
	 */
	@RequestMapping("delRole")
	@ResponseBody
	public Boolean delRole(String id) {
		return tRoleService.delRole(id);
	}
	/**
	 * 权限列表
	 */
	@RequestMapping("getUrlList")
	@ResponseBody
	public List<PrivilegeVo> getUrlList() {
		return tUrlService.getUrlList();
	}
	/**
	 * 点击查看跳转到权限管理
	 */
	@RequestMapping("powerManarger")
	public String powerManarger(HttpServletRequest request) {
		String id = request.getParameter("id");
		TRole role = tRoleService.getRoleById(id);
		request.setAttribute("role", role);
		return "aiPinXuan/authority/center/powerManarger";
	}
	/**
	 * 跳转到权限管理查询角色
	 */
	@RequestMapping("center/powerManarger")
	public String powerManargerRoles(HttpServletRequest request) {
		
		return "aiPinXuan/authority/center/powerManarger";
	}
	/**
	 * 给角色赋予权限
	 */
	@RequestMapping("insertRoleUrl")
	@ResponseBody
	public Boolean insertRoleUrl(String roleId, String urlIds) {
		return tUrlService.insertRoleUrl(roleId, urlIds);
	}
	/**
	 * 查询角色的权限
	 */
	@RequestMapping("getRoleUrlById")
	@ResponseBody
	public List<PrivilegeVo> getRoleUrlById(String roleId) {
		List<Map<String, Object>> role = tUrlService.getRoleUrlById(roleId);
		List<PrivilegeVo> urlList = tUrlService.getUrlList();
		for (PrivilegeVo privilegeVo : urlList) {
			for (Map<String, Object> map : role) {
				if (privilegeVo.getId().equals(map.get("URLID").toString())) {
					privilegeVo.setChecked(true);
				}
			}
		}
		return urlList;
	}
	
	@ResponseBody
	@RequestMapping(value="/updateMenu",method={RequestMethod.GET,RequestMethod.POST})
	public Map<String,Object> updateMenu(String uid,String menuName,String parent,String url,Integer sort,String oper){
		String pk = tUrlService.updateMenu(uid, menuName, parent, url, sort,oper);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", pk);
		if(oper.equals("edit")){
			map.put("pid", parent);
		}else if(oper.equals("add")){
			map.put("pid", uid);
		}
		map.put("name", menuName);
		map.put("urlVal", url);
		map.put("sortVal", sort);
		map.put("oper", oper);
		return map; 
	}
	
	@ResponseBody
	@RequestMapping(value="/deleteMenu",method={RequestMethod.GET,RequestMethod.POST})
	public void deleteMenu(String uid){
		tUrlService.deleteMenu(uid);
	}
}
