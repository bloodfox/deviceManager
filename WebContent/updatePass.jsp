<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新用户注册</title>
<script type="text/javascript">
function goSubmit(){
	var userid = document.getElementById("user_id").value;
	var pass = document.getElementById("password").value;
	var pass1 = document.getElementById("password1").value;
	var pass2 = document.getElementById("password2").value;
	if(pass==""){
		alert("请输入原有密码");
		return false;
	}
	if(pass1!=pass2){
		alert("请确认两次输入的密码是否一致");
		return false;
	}
	document.form1.submit();
	return false;
}
</script>
</head>
<body>
  <s:form name="form1" method="post" theme="simple" action="updatePass.action" target="_top" namespace="/">
	<table align="center" width="90%" cellspacing="0" cellpadding="1" border="1">
		<thead>
			<tr><th colspan="2">修改密码：</th></tr>
		</thead>
		<tbody>
			<tr><td width="20%">登录名：</td><td><s:textfield readonly="true" id="user_id" name="userId" value="%{#session.userSession.userName}" /></td></tr>
			<tr><td>原有密码：</td><td><s:password id="password" name="passwd" /></td></tr>
			<tr><td>新的密码：</td><td><s:password id="password1" name="passwdnew" /></td></tr>
			<tr><td>重复密码：</td><td><s:password id="password2" /></td></tr>
		</tbody>
<%-- 		<s:property value="phoneInfo.sysAllVersion" /> --%>
	</table>
	<br>
	<div align="center" width="90%">
	<a href="#" onclick="goSubmit();">[ 修改密码 ]</a>
	&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="./login.jsp">[ 返回 ]</a>
	</div>
	
	</s:form>
</body>
</html>