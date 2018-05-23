package com.zhb.dataAnalysis.common.repository.database.finance;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zhb.dataAnalysis.common.repository.database.model.SupplierBill;

@Repository("supplierBillDao")
public interface SupplierBillDao {

	List<SupplierBill> getSupplierBillList(@Param("supplierBillPrev") String supplierBillPrev, @Param("supplierBillNext") String supplierBillNext,
										   @Param("shortName") String shortName, @Param("activity") String activity, @Param("data") int data);
	List<SupplierBill> getSupplierBillList2(@Param("supplierBillPrev") String supplierBillPrev, @Param("supplierBillNext") String supplierBillNext,
											@Param("shortName") String shortName, @Param("activity") String activity, @Param("data") int data, @Param("isLpk") String isLpk);

	List<SupplierBill> getSupplierBillByPage(@Param("rows") int rows, @Param("page") int page,
											 @Param("supplierBillPrev") String supplierBillPrev, @Param("supplierBillNext") String supplierBillNext,
											 @Param("shortName") String shortName, @Param("activity") String activity, @Param("data") int data);

	int getCount(@Param("supplierBillPrev") String supplierBillPrev, @Param("supplierBillNext") String supplierBillNext,
				 @Param("shortName") String shortName, @Param("activity") String activity, @Param("data") int data);
	double getSumReturnCash(@Param("supplierBillPrev") String supplierBillPrev, @Param("supplierBillNext") String supplierBillNext);

}
