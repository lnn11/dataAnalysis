var param;
$.fn.serializeObject=function(){ 
  var obj=new Object(); 
  $.each(this.serializeArray(),function(index,param){ 
    if(!(param.name in obj)){ 
      obj[param.name]=param.value; 
    } 
  }); 
  return obj; 
}; 


key();
document.getElementById("cv").oncontextmenu = function(e){
	 return false;
}
$(function(){
	
	
	inti();
	
	function Appendzero(obj)  
	{  
		if(obj<10) return "0" +""+ obj;  
		else return obj;  
	}
	var exp = null;
	var time = new Date();
	var month = time.getMonth()+1;
	var day = time.getDate();
	var year = time.getFullYear();
	var hours=time.getHours();
	var minutes=time.getMinutes();
	var seconds=time.getSeconds();
	$('#startDate').val(year+'-'+Appendzero(month)+'-'+'0'+1+' 00:00:00');
	$('#endDate').val(year+'-'+Appendzero(month)+'-'+Appendzero(day)+' 23:59:59');

	param = $('#form').serializeObject();
	
	/**
	 * 列表加载数据
	 */
	$('#payplatforBill').datagrid({
	    url:'finance/getPayPlatform',
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
	    queryParams: param,
	    columns:[[
//			{field:'index',title:'序号',width:38, align: 'center',formatter:function(val,row,index){
//			    var options = $("#supplierBillTable").datagrid('getPager').data("pagination").options;
//			    var currentPage = options.pageNumber;
//			    var pageSize = options.pageSize;
//			    return (pageSize * (currentPage -1))+(index+1);
//			}},
	        {field:'createTime',title:'日期',width:200,sortable:true,align:'center',halign:'center'},    
	        {field:'orderMain',title:'主订单号',sortable:true,align:'center',halign:'center'},    
	        {field:'payID',title:'支付平台流水号',sortable:true,align:'center',halign:'center'},
	        {field:'channel',title:'渠   道',sortable:true,align:'center',halign:'center',
	        	formatter:function(value,row,index){
	        		if(value == 1 || value == 2 || value == 4 ) {
	        			return "爱品选";
	        		}else if(value== 'app' || value == 'h5' || value == 'WX') {
	        			return "爱品选";
	        		}else if(value == 3) {
	        			return "微匠";
	        		}else {
	        			return value;
	        		}
	        	}
	        },
	        {field:'paySourse',title:'&nbsp;&nbsp;&nbsp;&nbsp;支  付  方  式&nbsp;&nbsp;&nbsp;&nbsp;',sortable:true,align:'center',halign:'center',
	        	formatter:function(value,row,index){
	        		if(value == 1) {
	        			return "微信支付(普通)";
	        		}else if(value == 3) {
	        			return "微信支付(公众号)";
	        		}else if(value == 4) {
	        			return "支付宝支付";
	        		}else if(value == 6) {
	        			return "微信支付(H5)";
	        		}
	        	}
	        },
	        {field:'payCash1',title:'支付金额（元）',sortable:true,align:'center',halign:'center'},
	        {field:'returnCash1',title:'退款金额（元）',sortable:true,align:'center',halign:'center',
	        	formatter:function(value,row,index){
	        		if(value != 0) {
						return "-"+value;  
					}else{
						return value;
					}
	        	}
	        },
	        {field:'serviceCash1',title:'手续费金额（元）<img id="imgs" src="js/EasyUI-1.5.1-InsdepTheme-1.0.4/themes/insdep/images/icons_help.png">',sortable:true,align:'center',halign:'center',
	        	formatter:function(value,row,index){
	        		if(value != 0) {
						return "-"+value;  
					}else{
						return value;
					}
	        	}
	        },
	        {field:'cash1',title:'实际收入金额（元）<img id="imgs1" src="js/EasyUI-1.5.1-InsdepTheme-1.0.4/themes/insdep/images/icons_help.png">',sortable:true,align:'center',halign:'center'},
	        {field:'rate1',title:'费率 <img id="imgs2" src="js/EasyUI-1.5.1-InsdepTheme-1.0.4/themes/insdep/images/icons_help.png">',sortable:true,align:'center',halign:'center',
	        	formatter:function(value,row,index){
	        		if(value != exp) {
						return value+'%';  
					}
	        	}
	        }
	    ]],
	    onLoadSuccess:function(data){
			$('#income').text(data.income); $('#incomeAlipay').text(data.incomeAlipay); $('#incomeCommon').text(data.incomeCommon); $('#incomePublic').text(data.incomePublic); $('#incomeH5').text(data.incomeH5);
			$('#payCash').text(data.payCash);$('#payCashAlipay').text(data.payCashAlipay);$('#payCashCommon').text(data.payCashCommon);$('#payCashPublic').text(data.payCashPublic);$('#payCashH5').text(data.payCashH5);
			$('#realIncome').text(data.realIncome); $('#realIncomeAlipay').text(data.realIncomeAlipay); $('#realIncomeCommon').text(data.realIncomeCommon); $('#realIncomePublic').text(data.realIncomePublic); $('#realIncomeH5').text(data.realIncomeH5);
			$('#serviceIncome').text(data.serviceIncome); $('#serviceAlipay').text(data.serviceAlipay); $('#serviceIncomeCommon').text(data.serviceIncomeCommon); $('#serviceIncomePublic').text(data.serviceIncomePublic); $('#serviceIncomeH5').text(data.serviceIncomeH5);
			$('#servicePay').text(data.servicePay);$('#servicePayAlipay').text(data.servicePayAlipay);$('#servicePayCommon').text(data.servicePayCommon);$('#servicePayPublic').text(data.servicePayPublic);$('#servicePayH5').text(data.servicePayH5);
			$('#realServicePay').text(data.realServicePay);$('#realServicePayAlipay').text(data.realServicePayAlipay);$('#realServicePayCommon').text(data.realServicePayCommon);$('#realServicePayPublic').text(data.realServicePayPublic);$('#realServicePayH5').text(data.realServicePayH5);
	    },
	    onHeaderContextMenu:function(e, field) {
	    	if(field == "serviceCash1") {
	    		$.messager.alert('说明','总金额对应各个平台名称说明。 “微信”平台名称为：总金额 ,  “支付宝”平台名称为：收入');
	    	}else if(field == "cash1") {
	    		$.messager.alert('说明','总金额对应各个平台名称说明。“微信”平台名称为：总金额 ,   “支付宝”平台名称为：收入');
	    	}else if(field == "rate1") {
	    		$.messager.alert('说明','费率对应各个平台名称说明。“微信”平台名称为：费率  ,  “支付宝”平台名称为：无');
	    	}
	    }
	});
});
function quert(){
	var boo = true;
	var payCashStart = $("#payCashStart").val();
	var payCashEnd = $("#payCashsEnd").val();
	var cashStart = $("[name='cashStart']").val();
	var cashEnd = $("[name='cashEnd']").val();
	var returnCashStart = $("[name='returnCashStart']").val();
	var returnCashEnd = $("[name='returnCashEnd']").val();
	var serviceCashStart = $("[name='serviceCashStart']").val();
	var serviceCashEnd = $("[name='serviceCashEnd']").val();
	
	if(parseInt(payCashStart)> parseInt(payCashEnd)) {
		$.messager.alert('Warning','金额筛选输入数值错误，无法完成筛选，请重新输入');
		boo = false;
	}
	if(parseInt(cashStart)> parseInt(cashEnd)) {
		$.messager.alert('Warning','金额筛选输入数值错误，无法完成筛选，请重新输入');
		boo = false;
	}
	if(parseInt(returnCashStart)> parseInt(returnCashEnd)) {
		$.messager.alert('Warning','金额筛选输入数值错误，无法完成筛选，请重新输入');
		boo = false;
	}
	if(parseInt(serviceCashStart)> parseInt(serviceCashEnd)) {
		$.messager.alert('Warning','金额筛选输入数值错误，无法完成筛选，请重新输入');
		boo = false;
	}
	return boo;
}

