<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/taglib.jsp" %>
<c:set var="path" value="${pageContext.request.contextPath}/user"
	scope="application"></c:set>
<c:set var="path_" value="${pageContext.request.contextPath}"
	scope="application"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<link rel="stylesheet" type="text/css" href="${path}/css/style.css" />
</head>
<body>
	${result}
	<script type="text/javascript">
		function sub() {

			var password = document.getElementById("password");
			var email = document.getElementById("email");
			var verf=document.getElementById("verf");
			if (email.value == "" || email == null) {
				alert("邮箱不可以为空");
				return false;
			}else if (password.value == "" || password == null) {
				alert("密码不可以为空");
				return false;
			}
			else if (verf.value == "" || verf== null) {
				alert("请填写验证码");
				return false;
			}
			return true;
		}
	</script>
	<div id="wrap">
		<%@include file="top.jsp"%>
		<div class="center_content">
			<!-- 左边 -->
			<c:if test="${user!=null }">
				<div class="left_content">
				<p class="details" style="font-size: 20px;">
						<font color="red">欢迎您,${user.userName}<br/><br/>在书的海洋中尽情遨游吧~~~</font>
				</p>
				
				</div>
			</c:if>
			<c:if test="${user==null }">
				<div class="left_content">
				<div class="title">
					<span class="title_icon"><img src="${path}/images/bullet1.gif"
						alt="" title="" /></span>登录
				</div>
				<div class="feat_prod_box_details">
					<p class="details" style="font-size: 20px;">
						<font color="red">亲，先登录吧~</font>
					</p>
					
					<div class="contact_form">
						<div class="form_subtitle">登录账号</div>
						<%
							if(request.getAttribute("msg")!=null){
						%>
							<div  style="margin-left: 80px;"><font color="red">${msg}</div>
						<%		
							} 
						%>
						<form name="register" action="${path_}/checkUserLogin" onsubmit="return sub();">
							<div class="form_row">
								<label class="contact"><strong>邮箱</strong></label> <input
									type="email" name="email" id="email" class="contact_input"
									placeholder=" 输入注册邮箱" " />
							</div>
							<div class="form_row">
								<label class="contact"><strong>密码</strong></label> <input
									type="password" name="password" id="password"
									class="contact_input" placeholder="输入密码"
									 />
							</div>
							<div class="form_row">
								<label class="contact"><strong>验证码</strong></label> 
								<input type="text" name="verf" id="verf" placeholder="输入验证码"/>
								<img alt="验证码" src="${path_}/common/verificationCode.jsp">
							</div>
							<div class="form_row">
								<div class="terms">
									<input type="checkbox"  name="autoLogin"/> 一周内自动登录&nbsp;&nbsp;
									<font color="red"><a href="${path}/FindPassword.jsp">忘记密码</a></font>
								</div>
							</div>
							<div class="form_row">
								<input type="submit" class="register" value="登录"  />
							</div>
						</form>
					</div>
				</div>
				<div class="clear"></div>
			</div>
			</c:if>
			
			<!-- 右边 -->
			<%@include file="content_right.jsp"%>
		</div>
		<%@include file="bottom.jsp"%>
	</div>
</body>
</html>