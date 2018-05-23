<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 	<div id="rightTitleDiv">
		<span style="font-size: 16px;">四大合作平台-客户服务对账单</span>
	</div>
	<div style="margin-top: 10px">
		<span style=" margin-left: 10px;font-size: 14px;">公司名称：</span><input type="text" id="companyName" style="width:80px;"/>
		<span style=" margin-left: 20px;font-size: 14px;">统计时间：</span>
		<input type="text" id="partnerBillPrev" style="height:25px;width:150px;" class="Wdate" onclick="WdatePicker({skin:'whyGreen',maxDate:'#F{$dp.$D(\'partnerBillNext\')||\'new Date()\'}'})"/> 至 
		<input type="text" id="partnerBillNext" style="height:25px;width:150px;" class="Wdate" onclick="WdatePicker({skin:'whyGreen',minDate:'#F{$dp.$D(\'partnerBillPrev\')}',maxDate:'%y-%M-%d %H:%m:%s'})"/>
		<input style=" margin-left: 20px;" type="button" id="searchCustomerService" value="查找"/>
		<input type="button" id="exportCustomerServiceExcel" value="导出Excel"/>
	</div>
	<div style="margin-top: 20px;margin-bottom: 10px;">
		<span style="font-size: 16px;margin-left: 10px;color: #0080C0;">统计时段：</span><span id="countTime" style="font-size: 16px;margin-left: 10px;color: #0080C0;"></span>
	</div>
	<div>
		<table style="width: 800px; height: 70px; border-color: #00668F; border-style: solid; border-width: 1px 0px 0px 1px;" cellpadding="0" cellspacing="0">
			<tr>
				<td style="border:solid #00668F; border-width:0px 1px 1px 0px;">商品总数（件）</td>
				<td style="border:solid #00668F; border-width:0px 1px 1px 0px;">实际支付总积分</td>
				<td style="border:solid #00668F; border-width:0px 1px 1px 0px;">实际支付总积分对应总金额（元）</td>
			</tr>
			<tr>
				<td style="border:solid #00668F; border-width:0px 1px 1px 0px;"><span id="productNum">0</span></td>
				<td style="border:solid #00668F; border-width:0px 1px 1px 0px;"><span id="sumPayPoint">0</span></td>
				<td style="border:solid #00668F; border-width:0px 1px 1px 0px;"><span id="sumPayMoney">0</span></td>
			</tr>
		</table>
	</div>
	<div style="margin-top: 10px;">
		<table id="partnerBillTable" style="height: 485px;"></table>
	</div>
	<script type="text/javascript" src="js/aiPinXuan/center/commodity/finance/partnerBill.js"></script>
</body>
</html>