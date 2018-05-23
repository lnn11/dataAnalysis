var propDate;
var array1 = [];
var array2 = [];
var page = 1;
var page2;
var lastPage;

var time="";
var month="";
var day="";
var year="";
$(function(){
	function Appendzero(obj)  
	{  
		if(obj<10) return "0" +""+ obj;  
		else return obj;  
	}
	time = new Date();
	month = Appendzero(time.getMonth()+1);
	day = Appendzero(time.getDate());
	year = time.getFullYear();
	$("#propDate").val(year+'-'+month+'-'+day+' '+'23:59:59');
});

page2 = page;
propDate = $("#propDate").val();
$("#propTimingDate").text(propDate);
$("#propShortName").text($("#propSelect").val());
$("#propShortName").text($("#propSelect option:selected").text());

getProductDate(propDate,page);
loadProductDataPic();
getSupplier();

$("#firstPage").click(function(){
	page = 1;
	$("#inputPage").val(page);
	page2 = page;
	getProductDate(propDate,page);
	loadProductDataPic();
});

$("#lastPage").click(function(){
	page = page-1;
	if (page < 1 ) {
		page = 1;
		return;
	};
	page2 = page;
	$("#inputPage").val(page);
	getProductDate(propDate,page);
	loadProductDataPic();
});

$("#nextPage").click(function(){
	page = page+1;
	if (page > lastPage){
		page = lastPage;
		return;
	};
	page2 = page;
	$("#inputPage").val(page);
	getProductDate(propDate,page);
	loadProductDataPic();
});

$("#endPage").click(function(){
	if (lastPage != 0) page = lastPage;
	page2 = page;
	$("#inputPage").val(page);
	getProductDate(propDate,page);
	loadProductDataPic();
});

$("#goPage").click(function(){
	page = $("#inputPage").val();
	if(!isNaN(page)){
		page2 = page;
		if (page > lastPage) {
			page = lastPage;
		};
		if (page < 1){
			page = 1;
		};
		getProductDate(propDate,page);
		loadProductDataPic();
	}else{
		alert("请正确输入数字格式！");
		page = page2;
		$("#inputPage").val(page);
	}
});

$(":radio").click(function(){
	if($(this).attr("checked")!=undefined)
	{
		$(this).siblings().attr("checked",false);
		$(this).attr("checked",true);
	}
});

$("#propTimeQu").click(function() {
	$("#centerComm").panel({
		href:'aiPinXuan/center/commodity/commodity/propSKU'
	})
});
function getSupplier() {
	$.ajax({
		url:"product/getSupplier",
		type:"post",
		dataType:"json",
		async:false,
		success:function(data) {
			$(data).each(function(i,e) {
				$("#propSelect").append("<option value="+e.SHORT_NAME+">"+e.SHORT_NAME+"</option>");
			});
		}
	})
}

function tong_propTimingSKU(){
	propDate = $("#propDate").val();
	page = 1;
	$("#propTimingDate").text(propDate);
	$("#propShortName").text($("#propSelect option:selected").text());
	getProductDate(propDate,page);
	loadProductDataPic()
}

function getProductDate(propDate,page){
	arrayList = [];
	arrayList = toGetProduct(propDate,page);
};
function toGetProduct(propDate,page){
	var list = [];
	var pageSize = 10;
	if(page == null){
		page = 1;
	}
	if(propDate==null||propDate=="") {
		$("#propDate").val(year+'-'+month+'-'+day+' '+'23:59:59');
		propDate = $("#propDate").val();
	}
	$.ajax({
		type:"post",
		url:'product/getProductTimingProportion',
		data:{"propDate":propDate,"currentPage":page,"pageSize":pageSize,"shortName":$("#propSelect").val()},
		dataType:"json",
		async:false,
		success:function(productData){
			if(null != productData){
				list = productData;
			} else {
				list = 0
			};
		},
		error:function(){
			alert("登录超时，请重新登录！");
		}
	});
	return list;
}

