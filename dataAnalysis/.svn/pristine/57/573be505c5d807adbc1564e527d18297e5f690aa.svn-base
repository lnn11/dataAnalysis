<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<style type="text/css">
    .ss {position:relative;float: left; margin-left: 40px;}  
	.divs {height: 70px;width: 150px; background-color: #99CCFF;margin-top: 20px; border-radius:5px 5px 0px 0px; text-align: center; line-height:70px;}
	.divss {height: 25px;width: 150px; background-color: #00BFFF; border-radius:0px 0px 5px 5px; text-align: center; line-height:25px;}
	.font{color: #fff; font-size: 14px; }
	.text{width: 120px;height: 20px;border: 1px solid gray;}
 	.conf{margin-left: 40px; margin-top: 130px;} 
	.span{margin-left: 20px;}
	.select{width: 100px;}
	.text1{width: 50px;height: 20px;border: 1px solid gray;}
	.span1{font-size: 18px;}
	.divc{height: 85px;width: 200px; background-color: #DCDCDC;margin-top: 20px; text-align: center; position: absolute;z-index: 99;}
	#sv {height: 85px;width: 200px; background-color: #DCDCDC;margin-top: 20px; text-align: center; z-index: 99;}
</style>
	<div id="p" class="easyui-panel" title="支付平台对账单" style="width:100%;" data-options="cls:'theme-panel-blue'">
		<div id="incom" class="ss">
			<div class="divs">
				<span class="span1" id="income">0</span><span class="span1">元</span>
			</div>
			<div class="divss">
				<span class="font">收入总金额</span>
			</div>
		</div>
		<div id="inco" class="divc" style="left: 180px;" hidden="true">
			<span>支付宝平台：</span><span id="incomeAlipay">0</span><span>元</span><br>
			<span>微信(普通)：</span><span id="incomeCommon">0</span><span>元</span><br>
			<span>微信(公众)：</span><span id="incomePublic">0</span><span>元</span><br>
			<span>微信（h5）：</span><span id="incomeH5">0</span><span>元</span><br>
		</div>
		<div id="payCs" class="ss">
			<div class="divs">
				<span class="span1" id="payCash">0</span><span class="span1">元</span>
			</div>
			<div class="divss">
				<span class="font">支出总金额</span>
			</div>
		</div>
		<div id="payCa" class="divc" style="left: 370px;" hidden="true">
			<span>支付宝平台：</span><span id="payCashAlipay">0</span><span>元</span><br>
			<span>微信(普通)：</span><span id="payCashCommon">0</span><span>元</span><br>
			<span>微信(公众)：</span><span id="payCashPublic">0</span><span>元</span><br>
			<span>微信（h5）：</span><span id="payCashH5">0</span><span>元</span><br>
		</div>
		<div id="real" class="ss">
			<div class="divs">
				<span class="span1" id="realIncome">0</span><span class="span1">元</span>
			</div>
			<div class="divss">
				<span class="font">实际收入总金额</span>
			</div>
		</div>
		<div id="reals" class="divc" style="left: 560px;" hidden="true">
			<span>支付宝平台：</span><span id="realIncomeAlipay">0</span><span>元</span><br>
			<span>微信(普通)：</span><span id="realIncomeCommon">0</span><span>元</span><br>
			<span>微信(公众)：</span><span id="realIncomePublic">0</span><span>元</span><br>
			<span>微信（h5）：</span><span id="realIncomeH5">0</span><span>元</span><br>
		</div>
		<div id="serI" class="ss">
			<div class="divs">
				<span class="span1" id="serviceIncome">0</span><span class="span1">元</span>
			</div>
			<div class="divss">
				<span class="font">手续费收入总金额</span>
			</div>
		</div>
		<div id="serIn" class="divc" style="left: 750px;" hidden="true">
			<span>支付宝平台：</span><span id="serviceAlipay">0</span><span>元</span><br>
			<span>微信(普通)：</span><span id="serviceIncomeCommon">0</span><span>元</span><br>
			<span>微信(公众)：</span><span id="serviceIncomePublic">0</span><span>元</span><br>
			<span>微信（h5）：</span><span id="serviceIncomeH5">0</span><span>元</span><br>
		</div>
		<div id="serP" class="ss">
			<div class="divs">
				<span class="span1" id="servicePay">0</span><span class="span1">元</span>
			</div>
			<div class="divss">
				<span class="font">手续费支出总金额</span>
			</div>
		</div>
		<div id="serPa" class="divc" style="left: 940px;" hidden="true">
			<span>支付宝平台：</span><span id="servicePayAlipay">0</span><span>元</span><br>
			<span>微信(普通)：</span><span id="servicePayCommon">0</span><span>元</span><br>
			<span>微信(公众)：</span><span id="servicePayPublic">0</span><span>元</span><br>
			<span>微信（h5）：</span><span id="servicePayH5">0</span><span>元</span><br>
		</div>
		<div id="realP" class="ss">
			<div class="divs">
				<span class="span1" id="realServicePay">0</span><span class="span1">元</span>
			</div>
			<div class="divss">
				<span class="font">实际手续费支出总金额</span>
			</div>
		</div>
		<div id="realPa" class="divc" style="left: 800px;" hidden="true">
			<span>支付宝平台：</span><span id="realServicePayAlipay">0</span><span>元</span><br>
			<span>微信(普通)：</span><span id="realServicePayCommon">0</span><span>元</span><br>
			<span>微信(公众)：</span><span id="realServicePayPublic">0</span><span>元</span><br>
			<span>微信（h5）：</span><span id="realServicePayH5">0</span><span>元</span><br>
		</div>
		<div class="conf">
			<form id="form">
				<input class="text" type="text" name="test" hidden="true"/>
				<span>主订单编号：</span><input class="text" type="text" name="orderMains"/>
				<span class="span">支付平台流水号：</span><input class="text" type="text" name="payID"/>
				<span class="span">支付方式：</span>
				<select class ="select" name="paySourse">
					<option value="">全部</option>
					<option value="4">支付宝支付</option>
					<option value="1">微信支付（普通）</option>
					<option value="3">微信支付（公众号）</option>
					<option value="6">微信支付（H5）</option>
				</select>
				<span class="span">渠道：</span>
				<select class ="select" name="channel">
					<option value="">全部</option>
					<option value="aiPinXuan">爱品选</option>
<!-- 					<option value="2">微匠</option> -->
					<c:forEach items="${channel}" var="item" varStatus="i">
						<option value="${item.CHANNELID}">${item.CHANNELNAME}</option>
					</c:forEach>
				</select>
				<span class="span">
					<a onclick="payPlatformfind()" class="easyui-linkbutton" style="background-color: #e2e2e2">查询</a>
					<a onclick="payPlatFormExport()" class="easyui-linkbutton" style="background-color: #e2e2e2">交易账单导出</a>
				</span>
				<br><br>
				<span>支付金额：</span><input class="text1" type="text" name="payCashStart" id="payCashStart"/> - <input class="text1" type="text" name="payCashsEnd" id="payCashsEnd"/> 元
				<span class="span">实际收入金额：</span><input class="text1" type="text" name="cashStart"/> - <input class="text1" type="text" name="cashEnd"/> 元
				<span class="span">退款金额：</span><input class="text1" type="text" name="returnCashStart"/> - <input class="text1" type="text" name="returnCashEnd"/> 元
				<span class="span">手续费金额：</span><input class="text1" type="text" name="serviceCashStart"/> - <input class="text1" type="text" name="serviceCashEnd"/> 元
				<br><br>
				<span>日期：</span><input id="startDate" name="startDate" type="text" class="Wdate" onclick="WdatePicker({skin:'whyGreen',maxDate:'#F{$dp.$D(\'endDate\')||\'new Date()\'}',dateFmt:'yyyy-MM-dd HH:mm:ss'})"/> - 
					<input id="endDate" name="endDate" type="text" class="Wdate" onclick="WdatePicker({skin:'whyGreen',minDate:'#F{$dp.$D(\'startDate\')}',dateFmt:'yyyy-MM-dd HH:mm:ss'})"/> 
			</form>
		</div>
		<div id="cv" style="margin-top: 20px;">
			<table id="payplatforBill" style="height: 600px;"></table>
		</div>
	</div>
	<script type="text/javascript" src="js/aiPinXuan/center/commodity/finance/payPlatformBill.js"></script>
</body>
</html>