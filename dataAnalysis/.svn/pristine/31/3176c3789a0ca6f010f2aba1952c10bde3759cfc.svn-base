package com.zhb.dataAnalysis.common.repository.database.model;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;

public class PayPlatformModel implements Serializable,Comparable<PayPlatformModel>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String test;
	private String orderMain;
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
	private BigDecimal payCash;
	private BigDecimal returnCash;
	private BigDecimal serviceCash;
	private BigDecimal cash;
	private String payCash1;
	private String returnCash1;
	private String serviceCash1;
	private String cash1;
	private String rate1;
	private BigDecimal rate;
	private String createTime;
	private String bussinesschannel;
	private String orderSource;
	
	public String getTest() {
		return test;
	}
	public void setTest(String test) {
		this.test = test;
	}
	public String getOrderMain() {
		return orderMain;
	}
	public void setOrderMain(String orderMain) {
		this.orderMain = orderMain;
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
	public BigDecimal getPayCash() {
		return payCash;
	}
	public void setPayCash(BigDecimal payCash) {
		this.payCash = payCash;
	}
	public BigDecimal getReturnCash() {
		return returnCash;
	}
	public void setReturnCash(BigDecimal returnCash) {
		this.returnCash = returnCash;
	}
	public BigDecimal getServiceCash() {
		return serviceCash;
	}
	public void setServiceCash(BigDecimal serviceCash) {
		this.serviceCash = serviceCash;
	}
	public BigDecimal getCash() {
		return cash;
	}
	public void setCash(BigDecimal cash) {
		this.cash = cash;
	}
	public BigDecimal getRate() {
		return rate;
	}
	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}
	public String getCreateTime() {
		if(StringUtils.isNotBlank(createTime)){
			int index = createTime.lastIndexOf(".");
			if(index != -1)
				createTime = createTime.substring(0,index);
		}
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getBussinesschannel() {
		return bussinesschannel;
	}
	public void setBussinesschannel(String bussinesschannel) {
		this.bussinesschannel = bussinesschannel;
	}
	public String getOrderSource() {
		return orderSource;
	}
	public void setOrderSource(String orderSource) {
		this.orderSource = orderSource;
	}
	public String getPayCash1() {
		return payCash1;
	}
	public void setPayCash1(String payCash1) {
		this.payCash1 = payCash1;
	}
	public String getReturnCash1() {
		return returnCash1;
	}
	public void setReturnCash1(String returnCash1) {
		this.returnCash1 = returnCash1;
	}
	public String getServiceCash1() {
		return serviceCash1;
	}
	public void setServiceCash1(String serviceCash1) {
		this.serviceCash1 = serviceCash1;
	}
	public String getCash1() {
		return cash1;
	}
	public void setCash1(String cash1) {
		this.cash1 = cash1;
	}
	public String getRate1() {
		return rate1;
	}
	public void setRate1(String rate1) {
		this.rate1 = rate1;
	}
	@Override
	public int compareTo(PayPlatformModel o) {
		if(this.createTime.compareTo(o.createTime)>0) {
			return -1;
		}
		if(this.createTime.compareTo(o.createTime)<0) {
			return 1;
		}
		return 0;
	}
}
