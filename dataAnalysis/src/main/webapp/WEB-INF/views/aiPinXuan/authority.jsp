<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+--%>
<%
	String basePath = request.getContextPath()+"/";
%>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>爱品选数据雷达后台权限管理系统</title>
<link rel="stylesheet" href="js/EasyUI-1.5.1-InsdepTheme-1.0.4/themes/insdep/easyui.css" type="text/css"></link>
<link rel="stylesheet" href="js/EasyUI-1.5.1-InsdepTheme-1.0.4/themes/insdep/easyui_animation.css" type="text/css"></link>
<link rel="stylesheet" href="js/EasyUI-1.5.1-InsdepTheme-1.0.4/themes/insdep/easyui_plus.css" type="text/css"></link>
<link rel="stylesheet" href="js/EasyUI-1.5.1-InsdepTheme-1.0.4/themes/insdep/insdep_theme_default.css" type="text/css"></link>
<link rel="stylesheet" href="js/EasyUI-1.5.1-InsdepTheme-1.0.4/themes/insdep/icon.css" type="text/css"></link>
<link rel="stylesheet" href="js/EasyUI-1.5.1-InsdepTheme-1.0.4/themes/css/default.css" type="text/css"></link>
<link rel="stylesheet" href="js/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css"></link>
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="js/EasyUI-1.5.1-InsdepTheme-1.0.4/jquery.easyui-1.5.1.min.js"></script>
<script type="text/javascript" src="js/EasyUI-1.5.1-InsdepTheme-1.0.4/themes/insdep/jquery.insdep-extend.min.js"></script>
<script type="text/javascript" src="js/ztree/js/jquery.ztree.all-3.5.min.js"></script>
<script type="text/javascript" src="js/jquery.cookie.js"></script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',split:false,bodyCls:'theme-header-layout'" style="height: 100px; position: relative;">
		<a  id="back" onclick="javascript:history.back(-1);" style="float: right;margin-top: 10px; margin-right: 20px;" class="easyui-linkbutton">返回</a>
		<span style="float: right; margin-top: 18px; margin-right: 20px;"><a href="javascript:void(0);" style="text-decoration: none; color: #fff;font-size: 16px;" id="usernames"></a></span>
		<img style="float: right;margin-top: 10px; margin-right: 10px;" alt="头像" src="js/EasyUI-1.5.1-InsdepTheme-1.0.4/themes/insdep/images/portrait28x28.png">
	</div>
	<div id="leftA" data-options="region:'west',title:'权限管理',split:false,href:'aiPinXuan/authority/left/authority'" style="width: 200px; background-color: #eee"></div>
	<div id="centerA" data-options="region:'center',href:'aiPinXuan/authority/center/userManarger'" style="padding-top: 5px;"></div>
	<script type="text/javascript">
		$(function() {
			$("#usernames").html($.cookie('username'))
// 			$("#back").click(function() {
// 				location.href = "../home";
// 			})
		})
	</script>
</body>
</html>