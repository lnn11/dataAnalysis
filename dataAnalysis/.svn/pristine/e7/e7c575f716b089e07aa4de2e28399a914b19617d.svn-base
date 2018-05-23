<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="finance" class="easyui-accordion" fit="true" border="false"></div>
<script type="text/javascript">
$(function() {
	var _menu = {"menus":[
							{"menuid":"1","menuname":"对账单",
								"menus":[{"menuname":"供应商对账单","url":"aiPinXuan/center/finance/supplierBill"},
// 										{"menuname":"四大合作平台对账单","url":"aiPinXuan/center/finance/partnerBill"},
// 										{"menuname":"福利券对账单","url":"finance/toEmployee"}
									]
 							}
					]};
							
					
	InitLeftMenu1();


	function InitLeftMenu1() {
	
	    $("#finance").empty();
	    var menulist1 = "";
	   
	    $.each(_menu.menus, function(i, n) {
	        menulist1 += '<div title="'+n.menuname+'" style="overflow:auto;">';
			menulist1 += '<ul>';
	        $.each(n.menus, function(j, o) {
	        	
	        	var menulist2 = '<shiro:hasPermission name="/aiPinXuan/center/finance/supplierBill">'+'<li><div><a name="aiPinXuan/center/finance/supplierBill" >供应商对账单</a></div></li>'+'</shiro:hasPermission>';
// 	        	var menulist4 = '<shiro:hasPermission name="/aiPinXuan/center/finance/partnerBill">'+'<li><div><a name="aiPinXuan/center/finance/partnerBill" >四大合作平台对账单</a></div></li>'+'</shiro:hasPermission>';
	        	var menulist3 = '<shiro:hasPermission name="/aiPinXuan/center/finance/employeeBill">'+'<li><div><a name="finance/toEmployee" >福利券对账单</a></div></li>'+'</shiro:hasPermission>';
	        	var menulist5 = '<shiro:hasPermission name="/aiPinXuan/center/finance/payPlatformBill">'+'<li><div><a name="finance/toPayPlatforBill" >支付平台对账单</a></div></li>'+'</shiro:hasPermission>';
	        	
	        	menulist1 += menulist2;
// 	        	menulist1 += menulist4;
	        	menulist1 += menulist3;
	        	menulist1 += menulist5;
	        	
// 				menulist1 += '<li><div><a name="' + o.url + '" >' + o.menuname + '</a></div></li> ';
	        })
	        menulist1 += '</ul></div>';
	    })
	
		$("#finance").append(menulist1);
	    
// 	    $('#finance li a').eq(0).parent().addClass("selected");
		
		$('#finance li a').click(function(){
			var tabTitle = $(this).text();
			var url = $(this).attr("name");
			addTab1(tabTitle,url);
			$('#finance li div').removeClass("selected");
			$(this).parent().addClass("selected");
		}).hover(function(){
			$(this).parent().addClass("hover");
		},function(){
			$(this).parent().removeClass("hover");
		});
	
		$("#finance").accordion();
	}
	function addTab1(subtitle,url){
		$("#centerFinnce").panel({
			href:url
		})
	}
})
</script>
</body>
</html>