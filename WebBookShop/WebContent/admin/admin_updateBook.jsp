<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新书本信息</title>
<link href="${pageContext.request.contextPath}/admin/css/style.css"
	rel="stylesheet" type="text/css" />
</head>
<body>
	<center>
		<br />
		
		<form action="BookActionServlet?action=update" name="addform" id="addform" method="post">
			<br /> <br />
			<table border="0">
				<tr>
					<td>图书名称</td>
					<td>
						<input type="hidden" name="id" id="id" value="${book.bookId}" />
					    <input type="text" name="product" id="product" value="${book.bookName}" />
					</td>
				</tr>
				<tr>
					<td>图书价格</td>
					<td>
						<input type="text" name="price" id="price" value="${book.bookPrice }" />
						
				   </td>
				</tr>
				<tr>
					<td>所属类别</td>
					<td>
						<select id="classid" name="classid">
							<c:forEach items="${typeList}" var="type">
								<option value="${type.typeId}" selected=${type.typeId==book.bookType.typeId?"selected":"" }>
									
				   				 	${type.typeName}
								</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td>图书作者</td>
					<td>
						<input type="text" name="author" id="author" value="${book.bookAuthor}" />
					</td>
				</tr>
				<tr>
					<td>图书出版社</td>
					<td>
						<input type="text" name="publisher" id="publisher" value="${book.bookPublisher}" />
					</td>
				</tr>
				<tr>
					<td>图书描述</td>
					<td>
						<textarea rows="5" cols="50" name="description"	id="description" style="overflow: hidden;">${book.bookDescription }</textarea>
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<input type="submit" name="bt1" id="bt1" value="提交" /> 
						
						<input type="button" name="return" id="return" value="返回" onclick="history.back();"/>
					</td>
				</tr>

			</table>
		</form>

	</center>
</body>
</html>