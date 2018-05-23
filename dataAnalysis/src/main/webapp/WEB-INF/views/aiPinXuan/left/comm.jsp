<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<div id="comm" class="easyui-accordion" fit="true" border="false"></div>
<script type="text/javascript">
$(function() {
	var _menus = {"menus":[
							{"menuid":"1","menuname":"供应商分析",
 							},{"menuid":"8","menuname":"商品分析",
							}
 							,{"menuid":"56","menuname":"订单分析",
							}
					]};
					
	InitLeftMenu();


	function InitLeftMenu() {
		
	    $("#comm").empty();
	    var menulist = "";
	   
	    $.each(_menus.menus, function(i, n) {
	        menulist += '<div title="'+n.menuname+'" style="overflow:auto;">';
			menulist += '<ul>';
			var menulist1 = '<shiro:hasPermission name="/aiPinXuan/center/commodity/provider/xiao">'+'<li><div><a name="aiPinXuan/center/commodity/provider/xiao" >销量分析</a></div></li>'+'</shiro:hasPermission>';
			var menulist2 = '<shiro:hasPermission name="/aiPinXuan/center/commodity/provider/sale">'+'<li><div><a name="aiPinXuan/center/commodity/provider/sale" >销售额分析</a></div></li>'+'</shiro:hasPermission>';
			var menulist3 = '<shiro:hasPermission name="/aiPinXuan/center/commodity/provider/speed">'+'<li><div><a name="aiPinXuan/center/commodity/provider/speed" >发货速度分析</a></div></li>'+'</shiro:hasPermission>';
			var menulist4 = '<shiro:hasPermission name="/aiPinXuan/center/commodity/commodity/sellRaking">'+'<li><div><a name="aiPinXuan/center/commodity/commodity/sellRaking" >销售商品排名</a></div></li>'+'</shiro:hasPermission>';
			var menulist5 = '<shiro:hasPermission name="/aiPinXuan/center/commodity/commodity/propSKU">'+'<li><div><a name="aiPinXuan/center/commodity/commodity/propSKU" >各品类销售占比</a></div></li>'+'</shiro:hasPermission>';
			var menulist6 = '<shiro:hasPermission name="/aiPinXuan/center/commodity/commodity/sellSku">'+'<li><div><a name="aiPinXuan/center/commodity/commodity/sellSku" >年度销售分析</a></div></li>'+'</shiro:hasPermission>';
			var menulist7 = '<shiro:hasPermission name="/aiPinXuan/center/commodity/order/ordersTotal">'+'<li><div><a name="aiPinXuan/center/commodity/order/ordersTotal" >订单总数分析</a></div></li>'+'</shiro:hasPermission>';
			
			
// 	        $.each(n.menus, function(j, o) {
// 				menulist +='<shiro:hasPermission name="/aiPinXuan/center/commodity/provider/xiao">'+'<li><div><a name="' + o.url + '" >' + o.menuname + '</a></div></li>'+'</shiro:hasPermission>';
// 	        })
			if(n.menuid==1) {
				menulist += menulist1;
				menulist += menulist2;
				menulist += menulist3;
			}else if(n.menuid==8) {
				menulist += menulist4;
				menulist += menulist5;
				menulist += menulist6;
			}else if(n.menuid==56) {
				menulist += menulist7;
			}
			
			
			

	        menulist += '</ul></div>';
	    })
	    
		$("#comm").append(menulist);
	    
// 	    $('#comm li a').eq(0).parent().addClass("selected");
		
	    $('#comm li a').click(function(){
			var tabTitle = $(this).text();
			var url = $(this).attr("name");
			addTab(tabTitle,url);
			$('#comm li div').removeClass("selected");
			$(this).parent().addClass("selected");
		}).hover(function(){
			$(this).parent().addClass("hover");
		},function(){
			$(this).parent().removeClass("hover");
		});
	
		$("#comm").accordion();
	}
	function addTab(subtitle,url){
		$("#centerComm").panel({
			href:url
		})
	}
})
</script>
</body>
</html>