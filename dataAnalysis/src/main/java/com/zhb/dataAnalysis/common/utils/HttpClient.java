package com.zhb.dataAnalysis.common.utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class HttpClient {

	public static Integer getHits(String url, String startDate, String endDate) {
		Integer total = 0;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httppost = null;
		HttpEntity entity = null;
		try {
			String condition = "";
			long timestampStart,timestampEnd;
			URIBuilder uriBuilder = new URIBuilder(url);
			httppost = new HttpPost(uriBuilder.build());
			Calendar c = Calendar.getInstance();			

			if (StringUtils.isNotBlank(startDate)) {
				startDate = startDate.trim();
				if (startDate.indexOf("-") != -1) {
					String[] startAry = startDate.split(" ");
					String[] ymd = startAry[0].split("-");
					String[] hms = startAry[1].split(":");
					c.set(Integer.parseInt(ymd[0]), Integer.parseInt(ymd[1])-1,
							Integer.parseInt(ymd[2]), Integer.parseInt(hms[0]),
							Integer.parseInt(hms[1]), Integer.parseInt(hms[2]));
					timestampStart = c.getTimeInMillis();
					condition += "\"gte\": " + timestampStart + ",";
				}
			}
			if (StringUtils.isNotBlank(endDate)) {
				endDate = endDate.trim();
				if(endDate.indexOf("-") != -1){
					String[] endAry = endDate.split(" ");
					String[] ymd = endAry[0].split("-");
					String[] hms = endAry[1].split(":");
					c.set(Integer.parseInt(ymd[0]), Integer.parseInt(ymd[1])-1,
							Integer.parseInt(ymd[2]), Integer.parseInt(hms[0]),
							Integer.parseInt(hms[1]), Integer.parseInt(hms[2]));
					timestampEnd = c.getTimeInMillis();
					condition += "\"lte\": " + timestampEnd + ",";
				}
			}
			if(condition == ""){
				c.setTime(new Date());
				condition = "\"lte\": " + c.getTimeInMillis() + ",";
			}						
			
			String str = "{" + "\"query\": {" + "\"range\": {"
					+ "\"@timestamp\": {" 
					+ condition
					+ "\"format\": \"epoch_millis\"" + "}}}"
					//+ ",\"from\": 9998," + "\"size\": 1" 
					+ "}";
			entity = new StringEntity(str, ContentType.APPLICATION_JSON);
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
		}
		httppost.setEntity(entity);

		try {
			total = httpclient.execute(httppost,(response) -> {
				int status = response.getStatusLine().getStatusCode();
				if (status >= 200 && status < 300) {
					HttpEntity httpEntity = response.getEntity();
					if (httpEntity != null) {
						String jsonStr = EntityUtils.toString(httpEntity,"UTF-8");
						JSONObject obj = JSON.parseObject(jsonStr);
						JSONObject subObj = obj.getJSONObject("hits");
						Integer count = subObj.getInteger("total");
						return count;
					}
				} else {
					System.out.println(EntityUtils.toString(response.getEntity(), "UTF-8"));
					throw new ClientProtocolException("访问10.180.140.92:9200的ELK时出错!返回状态码: " + status);
				}
				return 0;
			});
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return total;
	}

	public static void main(String[] args) {
		//System.out.println("点击数为："+ HttpClient.getHits("http://10.180.140.92:9200/logstash-_search?pretty",null,null));
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = null;
		try {
				URIBuilder uriBuilder = new URIBuilder("http://localhost:8080/cistranslation/webservice/rest/certificate/getCustInfoByCardPhone/210882199004133029/15642386233");
			httpGet = new HttpGet(uriBuilder.build());
			httpGet.setHeader("cisKey", "QNL3ylYgbzgydkn7s2jtFLNdbIEbZZauyNYcN+K1G08=");
			httpGet.setHeader("operman", "XH_ZHB");
			httpclient.execute(httpGet,(response) -> {
				int status = response.getStatusLine().getStatusCode();
				if (status >= 200 && status < 300) {
					HttpEntity entity = response.getEntity();
					String jsonStr = EntityUtils.toString(entity,"UTF-8");
					System.out.println(jsonStr);
				}
				return null;
			});
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}
