<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>渠道数据分析</title>
</head>
<body>
<style type="text/css">
	.table1{
		border:solid #ADADAD; border-width:1px 1px 1px 1px;margin: 10px 10px 0px 0px; 
		height: 100px;
	}
	.table1 td{border:solid #ADADAD; border-width:0px 1px 1px 0px;}	
	.input_border_line{
		width: 80px;height: 20px;border: 1px solid gray;
	}
</style>
	<div class="easyui-panel" data-options="cls:'theme-panel-blue'" title="渠道数据分析" style="width:100%;height:100%;">
		<div style="padding-top: 20px;">
			<span>渠道名称:<select name="channelId"><option value="">全部</option></select></span>
			<span >注册用户数:<input type="text" name="registerMin" class="input_border_line">-<input type="text" name="registerMax" class="input_border_line">人</span>
			<span >订单数:<input type="text" name="orderMin" class="input_border_line">-<input type="text" name="orderMax" class="input_border_line"></span>
			<span >订单金额:<input type="text" name="amountsMin" class="input_border_line">-<input type="text" name="amountsMax" class="input_border_line">元</span>
			<span>实际支付金额:<input type="text" name="actualPayMin" class="input_border_line">-<input type="text" name="actualPayMax" class="input_border_line">元</span>
		</div>
		<div style="margin-top: 10px;">			
			<span>复购用户数:<input type="text" name="reBuyersMin" class="input_border_line">-<input type="text" name="reBuyersMax" class="input_border_line">人</span>
			<span>统计时间:<input type="text" id="startTime" name="startTime" readonly="readonly" class="Wdate"
			onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy/MM/dd',maxDate:'#F{$dp.$D(\'endTime\')||\'new Date()\'}'})">
			至<input type="text" id="endTime" name="endTime"  readonly="readonly" class="Wdate"
			onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy/MM/dd',minDate:'#F{$dp.$D(\'startTime\')||\'new Date()\'}'})"></span>
			<span>
				  <a href="javascript:void(0)" class="easyui-linkbutton query" style="background-color: #e2e2e2">查询</a>
<!-- 				  <a href="javascript:void(0)" class="easyui-linkbutton export" style="background-color: #e2e2e2">导出</a> -->
			</span>
		</div>
		<div style="margin-top: 10px;">统计时段：<span id="spnStart"></span>至<span id="spnEnd"></span></div>
		<div style="margin-top: 10px;">
			<table class="table1">
				<tr>
					<td>点击总数</td>
					<td>激活总数（下载且打开）</td>
					<td>注册用户总数（人）</td>
					<td>复购用户总数（人）</td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td><span id="spn_registers"></span></td>
					<td><span id="spn_reBuyers"></span></td>
				</tr>
				<tr>
					<td>订单总数</td>
					<td>订单总金额（元）</td>
					<td>实际支付总金额（元）</td>	
					<td></td>				
				</tr>
				<tr>
					<td><span id="spn_orders"></span></td>
					<td><span id="spn_amounts"></span></td>
					<td><span id="spn_actualPays"></span></td>		
					<td></td>			
				</tr>
			</table>
		</div>
		<div>
			<table id="channelAnalysisGrid" style="width:900px;height:250px"></table>
		</div>		
	</div>
	<script type="text/javascript">
			var channelTotal = ${channelTotal};
			
			$(document).ready(function(){
				$("input[name='startTime']").val("${startTime}");
				$("input[name='endTime']").val("${endTime}");
				$("#spnStart").html($("input[name='startTime']").val());
				$("#spnEnd").html($("input[name='endTime']").val());
				
				var channelMap = ${channelMap};
				if(channelMap !=null && channelMap.length > 0){					
					for (var i = 0; i < channelMap.length; i++) {
						$("select[name='channelId']").append("<option value='"+channelMap[i]["CHANNELID"]+"'>"+channelMap[i]["CHANNELNAME"]+"</option>");						
					}
				}
				
				queryData1();
				
				if(channelTotal == 0) channelTotal = 1;
				
				$("#channelAnalysisGrid").datagrid({
					fitColumns:true,
					striped:true,
					pagination:true,
					rownumbers:true,
					singleSelect:true,
					pageSize:(3*channelTotal),
					pageList:[(3*channelTotal),(7*channelTotal),(15*channelTotal),(30*channelTotal)],
					loadMsg:'正在加载，请稍等!',
					columns:[[
	 					{field:'startTime',title:'日期',align:'center'},
	 					{field:'channelId',title:'渠道号',align:'center'},
	 					{field:'channelName',title:'渠道名称',align:'center'},
	 					{field:'pvs',title:'pv数',align:'center'},
	 					{field:'uvs',title:'uv数',align:'center'},
	 					{field:'registers',title:'注册用户数',align:'center'},
	 					{field:'orders',title:'订单数',align:'center'},
	 					{field:'amounts',title:'订单总金额（元）',align:'center'},
	 					{field:'actualPay',title:'实际支付总金额（元）',align:'center'},
	 					{field:'reBuyers',title:'复购用户数',align:'center'} 					
					]],
					url:'marketing/channelAnalysis/list',
					queryParams:{						
						startTime:$("input[name='startTime']").val(),
						endTime:$("input[name='endTime']").val(),
						channelTotal:"${channelTotal}"
					}
				});
			});
			
			function custMethod(ss){
				return  customerArray = {
						channelId:ss,
						registerMin:$("input[name='registerMin']").val(),
						registerMax:$("input[name='registerMax']").val(),
						orderMin:$("input[name='orderMin']").val(),
						orderMax:$("input[name='orderMax']").val(),
						amountsMin:$("input[name='amountsMin']").val(),
						amountsMax:$("input[name='amountsMax']").val(),
						actualPayMin:$("input[name='actualPayMin']").val(),
						actualPayMax:$("input[name='actualPayMax']").val(),
						reBuyersMin:$("input[name='reBuyersMin']").val(),
						reBuyersMax:$("input[name='reBuyersMax']").val(),
						startTime:$("input[name='startTime']").val(),
						endTime:$("input[name='endTime']").val(),
						channelTotal:channelTotal
				};	
			}
			
			$(".easyui-linkbutton.query").click(function(){
				$("#spnStart").html($("input[name='startTime']").val());
				$("#spnEnd").html($("input[name='endTime']").val());
				queryData1();
				queryData2();
			});
			$("select[name='channelId']").change(function(){
				 $("#spnStart").html($("input[name='startTime']").val());
				 $("#spnEnd").html($("input[name='endTime']").val());
				
				 var ss = $(this).children('option:selected').val();		 
				 var custPageSize,custPageList;
				 if(ss != ''){
					 custPageSize = 10;
					 custPageList = [10,30,50,100];
					 channelTotal = 1;
				 }else{
					 channelTotal = ${channelTotal};
					 custPageSize = (3*channelTotal);
					 custPageList = [(3*channelTotal),(7*channelTotal),(15*channelTotal),(30*channelTotal)];
				 }				 
				 $("#channelAnalysisGrid").datagrid({
					 pageSize:custPageSize,
					 pageList:custPageList,
					 queryParams:custMethod(ss)
				 });
				 
			});
						
			function queryData1(){
				$.ajax({
					url:'marketing/channelAnalysis/countData',
					type:'post',
					data:custMethod($("select[name='channelId']").val()),
					dataType:'json',
					success:function(data){
						$("#spn_registers").html(data["REGISTERS"]);
						$("#spn_reBuyers").html(data["REBUYERS"]);
						$("#spn_orders").html(data["ORDERS"]);
						$("#spn_amounts").html(data["AMOUNTS"]);
						$("#spn_actualPays").html(data["ACTUALPAY"]);
					},
					error:function(errorThrown){
						alert(errorThrown);
					}
				});
			}
			
			function queryData2(){
				$("#channelAnalysisGrid").datagrid('load',custMethod($("select[name='channelId']").val()));				
			}			
			</script>
</body>
</html>