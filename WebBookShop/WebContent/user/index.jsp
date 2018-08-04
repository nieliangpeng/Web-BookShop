<%@page import="bean.BookType"%>
<%@page import="dao.bookTypeDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.BookDao"%>
<%@page import="bean.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Book Store</title>
<c:set var="path" value="${pageContext.request.contextPath}/user"
	scope="application"></c:set>
<c:set var="path_" value="${pageContext.request.contextPath}"
	scope="application"></c:set>
<link rel="stylesheet" type="text/css" href="${path}/css/style.css" />
</head>
<!-- 验证码<img alt="" src="../common/verificationCode.jsp"> -->

<body>
	<div id="wrap">
		<%@include file="top.jsp"%>
		<div class="center_content">
			<!-- 左边 -->
			<!--  <div class="center_content">-->
				<div class="left_content">
					<div class="title">
						<span class="title_icon"><img
							src="${path}/images/bullet1.gif" alt="" title="" /></span>猜你喜欢
					</div>
					
					<!-- 数据库中查询 -->
					<%	List<Book> productList = (new BookDao()).selectAllBook(); 
						List<Book> subList = new ArrayList<Book>();
						List<Book> subList_1 = new ArrayList<Book>();
						subList = productList.subList(0, 2);
						subList_1=productList.subList(0, 3);
						session.setAttribute("productList", subList);
						session.setAttribute("productList_1", subList_1);
						List<BookType> bookType=new bookTypeDao().selectAllBookType();
						session.setAttribute("productClassList", bookType);
					%>
					<c:forEach items="${productList}" var="book">
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
					
					 <div class="title"><span class="title_icon"><img src="${path}/images/bullet2.gif" alt="" title="" /></span>New books</div>
					 <div class="new_products">
						<c:forEach items="${productList_1}" var="book">
							<div class="new_prod_box">
									<a href="${path_}/BookActionServlet?action=index_detailed&id=${book.bookId}">${book.bookName}</a>
									<div class="new_prod_bg">
										<span class="new_icon">
											<img src="${path}/images/new_icon.gif" alt="" title="" />
										</span> 
										<a href="${path_}/BookActionServlet?action=index_detailed&id=${book.bookId}">
											<img src="${pageContext.request.contextPath}/${book.bookImgurl}" alt="" title="" class="thumb" border="0" width="55px;" height="85px;" />
										</a>	
									</div>
							</div>
							
								
								
							
							
						</c:forEach>
					
					</div>

				<div class="clear"></div>
				</div>
			<!--</div>-->
			<!-- 右边 -->
			<%@include file="content_right.jsp"%>
			
		</div>
		<%@include file="bottom.jsp"%>
	</div>
</body>
</html>