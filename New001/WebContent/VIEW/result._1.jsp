<%@page import="com.ryu.dto.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <% 
	MemberVO dto = (MemberVO)request.getAttribute("dto");
	if(dto==null){
		dto = new MemberVO();
		request.setAttribute("dto", dto);
	}
%> --%>
<jsp:useBean id="dto" class="com.ryu.dto.MemberVO" scope="request"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
id : <%=dto.getId() %><br>
pass : <%=dto.getPass() %><br>
name : <%=dto.getName() %><br>
age : <%=dto.getAge() %><br>
email : <%=dto.getEmail() %><br>
<p>
<a href="/New001/VIEW/result_2.jsp">result_2.jsp</a>
</body>
</html>