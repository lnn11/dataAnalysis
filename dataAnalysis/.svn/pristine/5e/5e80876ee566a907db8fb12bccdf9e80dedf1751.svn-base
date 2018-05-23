<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>菜单设置</title>
</head>
<body>
	<div class="easyui-layout" style="width:100%;height:100%;">
		<div id="p" data-options="region:'west'" title="菜单树" style="width:30%;padding:10px">
			<ul  class="zTree" id="ztree2"></ul>
		</div>
		<div data-options="region:'center'" title="Center">
			<div class="easyui-tabs">
				<div title="当前节点" style="padding:10px">
					<div style="margin-top: 20px;">
						<div>菜单：<input type="text" alt="输入菜单名称" title="输入菜单名称" name="txtMenuName"  style="width: 130px;height: 20px;border: 1px solid gray;"></div>
						<div style="margin-top: 20px;">隶属于：<select name="current"></select></div>
					</div>
					<div style="margin-top: 20px;">
						URL:<input type="text" alt="输入链接地址" title="输入链接地址" name="txtURL"  style="width: 130px;height: 20px;border: 1px solid gray;">
						sort:<input type="text" alt="如果要输入，前缀与隶属于中的一致" title="如果要输入，前缀与隶属于中的一致" name="txtSort" style="width: 130px;height: 20px;border: 1px solid gray;">
					</div>
					<div style="margin-top: 20px;">
						<button class="btnEdit" style="width: 35px;height: 25px;border: 1px solid gray;">编辑</button>
						<button type="reset" style="width: 35px;height: 25px;border: 1px solid gray;">重置</button>
						<button type="button" style="width: 35px;height: 25px;border: 1px solid gray;">删除</button>
					</div>
				</div>
				<div title="添加子节点" style="padding:10px">
					<div style="margin-top: 20px;">
						<div>菜单：<input type="text" alt="输入菜单名称" title="输入菜单名称" name="newSubName"  style="width: 130px;height: 20px;border: 1px solid gray;"></div>
						<div style="margin-top: 20px;">隶属于：<select name="parentNode"></select></div>
					</div>
					<div style="margin-top: 20px;">
						URL:<input type="text" alt="输入链接地址" title="输入链接地址" name="newSubURL"  style="width: 130px;height: 20px;border: 1px solid gray;">
						sort:<input type="text" alt="如果要输入，前缀与隶属于中的一致" title="如果要输入，前缀与隶属于中的一致" name="newSubSort" style="width: 130px;height: 20px;border: 1px solid gray;">
					</div>
					<div style="margin-top: 20px;">
						<button class="btnAddSubNode" style="width: 35px;height: 25px;border: 1px solid gray;">添加</button>
					</div>
				</div>					
			</div>
		</div>
	</div>	
	<script type="text/javascript">
		/*************权限树数据****************/
		var setting = {			
			data: {
				simpleData: {
					enable: true,
					idKey: "id",
					pIdKey: "pid",
					rootPId: 0
				},
				key:{
					name:'name',
				}
			},
			callback:{
                onClick:getSelectedNodes
            }
		};
		$.ajax({
			url:"authority/getUrlList",
			type:"post",
			dataType:"json",
			async:false,
			success:function(data) {
				$.fn.zTree.init($("#ztree2"), setting, data);
			},
			error:function() {
				alert("error");
			}
		});
		/*************end权限树数据****************/
		function getSelectedNodes(){
           	var treeObj=$.fn.zTree.getZTreeObj("ztree2");
            var nodes = treeObj.getSelectedNodes();
            if(nodes != null && nodes != ""){
            	nodes = nodes[nodes.length-1];
                $("input[name='txtMenuName']").val(nodes.name);
                
                $("select[name='current']").empty();
                $("select[name='parentNode']").empty();
                
                if(nodes.getParentNode() != null){
                	$("select[name='current']").append("<option value='"+nodes.pid+"'>"+nodes.getParentNode().name+"</option>");
                	$("select[name='parentNode']").append("<option value='"+nodes.pid+"'>"+nodes.getParentNode().name+"</option>");
                }
                $("input[name='txtURL']").val(nodes.urlVal);
                $("input[name='txtSort']").val(nodes.sortVal);
                setStatus(true);
            }
		}
		function setStatus(isDisabled){
			 $("input[name='txtMenuName']").attr("disabled",isDisabled);
			 $("input[name='txtURL']").attr("disabled",isDisabled);
			 $("input[name='txtSort']").attr("disabled",isDisabled);
			 if(isDisabled){
				 $(".btnEdit").text("编辑");
			 }else{
				 $(".btnEdit").text("保存");
			 }
		};
		function cleanTxt(txtName,txtUrl,txtSort){
			$("input[name='"+txtName+"']").val("");
			$("input[name='"+txtUrl+"']").val("");
			$("input[name='"+txtSort+"']").val("");
		}
		function updateData(txtName,current,txtUrl,txtSort,operation){
			var menuName = $("input[name='"+txtName+"']").val();
			var parentId = $("select[name='"+current+"']").val();
			var urlVal = $("input[name='"+txtUrl+"']").val();
			var sortVal = $("input[name='"+txtSort+"']").val();
			
			var treeObj=$.fn.zTree.getZTreeObj("ztree2");
            var nodes = treeObj.getSelectedNodes();
            nodes = nodes[nodes.length-1];
            var uid = nodes.id;
			
			$.ajax({
				url:'authority/updateMenu',
				type:'post',
				data:{"uid":uid,"menuName":menuName,"parent":parentId,"url":urlVal,"sort":sortVal,"oper":operation},
				dataType:'json',
				success:function(data) {
					var oper = data.oper;
					if(oper=="edit"){
						nodes.id = data.id;
						nodes.pid = data.pid;
						nodes.name = data.name;
						nodes.urlVal = data.urlVal;
						nodes.sortVal = data.sortVal;					
						treeObj.updateNode(nodes);
						cleanTxt("txtMenuName","txtURL","txtSort");	
					}else if(oper == "add"){
						var newNode = {id:data.id,pid:data.pid,name:data.name,urlVal:data.urlVal,sortVal:data.sortVal};
						newNode = treeObj.addNodes(nodes, newNode);
						cleanTxt("newSubName","newSubURL","newSubSort");
					}									
					treeObj.refresh();					
				},
				error:function(info){
					alert(info);
				}
			});
		}
		
		$(".btnEdit").click(function(){
			var treeObj=$.fn.zTree.getZTreeObj("ztree2");
            var nodes = treeObj.getSelectedNodes();            
            if(nodes != null && nodes != ""){
            	var btnVal = $(".btnEdit").text();
    			if("编辑"==btnVal){
    				setStatus(false);
    				$(".btnEdit").text("保存");
    			}else if("保存"==btnVal){
    				updateData("txtMenuName","current","txtURL","txtSort","edit");
    				$(".btnEdit").text("编辑");
    			}	
            }
		});
		$("button[type='reset']").click(function(){
			getSelectedNodes();			
		});
		$(".btnAddSubNode").click(function(){
			var treeObj=$.fn.zTree.getZTreeObj("ztree2");
            var nodes = treeObj.getSelectedNodes();
            if(nodes != null && nodes != ""){
            	var menuName = $("input[name='newSubName']").val();
            	if(menuName != null && menuName != ""){
            		updateData("newSubName","parentNode","newSubURL","newSubSort","add");
            	}            	
            }
		});
		$("button[type='button']").click(function(){
			var treeObj=$.fn.zTree.getZTreeObj("ztree2");
            var nodes = treeObj.getSelectedNodes();
            if(nodes != null && nodes != ""){
            	nodes = nodes[nodes.length-1];
            	if(confirm("确定要删除该节点及以下的子节点吗？")){				
					$.ajax({
						url:"authority/deleteMenu",
						type:"post",
						data:{uid:nodes.id},
						dataType:"json",
						success:function(){
							cleanTxt("txtMenuName","txtURL","txtSort");	
							treeObj.removeChildNodes(nodes);
							treeObj.removeNode(nodes);
							treeObj.refresh();
						}
					});	
				}
            }
		});
	</script>
</body>
</html>