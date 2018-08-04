<%@page import="dao.bookTypeDao"%>
<%@page import="bean.BookType"%>
<%@page import="java.util.List"%>
<%@page import="dao.DBConnection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@include file="../common/taglib.jsp" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style.css" rel="stylesheet" type="text/css" />
<title>addProduct</title>

<script type="text/javascript">
function addbt(){
    if(document.getElementById("product").value==""){
   		alert("商品名称不能为空！");
   		document.getElementById("product").focus();
   }else if(document.getElementById("price").value==""){
   		alert("商品价格不能为空！");
   		document.getElementById("price").focus();
   }else{ 
	   document.addform.submit();
   }
}
   
</script>	

</head>
<body>

	<center>
		<form action="${pageContext.request.contextPath}/BookActionServlet?action=add" name="addform" id="addform" method="post" ><br />
			<br />
			<table border="0">
				<tr>
					<td>商品名称</td>
					<td><input type="text" name="product" id="product" /></td>
				</tr>
				<tr>
					<td>商品价格</td>
					<td><input type="text" name="price" id="price" value=""/></td>
				</tr>
				<tr>
					<td>所属类别</td>
					<td>
						<%
							List<BookType> bookTypeList = new bookTypeDao().selectAllBookType();
							pageContext.setAttribute("bookTypeList", bookTypeList);
						%>
						<select id="classid" name="classid">
								<c:forEach items="${bookTypeList}" var="type">
									<option value="${type.typeId}"}>${type.typeName}</option>
								</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td>作者</td>
					<td><input type="text" name="author" id="author" /></td>
				</tr>
				<tr>
					<td>出版社</td>
					<td><input type="text" name="publisher" id="publisher" /></td>
				</tr>
				<tr>
					<td>商品描述</td>
					<td>
						<textarea rows="5" cols="50" name="description" id="description" style="overflow: hidden;">
						
						</textarea>
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<input type="button" name="bt1" id="bt1" value="添加商品" onclick="addbt();" /> 
						<input type="button" name="bt3" id="bt3" value="返回列表" onclick="javascript:document.location='${pageContext.request.contextPath}/BookActionServlet?action=selectlist'" />
					</td>
				</tr>
			
			</table>
		</form>
	</center>

</body>
</html>