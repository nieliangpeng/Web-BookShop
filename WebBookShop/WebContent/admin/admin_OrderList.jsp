<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="../common/taglib.jsp" %> 
<c:set var="path_" value="${pageContext.request.contextPath}" scope="application"></c:set>
<c:set var="path" value="${pageContext.request.contextPath}/admin" scope="application"></c:set>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>订单详情表</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<br>
<table align="center" border="1" width="80%" cellpadding="0"  cellspacing="0" style="text-align: center;">
	<tr>
		<th colspan="6" height="27px" style="border-color: #88F6F3;color: #000080;">订单列表</th>
	</tr>
	<tr>
		<td height="27px" style="border-color: #F6F6F6;">订单ID</td>
		<td style="border-color: #F6F6F6;">客户</td>
		<td style="border-color: #F6F6F6;">下单时间</td>
		<td style="border-color: #F6F6F6;">订单状态</td>
		<td style="border-color: #F6F6F6;">操作&nbsp;</td>
	</tr>
	<c:forEach items="${orderList}" var="order">
		<tr>
			<td height="27px" style="border-color: #F6F6F6;">${order.orderId}</td>
			<td style="border-color: #F6F6F6;">${order.user.userName}</td>
			<td style="border-color: #F6F6F6;">${order.orderTime}</td>
			<td style="border-color: #F6F6F6;">${order.orderState}</td>
			<td style="border-color: #F6F6F6;"><a href="${pageContext.request.contextPath}/OrderActionServlet?action=detailed&id=${order.orderId}">详情</a>|
				<c:if test="${order.orderState=='未支付'}">
					<a href="${pageContext.request.contextPath}/OrderActionServlet?action=delete&id=${order.orderId}">删除</a>|
				</c:if> 
				<c:if test="${order.orderState=='已支付'}">
					<a href="${pageContext.request.contextPath}/OrderActionServlet?action=endTheOrder&id=${order.orderId}">发货</a>|
				</c:if>
			</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>
