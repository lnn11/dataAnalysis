<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<style type="text/css">
.span{font-size: 14px;font-weight: bold;}
</style>
	<div id="p" class="easyui-panel" title="查看" style="width:100%;" data-options="cls:'theme-panel-blue'">
	</div>
	<div style="border: solid #CFCFCF; border-width: 1px 1px 0px 1px; margin: 10px 10px 0px 10px;width: 1120px;">
		<span id="curr" hidden="true">${current}</span>
		<div style="margin-left: 30px; margin-top: 20px;">
			<a onclick="back()" class="easyui-linkbutton" style="background-color: #e2e2e2; float: right;margin-right: 10px;">返回</a>
			<span class="span">活动编号：</span><span id="activityId">${activity.activityId}</span><br/><br/>
			<span class="span">活动名称：</span><span id="activityName">${activity.activityName}</span><br/><br/>
			<span class="span">活动状态：</span><span style="color: red">${activity.status==1?'待开启':''}${activity.status==2?'进行中':''}${activity.status==3?'已结束':''}</span><br/><br/>
			<span class="span">活动时段：</span><span id="time"></span><br/><br/>
			<input id="start" value="${activity.startTime}" type="hidden">
			<input id="end" value="${activity.endTime}" type="hidden">
			<span id="activityNameA" hidden="true"></span>
			<span id="mm" hidden="true">${mm}</span>
		</div>
	</div>
</body>
</html>