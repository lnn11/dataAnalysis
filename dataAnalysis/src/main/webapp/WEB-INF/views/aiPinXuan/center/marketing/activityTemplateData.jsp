<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="margin-top: 20px;margin-left: 10px;">
		<span id="dataCh">${data}</span>
		<span id="data">
			<span class="span">数据选择：</span>
			<c:forEach items="${list}" var="item" varStatus="i">
				<input type="radio" name="datas" value="${item}">${item}
			</c:forEach>
		</span>
		<span id="data1">
			<span class="span">渠道选择：</span>
			<select name="channel" onchange="channelChange()">			
				<option value="">全部</option>
<!-- 				<option value="兑换码">兑换码</option> -->
			</select>
		</span>
		<span id="data2">
			<span class="span">数据选择：</span>
			<select name="choice" onchange="change()">	
				<option value="全部">全部</option>
				<c:forEach items="${list}" var="item" varStatus="i">
					<option value="${item}">${item}</option>
				</c:forEach>	
			</select>
		</span>
		<span id="data3">
			<select name="choice1">	
				<option value="全部">全部</option>
				<c:forEach items="${list1}" var="item" varStatus="i">
					<option value="${item}">${item}</option>
				</c:forEach>	
			</select>
		</span>
		<span id="data4">
			<span class="span">数据选择：</span>
			<select name="dataChoice" onchange="dataChange()">	
				<option value="全部">全部</option>
				<c:forEach items="${list2}" var="item" varStatus="i">
					<option value="${item}">${item}</option>
				</c:forEach>	
			</select>
		</span>
		<a href="javascript:void(0);" id="export" style="margin-left: 20px;text-decoration: none;">数据导出</a>
		<span style="float: right;">
			<span style="font-size: 14px;">选择统计周期：</span>
			<input type="text" id="startTime" class="Wdate" onclick="WdatePicker({skin:'whyGreen',minDate:'${activity.startTime}',maxDate:'${activity.endTime}'})">
			<span>至</span>
			<input type="text" id="endTime" class="Wdate" onclick="WdatePicker({skin:'whyGreen',minDate:'${activity.startTime}'})">
			<a id="btnQuery" class="easyui-linkbutton" style="background-color: #e2e2e2">查询</a>
			<a id="btnQueryAll" class="easyui-linkbutton" style="background-color: #e2e2e2">全部</a>
		</span>
	</div>
</body>
</html>