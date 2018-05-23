<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript" src="js/aiPinXuan/center/commodity/flat/flat.js"></script>
	<div style="height: 24px;padding-top: 5px;">
		<div style="float:left; padding:10px 0 0 10px">
			<span style="font-size: 20px">平台运营概览</span>                                               
		</div>
		<div style="float:right;padding: 10px;">
			<span style="font-size: 15px">统计时间段：</span>
			<input id="flatStartDate" class="Wdate" onclick="WdatePicker({skin:'whyGreen',maxDate:'#F{$dp.$D(\'flatEndDate\')||\'new Date()\'}'})"/> - 
			<input id="flatEndDate" class="Wdate" onclick="WdatePicker({skin:'whyGreen',minDate:'#F{$dp.$D(\'flatStartDate\')}',maxDate:'%y-%M-%d 23:59:59'})"/>
			<a onclick="tongCount()" class="easyui-linkbutton" style="background-color: #e2e2e2">统计</a>
		</div>
	</div>
	<div id="p" class="easyui-panel" title="流量类指标" style="width:100%;padding:20px;" data-options="cls:'theme-panel-blue'">
		<table style="width: 800px;height: 100px;margin-left: 100px">
			<tr  align="center">
				<td>浏览量(PV)</td>
				<td>访客数(UV)</td>
				<td>会员总数</td>
				<td>激活会员<span id="activation">0</span>人</td>
				<td>注册会员<span id="register">0</span>人</td>
				<td>APP下载量</td>
			</tr>
			<tr  align="center">
				<td><span id="pvSpan"></span></td>
				<td>0人</td>
				<td><span id="member">0</span>人</td>
				<td colspan="2">已认证会员总数：<span id="authentication">0</span>人</td>
				<td>0</td>
			</tr>
		</table>
	</div>
	<div id="p" class="easyui-panel" title="商品类指标" style="width:100%;padding:20px;" data-options="cls:'theme-panel-blue'">
		<table style="width: 800px;height: 100px;margin-left: 100px">
			<tr  align="center">
				<td>供应商总数</td>
				<td>知名品牌</td>
				<td>在售商品SPU总数</td>
				<td>SPU总数</td>
				<td>在售商品SKU总数</td>
				<td>SKU总数</td>
				<td>已售出商品总数</td>
			</tr>
			<tr  align="center">
				<td><span id="supplier">0</span>家</td>
				<td><span id="knowBrand">0</span>个</td>
				<td><span id="onSaleProduct">0</span>件</td>
				<td><span id="saledProduct">0</span>件</td>
				<td><span id="inTheSaleOf">0</span>件</td>
				<td><span id="inTheSaleOfEd">0</span>件</td>
				<td><span id="areadySaledData">0</span>件</td>
			</tr>
		</table>
		<hr style="border-style: dashed; border-color: #eee; width: 800px; margin-left: 100px;margin-bottom: 20px" >
		<span style="font-size: 15px; margin-left: 100px">订单总数：<span id="orderCount">0</span></span>
		<span style="font-size: 15px; margin-left: 50px">已发货订单：<span id="alreadyShippedOrder">0</span></span>    
		<span style="font-size: 15px; margin-left: 50px">已收货订单：<span id="receivedGoodsOrder">0</span></span>    
		<span style="font-size: 15px; margin-left: 50px">已取消订单：<span id="beenCanceledOrder">0</span></span>    
		<span style="font-size: 15px; margin-left: 50px">已退货订单：<span id="returnedOrder">0</span></span>
	</div>
	<div id="p" class="easyui-panel" title="充值类指标" style="width:100%;padding:20px;" data-options="cls:'theme-panel-blue'">
		<table style="width: 678px;height: 100px;margin-left: 100px">
			<tr  align="center">
				<td>订单总数：</td>
				<td>话费订单总数：<span id="phoneOrder">0</span></td>
				<td>流量订单总数：<span id="flowOrder">0</span></td>
				<td>加油卡订单总数：<span id="fuelOrder">0</span></td>
			</tr>
			<tr  align="center">
				<td><span id="rechargeOrder">0</span></td>
				<td style="padding-left: 43px;">
					<table>
						<tbody>
							<tr>
								<td>已支付：</td>
								<td><span id="payPhoneOrder">0</span></td>
							</tr>
							<tr>
								<td>已完成：</td>
								<td><span id="completedPhoneOrder">0</span></td>
							</tr>
							<tr>
								<td>已取消：</td>
								<td><span id="cancelPhoneOrder">0</span></td>
							</tr>
							<tr>
								<td>已失效：</td>
								<td><span id="lapsedPhoneOrder">0</span></td>
							</tr>
						</tbody>
					</table>
				</td>
				<td style="padding-left: 36px;">
					<table>
						<tbody>
							<tr>
								<td><span>已支付：</span></td>
								<td><span id="payFlowOrder">0</span></td>
							</tr>
							<tr>
								<td><span>已完成：</span></td>
								<td><span id="completedFlowOrder">0</span></td>
							</tr>
							<tr>
								<td><span>已取消：</span></td>
								<td><span id="cancelFlowOrder">0</span></td>
							</tr>
							<tr>
								<td><span>已失效：</span></td>
								<td><span id="lapsedFlowOrder">0</span></td>
							</tr>
						</tbody>
					</table>
				</td>
				<td style="padding-left: 43px;">
					<table>
						<tbody>
							<tr>
								<td><span>已支付：</span></td>
								<td><span id="payFuelOrder">0</span></td>
							</tr>
							<tr>
								<td><span>已完成：</span></td>
								<td><span id="completedFuelOrder">0</span></td>
							</tr>
							<tr>
								<td><span>已取消：</span></td>
								<td><span id="cancelFuelOrder">0</span></td>
							</tr>
							<tr>
								<td><span>已失效：</span></td>
								<td><span id="lapsedFuelOrder">0</span></td>
							</tr>
						</tbody>
					</table>
				</td>
			</tr>
		</table>
	</div>
	<div id="p" class="easyui-panel" title="总体销售业绩指标" style="width:100%;padding:20px;" data-options="cls:'theme-panel-blue'">
		<table style="width: 800px;height: 100px;margin-left: 100px;">
			<tr  align="center">
				<td>商品总价</td>
				<td>商品成本</td>
				<td>实际毛利润</td>
				<td>转化率</td>
			</tr>
			<tr  align="center">
				<td><span id="productSalesVolumes">0.00</span>元</td>
				<td><span id="areadyPaidCostData">0.00</span>元</td>
				<td><span id="areadyPaidGrossProfit">0.00</span>元</td>
				<td><span id="percentConversion">0.00</span>%</td>
			</tr>
		</table>
		<hr style="border-style: dashed; border-color: #eee; width: 800px;margin-left: 100px"" align="center" >
		<table style="width: 800px;height: 100px;margin-left: 100px">
			<tr align="left">
				<td>实际支付对应总金额：</td><td><span id="actualPaidSalesVolumes">0.00</span>元</td>
				<td>现金支付总金额：</td><td><span id="actualPaidSalesMoney">0.00</span>元</td>
			</tr>
			<tr align="left">
				<td>活动抵扣对应金额：</td><td><span id="activitySalesMoney">0.00</span>元</td>
				<td>实际支付总积分：</td><td><span id="actualPaidSalesIntegral">0</span>积分</td>
			</tr>
			<tr align="left">
				<td>实际毛利率：</td><td><span id="grossRate">0.00</span>%</td>
				<td>动销率：</td><td><span id="moveRate">0</span>%</td>
			</tr>
		</table>
	</div>
	<div id="p" class="easyui-panel" title="充值销量指标" style="width:100%;" data-options="cls:'theme-panel-blue'">
	</div>
		<div id="p" class="easyui-panel" title="话费" style="width:100%;" data-options="cls:'theme-border-radius'">
			<table style="width: 800px;height: 100px;margin-left: 100px">
				<tr  align="center">
					<td>销售额</td>
					<td>充值成本</td>
					<td>毛利润</td>
				</tr>
				<tr  align="center">
					<td>
						<span id="phoneSaleMoney">0.00</span>元
					</td>
					<td>
						<span id="phoneCostMoney">0.00</span>元
					</td>
					<td>
						<span id="phoneGrossProfit">0.00</span>元
					</td>
				</tr>
			</table>
		</div>
		<div id="p" class="easyui-panel" title="流量" style="width:100%;" data-options="cls:'theme-border-radius'">
			<table style="width: 800px;height: 100px;margin-left: 100px">
				<tr  align="center">
					<td>销售额</td>
					<td>充值成本</td>
					<td>毛利润</td>
				</tr>
				<tr  align="center">
					<td>
						<span id="flowSaleMoney">0.00</span>元
					</td>
					<td>
						<span id="flowCostMoney">0.00</span>元
					</td>
					<td>
						<span id="flowGrossProfitr">0.00</span>元
					</td>
				</tr>
			</table>
		</div>
		<div id="p" class="easyui-panel" title="加油卡" style="width:100%;" data-options="cls:'theme-border-radius'">
			<table style="width: 800px;height: 100px;margin-left: 100px">
				<tr  align="center">
					<td>销售额</td>
					<td>充值成本</td>
					<td>毛利润</td>
				</tr>
				<tr  align="center">
					<td>
						<span id="fuelCardSaleMoney">0.00</span>元
					</td>
					<td>
						<span id="fuelCardCostMoney">0.00</span>元
					</td>
					<td>
						<span id="fuelCardflowGrossProfitr">0.00</span>元
					</td>
				</tr>
			</table>
		</div>
	
</body>
</html>