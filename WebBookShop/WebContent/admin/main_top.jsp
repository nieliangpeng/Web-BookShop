<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/taglib.jsp" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台页面头部</title>
<link href="${path}/css/css.css" type="text/css" rel="stylesheet" />
</head>
<body onselectstart="return false" oncontextmenu=return(false)
	style="overflow-x: hidden;">
	<!--禁止网页另存为-->
	<noscript>
		<iframe scr="*.htm"></iframe>
	</noscript>
	<!--禁止网页另存为-->
	<table width="100%" border="0" cellspacing="0" cellpadding="0"
		id="header">
		<tr>
			<td rowspan="2" align="left" valign="top" id="logo"><img
				src="${path}/images/main/logo.png" width="74" height="64"></td>
			<td align="left" valign="bottom">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td align="left" valign="bottom" id="header-name">&nbsp;&nbsp;&nbsp;你好，管理员:${adminUser.adminRealName}</td>
						<td align="right" valign="top" id="header-right"><a
							href="${path_}/checkAdminServlet?action=logout"  onFocus="this.blur()"
							class="admin-out" target="allFrame">退出登录</a> <a href="${path}/main_right.jsp" target="mainFrame"
							onFocus="this.blur()" class="admin-home">管理首页</a> <a
							href="${path_}/user/index.jsp" target="allFrame" onFocus="this.blur()"
							class="admin-index">网站首页</a> <span> <!-- 日历 --> <SCRIPT
									type=text/javascript src="js/clock.js"></SCRIPT> <SCRIPT
									type=text/javascript>
										showcal();
									</SCRIPT>
						</span></td>
					</tr>
				</table>
			</td>
		</tr>

		<tr>
			<td align="left" valign="bottom">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td align="left" valign="top" id="header-admin">&nbsp;&nbsp;&nbsp;后台管理系统</td>

					</tr>
				</table>
			</td>
		</tr>

	</table>
</body>
</html>