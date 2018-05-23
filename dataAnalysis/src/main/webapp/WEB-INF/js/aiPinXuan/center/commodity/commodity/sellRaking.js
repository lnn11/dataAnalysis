var startDate;
var endDate;
var saleNum;
var page = 1;
var page2;
var lastPage;
var productSupp = [];
var productNum = [];
var productSale = []; 
var num = [];
var productSuppPage = [];
var productNumPage = [];
var productSalePage = []; 
var numPage = [];
var productListJson1=[];
var pageSize = 10;

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
	$("#startDate").val(year+'-'+month+'-'+'0'+1+' '+'00:00:00');
	$("#endDate").val(year+'-'+month+'-'+day+' '+'23:59:59');
});

page2 = page;
saleNum = $("#saleNum").val();
startDate = $("#startDate").val();
endDate = $("#endDate").val();
var categoryOne = $("[name='categoryOne']").val();
var categoryTwo = $("[name='categoryTwo']").val();
var categoryThree = $("[name='categoryThree']").val();
var brand = $("[name='brand']").val();
getProductData(startDate,endDate,page,categoryOne,categoryTwo,categoryThree,brand);	
loadProductData();
getCategoryOne();

$("#firstPage").click(function(){
	page = 1;
	$("#inputPage").val(page);
	page2 = page;
	loadProductDataPage(productListJson1,page,pageSize)
	fuzhi();
});

$("#lastPage").click(function(){
	page = page-1;
	if (page < 1 ) {
		page = 1;
		return;
	};
	page2 = page;
	$("#inputPage").val(page);
	loadProductDataPage(productListJson1,page,pageSize)
	fuzhi();
});

$("#nextPage").click(function(){
	page = page+1;
	if (page > lastPage){
		page = lastPage;
		return;
	};
	page2 = page;
	$("#inputPage").val(page);
	loadProductDataPage(productListJson1,page,pageSize)
	fuzhi();
});

