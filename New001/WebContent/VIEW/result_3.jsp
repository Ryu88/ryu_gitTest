<%@page import="com.ryu.dto.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="dto" class="com.ryu.dto.MemberVO" scope = "session"></jsp:useBean>
<%-- <jsp:setProperty property="dto" name="id" param="id"/>
<jsp:setProperty property="dto" name="pass" param="pass"/>
<jsp:setProperty property="dto" name="name" param="name"/>
<jsp:setProperty property="dto" name="age" param="age"/>
<jsp:setProperty property="dto" name="email" param="email"/> --%>
<jsp:setProperty property="*" name="dto"/>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
id : <jsp:getProperty property="id" name="dto"/><br>
pass : <jsp:getProperty property="pass" name="dto"/><br>
name : <jsp:getProperty property="name" name="dto"/><br>
age : <jsp:getProperty property="age" name="dto"/><br>
email : <jsp:getProperty property="email" name="dto"/><br>
<p>
<a href="/New001/VIEW/result_2.jsp">result_2.jsp</a>
</body>
</html>