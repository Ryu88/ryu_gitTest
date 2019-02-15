<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
초기파라미터 조회<br>
<hr>
Config 초기파라미터 : <%= config.getInitParameter("name") %> <br>
Context 초기파라미터 : <%= application.getInitParameter("name") %>
</body>
</html>