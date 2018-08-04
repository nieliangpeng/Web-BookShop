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
<title>找回密码</title>
<link rel="stylesheet" type="text/css" href="${path}/css/style.css" />
</head>
<body>
	
	<script type="text/javascript">
		function sub() {

			var email = document.getElementById("email");
			if (email.value == "" || email == null) {
				alert("邮箱不可以为空");
				return false;
			}
			return true;
		}
	</script>
	${error}
	<div id="wrap">
		<%@include file="top.jsp"%>
		<div class="center_content">
			<!-- 左边 -->
			<div class="left_content">
				<div class="title">
					<span class="title_icon"><img src="${path}/images/bullet1.gif"
						alt="" title="" /></span>找回密码
				</div>
				<div class="feat_prod_box_details">
					<p class="details" style="font-size: 15px;">
						<font color="red">忘记密码了吗？别着急,快输入注册邮箱来找回密码吧！</font>
					</p>
					
					<div class="contact_form">
						<div class="form_subtitle">找回密码</div>
						
						<form name="register" action="${path_}/FindPasswordServlet" onsubmit="return sub();">
							<div class="form_row">
								<label class="contact"><strong>注册时邮箱</strong></label> <input
									type="email" name="email" id="email" class="contact_input"
									placeholder=" 输入注册时邮箱" " required/>
							</div>
							<div>
								<input type="hidden" name="path" value="${path}">
							</div>
							
							<div class="form_row">
								<input type="submit" class="register" value="找回密码"  />
							</div>
						</form>
					</div>
				</div>
			
				
				<div class="clear"></div>
			</div>
			
			
			<!-- 右边 -->
			<%@include file="content_right.jsp"%>
		</div>
		<%@include file="bottom.jsp"%>
	</div>
</body>
</html>