<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:set var="path" value="${pageContext.request.contextPath}/user"
	scope="application"></c:set>
<c:set var="path_" value="${pageContext.request.contextPath}"
	scope="application"></c:set>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${path}/css/style.css" />
<title>购物车</title>

</head>
<body>
<script type="text/javascript">
	
</script>
	<div id="wrap">
		<!-- TOP -->
		
		<%@include file="top.jsp"%>
		
		<!-- center -->
		<div class="center_content">
			<!-- 左边 -->
			<div class="left_content">
		      <div class="title"><span class="title_icon"><img src="${path}/images/bullet1.gif" alt="" title="" /></span>购物车</div>
			      <div class="feat_prod_box_details">
			        <table class="cart_table">
			          <tr class="cart_title">
			            <td>书本</td>
			            <td>书名</td>
			            <td>单价</td>
			            <td>本数</td>
			            <td>总价</td>
			            <td>操作</td>
			          </tr>
			          <c:forEach items="${productCart}" var="bean">
			          	<tr>
				            <td><a href="${path_}/BookActionServlet?action=index_detailed&id=${bean.product.bookId}"><img src="${pageContext.request.contextPath}/${bean.product.bookImgurl}" alt="" title="" border="0" class="cart_thumb" width="100px;" height="130px;" /></a></td>
				            <td>${bean.product.bookName}</td>
				            <td>${bean.product.bookPrice}</td>
				            <td>
				            	<form action="${pageContext.request.contextPath}/shopCartActionServlet?action=updateCount&id=${bean.product.bookId}" method="post" name="formSub" id="formSub">
				            		<input type="text" name="count" value="${bean.count}" style="width: 20px;" onchange="sub();"/>
				            		<input type="submit" value="+" />
				            	</form>
				            </td>
				            <td>
				            	${bean.product.bookPrice * bean.count}
				            </td>
				            <td><a href="${pageContext.request.contextPath}/shopCartActionServlet?action=delete&id=${bean.product.bookId}">删除</a></td>
			         	</tr>	
			          </c:forEach>
			          
			          
			          <tr>
			            <td colspan="4" class="cart_total"><span class="red">总金额：</span></td>
			            <td>
			            	<c:if test="${totalcost==null}">
			            		￥0,&nbsp;快去购物吧！
			            	</c:if>
			            	<c:if test="${totalcost!=null}">
			            	￥${totalcost}
			            	</c:if>
			            </td>
			          </tr>
			         
			        </table>
			        <br/><br/>
			        <input type="button" class="continue" name="return" id="return" value="返回" onclick="history.back();"/>
			        <c:if test="${totalcost!=null}">
			        	 <a href="${path_}/OrderActionServlet?action=addOrder" class="checkout">生成订单 &gt;</a>
			        </c:if>
			         </div>
			      
			      <div class="clear"></div>
		    </div>
			<!-- 右边 -->
			<%@include file="content_right.jsp"%>
		</div>
		
		<!-- bottom -->
		<%@include file="bottom.jsp"%>
	</div>
</body>
</html>
