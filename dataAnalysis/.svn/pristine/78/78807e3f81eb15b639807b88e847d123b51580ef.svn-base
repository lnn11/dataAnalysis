<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
	<div id="p" class="easyui-panel" title="各品类销售占比" style="width:100%;padding:20px;" data-options="cls:'theme-panel-blue'">
		<div style="height: 50px; width:1100px; font-size: 16px; margin-top: 20px">
			<div style="height: 50px; float: left;">
				统计方式：<input type="radio" id="propTimeQu" checked="checked">按时段
					<input type="radio" id="propTiming">按时间点
					  
			</div>
			<div style="height: 50px; float: right;">
				统计时间段：<input id="startDate" name="startDate" class="Wdate" type="text" onclick="WdatePicker({skin:'whyGreen',maxDate:'#F{$dp.$D(\'endDate\')||\'new Date()\'}'})"/> - 
				<input id="endDate" name="endDate" type="text" class="Wdate" onclick="WdatePicker({skin:'whyGreen',minDate:'#F{$dp.$D(\'startDate\')}'})"/>
			</div>
		</div>
		<div style="height: 50px; margin-top: 10px">
			<span style="font-size: 16px;">供应商简称：</span>
			<select id="propSelect">
				<option value="">全部</option>
			</select>
			<a onclick="tong_propSKU()" class="easyui-linkbutton" style="background-color: #e2e2e2">统计</a>
		</div>
		<div>
			<span style="font-size: 16px;margin-left: 10px;">统计时段：</span>
			<span style="font-size: 16px;" id="propStartDate"></span><span style="font-size: 16px;">&nbsp;至&nbsp;</span><span style="font-size: 16px;" id="propEndDate"></span>
			<span style="font-size: 16px;margin-left:100px;">供应商简称：</span><span style="font-size: 16px;" id="propShortName"></span>
		</div>
		<div style="width: ">
			<table id="propSKUTable" hidden="true" border="1" cellpadding="0" cellspacing="0" width="1100px" height="150px"></table>
		</div>
		<div align="center" id="x1" style="margin-top: 5px">
			<a id="firstPage" href="javascript:void(0)" style="text-decoration: none; cursor:pointer;">首页</a>   
			<a href="javascript:void(0)" style="text-decoration: none; cursor:pointer;"><span id="lastPage">上一页</span></a>   
			<a href="javascript:void(0)" style="text-decoration: none; cursor:pointer;"><span id="nextPage">下一页</span></a>   
			<a href="javascript:void(0)" style="text-decoration: none; cursor:pointer;"><span id="endPage">尾页</span></a>   
			<input id="inputPage" type="text" style="width: 30px;height: 20px;border: 1px solid gray;"/>  
			<a id="goPage" class="easyui-linkbutton" style="background-color: #e2e2e2">GO</a>
			共<span id="countPage"></span>页
		</div>
		<div id="piePropSku1" style="width: 600px;height: 500px;margin-left: 200px;margin-top: 10px; border: 1px;"></div>
		<div id="piePropSku2" style="width: 600px;height: 500px;margin-left: 200px;margin-top: 10px; border: 1px;"></div>
	</div>
</div>
	<script type="text/javascript" src="js/aiPinXuan/center/commodity/commodity/propSKU.js"></script>
</body>
</html>