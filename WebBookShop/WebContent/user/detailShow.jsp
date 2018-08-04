<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品详情</title>
<link rel="stylesheet" type="text/css" href="${path}/css/style.css" />
<c:set var="path" value="${pageContext.request.contextPath}/user"
	scope="application"></c:set>
<c:set var="path_" value="${pageContext.request.contextPath}"
	scope="application"></c:set>
</head>
<body>
	<div id="wrap">
		<%@include file="top.jsp"%>
		<div class="center_content">
			<!-- 左边 -->
			<div class="left_content">
		      <div class="crumb_nav"> <a href="${path}/index.jsp">首页</a> &gt;&gt;书本详情 </div>
		      <div class="title"><span class="title_icon"><img src="${path}/images/bullet1.gif" alt="" title="" /></span>${book.bookName}</div>
		      <div class="feat_prod_box_details">
		        <div class="prod_img"><a href="details.htm"><img src="${pageContext.request.contextPath}/${book.bookImgurl}" alt="" title="" border="0" width="130px;" height="140px;"/></a> <br />
		          <br />
		          <a href="${pageContext.request.contextPath}/${book.bookImgurl}" rel="lightbox"><img src="${path}/images/zoom.gif" alt="" title="" border="0" /></a> </div>
		        <div class="prod_det_box">
		          <div class="box_top"></div>
		          <div class="box_center">
		            <div class="prod_title">详情</div>
		            <p class="details">
		            	<strong>图书名称：</strong>&nbsp;&nbsp;<font color="blue">${book.bookName}</font><br/><br/>
		            	<strong>图书作者：</strong>&nbsp;&nbsp;<font color="blue">${book.bookAuthor}</font><br/><br/>
						<strong>图书出版社：</strong>&nbsp;&nbsp;<font color="blue">${book.bookPublisher}</font><br/><br/>
						<strong>图书类别：</strong>&nbsp;&nbsp;<font color="blue">${book.bookType.typeName}</font><br/><br/>
						<strong>图书介绍:</strong>&nbsp;&nbsp;<font color="blue">${book.bookDescription }</font><br/><br/>
		            </p>
		            <div class="price"><strong>价格：</strong> <span class="red">￥${book.bookPrice}</span></div>
		            <form action="${pageContext.request.contextPath}/shopCartActionServlet?action=addProduct&id=${book.bookId}" method="post">
		            	<div class="price">
				            <strong>买</strong> 
				           	<input type="text" name="BookCount" value="1" style="width: 20px;"/>
				            <span class="colors">本 </span>
		           	    </div>
		           	    <input type="button" name="return"  id="return" value="返回" style="font-style:italic;color:#f8981d;float:left;" onclick="history.back();"/>
		           	    
		           	    <input type="submit" value="加入购物车" class="more" style="font-style:italic;color:#f8981d;float:right;"/>
		            	
		            </form>
		           
		            <div class="clear"></div>
		          </div>
		          <div class="box_bottom"></div>
		        </div>
		        <div class="clear"></div>
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