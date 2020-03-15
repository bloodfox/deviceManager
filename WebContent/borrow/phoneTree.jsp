<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%

    response.setHeader("Pragma", "no-cache");
    response.setHeader("Cache-Control", "no-cache, no-store, max-age=0, must-revalidate");
    response.setDateHeader("Expires", 0);

%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>手机列表</title>
		<script
	src="<%=request.getContextPath()%>/common/js/jquery-1.3.2.min.js"
	type="text/javascript"></script>
		<script type="text/javascript">
	function getDetail(id) {
		document.getElementById("myform").action = "../phone/getPhoneInfo.action?id="
				+ id;
		document.getElementById("myform").submit();
	}
	function goSubmit(){
		var 
	phoneId = $("input:checked").val();
		parent.window.returnValue = phoneId;
		window.close();
	}
</script>
	</head>
	<body onLoad="initHtmlPage();"  bgcolor="#F0F8FF" >
		<s:form id="myform" method="post" theme="simple">
			<table align="center" width="100%" cellspacing="0" cellpadding="1"
				border="1">
				<thead>
					<tr>
						<th>
							选择
						</th>
						<th>
							手机品牌
						</th>
						<th>
							手机型号
						</th>
						<th>
							是否借用
						</th>
						<th>
							查看详情
						</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="phoneList">
						<tr align="center">
							<td>
								<input type="radio" name="phoneId" value="<s:property value="id" />,<s:property value='model' />,<s:property value='brand' />">
							</td>
							<td>
								<s:property value="brand" />
							</td>
							<td>
								<s:property value="model" />
							</td>
							<td>
							<s:if test="inuse==0">未借用</s:if>
							</td>
							<td>
								<a href="#" onclick="getDetail('<s:property value="id" />' )">查看</a>
							</td>
						</tr>
					</s:iterator>
					<tr><td colspan="5" align="center">[ <a href="#" onclick="return goSubmit();">确定</a>  ]</td></tr>
				</tbody>
			</table>
		</s:form>
	</body>
</html>