function loadProductDataPic(){
	var suppName = [];
	var numProp = [];
	var saleProp = [];
	var pname = [];
	var tpTotalNum = [];
	var tpdTotalNum = [];
	var titleNum = [];
	var tname = [];
	array1 = [];
	array2 = [];
	
	if (arrayList == 0) {
		suppName=['暂无数据'];
		numProp=['暂无数据'];
		saleProp=['暂无数据'];
		pname=['暂无数据'];
		tpTotalNum=['暂无数据'];
		tpdTotalNum=['暂无数据'];
		$("#inputPage").val(page);
		lastPage = 1;
		$("#countPage").text(1)
		var map = {};
		map.name = '暂无数据';
		map.value = 0;
		array1[0] = map;
		array2[0] = map;
	} else{
		
		var productCateList = eval(arrayList.productCateList);
		for(var i =0;i < productCateList.length;i++){
			
			var data = productCateList[i];
			//表头标题
			var dataList = data.list;
			var title = {};
			//封装表头标题数组
			title.suppName=data.tname;
			title.cow=dataList.length;
			titleNum.push(title);
			suppName=title.suppName;
			//封装子列表数组
			for(var key in dataList) {
				pname.push(dataList[key].PNAME);
				tpTotalNum.push(dataList[key].TPTOTALNUM);
				tpdTotalNum.push(dataList[key].TPDTOTALNUM);
			}
		}
		
		var ProductProportion = eval(arrayList.ProductProportion);
		
		if(ProductProportion!=null&&ProductProportion!="") {
			for(var key in ProductProportion) {
				numProp.push(ProductProportion[key].productNumProp+'%');
				saleProp.push(ProductProportion[key].productSaleProp+'%');
				var map = {};
				map.name = ProductProportion[key].NAME;
				map.value= ProductProportion[key].productNumProp;
				array1[key] = map;
				var map2 = {};
				map2.name = ProductProportion[key].NAME;
				map2.value= ProductProportion[key].productSaleProp;
				array2[key] = map2;
			}
		}else{
			for(var i=0;i<title.suppName.length;i++) {
				numProp=[0,0,0,0,0,0,0,0,0,0];
				saleProp=[0,0,0,0,0,0,0,0,0,0];
			}
		}
		
		$.each(arrayList,function(keys,values){ 
			$("#inputPage").val(page);
			lastPage = arrayList.totalPage;
			$("#countPage").text(lastPage);
		}); 
	}
	$("#propSKUTable").empty("");
	$("#propSKUTable").show();
	$("#propSKUTable").append("<tr id='propSku1' align='center'><th rowspan='2' style='width:150px;height:40px;'><div id='sd'><b id='sa'>品类</b><em id='se'>销量/销售额</em></div></th></tr>"+
			"<tr id='propSku' align='center'></tr>"+
			"<tr id='propSku5' align='center'><td>SPU总数</td></tr>"+
			"<tr id='propSku6' align='center'><td>SKU总数</td></tr>"+
			"<tr id='propSku2' align='center'><td>各品类销量占比</td></tr>"+
			"<tr id='propSku3' align='center'><td>各品类销售额占比</td></tr>");
	var num = 0;
	if(titleNum.length==0) {
		$("#propSku1").append("<td id='color'>"+suppName+"</td>");
		$("#propSku2").append("<td>"+numProp+"</td>");
		$("#propSku3").append("<td>"+saleProp+"</td>");
		$("#propSku5").append("<td>"+tpTotalNum+"</td>");
		$("#propSku6").append("<td>"+tpdTotalNum+"</td>");
	}else{
		for(var i=0;i < titleNum.length;i++){
			var title = titleNum[i];
			num = num + title.cow;
			$("#propSku1").append("<td id='color' colspan="+title.cow+" >"+title.suppName+"</td>");
			$("#propSku2").append("<td colspan="+title.cow+">"+numProp[i]+"</td>");
			$("#propSku3").append("<td colspan="+title.cow+">"+saleProp[i]+"</td>");
		}
		for(var i=0;i<num;i++){
			$("#propSku").append("<td id='color'>"+pname[i]+"</td>");
			$("#propSku5").append("<td>"+tpTotalNum[i]+"</td>");
			$("#propSku6").append("<td>"+tpdTotalNum[i]+"</td>");
		}
	}
	piePropSku1(array1);
	piePropSku2(array2);
}

function piePropSku1(array1) {
	var pieChart = echarts.init(document.getElementById('piePropSku1'));
	var pieOption={
		title : {
	        text: $("#propDate").val()+'各品类销量占比',
	        x:'center'
	    },
	    tooltip : {
	        trigger: 'item',
	        formatter: "{a} <br/>{b} : {c} ({d}%)"
	    },
	    series : [
	        {
	            type: 'pie',
	            radius : '55%',
	            center: ['50%', '60%'],
	            data:array1,
	            itemStyle: {
	                emphasis: {
	                    shadowBlur: 10,
	                    shadowOffsetX: 0,
	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
	                }
	            }
	        }
	    ]
	 }
	 pieChart.setOption(pieOption); 
}

function piePropSku2(array2){
	var pieChart = echarts.init(document.getElementById('piePropSku2'));
	var pieOption={
		title : {
	        text: $("#propDate").val()+'各品类销售额占比',
	        x:'center'
	    },
	    tooltip : {
	        trigger: 'item',
	        formatter: "{a} <br/>{b} : {c} ({d}%)"
	    },
	    series : [
	        {
	            type: 'pie',
	            radius : '55%',
	            center: ['50%', '60%'],
	            data:array2,
	            itemStyle: {
	                emphasis: {
	                    shadowBlur: 10,
	                    shadowOffsetX: 0,
	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
	                }
	            }
	        }
	    ]
	 }
	 pieChart.setOption(pieOption);
}
