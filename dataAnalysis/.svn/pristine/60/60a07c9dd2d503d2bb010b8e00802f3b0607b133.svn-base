<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
<div>
	<div id="p" class="easyui-panel" title="订单总数分析" style="width:100%;padding:20px;" data-options="cls:'theme-panel-blue'">
		<div style="height: 50px; width:1000px; font-size: 16px; margin-top: 20px">
			<div style="height: 50px; float: left;">
				统计方式：<input type="checkbox" id="month" checked="checked" >按月份     <input type="checkbox" id="pro">按供应商
			</div>
			<div style="height: 50px; float: right;">
				年份：<input type="text" name="orderYear" id="orderYear" class="Wdate" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy',minDate:2016,maxDate:'{%y}'})"/> 
				<a id="tong_orderTotal" class="easyui-linkbutton" style="background-color: #e2e2e2">统计</a>
			</div>
		</div>
		<div>
			<table id="orderTotalTable" hidden="true" border="1" cellpadding="0" cellspacing="0" style="width: 1000px; height: 250px;"></table>
		</div>
		<div style="width: 1500px; height: 500px; margin-top: 10px">
			<table id="o1" border="1" cellpadding="0" cellspacing="0" style="border-color: #eee" hidden="true">
				<tr>
					<td><div id="barOrder1" style="width: 750px;height: 500px;"></div></td>
					<td><div id="pieOrder1" style="width: 750px;height: 500px;"></div></td>
				</tr>
			</table>
		</div>
		<div style="width: 1500px; height: 500px;margin-top: 10px" >
			<table id="o2" border="1" cellpadding="0" cellspacing="0" style="border-color: #eee" hidden="true">
				<tr>
					<td><div id="barOrder2" style="width: 750px;height: 500px;"></div></td>
					<td><div id="pieOrder2" style="width: 750px;height: 500px;"></div></td>
				</tr>
			</table>
		</div>
		<div style="width: 1500px; height: 500px;margin-top: 10px" >
			<table id="o3" border="1" cellpadding="0" cellspacing="0" style="border-color: #eee" hidden="true">
				<tr>
					<td><div id="barOrder3" style="width: 750px;height: 500px;"></div></td>
					<td><div id="pieOrder3" style="width: 750px;height: 500px;"></div></td>
				</tr>
			</table>
		</div>
	</div>
</div>
	<script type="text/javascript" src="js/aiPinXuan/center/commodity/order/orderTotal.js"></script>
</body>
</html>