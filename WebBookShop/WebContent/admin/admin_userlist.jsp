<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/taglib.jsp" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form  action="" name="form1" id="form1" method="post">
		<center>
			<br />
			<br />
			<font color="red">${msg}</font>
			<table width="90%" border="1">
				<tr>
					<th>用户编号</th>
					<th>用户名称</th>
					<th>用户密码</th>
					<th>用户EMAIL</th>
					<th>用户手机号码</th>
					<th>用户地址</th>
					<th>注册时间</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${userList}" var="user">
					<tr>
						<td>${user.userId }</td>
						<td>${user.userName }</td>
						<td>${user.userPasswd }</td>
						<td>${user.userEmail }</td>
						<td>${user.userTelephone }</td>
						<td>${user.userAddress }</td>
						<td>${user.postTime }</td>
						<td>
							<a href="UserActionServlet?id=${user.userId}&action=delete">删除</a>|
							<a href="UserActionServlet?id=${user.userId}&action=initPwd">初始化密码</a>
						</td>
					</tr>
				</c:forEach>


			</table>

			
		</center>
	</form>
</body>
</html>