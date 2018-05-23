<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<style type="text/css">
	.table1{
		border:solid #ADADAD; border-width:0px 0px 0px 0px;margin: 30px 30px 0px 0px;
		height: 200px;
	}
	.table1 td{border:solid #ADADAD; border-width:0px 1px 1px 0px;}
	.td2{width: 50px;background-color: #1E90FF;color: #FFF;}
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
		</table>


<table  class="table1"  border="1" style="width: 800px;" cellpadding="0" cellspacing="0">
	<tr class="tr1">
		<td rowspan="2" style="width: 50px;">参与数据</td>
		<td id="enjoyTotal">活动参与总人数</td>
		<td id="repeatTotal">重复参与人数</td>
		<td id="addTotal">新增会员数</td>
		<%--<td hidden="true" id="activityTotal">拉新会员数</td>--%>
	</tr>
	<tr>
		<td id="enjoyUserCount"></td>
		<td id="repeatUserCount"></td>
		<td id="addUserCount"></td>
		<%--<td hidden="true" id="activityTotals"></td>--%>
	</tr>
	<tr>
		<td class="td2">APP</td>
		<td id="enjoyUserAppCount"></td>
		<td id="repeatUserAppCount"></td>
		<td id="activityUserApp"></td>
		<%--<td  id="activityMicroApp" align="center">--</td>--%>
	</tr>
	<tr>
		<td class="td2">微网站</td>
		<td id="enjoyUserMicroMallCount"></td>
		<td id="repeatUserMicroMallCount"></td>
		<td id="activityMicroMallTotal"></td>
		<%--<td hidden="true" id="activityMicroMallTotal"></td>--%>
	</tr>
	<tr>
		<td class="td2">微匠</td>
		<td id="enjoyUserMicroCount"></td>
		<td id="repeatUserMicroCount"></td>
		<td id="activityUserCountW"></td>
		<%--<td hidden="true" id="activityMicroMall" align="center">--</td>--%>
	</tr>
</table>
		

		



<%----------------------------%>

<table  class="table1"  border="0" style="width: 540px;height: 140px;border-top:0;" cellpadding="0" cellspacing="0">
	<tr class="tr1">
		<td  style="width: 100px;height: 18px;">游戏参与数据</td>
	</tr>
	<tr class="tr1">
		<td  style="width: 100px;height: 18px;">参与数据</td>
		<td >参与数据</td>
		<td >中奖数据</td>
		<td >抽奖数据</td>
	</tr>
	<tr>
		<td class="td2" style="height: 18px;">人次</td>
		<td id="participationDataTimes"></td>
		<td id="prizeDataTimes"></td>
		<td id="luckDraw"></td>
	</tr>
	<tr>
		<td class="td2" style="height: 18px;">人数</td>
		<td id="participationDataNumber"></td>
		<td id="prizeDataNumber"></td>
		<td id="disLuckDraw"></td>
	</tr>
</table>


<table  class="table1"  border="0" style="width: 1115px;height: 200px;" cellpadding="0" cellspacing="0">
	<tr class="tr1">
		<td  style="width: 100px;height: 18px;">优惠券数据</td>
	</tr>
	<tr class="tr1">
		<td  style="width: 50px;height: 35px;">参与数据</td>
		<td >优惠券发放数量</td>
		<td >优惠券使用数量</td>
		<td >优惠券发放人数</td>
		<td >优惠券使用人数</td>
		<td >优惠券过期数量</td>
		<td >优惠券过期人数</td>
		<td >优惠券订单总金额</td>
	</tr>
	<%--<tr>--%>
		<%--<td	 id="couponCountAdvanceCounts"></td>--%>
		<%--<td id="couponUseCounts"></td>--%>
		<%--<td id="couponAdvanceGrantUserCounts"></td>--%>
		<%--<td id="couponUseUserCounts"></td>--%>
		<%--<td id="getCouponPast"></td>--%>
		<%--<td id="couponPastUser"></td>--%>
		<%--<td id="getOrderCouponPastPrice"></td>--%>
	<%--</tr>--%>
	<tr>
		<td class="td2">5元</td>
		<td id="getCouponFiveAdvanceCount"></td>
		<td id="getCouponUseFiveCount"></td>
		<td id="couponUseUserFiveAdvanceCounts"></td>
		<td id="couponUseUserFiveCounts"></td>
		<td id="getCouponPastFiveCount"></td>
		<td id="couponPastUserFiveCounts"></td>
		<td id="orderCouponPastFivePrice"></td>
	</tr>
	<tr>
		<td class="td2">15元</td>
		<td id="couponGrantFifteenAdvanceCounts"></td>
		<td id="getCouponUseFifteenCount"></td>
		<td id="couponUseUseFifteenAdvancerCounts"></td>
		<td id="couponUseUserFifteenCounts"></td>
		<td id="couponPastFifteenCounts"></td>
		<td id="couponPastUserFifteenCounts"></td>
		<td id="getOrderCouponPastFifteenPrice"></td>
	</tr>
	<tr>
		<td class="td2">20元</td>
		<td id="getCouponTwentyAdvanceCount"></td>
		<td id="getCouponUseTwentyCount"></td>
		<td id="couponUseUserTwentyAdvanceCounts"></td>
		<td id="couponUseUserTwentyCounts"></td>
		<td id="getCouponPastTwentyCount"></td>
		<td id="couponPastUserTwentyCounts"></td>
		<td id="getOrderCouponPastTwentyPrice"></td>
	</tr>
	<tr>
		<td class="td2">50元</td>
		<td id="getCouponFiftyAdvanceCount"></td>
		<td id="getCouponUseFiftyCount"></td>
		<td id="couponUseUseFiftyAdvanceCounts"></td>
		<td id="couponUseUseFiftyCounts"></td>
		<td id="getCouponPastFiftyCount"></td>
		<td id="couponPastUserFiftyCounts"></td>
		<td id="getOrderCouponPastFiftyPrice"></td>
	</tr>
</table>
<table  class="table1"  border="0" style="width: 1115px;height: 140px;border-top:0;" cellpadding="0" cellspacing="0">
	<tr class="tr1">
		<td  style="width: 100px;height: 18px;">中奖数据</td>
	</tr>
	<tr class="tr1">
		<td  style="width: 50px;height: 35px;">中奖数据</td>
		<td>谢谢参与</td>
		<td>20积分</td>
		<td>50积分</td>
		<td>100积分</td>
		<td>500积分</td>
		<td>1000积分</td>
		<td>2018积分</td>
		<td>5元优惠券</td>
		<td>15元优惠券</td>
		<td>20元优惠券</td>
		<td>50元优惠券</td>
	</tr>

	<tr>
		<td class="td2">人次</td>
		<td id="thanksCountTimes"></td>
		<td id="thirtyCountTimes"></td>
		<td id="fiftyCountTimes">50</td>
		<td id="oneHundredCountTimes"></td>
		<td id="fiveHundredCountTimes"></td>
		<td id="oneThousandCountTimes"></td>
		<td id="2018CountTimes">2018</td>
		<td id="getCouponFiveAdvanceCountLuck"></td>
		<td id="couponGrantFifteenAdvanceCountsLuck"></td>
		<td id="getCouponTwentyAdvanceCountLuck"></td>
		<td id="getCouponFiftyAdvanceCountLuck"></td>
	</tr>
	<tr>
		<td class="td2">人数</td>
		<td id="thanksCountNumber"></td>
		<td id="thirtyCountNumber"></td>
		<td id="fiftyCountNumber"></td>
		<td id="oneHundredCountNumber"></td>
		<td id="fiveHundredCountNumber"></td>
		<td id="oneThousandCountNumber"></td>
		<td id="2018CountNumber"></td>
		<td id="couponUseUserFiveAdvanceCountsLuck"></td>
		<td id="couponUseUseFifteenAdvancerCountsLuck"></td>
		<td id="couponUseUserTwentyAdvanceCountsLuck"></td>
		<td id="couponUseUseFiftyAdvanceCountsLuck"></td>

	</tr>
</table>
	<script type="text/javascript" src="js/aiPinXuan/center/marketing/activityComm.js"></script>
	<script type="text/javascript" src="js/aiPinXuan/center/marketing/activityShowInfo.js"></script>
	<script type="text/javascript" src="js/aiPinXuan/center/marketing/newSpringGetCollarRed.js"></script>
</body>
</html>