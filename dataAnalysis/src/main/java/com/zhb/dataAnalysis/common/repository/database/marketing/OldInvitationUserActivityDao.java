package com.zhb.dataAnalysis.common.repository.database.marketing;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository("oldInvitationUserActivityDao")
public interface OldInvitationUserActivityDao {

	/**
	 * 获取领券数量
	 * 老用户邀请新用户活动
	 * @return
	 */
 	Integer getHcoupns();

	/**
	 * 活动期间注册人数
	 * @return
	 */
	Integer getRegistUsers(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("activityId") String activityId);

	/**
	 * 获取购买数和实际支付金额
	 * @param startTime
	 * @param endTime
	 * @param activityId
	 * @return
	 */
	Map<String,Object> getOrdersAndrealPay(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("activityId") String activityId);

	/**
	 * 获取被邀请人数
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	Integer getInviteCodeNum(@Param("startTime") String startTime, @Param("endTime") String endTime);

	/**
	 * 发起邀请人数
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	Integer getDisInviteCodeNum(@Param("startTime") String startTime, @Param("endTime") String endTime);

	/**
	 *
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	Integer getFullcutNum(@Param("startTime") String startTime, @Param("endTime") String endTime);

	//商品的总金额和供货价
	Map<String,Object> getProductTotal(@Param("startTime") String startTime, @Param("endTime") String endTime);
	//被邀请首单均值
	Map<String,Object> getFristOrder(@Param("startTime") String startTime, @Param("endTime") String endTime);
    //新人区sku
	Integer getSku(@Param("user") String user, @Param("startTime") String startTime, @Param("endTime") String endTime);
	//新人区spu
	Integer getSpu(@Param("user") String user, @Param("startTime") String startTime, @Param("endTime") String endTime);
	//新人去销售额
	Double getPayCash(@Param("user") String user, @Param("startTime") String startTime, @Param("endTime") String endTime);
	//一元专区销售商品数
	Integer getOneProductNum(@Param("startTime") String startTime, @Param("endTime") String endTime);
}
