<%@page import="common.indexPage"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:set var="path" value="${pageContext.request.contextPath}/user" scope="application"></c:set>
<c:set var="path_" value="${pageContext.request.contextPath}" scope="application"></c:set>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${path}/css/style.css" />
<title>书库</title>
</head>
<body>
	<div id="wrap">
		<%@include file="top.jsp"%>
		<div class="center_content">
			<div class="left_content">
		      <div class="title"><span class="title_icon"><img src="images/bullet1.gif" alt="" title="" /></span>遨游书库</div>
		     <!--图书的展示 -->
		      <c:forEach items="${bookList}" var="book">
			    	<div class="feat_prod_box">
						<div class="prod_img">
							<a href="${path_}/BookActionServlet?action=index_detailed&id=${book.bookId}">
								<img src="${pageContext.request.contextPath}/${book.bookImgurl}" alt="" title="" border="0" width="130px;" height="150px;" />
							</a>
						</div>
						<div class="prod_det_box">
							<div class="box_top"></div>
							<div class="box_center" style="height: 140px;">
								<div class="prod_title">${book.bookName}</div>
								<p class="details">
									${book.bookDescription}
								</p>
								<a href="${path_}/BookActionServlet?action=index_detailed&id=${book.bookId}" class="more">- 详情 -</a>
								<div class="clear"></div>
							</div>
							<div class="box_bottom"></div>
						</div>
						<div class="clear"></div>
					</div>
		      </c:forEach>
		      
		      
		     
		      
		      <div class="pagination"> 
		      	<c:if test="${page.page_count!=0 }">
						<a href="bookFactoryServlet?action=${a}&current_page=1">首页</a>&nbsp;
						<c:if test="${page.current_bottom_page!=1 }">
							<a href="subCurrent_bottom_page"> < </a>&nbsp;
						</c:if>
						<c:if test="${a=='factory'}">
							<%
							indexPage p=(indexPage)session.getAttribute("page");
							if(p.getMaxCurrent_bottom_page()<10) {
								for(int i=1;i<=p.getPage_count();i++){
									out.print("<a href=\"bookFactoryServlet?action=factory&current_page="+i+"\">"+i+"</a>"+"&nbsp;");
								}
						    
							}else if(p.getMaxCurrent_bottom_page()==p.getCurrent_bottom_page()){
								for(int i=p.getCurrent_bottom_page();i<=p.getPage_count();i++){
									out.print("<a href=\"bookFactoryServlet?action=factory&current_page="+i+"\">"+i+"</a>"+"&nbsp;");
								}
							}else {
								if(p.getCurrent_bottom_page()<=p.getMaxCurrent_bottom_page()){
									for(int i=p.getCurrent_bottom_page();i<=p.getCurrent_bottom_page()+8;i++){
										out.print("<a href=\"bookFactoryServlet?action=factory&current_page="+i+"\">"+i+"</a>"+"&nbsp;");
									}
								}
							}
							if(p.getCurrent_bottom_page()< p.getMaxCurrent_bottom_page()){
								out.print("<a href=\"addCurrent_bottom_page\"> > </a>"+"&nbsp;");
							}
							%>
						</c:if>
						<c:if test="${a!='factory'}">
							<%
							String a1=(String)session.getAttribute("a");
							int a=Integer.parseInt(a1);
							indexPage p=(indexPage)session.getAttribute("page");
							if(p.getMaxCurrent_bottom_page()<10) {
								for(int i=1;i<=p.getPage_count();i++){
									out.print("<a href=\"bookFactoryServlet?action="+a+"&current_page="+i+"\">"+i+"</a>"+"&nbsp;");
								}
						    
							}else if(p.getMaxCurrent_bottom_page()==p.getCurrent_bottom_page()){
								for(int i=p.getCurrent_bottom_page();i<=p.getPage_count();i++){
									out.print("<a href=\"bookFactoryServlet?action="+a+"&current_page="+i+"\">"+i+"</a>"+"&nbsp;");
								}
							}else {
								if(p.getCurrent_bottom_page()<=p.getMaxCurrent_bottom_page()){
									for(int i=p.getCurrent_bottom_page();i<=p.getCurrent_bottom_page()+8;i++){
										out.print("<a href=\"bookFactoryServlet?action="+a+"&current_page="+i+"\">"+i+"</a>"+"&nbsp;");
									}
								}
							}
							if(p.getCurrent_bottom_page()< p.getMaxCurrent_bottom_page()){
								out.print("<a href=\"addCurrent_bottom_page\"> > </a>"+"&nbsp;");
							}
							%>
							
						</c:if>
						
						
					
						<a href="bookFactoryServlet?action=${a}&current_page=${page.page_count }">尾页</a>&nbsp;
					</c:if>
		       </div>
		      <div class="clear"></div>
		    </div>
		
			<%@include file="content_right.jsp"%>
		</div>
		<%@include file="bottom.jsp"%>
	</div>
</body>
</html>