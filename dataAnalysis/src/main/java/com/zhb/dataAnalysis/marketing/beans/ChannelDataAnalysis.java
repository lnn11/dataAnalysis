package com.zhb.dataAnalysis.marketing.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ChannelDataAnalysis implements Serializable{
	
	private static final long serialVersionUID = -189175426063033570L;

	private String channelId;
	private String channelName;
	
	private Integer registers;
	private Integer registerMin;
	private Integer registerMax;
	
	private BigDecimal orders;
	private BigDecimal orderMin;
	private BigDecimal orderMax;
	
	private BigDecimal amounts;
	private BigDecimal amountsMin;
	private BigDecimal amountsMax;	
	
	private BigDecimal actualPay;
	private BigDecimal actualPayMin;
	private BigDecimal actualPayMax;
	
	private Integer reBuyers;
	private Integer reBuyersMin;
	private Integer reBuyersMax;
	
	private BigDecimal pvs;
	private BigDecimal pvMin;
	private BigDecimal pvMax;
	
	private BigDecimal uvs;
	private BigDecimal uvsMin;
	private BigDecimal uvsMax;
	
	private Date date;
	private String startTime;
	private String endTime;
	
	public String getChannelId() {
		return channelId;
	}
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
	public String getChannelName() {
		return channelName;
	}
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	public Integer getRegisters() {
		return registers;
	}
	public void setRegisters(Integer registers) {
		this.registers = registers;
	}
	public Integer getRegisterMin() {
		return registerMin;
	}
	public void setRegisterMin(Integer registerMin) {
		this.registerMin = registerMin;
	}
	public Integer getRegisterMax() {
		return registerMax;
	}
	public void setRegisterMax(Integer registerMax) {
		this.registerMax = registerMax;
	}
	public BigDecimal getOrders() {
		return orders;
	}
	public void setOrders(BigDecimal orders) {
		this.orders = orders;
	}
	public BigDecimal getOrderMin() {
		return orderMin;
	}
	public void setOrderMin(BigDecimal orderMin) {
		this.orderMin = orderMin;
	}
	public BigDecimal getOrderMax() {
		return orderMax;
	}
	public void setOrderMax(BigDecimal orderMax) {
		this.orderMax = orderMax;
	}
	public BigDecimal getAmounts() {
		return amounts;
	}
	public void setAmounts(BigDecimal amounts) {
		this.amounts = amounts;
	}
	public BigDecimal getAmountsMin() {
		return amountsMin;
	}
	public void setAmountsMin(BigDecimal amountsMin) {
		this.amountsMin = amountsMin;
	}
	public BigDecimal getAmountsMax() {
		return amountsMax;
	}
	public void setAmountsMax(BigDecimal amountsMax) {
		this.amountsMax = amountsMax;
	}
	public BigDecimal getActualPay() {
		return actualPay;
	}
	public void setActualPay(BigDecimal actualPay) {
		this.actualPay = actualPay;
	}
	public BigDecimal getActualPayMin() {
		return actualPayMin;
	}
	public void setActualPayMin(BigDecimal actualPayMin) {
		this.actualPayMin = actualPayMin;
	}
	public BigDecimal getActualPayMax() {
		return actualPayMax;
	}
	public void setActualPayMax(BigDecimal actualPayMax) {
		this.actualPayMax = actualPayMax;
	}
	public Integer getReBuyers() {
		return reBuyers;
	}
	public void setReBuyers(Integer reBuyers) {
		this.reBuyers = reBuyers;
	}
	public Integer getReBuyersMin() {
		return reBuyersMin;
	}
	public void setReBuyersMin(Integer reBuyersMin) {
		this.reBuyersMin = reBuyersMin;
	}
	public Integer getReBuyersMax() {
		return reBuyersMax;
	}
	public void setReBuyersMax(Integer reBuyersMax) {
		this.reBuyersMax = reBuyersMax;
	}
	public BigDecimal getPvs() {
		return pvs;
	}
	public void setPvs(BigDecimal pvs) {
		this.pvs = pvs;
	}
	public BigDecimal getPvMin() {
		return pvMin;
	}
	public void setPvMin(BigDecimal pvMin) {
		this.pvMin = pvMin;
	}
	public BigDecimal getPvMax() {
		return pvMax;
	}
	public void setPvMax(BigDecimal pvMax) {
		this.pvMax = pvMax;
	}
	public BigDecimal getUvs() {
		return uvs;
	}
	public void setUvs(BigDecimal uvs) {
		this.uvs = uvs;
	}
	public BigDecimal getUvsMin() {
		return uvsMin;
	}
	public void setUvsMin(BigDecimal uvsMin) {
		this.uvsMin = uvsMin;
	}
	public BigDecimal getUvsMax() {
		return uvsMax;
	}
	public void setUvsMax(BigDecimal uvsMax) {
		this.uvsMax = uvsMax;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
}
