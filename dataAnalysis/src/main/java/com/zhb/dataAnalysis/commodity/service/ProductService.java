package com.zhb.dataAnalysis.commodity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhb.dataAnalysis.commodity.api.IProduct;
import com.zhb.dataAnalysis.common.repository.database.product.ProductDao;

@Service("productService")
public class ProductService implements IProduct {

	@Autowired
	private ProductDao productDao;
	
	@Override
	public int getProductDetailCount(String startTime, String overTime) {
		return productDao.getProductDetailCount(startTime, overTime);
	}

	@Override
	public int getProductDetailCountEd(String startTime, String overTime) {
		return productDao.getProductDetailCountEd(startTime, overTime);
	}
}