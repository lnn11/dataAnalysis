package com.zhb.dataAnalysis.common.utils;

import java.io.Serializable;

public class PageContextUtils implements Serializable{
	private static final long serialVersionUID = 589392837672644436L;
	private int currentPage;//当前页
	private int pageSize;//每页显示多少条
	private int totalPage;//总共多少页
	private int totalCount;//总共多少条
	
	public int getCurrentPage() {
		if(this.currentPage<1)this.currentPage=1;
		else if(this.currentPage>getTotalPage())currentPage=getTotalPage();
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	/**
	 * 获取每页显示的条数
	 * @return
	 */
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public int getTotalPage() {
		int totalCount = this.getTotalCount();
		if(totalCount==0)return 0;
		if(totalCount%getPageSize()>0) totalPage=totalCount/getPageSize()+1;
		else totalPage=totalCount/getPageSize();
		return totalPage;
	}
	
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
}
