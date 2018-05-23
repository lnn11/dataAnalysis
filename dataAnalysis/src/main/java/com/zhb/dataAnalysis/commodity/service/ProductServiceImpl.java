package com.zhb.dataAnalysis.commodity.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.zhb.dataAnalysis.common.repository.database.model.OrderModel;
import com.zhb.dataAnalysis.common.repository.database.model.proModel;
import com.zhb.dataAnalysis.common.repository.database.product.ProductDao;
import com.zhb.dataAnalysis.commodity.api.ProductService;

@Service("productServiceImpl")
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao productDao;
	/**
	 * 销量排名
	 */
	@Override
	public Map<String,Object> getSaleTopRank(proModel pro) {
		Map<String, Object> map1 = new HashMap<String,Object>();
		List<Map<String, Object>> productList = productDao.getSaleTopRank(pro);
		int i=1;
		if(productList!=null&&productList.size()>0) {
			for (Map<String, Object> map : productList) {
				map.put("num", i);
				i++;
			}
			int size = 0;
			if(productList.size()%pro.getPageSize()==0) {
				size = productList.size()/pro.getPageSize();
			}
			else{
				size = productList.size()/pro.getPageSize()+1;
			}
			List<Map<String, Object>> productListByPage = getSaleToRankByPage(productList,pro.getCurrentPage(),pro.getPageSize());
			map1.put("size", size);
			map1.put("productList", productList);
			map1.put("productListJson", JSON.toJSONString(productList, true));
			map1.put("productListByPage", productListByPage);
			return map1;
		}
		return null;
	}
	@Override
	public List<Map<String,Object>> getSaleToRankByPage(List<Map<String,Object>> productList,int currentPage,int pageSize) {
		int lastIndex = currentPage*pageSize;
		int index = (currentPage-1)*pageSize;
		if(productList!=null&&productList.size()!=0){
			int productListSize = productList.size();
			List<Map<String,Object>> productListBPage;
			if (lastIndex <= productListSize) {
				productListBPage = productList.subList(index, lastIndex);
			} else {
				productListBPage = productList.subList(index, productListSize);
			}
			return productListBPage;
		}
		return null;
	}
	/**
	 * 销售额排名
	 */
	@Override
	public Map<String,Object> getProductSaleTopRank(proModel pro) {
		Map<String, Object> map1 = new HashMap<String,Object>();
		List<Map<String, Object>> productList = productDao.getProductSaleTopRank(pro);
		if(productList!=null&&productList.size()>0) {
			int i=1;
			for (Map<String, Object> map : productList) {
				map.put("num", i);
				i++;
			}
			int size = 0;
			if(productList.size()%pro.getPageSize()==0) {
				size = productList.size()/pro.getPageSize();
			}
			else{
				size = productList.size()/pro.getPageSize()+1;
			}
			List<Map<String, Object>> productListByPage = getProductSaleTopRankByPage(productList,pro.getCurrentPage(),pro.getPageSize());
			map1.put("size", size);
			map1.put("productList", productList);
			map1.put("productListJson", JSON.toJSONString(productList, true));
			map1.put("productListByPage", productListByPage);
			return map1;
		}
		return null;
	}
	@Override
	public List<Map<String,Object>> getProductSaleTopRankByPage(List<Map<String,Object>> productList,int currentPage,int pageSize) {
		int lastIndex = currentPage*pageSize;
		int index = (currentPage-1)*pageSize;
		if(productList!=null&&productList.size()>0) {
			int productListSize = productList.size();
			List<Map<String,Object>> productListBPage;
			if (lastIndex <= productListSize) {
				productListBPage = productList.subList(index, lastIndex);
			} else {
				productListBPage = productList.subList(index, productListSize);
			}
			return productListBPage;
		}
		return null;
	}
	/**
	 * 获取各品类销售占比
	 */
	@Override
	public List<Map<String,Object>> getProductProportion(String startDate,String endDate,String shortName,int currentPage, int pageSize) {
		if(currentPage==0){
			currentPage=1;
		}
		DecimalFormat df = (DecimalFormat) NumberFormat.getInstance();
		df.setMaximumFractionDigits(2);
		df.setRoundingMode(RoundingMode.HALF_UP);
		
		//获取产品类别和销售额、销量
		List<Map<String,Object>> productSaleList = productDao.getProductSaleParams(startDate, endDate,currentPage,pageSize,shortName); 
		double productTotalNum = productDao.getProductTotalNum(startDate, endDate,shortName);
		double productTotalSal = productDao.getProductTotalSal(startDate, endDate,shortName);
		for (Map<String, Object> map : productSaleList) {
			Double totalNum = ((BigDecimal) map.get("TOTALNUM")).doubleValue();
			Double numProp = (Double) (totalNum/productTotalNum*100);
			map.put("productNumProp", df.format(numProp));
			double salVol = ((BigDecimal) map.get("SALVOL")).doubleValue();
			Double salProp = (Double) (salVol/productTotalSal*100);
			map.put("productSaleProp", df.format(salProp));
		}
		
		return productSaleList;
	}
	/**
	 * 统计上架商品的spu,sku总数 
	 */
	@Override
	public List<Map<String,Object>> productCateList(String startDate,String endDate,String propDate,String shortName, int pageSize, int currentPage) {
		if(currentPage==0){
			currentPage=1;
		}
		List<Map<String,Object>> productCateList = productDao.getProductCateList(startDate,endDate,propDate,shortName);
		
		//一级分类spu,sku总数
		List<Map<String,Object>> getProductCateTotal = productDao.getProductCateTotal(startDate,endDate,propDate,shortName,pageSize,currentPage);
		
		List<Map<String,Object>> plist = new ArrayList<Map<String,Object>>();
		
		for(Map<String,Object> m :getProductCateTotal){
			String tname = (String) m.get("TNAME");
			Object tpto = m.get("TPTOTALNUM");
			Object talnum = m.get("TPDTOTALNUM");
			Map<String,Object> pmap = new HashMap<String,Object>();
			pmap.put("tname", tname);
			List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
			for(Map<String,Object> m1 :productCateList){
				String pname = (String) m1.get("TNAME");
				if(tname.equals(pname)){
					list.add(m1);
				}
			}
			Map<String,Object> little = new HashMap<String,Object>();
			little.put("PNAME","小计");
			little.put("TPTOTALNUM",tpto);
			little.put("TPDTOTALNUM",talnum);
			list.add(little);
			pmap.put("list", list);
			plist.add(pmap);
		}
		
		return plist;
	}

	@Override
	public int getProductSalesCount(String startDate, String endDate,String shortName) {
		int num = 0;
		num = productDao.getProductSalesCount(startDate, endDate,shortName);
		return num;
	}

	@Override
	public List<OrderModel> productTotalList(String productYear) {
		List<OrderModel> list = productDao.productTotalList(productYear);
		List<OrderModel> list1 = productDao.productTotalSaleList(productYear);
		for (OrderModel orderModel : list) {
			for (OrderModel orderModel1 : list1) {
				if (orderModel.getOrderMonth()==orderModel1.getOrderMonth()) {
					orderModel.setOrderSumIntegral(orderModel1.getOrderSumIntegral());
					orderModel.setSumNum(orderModel1.getSumNum());
				}
			}
		}
		int array[] = {1,2,3,4,5,6,7,8,9,10,11,12};
		List<OrderModel> list2 = new ArrayList<OrderModel>(); 
		for (int i = 1; i <= array.length; i++) {
			Boolean flag = false;
			for (OrderModel orderModel : list) {
				if (orderModel.getOrderMonth()==i) {
					flag = true;
				}
			}
			if(flag == false){
				OrderModel orderModel = new OrderModel();
				orderModel.setOrderMonth(i);
				orderModel.setOrderNum(0);
				orderModel.setOrderSumIntegral(0.00);
				orderModel.setSumNum(0);
				list2.add(orderModel);
			}
		}
		list2.addAll(list);
		DecimalFormat df = (DecimalFormat) NumberFormat.getInstance();
		df.setMaximumFractionDigits(2);//保留两位小数
		Double orderSum = 0.00;//订单总数
		Double orderIntegralSum = 0.00;//销售额总数
		Double orderSumNum = 0.00;//销量总数
		for (OrderModel orderModel : list2) {
			orderSum +=orderModel.getOrderNum();
			orderSumNum += orderModel.getSumNum();
			orderIntegralSum += orderModel.getOrderSumIntegral();
		}
		for (OrderModel orderModel : list2) {
			if (orderSum == 0.00) {
				orderModel.setOrderProp("0");
				orderModel.setSumNumProp("0");
				orderModel.setOrderIntegralProp("0");
			}else {
				orderModel.setOrderProp(df.format(orderModel.getOrderNum()/orderSum*100));
				orderModel.setSumNumProp(df.format(orderModel.getSumNum()/orderSumNum*100));
				orderModel.setOrderIntegralProp(df.format(orderModel.getOrderSumIntegral()/orderIntegralSum*100));
			}
		}
		//对结果集进行排序处理
		List<OrderModel> list3 = new ArrayList<OrderModel>();
		for(int i=1; i<=12; i++){
			for (OrderModel orderModel : list2) {
				if(orderModel.getOrderMonth()==i){
					list3.add(orderModel);
				}
			}
		}
		return list3;
	}
	/**
	 * 获取所有的供应商
	 */
	@Override
	public List<Map<String, Object>> getSupplier() {
		return productDao.getSupplier();
	}
	/**
	 * 按时间点查询条数
	 */
	@Override
	public int getProductTimingSalesCount(String propDate, String shortName) {
		int num = 0;
		num = productDao.getProductTimingSalesCount(propDate,shortName);
		return num;
	}
	/**
	 * 按时间点查询销量 销售额的占比
	 */
	@Override
	public List<Map<String, Object>> getProductTimingProportion(
			String propDate, String shortName, int currentPage, int pageSize) {
		if(currentPage==0){
			currentPage=1;
		}
		DecimalFormat df = (DecimalFormat) NumberFormat.getInstance();
		df.setMaximumFractionDigits(2);
		df.setRoundingMode(RoundingMode.HALF_UP);
		
		//获取产品类别和销售额、销量
		List<Map<String,Object>> productSaleList = productDao.getProductTimingSaleParams(propDate,currentPage,pageSize,shortName); 
		double productTotalNum = productDao.getProductTimingTotalNum(propDate,shortName);
		double productTotalSal = productDao.getProductTimingTotalSal(propDate,shortName);
		for (Map<String, Object> map : productSaleList) {
			Double totalNum = ((BigDecimal) map.get("TOTALNUM")).doubleValue();
			Double numProp = (Double) (totalNum/productTotalNum*100);
			map.put("productNumProp", df.format(numProp));
			double salVol = ((BigDecimal) map.get("SALVOL")).doubleValue();
			Double salProp = (Double) (salVol/productTotalSal*100);
			map.put("productSaleProp", df.format(salProp));
		}
		
		return productSaleList;
		
		
	}
	/**
	 * 按时间点查询一级分类 二级分类的spu  SKU
	 */
	@Override
	public List<Map<String, Object>> productTimingCateList(String propDate,
			 String shortName, int currentPage, int pageSize) {
		if(currentPage==0){
			currentPage=1;
		}
		List<Map<String,Object>> productCateList = productDao.getProductTimingCateList(propDate,shortName);
		//一级分类spu,sku总数
		List<Map<String,Object>> getProductCateTotal = productDao.getProductTimingCateTotal(propDate,shortName,pageSize,currentPage);
		
		List<Map<String,Object>> plist = new ArrayList<Map<String,Object>>();
		
		for(Map<String,Object> m :getProductCateTotal){
			String tname = (String) m.get("TNAME");
			Object tpto = m.get("TPTOTALNUM");
			Object talnum = m.get("TPDTOTALNUM");
			Map<String,Object> pmap = new HashMap<String,Object>();
			pmap.put("tname", tname);
			List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
			for(Map<String,Object> m1 :productCateList){
				String pname = (String) m1.get("TNAME");
				if(tname.equals(pname)){
					list.add(m1);
				}
			}
			Map<String,Object> little = new HashMap<String,Object>();
			little.put("PNAME","小计");
			little.put("TPTOTALNUM",tpto);
			little.put("TPDTOTALNUM",talnum);
			list.add(little);
			pmap.put("list", list);
			plist.add(pmap);
		}
		
		return plist;
	}
	/**
	 * 获取一级分类  二级分类  三级分类
	 */
	@Override
	public List<Map<String, Object>> getCategory(String data) {
		return productDao.getCategory(data);
	}
}
