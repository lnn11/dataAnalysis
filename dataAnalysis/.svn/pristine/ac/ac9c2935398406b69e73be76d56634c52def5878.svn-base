package com.zhb.dataAnalysis.marketing.api;

import com.zhb.dataAnalysis.marketing.beans.ChannelDataAnalysis;

public interface IChannelAnalysisService {

	/**
	 * 渠道数据分析
	 * @param params
	 * @return
	 */
	<T> T channelDataAnalysis(ChannelDataAnalysis cda,int rows,int curPage,int channelTotal);
	
	/**
	 * 渠道数据统计
	 * @param cda
	 * @return
	 */
	<T> T countChannelInfo(ChannelDataAnalysis cda);
	
	/**
	 * 获取所有渠道信息
	 * @return
	 */
	<T> T getChannelAll();
}