<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<div id="marketing" class="easyui-accordion" fit="true" border="false"></div>

<script type="text/javascript">
$(function() {
	var _menu_marketing = {"menus":[
							{"menuid":"1","menuname":"数据分析",
								"menus":[{"menuname":"活动数据分析","url":"aiPinXuan/center/marketing/activityData"},
// 										{"menuname":"渠道数据分析","url":"marketing/channelAnalysis/channel"}
									]
							}
					]};
					
	InitLeftMenu2();


	function InitLeftMenu2() {
	
	    $("#marketing").empty();
	    var menulist2 = "";
	   
	    $.each(_menu_marketing.menus, function(i, n) {
	        menulist2 += '<div title="'+n.menuname+'" style="overflow:auto;">';
			menulist2 += '<ul>';
	        	var menulist3 = '<shiro:hasPermission name="/aiPinXuan/center/marketing/activityData">'+'<li><div><a name="aiPinXuan/center/marketing/activityData" >活动数据分析</a></div></li>'+'</shiro:hasPermission>';
	        	var menulist4 = '<shiro:hasPermission name="/marketing/channelAnalysis/channel">'+'<li><div><a name="marketing/channelAnalysis/channel" >渠道数据分析</a></div></li>'+'</shiro:hasPermission>';
	        	
// 				menulist2 += '<li><div><a name="' + o.url + '" >' + o.menuname + '</a></div></li> ';
				if(n.menuid==1) {
					menulist2 += menulist3;
		        	menulist2 += menulist4;	
	        	}
	        menulist2 += '</ul></div>';
	    })
	
		$("#marketing").append(menulist2);
	    
// 	    $('#marketing li a').eq(0).parent().addClass("selected");
		
		$('#marketing li a').click(function(){
			var tabTitle = $(this).text();
			var url = $(this).attr("name");
			addTab(tabTitle,url);
			$('#marketing li div').removeClass("selected");
			$(this).parent().addClass("selected");
		}).hover(function(){
			$(this).parent().addClass("hover");
		},function(){
			$(this).parent().removeClass("hover");
		});
	
		$("#marketing").accordion();
	}
	function addTab(subtitle,url){
		$("#centerMarketing").panel({
			href:url
		})
	}
})
</script>





<!-- <style type="text/css"> -->
<!-- /* 	.li{font-size: 14px; margin-top: 5px;} */ -->
<!-- /* 	.ma{text-decoration: none; cursor:pointer;} */ -->
<!-- </style> -->
<!-- 	<div align="center" id="smallTitleDiv"> -->
<!--        <span>营销活动分析</span>  -->
<!--     </div> -->
<!--     <div> -->
<!--     	<ul> -->
<!-- 	    	<li class="li" id="activityData"><a class="ma">活动数据统计</a></li> -->
<!-- 	    	<li class="li" id="channelAnalysis"><a class="ma">渠道数据分析</a></li> -->
<!-- 	    </ul> -->
<!--     </div> -->
<!-- <script type="text/javascript"> -->
<!-- // 	$(function() { -->
<!-- // 		$("#activityData").click(function() { -->
<!-- // 			$(this).css("color","#0000CD"); -->
<!-- // 			$("#center").panel({ -->
<!-- // 				href:'aiPinXuan/center/marketing/activityData' -->
<!-- // 			}) -->
<!-- // 		}) -->
<!-- // 		$("#channelAnalysis").click(function(){ -->
<!-- // 			$(this).css("color","#0000CD"); -->
<!-- // 			$("#center").panel({ -->
<!-- // 				href:'marketing/channelAnalysis/channel' -->
<!-- // 			}); -->
<!-- // 		}); -->
<!-- // 	}) -->
<!-- </script> -->
</body>
</html>