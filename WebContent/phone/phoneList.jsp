<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>手机列表</title>
<script type="text/javascript">
	function getDetail(id) {
		document.getElementById("myform").action = "getPhoneInfo.action?id="
				+ id;
		document.getElementById("myform").submit();
	}
	function canclePhone(id, itemId, endUser) {
		document.getElementById("myform").action = "cancleBorrow.action?id="
				+ id + "&itemId=" + itemId + "&endUser=" + endUser;
		document.getElementById("myform").submit();
	}
	function returnPhone(id, itemId, endUser) {
		document.getElementById("myform").action = "returnBorrow.action?id="
				+ id + "&itemId=" + itemId + "&endUser=" + endUser;
		document.getElementById("myform").submit();
	}
</script>
</head>
<body onLoad="initHtmlPage();"  bgcolor="#F0F8FF" >
	<s:form id="myform" method="post" theme="simple">
		<table align="center" width="100%" cellspacing="0" cellpadding="1"
			border="1">
			<thead>
				<tr>
					<th>手机编号</th>
					<th>手机品牌</th>
					<th>手机型号</th>
					<th>是否借用</th>
					<th>使用者</th>
					<th>运营商</th>
					<th>操作详情</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="phoneList">
					<tr align="center">
						<td><s:property value="id" /></td>
						<td><s:property value="brand" /></td>
						<td><s:property value="model" /></td>
						<td><s:if test="inuse==0">未借用</s:if> <s:elseif
								test="inuse==1">已申请借用</s:elseif> <s:elseif
								test="inuse==2">已借用</s:elseif> <s:else>已申请归还</s:else></td>
						<td><s:property value="userId" />&nbsp;</td>
						<td><s:property value="isp" />&nbsp;</td>
						<td><a href="#" onclick="getDetail('<s:property value="id" />' )">查看</a>
							<s:if test="inuse==0"><a href="../borrow/borrowPhoneInit.action?itemId=<s:property value="id" />">借用</a></s:if>
							 <s:if
								test="confirmStatus==0">
								<a href="#"
									onclick="canclePhone('<s:property value="id" />','<s:property value="itemId" />','<s:property value="endUser" />' )">撤销申请</a>
							</s:if> <s:elseif test="confirmStatus==1">
								<a href="#"
									onclick="returnPhone('<s:property value="id" />','<s:property value="itemId" />','<s:property value="endUser" />' )">归还手机</a>
							</s:elseif></td>
							<td>
							 <s:if test="#session.userSession.isAdmin==1">       
                              <a href="../phone/ModifyPhoneInit.action?id=<s:property value="id" />" >修改</a>
                             </s:if></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
		<br>
	</s:form>
</body>
</html>