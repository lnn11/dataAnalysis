<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
	<div id="p" class="easyui-panel" title="销售商品排名" style="width:100%;padding:20px;" data-options="cls:'theme-panel-blue'">
		<div style="height: 50px; width:1100px; font-size: 16px; margin-top: 20px">
			<div style="height: 50px; float: left;">
				统计方式：<input type="radio" id="sellsales" checked="checked" >按销量
					  <input type="radio" id="sellsale">按销售额
				<span style="margin-left: 60px;">排名：前</span>
				<input type="text" id="saleNum" value="10" style="width: 60px;height: 20px;border: 1px solid gray;"/><span>名</span>
			</div>
			<div style="height: 50px; float: right;">
				统计时间段：<input id="startDate" name="startDate" type="text" class="Wdate" onclick="WdatePicker({skin:'whyGreen',maxDate:'#F{$dp.$D(\'endDate\')||\'new Date()\'}',dateFmt:'yyyy-MM-dd HH:mm:ss'})"/> - 
				<input id="endDate" name="endDate" type="text" class="Wdate" onclick="WdatePicker({skin:'whyGreen',minDate:'#F{$dp.$D(\'startDate\')}',dateFmt:'yyyy-MM-dd HH:mm:ss'})"/> 
				<a onclick="tong_sellRaking()" class="easyui-linkbutton" style="background-color: #e2e2e2">统计</a>
			</div>
		</div>
		<div>
			商品分类：
			<select name="categoryOne" onchange="categoryChangeTwo()">
				<option value="">==请选择==</option>
			</select>
			<select name="categoryTwo" onchange="categoryChangeThree()">
				<option value="">==请选择==</option>
			</select>
			<select name="categoryThree">
				<option value="">==请选择==</option>
			</select>
			<span style="margin-left: 20px;">商品品牌：</span>
			<input type="text" name="brand" style="width: 80px;height: 20px;border: 1px solid gray;">
		</div>
		<div style="margin-top: 20px;">
			<table id="sellRakingTable" hidden="true" border="1" cellpadding="0" cellspacing="0" width="1100px" height="150px"></table>
		</div>
		<div align="center" id="x1" style="margin-top: 5px">
			<a id="firstPage" href="javascript:void(0)" style="text-decoration: none; cursor:pointer;">首页</a>   
			<a href="javascript:void(0)" style="text-decoration: none; cursor:pointer;"><span id="lastPage">上一页</span></a>   
			<a href="javascript:void(0)" style="text-decoration: none; cursor:pointer;"><span id="nextPage">下一页</span></a>   
			<a href="javascript:void(0)" style="text-decoration: none; cursor:pointer;"><span id="endPage">尾页</span></a>   
			<input id="inputPage" type="text" style="width: 30px;height: 20px;border: 1px solid gray;"/>  
<!-- 			<button id="goPage">GO</button>   -->
			<a id="goPage" class="easyui-linkbutton" style="background-color: #e2e2e2">GO</a>
			共<span id="countPage"></span>页
		</div>
	</div>
	<div id="barSellRaking1" style="width: 1200px;height: 500px;margin-left: 10px;margin-top: 10px; border: 1px;"></div>
</div>
	<script type="text/javascript" src="js/aiPinXuan/center/commodity/commodity/sellRaking.js"></script>
</body>
</html>