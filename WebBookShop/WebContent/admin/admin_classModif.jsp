<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>增加/修改类别</title>
</head>
<body>
	<c:if test="${msg=='修改'}">
		<font color="red" size="20px;">修改类别</font><br/><br/>
		<form action="${pageContext.request.contextPath}/BookClassActionServlet?action=modify&update=1" method="post">
			类别：<input type="text"  name="type" value="${bookType.typeName}"/>
			<input type="hidden" name="id" value="${bookType.typeId}">
			<br/><br/>
			<input type="submit" value="修改"/><br/><br/>
			<input type="button" name="return" id="return" value="返回" onclick="history.back();"/>
		</form>
	</c:if>
	<c:if test="${msg==null}">
		<font color="red" size="20px;">增加类别</font><br/><br/>
		<form action="${pageContext.request.contextPath}/BookClassActionServlet?action=modify" method="post">
			类别：<input type="text"  name="type" value="${bookType.typeName}"/>
			
			<br/><br/>
			<input type="submit" value="增加"/><br/><br/>
			<input type="button" name="return" id="return" value="返回" onclick="history.back();"/>
		</form>
	</c:if>
</body>
</html>