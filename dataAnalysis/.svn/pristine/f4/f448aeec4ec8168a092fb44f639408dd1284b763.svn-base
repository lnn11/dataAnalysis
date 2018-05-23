package com.zhb.dataAnalysis.commodity.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhb.dataAnalysis.commodity.api.IUserInfo;
import com.zhb.dataAnalysis.common.repository.database.userInfo.UserInfoDao;

@Service("userInfoService")
public class UserInfoService implements IUserInfo {

	@Autowired
	private UserInfoDao userInfoDao;
	
	@Override
	public Map<String, Object> memberCount(String startTime, String endTime) {
		Map<String,Object> map = new HashMap<String, Object>();
		for (int i = 0; i <= 3; i++) {
			int j = userInfoDao.memberCount(startTime, endTime,i);
			map.put("member"+i, j);
		}
		return map;
	}
}