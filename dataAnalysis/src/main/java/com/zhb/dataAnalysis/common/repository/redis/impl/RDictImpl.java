package com.zhb.dataAnalysis.common.repository.redis.impl;

import com.zhb.dataAnalysis.common.repository.redis.RDict;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;


@Repository("rDict")
public class RDictImpl implements RDict {

	/** Redis模板 */
	@Resource(name = "redisTemplate")
	private RedisTemplate<String, Object> redisTemplate;
	
	@Override
	public void setAuthorizedHash(String key, String hashKey , String jsonArray) {
		HashOperations<String, String, String> hop = redisTemplate.opsForHash();
		hop.put(key, hashKey, jsonArray);
		redisTemplate.expire(key, TIME_OUT, TimeUnit.HOURS);
	}
	
	@Override
	public String getAuthorizedHash(String key,String userId) {
		HashOperations<String, String, String> hop = redisTemplate.opsForHash();
		String jsonArray = hop.get(key, userId);
		return jsonArray;
	}

}
