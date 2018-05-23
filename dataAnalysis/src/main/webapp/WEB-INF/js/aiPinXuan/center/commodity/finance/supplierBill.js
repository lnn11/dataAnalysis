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
	$("#supplierBillPrev").val(year+'-'+month+'-'+'0'+1+' '+'00:00:00');
	$("#supplierBillNext").val(year+'-'+month+'-'+day+' '+'23:59:59');
	//$("input[type='checkbox']").attr('checked',false);//false
});


//aj();

/**
 * 列表加载数据
 */
$('#supplierBillTable').datagrid({
    url:'finance/getSupplierBillByPage',
    fitColumns:true,
    rownumbers:true,
    singleSelect:true,
    method: 'post',
	loadMsg:'正在加载,请稍等...',
    pagination:true,
    pageSize:15,
    pageList:[10,15,20,30,40,50,60,70,80,90,100],
    nowrap:false,
    remoteSort:false,
    queryParams:{
    	supplierBillPrev:$("#supplierBillPrev").val(),
    	supplierBillNext:$("#supplierBillNext").val(),
    	shortName:$("#shortName").val(),
    	activity:$("#activity").val(),
    	data:$("#data").val(),
		isPlk:$("input[type='checkbox']").is(':checked')
    	},
    columns:[[
//		{field:'index',title:'序号',width:38, align: 'center',formatter:function(val,row,index){
//		    var options = $("#supplierBillTable").datagrid('getPager').data("pagination").options;
//		    var currentPage = options.pageNumber;
//		    var pageSize = options.pageSize;
//		    return (pageSize * (currentPage -1))+(index+1);
//		}},
        {field:'shortName',title:'供应商简称',width:100,sortable:true,align:'center',halign:'center'},    
        {field:'name',title:'商品名称',width:100,sortable:true,align:'center',halign:'center'},    
        {field:'activity',title:'商品分类',width:100,sortable:true,align:'center',halign:'center'},
        {field:'num',title:'数量',width:100,sortable:true,align:'center',halign:'center'},
        {field:'price',title:'实际供货价（元）',width:100,sortable:true,align:'center',halign:'center'},
        {field:'money',title:'供货金额（元）',width:100,sortable:true,align:'center',halign:'center'}
    ]],
    onLoadSuccess:function(date){
    	if(date.total > 0){
    		$("#sumNum").text(date.sumNum);
			$("#activitySumNum").text(date.activitySumNum);
			$("#unActivitySumNum").text(date.unActivitySumNum);
			$("#sumMoney").text(date.sumMoney);
			$("#activitySumMoney").text(date.activitySumMoney);
			$("#unActivitySumMoney").text(date.unActivitySumMoney);
    	}else{
    		$("#sumNum").text(0);
			$("#activitySumNum").text(0);
			$("#unActivitySumNum").text(0);
			$("#sumMoney").text(0);
			$("#activitySumMoney").text(0);
			$("#unActivitySumMoney").text(0);

    	}
    }
});

$("#supplierBillFind").click(function() {
	//alert($("#payBox").prop('checked'));
	var isLpk=$("input[type='checkbox']").is(':checked');
	var supplierBillPrev=$("#supplierBillPrev").val();
	var supplierBillNext=$("#supplierBillNext").val();
	$("#prevSupplierBill").text($("#supplierBillPrev").val());
	$("#nextSupplierBill").text($("#supplierBillNext").val());
	$("#supplierBillTable").datagrid("load",{
		supplierBillPrev:supplierBillPrev,
    	supplierBillNext:supplierBillNext,
    	shortName:$("#shortName").val(),
    	activity:$("#activity").val(),
    	data:$("#data").val(),
		payBox:$("#payBox").prop('checked')
	});
	//alert($("#payBox").prop('checked'));
//	aj();
});

$("#expotSupplierBill").click(function() {
	location.href="finance/exportSupplierBill?supplierBillPrev="+$("#supplierBillPrev").val()+"&supplierBillNext="+$("#supplierBillNext").val()+"&shortName="+encodeURI(encodeURI($("#shortName").val()))+"&activity="+encodeURI(encodeURI($("#activity").val())+"&data="+$("#data").val()+"&payBox="+$("#payBox").prop('checked'));
})

function aj(){
	var supplierBillPrev=$("#supplierBillPrev").val();
	var supplierBillNext=$("#supplierBillNext").val();
	var isLpk=$("input[type='checkbox']").is(':checked');
	$.ajax({
		url:'finance/getSupplierBill',
		data:{supplierBillPrev:supplierBillPrev,
	    	supplierBillNext:supplierBillNext,
	    	shortName:$("#shortName").val(),
	    	activity:$("#activity").val(),
	    	data:$("#data").val(),
			isLpk:isLpk},
		dataType:"json",
		type:"post",
		async:false,
		success:function(date) {
			$("#sumNum").text(date.sumNum);
			$("#activitySumNum").text(date.activitySumNum);
			$("#unActivitySumNum").text(date.unActivitySumNum);
			$("#sumMoney").text(date.sumMoney);
			$("#activitySumMoney").text(date.activitySumMoney);
			$("#unActivitySumMoney").text(date.unActivitySumMoney);
		}
	});
};





