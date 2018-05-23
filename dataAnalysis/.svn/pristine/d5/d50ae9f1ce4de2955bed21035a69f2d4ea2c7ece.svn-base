var url;

$("#userId").hide();
$("[name='roleName']").hide();
/**
 * 下拉值回显
 */
function role() {
	$.ajax({
		url:'authority/getRoleList',
		type:'post',
		dataType:'json',
		async:false,
		success:function(data){
			$("[name='role']").empty();
			$("[name='role']").append("<option value=''>==请选择==</option>")
			for(var i=0;i<data.length;i++) {
				$("[name='role']").append("<option value="+data[i].id+">"+data[i].roleName+"</option>");
			}
		},
		error:function() {
			alert("error");
		}
	})
}

/**
 * 列表加载数据
 */
$('#userTable').datagrid({
    url:'authority/getUserList',
    toolbar:'#tb',
    fitColumns:true,
    rownumbers:true,
//    title:'用户列表',
    singleSelect:true,
    method: 'post',
	loadMsg:'正在加载,请稍等...',
    pagination:true,
    pageSize:15,
    pageList:[10,15,20,30,40,50,60,70,80,90,100],
    nowrap:false,
    border:false,
    remoteSort:false,
    columns:[[
        {field:'userName',title:'用户名',width:100,sortable:true,align:'center',halign:'center'},    
        {field:'roleName',title:'所属角色',width:100,sortable:true,align:'center',halign:'center'},    
        {field:'remark',title:'备注',width:100,sortable:true,align:'center',halign:'center'}  ,
        {field:'xx',title:'操作',width:100,sortable:true,align:'center',halign:'center',formatter:function(value,row,index){
			if(row) {
				return "<a href='javascript:void(0)' style='text-decoration: none;' onclick='updUser(this)' name='"+row.id+"' class='updUser' >修改</a>"+"-"+"<a href='javascript:void(0)' style='text-decoration: none;' onclick='delUser(this)'  name='"+row.id+"' class='delUser' >删除</a>";
			}
	   }}
    ]]
});
/**
 * 用户修改
 */
function updUser(obj) {
	role();
	var id = $(obj).attr("name");
	$("#userId").val("");
	$("#userName").val("");
	$("#nameSpan1").hide();
	$("#password").val("");
	$("#remark").val("");
	$("[name='role']").val("");
	$("[name='roleName']").val("");
	$("#s").text("");
	$("#chose").show();
	$.ajax({
		url:'authority/getUserById',
		data:{id:id},
		type:"post",
		dataType:"json",
		async:false,
		success:function(date) {
			$("#userId").val(date.id);
			$("#userName").val(date.userName);
			$("#remark").val(date.remark);
			$("#roles").html(date.roleName);
			$("[name='roleName']").val(date.roles);
		},
		error:function() {
			alert("数据加载失败");
		}
	});
	$("#userDialog").dialog({
		title:'用户修改'
	})
	$("#userDialog").dialog("open");
	$("#nameSpan").hide();
	url = "authority/updateUser";
}
/**
 * 用户添加
 */
$("#addUser").click(function() {
	role();
	$("#userId").val("");
	$("#userName").val("");
	$("#password").val("");
	$("#remark").val("");
	$("[name='role']").val("");
	$("#nameSpan1").hide();
	$("[name='roleName']").val("");
	$("#roles").html("");
	$("#s").text("");
	$("#chose").show();
	$("#userDialog").dialog({
		title:'用户添加'
	})
	$("#userDialog").dialog("open");
	$("#nameSpan").hide();
	url = "authority/insertUser";
})
/**
 * 表单提交
 */
$("#saveUser").click(function() {
	if($("#userName").val()==null||$("#userName").val()=="") {
		$("#nameSpan1").show();
	}else{
		$.ajax({
			url:url,
			data:{id:$("#userId").val(),userName:$("#userName").val(),password:$("#password").val(),remark:$("#remark").val(),roleName:$("[name='roleName']").val()},
			type:"post",
			dataType:"json",
			success:function(data) {
				if(data) {
					$.messager.alert('我的消息','操作成功');
					$("#userDialog").dialog("close");
					$("#userTable").datagrid("reload");
				}else{
					$.messager.alert('我的消息','操作失败'); 
				}
			}
		})
	}
});
/**
 * 选择角色
 */
$("#chose").click(function() {
	var roles = $("[name='roleName']").val();
	var rolesName = $("#roles").html();
	if($("[name='role']").val()!=""&&$("[name='role']").val()!=null) {
		var name = $("[name='role'] option:selected").val();
		var roleName = $("[name='role'] option:selected").text();
		var rolesN = roles.split(",");
		if(roles.split(",").length<3) {
			$("#s").text("");
		}else{
			$("#s").text("最多显示3个角色");
			$("#chose").hide();
		}
		if(roles.split(",").length<3) {
			var flag = true;
			for(i=0;i<rolesN.length;i++) {
				if(rolesN[i] == name) {
					flag = false;
				}
			}
			if(flag == true){
				if(roles == "") {
					$("[name='roleName']").val(name);
					$("#roles").html(roleName);
				}else{
					$("[name='roleName']").val(roles+","+name);
					$("#roles").html(rolesName+","+roleName);
				}
			}
		}
	}
	
});
/**
 * 重置
 */
$("#reset").click(function() {
	$("#userId").val("");
	$("#userName").val("");$("#nameSpan1").hide();
	$("#password").val("");
	$("#remark").val("");
	$("#roles").html("");
	$("[name='roles']").val("");
	$("[name='role']").val("");
	$("#s").text("");
	$("#chose").show();
	$("#nameSpan").hide();
})
/**
 * 重置角色
 */
$("#resetRole").click(function() {
	$("#roles").html("");
	$("#nameSpan1").hide();
	$("[name='roleName']").val("");
	$("[name='roles']").val("");
	$("[name='role']").val("");
	$("#s").text("");
	$("#chose").show();
})
/**
 * 用户删除
 */
function delUser(obj) {
	var id = $(obj).attr("name");
		$.messager.confirm("确认对话框", "您想要删除此用户吗？", function(r){
        if(r){
			$.ajax({
				url:'authority/delUser',
				data:{id:id},
				type:'post',
				dataType:"json",
				success:function(data) {
					if(data) {
						$.messager.alert('我的消息','删除成功');
						$("#userTable").datagrid("reload");
					}
				},
				error:function() {
					alert("error");
				}
			});
        }
	});
}
/**
 * 验证用户名唯一
 */
$("#userName").blur(function() {
	$.ajax({
		url:'authority/getByName',
		data:{userName:$("#userName").val()},
		type:"post",
		dataType:"json",
		success:function(date) {
			if(date) {
				$("#nameSpan").hide();
				$("#nameSpan1").hide();
			}else{
				$("#nameSpan").show();
				$("#nameSpan1").hide();
				$("#userName")[0].focus();
			}
		},
		error:function() {
			alert("error");
		}
	})
})
