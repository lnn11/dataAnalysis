package com.zhb.dataAnalysis.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.zhb.dataAnalysis.common.repository.database.model.OrderModel;
import com.zhb.dataAnalysis.common.repository.database.model.proModel;
import com.zhb.dataAnalysis.common.utils.PageContextUtils;
import com.zhb.dataAnalysis.commodity.api.IProduct;
import com.zhb.dataAnalysis.commodity.api.ProductService;

/**
 * @author chunjie.huo
 * @time 2016年12月19日 下午5:24:08
 * 作用:商品
 */
@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private IProduct productService;
	@Autowired
	ProductService proService;
	
	/**
	 * 在售商品子商品总数之和
	 * @param startTime 开始时间
	 * @param overTime 结束时间
	 * @return int
	 */
	@RequestMapping("/getProductDetailCount")
	@ResponseBody
	public int getProductDetailCount(String startTime,String overTime){
		if(StringUtils.isBlank(startTime)){startTime = "";}if(StringUtils.isBlank(overTime)){overTime = "";};
		return productService.getProductDetailCount(startTime, overTime);
	}
	
	/**
	 * 在售商品子商品总数之和
	 * @param startTime 开始时间
	 * @param overTime 结束时间
	 * @return int
	 */
	@RequestMapping("/getProductDetailCountEd")
	@ResponseBody
	public int getProductDetailCountEd(String startTime,String overTime){
		if(StringUtils.isBlank(startTime)){startTime = "";}if(StringUtils.isBlank(overTime)){overTime = "";};
		return productService.getProductDetailCountEd(startTime, overTime);
	}
	
	/**
	 *获取一级分类  二级分类  三级分类 
	 */
	@RequestMapping(value = "/getCategory", method = {RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public List<Map<String, Object>> getCategory(String data) {
		return proService.getCategory(data);
	}
	
	/**
	 * 销量商品排名
	 * @param startDate
	 * @param endDate
	 * @param saleNum
	 * @return
	 */
	@RequestMapping(value = "/productTopRank", method = {RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Map<String, Object> getSaleTopRank(proModel pro){
		PageContextUtils pageUtils = new PageContextUtils();
		pageUtils.setPageSize(pro.getPageSize());
		pageUtils.setCurrentPage(pro.getCurrentPage());
		int pageSize = pageUtils.getPageSize();
		if (pageSize != 0) {
			int count = Integer.parseInt(pro.getSaleNum());
			pageUtils.setTotalCount(count);
		}
		int currentPage = pageUtils.getCurrentPage();
		int totalPage = pageUtils.getTotalPage();
		pro.setCurrentPage(currentPage);
		pro.setPageSize(pageSize);
		Map<String,Object> map = new HashMap<String, Object>();
		Map<String,Object> productSaleTopRank = proService.getSaleTopRank(pro);
		if (productSaleTopRank !=null && productSaleTopRank.size() > 0) {
			map.put("productSaleTopRank", productSaleTopRank);
			map.put("totalPage", totalPage);
			return map;
		}
		return null;
	}
	@RequestMapping("productTopRankByPage")
	@ResponseBody
	public List<Map<String, Object>> productTopRankByPage(String productListJson,int currentPage,int pageSize) {
		@SuppressWarnings("unchecked")
		List<Map<String,Object>> productList = JSON.parseObject(productListJson,ArrayList.class);
		List<Map<String, Object>> productListByPage = proService.getSaleToRankByPage(productList,currentPage,pageSize);
		return productListByPage;
	}
	/**
	 * 销量额商品排名
	 * @param startDate
	 * @param endDate
	 * @param saleNum
	 * @return
	 */
	@RequestMapping(value = "/productSaleTopRank", method = {RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Map<String, Object> productSaleTopRank(proModel pro){
		PageContextUtils pageUtils = new PageContextUtils();
		pageUtils.setCurrentPage(pro.getCurrentPage());
		pageUtils.setPageSize(pro.getPageSize());
		int pageSize = pageUtils.getPageSize();
		if (pageSize != 0) {
			int count = Integer.parseInt(pro.getSaleNum());
			pageUtils.setTotalCount(count);
		}
		int currentPage = pageUtils.getCurrentPage();
		int totalPage = pageUtils.getTotalPage();
		pro.setCurrentPage(currentPage);
		pro.setPageSize(pageSize);
		Map<String,Object> map = new HashMap<String, Object>();
		Map<String,Object> productSaleTopRank = proService.getProductSaleTopRank(pro);
		if (productSaleTopRank !=null && productSaleTopRank.size() > 0) {
			map.put("productSaleTopRank", productSaleTopRank);
			map.put("totalPage", totalPage);
			return map;
		}
		return null;
	}
	@RequestMapping("getProductSaleTopRankByPage")
	@ResponseBody
	public List<Map<String, Object>> getProductSaleTopRankByPage(String productListJson,int currentPage,int pageSize) {
		@SuppressWarnings("unchecked")
		List<Map<String,Object>> productList = JSON.parseObject(productListJson,ArrayList.class);
		List<Map<String, Object>> productListByPage = proService.getProductSaleTopRankByPage(productList,currentPage,pageSize);
		return productListByPage;
	}
	/**
	 * 各品类销售
	 * @param startDate
	 * @param endDate
	 * @param pageUtils
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = "/getProductProportion", method = {RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Map<String, Object>  getProductProportion(String propDate,String shortName,String startDate,String endDate,PageContextUtils pageUtils) throws UnsupportedEncodingException{
		int pageSize = pageUtils.getPageSize();
		if (pageSize != 0) {
			int count = proService.getProductSalesCount(startDate, endDate,shortName);
			pageUtils.setTotalCount(count);
		}
		int currentPage = pageUtils.getCurrentPage();
		int totalPage = pageUtils.getTotalPage();
		
		Map<String,Object> map = new HashMap<String, Object>();
		List<Map<String,Object>> productProportion = proService.getProductProportion(startDate, endDate,shortName, currentPage, pageSize);
		List<Map<String, Object>> productCateList = proService.productCateList(startDate,endDate,propDate,shortName,currentPage,pageSize);
		if (productProportion != null && productProportion.size() > 0) {
 			map.put("ProductProportion", productProportion);
			map.put("productCateList", productCateList);
			map.put("totalPage", totalPage);
			return map;
		}
		return null;
	} 
	/**
	 * 按时间点查询各品类销售
	 */
	@RequestMapping(value = "/getProductTimingProportion", method = {RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Map<String, Object>  getProductTimingProportion(String propDate,String shortName,PageContextUtils pageUtils) throws UnsupportedEncodingException{
		int pageSize = pageUtils.getPageSize();
		if (pageSize != 0) {
			int count = proService.getProductTimingSalesCount(propDate,shortName);
			if(count==0) {
				count=1;
			}
			pageUtils.setTotalCount(count);
		}
		int currentPage = pageUtils.getCurrentPage();
		int totalPage = pageUtils.getTotalPage();
		
		Map<String,Object> map = new HashMap<String, Object>();
		List<Map<String,Object>> productProportion = proService.getProductTimingProportion(propDate,shortName, currentPage, pageSize);
		List<Map<String, Object>> productCateList = proService.productTimingCateList(propDate,shortName,currentPage,pageSize);
		if (productCateList != null && productCateList.size() > 0) {
 			map.put("ProductProportion", productProportion);
			map.put("productCateList", productCateList);
			map.put("totalPage", totalPage);
			return map;
		}
		return null;
	} 
	/**
	 * 查询所有的供应商
	 */
	@RequestMapping("/getSupplier")
	@ResponseBody
	public List<Map<String, Object>> getSupplier() {
		
		return proService.getSupplier();
	}
	/**
	 * SKU总量分析
	 * @param orderYear
	 * @return
	 */
	@RequestMapping(value = "/productTotal", method = {RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public List<OrderModel> orderTotal(String productYear) {
		List<OrderModel> list = proService.productTotalList(productYear);
		return list;
	}
}
