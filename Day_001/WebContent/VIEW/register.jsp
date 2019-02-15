<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/Exam_04/Join" method="post">
		<table>
			<tr>
				<td align = "right"> ID : </td>
				<td align = "right"><input type = "text" name="id" size = "20"/></td>
			</tr>
			<tr>
				<td align = "right"> PASS : </td>
				<td align = "right"><input type = "password" name="pwd" size = "20"/></td>
			</tr>
			<tr>
				<td align = "right"> NAME : </td>
				<td align = "right"><input type = "text" name="name" size = "20"/></td>
			</tr>
			<tr>
				<td align = "right"> phone : </td>
				<td align = "right"><input type = "text" name="phone" size = "20"/></td>
			</tr>
			<tr>
				<td align = "right"> age : </td>
				<td align = "right"><input type = "text" name="age" size = "20"/></td>
			</tr>
			<tr>
			<td colspan = "2" align = "center">
			<input type = "submit" value="등록">
			<input type = "reset" value="취소">
			</tr>
		</table>
	</form>
</body>
</html>