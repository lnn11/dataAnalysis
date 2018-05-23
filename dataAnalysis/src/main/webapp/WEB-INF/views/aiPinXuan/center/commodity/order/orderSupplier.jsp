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
				统计方式：<input type="checkbox" id="month1" >按月份     <input type="checkbox" id="pro1" checked="checked">按供应商
			</div>
			<div style="height: 50px; float: right;">
				统计时间段：<input type="text" id="prevDateOrder" name="prevDateOrder" class="Wdate" onclick="WdatePicker({skin:'whyGreen',startDate:'%y-%M-01 00:00:00',maxDate:'#F{$dp.$D(\'nextDateOrder\')||\'new Date()\'}'})"/> - 
				<input type="text" id="nextDateOrder" name="nextDateOrder" class="Wdate" onclick="WdatePicker({skin:'whyGreen',startDate:'%y-%M-%d 23:59:59',minDate:'#F{$dp.$D(\'prevDateOrder\')}'})"/> 
<!-- 				<input type="button" id="tong_orderSupplier" value="统计"/> -->
				<a id="tong_orderSupplier" class="easyui-linkbutton" style="background-color: #e2e2e2">统计</a>
			</div>
		</div>
		<div>
			<table id="orderSupplierTable" hidden="true" border="1" cellpadding="0" cellspacing="0" width="1000px" height="250px"></table>
		</div>
		<div align="center" id="x1" style="margin-top: 5px">
			<a id="orderFirstPage" href="javascript:void(0)" style="text-decoration: none; cursor:pointer;">首页</a>
			<a href="javascript:void(0)" style="text-decoration: none; cursor:pointer;"><span id="orderPrevPage">上一页</span></a>  
			<a href="javascript:void(0)" style="text-decoration: none; cursor:pointer;"><span id="orderNextPage">下一页</span></a>  
			<a href="javascript:void(0)" style="text-decoration: none; cursor:pointer;"><span id="orderLastPage">尾页</span></a>  
			<input type="text" id="orderTextG0" style="width: 30px;height: 20px;border: 1px solid gray;"/>  
			<a id="orderGo" class="easyui-linkbutton" style="background-color: #e2e2e2">GO</a> 
			共<span id="orderPageCount"></span>页
		</div>
		<div style="width: 1500px; height: 500px; margin-top: 10px">
			<table id="os1" border="1" cellpadding="0" cellspacing="0" style="border-color: #eee" hidden="true">
				<tr>
					<td><div id="barOrderSupplier1" style="width: 750px;height: 500px;"></div></td>
					<td><div id="pieOrderSupplier1" style="width: 750px;height: 500px;"></div></td>
				</tr>
			</table>
		</div>
		<div style="width: 1500px; height: 500px;margin-top: 10px">
			<table id="os2" border="1" cellpadding="0" cellspacing="0" style="border-color: #eee" hidden="true">
				<tr>
					<td><div id="barOrderSupplier2" style="width: 750px;height: 500px;"></div></td>
					<td><div id="pieOrderSupplier2" style="width: 750px;height: 500px;"></div></td>
				</tr>
			</table>
		</div>
		<div style="width: 1500px; height: 500px;margin-top: 10px" >
			<table id="os3" border="1" cellpadding="0" cellspacing="0" style="border-color: #eee" hidden="true">
				<tr>
					<td><div id="barOrderSupplier3" style="width: 750px;height: 500px;"></div></td>
					<td><div id="pieOrderSupplier3" style="width: 750px;height: 500px;"></div></td>
				</tr>
			</table>
		</div>
	</div>
</div>
	<script type="text/javascript" src="js/aiPinXuan/center/commodity/order/orderSupplier.js"></script>
</body>
</html>