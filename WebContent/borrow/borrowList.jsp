<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>借用归还待审核列表</title>
<script type="text/javascript">
	function getDetail(borrowType, id, itemId,borrowItem, endUser) {
		if (borrowType == 1) {
			document.getElementById("myform").action = "confirmBorrow.action?id="
					+ id + "&itemId=" + itemId + "&borrowItem="+borrowItem+"&endUser=" + endUser;
		} else {
			document.getElementById("myform").action = "confirmReturn.action?id="
					+ id + "&itemId=" + itemId + "&borrowItem="+borrowItem+"&endUser=" + endUser;
		}
		document.getElementById("myform").submit();
	}
</script>
</head>
<body>
	<s:form id="myform" method="post" theme="simple">
		<table align="center" width="100%" cellspacing="0" cellpadding="1"
			border="1">
			<thead>
				<tr>
					<th>借用归还流水编号</th>
					<th>借用归还类型</th>
					<th>借用物品类型</th>
					<th>借用物品编号</th>
					<th>借用物品型号</th>
					<th>借用者</th>
					<th>申请日期</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="borrowList">
					<tr align="center">
						<td><s:property value="id" /> <s:hidden value="id" /></td>
						<td><s:if test="borrowType==1">借用</s:if> <s:elseif
								test="borrowType==2">归还</s:elseif></td>
						<td><s:property value="borrowItem" /> </td>
						<td>
						<s:property value="itemId" /> <s:hidden value="itemId" />
						</td>
                    	<td><s:property value="model" /> 						</td>
						<td>
						<s:if test="borrowType==1"><s:property value="endUser" /> <s:hidden value="endUser" /></s:if>
						<s:else><s:property value="strUser" /> <s:hidden value="strUser" /></s:else>
						</td>
						<td><s:property value="recDate" />&nbsp;</td>
						<td><a href="#"
							onclick="getDetail('<s:property value="borrowType" />','<s:property value="id" />','<s:property value="itemId" />','<s:property value="borrowItem" />','<s:property value="endUser" />' )">审核通过</a>
						</td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</s:form>
</body>
</html>