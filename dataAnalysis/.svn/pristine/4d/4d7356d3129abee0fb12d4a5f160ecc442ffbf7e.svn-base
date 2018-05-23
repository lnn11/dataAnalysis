<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript" src="js/aiPinXuan/center/commodity/provider/speedData.js"></script>
	<script type="text/javascript" src="js/aiPinXuan/center/commodity/provider/speed.js"></script>
<div>
	<div id="p" class="easyui-panel" title="发货速度分析" style="width:100%;padding:20px;" data-options="cls:'theme-panel-blue'">
		<div class="div" hidden="true" align="right" id="countTime">
			<span id="countTimeOneFont">统计时段：</span>
			<input id="speedStartDate" type="text" class="Wdate" onclick="WdatePicker({skin:'whyGreen',maxDate:'#F{$dp.$D(\'speedEndDate\')||\'new Date()\'}'})" style="height:25px;width:140px;"/> - <input id="speedEndDate" type="text" class="Wdate" onclick="WdatePicker({skin:'whyGreen',minDate:'#F{$dp.$D(\'speedStartDate\')}',maxDate:'%y-%M-%d 23:59:59'})" style="height:25px;width:140px;"/>
			<a onclick="tongSpeed()" class="easyui-linkbutton" style="background-color: #e2e2e2">统计</a>
		</div>
		<div class="div" hidden="true">
			<table id="speedTable" class="table" hidden="true" align="center" cellpadding="0" cellspacing="0" width="98%" height="300px" style="table-layout:fixed;">
			</table>
		</div>
		<div class="div" hidden="true" align="center" id="x1" style="margin-top: 5px;margin-bottom: 10px;">
			<a id="firstPage" href="javascript:void(0)" style="text-decoration: none; cursor:pointer;">首页</a>   
			<a href="javascript:void(0)" style="text-decoration: none; cursor:pointer;"><span id="lastPage">上一页</span></a>   
			<a href="javascript:void(0)" style="text-decoration: none; cursor:pointer;"><span id="nextPage">下一页</span></a>   
			<a href="javascript:void(0)" style="text-decoration: none; cursor:pointer;"><span id="endPage">尾页</span></a>   
			<input id="inputPage" type="text" style="width: 30px;height: 20px;border: 1px solid gray;"/>  
			<a id="goPage" class="easyui-linkbutton" style="background-color: #e2e2e2">GO</a> 
			共<span id="countPage"></span>页
		</div>
		<div class="div barCss" hidden="true" id="barSpeed"></div>
		<div class="div" hidden="true" style="width: 1700px; height: 600px">
				<div id="pieSpeed1" class="pieLeft pieMarginTB"></div>
				<div id="pieSpeed2" class="pieRight pieMarginTB"></div>
		</div>
		<div class="div" hidden="true" style="width: 1700px; height: 600px;margin-top: 10px" >
			<div id="pieSpeed3" class="pieLeft pieMarginTB"></div>
			<div id="pieSpeed4" class="pieRight pieMarginTB"></div>
		</div>
	</div>
</div>
</body>
</html>