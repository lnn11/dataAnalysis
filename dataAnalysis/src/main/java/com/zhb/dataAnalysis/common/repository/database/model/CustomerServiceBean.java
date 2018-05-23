package com.zhb.dataAnalysis.common.repository.database.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class CustomerServiceBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9092129080696231516L;
	
	/**
	 * 公司名称
	 */
	private String companyName;
	
	/**
	 * 商品名称
	 */
	private String goodsName;
	
	/**
	 * 数量
	 */
	private BigDecimal num;
	
	/**
	 * 实际销售价
	 */
	private BigDecimal actualSellPrice;
	
	/**
	 * 实际支付总积分
	 */
	private BigDecimal actualPayPoints;
	
	/**
	 * 实际支付总积分对应金额
	 */
	private BigDecimal actualPayMoney;
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public BigDecimal getNum() {
		return num;
	}
	public void setNum(BigDecimal num) {
		this.num = num;
	}
	public BigDecimal getActualSellPrice() {
		return actualSellPrice;
	}
	public void setActualSellPrice(BigDecimal actualSellPrice) {
		this.actualSellPrice = actualSellPrice;
	}
	public BigDecimal getActualPayPoints() {
		return actualPayPoints;
	}
	public void setActualPayPoints(BigDecimal actualPayPoints) {
		this.actualPayPoints = actualPayPoints;
	}
	public BigDecimal getActualPayMoney() {
		return actualPayMoney;
	}
	public void setActualPayMoney(BigDecimal actualPayMoney) {
		this.actualPayMoney = actualPayMoney;
	}
	@Override
	public String toString() {
		return "CustomerServiceBean [companyName=" + companyName
				+ ", goodsName=" + goodsName + ", num=" + num
				+ ", actualSellPrice=" + actualSellPrice + ", actualPayPoints="
				+ actualPayPoints + ", actualPayMoney=" + actualPayMoney + "]";
	}
	
}
