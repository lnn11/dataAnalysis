package com.zhb.dataAnalysis.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zhb.dataAnalysis.commodity.api.ISupplier;
import com.zhb.dataAnalysis.common.utils.PageContextUtils;

/**
 * @author chunjie.huo
 * @time 2016年12月19日 下午2:29:13
 * 作用: 供应商
 */
@RestController
@RequestMapping("/supplier")
public class SupplierController {

	@Autowired
	private ISupplier supplierService;
	
	/**
	 * 供应商销量汇总
	 * @param startTime 开始时间
	 * @param overTime 结束时间
	 * @param pageUtils 分页bean
	 * @return Map<String, Object>
	 */
	@RequestMapping(value = "/getSupplierSalesNum",method={RequestMethod.GET,RequestMethod.POST})
	public Map<String, Object> getSupplierSalesNum(String startTime,String overTime,PageContextUtils pageUtils,boolean C){
		if(StringUtils.isBlank(startTime)){startTime = "";}if(StringUtils.isBlank(overTime)){overTime = "";};
		int pageSize = pageUtils.getPageSize();
		if(pageSize != 0){
			int count = supplierService.getSupplierCount(startTime, overTime);
			pageUtils.setTotalCount(count);
		}
		int currentPage = pageUtils.getCurrentPage();
		int totalPage = pageUtils.getTotalPage();
		Map<String,Object> map = new HashMap<String, Object>();
		List<Map<String,Object>> salesNum = supplierService.getSupplierSalesNum(startTime, overTime, currentPage,pageSize);
		if(C == true){
			List<Map<String,Object>> salesNums = supplierService.getSupplierSalesNum(startTime, overTime, 0,0);
			if(null != salesNums && salesNums.size() > 0){
				map.put("list", salesNum);
				map.put("list1", salesNums);
				map.put("totalPage", totalPage);
				return map;
			}
		}
		else if(null != salesNum && salesNum.size() > 0){
			map.put("list", salesNum);
			map.put("totalPage", totalPage);
			return map;
		}
		return null;
	}
	
	/**
	 * 供应商销售额汇总
	 * @param startTime 开始时间
	 * @param overTime 结束时间
	 * @param pageUtils 分页bean
	 * @return Map<String, Object>
	 */
	@RequestMapping(value = "/getSupplierSalesVoles",method = {RequestMethod.GET,RequestMethod.POST})
	public Map<String, Object> getSupplierSalesVoles(String startTime,String overTime,PageContextUtils pageUtils,boolean C){
		if(StringUtils.isBlank(startTime)){startTime = "";}if(StringUtils.isBlank(overTime)){overTime = "";};
		int pageSize = pageUtils.getPageSize();
		if(pageSize != 0){
			int count = supplierService.getSupplierSalesCount(startTime, overTime);
			pageUtils.setTotalCount(count);
		}
		int currentPage = pageUtils.getCurrentPage();
		int totalPage = pageUtils.getTotalPage();
		Map<String,Object> map = new HashMap<String, Object>();
		List<Map<String,Object>> salesVolues = supplierService.getSupplierSalesVoles(startTime, overTime, currentPage,pageSize);
		if(C==true){
			List<Map<String,Object>> salesTVolues = supplierService.getSupplierSalesVoles(startTime, overTime,0,0);
			if(null != salesVolues && salesVolues.size() > 0){
				map.put("list", salesVolues);
				map.put("listC", salesTVolues);
				map.put("totalPage", totalPage);
				return map;
			}
		}else if(null != salesVolues && salesVolues.size() > 0){
			map.put("list", salesVolues);
			map.put("totalPage", totalPage);
			return map;
		}
		return null;
	}
	
	/**
	 * 供应商发货速度汇总
	 * @param startTime 开始时间
	 * @param overTime 结束时间
	 * @param pageUtils 分页bean
	 * @return Map<String, Object>
	 */
	@RequestMapping(value = "/getSupplierDeliverGoodsSpeed",method = {RequestMethod.GET,RequestMethod.POST})
	public Map<String, Object> getSupplierDeliverGoodsSpeed(String startTime,String overTime,PageContextUtils pageUtils,boolean C){
		if(StringUtils.isBlank(startTime)){startTime = "";}if(StringUtils.isBlank(overTime)){overTime = "";};
		int pageSize = pageUtils.getPageSize();
		if(pageSize != 0){
			int count = supplierService.getSupplierDeliverGoodsSpeedCount(startTime, overTime);
			pageUtils.setTotalCount(count);
		}
		int currentPage = pageUtils.getCurrentPage();
		int totalPage = pageUtils.getTotalPage();
		Map<String,Object> map = new HashMap<String, Object>();
		for (int i = 1; i <= 4; i++) {
			List<Map<String,Object>> salesVolues = supplierService.getSupplierDeliverGoodsSpeed(i,startTime, overTime, currentPage,pageSize);
			if(C==true){
				List<Map<String,Object>> salesTVolues = supplierService.getSupplierDeliverGoodsSpeed(i,startTime, overTime, 0,0);
				map.put("list"+i, salesVolues);
				map.put("list"+i+i, salesTVolues);
			}else{
				map.put("list"+i, salesVolues);
			}
		}
		map.put("totalPage", totalPage);
		return map;
	}
	
	/**
	 * 供应商总数
	 * @param startTime 开始时间
	 * @param overTime 结束时间
	 * @return int
	 */
	@RequestMapping("/getSupplierCountNum")
	public int getSupplierCountNum(String startTime,String overTime){
		if(StringUtils.isBlank(startTime)){startTime = "";}if(StringUtils.isBlank(overTime)){overTime = "";};
		return supplierService.getSupplierCountNum(startTime, overTime);
	}
}