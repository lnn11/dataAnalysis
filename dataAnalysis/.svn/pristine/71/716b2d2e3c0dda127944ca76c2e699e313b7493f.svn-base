<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<script type="text/javascript">
			var time = new Date();
			var year = time.getFullYear();
			var month = time.getMonth()+1;
			var day = time.getDate();
			var date = year + "年" + month + "月" + day + "日";
			$("#newDate").text(date);
		</script>
		<a  id="logout" style="float: right;margin-top: 10px; margin-right: 20px;" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-cancel'"></a>
		<span style="float: right; margin-top: 18px; margin-right: 20px;"><a href="javascript:void(0);" style="text-decoration: none; color: #fff;font-size: 16px;" id="username"></a></span>
		<img style="float: right;margin-top: 10px; margin-right: 10px;" alt="头像" src="js/EasyUI-1.5.1-InsdepTheme-1.0.4/themes/insdep/images/portrait28x28.png">
		<script type="text/javascript">
			$(function() {
				$("#username").html($.cookie('username'))
				$("#logout").click(function(){
//					window.location.href="logout";
					window.location.href="logout";
				});
				
				$("#username").click(function() {
					var username=$("#username").html();
					if($.cookie('username')=="admin") {
						location.href="authority/authorized";
					}else{
						$("#userInfoLayOut").show();
						$("#centerUser").panel({
			    			href:"passwordManager/toUserInfo?username="+username
			    		});
// 						$("#leftUser").panel({
// 							href:"passwordManager/toUserInfoLeft"		
// 						});
					}
// 					window.location.href = "passwordManager/toUserInfo?username="+$("#username").html();
				});
			})
		</script>
</body>
</html>