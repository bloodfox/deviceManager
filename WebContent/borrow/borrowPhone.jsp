<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>借用手机详情</title>
<script
	src="<%=request.getContextPath()%>/common/js/jquery-1.3.2.min.js"
	type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/common/js/initTime.js"
	type="text/javascript"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/common/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		initDate($("#planDate"));
	});
	function mysubmit() {
		if (document.getElementsByName("itemId")[0].value == "") {
			alert("请选择要借用的手机");
			return false;
		}
		document.myform.submit();
	}
	function getPhone() {
		var tmp = window.showModalDialog("selectPhone.action", "",
				"dialogWidth=1002px;dialogHeight=600px;status=0");
		var strs = new Array()
		strs = tmp.split(",");
		$("#phoneId").attr("value", strs[0]);
		$("#model").attr("value", strs[1]);
		$("#brand").attr("value", strs[2]);
		return false;
	}
</script>
</head>
<body>
	<s:form name="myform" method="post" theme="simple"
		action="borrowPhone.action">
		<table align="center" width="90%" cellspacing="0" cellpadding="1"
			border="1">
			<thead>
				<tr>
					<th colspan="2">借用手机详情：</th>
				</tr>
			</thead>
			<tbody>
			
						<s:hidden name="borrowType"   value="1"></s:hidden>
			<s:hidden name="borrowItem" value="phone"></s:hidden>
				<tr>
					<td width="20%">手机编号：</td>
					<td><s:textfield readonly="true" id="phoneId" name="itemId" />
						<!-- 							<input type="button" value="选择" onclick="getPhone();"></input> -->
					</td>
				</tr>
				<tr>
					<td>手机品牌：</td>
					<td><s:textfield readonly="true" theme="simple" name="brand"
							id="brand" /> &nbsp;</td>
				</tr>
				<tr>
					<td>手机型号：</td>
					<td><s:textfield readonly="true" theme="simple" name="model"
							id="model" /> &nbsp;</td>
				</tr>
				<tr>
					<td>借用者：</td>
					<td><s:textfield readonly="true" theme="simple" name="endUser"
							value="%{#session.userSession.userName}" /> &nbsp;</td>
				</tr>

				<tr>
					<td>预计归还日期：</td>
					<td><s:textfield id="planDate" name="planDate"
							cssClass="Wdate"
							onfocus="WdatePicker({el:this,dateFmt:'yyyy-MM-dd'})" />
						&nbsp;(格式：2012-05-02)</td>
				</tr>

			</tbody>
		</table>
		<br>
		<div align="center" width="90%">
			<a href="#" onclick=mysubmit();;>[ 提交 ]</a>&nbsp;&nbsp;<a
				href="../phone/getPhoneList.action">[ 返回 ]</a>
		</div>
	</s:form>
</body>
</html>