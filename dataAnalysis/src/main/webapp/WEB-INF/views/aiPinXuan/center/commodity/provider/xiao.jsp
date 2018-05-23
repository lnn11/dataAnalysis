<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript" src="js/aiPinXuan/center/commodity/provider/xiaoData.js"></script>
	<script type="text/javascript" src="js/aiPinXuan/center/commodity/provider/xiao.js"></script>
<div>
	<div id="p" class="easyui-panel" title="销量分析" style="width:100%;padding:20px;" data-options="cls:'theme-panel-blue'">
		<div class="div" hidden="true" style="float: right;" id="countTime">
			<span id="countTimeOneFont">统计时段：</span>
			<input id="xiaoStartDate" type="text" style="height:25px;width:140px;" class="Wdate" onclick="WdatePicker({skin:'whyGreen',maxDate:'#F{$dp.$D(\'xiaoEndDate\')||\'new Date()\'}'})"/> - 
			<input id="xiaoEndDate" type="text" style="height:25px;width:140px;" class="Wdate" onclick="WdatePicker({skin:'whyGreen',minDate:'#F{$dp.$D(\'xiaoStartDate\')}',maxDate:'%y-%M-%d 23:59:59'})"/>
			<a onclick="tong()" class="easyui-linkbutton" style="background-color: #e2e2e2">统计</a>
		</div>
		<div class="div" hidden="true">
			<table id="t" hidden="true" class="table" align="center" cellpadding="0" cellspacing="0" width="98%" height="150px"></table>
		</div>
		<div class="div" hidden="true" align="center" id="x1" style="margin-top: 5px">
			<a id="firstPage" href="javascript:void(0)" style="text-decoration: none; cursor:pointer;">首页</a>
			<a href="javascript:void(0)" style="text-decoration: none; cursor:pointer;"><span id="lastPage">上一页</span></a>
			<a href="javascript:void(0)" style="text-decoration: none; cursor:pointer;"><span id="nextPage">下一页</span></a>
			<a href="javascript:void(0)" style="text-decoration: none; cursor:pointer;"><span id="endPage">尾页</span></a>
			<input id="inputPage" type="text" style="width: 30px;height: 20px;border: 1px solid gray;"/> 
<!-- 			<input id="inputPage" class="easyui-textbox" style="width:5%;height:20px"> -->
			<a id="goPage" class="easyui-linkbutton" style="background-color: #e2e2e2">GO</a>
			共<span id="countPage"></span>页
		</div>
		<div class="div saleBar pieMarginTB" hidden="true" id="bar"></div>
		<div class="div saleBar pieMarginTB" hidden="true" id="pie"></div>
	</div>
</div>
</body>
</html>