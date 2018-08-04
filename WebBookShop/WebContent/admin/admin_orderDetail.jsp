<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@include file="../common/taglib.jsp" %> 
<html>
<head>
<title>订单详情表</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath }/admin/css/style.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/admin/css/lqy_style.css"
	rel="stylesheet" type="text/css" />
</head>
<body>
<br>
<table align="center" border="0" width="580px" cellpadding="0" cellspacing="0">
	<tr class="lqy_productCart_thead">
		<td class="lqy_productCart_thead">订单ID</td>
		<td class="lqy_productCart_thead">${order.orderId} <input type="hidden" name="orderid" value="${order.orderId}"></td>
		<td class="lqy_productCart_thead">用户名:</td>
		<td class="lqy_productCart_thead">${order.user.userName}</td>
	</tr>
	<tr>
		<td class="lqy_productCart_thead">地址:</td>
		<td class="lqy_productCart_thead">${order.user.userAddress }</td>
		<td class="lqy_productCart_thead">邮箱:</td>
		<td class="lqy_productCart_thead">${order.user.userEmail}</td>
	</tr>
	<tr>
		<td class="lqy_productCart_thead">商品名称</td>
		<td class="lqy_productCart_thead">单价</td>
		<td class="lqy_productCart_thead">数量</td>
		<td class="lqy_productCart_thead">&nbsp;</td>

	</tr>
	<c:forEach items="${orderDetailList}" var="orderDetail">
		<tr>
			<td>${orderDetail.book.bookName}</td>
			<td>￥${orderDetail.book.bookPrice}</td>
			<td>${orderDetail.count}</td>
			<td>&nbsp;</td>
		</tr>
	</c:forEach>

	<tr>
		<td colspan="6" class="lqy_productCart_totalCost"><span
			id="showTotalCost">总价：￥${totalMoney}</span>&nbsp;&nbsp;</td>
	</tr>
	<tr><td colspan="6" height="10px"></td></tr>
	<tr>
		<td colspan="6" style="text-align: center;"><input
			type="button" onclick="history.back();" name="submit" value="返回" /></td>
	</tr>
</table>
</body>
</html>
