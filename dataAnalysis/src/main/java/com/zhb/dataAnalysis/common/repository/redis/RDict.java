package com.zhb.dataAnalysis.common.repository.redis;

import java.text.MessageFormat;

public interface RDict {
	
	int TIME_OUT = 10;
	
	MessageFormat KEY_FORMAT = new MessageFormat("dataAnalysis:Dict:Type:{0}");

	String ROLENAMESFORUSER = "DataAnalysis:Dic:Role";

	String PERMISSIONS = "DataAnalysis:Dic:permission";
	
	/**
	 * 设置值,通用方法
	 * @param ROLENAMESFORUSER
	 * @param map
	 */
	public void setAuthorizedHash(String key, String hashKey, String list);
	
	/**
	 * 通过用户id获取对应的hash值
	 * @param userId
	 * @return
	 */
	public String getAuthorizedHash(String key, String userId);


}
