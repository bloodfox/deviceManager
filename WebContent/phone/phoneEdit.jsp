<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑手机详情</title>
<script
	src="<%=request.getContextPath()%>/common/js/jquery-1.3.2.min.js"
	type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/common/js/initTime.js"
	type="text/javascript"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/common/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
	/* 	$(document).ready(function() {
	 initDate($("#planDate"));
	 }); */
	function mysubmit() {
		if (document.getElementById("phoneId").value == "") {
			alert("请选择要更改的手机 ");
			return false;
		}
		document.myform.submit();
	}
</script>
</head>
<body>
	<s:form name="myform" method="post" theme="simple"
		action="ModifyPhone.action">
		<table align="center" width="50%" cellspacing="0" cellpadding="1"
			border="1">
			<thead>
				<tr>
					<th colspan="2">编辑手机详情：</th>
				</tr>
			</thead>
			<tbody>
				<s:hidden name="borrowType" value="1"></s:hidden>
				<s:hidden name="borrowItem" value="phone"></s:hidden>
				<tr>
					<td width="20%">手机编号：</td>
					<td><s:textfield readonly="true" id="phoneId"
							name="phoneInfo.id" /> 
							<%-- 					<td><s:textfield readonly="true" id="phoneId" name="phoneInfo.itemId" /> --%>
						<!-- 					<input type="button" value="选择" onclick="getPhone();"></input> -->
					</td>
				</tr>
				<tr>
					<td>手机品牌 ：</td>
					<td><s:textfield readonly="true" theme="simple"
							name="phoneInfo.brand" id="brand" /> &nbsp;</td>
				</tr>
				<tr>
				<td>手机型号 ：</td>
				<td><s:textfield readonly="false" theme="simple"
						name="phoneInfo.model" id="model" /> &nbsp;</td>
				</tr>
				<tr>
				<td>系统类型 ：</td>
				<td><s:textfield readonly="false" theme="simple"
						name="phoneInfo.sysTypeId" id="sys_typeid" /> &nbsp;</td>
				</tr>
				<tr>
				<td>运营商：</td>
				<td><s:textfield readonly="false" theme="simple"
						name="phoneInfo.isp" id="isp" /> &nbsp;</td>
				</tr>

				<tr>
					<td>支持版本：</td>
					<td><s:textfield readonly="false" theme="simple"
							name="phoneInfo.sysVsersion" id="sys_version" /> &nbsp;</td>
				</tr>
				<tr>
				<td>当前飞信版本：</td>
				<td><s:textfield readonly="false" theme="simple"
						name="phoneInfo.sys_version" id="sys_version" /> &nbsp;</td>
				</tr>
<%-- 									<tr> 
					<td>
							当前飞信版本：
						</td>
						<td>
							<s:select name="version" listKey="versionName" listValue="versionName" list="phoneVersionList"></s:select>
							&nbsp;
						</td>
						
					</tr>  --%>
<%-- 				<tr>
					<td>手机状态：</td>
					<td><s:textfield readonly="false" theme="simple"
							name="phoneInfo.inuse" id="inuse" /> &nbsp;</td>
				</tr> --%>
 				<tr>
					<td>手机配件：</td>
					<td><s:textfield readonly="false" theme="simple"
							name="phoneInfo.parts" id="parts" /> &nbsp;</td>
				</tr>
 				<tr>
					<td>备注：</td>
					<td><s:textfield readonly="false" theme="simple"
							name="phoneInfo.remarks" id="remarks" /> &nbsp;</td>
				</tr>
			</tbody>
		</table>
		<br>
		<div align="center" width="90%">
			<a href="#" onclick=mysubmit();;>[ 提交 ]</a>&nbsp;&nbsp;<a
				href="../phone/getPhoneList.action">[ 返回 ]</a>
		</div>
	</s:form>
</body>
</html>