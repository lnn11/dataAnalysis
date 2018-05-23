package com.zhb.dataAnalysis.common.repository.database.marketing;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zhb.dataAnalysis.common.repository.database.model.ActivityModel;

@Repository("hKMacaoDao")
public interface HKMacaoDao {

	List<ActivityModel> getActivityList();

	int getCount();

	ActivityModel getActivityInfo(@Param("id") String id);
	//销售额
	Map<String, Object> getTravelSales(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("orderSource") String orderSource);
	//活动销售SPU种类总数  活动销售SKU种类总数
	Map<String, Object> getTravelSaleSPUCount(@Param("startTime") String startTime, @Param("endTime") String endTime,
											  @Param("orderSource") String orderSource);
	//活动商品总销量  活动期间，满99、199、299的销售子商品总销量
	Map<String, Object> getTravelProductCount(@Param("startTime") String startTime, @Param("endTime") String endTime,
											  @Param("orderSource") String orderSource);
	//现金满额销售额   活动期间，满99、199、299且使用购卡权限的销售额（订单总额）
	Map<String, Object> getTravelSalesCash(@Param("startTime") String startTime, @Param("endTime") String endTime,
										   @Param("orderSource") String orderSource);
	//现金满额销售SPU SKU种类总数  活动期间，满99、199、299且使用购卡权限的销售SPU种类总数
	Map<String, Object> getTravelSaleSPUCash(@Param("startTime") String startTime, @Param("endTime") String endTime,
											 @Param("orderSource") String orderSource);
	//现金满额总销量  活动期间，满99、199、299且使用购卡权限的的销售子商品总销量
	Map<String, Object> getTravelSaleCash(@Param("startTime") String startTime, @Param("endTime") String endTime,
										  @Param("orderSource") String orderSource);
	//活动订单总数    活动期间，满99、199、299的活动主订单总数
	Map<String, Object> getTravelOrderMainCount(@Param("startTime") String startTime, @Param("endTime") String endTime,
												@Param("orderSource") String orderSource);
	//活动子订单总数  活动期间，满99、199、299的活动子订单总数
	Map<String, Object> getTravelOrderCount(@Param("startTime") String startTime, @Param("endTime") String endTime,
											@Param("orderSource") String orderSource);
	//现金满额订单总数   活动期间，满99、199、299且使用购卡权限主订单总数
	Map<String, Object> getTravelOrderMainCash(@Param("startTime") String startTime, @Param("endTime") String endTime,
											   @Param("orderSource") String orderSource);
	//现金满额子订单总数   活动期间，满99、199、299且使用购卡权限子订单总数
	Map<String, Object> getTravelOrderCash(@Param("startTime") String startTime, @Param("endTime") String endTime,
										   @Param("orderSource") String orderSource);
	//活动参与总人数  活动期间，参加99、199、299满额活动的总人数
	Map<String, Object> getTravelUserCount(@Param("startTime") String startTime, @Param("endTime") String endTime,
										   @Param("orderSource") String orderSource);
	//重复参与人数  参与活动两次以上的人，去重数据
	Map<String, Object> getTravelRepeUserCount(@Param("startTime") String startTime, @Param("endTime") String endTime,
											   @Param("orderSource") String orderSource);
	//新增会员数  活动期间新增的会员人数
	Map<String, Object> getTravelNewUserCount(@Param("startTime") String startTime, @Param("endTime") String endTime);
	
	/**
	 * [现金支付总金额]
	 * @param startTime
	 * @param endTime
	 * @param activityId
	 * @param orderSource
	 * @return
	 */
	Map<String,Object> getPayTotal(@Param("startTime") String startTime, @Param("endTime") String endTime,
								   @Param("orderSource") String orderSource);
	
	/**
	 * [现金满额现金支付总金额]
	 * @param startTime
	 * @param endTime
	 * @param activityId
	 * @param orderSource
	 * @return
	 */
	Map<String,Object> getBuyCardPayTotal(@Param("startTime") String startTime, @Param("endTime") String endTime,
										  @Param("orderSource") String orderSource);
	
	/**
	 * [实际支付总积分] [福利券支付总积分]
	 * @param startTime
	 * @param endTime
	 * @param activityId
	 * @param orderSource
	 * @return
	 */
	Map<String,Object> getActualPayTotalPoint(@Param("startTime") String startTime, @Param("endTime") String endTime,
											  @Param("orderSource") String orderSource);

	/**
	 * [现金满额实际支付总积分] [现金满额褔利券支付总积分]
	 * @param startTime
	 * @param endTime
	 * @param activityId
	 * @param orderSource
	 * @return
	 */
	Map<String,Object> getBuyCardPayTotalPoint(@Param("startTime") String startTime, @Param("endTime") String endTime,
											   @Param("orderSource") String orderSource);
	
}
