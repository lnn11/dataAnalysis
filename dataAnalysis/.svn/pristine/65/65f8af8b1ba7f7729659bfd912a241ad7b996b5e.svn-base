package com.zhb.dataAnalysis.common.repository.database.channelanalysis;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zhb.dataAnalysis.marketing.beans.ChannelDataAnalysis;

@Repository(value="channelAnalysisDao")
public interface ChannelAnalysisDao {	
	
	/**
	 * 获取具体某一天的 渠道号,订单数,订单总金额,实际支付总金额
	 * @param channel
	 * @return
	 */
	List<ChannelDataAnalysis> getOrderSum(@Param("channelData") ChannelDataAnalysis channel);
	
	/**
	 * 复购用户数
	 * @param channelId
	 * @param reBuyersMin
	 * @param reBuyersMax
	 * @param startTime
	 * @return
	 */
	List<ChannelDataAnalysis> getRepeatBuyers(@Param("channelId") String channelId, @Param("reBuyersMin") Integer reBuyersMin, @Param("reBuyersMax") Integer reBuyersMax,
											  @Param("date") Date date);
	
	/**
	 * 获取用户注册数
	 * @param channelId
	 * @param startTime
	 * @return
	 */
	List<ChannelDataAnalysis> getRegisterUser(@Param("channelId") String channelId, @Param("registerMin") Integer registerMin, @Param("registerMax") Integer registerMax,
											  @Param("date") Date date);
	
	/**
	 * 获取某个时间段内 订单数,订单总金额,实际支付总金额
	 * @param channel
	 * @return
	 */
	Map<String,BigDecimal> getAboutOrderSum(@Param("channelData") ChannelDataAnalysis channel);
	
	/**
	 * 获取某个时间段内 复购用户数
	 * @param channelId
	 * @param reBuyersMin
	 * @param reBuyersMax
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	Map<String,BigDecimal> getReBuyers(@Param("channelId") String channelId, @Param("reBuyersMin") Integer reBuyersMin, @Param("reBuyersMax") Integer reBuyersMax,
									   @Param("startTime") String startTime, @Param("endTime") String endTime);
	
	/**
	 * 获取某个时间段内 用户注册数
	 * @param channelId
	 * @param registerMin
	 * @param registerMax
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	Map<String,BigDecimal> getRegisterUsers(@Param("channelId") String channelId, @Param("registerMin") Integer registerMin, @Param("registerMax") Integer registerMax,
											@Param("startTime") String startTime, @Param("endTime") String endTime);
	
	/**
	 * 获取所有渠道信息
	 * @return
	 */
	List<Map<String,String>> getChannelAll();
}
