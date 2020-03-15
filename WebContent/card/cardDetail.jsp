<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>手机卡详情</title>
</head>
<body>
	<table align="center" width="90%" cellspacing="0" cellpadding="1" border="1">
		<thead>
			<tr><th colspan="2">手机卡详情：</th></tr>
		</thead>
		<tbody>
			<tr><td width="20%">手机卡编号：</td><td><s:property value="cardInfo.id" /></td></tr>
			<tr><td>手机卡号：</td><td><s:property value="cardInfo.phone_no" /></td></tr>
			<tr><td>手机卡归属省：</td><td><s:property value="cardInfo.province" /></td></tr>
			<tr><td>手机卡Site：</td><td><s:property value="cardInfo.site" /></td></tr>
			<tr><td>手机卡Pool：</td><td><s:property value="cardInfo.pool" /></td></tr>
			<tr><td>手机卡运营商：</td><td><s:property value="cardInfo.card_isp" /></td></tr>
			<tr><td>手机卡业务类型：</td><td><s:property value="cardInfo.fee_sign" /></td></tr>
			<tr><td>手机卡余额：</td><td><s:property value="cardInfo.balance" /></td></tr>
			<tr><td>手机卡灰度信息：</td><td><s:property value="cardInfo.isgray" /></td></tr>
			<tr><td>是否借用：</td><td><s:if test="cardInfo.inuse==0">未借用</s:if><s:elseif test="inuse==1">申请借用</s:elseif><s:else>已借用</s:else></td></tr>
			<tr><td>借用者：</td><td><s:property value="cardInfo.userId" />&nbsp;</td></tr>
			<tr>
				<td>预计归还日期</td>
				<td><s:iterator value="borrowList">
						<s:property value="borrowInfo.plan_date" />
					</s:iterator>&nbsp;</td>
			</tr>
		
			<tr><td>备注：</td><td><s:property value="cardInfo.remarks" />&nbsp;</td></tr>
				</tbody>
	</table>
	<br>
	<div align="center" width="90%">
	<s:if test="cardInfo.inuse==0"><a href="../borrow/borrowCardInit.action?itemId=<s:property value="cardInfo.id" />">[ 借用]</a></s:if>
	<a href="../borrow/searchCardBorrow.action?itemId=<s:property value="cardInfo.id" />">[ 借用历史]</a>
	<a href="getCardList.action">[ 返回 ]</a>
	</div>
	
	
</body>
</html>