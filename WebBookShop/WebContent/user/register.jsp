<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${path}/css/style.css" />
<title>注册账号</title>
</head>

<body>
	<script type="text/javascript">
		function sele(){
			if(document.getElementById("terms").checked==false){
				document.getElementById("zhuce").disabled="disabled";
			}else{
				
				document.getElementById("zhuce").disabled=false;
			}
		}
		function checkUsername(){
			var username=document.getElementById("username");
			var username_=/^[0-9a-zA-Z_]{3,10}$/;
			if(username==null || username.value==""){
				alert("用户名不可以为空");
				username.focus();
			}else{
				if(username.value.match(username_)==null){
					username.value="";
					alert("用户名格式不对，重新输入");
					username.focus();
				}else{
					document.getElementById("username_yx").style.display="inline";
				}
			}
		}
		function checkPassword(){
			var password=document.getElementById("password");
			var password_=/^[0-9a-zA-Z_]{3,10}$/;
			if(password==null || password.value==""){
				alert("密码不可以为空");
			}else{
				if(password.value.match(password_)==null){
					password.value="";
					alert("密码格式不对，重新输入");
				}else{
					document.getElementById("password_yx").style.display="inline";
				}
			}
		}
		function checkEmail(){
			var email=document.getElementById("email");
			var email_=/^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$/;
			if(email==null || email.value==""){
				alert("邮箱不可以为空");
			}else{
				if(email.value.match(email_)==null){
					email.value="";
					alert("邮箱格式不对，重新输入");
				}else{
					document.getElementById("email_yx").style.display="inline";
				}
			}
		}
		function checkTelephone(){
			var telephone=document.getElementById("telephone");
			var telephone_=/^\d{11}$/;
			if(telephone==null || telephone.value==""){
				alert("手机号码不可以为空");
			}else{
				if(telephone.value.match(telephone_)==null){
					telephone.value="";
					alert("手机号码格式不对，重新输入");
				}else{
					document.getElementById("telephone_yx").style.display="inline";
				}
			}
		}
		function checkAddress(){
			var address=document.getElementById("address");
			
			if(address==null || address.value==""){
				alert("地址不可以为空");
			}else{
				
				document.getElementById("address_yx").style.display="inline";
				
			}
		}
		function sub() {
			var username = document.getElementById("username");
			var password = document.getElementById("password");
			var email=document.getElementById("email");
			var telephone=document.getElementById("telephone");
			var address=document.getElementById("address");
			if (username.value == "" || username == null) {
				alert("用户名不可以为空");
				return false;
			} else if (password.value=="" || password==null ) {
				alert("密码不可以为空");
				return false;
			} else if (email.value=="" || email==null ) {
				alert("邮箱不可以为空");
				return false;
			} else if (telephone.value=="" || telephone==null ) {
				alert("手机号码不可以为空");
				return false;
			} else if (address.value=="" || address==null ) {
				alert("地址不可以为空");
				return false;
			} 
			return true;
		}
	</script>
	<div id="wrap">
		<%@include file="top.jsp"%>
		<div class="center_content">
			<!-- 右边 -->
			<div class="left_content">
				<div class="title">
					<span class="title_icon"><img src="${path}/images/bullet1.gif"
						alt="" title="" /></span>注册
				</div>
				<div class="feat_prod_box_details">
					<p class="details" style="font-size: 30px;"><font color="red" >快来注册属于你的账号吧~</font></p>
					<div class="contact_form">
						<div class="form_subtitle">创建一个账号</div>
						<%
							if(request.getAttribute("msg")!=null){
						%>
							<div  style="margin-left: 80px;"><font color="red">${msg}</div>
						<%		
							} 
						%>
						<form name="register" action="${path_}/addUserToDBServlet" onsubmit="return sub();">
							<div class="form_row">
								<label class="contact"><strong><font color="red">*</font>用户名:</strong></label> 
								<input type="text" name="username" id="username"  class="contact_input"  placeholder=" 3-10位   数字/字母/下划线"  onchange="checkUsername()"/>
								<div id="username_yx" style="margin-left: 80px;display:none"><font color="green">允许</div>
							</div>
							<div class="form_row">
								<label class="contact"><strong><font color="red">*</font>密码:</strong></label> 
								<input type="password" name="password" id="password" class="contact_input" placeholder=" 3-10位   数字/字母/下划线"  onchange="checkPassword()" />
								<div id="password_yx" style="margin-left: 80px;display:none"><font color="green">允许</div>
							</div>
							<div class="form_row">
								<label class="contact"><strong><font color="red">*</font>邮箱：</strong></label>
								<input type="email" class="contact_input" name="email" id="email" placeholder=" 输入有效的邮箱"  onchange="checkEmail()"/>
								<div id="email_yx" style="margin-left: 80px;display:none"><font color="green">允许</div>	 
							</div>
							<div class="form_row">
								<label class="contact"><strong><font color="red">*</font>手机号码:</strong></label>
								<input type="text" class="contact_input" name="telephone" id="telephone" placeholder=" 输入有效的手机号码" onchange="checkTelephone()"/>
								<div id="telephone_yx" style="margin-left: 80px;display:none"><font color="green">允许</div>
							</div>
							
							<div class="form_row">
								<label class="contact"><strong><font color="red">*</font>地址:</strong></label> <input
								type="text" class="contact_input" name="address" id="address" placeholder=" 输入有效的地址" onchange="checkAddress()"/>
								<div id="address_yx" style="margin-left: 80px;display:none"><font color="green">允许</div>	
							</div>
							<div class="form_row">
								<div class="terms">
									<input type="checkbox" name="terms" id="terms" onchange="sele()"/> 阅读并同意 <a
										href="#">条款 &amp; 条件</a>
								</div>
							</div>
							<div class="form_row">
								<input type="submit" class="register" id="zhuce" disabled="disabled" value="注册" />
							</div>
						</form>
					</div>
				</div>
				<div class="clear"></div>
			</div>
			<%@include file="content_right.jsp"%>
		</div>
		<%@include file="bottom.jsp"%>
	</div>
</body>
</html>