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
		<td rowspan="2" style="width: 80px;">效果数据</td>
		<td id="coups">领券数量</td>
		<td id="rUsers">注册用户数</td>
		<td id="oTotal">购买数</td>
		<td id="payPrice">实际支付金额</td>
	</tr>
	<tr>
		<td id="coupons"></td>
		<td id="registUsers"></td>
		<td id="orderTotal"></td>
		<td id="realPay"></td>
	</tr>
</table>
<table class="table1" border="1" style="width: 1000px;"cellpadding="0" cellspacing="0">
	<tr class="tr1">
		<td rowspan="2" style="width: 80px;">参与数据</td>
		<td id="dis">发起邀请总人数</td>
		<td id="inv">被邀请总人数</td>
		<td id="first">被邀首单人数</td>
		<td id="cah">被邀请完成首单金额均值</td>
		<td id="full">邀请人满减券使用数量</td>
	</tr>
	<tr>
		<td id="disInviteCodeNum"></td>
		<td id="inviteCodeNum"></td>
		<td id="firstOrderTotal"></td>
		<td id="cashDivTotal"></td>
		<td id="fullcutNum"></td>
	</tr>
</table>
<table class="table1" border="1" style="width: 1000px;"cellpadding="0" cellspacing="0">
	<tr class="tr1">
		<td rowspan="2" style="width: 80px;">用券数据</td>
		<td id="proTotal">用券商品总价</td>
		<td id="oriPice">用券商品利润</td>
	</tr>
	<tr>
		<td id="productTotal"></td>
		<td id="profit"></td>
	</tr>
</table>

<table class="table1" border="1" style="width: 1000px;"cellpadding="0" cellspacing="0">
	<tr class="tr1">
		<td rowspan="2" style="width: 80px;">新人专区</td>
		<td id="uSku">新人专区购买SKU</td>
		<td id="uSpu">新人专区购买SPU</td>
		<td id="uPayCash">新人专区商品销售额</td>
	</tr>
	<tr>
		<td id="userSku">--</td>
		<td id="userSpu">--</td>
		<td id="userPayCash">--</td>
	</tr>
</table>



<table class="table1" border="1" style="width: 1000px;"cellpadding="0" cellspacing="0">
	<tr class="tr1">
		<td rowspan="2" style="width: 80px;">一元专区</td>
		<td id="oSku">一元专区购买SKU</td>
		<td id="oSpu">一元专区购买SPU</td>
		<td id="oPayCash"> 一元专区商品销售额</td>
	</tr>
	<tr>
		<td id="oneSku">--</td>
		<td id="oneSpu">--</td>
		<td id="onePayCash">--</td>
	</tr>
</table>

<table class="table1" border="1" style="width: 1000px;"cellpadding="0" cellspacing="0">
	<tr class="tr1">
		<td rowspan="2" style="width: 80px;">活动</td>
		<td id="uCose">获客成本</td>
		<td id="aCose">活动成本</td>
	</tr>
	<tr>
		<td id="getUserCost"></td>
		<td id="activityCost"></td>
	</tr>
</table>



<script type="text/javascript" src="js/aiPinXuan/center/marketing/activityComm.js"></script>
<script type="text/javascript" src="js/aiPinXuan/center/marketing/oldInvitationUserActivity.js"></script>
</body>
</html>