<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>爱品选数据雷达系统</title>
<link rel="stylesheet" href="js/EasyUI-1.5.1-InsdepTheme-1.0.4/themes/insdep/easyui.css" type="text/css"></link>
<link rel="stylesheet" href="js/EasyUI-1.5.1-InsdepTheme-1.0.4/themes/insdep/easyui_animation.css" type="text/css"></link>
<!-- <link rel="stylesheet" href="js/EasyUI-1.5.1-InsdepTheme-1.0.4/themes/insdep/easyui_plus.css" type="text/css"></link> -->
<link rel="stylesheet" href="js/EasyUI-1.5.1-InsdepTheme-1.0.4/themes/insdep/insdep_theme_default.css" type="text/css"></link>
<link rel="stylesheet" href="js/EasyUI-1.5.1-InsdepTheme-1.0.4/themes/insdep/icon.css" type="text/css"></link>
<link rel="stylesheet" href="js/EasyUI-1.5.1-InsdepTheme-1.0.4/themes/css/default.css" type="text/css"></link>
<link rel="stylesheet" href="css/table.css" type="text/css"></link>
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="js/EasyUI-1.5.1-InsdepTheme-1.0.4/jquery.easyui-1.5.1.min.js"></script>
<script type="text/javascript" src="js/EasyUI-1.5.1-InsdepTheme-1.0.4/themes/insdep/jquery.insdep-extend.min.js"></script>
<script type="text/javascript" src="js/echarts.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="js/jquery.cookie.js"></script>
</head>
<body class="easyui-layout" fit="true" style="padding:0px">
	<div data-options="region:'north',href:'aiPinXuan/top',bodyCls:'theme-header-layout'" style="height: 10%;"></div>
	<div data-options="region:'center',border:false">
		<div class="easyui-layout" fit="true" style="padding:0px" hidden="true" id="userInfoLayOut">
			<div id="centerUser" data-options="region:'center',border:false"></div>
		</div>
		<div id="tabs" class="easyui-tabs theme-tab-black-block" data-options="tabPosition:'top',tabWidth:140,tabHeight:40" style="width:100%;height:100%">
			<div title="首页" data-options="tabPosition:'top',tabWidth:200">
				<div class="easyui-layout" fit="true" style="padding:0px">
					<div data-options="region:'west',title:'欢迎登录'" style="width: 15%;"></div>
					<div id="center" data-options="region:'center',border:false,href:'aiPinXuan/center/welcome'"></div>
				</div>
			</div>
			<div title="总体运营分析">
				<div class="easyui-layout" fit="true" style="padding:0px">
					<div id="leftZong" data-options="region:'west',title:'总体运营分析',href:'aiPinXuan/left/zong'" style="width: 15%;"></div>
					<div id="centerZong" data-options="region:'center',border:false,href:'aiPinXuan/center/welcome'"></div>
				</div>
			</div>
			<div title="平台流量分析">
				<div class="easyui-layout" fit="true">
					<div data-options="region:'west',title:'平台流量分析'" style="width: 15%;"></div>
					<div id="center" data-options="region:'center',border:false,href:'aiPinXuan/center/welcome'"></div>
				</div>
			</div>
			<div title="销售情况分析">
				<div class="easyui-layout" fit="true">
					<div data-options="region:'west',title:'销售情况分析'" style="width: 15%;"></div>
					<div id="center" data-options="region:'center',border:false,href:'aiPinXuan/center/welcome'"></div>
				</div>
			</div>
			<div title="客户价格分析">
				<div class="easyui-layout" fit="true">
					<div data-options="region:'west',title:'客户价格分析'" style="width: 15%;"></div>
					<div id="center" data-options="region:'center',border:false,href:'aiPinXuan/center/welcome'"></div>
				</div>
			</div>
			<div title="商城分析">
				<div class="easyui-layout" fit="true">
					<div id="leftComm" data-options="region:'west',title:'商城分析',href:'aiPinXuan/left/comm'" style="width: 15%;"></div>
					<div id="centerComm" data-options="region:'center',border:false,href:'aiPinXuan/center/welcome'"></div>
				</div>
			</div>
			<div title="营销活动分析">
				<div class="easyui-layout" fit="true">
					<div id="leftMarketing" data-options="region:'west',title:'营销活动分析',href:'aiPinXuan/left/marketing'" style="width: 15%;"></div>
					<div id="centerMarketing" data-options="region:'center',border:false,href:'aiPinXuan/center/welcome'"></div>
				</div>
			</div>
			<div title="客户互动分析">
				<div class="easyui-layout" fit="true">
					<div data-options="region:'west',title:'客户互动分析'" style="width: 15%;"></div>
					<div id="center" data-options="region:'center',border:false,href:'aiPinXuan/center/welcome'"></div>
				</div>
			</div>
			<div title="财务结算分析">
				<div class="easyui-layout" fit="true">
					<div id="leftFinnce" data-options="region:'west',title:'财务结算分析',href:'aiPinXuan/left/finance'" style="width: 15%;"></div>
					<div id="centerFinnce" data-options="region:'center',border:false,href:'aiPinXuan/center/welcome'"></div>
				</div>
			</div>
	<%-- 		<div title="<span class='tt-inner'><img src='js/EasyUI-1.5.1-InsdepTheme-1.0.4/themes/insdep/icons/man.png'/></span>"> --%>
	<!-- 			<div class="easyui-layout" fit="true"> -->
	<!-- 				<div data-options="region:'west',title:'个人信息',href:'passwordManager/toUserInfoLeft'" style="width: 15%;"></div> -->
	<!-- 				<div id="centerUser" data-options="region:'center',border:false,href:'aiPinXuan/center/welcome'"> -->
						
	<!-- 				</div> -->
	<!-- 			</div> -->
	<!-- 		</div> -->
		</div>
	</div>
	<script type="text/javascript">
		$(function() {
			$("#tabs").tabs('disableTab',2);
			$("#tabs").tabs('disableTab',3);
			$("#tabs").tabs('disableTab',4);
			$("#tabs").tabs('disableTab',7);
// 			$('#tabs').tabs({
// 			    border:false,
// 			    onSelect:function(title,index){
// 			        if(index==1){
// 			        	$("#leftZong").panel({
// 			        		href:'aiPinXuan/left/zong'
// 			        	}) 
// 			     		$("#centerZong").panel({
// 				 			href:'aiPinXuan/center/totality/flat/flat'
// 				 		})
// 			        }else if(index==5) {
// 			        	$("#leftComm").panel({
// 			        		href:'aiPinXuan/left/comm'
// 			        	}) 
// 			         	$("#centerComm").panel({
// 				     		href:'aiPinXuan/center/commodity/provider/xiao'
// 				     	})
// 			        }else if(index==6) {
// 			        	$("#leftMarketing").panel({
// 			        		href:'aiPinXuan/left/marketing'
// 			        	}) 
// 			        	$("#centerMarketing").panel({
// 			         		href:'aiPinXuan/center/marketing/activityData'
// 				     	})
// 			        }else if(index==8) {
// 			        	$("#leftFinnce").panel({
// 			        		href:'aiPinXuan/left/finance'
// 			        	}) 
// 			        	$("#centerFinnce").panel({
// 			         		href:'aiPinXuan/center/finance/supplierBill'
// 			         	})
// 			        }
// 			    }
// 			});
		})
	</script>
</body>
</html>