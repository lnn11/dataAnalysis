package com.zhb.dataAnalysis.marketing.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhb.dataAnalysis.common.repository.database.marketing.SilkActivityDao;
import com.zhb.dataAnalysis.marketing.api.SilkActivityService;

@Service("silkActivityService")
public class SilkActivityServiceImpl implements SilkActivityService{

	@Resource(name="silkActivityDao")
	private SilkActivityDao silkActivityDao;
	
	/**
	 * 活动销售SPU数  活动销售SKU总数
	 * @param startTime
	 * @param endTime
	 * @param data
	 * @param activityId
	 * @return
	 */
	@Override
	public Map<String, Object> silkSPUSKUData(String startTime, String endTime, String data, String activityId) {
		Map<String,Object> map = new HashMap<String, Object>();
		Map<String, Object> silkSPUSKUData = silkActivityDao.getSilkSPUSKUData(startTime, endTime, data, activityId, null);
		Map<String, Object> silkSPUSKUDataAPP = silkActivityDao.getSilkSPUSKUData(startTime, endTime, data, activityId, "1");
		Map<String, Object> silkSPUSKUDataMicroMall = silkActivityDao.getSilkSPUSKUData(startTime, endTime, data, activityId, "2");
		Map<String, Object> silkSPUSKUDataMicro = silkActivityDao.getSilkSPUSKUData(startTime, endTime, data, activityId, "");
		if(!silkSPUSKUData.isEmpty()){
			map.put("silkSPUSKUData", silkSPUSKUData);
		}
		if(!silkSPUSKUDataAPP.isEmpty()){
			map.put("silkSPUSKUDataAPP", silkSPUSKUDataAPP);
		}
		if(!silkSPUSKUDataMicroMall.isEmpty()){
			map.put("silkSPUSKUDataMicroMall", silkSPUSKUDataMicroMall);
		}
		if(!silkSPUSKUDataMicro.isEmpty()){
			map.put("silkSPUSKUDataMicro", silkSPUSKUDataMicro);
		}
		
		return map;
	}

	/**
	 * 活动主订单总数  活动子订单总数   活动参与总人数
	 * @param startTime
	 * @param endTime
	 * @param data
	 * @param activityId
	 * @return
	 */
	@Override
	public Map<String, Object> silkOrderData(String startTime, String endTime, String data, String activityId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> silkOrderData = silkActivityDao.getSilkOrderData(startTime, endTime, data, activityId, null);
		Map<String, Object> silkOrderDataAPP = silkActivityDao.getSilkOrderData(startTime, endTime, data, activityId, "1");
		Map<String, Object> silkOrderDataMicroMall = silkActivityDao.getSilkOrderData(startTime, endTime, data, activityId, "2");
		Map<String, Object> silkOrderDataMicro = silkActivityDao.getSilkOrderData(startTime, endTime, data, activityId, "");
		map.put("silkOrderData", silkOrderData);
		map.put("silkOrderDataAPP", silkOrderDataAPP);
		map.put("silkOrderDataMicroMall", silkOrderDataMicroMall);
		map.put("silkOrderDataMicro", silkOrderDataMicro);
		return map;
	}

	/**
	 * 现金支付总金额   实际支付总积分  福利券支付总积分   活动商品总销量
	 * @param startTime
	 * @param endTime
	 * @param data
	 * @param activityId
	 * @return
	 */
	@Override
	public Map<String, Object> silkPayData(String startTime, String endTime, String data, String activityId) {
		Map<String,Object> map = new HashMap<String, Object>();
		Map<String, Object> silkPayData = silkActivityDao.getSilkPayData(startTime, endTime, data, activityId, null);
		Map<String, Object> silkPayDataAPP = silkActivityDao.getSilkPayData(startTime, endTime, data, activityId, "1");
		Map<String, Object> silkPayDataMicroMall = silkActivityDao.getSilkPayData(startTime, endTime, data, activityId, "2");
		Map<String, Object> silkPayDataMicro = silkActivityDao.getSilkPayData(startTime, endTime, data, activityId, "");
		map.put("silkPayData", silkPayData);
		map.put("silkPayDataAPP", silkPayDataAPP);
		map.put("silkPayDataMicroMall", silkPayDataMicroMall);
		map.put("silkPayDataMicro", silkPayDataMicro);
		return map;
	}

