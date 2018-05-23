<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="p" class="easyui-panel" title="供应商对账单" style="width:100%;" data-options="cls:'theme-panel-blue'">
		<form id="ceshi">
			<div style="margin-top: 10px">
				<span style=" margin-left: 10px;font-size: 14px;">供应商简称：</span><input type="text" name="shortName" id="shortName" style="width: 80px;height: 20px;border: 1px solid gray;"/>
				<span style=" margin-left: 20px;font-size: 14px;">商品分类：</span>
				<select id="activity" name="activity">
					<option value="">请选择</option>
					<option value="活动类">活动类</option>
					<option value="非活动类">非活动类</option>
				</select>
				<span style=" margin-left: 20px;font-size: 14px;">订单状态：</span>
				<select id="data">
					<option value="0">请选择</option>
					<option value="1">已发货</option>
					<option value="2">已收货</option>
				</select>
				<span style=" margin-left: 20px;font-size: 14px;">统计时间：</span>
				<input type="text" name="supplierBillPrev" id="supplierBillPrev" class="Wdate" onclick="WdatePicker({skin:'whyGreen',maxDate:'#F{$dp.$D(\'supplierBillNext\')||\'new Date()\'}'})"/> 至 
				<input type="text" name="supplierBillNext" id="supplierBillNext" class="Wdate" onclick="WdatePicker({skin:'whyGreen',minDate:'#F{$dp.$D(\'supplierBillPrev\')}'})"/>
				<input type="checkbox" name="payBox" id = "payBox">礼品卡支付数据
				<a id="supplierBillFind" class="easyui-linkbutton" style="background-color: #e2e2e2">查找</a>
				<a id="expotSupplierBill" class="easyui-linkbutton" style="background-color: #e2e2e2">导出Excel</a>
			</div>
			<div style="margin-top: 20px;margin-bottom: 10px;">
				<span style="font-size: 14px;margin-left: 10px;">统计时段：</span>
				<span id="prevSupplierBill" style="font-size: 14px;"></span><span style="font-size: 14px;">&nbsp;至&nbsp;</span><span style="font-size: 14px;" id="nextSupplierBill"></span>
			</div>
		</form>
		<div>
			<table style="width: 1000px; height: 150px; border-color: #5F9EA0;" border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td>商品总数（件）</td><td>活动商品总数（件）</td><td>非活动商品总数（件）</td>
				</tr>
				<tr>
					<td><span id="sumNum">0</span></td><td><span id="activitySumNum">0</span></td><td><span id="unActivitySumNum">0</span></td>
				</tr>
				<tr>
					<td>总供货价（元）</td><td>活动商品总供货价（元）</td><td>非活动商品总供货价（元）</td>
				</tr>
				<tr>
					<td><span id="sumMoney">0</span></td><td><span id="activitySumMoney">0</span></td><td><span id="unActivitySumMoney">0</span></td>
				</tr>
			</table>
		</div>
		<div style="margin-top: 10px;">
			<table id="supplierBillTable" style="height: 485px; width: 100%"></table>
		</div>
	</div>
	<script type="text/javascript" src="js/aiPinXuan/center/commodity/finance/supplierBill.js"></script>
</body>
</html>