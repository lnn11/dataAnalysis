package com.zhb.dataAnalysis.commodity.api;

import java.math.BigDecimal;
import java.util.Map;

public interface IOperate {

	/**
	 * 在售商品SPU总数  和  SPU总数
	 * @param startDate 开始时间
	 * @param endDate 结束时间
	 * @return List<BigDecimal>
	 */
	Map<String,BigDecimal> getProductSPU(String startDate, String endDate);
	
	/**
	 * 话费/流量/加油卡充值订单总数
	 * @param startDate 开始时间
	 * @param endDate 结束时间
	 * @param rechargeType 充值类型
	 * @return List<Map<String,BigDecimal>>
	 */
	Map<String, BigDecimal> getRechargeOrderNum(String startDate, String endDate);
	
	/**
	 * 话费/流量/加油卡充值订单总数(已支付/已完成/已取消/已失效)
	 * @param startDate 开始时间
	 * @param endDate 结束时间
	 * @param rechargeType 充值类型
	 * @return List<Map<String,BigDecimal>>
	 */
	Map<String,Map<String,BigDecimal>> getRechargeOrderNumByStatus(String startDate, String endDate);
	
	/**
	 * 话费/流量/加油卡销售额指标
	 * @param startDate 开始时间
	 * @param endDate 结束时间
	 * @param rechargeType 充值类型
	 * @return List<Map<String,BigDecimal>>
	 */
	Map<String,Map<String,BigDecimal>> getRechargeSaleIndex(String startDate, String endDate);
}
