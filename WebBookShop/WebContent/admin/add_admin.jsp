<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加管理员</title>
<script type="text/javascript" language="javascript">
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
		}
	}
}
function addbt(){
	  if(document.getElementById("username").value==""){
	   		alert("用户名不能为空！");
	   		document.getElementById("username").focus();
	   		return false;
	  }else if(document.getElementById("password").value==""){
	   		alert("密码框不能为空！");
	   		document.getElementById("password").focus();
	   		return false;
	  }else if(document.getElementById("password_r").value==""){
	   		alert("重复密码框不能为空！");
	   		document.getElementById("password_r").focus();
	   		return false;
	  }else if(document.getElementById("password").value!=document.getElementById("password_r").value){
	  		alert("两次输入密码不一样！");
	  		document.getElementById("password_r").focus();
	  		return false;
	  }else{ 
		  return true;
	  }
}
   
</script>
</head>
<body>
	<center>
		<form action="${pageContext.request.contextPath}/adminActionServlet?action=add" name="addform" id="addform" method="post" onsubmit="return addbt();"><br />
			<br />
			<table border="0">
				<tr>
					<td>管理员用户名:</td>
					<td><input type="text" name="username" id="username" onchange="checkUsername();"/></td>
				</tr>
				<tr>
					<td>管理员密码:</td>
					<td><input type="password"" name="password" id="password" onchange=" checkPassword();"/></td>
				</tr>
				<tr>
					<td>重复管理员密码:</td>
					<td><input type="password"" name="password_r" id="password_r" /></td>
				</tr>
					<tr>
					<td>管理员真实姓名:</td>
					<td><input type="text" name="realname" id="realname" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" name="bt1" id="bt1" value="添加管理员"  />
					 <input type="reset" name="bt2" id="bt2" value="重置" /> 		
					 </td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>