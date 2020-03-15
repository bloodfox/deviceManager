<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>设备管理系统</title>
<script language="JavaScript1.2" type="text/javascript">
	function initHtmlPage() {
		document.all.user_id.focus();
	}
	function _doSubmit() {
		document.form1.submit();
		return false;
	}
	function _doReset() {
		document.form1.user_id.value = "";
		document.form1.password.value = "";
		return false;
	}
</script>
<script language="javascript" for="document" event="onkeydown">
	if (event.keyCode == 13 && event.srcElement.id != "reset") {
		event.keyCode = 9;
		document.form1.submit();
		return false;
	}
</script>
<style type="text/css">
a {
	color: #008EE3
}

a:link {
	text-decoration: none;
	color: #008EE3
}

A:visited {
	text-decoration: none;
	color: #666666
}

A:active {
	text-decoration: underline
}

A:hover {
	text-decoration: underline;
	color: #0066CC
}

A.b:link {
	text-decoration: none;
	font-size: 12px;
	font-family: "Helvetica,微软雅黑,宋体";
	color: #FFFFFF;
}

A.b:visited {
	text-decoration: none;
	font-size: 12px;
	font-family: "Helvetica,微软雅黑,宋体";
	color: #FFFFFF;
}

A.b:active {
	text-decoration: underline;
	color: #FF0000;
}

A.b:hover {
	text-decoration: underline;
	color: #ffffff
}

.table1 {
	border: 1px solid #CCCCCC;
}

.font {
	font-size: 12px;
	text-decoration: none;
	color: #999999;
	line-height: 20px;
}

.input {
	font-size: 12px;
	color: #999999;
	text-decoration: none;
	border: 0px none #999999;
}

td {
	font-size: 12px;
	color: #007AB5;
}

input {
	border: 0px;
	height: 26px;
	color: #007AB5;
}

.unnamed1 {
	border: thin none #FFFFFF;
}

.unnamed1 {
	border: thin none #FFFFFF;
}

select {
	border: 1px solid #cccccc;
	height: 18px;
	color: #666666;
}

.unnamed1 {
	border: thin none #FFFFFF;
}

body {
	background-repeat: no-repeat;
	background-color: #F0F8FF;
	background-position: 0px 0px;
}

.tablelinenotop {
	border-top: 0px solid #CCCCCC;
	border-right: 1px solid #CCCCCC;
	border-bottom: 0px solid #CCCCCC;
	border-left: 1px solid #CCCCCC;
}

.tablelinenotopdown {
	border-top: 1px solid #eeeeee;
	border-right: 1px solid #eeeeee;
	border-bottom: 1px solid #eeeeee;
	border-left: 1px solid #eeeeee;
}


</style>
</head>
<body onLoad="initHtmlPage();">

	<s:form name="form1" method="post" theme="simple" action="login"
		target="_top" namespace="/">
		<table border="0" align="center" cellpadding="0" cellspacing="0"
			style="margin-top: 175px;">
			<tr>
				<td><h2 align="center">设备管理系统（DM）</h2></td>
			</tr>
			<tr>

				<td width="220" background="Images/login_2.gif">
					<table width="0" height="0" border="0" align="center"
						cellpadding="2" cellspacing="0">
						<tr>
							<td height="50" colspan="2" align="left">&nbsp;</td>
						</tr>
						<tr>
							<td width="60" height="30" align="left">登录名称</td>
							<td><s:textfield name="userId" id="user_id" theme="simple"
									size="14"
									cssStyle="background:url(Images/login_6.gif) repeat-x; border:solid 1px #27B3FE; height:20px; background-color:#FFFFFF" /></td>
						</tr>
						<tr>
							<td width="60" height="30" align="left">登录密码</td>
							<td><s:password name="passwd" id="password" theme="simple"
									size="16"
									cssStyle="background:url(Images/login_6.gif) repeat-x; border:solid 1px #27B3FE; height:20px; background-color:#FFFFFF" /></td>
						</tr>

						<tr>
							<td colspan="2" align="center"><input type="submit"
								name="submit"
								style="background: url(Images/login_5.gif) no-repeat"
								value=" 登 录  "> <input type="button" name="reg"
								onclick=" window.location.href='http://10.10.208.129/WebSite/Admin/Login.aspx'"
								style="background: url(Images/login_5.gif) no-repeat; cursor: pointer"
								value=" 注 册  "></td>
						</tr>
						<tr>
							<td height="5" colspan="2"></td>
						</tr>
					</table>
				</td>

			</tr>

		</table>
	</s:form>
</body>
</html>