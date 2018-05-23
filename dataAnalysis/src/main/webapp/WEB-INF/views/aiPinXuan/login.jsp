<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <link rel="stylesheet" href="css/login.css">
    <script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
    <script src="js/base64.js" ></script>
</head>

<body>
<div class="container">
    <nav>
        <img src="images/login_logo.png" alt="">
    </nav>
    <div class="title">
        <img src="images/login_title.png" alt="">
    </div>
    <div class="login">
         <form:form action="login" method="post" modelAttribute="loginCommand" onsubmit="pas()">
            <div class="loginName">
                <span></span>
                <i>登录名:</i>
<!--                 <input type="text"> -->
                <form:input path="username" type="text" id="username" />
                <!--<img src="../images/login_icon_name.png" alt="">-->
            </div>
            <div class="loginPassword">
                <span></span>
                <i>密&nbsp;&nbsp;&nbsp;码:</i>
                 <input path="password1" type="password" id="password1" />
<!--                 <input type="password"> -->
                <!--<img src="../images/login_icon_password.png" alt="">-->
                <form:input path="password" type="password" id="password"  hidden="true" />
            </div>

            <div class="loginIdectify">
                <span></span>
                <i>验证码:</i>
                <form:input path="validatorCode"/>
<!--                 <input type="text"> -->
                <!--<img src="../images/login_icon_identify.png" alt="">-->
                <img id="imgObj" alt="验证码" title="看不清可单击图片刷新" onclick="loadPng()">
            </div>
            <div style="line-height:10px;">
		        	<font color="red">
						<spring:bind path="*">
			                ${status.errorMessage}
			            </spring:bind>
		            </font>
		        </div>
            <input type="submit" value="登&nbsp;录" >
        </form:form>
    </div>
</div>
<script type="text/javascript">
	$(function() {
		loadPng();
		$("#forget").click(function() {
			window.location.href="passwordManager/toUpdatePasswordForget?username="+$("#username").val();
		})
	});
	function loadPng() {
		$("#imgObj").attr("src", "verificationCode/getVerificationCode?" + Math.random());
	}
    function pas(){
        var pass=$("#password1").val();
        document.getElementById('password').value=encode64(pass);
    }
</script>
</body>
</html>