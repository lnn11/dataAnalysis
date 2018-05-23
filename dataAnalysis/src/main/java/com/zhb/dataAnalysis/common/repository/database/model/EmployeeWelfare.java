package com.zhb.dataAnalysis.common.repository.database.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class EmployeeWelfare implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String company;
	private String productName;
	private BigDecimal productNum;
	private BigDecimal price;
	private BigDecimal sumSpecialPoints;
	private BigDecimal sumSpecialMoney;
	private String welfareName; // 1,2,3
	private BigDecimal sumProductNum; // 1,2,3
	private BigDecimal sumPoints; // 1,2,3
	private BigDecimal sumMoney; // 1,2,3
	
	private String employeeName;
	private String employeeNumber;
	private String createTime;
	
	private String normInfo;
	
	private BigDecimal taxRate;//税率
	private String taxTypeCode;//税收分类编码

	private Integer jxPoints;//金信积分数
	private Integer djrPoints;//大金融

	private String orderNo;

	private String timestampTime;

	private Integer numbers;


	public Integer getNumbers() {
		return numbers;
	}

	public void setNumbers(Integer numbers) {
		this.numbers = numbers;
	}

	public String getTimestampTime() {
		return timestampTime;
	}

	public void setTimestampTime(String timestampTime) {
		this.timestampTime = timestampTime;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Integer getJxPoints() {
		return jxPoints;
	}

	public void setJxPoints(Integer jxPoints) {
		this.jxPoints = jxPoints;
	}

	public Integer getDjrPoints() {
		return djrPoints;
	}

	public void setDjrPoints(Integer djrPoints) {
		this.djrPoints = djrPoints;
	}

	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public BigDecimal getProductNum() {
		return productNum;
	}
	public void setProductNum(BigDecimal productNum) {
		this.productNum = productNum;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getSumSpecialPoints() {
		return sumSpecialPoints;
	}
	public void setSumSpecialPoints(BigDecimal sumSpecialPoints) {
		this.sumSpecialPoints = sumSpecialPoints;
	}
	public BigDecimal getSumSpecialMoney() {
		return sumSpecialMoney;
	}
	public void setSumSpecialMoney(BigDecimal sumSpecialMoney) {
		this.sumSpecialMoney = sumSpecialMoney;
	}
	public String getWelfareName() {
		return welfareName;
	}
	public void setWelfareName(String welfareName) {
		this.welfareName = welfareName;
	}
	public BigDecimal getSumProductNum() {
		return sumProductNum;
	}
	public void setSumProductNum(BigDecimal sumProductNum) {
		this.sumProductNum = sumProductNum;
	}
	public BigDecimal getSumPoints() {
		return sumPoints;
	}
	public void setSumPoints(BigDecimal sumPoints) {
		this.sumPoints = sumPoints;
	}
	public BigDecimal getSumMoney() {
		return sumMoney;
	}
	public void setSumMoney(BigDecimal sumMoney) {
		this.sumMoney = sumMoney;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeNumber() {
		return employeeNumber;
	}
	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getNormInfo() {
		return normInfo;
	}
	public void setNormInfo(String normInfo) {
		this.normInfo = normInfo;
	}
	public BigDecimal getTaxRate() {
		return taxRate;
	}
	public void setTaxRate(BigDecimal taxRate) {
		this.taxRate = taxRate;
	}
	public String getTaxTypeCode() {
		return taxTypeCode;
	}
	public void setTaxTypeCode(String taxTypeCode) {
		this.taxTypeCode = taxTypeCode;
	}

	@Override
	public String toString() {
		return "EmployeeWelfare{" +
				"company='" + company + '\'' +
				", productName='" + productName + '\'' +
				", productNum=" + productNum +
				", price=" + price +
				", sumSpecialPoints=" + sumSpecialPoints +
				", sumSpecialMoney=" + sumSpecialMoney +
				", welfareName='" + welfareName + '\'' +
				", sumProductNum=" + sumProductNum +
				", sumPoints=" + sumPoints +
				", sumMoney=" + sumMoney +
				", employeeName='" + employeeName + '\'' +
				", employeeNumber='" + employeeNumber + '\'' +
				", createTime='" + createTime + '\'' +
				", normInfo='" + normInfo + '\'' +
				", taxRate=" + taxRate +
				", taxTypeCode='" + taxTypeCode + '\'' +
				", jxPoints=" + jxPoints +
				", djrPoints=" + djrPoints +
				", orderNo='" + orderNo + '\'' +
				'}';
	}
}