function payPlatFormExport() {
	var boo = quert();
	if(boo==true) {
		var a = $("#form").serialize();
		location.href="finance/downPayPlatFormExport?pay="+$("#form").serialize();
	}
}

function payPlatformfind(){
	var boo = quert();
	if(boo==true) {
		param = $('#form').serializeObject();
		$('#payplatforBill').datagrid("load",param);
	}
}
function inti() {
	var div=document.getElementById("incom");
	div.onmouseover=function(){
		$("#inco").show();
	};
	div.onmouseout=function(){
		$("#inco").hide();
	};
	var div1=document.getElementById("payCs");
	div1.onmouseover=function(){
		$("#payCa").show();
	};
	div1.onmouseout=function(){
		$("#payCa").hide();
	};
	var div2=document.getElementById("real");
	div2.onmouseover=function(){
		$("#reals").show();
	};
	div2.onmouseout=function(){
		$("#reals").hide();
	};
	var div3=document.getElementById("serI");
	div3.onmouseover=function(){
		$("#serIn").show();
	};
	div3.onmouseout=function(){
		$("#serIn").hide();
	};
	var div4=document.getElementById("serP");
	div4.onmouseover=function(){
		$("#serPa").show();
	};
	div4.onmouseout=function(){
		$("#serPa").hide();
	};
	var div5=document.getElementById("realP");
	div5.onmouseover=function(){
		$("#realPa").show();
	};
	div5.onmouseout=function(){
		$("#realPa").hide();
	};
}
function key(){
	$("[name='payCashStart']").keydown(function() {
		$("[name='cashStart']").val("");
		$("[name='cashEnd']").val("");
		$("[name='returnCashStart']").val("");
		$("[name='returnCashEnd']").val("");
		$("[name='serviceCashStart']").val("");
		$("[name='serviceCashEnd']").val("");
	})
	$("[name='payCashsEnd']").keydown(function() {
		$("[name='cashStart']").val("");
		$("[name='cashEnd']").val("");
		$("[name='returnCashStart']").val("");
		$("[name='returnCashEnd']").val("");
		$("[name='serviceCashStart']").val("");
		$("[name='serviceCashEnd']").val("");
	})
	
	$("[name='cashStart']").keydown(function() {
		$("[name='payCashStart']").val("");
		$("[name='payCashsEnd']").val("");
		$("[name='returnCashStart']").val("");
		$("[name='returnCashEnd']").val("");
		$("[name='serviceCashStart']").val("");
		$("[name='serviceCashEnd']").val("");
	})
	$("[name='cashEnd']").keydown(function() {
		$("[name='payCashStart']").val("");
		$("[name='payCashsEnd']").val("");
		$("[name='returnCashStart']").val("");
		$("[name='returnCashEnd']").val("");
		$("[name='serviceCashStart']").val("");
		$("[name='serviceCashEnd']").val("");
	})
	
	$("[name='returnCashStart']").keydown(function() {
		$("[name='cashStart']").val("");
		$("[name='cashEnd']").val("");
		$("[name='payCashStart']").val("");
		$("[name='payCashsEnd']").val("");
		$("[name='serviceCashStart']").val("");
		$("[name='serviceCashEnd']").val("");
	})
	$("[name='returnCashEnd']").keydown(function() {
		$("[name='cashStart']").val("");
		$("[name='cashEnd']").val("");
		$("[name='payCashStart']").val("");
		$("[name='payCashsEnd']").val("");
		$("[name='serviceCashStart']").val("");
		$("[name='serviceCashEnd']").val("");
	})
	
	$("[name='serviceCashStart']").keydown(function() {
		$("[name='cashStart']").val("");
		$("[name='cashEnd']").val("");
		$("[name='returnCashStart']").val("");
		$("[name='returnCashEnd']").val("");
		$("[name='payCashStart']").val("");
		$("[name='payCashsEnd']").val("");
	})
	$("[name='serviceCashEnd']").keydown(function() {
		$("[name='cashStart']").val("");
		$("[name='cashEnd']").val("");
		$("[name='returnCashStart']").val("");
		$("[name='returnCashEnd']").val("");
		$("[name='payCashStart']").val("");
		$("[name='payCashsEnd']").val("");
	})
}
