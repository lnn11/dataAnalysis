package com.zhb.dataAnalysis.common.repository.database.model;

public class OrderModel {

	private int orderNum;//每月订单数量
	private int orderMonth;//月份
	private Double orderSumIntegral;//订单总销售额
	private String orderProp;//订单数量对比
	private String orderIntegralProp;//订单总销售额对比
	private Double orderSum;//总订单
	private Double orderIntegralSum;//总销单额
	private Double orderSumIntegrals;//订单总积分
	private int sumNum;//销量
	private String sumNumProp;//销量占比
	private String sname;//供应商名称
	
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public int getOrderMonth() {
		return orderMonth;
	}
	public void setOrderMonth(int orderMonth) {
		this.orderMonth = orderMonth;
	}
	public String getOrderProp() {
		return orderProp;
	}
	public void setOrderProp(String orderProp) {
		this.orderProp = orderProp;
	}
	public String getOrderIntegralProp() {
		return orderIntegralProp;
	}
	public void setOrderIntegralProp(String orderIntegralProp) {
		this.orderIntegralProp = orderIntegralProp;
	}
	public Double getOrderSum() {
		return orderSum;
	}
	public void setOrderSum(Double orderSum) {
		this.orderSum = orderSum;
	}
	public Double getOrderIntegralSum() {
		return orderIntegralSum;
	}
	public void setOrderIntegralSum(Double orderIntegralSum) {
		this.orderIntegralSum = orderIntegralSum;
	}
	public Double getOrderSumIntegral() {
		return orderSumIntegral;
	}
	public void setOrderSumIntegral(Double orderSumIntegral) {
		this.orderSumIntegral = orderSumIntegral;
	}
	public Double getOrderSumIntegrals() {
		return orderSumIntegrals;
	}
	public void setOrderSumIntegrals(Double orderSumIntegrals) {
		this.orderSumIntegrals = orderSumIntegrals;
	}
	public int getSumNum() {
		return sumNum;
	}
	public void setSumNum(int sumNum) {
		this.sumNum = sumNum;
	}
	public String getSumNumProp() {
		return sumNumProp;
	}
	public void setSumNumProp(String sumNumProp) {
		this.sumNumProp = sumNumProp;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	@Override
	public String toString() {
		return "OrderModel [orderNum=" + orderNum + ", orderMonth="
				+ orderMonth + ", orderSumIntegral=" + orderSumIntegral
				+ ", orderProp=" + orderProp + ", orderIntegralProp="
				+ orderIntegralProp + ", orderSum=" + orderSum
				+ ", orderIntegralSum=" + orderIntegralSum
				+ ", orderSumIntegrals=" + orderSumIntegrals + ", sumNum="
				+ sumNum + ", sumNumProp=" + sumNumProp + ", sname=" + sname
				+ "]";
	}

	
}
