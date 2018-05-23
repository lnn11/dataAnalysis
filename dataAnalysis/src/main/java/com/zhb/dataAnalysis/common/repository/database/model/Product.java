package com.zhb.dataAnalysis.common.repository.database.model;

import java.sql.Clob;
import java.util.Date;

public class Product {

	private String productId;
	private String name;
	private String categoryId;
	private String title;
	private Date beginTime;
	private Date endTime;
	private Clob description;
	private double isSeckill;
	private double isSelect;
	private String pic1Url;
	private String pic2Url;
	private String supplierId;
	private double status;
	private String creator;
	private Date createTime;
	private String updater;
	private Date updateTime;
	private String remark;
	private double isPopularity;
	private Date publishStart;
	private Date publishEnd;
	private double isSpecial;
	private String productNumber;
	private double isPreference;
	private String callbackReason;
	private double displaySeq;
	private Clob mainUrl;
	private String nameJx;
	private String titleJx;
	private String nameRq;
	private String titleRq;
	private String nameTs;
	private String titleTs;
	private String nameSy;
	private String titleSy;
	private String nameQd;
	private String titleQd;
	private int isRecommend;
	private String titleRecommend;
	private String nameRecommend;
	private double isLower;
	private String productDesc;
	private double clickNum;
	private double saleNum;
	private String brand;
	private double isNewarrivals;
	private String nameNa;
	private String titleNa;
	private double isArrivalsafterpaid;
	private String nameAp;
	private String titleAp;
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Clob getDescription() {
		return description;
	}
	public void setDescription(Clob description) {
		this.description = description;
	}
	public double getIsSeckill() {
		return isSeckill;
	}
	public void setIsSeckill(double isSeckill) {
		this.isSeckill = isSeckill;
	}
	public double getIsSelect() {
		return isSelect;
	}
	public void setIsSelect(double isSelect) {
		this.isSelect = isSelect;
	}
	public String getPic1Url() {
		return pic1Url;
	}
	public void setPic1Url(String pic1Url) {
		this.pic1Url = pic1Url;
	}
	public String getPic2Url() {
		return pic2Url;
	}
	public void setPic2Url(String pic2Url) {
		this.pic2Url = pic2Url;
	}
	public String getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
	public double getStatus() {
		return status;
	}
	public void setStatus(double status) {
		this.status = status;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getUpdater() {
		return updater;
	}
	public void setUpdater(String updater) {
		this.updater = updater;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public double getIsPopularity() {
		return isPopularity;
	}
	public void setIsPopularity(double isPopularity) {
		this.isPopularity = isPopularity;
	}
	public Date getPublishStart() {
		return publishStart;
	}
	public void setPublishStart(Date publishStart) {
		this.publishStart = publishStart;
	}
	public Date getPublishEnd() {
		return publishEnd;
	}
	public void setPublishEnd(Date publishEnd) {
		this.publishEnd = publishEnd;
	}
	public double getIsSpecial() {
		return isSpecial;
	}
	public void setIsSpecial(double isSpecial) {
		this.isSpecial = isSpecial;
	}
	public String getProductNumber() {
		return productNumber;
	}
	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}
	public double getIsPreference() {
		return isPreference;
	}
	public void setIsPreference(double isPreference) {
		this.isPreference = isPreference;
	}
	public String getCallbackReason() {
		return callbackReason;
	}
	public void setCallbackReason(String callbackReason) {
		this.callbackReason = callbackReason;
	}
	public double getDisplaySeq() {
		return displaySeq;
	}
	public void setDisplaySeq(double displaySeq) {
		this.displaySeq = displaySeq;
	}
	public Clob getMainUrl() {
		return mainUrl;
	}
	public void setMainUrl(Clob mainUrl) {
		this.mainUrl = mainUrl;
	}
	public String getNameJx() {
		return nameJx;
	}
	public void setNameJx(String nameJx) {
		this.nameJx = nameJx;
	}
	public String getTitleJx() {
		return titleJx;
	}
	public void setTitleJx(String titleJx) {
		this.titleJx = titleJx;
	}
	public String getNameRq() {
		return nameRq;
	}
	public void setNameRq(String nameRq) {
		this.nameRq = nameRq;
	}
	public String getTitleRq() {
		return titleRq;
	}
	public void setTitleRq(String titleRq) {
		this.titleRq = titleRq;
	}
	public String getNameTs() {
		return nameTs;
	}
	public void setNameTs(String nameTs) {
		this.nameTs = nameTs;
	}
	public String getTitleTs() {
		return titleTs;
	}
	public void setTitleTs(String titleTs) {
		this.titleTs = titleTs;
	}
	public String getNameSy() {
		return nameSy;
	}
	public void setNameSy(String nameSy) {
		this.nameSy = nameSy;
	}
	public String getTitleSy() {
		return titleSy;
	}
	public void setTitleSy(String titleSy) {
		this.titleSy = titleSy;
	}
	public String getNameQd() {
		return nameQd;
	}
	public void setNameQd(String nameQd) {
		this.nameQd = nameQd;
	}
	public String getTitleQd() {
		return titleQd;
	}
	public void setTitleQd(String titleQd) {
		this.titleQd = titleQd;
	}
	public int getIsRecommend() {
		return isRecommend;
	}
	public void setIsRecommend(int isRecommend) {
		this.isRecommend = isRecommend;
	}
	public String getTitleRecommend() {
		return titleRecommend;
	}
	public void setTitleRecommend(String titleRecommend) {
		this.titleRecommend = titleRecommend;
	}
	public String getNameRecommend() {
		return nameRecommend;
	}
	public void setNameRecommend(String nameRecommend) {
		this.nameRecommend = nameRecommend;
	}
	public double getIsLower() {
		return isLower;
	}
	public void setIsLower(double isLower) {
		this.isLower = isLower;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public double getClickNum() {
		return clickNum;
	}
	public void setClickNum(double clickNum) {
		this.clickNum = clickNum;
	}
	public double getSaleNum() {
		return saleNum;
	}
	public void setSaleNum(double saleNum) {
		this.saleNum = saleNum;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getIsNewarrivals() {
		return isNewarrivals;
	}
	public void setIsNewarrivals(double isNewarrivals) {
		this.isNewarrivals = isNewarrivals;
	}
	public String getNameNa() {
		return nameNa;
	}
	public void setNameNa(String nameNa) {
		this.nameNa = nameNa;
	}
	public String getTitleNa() {
		return titleNa;
	}
	public void setTitleNa(String titleNa) {
		this.titleNa = titleNa;
	}
	public double getIsArrivalsafterpaid() {
		return isArrivalsafterpaid;
	}
	public void setIsArrivalsafterpaid(double isArrivalsafterpaid) {
		this.isArrivalsafterpaid = isArrivalsafterpaid;
	}
	public String getNameAp() {
		return nameAp;
	}
	public void setNameAp(String nameAp) {
		this.nameAp = nameAp;
	}
	public String getTitleAp() {
		return titleAp;
	}
	public void setTitleAp(String titleAp) {
		this.titleAp = titleAp;
	}
}