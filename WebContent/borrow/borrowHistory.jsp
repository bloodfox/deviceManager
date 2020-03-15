<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>手机借用历史列表</title>
<script type="text/javascript">
	function canclePhone(id, itemId,borrowItem, endUser) {
		document.getElementById("myform").action = "cancleBorrow.action?id="
				+ id + "&itemId=" + itemId + "&borrowItem="+borrowItem+"&endUser=" + endUser;
		document.getElementById("myform").submit();
	}
	function returnPhone(id, itemId,borrowItem, endUser) {
		document.getElementById("myform").action = "returnInit.action?id=" + id
				+ "&itemId=" + itemId+"&borrowItem="+borrowItem;
		document.getElementById("myform").submit();
	}
	function returnCard(id, itemId,borrowItem, endUser) {
		document.getElementById("myform").action = "returnCardInit.action?id=" + id
				+ "&itemId=" + itemId+"&borrowItem="+borrowItem;
		document.getElementById("myform").submit();
	}
</script>
</head>
<body onLoad="initHtmlPage();" bgcolor="#F0F8FF">
	<s:form id="myform" method="post" theme="simple">
		<s:hidden name="version" id="version"></s:hidden>
		<table align="center" width="100%" cellspacing="0" cellpadding="1"
			border="1">
			<thead>
				<tr>
					<th>序号</th>
					<th>借用物品类型</th>
					<th>物品编号</th>
					<th>物品型号</th>
					<th>借用者</th>
					<th>借用日期</th>
					<th>归还日期</th>
					<th>申请状态</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="borrowList">
					<tr align="center">
						<td><s:property value="id" /> <s:hidden value="id" /></td>
						<td><s:property value="borrowItem" /></td>
						<td><s:property value="itemId" /> <s:hidden value="itemId" />
						</td>
						<td><s:property value="model" /></td>
						<td><s:if test="borrowType==1">
								<s:property value="endUser" />
								<s:hidden value="endUser" />
							</s:if> <s:elseif test="borrowType==2">
								<s:property value="strUser" />
								<!--<s:hidden value="strUser" />-->
							</s:elseif></td>
						<td><s:property value="recDate1" /></td>
						<td><s:property value="recDate" />&nbsp;</td>
						<td><s:if test="confirmStatus==0">未审核</s:if> <s:elseif
								test="confirmStatus==1">已审核</s:elseif> <s:elseif
								test="confirmStatus==2">已撤销</s:elseif></td>
						<td>&nbsp; <s:if test="borrowType==1">
								<s:if test="confirmStatus==0">
									<a href="#"
										onclick="canclePhone('<s:property value="id" />','<s:property value="itemId" />','<s:property value="borrowItem" />','<s:property value="endUser" />' )">撤销申请</a>
								</s:if>
								<s:elseif test="confirmStatus==1">
									<!-- <a href="#"
										onclick="returnPhone('<s:property value="id" />','<s:property value="itemId" />','<s:property value="borrowItem" />','<s:property value="endUser" />' )">归还设备</a>
								 -->
								<s:if test="borrowItem.equals('phone')">
								<a href="#"
									onclick="returnPhone('<s:property value="id" />','<s:property value="itemId" />','<s:property value="borrowItem" />','<s:property value="endUser" />' )">归还手机</a>
								</s:if>
								<s:elseif test="borrowItem.equals('card')">
								<a href="#"
									onclick="returnCard('<s:property value="id" />','<s:property value="itemId" />','<s:property value="borrowItem" />','<s:property value="endUser" />' )">归还手机卡</a>
								</s:elseif>
								</s:elseif>
							</s:if>
						</td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</s:form>
</body>
</html>