	/**
	 * 重复参与人数
	 * @param startTime
	 * @param endTime
	 * @param data
	 * @param activityId
	 * @return
	 */
	@Override
	public Map<String, Object> silkRepeData(String startTime, String endTime, String data, String activityId) {
		Map<String,Object> map = new HashMap<String, Object>();
		Map<String, Object> silkRepeData = silkActivityDao.getSilkRepeData(startTime, endTime, data, activityId, null);
		Map<String, Object> silkRepeDataAPP = silkActivityDao.getSilkRepeData(startTime, endTime, data, activityId, "1");
		Map<String, Object> silkRepeDataMicroMall = silkActivityDao.getSilkRepeData(startTime, endTime, data, activityId, "2");
		Map<String, Object> silkRepeDataMicro = silkActivityDao.getSilkRepeData(startTime, endTime, data, activityId, "");
		map.put("silkRepeData", silkRepeData);
		map.put("silkRepeDataAPP", silkRepeDataAPP);
		map.put("silkRepeDataMicroMall", silkRepeDataMicroMall);
		map.put("silkRepeDataMicro", silkRepeDataMicro);
		return map;
	}

	/**
	 * 新增会员数
	 * @param startTime
	 * @param endTime
	 * @param data
	 * @param activityId
	 * @return
	 */
	@Override
	public Map<String, Object> silkNewUserData(String startTime, String endTime, String data, String activityId) {
		return silkActivityDao.getSilkNewUserData(startTime, endTime, activityId);
	}

	@Override
	public Map<String, Object> silksSPUSKUData(String startTime,
			String endTime, String data, String activityId) {
		Map<String,Object> map = new HashMap<String, Object>();
		Map<String, Object> silkSPUSKUData = silkActivityDao.getSilksSPUSKUData(startTime, endTime, data, activityId, null);
		Map<String, Object> silkSPUSKUDataAPP = silkActivityDao.getSilksSPUSKUData(startTime, endTime, data, activityId, "1");
		Map<String, Object> silkSPUSKUDataMicroMall = silkActivityDao.getSilksSPUSKUData(startTime, endTime, data, activityId, "2");
		Map<String, Object> silkSPUSKUDataMicro = new HashMap<String, Object>();
		Map<String, Object> silkSPUSKUDataM = new HashMap<String, Object>();
		if(startTime.compareTo("2017-07-01 00:00:00") < 0){
			silkSPUSKUDataMicro = silkActivityDao.getSilksSPUSKUData(startTime, endTime, data, activityId, "");
		}else{
			silkSPUSKUDataMicro = silkActivityDao.getSilksSPUSKUData(startTime, endTime, data, activityId, "3");
			silkSPUSKUDataM = silkActivityDao.getSilksSPUSKUData(startTime, endTime, data, activityId, "4");
		}
		
		map.put("silkSPUSKUData", silkSPUSKUData);
		map.put("silkSPUSKUDataAPP", silkSPUSKUDataAPP);
		map.put("silkSPUSKUDataMicroMall", silkSPUSKUDataMicroMall);
		map.put("silkSPUSKUDataMicro", silkSPUSKUDataMicro);
		map.put("silkSPUSKUDataM", silkSPUSKUDataM);
		
		return map;
	}

