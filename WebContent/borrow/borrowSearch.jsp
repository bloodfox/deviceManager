<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>借用归还情况查询</title>
</head>
<body>
	<s:form id="myform" action="searchBorrow.action" method="post" theme="simple">
	<table align="center" width="100%" cellspacing="0" cellpadding="1"
			border="1">
	<%-- 	<tr>
			<td>选择类型：</td><td><select name="borrowType" ><option value="1">借用</option><option value="2">归还</option></select></td>
		</tr> --%>
		<tr><td colspan="2" align="center">品牌：<s:property value="phoneInfo.brand" /></td></tr>	
		<tr><td colspan="2" align="center">型号：<s:property value="phoneInfo.model" /></td></tr>	
		<tr><td colspan="2" align="center"><input type="submit" value="查询"></td></tr>	
	</table>
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
                    	<td><s:property value="model" /></td>
						<td>
						<s:if test="borrowType==1"><s:property value="endUser" /> <s:hidden value="endUser" /></s:if>
						<s:else><s:property value="strUser" /> <s:hidden value="strUser" /></s:else>
						</td>
						<td><s:property value="recDate" />&nbsp;</td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</s:form>
</body>
</html>