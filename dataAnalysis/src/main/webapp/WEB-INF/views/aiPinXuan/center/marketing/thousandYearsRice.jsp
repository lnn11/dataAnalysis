<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<style type="text/css">
	.table1{
		border:solid #ADADAD; border-width:1px 0px 0px 0px;margin: 30px 30px 0px 0px; 
		height: 80px;
	}
	.table1 td{border:solid #ADADAD; border-width:0px 1px 1px 0px;}
	.td2{width: 50px;background-color: #1E90FF;color: #FFF;}
	.tr1{background-color: #1E90FF;color: #FFF;}
</style>
	<div id="mydiv" style="position:absolute;display:none;border:1px solid;background:#FFFB5A;"></div>
	<table class="table1" border="1" style="width: 1000px;"cellpadding="0" cellspacing="0">
		<tr class="tr1">
			<td rowspan="2" style="width: 80px;">页面数据</td>
			<td id="channelCount">渠道覆盖数量</td>
			<td id="ticketUV">领券页面展示量UV</td>
			<td id="ticketPV">领券页面展示量PV</td>
			<td id="activePV">活动展示页PV</td>
			<td id="activeUV">活动展示页UV</td>
			<td id="orderPV">提交订单页面展示量PV</td>
		</tr>
		<tr>
			<td id="channelCounts"></td>
			<td>--</td>
			<td>--</td>
			<td>--</td>
			<td>--</td>
			<td>--</td>
		</tr>
	</table> 
	<table class="table1" border="1" style="width: 1115px;"cellpadding="0" cellspacing="0">
		<tr class="tr1">
			<td rowspan="2" style="width: 60px;">效果数据</td>
			<td id="specialCount">获取购买特权数量</td>
			<td id="ticketCount">兑换码领取数量</td>
			<td id="specialCount1">获取优惠券数量</td>
			<td id="ticketCount1">使用优惠券数量</td>
			<td id="pastTicketCount">过期优惠券数量</td>
			<td id="registerUser">注册用户</td>
			<td id="buyCount">购买数</td>
			<td id="payMoney">实际支付金额</td>
			<td id="channelChange">渠道转化量</td>
			<td id="redeemCodePV">兑换码页面展示量PV</td>
			<td id="redeemCodeOrderPV">兑换码提交订单页面展示量PV</td>
		</tr>
		<tr>
			<td id="specialCounts"></td>
			<td id="ticketCountes"></td>
			<td id="pastTicketCounts"></td>
			<td id="registerUsers"></td>
			<td id="buyCounts"></td>
			<td id="payMoneys"></td>
			<td>--</td>
			<td>--</td>
			<td>--</td>
		</tr>
	</table>
	<table class="table1" border="1" style="width: 250px;"cellpadding="0" cellspacing="0">
		<tr class="tr1">
			<td rowspan="2" style="width: 500px;">打点数据</td>
			<td id="longinCount">去注册按钮（点击人次）</td>
		</tr>
		<tr>
			<td id="longinCounts"></td>
		</tr>
	</table>
	<script type="text/javascript" src="js/aiPinXuan/center/marketing/activityComm.js"></script>
	<script type="text/javascript" src="js/aiPinXuan/center/marketing/wuChangRice.js"></script>
</body>
</html>