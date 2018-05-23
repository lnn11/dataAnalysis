package com.zhb.dataAnalysis.finance.api;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhb.dataAnalysis.common.repository.database.model.PayPlatForm;
import com.zhb.dataAnalysis.common.repository.database.model.PayPlatformModel;

public interface FinanceExportUtilsService {

	/**
	 * 福利券对账单导出
	 */
	void downWelfareExcel(HttpServletResponse reponse, HttpServletRequest request, String startDate, String endDate, String employeeNmae, String welfareIndex);

	/**
	 * 四大合作平台对账单导出
	 */
	void downCustomerServiceExcel(HttpServletResponse reponse, String startTime, String endTime, String company) throws UnsupportedEncodingException;

	/**
	 * 供应商对账单导出
	 */
	void exportSupplierBill(HttpServletResponse reponse, HttpServletRequest request, String supplierBillPrev, String supplierBillNext, String shortName, String activity, int data, boolean payBox) throws UnsupportedEncodingException;

	/**
	 *支付平台对账单导出 
	 */
	void downPayPlatFormExport(HttpServletResponse reponse,
							   HttpServletRequest request, PayPlatForm pay);

}
