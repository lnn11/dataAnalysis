package com.zhb.dataAnalysis.commodity.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhb.dataAnalysis.commodity.api.ISupplier;
import com.zhb.dataAnalysis.common.repository.database.supplier.SupplierDao;

@Service("supplierService")
public class SupplierService implements ISupplier {

	@Autowired
	private SupplierDao supplierDao;
	
	@Override
	public List<Map<String, Object>> getSupplierSalesNum(String startTime, String overTime,int currentPage,int pageSize) {
		List<Map<String,Object>> list = supplierDao.getSupplierSalesNum(startTime, overTime, currentPage,pageSize);
		DecimalFormat df = (DecimalFormat) NumberFormat.getInstance();
		df.setMaximumFractionDigits(2);
		df.setRoundingMode(RoundingMode.HALF_UP);
		int sumSales = supplierDao.getAllSupplierSumSales(startTime, overTime);
		for (Map<String, Object> map : list) {			
			Double sum = ((BigDecimal)map.get("SUMNUM")).doubleValue();
			if(sumSales == 0){
				map.put("manyBi", 0);
			}else{
				Double i = (Double) (sum/sumSales*100);
				map.put("manyBi", df.format(i));
			}
		}
		return list;
	}

	@Override
	public int getSupplierCount(String startTime, String overTime) {
		return supplierDao.getSupplierCount(startTime, overTime);
	}

	@Override
	public int getAllSupplierSumSales(String startTime, String overTime) {
		return supplierDao.getAllSupplierSumSales(startTime, overTime);
	}

	@Override
	public List<Map<String, Object>> getSupplierSalesVoles(String startTime,
			String overTime, int currentPage, int pageSize) {
		List<Map<String,Object>> list =  supplierDao.getSupplierSalesVoles(startTime, overTime, currentPage,pageSize);
		DecimalFormat df = (DecimalFormat) NumberFormat.getInstance();
		df.setMaximumFractionDigits(2);
		df.setRoundingMode(RoundingMode.HALF_UP);
		double sumSales = supplierDao.getAllSupplierSalesVolues(startTime, overTime);
		for (Map<String, Object> map : list) {			
			Double sumMoney = ((BigDecimal)map.get("SUMMONEY")).doubleValue();
			if(sumSales == 0){
				map.put("manyBi", 0);
			}else{
				Double i = (Double) (sumMoney/sumSales*100);
				map.put("manyBi", df.format(i));
			}
		}
		return list;
	}

	@Override
	public int getSupplierSalesCount(String startTime, String overTime) {
		return supplierDao.getSupplierSalesCount(startTime, overTime);
	}

	@Override
	public double getAllSupplierSalesVolues(String startTime, String overTime) {
		return supplierDao.getAllSupplierSalesVolues(startTime, overTime);
	}

	@Override
	public List<Map<String, Object>> getSupplierDeliverGoodsSpeed(int workingDayNum, String startTime, String overTime, int currentPage, int pageSize) {
			List<Map<String,Object>> list = supplierDao.getSupplierDeliverGoodsSpeed(workingDayNum,startTime, overTime, currentPage,pageSize);
		return list;
	}

	@Override
	public int getSupplierDeliverGoodsSpeedCount(String startTime, String overTime) {
		return supplierDao.getSupplierDeliverGoodsSpeedCount(startTime, overTime);
	}

	@Override
	public int getSupplierCountNum(String startTime, String overTime) {
		return supplierDao.getSupplierCountNum(startTime, overTime);
	}
}