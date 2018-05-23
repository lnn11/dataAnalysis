<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<div id="authorityLeft" class="easyui-accordion" fit="true" border="false"></div>

<script type="text/javascript">
$(function() {
	var _menus_authority = {"menus":[
							{"menuid":"1","menuname":"权限管理",
								"menus":[{"menuname":"用户管理","url":"aiPinXuan/authority/center/userManarger"},
										{"menuname":"角色管理","url":"aiPinXuan/authority/center/roleManarger"},
										{"menuname":"权限管理","url":"authority/center/powerManarger"},
// 										{"menuname":"菜单设置","url":"authority/center/menu"}
									]
 							}
					]};
					
	InitLeftMenu_auth();


	function InitLeftMenu_auth() {
	
	    $("#authorityLeft").empty();
	    var menulist_auth = "";
	   
	    $.each(_menus_authority.menus, function(i, n) {
	    	menulist_auth += '<div title="'+n.menuname+'" style="overflow:auto;">';
	    	menulist_auth += '<ul>';
	        $.each(n.menus, function(j, o) {
	        	menulist_auth += '<li><div><a name="' + o.url + '" >' + o.menuname + '</a></div></li> ';
	        })
	        menulist_auth += '</ul></div>';
	    })
	
		$("#authorityLeft").append(menulist_auth);
		
	    $('#authorityLeft li a').eq(0).parent().addClass("selected");
	    
		$('#authorityLeft li a').click(function(){
			var tabTitle = $(this).text();
			var url = $(this).attr("name");
			addTab(tabTitle,url);
			$('#authorityLeft li div').removeClass("selected");
			$(this).parent().addClass("selected");
		}).hover(function(){
			$(this).parent().addClass("hover");
		},function(){
			$(this).parent().removeClass("hover");
		});
	
		$("#authorityLeft").accordion();
	}
	function addTab(subtitle,url){
		if(url=='aiPinXuan/authority/center/userManarger') {
			parent.location.reload();
		}else{
			$("#centerA").panel({
				href:url
			})	
		}
		
	}
})
</script>



<!--     <div> -->
<!--     	<ul> -->
<!-- 	    	<li style="font-size: 14px">权限管理</li> -->
<!-- 	    	<li style="font-size: 14px; margin-top: 5px; margin-left: 20px" id="user"><a style="text-decoration: none; cursor:pointer;">用户管理</a></li> -->
<!-- 	    	<li style="font-size: 14px; margin-top: 5px; margin-left: 20px" id="role"><a style="text-decoration: none; cursor:pointer;">角色管理</a></li> -->
<!-- 	    	<li style="font-size: 14px; margin-top: 5px; margin-left: 20px" id="power"><a style="text-decoration: none; cursor:pointer;">权限管理</a></li> -->
<!-- 			<li style="font-size: 14px; margin-top: 5px; margin-left: 20px" id="urlSet"><a style="text-decoration: none; cursor:pointer;">菜单设置</a></li> -->
<!-- 	    </ul> -->
<!--     </div> -->
<!--     <script type="text/javascript"> -->
<!-- //     	$(function() { -->
<!-- //     		$("#centerA").panel({ -->
<!-- // 				href:'aiPinXuan/authority/center/userManarger' -->
<!-- // 			}) -->
<!-- //     		$("#user").click(function() { -->
<!-- //     			parent.location.reload(); -->
<!-- // //     			$("#centerA").panel({ -->
<!-- // //     				href:'aiPinXuan/authority/center/userManarger' -->
<!-- // //     			}) -->
<!-- //     		}) -->
<!-- //     		$("#role").click(function() { -->
<!-- //     			$("#centerA").panel({ -->
<!-- //     				href:'aiPinXuan/authority/center/roleManarger' -->
<!-- //     			}) -->
<!-- //     		}) -->
<!-- //     		$("#power").click(function() { -->
<!-- //     			$("#centerA").panel({ -->
<!-- //     				href:'authority/center/powerManarger' -->
<!-- //     			}) -->
<!-- //     		}) -->
<!-- //     		$("#urlSet").click(function(){ -->
<!-- //     			$("#centerA").panel({ -->
<!-- //     				href:'authority/center/menu' -->
<!-- //     			}) -->
<!-- //     		}); -->
<!-- //     	}) -->
<!--     </script> -->
</body>
</html>