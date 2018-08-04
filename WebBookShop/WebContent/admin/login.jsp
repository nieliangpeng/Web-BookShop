<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/taglib.jsp" %>    
<c:set var="path_" value="${pageContext.request.contextPath}" scope="application"></c:set>
<c:set var="path" value="${pageContext.request.contextPath}/admin" scope="application"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head runat="server">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>后台管理登录界面</title>
    <link href="${path}/css/alogin.css" rel="stylesheet" type="text/css" />
</head>
<body>

	<script type="text/javascript">
		function sub() {

			var password = document.getElementById("pwd");
			var username = document.getElementById("username");
			var verif=document.getElementById("verif");
			if (username.value == "" || username == null) {
				alert("用户名不可以为空");
				return false;
			}if (password.value == "" || password == null) {
				alert("密码不可以为空");
				return false;
			} else if (verif.value == "" || verif== null) {
				alert("请填写验证码");
				return false;
			}
			return true;
		}
	</script>
	
    <form id="form1" runat="server" action="${path_}/checkAdminServlet?action=login" method="post" onsubmit="return sub();">
	    <div class="Main">
	    	
	        <ul>
	            <li class="top"></li>
	            <li class="top2"></li>
	            <li class="topA"></li>
	            <li class="topB"><span><img src="${path}/images/login/logo.png" alt="" style="" /></span></li>
	            <li class="topC"></li>
	            <li class="topD">
	         		<c:if test="${message!=null}">
	         			<font color="red">${message}</font>
	         		</c:if>
	                <ul class="login">
	                    <li><span class="left login-text">用户名：</span> <span style="left">
	                        <input id="username" type="text" class="txt" name="username"/>  
	                     
	                    </span></li>
	                    <li><span class="left login-text">密码：</span> <span style="left">
	                       <input id="pwd" type="password" class="txt" name="pwd" />  
	                    </span></li>
						<li><span class="left login-text">验证码：</span> <span style="left">
	                       <input id="verif" type="text"  name="verif" /> 
	                       <img alt="验证码" src="${path_}/common/verificationCode.jsp"> 
	                    </span></li>
	                </ul>
	            </li>
	            <li class="topE"></li>
	            <li class="middle_A"></li>
	            <li class="middle_B"></li>
	            <li class="middle_C">
	            <span class="btn"><input value="登录" type="submit"  class="button"/></span>
	            <span class="btn"><input type="checkbox"  name="autoLogin"/> 一周内自动登录&nbsp;&nbsp;</span>
					<br/><br/>				
	            <span class="btn"><font color="red"><a href="${path}/findPassword.jsp">忘记密码</a></font>
	            </span>
	            </li>
	            <li class="middle_D"></li>
	            <li class="bottom_A"></li>
	            <li class="bottom_B">网站后台管理系统&nbsp;&nbsp;www.php.com</li>
	        </ul>
	    </div>
    </form>
</body>
</html>