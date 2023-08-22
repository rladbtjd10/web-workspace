<%@page import="servlet.model.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
String name = request.getParameter("name");
//List<MemberVO> list  = (List) application.getAttribute("list");
List<MemberVO> list  = (List) request.getAttribute("list");
%>    
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	
	<div class="container">
		<h2>회원 조회</h2>
		<form action="search">
			검색할 회원 이름을 입력해주세요. <br>
			<input type="text" name="name">
			<input type="submit" value="조회>
		</form>
		
		<hr>
		
		<h2>전체 Cafe 명단 리스트 </h2>
		<table class="table">
			<tr>
				<th></th>
				<th>이름</th>
				<th>나이</th>
				<th>주소</th>
			</tr>
			<%
			if(list!=null) {
				for(int i=0; i<list.size(); i++) { %> 
				<tr>
					<td><%= i + 1 %></td>
					<td><%= list.get(i).getName() %></td>
					<td><%= list.get(i).getAge() %></td>
					<td><%= list.get(i).getAddr() %></td>
				</tr>
			<% } }%>
		</table>
	</div>
</body>
</html>