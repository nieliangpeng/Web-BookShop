<%@page import="common.Page"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="../common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品列表</title>
<link href="${pageContext.request.contextPath}/admin/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<center>
		<table border="1" width="80%" cellpadding="0" cellspacing="0">
			<tr>
				<td height="27px" style="border-color: #F6F6F6;">图书ID</td>
				<td style="border-color: #F6F6F6;">图书名称</td>
				<td style="border-color: #F6F6F6;">图书作者</td>
				<td style="border-color: #F6F6F6;">图书出版社</td>
				<td style="border-color: #F6F6F6;">图书价格</td>
				<td style="border-color: #F6F6F6;">图书描述</td>
				<td style="border-color: #F6F6F6;">图书图片</td>
				<td style="border-color: #F6F6F6;">图书类别</td>
				<td style="border-color: #F6F6F6;">操作</td>
			</tr>
			<c:forEach items="${productList}" var="book">
				<tr>
					<td height="27px" style="border-color: #F6F6F6;">${book.bookId}&nbsp;</td>
					<td height="27px" style="border-color: #F6F6F6;">${book.bookName}&nbsp;</td>
					<td height="27px" style="border-color: #F6F6F6;">${book.bookAuthor}&nbsp;</td>
					<td height="27px" style="border-color: #F6F6F6;">${book.bookPublisher}&nbsp;</td>
					<td height="27px" style="border-color: #F6F6F6;">${book.bookPrice}&nbsp;</td>
					<td height="27px" style="border-color: #F6F6F6;">${book.bookDescription}&nbsp;</td>
					<td height="27px" style="border-color: #F6F6F6;">
						<!-- 上传图片显示 -->
						<img height="50" width="40" border="30"
						src="${pageContext.request.contextPath}/${book.bookImgurl}" />&nbsp;
							
					</td>
					<td height="27px" style="border-color: #F6F6F6;">
						${book.bookType.typeName}&nbsp;
					</td>
						<td height="27px" style="border-color: #F6F6F6;">
						<a href="${pageContext.request.contextPath}/BookActionServlet?action=detailed&id=${book.bookId }">详细</a>|
						<a href="${pageContext.request.contextPath}/BookActionServlet?action=delete&id=${book.bookId }">删除</a>|
						<a href="${pageContext.request.contextPath}/BookActionServlet?action=updateSelect&id=${book.bookId }">修改</a>|
						<a href="${pageContext.request.contextPath}/BookActionServlet?action=uploadImage&id=${book.bookId }">更新/上传图片</a>
					</td>
				</tr>
			</c:forEach>

		</table>
		<br />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

		<div id="lqy_product_showpage">
			共${pageCount.recordCount}条记录&nbsp;&nbsp;共 ${pageCount.count}页
			<c:if test="${pageCount.isFirst}">
  				&nbsp;首页&nbsp;&nbsp;
			</c:if>
			<c:if test="${!(pageCount.isFirst)}">
  				&nbsp;<a href='BookActionServlet?action=selectlist&pageNum=1'>首页</a>&nbsp;
  				&nbsp;<a href='BookActionServlet?action=selectlist&pageNum=${pageCount.showPage-1}'>上一页</a>&nbsp;
			</c:if>
			<c:if test="${pageCount.isLast}">
  				&nbsp;尾页&nbsp;&nbsp;
			</c:if>
			<c:if test="${!(pageCount.isLast)}">
	  			&nbsp;<a href='BookActionServlet?action=selectlist&pageNum=${pageCount.showPage+1}'>下一页</a>&nbsp;
	  			&nbsp;<a href='BookActionServlet?action=selectlist&pageNum=${pageCount.count}'>尾页</a>&nbsp;
			</c:if>
			&nbsp;当前页为第 ${pageCount.showPage} 页
		</div>
</body>
</html>