package com.zhb.dataAnalysis.marketing.api;

import java.math.BigDecimal;
import java.util.Map;

public interface IActivityTemplateService {
	/**
	 * 南瓜姑娘活动，获取SPU,SKU
	 * @param startTime
	 * @param endTime
	 * @param activityId
	 * @return
	 */
	Map<String,BigDecimal> getActivitySPU(String startTime, String endTime, String data, String activityId);
	
	/**
	 * [活动商品总销量] [活动主订单总数] [活动子订单总数] [现金支付总金额] [实际支付总积分] [福利券支付总积分]
	 * @param startTime
	 * @param endTime
	 * @param activityId
	 * @return
	 */
	Map<String,BigDecimal> getActivityTotal(String startTime, String endTime, String data, String activityId);
	
	/**
	 * [活动参与总人数]
	 * @param startTime
	 * @param endTime
	 * @param activityId
	 * @return
	 */
	public Map<String,BigDecimal> getActivityUserTotal(String startTime,String endTime, String data,String activityId);
	
	/**
	 * [重复参与人数]
	 * @param startTime
	 * @param endTime
	 * @param activityId
	 * @param data 
	 * @return
	 */
	public Map<String,BigDecimal> getActivityUserRepeat(String startTime,String endTime, String data,String activityId);
	
	/**
	 * [新增会员数]
	 * @param startTime
	 * @param endTime
	 * @param activityId
	 * @return
	 */
	public Map<String,BigDecimal> getActivityUserAdd(String startTime,String endTime);
	
	/**
	 * 拉新会员数
	 */
	public Map<String, BigDecimal> getActivityUserCount(String startTime, String endTime, String activityId);
	
	/**
	 * 大转盘参与人次  人数
	 * @param activityId 
	 */
	public Map<String, BigDecimal> getParticipationData(String startTime,String endTime, String activityId);
	
	/**
	 * 大转盘中奖人次  人数
	 * @param activityId 
	 */
	public Map<String, BigDecimal> getPrizeData(String startTime,String endTime, String activityId);
	
	/**
	 * 大转盘分享人次
	 */
	public Map<String, BigDecimal> getEnjoyData(String startTime,String endTime, String activityId);
	
	/**
	 * 大转盘消耗积分
	 * @param activityId 
	 */
	public Map<String, BigDecimal> getExpendIntegral(String startTime,String endTime, String activityId);
	
	/**
	 * （谢谢） 人次  人数
	 * @param activityId 
	 */
	public Map<String, BigDecimal> getThanksCount(String startTime,String endTime, String activityId);
	
	/**
	 * 积分奖励值  人次  人数
	 */
	public Map<String, BigDecimal> getPrizeInterger(String startTime,String endTime);

	/**
	 * v2
	 * 积分奖励值  人次  人数
	 */
	public Map<String, BigDecimal> getPrizeIntergerV2(String startTime,String endTime);
	
	/**
	 * 非谢谢 非积分  奖励值  人次 人数
	 * @param activityId 
	 */
	public Map<String, BigDecimal> getOtherCount(String startTime,String endTime, String activityId);
	
	/**
	 * 优惠券
	 */
	Map<String, BigDecimal> getCoupon(String startTime, String endTime);

	/**
	 * v2
	 * 优惠券
	 */
	Map<String, BigDecimal> getCouponV2(String startTime, String endTime);

	/**
	 *中奖详情 
	 */
	Map<String, BigDecimal> getPrizeCount(String startTime, String endTime);

	/**
	 * v2
	 *中奖详情
	 */
	Map<String, BigDecimal> getPrizeCountV2(String startTime, String endTime);

	/**
	 * 积分兑换大转盘数据
	 */
	Map<String,Object>  getLuckDrawCount(String  startTime,String endTime,String activityId);

	/**
	 * 年货提前购优惠券
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public Map<String, BigDecimal> getCouponAdvance(String startTime, String endTime);

	/**
	 * 新春领红包
	 * @param startTime
	 * @param endTime
	 * @param activityId
	 * @return
	 */
	Map<String,BigDecimal>  newSpringGetCollarRed(String  startTime,String endTime,String activityId);

	/**
	 * 315
	 * @param startTime
	 * @param endTime
	 * @param activityId
	 * @return
	 */
	Map<String,BigDecimal>  query315miniHouseEleAppliances(String  startTime,String endTime,String activityId);



}
