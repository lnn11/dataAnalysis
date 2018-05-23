<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<style type="text/css">
		.left{text-align:right}
		.right{text-align:left}
	</style>
	<div class="easyui-panel" data-options="cls:'theme-panel-blue'" title="用户列表" style="width:100%;height:100%;">
		<div id="tb">
			<a id="addUser" class="easyui-linkbutton" data-options="iconCls:'icon-add'" >用户添加</a>  
		</div>
		<div style="margin-top: 10px;">
		<table id="userTable" style="height: 485px; width: 100%;"></table>
	</div>
	</div>
	
	<div id="userDialog" class="easyui-dialog" align="center" data-options="
 		width:500,
 		height:300,
		closed:true">
<!-- 		<form id="userForm" method="post"> -->
			<table style="position: absolute;margin-left: 60px;margin-top: 10px;">
				<tr>
					<td class="left">
						<input type="text" name="id" id="userId"/>
						<span style="font-size: 16px;">用户名 ：</span>
					</td>
					<td class="right">
						<input type="text" id="userName" name="userName" class="easyui-validatebox" style="width: 130px;height: 20px;border: 1px solid gray;" data-options="required:true"/>
						<span id="nameSpan" style="color: red" hidden="true">用户名已存在</span>
						<span id="nameSpan1" style="color: red" hidden="true">用户名不能为空</span>
					</td>
				</tr>
				<tr>
					<td class="left">
						<span style="font-size: 16px;">密码 ：</span>
					</td>
					<td class="right">
						<input type="password" name="password" id="password" style="width: 130px;height: 20px;border: 1px solid gray;"/>
					</td>
				</tr>
				<tr>
					<td class="left">
						<span style="font-size: 16px;">备注 ：</span>
					</td>
					<td class="right"> 
						<input type="text" name="remark" id="remark" style="width: 130px;height: 20px;border: 1px solid gray;"/>
					</td>
				</tr>
				<tr>
					<td class="left"> 
						<span style="font-size: 16px;">角色 ：</span>
					</td>
					<td class="right">
						<select name="role" id="role"></select>
<!-- 						<input type="button" value="选择" id="chose"/> -->
<!-- 						<input type="button" value="重置角色" id="resetRole"/> -->
						<a id="chose" class="easyui-linkbutton" style="background-color: #e2e2e2">选择</a>
						<a id="resetRole" class="easyui-linkbutton" style="background-color: #e2e2e2">重置角色</a>
					</td>
				</tr>
				<tr>
					<td class="left">
						<span style="font-size: 16px;">所属角色 ：</span>
					</td>
					<td class="right">
						<span id="roles"></span><span id="s" style="color: red;margin-left: 5px;"></span>
						<input type="text" name="roleName" style="width: 130px;height: 20px;border: 1px solid gray;"/>
					</td>
				</tr>
				<tr>
					<td style="position: absolute; margin-left: 100px;">
<!-- 						<input type="button" value="保存" id="saveUser"/> -->
<!-- 						<input type="button" value="重置" id="reset"/> -->
						<a id="saveUser" class="easyui-linkbutton" style="background-color: #e2e2e2">保存</a>
						<a id="reset" class="easyui-linkbutton" style="background-color: #e2e2e2">重置</a>
					</td>
				</tr>
			</table>
<!-- 		</form> -->
	</div>
	<script type="text/javascript" src="js/aiPinXuan/authority/center/userManarger.js"></script>
</body>
</html>