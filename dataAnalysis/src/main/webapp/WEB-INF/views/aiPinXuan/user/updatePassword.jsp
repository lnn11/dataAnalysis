<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	 		  margin-top:20px; height:200px;
	 	} 
	 	.div{
	 		position: absolute; margin-top:100px; margin-left:100px; text-align:center;height:400px;
	 	}
	 	.left{text-align:right}
	 	.right{text-align:left}
	 	#password1{font-size:12px;color:red}
	 	#oldPassword1{font-size:12px;color:red}
	-->
	</style>
	<div style="margin-left: 200px;margin-top: 50px;">
		<div class="easyui-panel" title="修改密码" style="width:100%;max-width:600px;padding:30px 60px;">
			<form id="form" method="post">
				<div style="margin-bottom:20px">
			         <label class="label-top">用户名:</label>
			         <span>${requestScope.tUser.userName}</span>
					<input type="hidden" value="${requestScope.tUser.userName}" name="userName"/>
					<input type="hidden" value="${requestScope.tUser.id}" name="id"/>
		<!-- 	         <input class="easyui-passwordbox" data-options="required:true" prompt="Password" iconWidth="28" style="width:100%;" label='密码'> -->
			     </div>
				<div style="margin-bottom:20px">
			         <label class="label-top">旧密码:</label>
			         <input class="easyui-passwordbox" data-options="required:true" prompt="Password" iconWidth="28" style="width:100%;"  name="oldPassword">
			     	 <span id="oldPassword1"></span>
			     </div>
				<div style="margin-bottom:20px">
			         <label class="label-top">新密码:</label>
			         <input class="easyui-passwordbox" data-options="required:true" prompt="Password" iconWidth="28" style="width:100%;"  name="password">
			     </div>
			     <div style="margin-bottom:20px">
			         <label class="label-top">确认密码:</label>
			         <input class="easyui-passwordbox" data-options="required:true" prompt="Password" iconWidth="28" style="width:100%;"  name="password1">
			    	 <span id="password1"></span>
			     </div>
			     <div style="margin-bottom:20px">
			        <a id="updateUser" class="easyui-linkbutton" style="background-color: #e2e2e2">确定</a>
					<a id="reset" class="easyui-linkbutton" style="background-color: #e2e2e2">关闭</a>
			     </div>
			  </form>
		 </div>       
	 </div>      
	
	<script type="text/javascript">
		$(function() {
			$("#updateUser").click(function() {
				if($("[name='password']").val()!=$("[name='password1']").val()) {
					$("#password1").text("您两次输入的密码不一致，请确认");
				}else{
					$("#password1").text("");
					$.ajax({
						url:"passwordManager/checkPassword",
						data:{id:$("[name='id']").val(),password:$("[name='oldPassword']").val(),username:$("[name='userName']").val()},
						type:"post",
						dataType:"json",
						success:function(data) {
							if(data) {
								$("#oldPassword1").text("");
								$("#form").form('submit',{
									url:"passwordManager/updateUser",
									success:function(data) {
										if(data) {
											alert('操作成功');
											location.href = "home";
										}else{
											alert('操作失败'); 
										}
									}
								})
							}else{
								$("#oldPassword1").text("旧密码输入有误，请检查");
							}
						},
						error:function() {
							alert("ajax参数有误");							
						}
					});
				};
			});
			$("#reset").click(function() {
				location.href = "home";
			});
		});
	</script>
</body>
</html>