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
<title>我的所有订单</title>
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
				
					
					
				<table align="center" border="1" width="80%" cellpadding="0"  cellspacing="0" style="text-align: center;">
					
					<tr>
						<th colspan="4" height="27px" style="border-color: #88F6F3;color: #000080;">订单列表</th>
					</tr>
					<tr>
						<td height="27px" style="border-color: #F6F6F6;">订单ID</td>
						
						<td style="border-color: #F6F6F6;">下单时间</td>
						<td style="border-color: #F6F6F6;">订单状态</td>
						<td style="border-color: #F6F6F6;">操作&nbsp;</td>
					</tr>
					
					<c:if test="${MyorderList!=null}">
						<c:forEach items="${MyorderList}" var="order">
							<tr>
								<td height="27px" style="border-color: #F6F6F6;">${order.orderId}</td>
								
								<td style="border-color: #F6F6F6;">${order.orderTime}</td>
								<td style="border-color: #F6F6F6;">${order.orderState}</td>
								<td style="border-color: #F6F6F6;"><a href="${pageContext.request.contextPath}/OrderActionServlet?action=Mydetailed&id=${order.orderId}">详情</a>|
									<c:if test="${order.orderState=='未支付'}">
										<a href="${pageContext.request.contextPath}/OrderActionServlet?action=Userdelete&id=${order.orderId}">删除</a>|
									</c:if> 
									
								</td>
							</tr>
						</c:forEach>
					</c:if>
					
				</table>
				<br/><br/>
				<c:if test="${MyorderList==null}">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<font color="red">现在还没有订单呢！快去下单吧</font>
				</c:if>
				<div class="clear"></div>
			</div>
			<!-- 右边 -->
			<%@include file="content_right.jsp"%>
		</div>
		<%@include file="bottom.jsp"%>
	</div>
</body>
</html>