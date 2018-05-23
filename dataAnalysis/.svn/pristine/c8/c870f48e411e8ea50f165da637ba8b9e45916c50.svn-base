<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="margin-top: 10px;">
		<form id="insertRoleFrom" method="post">
			<span style="font-size: 16px;">角色名称 ：</span><input type="text" onclick="getRoleName()" name="roleName" class="easyui-validatebox" data-options="required:true" style="width: 130px;height: 20px;border: 1px solid gray;"/>
			<span style="color: red;" id="roleNameSpan">角色名已存在</span>
			<span style="font-size: 16px;">角色备注 ：</span><input type="text" name="remark" style="width: 130px;height: 20px;border: 1px solid gray;"/>
<!-- 			<input type="button" value="添加" onclick="insertRole1()"/> -->
<!-- 			<input type="button" value="重置" onclick="resertRole1()"/> -->
			<a onclick="insertRole1()" class="easyui-linkbutton" style="background-color: #e2e2e2">添加</a>
			<a onclick="resertRole1()" class="easyui-linkbutton" style="background-color: #e2e2e2">重置</a>
		</form>
	</div>
	<div class="easyui-panel" data-options="cls:'theme-panel-blue'" title="角色列表" style="width:100%;height:100%;">
			<table id="roleTable" style="height: 458px; width: 100%;"></table>
	</div>
	<div id="roleDialog" class="easyui-dialog" align="center" data-options="
		width:400,
		height:250,
		closed:true,
		title:'角色修改'">
		<form id="roleForm" method="post">
			<table style="margin-top: 10px;position: absolute; margin-left: 30px;">
				<tr>
					<td>
						<span style="font-size: 16px;">角色名称 ：</span>
					</td>
					<td>
						<input type="text" name="roleName" id="roleName" class="easyui-validatebox" data-options="required:true" style="width: 130px;height: 20px;border: 1px solid gray;"/>
						<span style="color: red;font-size: 12px;" id="roleNameSpan1">角色名已存在</span><input type="text" name="id" id="roleId"/>
					</td>
				</tr>
				<tr>
					<td>
						<span style="font-size: 16px;">角色备注 ：</span>
					</td>
					<td>
						<input type="text" name="remark" id="rem" style="width: 130px;height: 20px;border: 1px solid gray;"/>
					</td>
				</tr>
				<tr>
					<td colspan="2" style="position: absolute;margin-top: 10px; margin-left: 50px;">
<!-- 						<input type="button" value="保存" id="saveRole"/> -->
<!-- 						<input type="button" value="重置" id="resetRole"/> -->
						<a id="saveRole" class="easyui-linkbutton" style="background-color: #e2e2e2">保存</a>
						<a id="resetRole" class="easyui-linkbutton" style="background-color: #e2e2e2">重置</a>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<script type="text/javascript" src="js/aiPinXuan/authority/center/roleManarger.js"></script>
</body>
</html>