$("#endPage").click(function(){
	if (lastPage != 0) page = lastPage;
	page2 = page;
	$("#inputPage").val(page);
	loadProductDataPage(productListJson1,page,pageSize)
	fuzhi();
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
		loadProductDataPage(productListJson1,page,pageSize)
		fuzhi();
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

$("#sellsale").click(function() {
	$("#centerComm").panel({
		href:'aiPinXuan/center/commodity/commodity/sellSaleRanking'
	})
})

function getCategoryOne() {
	var data = "";
	$.ajax({
		url:"product/getCategory",
		data:{data:data},
		dataType:"json",
		type:"post",
		success:function(data) {
			for(var i in data) {
				$("[name='categoryOne']").append("<option value="+data[i].ID+">"+data[i].NAME+"</option>");
			}
		},
		error:function() {alert("登录超时，请重新登录！");}
	})
}

function categoryChangeTwo() {
	var data = $("[name='categoryOne']").val();
	$("[name='categoryTwo']").empty();
	$("[name='categoryThree']").empty();
	$("[name='categoryThree']").append("<option value=''>==请选择==</option>");
	$("[name='categoryTwo']").append("<option value=''>==请选择==</option>");
	if(data != '') {
		$.ajax({
			url:"product/getCategory",
			data:{data:data},
			dataType:"json",
			type:"post",
			success:function(data) {
				for(var i in data) {
					$("[name='categoryTwo']").append("<option value="+data[i].ID+">"+data[i].NAME+"</option>");
				}
			},
			error:function() {alert("登录超时，请重新登录！");}
		})
	}
}
 
function categoryChangeThree() {
	var data = $("[name='categoryTwo']").val();
	$("[name='categoryThree']").empty();
	$("[name='categoryThree']").append("<option value=''>==请选择==</option>");
	if(data != '') {
		$.ajax({
			url:"product/getCategory",
			data:{data:data},
			dataType:"json",
			type:"post",
			success:function(data) {
				for(var i in data) {
					$("[name='categoryThree']").append("<option value="+data[i].ID+">"+data[i].NAME+"</option>");
				}
			},
			error:function() {alert("登录超时，请重新登录！");}
		})
	}
}

function tong_sellRaking(){
	saleNum = $("#saleNum").val();
	startDate =  $("#startDate").val();
	endDate = $("#endDate").val();
	page = 1;
	$("#inputPage").val(page);
	categoryOne = $("[name='categoryOne']").val();
	categoryTwo = $("[name='categoryTwo']").val();
	categoryThree = $("[name='categoryThree']").val();
	brand = $("[name='brand']").val();
	getProductData(startDate,endDate,page,categoryOne,categoryTwo,categoryThree,brand);
	loadProductData();
}

function  getProductData(startDate,endDate,page,categoryOne,categoryTwo,categoryThree,brand){
	arrayList = [];
	arrayList =getProduct(startDate,endDate,page,categoryOne,categoryTwo,categoryThree,brand);
}

function getProduct(startDate,endDate,page,categoryOne,categoryTwo,categoryThree,brand){
	var list = [];
	if(page == null){
		page = 1;
	}
	$.ajax({
		type:"post",
		url:'product/productTopRank',
		data:{"startDate":startDate,"endDate":endDate,"saleNum":saleNum,"currentPage":page,"pageSize":pageSize,
			"categoryOne":categoryOne,"categoryTwo":categoryTwo,"categoryThree":categoryThree,"brand":brand},
		dataType:"json",
		async:false,
		success:function(productData){
			if(productData != null){
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

function loadProductDataPage(productListJson1,page,pageSize) {
	productSuppPage = [];
	productNumPage = [];
	productSalePage = []; 
	numPage = [];
	if(page == null){
		page = 1;
	}
	$.ajax({
		type:"post",
		url:'product/productTopRankByPage',
		data:{productListJson:productListJson1,"currentPage":page,"pageSize":pageSize},
		dataType:"json",
		async:false,
		success:function(productData){
			if(productData != null){
				for ( var key in productData) {
					productSuppPage.push(productData[key].NAME);
					productNumPage.push(productData[key].SALE_NUM);
					productSalePage.push(productData[key].SALE_VOLUME);
					numPage.push(productData[key].num);
				}
				$("#inputPage").val(page);
			} else {
				productSuppPage = ['暂无数据'];
				productNumPage = ['暂无数据'];
				productSalePage = ['暂无数据'];
				numPage = ['暂无数据'];
			}
		},
		error:function(){
			alert("登录超时，请重新登录！");
		}
	});
}

function loadProductData(){
	productSupp = [];
	productNum = [];
	productSale = []; 
	num = [];
	productSuppPage = [];
	productNumPage = [];
	productSalePage = []; 
	productListJson1=[];
	numPage = [];
	if (arrayList == 0) {
		productSupp = ['暂无数据'];
		productNum = ['暂无数据'];
		productSale = ['暂无数据'];
		num = ['暂无数据'];
		productSuppPage = ['暂无数据'];
		productNumPage = ['暂无数据'];
		productSalePage = ['暂无数据'];
		numPage = ['暂无数据'];
		$("#countPage").text(1);
		$("#inputPage").val(page);
		lastPage = 1;
	} else {
		var productSaleTopRank = eval(arrayList.productSaleTopRank);
		var productList = productSaleTopRank["productList"];
		var productListByPage = productSaleTopRank["productListByPage"];
		productListJson1 = productSaleTopRank["productListJson"];
		for ( var key in productList) {
			productSupp.push(productList[key].NAME);
			productNum.push(productList[key].SALE_NUM);
			productSale.push(productList[key].SALE_VOLUME);
			num.push(productList[key].num);
		}
		for ( var key in productListByPage) {
			productSuppPage.push(productListByPage[key].NAME);
			productNumPage.push(productListByPage[key].SALE_NUM);
			productSalePage.push(productListByPage[key].SALE_VOLUME);
			numPage.push(productListByPage[key].num);
		}
		$("#inputPage").val(page);
		if(arrayList.totalPage>productSaleTopRank["size"]) {
			lastPage = productSaleTopRank["size"];
		}else{
			lastPage = arrayList.totalPage;
		}
		$("#countPage").text(lastPage);
	}
	fuzhi();
}

function fuzhi() {
	$("#sellRakingTable").empty("");
	$("#sellRakingTable").show();
	$("#sellRakingTable").append("<tr id='sellRaking1' align='center'><th style='width:150px;height:40px;'><div id='sd'><b id='sa'>商品名称</b><em id='se'>销量/销售额</em></div></th></tr><tr id='sellRakingNum' align='center'><td>销量排名</td></tr><tr id='sellRaking2' align='center'><td>销量(件)</td></tr><tr id='sellRaking3' align='center'><td>销售额(元)</td></tr>");
	for(var i=0;i<productNumPage.length ;i++){
		$("#sellRaking1").append("<td id='color'>"+productSuppPage[i]+"</td>");
		$("#sellRakingNum").append("<td>"+numPage[i]+"</td>");
		$("#sellRaking2").append("<td>"+productNumPage[i]+"</td>");
		$("#sellRaking3").append("<td>"+productSalePage[i]+"</td>");
	}
	
	//柱状图赋值
	barSellRaking1(productNumPage,productSuppPage);
}

function barSellRaking1(productNum,productSupp) {
	var barChart1 = echarts.init(document.getElementById('barSellRaking1'));
	var barOption = {
		    title: {
		        text: $("#startDate").val()+'至'+$("#endDate").val()+'销量前'+saleNum+'排名',
		        x:'center'
		    },
		    tooltip : {
		        trigger: 'axis',
		    },
		    xAxis : [
		        {
		            type : 'category',
		            data : productSupp,
		            axisLabel:{
                        interval:0,
	                      rotate:45,
	                      margin:2,
	                      textStyle:{
	                          color:"#222"
	                      }
	                  },
		        }
		    ],
		    grid: { // 控制图的大小，调整下面这些值就可以，
	             x: 40,
	             x2: 100,
	             y2: 150,// y2可以控制 X轴跟Zoom控件之间的间隔，避免以为倾斜后造成 label重叠到zoom上
	         },
		    yAxis : [
		        {
		            type : 'value',
		            axisLabel:{
                        interval:0,
	                      margin:2,
	                      textStyle:{
	                          color:"#222"
	                      }
	                  },
		        }
		    ],
		    series : [
				{
		            type:'bar',
		            barWidth: 40,
		            data:productNum
		        }
		    ]
		};
	// 为echarts对象加载数据 
	barChart1.setOption(barOption); 
}