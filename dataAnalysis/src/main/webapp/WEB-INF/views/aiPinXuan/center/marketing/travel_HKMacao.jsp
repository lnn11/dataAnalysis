<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<style type="text/css">
	.table1{
		border:solid #ADADAD; border-width:1px 0px 0px 0px;margin: 30px 30px 0px 0px; 
		height: 200px;
	}
	.table1 td{border:solid #ADADAD; border-width:0px 1px 1px 0px;}
	.td2{width: 50px;background-color: #1E90FF;color: #FFF;}
	.tr1{background-color: #1E90FF;color: #FFF;}
</style>
		<div id="mydiv" style="position:absolute;display:none;border:1px solid;background:#FFFB5A;"></div> 
		<table class="table1"  border="1" style="width: 1115px;" cellpadding="0" cellspacing="0"> 
			<tr class="tr1">
				<td rowspan="2" style="width: 50px;">销售<br/>数据</td>
				<td id="travelSales">销售额</td>
				<td id="travelSaleSPUCount">活动销售SPU种类总数</td>
				<td id="travelSaleSKUCount">活动销售SKU种类总数</td>
				<td id="travelProductCount">活动商品总销量</td>
				<td id="travelSalesCash">现金满额销售额</td>
				<td id="travelSaleSPUCash">现金满额销售SPU种类总数</td>
				<td id="travelSaleSKUCash">现金满额销售SKU种类总数</td>
			</tr>
			<tr>
				<td id="saleTotal"></td>
				<td id="saleSpuTotal"></td>
				<td id="saleSkuTotal"></td>
				<td id="productTotal"></td>
				<td id="saleCashTotal"></td>
				<td id="saleSpuCashTotal"></td>
				<td id="saleSkuCashTotal"></td>
			</tr>
			<tr>
				<td class="td2">APP</td>
				<td id="saleAppTotal"></td>
				<td id="saleSpuAppTotal"></td>
				<td id="saleSkuAppTotal"></td>
				<td id="productAppTotal"></td>
				<td id="saleCashAppTotal"></td>
				<td id="saleSpuCashAppTotal"></td>
				<td id="saleSkuCashAppTotal"></td>
			</tr>
			<tr>
				<td class="td2">微网站</td>
				<td id="saleWebChatTotal"></td>
				<td id="saleSpuWebChatTotal"></td>
				<td id="saleSkuWebChatTotal"></td>
				<td id="productWebChatTotal"></td>
				<td id="saleCashWebChatTotal"></td>
				<td id="saleSpuCashWebChatTotal"></td>
				<td id="saleSkuCashWebChatTotal"></td>
			</tr>
			<tr>
				<td class="td2">微匠</td>
				<td id="saleMicroTotal"></td>
				<td id="saleSpuMicroTotal"></td>
				<td id="saleSkuMicroTotal"></td>
				<td id="productMicroTotal"></td>
				<td id="saleCashMicroTotal"></td>
				<td id="saleSpuCashMicroTotal"></td>
				<td id="saleSkuCashMicroTotal"></td>
			</tr>
		</table>
		<table class="table1"  border="1" style="width: 1115px;" cellpadding=0" cellspacing="0"> 
			<tr class="tr1">
				<td rowspan="2" style="width: 50px;">销售<br/>数据</td>
				<td id="travelSaleCash">现金满额总销量</td>
				<td id="travelOrderMainCount">活动订单总数</td>
				<td id="travelOrderCount">活动子订单总数</td>
				<td id="travelOrderMainCash">现金满额订单总数</td>
				<td id="travelOrderCash">现金满额子订单总数</td>
			</tr>
			<tr>
				<td id="saleCashTotalSub"></td>
				<td id="orderMainTotal"></td>
				<td id="orderSubTotal"></td>
				<td id="orderMainCashTotal"></td>
				<td id="orderSubCashTotal"></td>
			</tr>
			<tr>
				<td class="td2">APP</td>
				<td id="saleCashTotalAppSub"></td>
				<td id="orderMainAppTotal"></td>
				<td id="orderSubAppTotal"></td>
				<td id="orderMainCashAppTotal"></td>
				<td id="orderSubCashAppTotal"></td>
			</tr>
			<tr>
				<td class="td2">微网站</td>
				<td id="saleCashTotalWebChatSub"></td>
				<td id="orderMainWebChatTotal"></td>
				<td id="orderSubWebChatTotal"></td>
				<td id="orderMainCashWebChatTotal"></td>
				<td id="orderSubCashWebChatTotal"></td>
			</tr>
			<tr>
				<td class="td2">微匠</td>
				<td id="saleCashTotalMicroSub"></td>
				<td id="orderMainMicroTotal"></td>
				<td id="orderSubMicroTotal"></td>
				<td id="orderMainCashMicroTotal"></td>
				<td id="orderSubCashMircoTotal"></td>
			</tr>
		</table>
		<table class="table1" border="1" style="width: 1115px;"cellpadding="0" cellspacing="0">
			<tr class="tr1">
				<td rowspan="2" style="width: 60px;">支付<br/>数据</td>
				<td id="travelCashCount">现金支付总金额</td>
				<td id="travelCash">现金满额现金支付总金额</td>
				<td id="travelPointCount">实际支付总积分</td>
				<td id="travelPoint">现金满额实际支付总积分</td>
				<td id="travelGiftPointCount">福利券支付总积分</td>
				<td id="travelGiftPoint">现金满额褔利券支付总积分</td>
			</tr>
			<tr>
				<td id="payTotal"></td>
				<td id="buyCardPayTotal"></td>
				<td id="actualPayTotalPoint"></td>
				<td id="buyCardPayTotalPoint"></td>
				<td id="specialPointTotal"></td>
				<td id="buyCardSpecialTotal"></td>
			</tr>
			<tr>
				<td class="td2">APP</td>
				<td id="payTotalApp"></td>
				<td id="buyCardPayTotalApp"></td>
				<td id="actualPayTotalPointApp"></td>
				<td id="buyCardPayTotalPointApp"></td>
				<td id="specialPointAppTotal"></td>
				<td id="buyCardSpecialAppTotal"></td>
			</tr>
			<tr>
				<td class="td2">微网站</td>
				<td id="payTotalWebChat"></td>
				<td id="buyCardPayTotalWebChat"></td>
				<td id="actualPayTotalPointWebChat"></td>
				<td id="buyCardPayTotalPointWebChat"></td>
				<td id="specialPointWebChatTotal"></td>
				<td id="buyCardSpecialWebChatTotal"></td>
			</tr>
			<tr>
				<td class="td2">微匠</td>
				<td id="payTotalMicro"></td>
				<td id="buyCardPayTotalMicro"></td>
				<td id="actualPayTotalPointMicro"></td>
				<td id="buyCardPayTotalPointMicro"></td>
				<td id="specialPointMicroTotal"></td>
				<td id="buyCardSpecialMicroTotal"></td>
			</tr>
		</table>
		<table class="table1" border="1" style="width: 500px;"cellpadding="0" cellspacing="0">
			<tr class="tr1">
				<td rowspan="2" style="width: 60px;">支付<br/>数据</td>
				<td id="travelPrice">客单价</td>
				<td id="travelPriceCash">现金满额客单价</td>
			</tr>
			<tr>
				<td id="custSingleTotal"></td>
				<td id="cashSingle"></td>
			</tr>
			<tr>
				<td class="td2">APP</td>
				<td id="custSingleAppTotal"></td>
				<td id="cashSingleApp"></td>
			</tr>
			<tr>
				<td class="td2">微网站</td>
				<td id="custSingleWebChatTotal"></td>
				<td id="cashSingleWebChat"></td>
			</tr>
			<tr>
				<td class="td2">微匠</td>
				<td id="custSingleMicroTotal"></td>
				<td id="cashSingleMicro"></td>
			</tr>
		</table>
		<table class="table1" border="1" style="width: 800px;"cellpadding="0" cellspacing="0">
			<tr class="tr1">
				<td rowspan="2" style="width: 60px;">参与<br/>数据</td>
				<td id="travelUserCounts">活动参与总人数</td>
				<td id="travelRepeUserCounts">重复参与人数</td>
				<td id="travelNewUserCounts">新增会员数</td>
			</tr>
			<tr>
				<td id="travelUserCount"></td>
				<td id="travelRepeUserCount"></td>
				<td id="travelNewUserCount"></td>
			</tr>
			<tr>
				<td class="td2">APP</td>
				<td id="travelUserCountAPP"></td>
				<td id="travelRepeUserCountAPP"></td>
				<td align="center">--</td>
			</tr>
			<tr>
				<td class="td2">微网站</td>
				<td id="travelUserCountMicroMall"></td>
				<td id="travelRepeUserCountMicroMall"></td>
				<td align="center">--</td>
			</tr>
			<tr>
				<td class="td2">微匠</td>
				<td id="travelUserCountMicro"></td>
				<td id="travelRepeUserCountMicro"></td>
				<td align="center">--</td>
			</tr>
		</table>
	<script type="text/javascript" src="js/aiPinXuan/center/marketing/activityComm.js"></script>
	<script type="text/javascript" src="js/aiPinXuan/center/marketing/travel_HKMacao.js"></script>
</body>
</html>