	@Override
	public Map<String, Object> silksOrderData(String startTime, String endTime,
			String data, String activityId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> silkOrderData = silkActivityDao.getSilksOrderData(startTime, endTime, data, activityId, null);
		Map<String, Object> silkOrderDataAPP = silkActivityDao.getSilksOrderData(startTime, endTime, data, activityId, "1");
		Map<String, Object> silkOrderDataMicroMall = silkActivityDao.getSilksOrderData(startTime, endTime, data, activityId, "2");
		Map<String, Object> silkOrderDataMicro = new HashMap<String, Object>();
		Map<String, Object> siklOrderDataM = new HashMap<String, Object>();
		if(startTime.compareTo("2017-07-01 00:00:00") < 0){
			silkOrderDataMicro = silkActivityDao.getSilksOrderData(startTime, endTime, data, activityId, "");
		}else{
			silkOrderDataMicro = silkActivityDao.getSilksOrderData(startTime, endTime, data, activityId, "3");
			siklOrderDataM = silkActivityDao.getSilksOrderData(startTime, endTime, data, activityId, "4");
		}
		map.put("silkOrderData", silkOrderData);
		map.put("silkOrderDataAPP", silkOrderDataAPP);
		map.put("silkOrderDataMicroMall", silkOrderDataMicroMall);
		map.put("silkOrderDataMicro", silkOrderDataMicro);
		map.put("siklOrderDataM", siklOrderDataM);
		return map;
	}

	@Override
	public Map<String, Object> silksPayData(String startTime, String endTime,
			String data, String activityId) {
		Map<String,Object> map = new HashMap<String, Object>();
		Map<String, Object> silkPayData = silkActivityDao.getSilksPayData(startTime, endTime, data, activityId, null);
		Map<String, Object> silkPayDataAPP = silkActivityDao.getSilksPayData(startTime, endTime, data, activityId, "1");
		Map<String, Object> silkPayDataMicroMall = silkActivityDao.getSilksPayData(startTime, endTime, data, activityId, "2");
		Map<String, Object> silkPayDataMicro = new HashMap<String, Object>();
		Map<String, Object> silkPayDataM = new HashMap<String, Object>();
		if(startTime.compareTo("2017-07-01 00:00:00") < 0){
			silkPayDataMicro = silkActivityDao.getSilksPayData(startTime, endTime, data, activityId, "");
		}else{
			silkPayDataMicro = silkActivityDao.getSilksPayData(startTime, endTime, data, activityId, "3");
			silkPayDataM = silkActivityDao.getSilksPayData(startTime, endTime, data, activityId, "4");
		}
		map.put("silkPayData", silkPayData);
		map.put("silkPayDataAPP", silkPayDataAPP);
		map.put("silkPayDataMicroMall", silkPayDataMicroMall);
		map.put("silkPayDataMicro", silkPayDataMicro);
		map.put("silkPayDataM", silkPayDataM);
		return map;
	}

	@Override
	public Map<String, Object> silksRepeData(String startTime, String endTime,
			String data, String activityId) {
		Map<String,Object> map = new HashMap<String, Object>();
		Map<String, Object> silkRepeData = silkActivityDao.getSilksRepeData(startTime, endTime, data, activityId, null);
		Map<String, Object> silkRepeDataAPP = silkActivityDao.getSilksRepeData(startTime, endTime, data, activityId, "1");
		Map<String, Object> silkRepeDataMicroMall = silkActivityDao.getSilksRepeData(startTime, endTime, data, activityId, "2");
		Map<String, Object> silkRepeDataMicro = new HashMap<String, Object>();
		Map<String, Object> silkRepeDataM = new HashMap<String, Object>();
		if(startTime.compareTo("2017-07-01 00:00:00") < 0){
			silkRepeDataMicro = silkActivityDao.getSilksRepeData(startTime, endTime, data, activityId, "");
		}else{
			silkRepeDataMicro = silkActivityDao.getSilksRepeData(startTime, endTime, data, activityId, "3");
			silkRepeDataM = silkActivityDao.getSilksRepeData(startTime, endTime, data, activityId, "4");
		}
		map.put("silkRepeData", silkRepeData);
		map.put("silkRepeDataAPP", silkRepeDataAPP);
		map.put("silkRepeDataMicroMall", silkRepeDataMicroMall);
		map.put("silkRepeDataMicro", silkRepeDataMicro);
		map.put("silkRepeDataM", silkRepeDataM);
		return map;
	}

}
