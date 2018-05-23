package com.zhb.dataAnalysis.marketing.beans;

import java.io.Serializable;

public class Channel implements Serializable{
	
	private static final long serialVersionUID = 3400948136226541480L;
	
	private String channelId;
	
	private String channelName;
	
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
}
