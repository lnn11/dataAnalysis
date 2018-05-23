package com.zhb.dataAnalysis.common.repository.database.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class PayPlatForm implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5920073367540091915L;
	
	
	private String orderMains;
	private String payID;
	private String paySourse;
	private String channel;
	private BigDecimal payCashStart;
	private BigDecimal payCashsEnd;
	private BigDecimal cashStart;
	private BigDecimal cashEnd;
	private BigDecimal returnCashStart;
	private BigDecimal returnCashEnd;
	private BigDecimal serviceCashStart;
	private BigDecimal serviceCashEnd;
	private String startDate;
	private String endDate;
	private int rows;
	private int page;
	public String getOrderMains() {
		return orderMains;
	}
	public void setOrderMains(String orderMains) {
		this.orderMains = orderMains;
	}
	public String getPayID() {
		return payID;
	}
	public void setPayID(String payID) {
		this.payID = payID;
	}
	public String getPaySourse() {
		return paySourse;
	}
	public void setPaySourse(String paySourse) {
		this.paySourse = paySourse;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public BigDecimal getPayCashStart() {
		return payCashStart;
	}
	public void setPayCashStart(BigDecimal payCashStart) {
		this.payCashStart = payCashStart;
	}
	public BigDecimal getPayCashsEnd() {
		return payCashsEnd;
	}
	public void setPayCashsEnd(BigDecimal payCashsEnd) {
		this.payCashsEnd = payCashsEnd;
	}
	public BigDecimal getCashStart() {
		return cashStart;
	}
	public void setCashStart(BigDecimal cashStart) {
		this.cashStart = cashStart;
	}
	public BigDecimal getCashEnd() {
		return cashEnd;
	}
	public void setCashEnd(BigDecimal cashEnd) {
		this.cashEnd = cashEnd;
	}
	public BigDecimal getReturnCashStart() {
		return returnCashStart;
	}
	public void setReturnCashStart(BigDecimal returnCashStart) {
		this.returnCashStart = returnCashStart;
	}
	public BigDecimal getReturnCashEnd() {
		return returnCashEnd;
	}
	public void setReturnCashEnd(BigDecimal returnCashEnd) {
		this.returnCashEnd = returnCashEnd;
	}
	public BigDecimal getServiceCashStart() {
		return serviceCashStart;
	}
	public void setServiceCashStart(BigDecimal serviceCashStart) {
		this.serviceCashStart = serviceCashStart;
	}
	public BigDecimal getServiceCashEnd() {
		return serviceCashEnd;
	}
	public void setServiceCashEnd(BigDecimal serviceCashEnd) {
		this.serviceCashEnd = serviceCashEnd;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
}
