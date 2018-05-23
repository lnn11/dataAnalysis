package com.zhb.dataAnalysis.commodity.api;

import java.util.List;
import java.util.Map;

import com.zhb.dataAnalysis.common.repository.database.model.OrderModel;
import com.zhb.dataAnalysis.common.repository.database.model.proModel;

public interface ProductService {

	/**
	 * 获取销量前十商品排行
	 * @param startDate
	 * @param endDate
	 * @param saleNum 
	 * @param pageSize 
	 * @param currentPage 
	 * @param categoryThree 
	 * @param categoryTwo 
	 * @param categoryOne 
	 * @param numOrderBy 
	 * @return
	 */
	public Map<String,Object>  getSaleTopRank(proModel pro);
	

	public List<Map<String, Object>> getSaleToRankByPage(
			List<Map<String, Object>> productList, int currentPage, int pageSize);

	/**
	 * 获取各品类销售占比
	 * @param startDate
	 * @param endDate
	 * @param shortName 
	 * @param pageSize 
	 * @param currentPage 
	 * @return
	 */
	public List<Map<String,Object>>  getProductProportion(String startDate, String endDate, String shortName, int currentPage, int pageSize);

	/**
	 * 获取各品类销售总条数
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public int getProductSalesCount(String startDate, String endDate, String shortName);

	/**
	 * SKU总量分析
	 * @param productYear
	 * @return
	 */
	public List<OrderModel> productTotalList(String productYear);
	/**
	 * 销售额商品排名
	 * @param startDate
	 * @param endDate
	 * @param saleNum
	 * @param pageSize 
	 * @param currentPage 
	 * @return
	 */
	public Map<String, Object> getProductSaleTopRank(proModel pro);
	
	public List<Map<String, Object>> getProductSaleTopRankByPage(
			List<Map<String, Object>> productList, int currentPage, int pageSize);

	/**
	 * 获取所有的供应商
	 * @return
	 */
	public List<Map<String, Object>> getSupplier();

	/**
	 * @param pageSize 
	 * @param currentPage 
	 * 
	 */
	public List<Map<String, Object>> productCateList(String propDate,
													 String shortName, String startDate, String endDate, int pageSize, int currentPage);

	/**
	 * 按时间点查询数量
	 * @param propDate
	 * @param shortName
	 * @return
	 */
	public int getProductTimingSalesCount(String propDate, String shortName);

	/**
	 * 按时间点查询销量  销售额的占比
	 */
	public List<Map<String, Object>> getProductTimingProportion(String propDate,
																String shortName, int currentPage, int pageSize);

	/**
	 * 按时间点查询一级分类 二级分类的spu SKU
	 */
	public List<Map<String, Object>> productTimingCateList(String propDate,
														   String shortName, int currentPage, int pageSize);

	/**
	 *获取一级分类  二级分类  三级分类 
	 */
	public List<Map<String, Object>> getCategory(String data);

}
