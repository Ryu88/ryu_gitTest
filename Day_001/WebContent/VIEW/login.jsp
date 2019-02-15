<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>로그인</h3>
	<%
		String msg = (String)request.getAttribute("msg");
		if(msg != null){
	%>
		<font color = "red" size = "4"><%= msg %></font>
	<%		
		}
	%>
	<form action="/Exam_04/login" method = "post">
		아이디 : <input type ="text" name = "id" /><br>
		비밀번호 : <input type = "password" name = "pwd" /><br>
		<input type = "submit" value = "로그인" />
	</form>
</body>
</html>