<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="totalZong" class="easyui-accordion" fit="true" border="false"></div>
	
	<script type="text/javascript">
	$(function() {
		var _menu_zong = {"menus":[
								{"menuid":"1","menuname":"平台运营概览",
									"menus":[{"menuname":"平台运营概览","url":"aiPinXuan/center/totality/flat/flat"}
										]
	 							}
						]};
								
						
		InitLeftMenu_zong();
	
	
		function InitLeftMenu_zong() {
		
		    $("#totalZong").empty();
		    var menulist_zong = "";
		   
		    $.each(_menu_zong.menus, function(i, n) {
		        menulist_zong += '<div title="'+n.menuname+'" style="overflow:auto;">';
				menulist_zong += '<ul>';
		        $.each(n.menus, function(j, o) {
		        	
		        	var menulist1 = '<shiro:hasPermission name="/aiPinXuan/center/totality/flat/flat">'+'<li><div><a name="aiPinXuan/center/totality/flat/flat" >平台运营概览</a></div></li>'+'</shiro:hasPermission>';
		        	
		        	menulist_zong += menulist1;
		        })
		        menulist_zong += '</ul></div>';
		    })
		
			$("#totalZong").append(menulist_zong);
		    
// 		    $("#totalZong li a").eq(0).parent().addClass("selected");
			
			$('#totalZong li a').click(function(){
				var tabTitle = $(this).text();
				var url = $(this).attr("name");
				addTab1(tabTitle,url);
				$('#totalZong li div').removeClass("selected");
				$(this).parent().addClass("selected");
			}).hover(function(){
				$(this).parent().addClass("hover");
			},function(){
				$(this).parent().removeClass("hover");
			});
		
			$("#totalZong").accordion();
		}
		function addTab1(subtitle,url){
			$("#centerZong").panel({
				href:url
			})
		}
	})
	</script>
</body>
</html>