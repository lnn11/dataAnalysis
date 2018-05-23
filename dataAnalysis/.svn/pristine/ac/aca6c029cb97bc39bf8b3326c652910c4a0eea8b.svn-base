package com.zhb.dataAnalysis.finance.api;

import java.util.List;
import java.util.Map;

import com.zhb.dataAnalysis.common.repository.database.model.SupplierBill;


public interface SupplierBillService {

	public Map<String,Object> supplierBillListByPage(int rows, int page, String supplierBillPrev, String supplierBillNext, String shortName, String activity, int data, boolean payBox);
	
	public Map<String,Object> supplierBillList(String supplierBillPrev, String supplierBillNext, String shortName, String activity, int data, boolean payBox);

	public List<SupplierBill> getSupplierBillList(String supplierBillPrev, String supplierBillNext, String shortName, String activity, int data, boolean payBox);
}
