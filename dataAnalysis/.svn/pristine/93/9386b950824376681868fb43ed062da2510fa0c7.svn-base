$("#roleNameSpan1").hide();
$("#roleId").hide();
$("#roleNameSpan").hide();
/**
 * 列表加载数据
 */
$('#roleTable').datagrid({
    url:'authority/getRoleLists',
    fitColumns:true,
    rownumbers:true,
//    title:'角色列表',
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
        {field:'roleName',title:'角色名称',width:100,height:10,sortable:true,align:'center',halign:'center'},    
        {field:'remark',title:'备注',width:100,sortable:true,align:'center',halign:'center'}  ,
        {field:'xx',title:'操作',width:100,sortable:true,align:'center',halign:'center',formatter:function(value,row,index){
			if(row) {
				return "<a href='javascript:void(0)' style='text-decoration: none;' name='"+row.id+"' onclick='findRole(this)' class='findRole' >查看</a>"+"-"+"<a href='javascript:void(0)' style='text-decoration: none;' name='"+row.id+"' onclick='updRole(this)' class='updRole' >修改</a>"+"-"+"<a href='javascript:void(0)' style='text-decoration: none;' name='"+row.id+"' onclick='delRole(this)' class='delRole' >删除</a>";
			}
	   }}
    ]]
});
/**
 * 角色修改
 */
function updRole(obj) {
	var id = $(obj).attr("name");
	$("#roleDialog").dialog("open");
	$("#roleNameSpan1").hide();
	$.ajax({
		url:'authority/getRoleById',
		data:{id:id},
		type:"post",
		dataType:"json",
		success:function(date) {
			$("#roleId").val(date.id);
			$("#roleName").val(date.roleName);
			$("#rem").val(date.remark);
		}
	})
	$("#roleName").blur(function() {
		$.ajax({
			url:'authority/getByRoleName',
			data:{roleName:$("#roleName").val()},
			type:"post",
			dataType:"json",
			success:function(date) {
				if(date) {
					$("#roleNameSpan1").hide();
				}else{
					$("#roleNameSpan1").show();
					$("#roleName")[0].focus();
				}
			},
			error:function() {
				alert("error");
			}
		})
	})
}
/**
 * 修改保存角色
 */
$("#saveRole").click(function() {
	$("#roleForm").form('submit',{
		url:'authority/updateRole',
		success:function(date) {
			if(date) {
				$.messager.alert('我的消息','操作成功');
				$("#roleDialog").dialog("close");
				$("#roleTable").datagrid("reload");
			}else{
				$.messager.alert('我的消息','操作失败');
			}
		}
	})
})
/**
 * 角色添加
 */
function insertRole1() {
	$("#insertRoleFrom").form('submit',{
		url:'authority/insertRole',
		success:function(date) {
			if(date) {
				$.messager.alert('我的消息','操作成功');  
				$("#insertRoleFrom").form("clear");
				$("#roleTable").datagrid("reload");
			}else{
				$.messager.alert('我的消息','操作失败');  
			}
		}
	})
}
/**
 * 角色删除
 */
function delRole(obj) {
	var id = $(obj).attr("name");
	$.messager.confirm("确认对话框", "您想要删除此角色吗？", function(r){
	    if(r){
			$.ajax({
				url:'authority/delRole',
				data:{id:id},
				type:'post',
				dataType:"json",
				success:function(data) {
					if(data) {
						$.messager.alert('我的消息','删除成功');  
						$("#roleTable").datagrid("reload");
					}
				},
				error:function() {
					alert("error");
				}
			});
	    }
	})
}
/**
 * 查看权限
 * @param id
 */
function findRole(obj) {
	var id = $(obj).attr("name");
	$("#centerA").panel({
		href:'authority/powerManarger',
		queryParams:{id:id}
	})
}
/**
 * 添加重置
 */
function resertRole1() {
	$("#insertRoleFrom").form("clear");
	$("#roleNameSpan").hide();
}
/**
 * 重置
 */
$("#resetRole").click(function() {
	$("#roleForm").form("clear");
	$("#roleNameSpan1").hide();
})
/**
 * 验证角色名唯一
 */
function getRoleName() {
	$("[name='roleName']").blur(function() {
		$.ajax({
			url:'authority/getByRoleName',
			data:{roleName:$("[name='roleName']").val()},
			type:"post",
			dataType:"json",
			success:function(date) {
				if(date) {
					$("#roleNameSpan").hide();
				}else{
					$("#roleNameSpan").show();
					$("[name='roleName']")[0].focus();
				}
			},
			error:function() {
				alert("error");
			}
		})
	})
}
