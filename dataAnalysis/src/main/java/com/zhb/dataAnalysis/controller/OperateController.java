package com.zhb.dataAnalysis.controller;

import java.math.BigDecimal;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhb.dataAnalysis.commodity.service.OperateService;

@Controller
@RequestMapping("/operate")
public class OperateController {

	@Resource(name = "operateService")
	private OperateService operateService;
	
	@RequestMapping(value = "/getProductSPU", method = {RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Map<String, BigDecimal> getProductSPU(String startDate, String endDate){
		Map<String, BigDecimal> map = operateService.getProductSPU(startDate, endDate);
		return map;
	}
	
	@RequestMapping(value = "/getRechargeOrderNum", method = {RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Map<String, BigDecimal> getRechargeOrderNum(String startDate,String endDate) {
		Map<String, BigDecimal> map = operateService.getRechargeOrderNum(startDate, endDate);
		return map;
	}
	
	@RequestMapping(value = "/getRechargeOrderNumByStatus", method = {RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Map<String, Map<String, BigDecimal>> getRechargeOrderNumByStatus(String startDate, String endDate) {
		Map<String, Map<String, BigDecimal>> map = operateService.getRechargeOrderNumByStatus(startDate, endDate);
		return map;
	}
	
	@RequestMapping(value = "/getRechargeSaleIndex", method = {RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Map<String,Map<String,BigDecimal>> getRechargeSaleIndex(String startDate,String endDate) {
		Map<String, Map<String, BigDecimal>> map = operateService.getRechargeSaleIndex(startDate, endDate);
		return map;
	}
}
