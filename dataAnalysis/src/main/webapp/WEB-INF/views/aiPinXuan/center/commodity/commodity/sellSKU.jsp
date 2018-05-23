<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
	<div id="p" class="easyui-panel" title="年度销售分析" style="width:100%;padding:20px;" data-options="cls:'theme-panel-blue'">
		<div style="height: 50px; float: right;">
				年份：<input type="text" name="productYear" id="productYear" class="Wdate" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy',minDate:2016,maxDate:'{%y}'})"/> 
<!-- 				<input type="button" id="tong_sellSku" onclick="tong_sellSku()" value="统计"/> -->
				<a id="tong_sellSku" class="easyui-linkbutton" style="background-color: #e2e2e2">统计</a>
		</div>
		<div>
			<table id="sellSKUTable" hidden="true" border="1" cellpadding="0" cellspacing="0" style="width: 1150px;height: 250px;"></table>
		</div>
		<div style=" margin-top: 10px">
			<table id="ss1" border="1" cellpadding="0" cellspacing="0" style="border-color: #eee" hidden="true">
				<tr>
					<td><div id="barSellSku1" style="width: 750px;height: 500px;"></div></td>
					<td><div id="pieSellSku1" style="width: 750px;height: 500px;"></div></td>
				</tr>
			</table>
		</div>
		<div style="margin-top: 10px" >
			<table id="ss2" border="1" cellpadding="0" cellspacing="0" style="border-color: #eee" hidden="true">
				<tr>
					<td><div id="barSellSku2" style="width: 750px;height: 500px;"></div></td>
					<td><div id="pieSellSku2" style="width: 750px;height: 500px;"></div></td>
				</tr>
			</table>
		</div>
	</div>
</div>
	<script type="text/javascript" src="js/aiPinXuan/center/commodity/commodity/sellSKU.js"></script>
</body>
</html>