<%@page import="bean.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/taglib.jsp" %>
<div class="header">
    <div class="logo"><a href="${path}/index.jsp"><img src="${path}/images/logo.gif" alt="" title="" border="0" /></a></div>
    <div id="menu">
      <ul>
       
        <li class="selected"><a href="${path}/index.jsp">首页</a></li>
        <li><a href="about.htm">关于我们</a></li>
        <li><a href="${path_}/bookFactoryServlet?action=factory">书库</a></li>
        <li><a href="specials.htm">精品书</a></li>
        <li><a href="${path}/login.jsp">登录账号</a></li>
        <li><a href="${path}/register.jsp">注册账号</a></li>
        <li><a href="details.htm">详情</a></li>
        <li><a href="contact.htm">联系我们</a></li>
       	
	        	
	   
      </ul>
    </div>
</div>