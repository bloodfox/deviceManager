<%@ page contentType="text/html;charset=utf-8" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!--<%-->
<!---->
<!--    response.setHeader("Pragma", "no-cache");-->
<!--    response.setHeader("Cache-Control", "no-cache, no-store, max-age=0, must-revalidate");-->
<!--    response.setDateHeader("Expires", 0);-->
<!---->
<!--%>-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML> 
<HEAD> 
<TITLE>设备管理系统（DM）</TITLE> 
</HEAD>
<frameset rows="95,*" framespacing="1" frameborder="yes" border="1" bordercolor="#9493cf">
<frame name="top" src="<%=basePath %>top.jsp" scrolling="no" frameborder="0" marginwidth="0" marginheight="0"> 
<frameset cols="220,*" framespacing="0" frameborder="yes" > 
	<frame name="left" src="<%=basePath %>left.jsp"> 
	<frame name="right" id="right" src="<%=basePath %>/phone/getPhoneList.action"  noresize="noresize"  marginwidth="1" marginheight="1" scrolling="yes"> 
</frameset> 
</frameset>
</HTML>  