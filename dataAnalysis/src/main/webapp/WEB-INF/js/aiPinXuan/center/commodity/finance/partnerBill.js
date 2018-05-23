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
	$('#partnerBillPrev').val(year+'-'+Appendzero(month)+'-'+'0'+1+' '+'00:00:00');
	$('#partnerBillNext').val(year+'-'+Appendzero(month)+'-'+Appendzero(day)+' 23:59:59');
	$('#countTime').text(year+'-'+Appendzero(month)+'-'+'0'+1+' '+'00:00:00'+' 至  '+year+'-'+Appendzero(month)+'-'+Appendzero(day)+' 23:59:59');
});
/**
 * 列表加载数据
 */
$('#partnerBillTable').datagrid({
    url:'finance/getCustomerService',
    queryParams: {
    	startTime:$("#partnerBillPrev").val(),
    	endTime:$("#partnerBillNext").val(),
    	company:''
    },
    fitColumns:true,
    rownumbers:false,
    singleSelect:true,
    method: 'post',
	loadMsg:'正在加载,请稍等...',
    pagination:true,
    pageSize:100,
    pageList:[10,15,20,30,40,50,60,70,80,90,100],
    nowrap:false,
    remoteSort:false,
    columns:[[
      {field:'index',title:'序号',width:38, align: 'center',formatter:function(val,row,index){
            	     var options = $("#partnerBillTable").datagrid('getPager').data("pagination").options;
            	     var currentPage = options.pageNumber;
            	     var pageSize = options.pageSize;
            	     return (pageSize * (currentPage -1))+(index+1);
        },
        styler: function (value, row, index) { return 'border-color:#797671;border-width:0px 1px 1px 0px;border-style:solid';}},
        {field:'companyName',title:'公司名称',width:100,sortable:true,align:'center',halign:'center',
        	formatter:function(value,row,index){
        		if(value == 'XH_DJR'){
        			return '大金融';
        		}else if(value == 'XH_JX'){
        			return '金信网';
        		}else if(value == 'XH_JK'){
        			return '信和汇金';
        		}else if(value == 'XH_CF'){
        			return '信和财富';
        		}
        	},
        	styler: function (value, row, index) { return 'border-color:#797671;border-width:0px 1px 1px 0px;border-style:solid';}
        },    
        {field:'goodsName',title:'商品名称',width:100,sortable:true,align:'center',halign:'center',
        	styler: function (value, row, index) { return 'border-color:#797671;border-width:0px 1px 1px 0px;border-style:solid';}
        },    
        {field:'num',title:'数量',width:100,sortable:true,align:'center',halign:'center',
        	styler: function (value, row, index) { return 'border-color:#797671;border-width:0px 1px 1px 0px;border-style:solid';}},
        {field:'actualSellPrice',title:'实际销售价（元）',width:100,sortable:true,align:'center',halign:'center',
        	styler: function (value, row, index) { return 'border-color:#797671;border-width:0px 1px 1px 0px;border-style:solid';}
        },
        {field:'actualPayPoints',title:'实际支付总积分',width:100,sortable:true,align:'center',halign:'center',
        	styler: function (value, row, index) { return 'border-color:#797671;border-width:0px 1px 1px 0px;border-style:solid';}
        },
        {field:'actualPayMoney',title:'实际支付总积分对应总金额（元）',width:110,sortable:true,align:'center',halign:'center',
        	styler: function (value, row, index) { return 'border-color:#797671;border-width:0px 1px 1px 0px;border-style:solid';}
        }
    ]],
    onLoadSuccess:function(data){
    	if(data.total > 0){
    		$('#productNum').text(data.sumNum);
    		$('#sumPayPoint').text(data.sumSellPoints);
    		$('#sumPayMoney').text(data.sumSellMoney);
    	}else{
    		$('#productNum').text(0);
    		$('#sumPayPoint').text(0);
    		$('#sumPayMoney').text(0);

    	}
    },
    onBeforeLoad:function(){
    	$(".panel-body").css({
            "border-color": "#797671","border-width":"1px 1px 1px 1px","border-style":"solid"
        });
    	var panel = $(this).datagrid('getPanel');
    	var tr = panel.find('div.datagrid-header tr');
    	tr.each(function(){
            var td = $(this).children('td');
            td.css({
                "border-color": "#797671","border-width":"0px 1px 2px 0px","border-style":"solid"
            });
        });
    }
});
$("#searchCustomerService").click(function(){
	var startTime = $("#partnerBillPrev").val();
	var endTime = $("#partnerBillNext").val();
	var company = $("#companyName").val();
	$('#countTime').text(startTime + '至' + endTime);
	$('#partnerBillTable').datagrid("load",
			{
				startTime: startTime,
				endTime:endTime,
				company:company
			}
	);
});
$('#exportCustomerServiceExcel').click(function(){
	var startTime = $("#partnerBillPrev").val();
	var endTime = $("#partnerBillNext").val();
	var company = $("#companyName").val();
	location.href=decodeURI("finance/downCustomerServiceExcel?startTime="+startTime+"&endTime="+endTime+"&company="+company);
})