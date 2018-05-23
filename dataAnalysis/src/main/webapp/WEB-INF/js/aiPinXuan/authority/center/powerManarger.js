var id = $("[name='roleId']").val();
$("#edit1").hide();
$("[name='roleId']").hide();
$("#nameRole").hide();
$("[name='urlIds']").hide();


/**
 * 权限树数据
 */
var setting = {
	check: {
		enable: true,
		chkStyle: "checkbox",
		chkboxType: { "Y": "ps", "N": "ps" }
	},
	data: {
		simpleData: {
			enable: true,
			idKey: "id",
			pIdKey: "pid",
			rootPId: 0
		},
		key:{
			name:'name'
		}
	}
};
$.ajax({
	url:"authority/getUrlList",
	type:"post",
	dataType:"json",
	async:false,
	success:function(date) {
		$.fn.zTree.init($("#ztree"), setting, date);
	},
	error:function() {
		alert("error");
	}
})

if(id != null && id != "") {
	$("#edit1").show();
	$("#impower").hide();
	$("#nameRole").show();
	$("#powerSelect").hide();
	powerById(id);
}
function powerById(id) {
	/**
	 * 查询角色的权限并回显
	 */
	$.ajax({
		url:"authority/getRoleUrlById",
		data:{roleId:id},
		type:"post",
		dataType:"json",
		async:false,
		success:function(date) {
			$.fn.zTree.init($("#ztree"), setting, date);
		},
		error:function() {
			alert("error");
		}
	});
}
/**
 * 遍历ztree树的所有节点
 */
var treeObj = $.fn.zTree.getZTreeObj("ztree");
var nodes = treeObj.transformToArray(treeObj.getNodes());
if(id != null && id != "") {
	for(var i=0;i<nodes.length;i++) {
		treeObj.setChkDisabled(nodes[i], true);
	}
}
/**
 * 下拉值回显
 */
$.ajax({
	url:'authority/getRoleList',
	type:'post',
	dataType:'json',
	async:false,
	success:function(data) {
		for(var i=0;i<data.length;i++) {
			$("[name='powerSelect']").append("<option value="+data[i].id+">"+data[i].roleName+"</option>");
		}
	},
	error:function() {
		alert("error");
	}
})

$("[name='powerSelect']").click(function() {
	var pid = $("[name='powerSelect']").val();
	powerById(pid);
})


/**
 * 编辑按钮
 */
$("#edit1").click(function() {
	$("#edit1").hide();
	$("#impower").show();
	for(var i=0;i<nodes.length;i++) {
		treeObj.setChkDisabled(nodes[i], false);
	}
})
/**
 * 授权按钮
 */
$("#impower").click(function() {
	var treeObj = $.fn.zTree.getZTreeObj("ztree");
	var nodes = treeObj.getCheckedNodes(true);
	var urls = "";
	for(i = 0; i < nodes.length; i++) {
		urls += ","+nodes[i].id;
	}
	$("[name='urlIds']").val(urls.substr(1));
	var roleId = "";
	if(id == null || id == "") {
		roleId = $("[name='powerSelect']").val();
	}else{
		roleId = id;
	}
	if(roleId !=null && roleId != "") {
		$.ajax({
			url:'authority/insertRoleUrl',
			data:{roleId:roleId,urlIds:urls.substr(1)},
			type:"post",
			dataType:"json",
			async:false,
			success:function(date) {
				if(date) {
					$.messager.alert('我的消息','授权成功'); 
				}else{
					$.messager.alert('我的消息','授权失败，可能没有用户拥有此权限');
				}
			}
		})
	}else{
		$.messager.alert('我的消息','请选择角色'); 
	}
})
