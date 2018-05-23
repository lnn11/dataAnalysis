$(function(){
	function Appendzero(obj)  
	{  
		if(obj<10) return "0" +""+ obj;  
		else return obj;  
	}
	var time = new Date();
	var month = time.getMonth()+1;
	var day = time.getDate();
	var year = time.getFullYear();
	var hours=time.getHours();
	var minutes=time.getMinutes();
	var seconds=time.getSeconds();
	$('#employeeBillPrev').val(year+'-'+Appendzero(month)+'-'+'0'+1+' 00:00:00');
	$('#employeeBillNext').val(year+'-'+Appendzero(month)+'-'+Appendzero(day)+' 23:59:59');
	$('#employeeWelfareName').text($("[name='welfare']").val());
	$('#time').text(year+'-'+Appendzero(month)+'-'+'0'+1+' 00:00:00'+' 至  '+year+'-'+Appendzero(month)+'-'+Appendzero(day)+' 23:59:59');
});
var exp = null;
/**
 * 列表加载数据
 */
$('#employeeBillTable').datagrid({
    url:'finance/employeeWelfare',
    queryParams: {
    	welfareIndex: $("[name='welfare']").val(),
    	startDate:$('#employeeBillPrev').val(),
    	endDate:$('#employeeBillNext').val(),
    	employeeNmae:''
    },
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
    columns:[[
//		{field:'index',title:'序号',width:38, align: 'center',formatter:function(val,row,index){
//		    var options = $("#employeeBillTable").datagrid('getPager').data("pagination").options;
//		    var currentPage = options.pageNumber;
//		    var pageSize = options.pageSize;
//		    return (pageSize * (currentPage -1))+(index+1);
//		},
//		styler: function (value, row, index) { return 'border-color:#797671;border-width:0px 1px 1px 0px;border-style:solid';}
//		},
        {field:'company',title:'公司名称',sortable:true,align:'center',halign:'center',
//        	 styler: function (value, row, index) { return 'border-color:#797671;border-width:0px 1px 1px 0px;border-style:solid';}
		},
		{field:'employeeName',title:'员工姓名',sortable:true,align:'center',halign:'center',
//			styler: function (value, row, index) { return 'border-color:#797671;border-width:0px 1px 1px 0px;border-style:solid';}
		},
		{field:'employeeNumber',title:'员工编号',sortable:true,align:'center',halign:'center',
//			styler: function (value, row, index) { return 'border-color:#797671;border-width:0px 1px 1px 0px;border-style:solid';}
		},
        {field:'productName',title:'商品名称',sortable:true,align:'center',halign:'center',
//        	styler: function (value, row, index) { return 'border-color:#797671;border-width:0px 1px 1px 0px;border-style:solid';}
		},    
		{field:'normInfo',title:'商品规格',sortable:true,align:'center',halign:'center',
//        	styler: function (value, row, index) { return 'border-color:#797671;border-width:0px 1px 1px 0px;border-style:solid';}
		},    
        {field:'productNum',title:'数量',sortable:true,align:'center',halign:'center',
//        	styler: function (value, row, index) { return 'border-color:#797671;border-width:0px 1px 1px 0px;border-style:solid';}
		},
        {field:'price',title:'实际销售单价（元）',sortable:true,align:'center',halign:'center',
//			styler: function (value, row, index) { return 'border-color:#797671;border-width:0px 1px 1px 0px;border-style:solid';}
		},
        {field:'welfareName',title:'参与员工福利名称',sortable:true,align:'center',halign:'center',
//        	styler: function (value, row, index) { return 'border-color:#797671;border-width:0px 1px 1px 0px;border-style:solid';}
		},
        {field:'sumSpecialPoints',title:'福利券支付积分',sortable:true,align:'center',halign:'center',
//        	styler: function (value, row, index) { return 'border-color:#797671;border-width:0px 1px 1px 0px;border-style:solid';}
		},
        {field:'sumSpecialMoney',title:'福利券支付金额（元）',sortable:true,align:'center',halign:'center',
//        	styler: function (value, row, index) { return 'border-color:#797671;border-width:0px 1px 1px 0px;border-style:solid';}
		},
		{field:'taxRate',title:'税率',sortable:true,align:'center',halign:'center',
			formatter: function (value, row, index) {  
				if(value != exp) {
					return value*100+'%';  
				}
            }  
//        	styler: function (value, row, index) { return 'border-color:#797671;border-width:0px 1px 1px 0px;border-style:solid';}
		},
		{field:'taxTypeCode',title:'税收分类编码',sortable:true,align:'center',halign:'center',
//        	styler: function (value, row, index) { return 'border-color:#797671;border-width:0px 1px 1px 0px;border-style:solid';}
		}
    ]],
    onLoadSuccess:function(data){
    	if(data.total > 0){
    		$('#sumProductNum').text(data.sumProductNum);
    		$('#sumPoints').text(data.sumPoints);
    		$('#sumMoney').text(data.sumMoney);
    	}else{
    		$('#sumProductNum').text(0);
    		$('#sumPoints').text(0);
    		$('#sumMoney').text(0);

    	}
    },
    onBeforeLoad:function(){
//    	$(".panel-body").css({
//            "border-color": "#797671","border-width":"1px 1px 1px 1px","border-style":"solid"
//        });
    	var panel = $(this).datagrid('getPanel');
    	var tr = panel.find('div.datagrid-header tr');
    	tr.each(function(){
            var td = $(this).children('td');
//            td.css({
//                "border-color": "#797671","border-width":"0px 1px 2px 0px","border-style":"solid"
//            });
        });
    }
});

$("#exportWelfareData").click(function(){
	var welfareIndex;
	var value = $("[name='welfare']").val();
	var startDate = $('#employeeBillPrev').val();
	var endDate = $('#employeeBillNext').val();
	var company = $('#company').val();
//	welfareIndex = getWelfareIndex(welfareIndex,value);
	location.href="finance/downWelfareExcel?welfareIndex="+encodeURIComponent(value)+"&startDate="+startDate+"&endDate="+endDate+"&employeeNmae="+encodeURIComponent(company);
});


function getWelfareIndex(welfareIndex,value){
	if(value == '所有专属福利'){
		welfareIndex = 4;
	}else if(value == '中秋专属福利'){
		welfareIndex = 1;
	}else if(value == '春节专属福利'){
		welfareIndex = 2;
	}else if(value == '元宵专属福利'){
		welfareIndex = 3;
	}
	return welfareIndex;
}
$("#searchEmployeeWelfare").click(function(){
	var welfareIndex;
	var value = $("[name='welfare']").val();
	var startDate = $('#employeeBillPrev').val();
	var endDate = $('#employeeBillNext').val();
	var company = $('#company').val();
	$('#employeeWelfareName').text(value);
	$('#time').text(startDate+' 至  '+endDate);
//	welfareIndex = getWelfareIndex(welfareIndex,value);
	welfareIndex = value;
	$('#employeeBillTable').datagrid("load",
		{
			startDate: startDate,
			endDate:endDate,
			welfareIndex:welfareIndex,
			employeeNmae:company
		}
	);
});