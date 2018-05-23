package com.zhb.dataAnalysis.common.shiro.api;

import com.zhb.dataAnalysis.common.shiro.model.PrivilegeVo;

import java.util.List;
import java.util.Map;


public interface TUrlService {
	void test();
	
	List<PrivilegeVo> getUrlList();
	
	Boolean insertRoleUrl(String roleId, String urlIds);

	List<Map<String, Object>> getRoleUrlById(String roleId);
	
	/**
	 * 更新菜单
	 * @param menuName
	 * @param parent
	 * @param url
	 * @param sort
	 * @return
	 */
	String updateMenu(String uid, String menuName, String parent, String url, Integer sort, String oper);
	
	/**
	 * 删除uid对应的节点及子节点
	 * @param uid
	 * @return
	 */
	boolean deleteMenu(String uid);
}
