<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/taglib.jsp"%>
<div class="right_content">

	<c:if test="${user==null}">
		<div class="currency">
			<span class="red">快登录账号购买图书吧~</span> <a href="${path}/login.jsp"
				class="selected">登录</a> <a href="${path}/register.jsp"
				class="selected">注册</a>
		</div>
	</c:if>
	<c:if test="${user!=null}">
		<div class="currency">
			<span class="red">账号：</span> <a href="${path}/login.jsp"
				class="selected">${user.userEmail }</a> <a
				href="${path_}/OutLoginAccount"><font color="red">退出账号</font></a>
		</div>
	</c:if>

	<div class="cart">
		<div class="title">
			<span class="title_icon"><img src="${path}/images/cart.gif"
				alt="" title="" /></span>我的购物车
		</div>
		<!-- <div class="home_cart_content">
				3 x items | <span class="red">TOTAL: 100$</span>
			 </div>
		 -->
		<a href="${path_}/shopCartActionServlet?action=view" class="view_cart">进入购物车  &nbsp;>></a>
		<c:if test="${user!=null}">
			<a href="${path_}/OrderActionServlet?action=myOrders" class="view_cart">我的订单</a>
		</c:if>
	</div>
	<div class="title">
		<span class="title_icon"><img src="${path}/images/bullet3.gif"
			alt="" title="" /></span>书店简介
	</div>
	<div class="about">
		<p>
			<img src="${path}/images/about.gif" alt="" title="" class="right" />全球最大中文网上书店,
			专业提供小说传记,青春文学,成功励志,投资理财等各品类图书畅销榜最新报价、促销、评论信息,引领最新网上购书体验!
		</p>
	</div>
	<div class="right_box">
		<div class="title">
			<span class="title_icon"><img src="${path}/images/bullet4.gif"
				alt="" title="" /></span> 促销
		</div>
		<div class="new_products">
			<c:forEach items="${productList_1}" var="book">
				<div class="new_prod_box">
					<a href="details.htm">${book.bookName}</a>
					<div class="new_prod_bg">
						<span class="new_icon"> <img
							src="${path}/images/new_icon.gif" alt="" title="" />
						</span> <a href="${path_}/BookActionServlet?action=index_detailed&id=${book.bookId}"> <img
							src="${pageContext.request.contextPath}/${book.bookImgurl}"
							alt="" title="" class="thumb" border="0" width="55px;"
							height="85px;" />
						</a>
					</div>
				</div>





			</c:forEach>

		</div>
	</div>
	<div class="right_box">
		<div class="title">
			<span class="title_icon"><img src="${path}/images/bullet5.gif"
				alt="" title="" /></span>类别
		</div>
		<ul class="list">
			<c:forEach items="${productClassList}" var="bookClass">
				<li><a href="${path_}/bookFactoryServlet?action=${bookClass.typeId}">${bookClass.typeName}</a></li>
			</c:forEach>
			
			
		</ul>
		<div class="title">
			<span class="title_icon"><img src="${path}/images/bullet6.gif"
				alt="" title="" /></span>合伙人
		</div>
		<ul class="list">
			<li><a href="#">合伙人1</a></li>
			<li><a href="#">合伙人2</a></li>
			<li><a href="#">合伙人3</a></li>
			<li><a href="#">合伙人4</a></li>
			<li><a href="#">合伙人5</a></li>
			<li><a href="#">合伙人6</a></li>
			<li><a href="#">合伙人7</a></li>
			<li><a href="#">合伙人8</a></li>
			<li><a href="#">合伙人9</a></li>
		</ul>
	</div>
</div>
<!--end of right content-->
<div class="clear"></div>