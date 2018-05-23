package com.zhb.dataAnalysis.marketing.api;

import javax.servlet.http.HttpServletResponse;

public interface ExportUtilService {
	void exportExcel(HttpServletResponse reponse, String startTime, String endTime, String data, String activityId,String sign, String activityName);
}