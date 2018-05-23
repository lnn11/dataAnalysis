package com.zhb.dataAnalysis.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.zhb.dataAnalysis.commodity.api.OrderService;
import com.zhb.dataAnalysis.common.repository.database.model.OrderModel;

@RequestMapping("/order")
@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	/**
	 * 订单总数分析  按月分析
	 * @param orderYear
	 * @return
	 */
	@RequestMapping(value = "/orderTotal", method = {RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public List<OrderModel> orderTotal(String orderYear) {
		List<OrderModel> list = orderService.orderTotalList(orderYear);
		return list;
	}
	
	/**
	 * 订单总数分析  按供应商分析
	 */
	@RequestMapping(value = "/orderSupplier", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Map<String,Object> orderSupplier(String prevDateOrder,String nextDateOrder,Integer currentPage) {
		Map<String,Object> map = null;
		int pageSize = 6;
		if (currentPage == null ){
			currentPage=1;
		}
		map = orderService.orderSupplierList(prevDateOrder,nextDateOrder,currentPage,pageSize);
		map.put("currentPage",currentPage);
		map.put("pageSize", pageSize);
		return map;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getSupplierByPage", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Map<String,Object> getSupplierByPage(String prevDateOrder,String nextDateOrder,Integer currentPage,String supplierLists,int pageSize) {
		List<Map<String,String>> supplierList = JSON.parseObject(supplierLists,ArrayList.class);
		Map<String, Object> map = orderService.getSupplierByPage(supplierList, currentPage, pageSize, prevDateOrder, nextDateOrder);
		map.put("currentPage", currentPage);
		return map;
	}

	/**
	 * 订单函数
	 * @param startTime 开始时间
	 * @param overTime 结束时间
	 * @return int
	 */
	@RequestMapping("/getOrderNumber")
	@ResponseBody
	public Map<String, Object> getReturnedOrder(String startTime,String overTime){
		if(StringUtils.isBlank(startTime)){startTime = "";}if(StringUtils.isBlank(overTime)){overTime = "";};
		Map<String, Object> map = orderService.getReturnedOrder(startTime, overTime);
		return map;
	}
	
	/**
	 * 总体销售业绩指标
	 * @param startTime
	 * @param overTime
	 * @return
	 */
	@RequestMapping("/getAreadyPaidOrder")
	@ResponseBody
	public Map<String, Double> getAreadyPaidOrder(String startTime,String overTime){
		if(StringUtils.isBlank(startTime)){startTime = "";}if(StringUtils.isBlank(overTime)){overTime = "";};
		return orderService.getAreadyPaidOrder(startTime, overTime);
	}
	
	/**
	 * 已售出商品总数之和
	 * @param startTime 开始时间
	 * @param overTime 结束时间
	 * @return int
	 */
	@RequestMapping("/getAreadySaled")
	@ResponseBody
	public int getAreadySaled(String startTime,String overTime){
		if(StringUtils.isBlank(startTime)){startTime = "";}if(StringUtils.isBlank(overTime)){overTime = "";};
		return orderService.getAreadySaled(startTime, overTime);
	}
}
