<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>书本详情</title>
<link href="${pageContext.request.contextPath}/admin/css/style.css"
	rel="stylesheet" type="text/css" />
</head>
<body>
	<center>
		<br />
		<table width="490" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td height="22" colspan="2">
					<div align="left">
						<span class="STYLE2">图书详细信息显示：</span>
					</div>
				</td>
			</tr>
			<tr>
				<td width="91" height="22">图书编号：</td>
				<td width="393">&nbsp;&nbsp;${book.bookId}</td>
			</tr>
			<tr>
				<td height="25">图书名称：</td>
				<td>&nbsp;&nbsp;${book.bookName}</td>
			</tr>
			<tr>
				<td height="25">图书作者：</td>
				<td>&nbsp;&nbsp;${book.bookAuthor}</td>
			</tr>
			<tr>
				<td height="25">图书出版社：</td>
				<td>&nbsp;&nbsp;${book.bookPublisher}</td>
			</tr>
			<tr>
				<td height="24">图书类别：</td>
				<td>&nbsp;&nbsp;${book.bookType.typeName}</td>
			</tr>
			<tr>
				<td height="25">图书价格：</td>
				<td>&nbsp;&nbsp;${book.bookPrice}</td>
			</tr>
			<tr>
				<td height="25">产品图片：</td>
				<td>
					<img
					src="${pageContext.request.contextPath}/${book.bookImgurl}" /></td>
			</tr>

			<tr>
				<td height="73">产品介绍：</td>
				<td>
					<div align="left">
						<textarea name="textarea" rows="7" cols="50">${book.bookDescription }</textarea>
					</div>
				</td>
			</tr>
			<tr>
				<td height="28" colspan="2">
					<input type="button" onclick="history.back();" name="submit" value="返回" /></td>
				</td>
			</tr>
		</table>
	</center>
</body>
</html>