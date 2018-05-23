<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 	<div align="center" id="smallTitleDiv"> -->
<!--        <span>个人信息</span>  -->
<!--     </div> -->
<!--     <div> -->
<!--     	<ul> -->
<!-- 	    	<li style="font-size: 14px; margin-top: 5px; margin-left: 20px" id="userInfo"><a style="text-decoration: none; cursor:pointer;">个人信息</a></li> -->
<!-- 	    </ul> -->
<!--     </div> -->
<div id="totalUser" class="easyui-accordion" fit="true" border="false"></div>
	<a href="javascript:void(0);" style="text-decoration: none;"  id="username"></a>
	<script type="text/javascript">
	$(function() {
		$("#username").html($.cookie('username'))
		$("#username").hide();
		var _menu_user = {"menus":[
								{"menuid":"1","menuname":"个人信息",
									"menus":[{"menuname":"个人信息","url":"passwordManager/toUserInfo"}
										]
	 							}
						]};
								
						
		InitLeftMenu_user();
	
	
		function InitLeftMenu_user() {
		
		    $("#totalUser").empty();
		    var menulist_user = "";
		   
		    $.each(_menu_user.menus, function(i, n) {
		    	menulist_user += '<div title="'+n.menuname+'" style="overflow:auto;">';
		    	menulist_user += '<ul>';
		        $.each(n.menus, function(j, o) {
		        	menulist_user += '<li><div><a name="' + o.url + '" >' + o.menuname + '</a></div></li> ';
		        })
		        menulist_user += '</ul></div>';
		    })
		
			$("#totalUser").append(menulist_user);
			
			$('#totalUser li a').click(function(){
				var tabTitle = $(this).text();
				var url = $(this).attr("name");
				addTab1(tabTitle,url);
				$('#totalUser li div').removeClass("selected");
				$(this).parent().addClass("selected");
			}).hover(function(){
				$(this).parent().addClass("hover");
			},function(){
				$(this).parent().removeClass("hover");
			});
		
			$("#totalUser").accordion();
		}
		function addTab1(subtitle,url){
			$("#centerUser").panel({
// 				href:url
			})
		}
	})
	</script>
</body>
</html>