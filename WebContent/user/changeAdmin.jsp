<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更换管理员</title>
<script type="text/javascript">
	function mysubmit() {
		if(document.getElementsByName("userId")[0].value==""){
			alert("请填写要转变为管理员的用户名");
			return false;
		}
		document.myform.submit();
	}
</script>
</head>
<body onLoad="initHtmlPage();"  bgcolor="#F0F8FF" >
<s:form name="myform" method="post" action="../changeUser.action" theme="simple" target="_top" >
	<table align="center" width="90%" cellspacing="0" cellpadding="1" border="1">
		<thead>
			<tr><th colspan="2">更换管理员：</th></tr>
		</thead>
		<tbody>
			<tr><td width="20%">要更换为管理员的用户名：</td><td><s:textfield name="userId" /></td></tr>
			<s:hidden name="adminId" value="%{#session.userSession.userid}" ></s:hidden>
		</tbody>
	</table>
	<br>
	<div align="center" width="90%">
	<a href="#" onclick="return mysubmit();">[ 提交 ]</a>
	&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="../phone/getPhoneList.action">[ 返回 ]</a>
	</div>
	
</s:form>
</body>
</html>