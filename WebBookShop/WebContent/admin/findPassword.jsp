<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/taglib.jsp" %>    
<c:set var="path_" value="${pageContext.request.contextPath}" scope="application"></c:set>
<c:set var="path" value="${pageContext.request.contextPath}/admin" scope="application"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="UTF-8">
<title>找回密码界面</title>
<link href="css/default.css" rel="stylesheet" type="text/css" />
<!--必要样式-->
<link href="${path}/css/styles.css" rel="stylesheet" type="text/css" />
<link href="${path}/css/demo.css" rel="stylesheet" type="text/css" />
<link href="${path}/css/loaders.css" rel="stylesheet" type="text/css" />
</head>
<body>
	${error}
	<div class='login'>
		<div class='login_title'>
			<span>找回密码</span>
		</div>
		<div class='login_fields'>
			<!-- 表单 -->
			<form action="${path_}/findAdminPasswordServlet" method="post">
				<div class='login_fields__user'>
					<div class='icon'>
						<img alt="" src='${path}/img/user_icon_copy.png'>
					</div>
					<input name="username" placeholder='用户名' maxlength="16" type='text'
						autocomplete="off"  required/>
					<div class='validation'>
						<img alt="" src='${path}/img/tick.png'>
					</div>
				</div>


				<div class='login_fields__submit'>
					<input type='submit' value='找回密码'>
				</div>
			</form>
		</div>
		<div class='success'></div>
		<div class='disclaimer'>
			<p>
				欢迎登录后台管理系统
			</p>
		</div>
	</div>


</body>
</html>
