<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery-1.8.2.min.js"></script>

</head>
<body id="parent" style="position: relative; background-color: #FCFCFC;">
<style type="text/css">
<!-- 
	#parent {position: relative;}
	#child {
		position: absolute;
		top: 0;
		bottom: 0;
		left: 0;
		right: 0;
		width: 20%;
		height: 30%;
		margin: auto;
	}
	.span2{
		position: absolute; font-size: 20px; margin-top:30px; margin-left:50px;
	}
	.span1{
		position: absolute; font-size: 20px; margin-top:50px; margin-left:50px;
	}
 	.table1{ 
 		  margin-top:20px; text-align:center;height:200px;
 	} 
 	.div{
 		position: absolute;  text-align:center;height:400px;width:300px;
 	}
 	.left{text-align:right}
 	.right{text-align:left}
-->
</style>
	<div style="margin-left: 200px;margin-top: 50px;">
		<div class="div" style="width: 500px; height: 600px;">
			<div class="easyui-panel" title="个人信息" style="width:100%;max-width:600px;padding:30px 60px;">
				<div style="margin-bottom:20px">
			         <label class="label-top">用户名:</label>
			        <span id="userName">${requestScope.tUser.userName}</span>
			     </div>
			     <div style="margin-bottom:20px">
			         <label class="label-top">备注:</label>
			         <span id="remark">${requestScope.tUser.remark}</span>
			     </div>
			     <div style="margin-bottom:20px">
			         <a id="updateUser" class="easyui-linkbutton" style="background-color: #e2e2e2">修改密码</a>
						<a id="reset" class="easyui-linkbutton" style="background-color: #e2e2e2">取消</a>
			     </div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	$(function() {
		var username="${requestScope.tUser.userName}";
		$("#updateUser").click(function() {
			$("#centerUser").panel({
				href:"passwordManager/toUpdatePassword?username="+username
    		});
// 			window.location.href="passwordManager/toUpdatePassword?username="+username;
		});
		$("#reset").click(function() {
			location.href = "home";
		});
	})
	</script>
</body>
</html>