<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑手机卡详情</title>
<script
	src="<%=request.getContextPath()%>/common/js/jquery-1.3.2.min.js"
	type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/common/js/initTime.js"
	type="text/javascript"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/common/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
/* 	$(document).ready(function() {
		initDate($("#planDate"));
	}); */
	function mysubmit() {
		if (document.getElementById("cardId").value == "") {
			alert("请选择要更改的手机卡 ");
			return false;
		}
		document.myform.submit();
	}

</script>
</head>
<body>
	<s:form name="myform" method="post" theme="simple"
		action="ModifyCard.action">
		<table align="center" width="50%" cellspacing="0" cellpadding="1"
			border="1">
			<thead>
				<tr>
					<th colspan="2">编辑手机卡详情：</th>
				</tr>
			</thead>
			<tbody>
			<s:hidden name="borrowType"   value="1"></s:hidden>
			<s:hidden name="borrowItem" value="card"></s:hidden>
				<tr>
					<td width="20%">手机卡编号：</td>
					<td><s:textfield readonly="true" id="cardId" name="cardInfo.id" />
<%-- 					<td><s:textfield readonly="true" id="cardId" name="cardInfo.itemId" /> --%>
						<!-- 							<input type="button" value="选择" onclick="getPhone();"></input> -->
					</td>
				</tr>
				<tr>
					<td>手机卡号：</td>
					<td><s:textfield readonly="true" theme="simple" name="cardInfo.phone_no"
							id="phone_no" /> &nbsp;</td>
				</tr>
				<tr>
					<td>手机灰度：</td>
					<td><s:textfield readonly="false" theme="simple" name="cardInfo.isgray"
							id="isgray" /> &nbsp;</td>
				</tr>
            	<td>site：</td>
					<td><s:textfield readonly="false" theme="simple" name="cardInfo.site"
							id="site" /> &nbsp;</td>
				</tr>
				<tr>
					<td>pool：</td>
					<td><s:textfield readonly="false" theme="simple" name="cardInfo.pool"
							id="pool"/> &nbsp;</td>
				</tr>
			

				

			</tbody>
		</table>
		<br>
		<div align="center" width="90%">
			<a href="#" onclick=mysubmit();;>[ 提交 ]</a>&nbsp;&nbsp;<a
				href="../card/getCardList.action">[ 返回 ]</a>
		</div>
	</s:form>
</body>
</html>