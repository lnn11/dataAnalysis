package com.zhb.dataAnalysis.controller;

import java.util.Map;

import com.zhb.dataAnalysis.common.utils.HttpClient;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhb.dataAnalysis.commodity.api.IUserInfo;


/**
 * @author chunjie.huo
 * @time 2016年12月19日 下午2:29:25
 * 作用: 会员
 */
@RestController
@RequestMapping("/userInfo")
public class UserInfoController {

	@Autowired
	private IUserInfo userInfoService;
	
	@Value("${pv.url}")
	private String pvUrl;
	
	/**
	 * 获取PV数
	 */
	@RequestMapping("/getPV")	
	public long getPVHits(String startTime, String endTime){
		return HttpClient.getHits(pvUrl, startTime, endTime);
	}
	
	/**
	 * 会员总数
	 * @param startTime 开始时间
	 * @param overTime 结束时间
	 * @return Map<String,Object>
	 */
	@RequestMapping("/memberCount")	
	public Map<String, Object> memberCount(String startTime, String overTime){
		if(StringUtils.isBlank(startTime)){startTime = "";}if(StringUtils.isBlank(overTime)){overTime = "";};
		Map<String, Object> count = userInfoService.memberCount(startTime, overTime);
		return count;
	}
}