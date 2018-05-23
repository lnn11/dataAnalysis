package com.zhb.dataAnalysis.common.repository.database.finance;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zhb.dataAnalysis.common.repository.database.model.PayPlatForm;
import com.zhb.dataAnalysis.common.repository.database.model.PayPlatformModel;

@Repository("payPlatformDao")
public interface PayPlatformDao {

	List<PayPlatformModel> getPayPlatform(@Param("pay") PayPlatForm pay);


	String getPayPlatCreateTime(@Param("orderMain") String orderMain);

	List<PayPlatformModel> getPayPlatformCharge(@Param("pay") PayPlatForm pay);


}
