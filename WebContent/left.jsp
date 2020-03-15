<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;  charset=UTF-8">
<title>设备管理系统（DM）</title>
<style>
body {
	font-size: 15px;
	color: #000000;
	border: none;
	padding: 0px;
	margin: 0px
}

.glob {
	
}

.glob ul {
	padding-top: 14px;
	padding-left: 20px;
	margin: 0px
}

.glob ul li {
	padding-right: 15px;
	font-size: 14px;
}

.glob ul li a {
	text-decoration: none
}
</style>
</head>

<body bgcolor="Beige">

	<div class="glob">
		<ul>

			<li><s:if test="#session.userSession.isAdmin==1">你好，管理员！  <s:property
						value="%{#session.userSession.userName}" />。 </s:if> <s:else>欢迎，<s:property
						value="%{#session.userSession.userName}" />
				</s:else></li>
			<li><a href="phone/getPhoneList.action" target="right">查看手机列表</a></li>

			<li><a href="card/getCardList.action" target="right">查看手机卡列表</a></li>
			<li><a
				href="borrow/selectUserBorrow.action?endUser=<s:property value="%{#session.userSession.userid}" />"
				target="right">我的借用</a></li>

			<s:if test="#session.userSession.isAdmin==1">
				<li><a href="borrow/selectBorrow.action" target="right">审核信息</a></li>
				<li><a href="user/changeAdmin.jsp" target="right">变更管理员</a><br></li>
				<li><a href="phone/addPhoneInfoInit.action" target="right">添加手机</a></li>
			</s:if>




			<li><a href="logout.action" target="_top">退出</a></li>
		</ul>
	</div>


</body>
</html>
