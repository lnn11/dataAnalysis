package com.zhb.dataAnalysis.common.repository.database.product;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zhb.dataAnalysis.common.repository.database.model.OrderModel;
import com.zhb.dataAnalysis.common.repository.database.model.proModel;

@Repository("productDao")
public interface ProductDao {

	/**
	 * 在售商品子商品总数之和
	 * @param startTime 开始时间
	 * @param overTime 结束时间
	 * @return int
	 */
	int getProductDetailCount(@Param("startTime") String startTime, @Param("overTime") String overTime);
	
	/**
	 * 上架过的子商品总数之和
	 * @param startTime 开始时间
	 * @param overTime 结束时间
	 * @return int
	 */
	int getProductDetailCountEd(@Param("startTime") String startTime, @Param("overTime") String overTime);
	
	/**
	 * 获取销量前十商品排行
	 * @param startDate
	 * @param endDate
	 * @param saleNum 
	 * @param numOrderBy 
	 * @return
	 */
	public List<Map<String, Object>> getSaleTopRank(@Param("pro") proModel pro);

	/**
	 * 获取销量前十商品排行销售额
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<Map<String, Object>> gerSaleTop(@Param("startDate") String startDate, @Param("endDate") String endDate);
	
	/**
	 * 获取产品类别和销售额、销量
	 * @param startDate
	 * @param endDate
	 * @param pageSize 
	 * @param currentPage 
	 * @param shortName 
	 * @return
	 */
	public List<Map<String,Object>> getProductSaleParams(@Param("startDate") String startDate, @Param("endDate") String endDate,
														 @Param("currentPage") int currentPage, @Param("pageSize") int pageSize, @Param("shortName") String shortName);
	/**
	 * 获取产品总的销量
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public double getProductTotalNum(@Param("startDate") String startDate, @Param("endDate") String endDate, @Param("shortName") String shortName);
	
	/**
	 * 获取产品总的销售额
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public double getProductTotalSal(@Param("startDate") String startDate, @Param("endDate") String endDate, @Param("shortName") String shortName);

	/**
	 * 获取各品类销售总条数
	 * @param startDate
	 * @param endDate
	 * @param shortName 
	 * @return
	 */
	public int getProductSalesCount(@Param("startDate") String startDate, @Param("endDate") String endDate, @Param("shortName") String shortName);

	/**
	 * SKU总量分析
	 * @param productYear
	 * @return
	 */
	public List<OrderModel> productTotalSaleList(@Param("productYear") String productYear);

	/**
	 * SKU总量分析
	 * @param productYear
	 * @return
	 */
	public List<OrderModel> productTotalList(@Param("productYear") String productYear);

	/**
	 * 销售额商品排名
	 * @param startDate
	 * @param endDate
	 * @param saleNum
	 * @return
	 */
	List<Map<String, Object>> getProductSaleTopRank(@Param("pro") proModel pro);

	/**
	 * 获取所有的供应商
	 * @return
	 */
	List<Map<String, Object>> getSupplier();

	/**
	 *  统计上架商品的spu,sku总数 
	 * @return
	 */
	List<Map<String, Object>> getProductCateList(@Param("startDate") String startDate,
												 @Param("endDate") String endDate, @Param("propDate") String propDate, @Param("shortName") String shortName);
	/**
	 * 一级分类商品spu，sku总数
	 * @param currentPage 
	 * @param pageSize 
	 */
	List<Map<String, Object>> getProductCateTotal(@Param("startDate") String startDate,
												  @Param("endDate") String endDate, @Param("propDate") String propDate, @Param("shortName") String shortName,
												  @Param("currentPage") int currentPage, @Param("pageSize") int pageSize);

	
	int getProductTimingSalesCount(@Param("propDate") String propDate, @Param("shortName") String shortName);

	List<Map<String, Object>> getProductTimingCateList(@Param("propDate") String propDate,
													   @Param("shortName") String shortName);

	List<Map<String, Object>> getProductTimingCateTotal(@Param("propDate") String propDate,
														@Param("shortName") String shortName, @Param("pageSize") int pageSize, @Param("currentPage") int currentPage);

	List<Map<String, Object>> getProductTimingSaleParams(@Param("propDate") String propDate,
														 @Param("currentPage") int currentPage, @Param("pageSize") int pageSize, @Param("shortName") String shortName);

	double getProductTimingTotalNum(@Param("propDate") String propDate, @Param("shortName") String shortName);

	double getProductTimingTotalSal(@Param("propDate") String propDate, @Param("shortName") String shortName);
	
	/**
	 * 获取一级分类  二级分类  三级分类
	 * @param data
	 * @return
	 */
	List<Map<String, Object>> getCategory(@Param("data") String data);
}