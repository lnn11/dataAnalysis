package com.zhb.dataAnalysis.common.shiro.service;

import com.alibaba.fastjson.JSON;
import com.zhb.dataAnalysis.common.repository.redis.RDict;
import com.zhb.dataAnalysis.common.shiro.api.TAuthorizedService;
import com.zhb.dataAnalysis.common.shiro.database.TAuthorizedDao;
import com.zhb.dataAnalysis.common.shiro.model.TRole;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.List;
import java.util.Map;

@Service("tAuthorizedService")
public class TAuthorizedServiceImpl implements TAuthorizedService {
	
	@Resource(name = "tAuthorizedDao")
	private TAuthorizedDao tAuthorizedDao;
	
	@Resource(name = "rDict")
	private RDict rDict;

	@Override
	public List<TRole> getRoleNamesForUser(String userId) {
		String jsonArray = null;
		try {
			jsonArray = rDict.getAuthorizedHash(RDict.ROLENAMESFORUSER,userId);
			if(StringUtils.isBlank(jsonArray)){
				List<Map<String,String>> listMap = tAuthorizedDao.getRoleNamesForUser(userId);
				if(listMap != null && listMap.size() > 0){
					jsonArray = JSON.toJSONString(listMap);
					rDict.setAuthorizedHash(RDict.ROLENAMESFORUSER,userId,jsonArray);
				}
			}
		} catch (Exception e) {
			List<Map<String,String>> listMap = tAuthorizedDao.getRoleNamesForUser(userId);
			if(listMap != null && listMap.size() > 0){
				jsonArray = JSON.toJSONString(listMap);
			}
		}
			
		List<TRole> list = JSON.parseArray(jsonArray, TRole.class);
		
		return list;
	}

	@Override
	public List<String> getPermissions(String userId,List<TRole> roles) {
		String jsonArray = null;
		try {
			jsonArray = rDict.getAuthorizedHash(RDict.PERMISSIONS,userId);
			if(StringUtils.isBlank(jsonArray)){
				List<String> list = tAuthorizedDao.getPermissions(userId, roles);
				jsonArray = JSON.toJSONString(list);
				rDict.setAuthorizedHash(RDict.PERMISSIONS, userId, jsonArray);
			}
		} catch (Exception e) {
			List<String> list = tAuthorizedDao.getPermissions(userId, roles);
			jsonArray = JSON.toJSONString(list);
		}
		
		List<String> list = JSON.parseArray(jsonArray, String.class);
		return list;
	}
}
