<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/admin/css/style.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<center>
		<table border="1" width="80%" cellpadding="0" cellspacing="0">

			<tr>
				<td height="27px" style="border-color: #F6F6F6;">类别编号</td>
				<td style="border-color: #F6F6F6;">类别名称</td>
				<td style="border-color: #F6F6F6;">操作</td>
			</tr>

			<c:forEach items="${productclasslist}" var="booktype">
				<tr>
					<td height="27px" style="border-color: #F6F6F6;">
						${booktype.typeId}</td>
					<td style="border-color: #F6F6F6;">${booktype.typeName}</td>

					<td style="border-color: #F6F6F6;"><a
						href="${pageContext.request.contextPath}/BookClassActionServlet?action=delete&id=${booktype.typeId }">删除</a>
						| <a
						href="${pageContext.request.contextPath}/BookClassActionServlet?action=gotoModify&id=${booktype.typeId}">修改</a>
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


		<a href="${pageContext.request.contextPath}/admin/admin_classModif.jsp">增加类别</a>

	</center>
</body>
</html>