<%-- <%@page import="servlet.model.vo.MemberDTO"%>
<%@page import="java.util.ArrayList"%>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>전체 회원 목록</h1>
	
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>주소</th>
		</tr>
		
		<jsp:useBean id="list" class="java.util.ArrayList" scope="request" />
		<c:forEach var="item" items="${list}">
			<tr>
				<td><c:out value="${item.id}" /></td>
				<td><c:out value="${item.name}" /></td>
				<td><c:out value="${item.address}" /></td>
			</tr>
		</c:forEach>
		<%-- 
		<%
			ArrayList<MemberDTO> list = (ArrayList<MemberDTO>) request.getAttribute("list");
			for(MemberDTO item : list) {
		%>	
			<tr>
				<td><%= item.getId() %></td>
				<td><%= item.getName() %></td>
				<td><%= item.getAddress() %></td>
			</tr>	
			<% } %>
	     --%>
	</table>
</body>
</html>