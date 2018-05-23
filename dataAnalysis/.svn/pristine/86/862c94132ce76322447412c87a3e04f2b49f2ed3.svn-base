package com.zhb.dataAnalysis.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhb.dataAnalysis.common.repository.database.model.PayPlatForm;
import com.zhb.dataAnalysis.finance.api.CustomerService;
import com.zhb.dataAnalysis.finance.api.EmployeeWelfareService;
import com.zhb.dataAnalysis.finance.api.FinanceExportUtilsService;
import com.zhb.dataAnalysis.finance.api.PayPlatformService;
import com.zhb.dataAnalysis.finance.api.SupplierBillService;

@Controller
@RequestMapping("/finance")
public class FinanceController {

	@Resource(name="supplierBillServiceImpl")
	private SupplierBillService supplierBillServiceImpl;
	
	@Resource(name = "employeeWelfareService")
	private EmployeeWelfareService employeeWelfareService;
	
	@Resource(name = "customerService")
	private CustomerService customerService;
	
	@Resource(name = "financeExportService")
	private FinanceExportUtilsService financeExportService;
	
	@Resource(name = "payPlatformService")
	private PayPlatformService payPlatformService;
	
	@RequestMapping(value="/toEmployee",method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView toEmployee() {
		ModelAndView view = new ModelAndView("aiPinXuan/center/finance/employeeBill");
		List<Map<String, String>> employeeGift= employeeWelfareService.getEmployeeGift();
		view.addObject("list", employeeGift);
		return view;
	}
	
	@RequestMapping(value = "/employeeWelfare",method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Map<String, Object> employeeWelfare(String startDate,String endDate,int page,int rows,String employeeNmae,String welfareIndex){
//		Map<String, Object> map = employeeWelfareService.getCompanyProducts(startDate, endDate, page, rows, employeeNmae, welfareIndex);
		Map<String, Object> map = employeeWelfareService.getWelfareLisit(startDate, endDate, page, rows, employeeNmae, welfareIndex);
		return map;
	}
	//
	@RequestMapping(value="/queryEmployee",method = {RequestMethod.POST,RequestMethod.GET})
	public void queryEmployee(String startDate, String endDate) {
		employeeWelfareService.queryEmployee(startDate, endDate);
	}
	
	//
	@RequestMapping(value="/deleteEmployee",method = {RequestMethod.POST,RequestMethod.GET})
	public void deleteEmployee(String startDate, String endDate) {
		employeeWelfareService.deleteEmployee(startDate, endDate);
	}
	
	
	@RequestMapping(value = "/downWelfareExcel", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void downWelfareExcel(HttpServletResponse reponse,HttpServletRequest request, String startDate,String endDate,String employeeNmae,String welfareIndex) throws Exception{
		financeExportService.downWelfareExcel(reponse,request,startDate,endDate,employeeNmae,welfareIndex);
		

	}
	
	@RequestMapping(value = "/getCustomerService",method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Map<String, Object> getCustomerService(String startTime,String endTime,int page,int rows,String company){
		Map<String, Object> map = customerService.getAccountStatement(startTime, endTime, page, rows, company);
		return map;
	}
	
	@RequestMapping(value = "/downCustomerServiceExcel",method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void downCustomerServiceExcel(HttpServletResponse reponse,String startTime,String endTime,String company) throws Exception{
		financeExportService.downCustomerServiceExcel(reponse, startTime, endTime, company);
	}

	/**
	 * 供应商对账单列表查询
	 * @param rows 每页条数
	 * @param page 第几页
	 * @param supplierBillPrev 统计时间段（前）
	 * @param supplierBillNext 统计时间段（后）
	 * @param shortName 供应商简称
	 * @param activity 商品类型
	 * @return
	 */
	@RequestMapping("/getSupplierBillByPage")
	@ResponseBody
	public Map<String, Object> getSupplierBillByPage(int rows,int page,String supplierBillPrev,String supplierBillNext,String shortName,String activity,int data,boolean payBox) {
		return supplierBillServiceImpl.supplierBillListByPage(rows,page,supplierBillPrev,supplierBillNext,shortName,activity,data,payBox);
	}
	
	/**
	 * 供应商对账单商品求和
	 */
	@RequestMapping("/getSupplierBill")
	@ResponseBody
	public Map<String,Object> getSuppliserBill(String supplierBillPrev,String supplierBillNext,String shortName,String activity,int data,boolean payBox) {
		return supplierBillServiceImpl.supplierBillList(supplierBillPrev, supplierBillNext, shortName, activity, data,payBox);
	}
	/**
	 * 导出供应商账单操作
	 */
	@RequestMapping("/exportSupplierBill")
	public void exportSupplierBill(HttpServletRequest request,HttpServletResponse reponse,String supplierBillPrev,String supplierBillNext,String shortName,String activity,int data,boolean payBox) throws UnsupportedEncodingException{
		financeExportService.exportSupplierBill(reponse, request, supplierBillPrev, supplierBillNext, shortName, activity, data,payBox);
	}
	
	/**
	 * 跳转到支付平台对账单页面
	 */
	@RequestMapping("toPayPlatforBill")
	public ModelAndView toPayPlatforBill () {
		ModelAndView view = new ModelAndView("aiPinXuan/center/finance/payPlatformBill");
		List<Map<String, String>> getChannelList = payPlatformService.getChannelList();
		view.addObject("channel", getChannelList);
		return view;
	}
	
	@RequestMapping("getPayPlatform")
	@ResponseBody
	public Map<String, Object> getPayPlatform(PayPlatForm pay) {
		return payPlatformService.getPayPlatform(pay);
	}
	
	/**
	 * 支付对账单导出
	 */
	@RequestMapping("downPayPlatFormExport")
	public void downPayPlatFormExport(HttpServletResponse reponse,HttpServletRequest request,PayPlatForm pay) {
		financeExportService.downPayPlatFormExport(reponse,request,pay);
	}
}
