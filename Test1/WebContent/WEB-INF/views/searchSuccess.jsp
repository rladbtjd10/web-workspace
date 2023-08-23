<%@page import="edu.kh.test.user.model.vo.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원정보</h2>
	<table border="1">
	<tr>
		<td>회원번호</td>
		<td>회원아이디</td>
		<td>회원이름</td>
		<td>회원나이</td>
	</tr>
	<% UserDTO dto = (UserDTO) request.getAttribute("dto"); %>
	<% if(dto!=null) { %>
	<tr>
		<td><%= (dto.getNo()) %></td>
		<td><%= (dto.getId()) %></td>
		<td><%= (dto.getName()) %></td>
		<td><%= (dto.getAge()) %></td>
	</tr>
	<%} %>
	
	<a href="index.jsp">메인페이지로 돌아가기</a>
</body>
</html>