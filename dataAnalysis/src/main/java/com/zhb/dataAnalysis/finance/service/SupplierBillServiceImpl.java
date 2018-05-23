package com.zhb.dataAnalysis.finance.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhb.dataAnalysis.common.repository.database.finance.SupplierBillDao;
import com.zhb.dataAnalysis.common.repository.database.model.SupplierBill;
import com.zhb.dataAnalysis.finance.api.SupplierBillService;

@Service("supplierBillServiceImpl")
public class SupplierBillServiceImpl implements SupplierBillService{
	
	@Resource(name="supplierBillDao")
	private SupplierBillDao supplierBillDao;

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
	@Override
	public Map<String,Object> supplierBillListByPage(int rows, int page, String supplierBillPrev, String supplierBillNext,String shortName,String activity, int data,boolean payBox) {
		System.out.println("supplierBillListByPage======"+payBox);
//		System.out.println("supplierBillListByPage======"+shortName);
		Map<String,Object> map = new HashMap<String,Object>();
		List<SupplierBill> list = new ArrayList<SupplierBill>();
		String isLpk="1";
		if(payBox){
			isLpk="2";
		}
		if(data != 0) {
			list = supplierBillDao.getSupplierBillList2(supplierBillPrev, supplierBillNext, shortName, activity, data,isLpk);
		}else if(data == 0) {
			list = this.supplierTotal(supplierBillPrev, supplierBillNext, shortName, activity, data,isLpk);
		}
		DecimalFormat df = new DecimalFormat("0.0000");
		int sumNum = 0;//商品总数
		Double sumMoney = 0.00;//总供货价
		int activitySumNum = 0;//活动商品总数
		Double activitySumMoney = 0.00;//活动商品总供货价
		int unActivitySumNum = 0;//非活动商品总数
		Double unActivitySumMoney = 0.00;//非活动商品总供货价
		for (SupplierBill supplierBill : list) {
			sumNum += supplierBill.getNum();
			sumMoney += supplierBill.getMoney()==null?0:supplierBill.getMoney();
			if(supplierBill.getActivity().equals("活动类")){
				activitySumNum += supplierBill.getNum();
				activitySumMoney += supplierBill.getMoney();
			}
			if(supplierBill.getActivity().equals("非活动类")){
				unActivitySumNum += supplierBill.getNum();
				unActivitySumMoney += supplierBill.getMoney()==null?0: supplierBill.getMoney();
			}
		}
		map.put("sumNum", sumNum);
		map.put("sumMoney", df.format(sumMoney));
		map.put("activitySumNum", activitySumNum);
		map.put("activitySumMoney", df.format(activitySumMoney));
		map.put("unActivitySumNum", unActivitySumNum);
		map.put("unActivitySumMoney", df.format(unActivitySumMoney));
		map.put("total", list.size());
		if(rows > 0 && page > 0){
			int lastIndex = rows*page;
			int index = (page-1)*rows;
			int size = list.size();
			if (lastIndex <= size) {
				list = list.subList(index, lastIndex);
			} else {
				list = list.subList(index, size);
			}
		}
		map.put("rows", list);
		return map;
	}
	
	@Override
	public List<SupplierBill> getSupplierBillList(String supplierBillPrev,
			String supplierBillNext, String shortName, String activity, int data,boolean payBox) {
		List<SupplierBill> list = new ArrayList<SupplierBill>();
		String isLpk="1";
		if(payBox){
			isLpk="2";
		}
		if(data != 0) {
			list = supplierBillDao.getSupplierBillList2(supplierBillPrev, supplierBillNext, shortName, activity, data,isLpk);
		}else if(data == 0) {
			list = this.supplierTotal(supplierBillPrev, supplierBillNext, shortName, activity, data,isLpk);
		}
		return list;
	}
	
	public List<SupplierBill> supplierTotal(String supplierBillPrev,
			String supplierBillNext, String shortName, String activity, int data,String isLpk) {
		List<SupplierBill> list1 = supplierBillDao.getSupplierBillList2(supplierBillPrev,supplierBillNext,shortName,activity, 1,isLpk);
		List<SupplierBill> list2 = supplierBillDao.getSupplierBillList2(supplierBillPrev,supplierBillNext,shortName,activity, 2,isLpk);
		list1.addAll(list2);
		return list1;
	}
	
	
	
	/**
	 * 供应商对账单商品求和  暂时没用
	 */
	@Override
	public Map<String, Object> supplierBillList(String supplierBillPrev,String supplierBillNext,String shortName,String activity, int data,boolean payBox) {
		;
		Map<String,Object> map = new HashMap<String,Object>();
		List<SupplierBill> list = new ArrayList<SupplierBill>();
		String isLpk="1";
		if(payBox){
			isLpk="2";
		}
		if(data != 0) {
			list = this.getSupplierBillList(supplierBillPrev, supplierBillNext, shortName, activity, data,payBox);
		}else if(data == 0) {
			list = this.supplierTotal(supplierBillPrev, supplierBillNext, shortName, activity, data,isLpk);
		}
//		DecimalFormat df = (DecimalFormat) NumberFormat.getInstance();
//		df.setMaximumFractionDigits(4);//保留四位小数
		DecimalFormat df = new DecimalFormat("0.0000");
		int sumNum = 0;//商品总数
		Double sumMoney = 0.00;//总供货价
		int activitySumNum = 0;//活动商品总数
		Double activitySumMoney = 0.00;//活动商品总供货价
		int unActivitySumNum = 0;//非活动商品总数
		Double unActivitySumMoney = 0.00;//非活动商品总供货价
		for (SupplierBill supplierBill : list) {
			sumNum += supplierBill.getNum();
			sumMoney += supplierBill.getMoney();
			if(supplierBill.getActivity().equals("活动类")){
				activitySumNum += supplierBill.getNum();
				activitySumMoney += supplierBill.getMoney();
			}
			if(supplierBill.getActivity().equals("非活动类")){
				unActivitySumNum += supplierBill.getNum();
				unActivitySumMoney += supplierBill.getMoney();
			}
		}
		map.put("sumNum", sumNum);
		map.put("sumMoney", df.format(sumMoney));
		map.put("activitySumNum", activitySumNum);
		map.put("activitySumMoney", df.format(activitySumMoney));
		map.put("unActivitySumNum", unActivitySumNum);
		map.put("unActivitySumMoney", df.format(unActivitySumMoney));
		return map;
	}
	
}
