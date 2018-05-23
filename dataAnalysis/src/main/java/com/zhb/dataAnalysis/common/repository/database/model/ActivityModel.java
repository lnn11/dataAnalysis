package com.zhb.dataAnalysis.common.repository.database.model;

import org.apache.commons.lang3.StringUtils;

public class ActivityModel implements Comparable<ActivityModel>{
	private String activityId;//活动编号
	private String activityName;//活动名称
	private int status;//活动状态
	private String startTime;//活动开始时间
	private String endTime;//活动结束时间
	public String getActivityId() {
		return activityId;
	}
	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getStartTime() {
		if(StringUtils.isNotBlank(startTime)){
			int index = startTime.lastIndexOf(".");
			if(index != -1)
				startTime = startTime.substring(0,index);
		}
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		if(StringUtils.isNotBlank(endTime)){
			int index = endTime.lastIndexOf(".");
			if(index != -1)
				endTime = endTime.substring(0,index);
		}
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	@Override
	public int compareTo(ActivityModel o) {
		if(this.startTime.compareTo(o.startTime)>0) {
			return -1;
		}
		if(this.startTime.compareTo(o.startTime)<0) {
			return 1;
		}
		return 0;
	}
}
