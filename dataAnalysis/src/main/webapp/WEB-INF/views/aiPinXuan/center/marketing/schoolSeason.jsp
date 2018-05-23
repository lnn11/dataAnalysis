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
		height: 200px;
	}
	.table1 td{border:solid #ADADAD; border-width:0px 1px 1px 0px;}
	.td2{width: 60px;background-color: #1E90FF;color: #FFF;}
	.tr1{background-color: #1E90FF;color: #FFF;}
</style>
		<div id="mydiv" style="position:absolute;display:none;border:1px solid;background:#FFFB5A;"></div> 
		<table class="table1"  border="1" style="width: 1115px;" cellpadding="0" cellspacing="0"> 
			<tr class="tr1">
				<td rowspan="2" style="width: 50px;">销售数据</td>
				<td id="saleSPUCount">活动销售SPU种类总数</td>
				<td id="saleSKUCount">活动销售SKU种类总数</td>
				<td id="productCount">活动商品总销量</td>
				<td id="salesOrderNoMainTotal">活动主订单总数</td>
				<td id="salesOrderNoTotal">活动子订单总数</td>
			</tr>
			<tr>
				<td id="saleSpuTotal"></td>
				<td id="saleSkuTotal"></td>
				<td id="saleProductTotal"></td>
				<td id="saleMainOrderTotal"></td>
				<td id="saleSubOrderTotal"></td>
			</tr>
			<tr>
				<td class="td2">APP</td>
				<td id="saleSpuAppTotal"></td>
				<td id="saleSkuAppTotal"></td>
				<td id="saleProductAppTotal"></td>
				<td id="saleMainOrderAppTotal"></td>
				<td id="saleSubOrderAppTotal"></td>
			</tr>
			<tr>
				<td class="td2">微网站</td>
				<td id="saleSpuWebChatTotal"></td>
				<td id="saleSkuWebChatTotal"></td>
				<td id="saleProductWebChatTotal"></td>
				<td id="saleMainOrderWebChatTotal"></td>
				<td id="saleSubOrderWebChatTotal"></td>
			</tr>
			<tr>
				<td class="td2">微匠</td>
				<td id="saleSpuMicroTotal"></td>
				<td id="saleSkuMicroTotal"></td>
				<td id="saleProductMicroTotal"></td>
				<td id="saleMainOrderMicroTotal"></td>
				<td id="saleSubOrderMicroTotal"></td>
			</tr>
			<tr>
				<td class="td2">M站</td>
				<td id="saleSpuMTotal"></td>
				<td id="saleSkuMTotal"></td>
				<td id="saleProductMTotal"></td>
				<td id="saleMainOrderMTotal"></td>
				<td id="saleSubOrderMTotal"></td>
			</tr>
		</table>
		<table class="table1"  border="1" style="width: 800px;" cellpadding="0" cellspacing="0"> 
			<tr class="tr1">
				<td rowspan="2" style="width: 60px;">支付数据</td>
				<td id="saleCash">现金支付总金额</td>
				<td id="salePoint">实际支付总积分</td>
				<td id="saleSpecialPoint">福利券支付总积分</td>
			</tr>
			<tr>
				<td id="saleCashTotalSub"></td>
				<td id="actualPayPointTotal"></td>
				<td id="specialCashTotal"></td>
			</tr>
			<tr>
				<td class="td2">APP</td>
				<td id="saleCashTotalAppSub"></td>
				<td id="actualPayPointAppTotal"></td>
				<td id="specialCashAppTotal"></td>
			</tr>
			<tr>
				<td class="td2">微网站</td>
				<td id="saleCashTotalWebChatSub"></td>
				<td id="actualPayPointWebChatTotal"></td>
				<td id="specialCashWebChatTotal"></td>
			</tr>
			<tr>
				<td class="td2">微匠</td>
				<td id="saleCashTotalMicroSub"></td>
				<td id="actualPayPointMicroTotal"></td>
				<td id="specialCashMicroTotal"></td>
			</tr>
			<tr>
				<td class="td2">M站</td>
				<td id="saleCashTotalMSub"></td>
				<td id="actualPayPointMTotal"></td>
				<td id="specialCashMTotal"></td>
			</tr>
		</table>
		
		
		<table class="table1" border="1" style="width: 1115px;"cellpadding="0" cellspacing="0">
			<tr class="tr1">
				<td rowspan="2" style="width: 60px;">参与数据</td>
				<td id="enjoyTotal">活动参与总人数</td>
				<td id="repeatTotal">重复参与人数</td>
				<td id="addTotal">新增会员数</td>
				<td id="activityTotal">拉新会员数</td>
			</tr>
			<tr>
				<td id="enjoyUserCount"></td>
				<td id="repeatUserCount"></td>
				<td id="addUserCount"></td>
				<td id="activityTotals"></td>
			</tr>
			<tr>
				<td class="td2">APP</td>
				<td id="enjoyUserAppCount"></td>
				<td id="repeatUserAppCount"></td>
				<td align="center">--</td>
				<td align="center">--</td>
			</tr>
			<tr>
				<td class="td2">微网站</td>
				<td id="enjoyUserMicroMallCount"></td>
				<td id="repeatUserMicroMallCount"></td>
				<td align="center">--</td>
				<td id="activityMicroMallTotal"></td>
			</tr>
			<tr>
				<td class="td2">微匠</td>
				<td id="enjoyUserMicroCount"></td>
				<td id="repeatUserMicroCount"></td>
				<td align="center">--</td>
				<td align="center">--</td>
			</tr>
			<tr>
				<td class="td2">M站</td>
				<td id="enjoyUserMCount"></td>
				<td id="repeatUserMCount"></td>
				<td align="center">--</td>
				<td id="activityMTotal"></td>
			</tr>
		</table>
		
		<table class="table1" border="1" style="width: 1115px;height: 100px;"cellpadding="0" cellspacing="0">
			<tr class="tr1">
				<td class="td2" id="participationDatas">参与数据</td>
				<td id="participationData">参与数据</td>
				<td id="prizeData">中奖数据</td>
				<td id="enjoyData">分享数据</td>
				<td id="expendIntegrals">大转盘消耗积分数</td>
			</tr>
			<tr>
				<td class="td2">人次</td>
				<td id="participationDataTimes"></td>
				<td id="prizeDataTimes"></td>
				<td id="enjoyDataTimes"></td>
				<td rowspan="2" id="expendIntegral"></td>
			</tr>
			<tr>
				<td class="td2">人数</td>
				<td id="participationDataNumber"></td>
				<td id="prizeDataNumber"></td>
				<td id="enjoyDataNumber">--</td>
			</tr>
		</table>
		
		<table class="table1" border="1" style="width: 1115px;height: 150px;"cellpadding="0" cellspacing="0">
			<tr class="tr1">
				<td class="td2">中奖数据</td>
				<td>谢谢</td>
				<td>30积分</td>
				<td>100积分</td>
				<td>200积分</td>
				<td>500积分</td>
				<td>维乐夫菊粉（件）</td>
				<td>夏季凉被（件）</td>
				<td>iPad（台）</td>
			</tr>
			<tr>
				<td class="td2">奖励值</td>
				<td id="thanksCount">0</td>
				<td id="thirtyCount"></td>
				<td id="hundredCount"></td>
				<td id="twoHundredCount"></td>
				<td id="FiveHundredCount"></td>
				<td id="weileCount"></td>
				<td id="summerCount"></td>
				<td id="iPadCount"></td>
			</tr>
			<tr>
				<td class="td2">人次</td>
				<td id="thanksCountTimes"></td>
				<td id="thirtyCountTimes"></td>
				<td id="hundredCountTimes"></td>
				<td id="twoHundredCountTimes"></td>
				<td id="FiveHundredCountTimes"></td>
				<td id="weileCountTimes"></td>
				<td id="summerCountTimes"></td>
				<td id="iPadCountTimes"></td>
			</tr>
			<tr>
				<td class="td2">人数</td>
				<td id="thanksCountNumber"></td>
				<td id="thirtyCountNumber"></td>
				<td id="hundredCountNumber"></td>
				<td id="twoHundredCountNumber"></td>
				<td id="FiveHundredCountNumber"></td>
				<td id="weileCountNumber"></td>
				<td id="summerCountNumber"></td>
				<td id="iPadCountNumber"></td>
			</tr>
		</table>
	<script type="text/javascript" src="js/aiPinXuan/center/marketing/activityComm.js"></script>
	<script type="text/javascript" src="js/aiPinXuan/center/marketing/activityShowInfo.js"></script>
	<script type="text/javascript" src="js/aiPinXuan/center/marketing/activityTemplate.js"></script>
</body>
</html>