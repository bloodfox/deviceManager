<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>归还手机卡 </title>
		<script
			src="<%=request.getContextPath()%>/common/js/jquery-1.3.2.min.js"
			type="text/javascript"></script>
		<script src="<%=request.getContextPath()%>/common/js/initTime.js"
			type="text/javascript"></script>
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/common/My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript">
	function mysubmit() {
		var id = document.getElementById("id").value;
		var itemId = document.getElementById("itemId").value;
		var endUser = document.getElementById("endUser").value;
  		document.getElementById("myform").action = "returnBorrow.action?id="
 			+ id + "&itemId=" + itemId + "&endUser=" + endUser+"&borrowItem=card";
		document.getElementById("myform").submit();
	}
</script>
	</head>
	<body onLoad="initHtmlPage();"  bgcolor="#F0F8FF" >
		<s:form id="myform" method="post" theme="simple">
			<table align="center" width="90%" cellspacing="0" cellpadding="1"
				border="1">
				<thead>
					<tr>
						<th colspan="2">
							归还手机卡详情：<s:hidden id="id" name="borrowInfo.id"  />
						</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td width="20%">
							手机卡编号：
						</td>
						<td>
							<s:textfield readonly="true" id="itemId" name="borrowInfo.itemId" />
						</td>
					</tr>
					<tr><td>手机卡号：</td>
					<td><!--<s:property value="model" />&nbsp;（查看后借阅带入的）-->
					
							<s:textfield readonly="true" theme="simple" name="borrowInfo.model" />
							&nbsp;
					
					</td></tr>
					<tr>
						<td>
							借用者：
						</td>
						<td>
							<s:textfield readonly="true" id="endUser" theme="simple" name="borrowInfo.endUser" />
							&nbsp;
						</td>
					</tr>
					<tr>
						<td>
							计划归还日期：
						</td>
						<td>
							<s:textfield readonly="true" theme="simple" name="borrowInfo.planDate" />
							&nbsp;
						</td>
					</tr>
					<tr>
						<td>
							申请日期：
						</td>
						<td>
							<s:textfield readonly="true" theme="simple" name="borrowInfo.recDate" />
							&nbsp;
						</td>
					</tr>

				</tbody>
			</table>
			<br>
			<div align="center" width="90%">
				<a href="#" onclick=
	mysubmit();;
>[ 归还 ]</a>&nbsp;&nbsp;
			</div>
		</s:form>
	</body>
</html>