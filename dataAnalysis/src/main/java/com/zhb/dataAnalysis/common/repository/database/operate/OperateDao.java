package com.zhb.dataAnalysis.common.repository.database.operate;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author chunjie.huo
 * @time 2017年4月1日 下午2:37:20
 * 作用:二期平台运营指标
 */
@Repository("operateDao")
public interface OperateDao {

	/**
	 * 在售商品SPU总数  和  SPU总数
	 * @param startDate 开始时间
	 * @param endDate 结束时间
	 * @return List<BigDecimal>
	 */
	List<BigDecimal> getProductSPU(@Param("startDate") String startDate, @Param("endDate") String endDate);
	
	/**
	 * 话费/流量/加油卡充值订单总数
	 * @param startDate 开始时间
	 * @param endDate 结束时间
	 * @param rechargeType 充值类型
	 * @return List<Map<String,BigDecimal>>
	 */
	List<BigDecimal> getRechargeOrderNum(@Param("startDate") String startDate, @Param("endDate") String endDate);
	/**
	 * 话费/流量/加油卡充值订单总数(已支付/已完成/已取消/已失效)
	 * @param startDate 开始时间
	 * @param endDate 结束时间
	 * @param rechargeType 充值类型
	 * @return List<Map<String,BigDecimal>>
	 */
	List<Map<String,BigDecimal>> getRechargeOrderNumByStatus(@Param("startDate") String startDate, @Param("endDate") String endDate);
	
	/**
	 * 话费/流量/加油卡销售额指标
	 * @param startDate 开始时间
	 * @param endDate 结束时间
	 * @param rechargeType 充值类型
	 * @return List<Map<String,BigDecimal>>
	 */
	List<Map<String,BigDecimal>> getRechargeSaleIndex(@Param("startDate") String startDate, @Param("endDate") String endDate);
}
