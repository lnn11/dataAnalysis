<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="p" class="easyui-panel" title="福利券对账单" style="width:100%;" data-options="cls:'theme-panel-blue'">
		<div style="margin-top: 10px">
			<span style=" margin-left: 10px;font-size: 14px;">公司名称：</span><input type="text" id="company" style="width: 80px;height: 20px;border: 1px solid gray;"/>
			<span style=" margin-left: 10px;font-size: 14px;">员工福利名称：</span>
			<select name="welfare">
				<option value="所有专属福利">所有专属福利</option>
				<c:forEach items="${list}" var="item" varStatus="i">
					<option value="${item.GIFTNAME}">${item.GIFTNAME}</option>
				</c:forEach>
			</select>
			<span style=" margin-left: 20px;font-size: 14px;">统计时间：</span>
			<input type="text" id="employeeBillPrev" class="Wdate" onclick="WdatePicker({skin:'whyGreen',maxDate:'#F{$dp.$D(\'employeeBillNext\')||\'new Date()\'}'})"/> 至 
			<input type="text" id="employeeBillNext" class="Wdate" onclick="WdatePicker({skin:'whyGreen',minDate:'#F{$dp.$D(\'employeeBillPrev\')}'})"/>
			<span style="float: right; margin-right: 10px;">
				<a id="searchEmployeeWelfare" class="easyui-linkbutton" style="background-color: #e2e2e2">查找</a>
				<a id="exportWelfareData" class="easyui-linkbutton" style="background-color: #e2e2e2">导出Excel</a>
			</span>
		</div>
		<div style="margin-top: 20px;margin-bottom: 10px;">
			<span style="font-size: 16px;margin-left: 10px;">统计时段：</span><span id="time" style="font-size: 16px;margin-left: 10px;"></span>
			<span style="font-size: 16px;margin-left: 20px;">员工福利名称：</span><span id="employeeWelfareName" style="font-size: 16px;margin-left: 10px;"></span>
		</div>
		<div>
			<table style="width: 800px; height: 70px; border-color: #00668F; border-style: solid; border-width: 1px 0px 0px 1px;" cellpadding="0" cellspacing="0">
				<tr>
					<td style="border:solid #00668F; border-width:0px 1px 1px 0px;">商品总数（件）</td>
					<td style="border:solid #00668F; border-width:0px 1px 1px 0px;">福利券支付总积分</td>
					<td style="border:solid #00668F; border-width:0px 1px 1px 0px;">福利券支付总金额（元）</td>
				</tr>
				<tr>
					<td style="border:solid #00668F; border-width:0px 1px 1px 0px;"><span id="sumProductNum">0</span></td>
					<td style="border:solid #00668F; border-width:0px 1px 1px 0px;"><span id="sumPoints">0</span></td>
					<td style="border:solid #00668F; border-width:0px 1px 1px 0px;"><span id="sumMoney">0</span></td>
				</tr>
			</table>
		</div>
		<div style="margin-top: 10px;">
			<table id="employeeBillTable" style="height: 485px;whidth: 100px;"></table>
		</div>
	</div>
	<script type="text/javascript" charset="UTF-8" src="js/aiPinXuan/center/commodity/finance/employeeBill.js"></script>
</body>
</html>