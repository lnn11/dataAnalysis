<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../js/easyui/themes/default/easyui.css" type="text/css"></link>
<link rel="stylesheet" href="../js/easyui/themes/icon.css" type="text/css"></link>
<script type="text/javascript" src="../js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="../js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../js/easyui/easyui-lang-zh_CN.js"></script>
<style type="text/css">
	<!-- 
		body{position: relative; background-color: #FCFCFC;}
		.span{
			position: absolute; font-size: 20px; margin-top:30px; margin-left:50px;
		}
		.span1{
			position: absolute; font-size: 20px; margin-top:50px; margin-left:50px;
		}
	 	.table1{ 
	 		  margin-top:20px;height:200px;
	 	} 
	 	.div{
	 		position: absolute; margin-top:100px; margin-left:100px; text-align:center;height:400px;
	 	}
	 	.left{text-align:right}
	 	.right{text-align:left}
	 	#password1{font-size:12px;color:red}
	-->
	</style>
</head>
<body>
	<span class="span">修改信息</span>
	<span class="span1">-----------------------------------------------------------------</span>
	<div class="div">
		<form id="form" method="post">
			<table class="table1">
				<tr>
					<td class="left">用户名：</td><td class="right">
<%-- 					<span id="u">${requestScope.tUser.userName}</span> --%>
					<input type="text" value="${requestScope.username}" name="userName" class="easyui-validatebox" data-options="required:true"/><span style="font-size:12px;color:red" id="u">没有此用户</span>
					<input type="hidden" name="id"/></td>
				</tr>
				<tr>
					<td class="left">密码：</td><td class="right"><input type="password" name="password" class="easyui-validatebox" data-options="required:true"/></td>
				</tr>
				<tr>
					<td class="left">确认密码：</td><td class="right"><input type="password" name="password1" class="easyui-validatebox" data-options="required:true"/><span id="password1"></span></td>
				</tr>
<!-- 				<tr> -->
<!-- 					<td class="left">电子邮箱：</td><td class="right"><input type="text" name="email" /></td> -->
<!-- 				</tr> -->
				<tr>
					<td colspan="2" style="position:absolute; margin-left: 100px;">
						<input type="button" value="确定" id="updateUser"/>
						<input type="button" value="关闭" id="reset"/>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<script type="text/javascript">
		$(function() {
			$("#u").hide();
			$("#updateUser").click(function() {
				if($("[name='password']").val()!=$("[name='password1']").val()) {
					$("#password1").text("您两次输入的密码不一致，请确认");
				}else{
					if($("[name='userName']").val()!=null&&$("[name='userName']").val()!="") {
						$.ajax({
							url:"../passwordManager/checkUserName",
							data:{username:$("[name='userName']").val()},
							type:"post",
							dataType:"json",
							success:function(data) {
								if(data==null) {
									$("#password1").text("");
									$("#u").show();
								}else{
									$("[name='id']").val(data.id);
									$("#u").hide();
									$("#password1").text("");
									$("#form").form('submit',{
										url:"../passwordManager/updateUser",
										success:function(data) {
											if(data) {
												alert('操作成功');
												location.href = "../login";
											}else{
												alert('操作失败'); 
											}
										}
									})
								}
							}
						});
					};
				}
			});
			$("#reset").click(function() {
				location.href = "../login";
			});
		});
	</script>
</body>
</html>