<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:set var="path" value="${pageContext.request.contextPath}/user"
	scope="application"></c:set>
<c:set var="path_" value="${pageContext.request.contextPath}"
	scope="application"></c:set>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>生成订单</title>
<link rel="stylesheet" type="text/css" href="${path}/css/style.css" />
<link href="${path}/css/style_1.css"
	rel="stylesheet" type="text/css" />
<link href="${path}/css/lqy_style.css"
	rel="stylesheet" type="text/css" />
</head>
<body>
	<div id="wrap">
		<%@include file="top.jsp"%>
		<div class="center_content">
			<div class="left_content">
				<font color="red">${msg}</font>
				<table align="center" border="0" width="450px" cellpadding="0" cellspacing="0">
					<tr class="lqy_productCart_thead">
						<td class="lqy_productCart_thead">订单ID</td>
						<td class="lqy_productCart_thead">${order.orderId} <input type="hidden" name="orderid" value="${order.orderId}"></td>
						<td class="lqy_productCart_thead">用户名:</td>
						<td class="lqy_productCart_thead">${order.user.userName}</td>
						<td class="lqy_productCart_thead">&nbsp;</td>
					</tr>
					<tr>
						<td class="lqy_productCart_thead">地址:</td>
						<td class="lqy_productCart_thead">${order.user.userAddress }</td>
						<td class="lqy_productCart_thead">邮箱:</td>
						<td class="lqy_productCart_thead">${order.user.userEmail}</td>
						<td class="lqy_productCart_thead">&nbsp;</td>
					</tr>
					<tr>
						<td class="lqy_productCart_thead">商品名称</td>
						<td class="lqy_productCart_thead">单价</td>
						<td class="lqy_productCart_thead">数量</td>
						<td class="lqy_productCart_thead">价格</td>
						<td class="lqy_productCart_thead">&nbsp;</td>
				
					</tr>
					<c:forEach items="${orderDetailList}" var="orderDetail">
						<tr style="height: 50px;">
							<td>${orderDetail.book.bookName}</td>
							<td>￥${orderDetail.book.bookPrice}</td>
							<td>${orderDetail.count}</td>
							<td>￥${orderDetail.book.bookPrice*orderDetail.count}</td>
							<td >
								<img alt="图片" src="${pageContext.request.contextPath}/${orderDetail.book.bookImgurl} "style="width: 40px;height: 50px;"/>
							</td>
						</tr>
					</c:forEach>
				
					<tr>
						<td colspan="6" class="lqy_productCart_totalCost"><span
							id="showTotalCost">总价：￥${totalMoney}</span>&nbsp;&nbsp;</td>
					</tr>
					<tr><td colspan="6" height="10px"></td></tr>
					<tr>
						<td colspan="6" style="text-align: center;">
							<a href="${path_}/OrderActionServlet?action=getMoney&orderid=${order.orderId}" style="font-size: 10px;font-weight:bolder;color: #f8981d;">付款 </a>
							<a href="${path_}/shopCartActionServlet?action=view" style="font-size: 10px;font-weight:bolder;color: #f8981d;">返回购物车 </a>
						</td>
					</tr>
				</table>
				<div class="clear"></div>
			</div>
			<!-- 右边 -->
			<%@include file="content_right.jsp"%>
		</div>
		<%@include file="bottom.jsp"%>
	</div>
</body>
</html>