<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<% 
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户登录超时</title>
</head>
<body>
	<p></p>
	<h5> 您尚未登录或登录时间过长,请<a href="login">重新登录</a> </h5>
</body>
</html>