<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>手机详情</title>
</head>
<body onLoad="initHtmlPage();"  bgcolor="#F0F8FF" >
	<table align="center" width="90%" cellspacing="0" cellpadding="1" border="1">
		<thead>
			<tr><th colspan="2">手机详情：</th></tr>
		</thead>
		<tbody>
			<tr><td width="20%">手机编号：</td><td><s:property value="phoneInfo.id" /></td></tr>
			<tr><td>手机品牌：</td><td><s:property value="phoneInfo.brand" /></td></tr>
			<tr><td>手机型号：</td><td><s:property value="phoneInfo.model" /></td></tr>
			<tr><td>是否借用：</td><td>
			<s:if test="phoneInfo.inuse==0">未借用</s:if>
			<s:elseif test="inuse==1">申请借用</s:elseif>
			<s:elseif test="inuse==11">已停用</s:elseif>
			<s:else>已借用</s:else></td></tr>
			<!--  <tr><td>协议类型 ：</td><td><s:property value="phoneInfo.protocol" /></td></tr>-->
			<tr><td>支持版本：</td><td>
<%-- 				<s:property value="phoneInfo.sysAllVersion" /> --%>
				<s:iterator value="phoneVersionList">
					<s:property value="versionName" />&nbsp;
				</s:iterator>
				&nbsp;
			</td></tr>
			<tr><td>操作系统  ：</td><td><s:property value="phoneInfo.sysTypeId" /></td></tr>
			<tr><td>当前飞信版本  ：</td><td><s:property value="phoneInfo.sysVsersion" /></td></tr>
			<tr><td>手机配件：</td><td><s:property value="phoneInfo.parts" />&nbsp;</td></tr>
			<tr><td>借用者：</td><td><s:property value="phoneInfo.userId" />&nbsp;</td></tr>
			<tr>
				<td>预计归还日期</td>
				<td><s:iterator value="borrowList">
						<s:property value="borrowInfo.plan_date" />
					</s:iterator>&nbsp;</td>
			</tr>
			<tr><td>版本下载：</td><td><a href="\\WANGLE-1\software\">点击下载</a>&nbsp;</td></tr>
			<tr><td>备注：</td><td><s:property value="phoneInfo.remarks" />&nbsp;</td></tr>
				</tbody>
<%-- 		<s:property value="phoneInfo.sysAllVersion" /> --%>
	</table>
	<br>
	<div align="center" width="90%">
	<s:if test="phoneInfo.inuse==0"><a href="../borrow/borrowPhoneInit.action?itemId=<s:property value="phoneInfo.id" />">[ 借用]</a></s:if>
	<a href="../borrow/searchBorrow.action?itemId=<s:property value="phoneInfo.id" />">[ 借用历史]</a>
	<a href="getPhoneList.action">[ 返回 ]</a>
	</div>
	
	
</body>
</html>