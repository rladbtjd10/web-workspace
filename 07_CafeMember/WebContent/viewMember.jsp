<%--
JSP Element
1) 지시어 %@ % : 컨테이너에게 알려줄 내용 지정
2) 스클릿틀릿 % % : 자바코드는 이 안에 지정
3) 출력문 %= % : 출력하려는 내용 지정
 --%>
<%@ page import= "java.util.List" %> 
<%@ page import="servlet.model.MemberVO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
String name = request.getParameter("name");
//List<MemberVO> list  = (List) application.getAttribute("list");
List<MemberVO> list  = (List) request.getAttribute("list");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>

	<div class="container">
		<h2>회원 조회</h2>
		<form action="search">
			검색할 회원 이름을 입력해주세요. <br>
			<input type="text" name="name">
			<input type="submit" value="조회">
		</form>

		<hr>
		
		<h2>전체 Cafe 명단 리스트</h2>
		<table class="table">
			<tr>
				<th></th>
				<th>이름</th>
				<th>나이</th>
				<th>주소</th>
			</tr>
			<%
			if(list!=null){
			for(int i=0; i<list.size(); i++) { %>
					<tr>
						<td><%= i + 1 %></td>
						<td><%= list.get(i).getName() %></td>
						<td><%= list.get(i).getAge() %></td>
						<td><%= list.get(i).getAddr() %></td>
					</tr>
				<% } } %>
		</table>
	</div>
	
	<%-- 
	<h2>회원님의 정보를 출력합니다..</h2>
	<% for(MemberVO vo : list){ %>
	
	<h2><%= vo.getName() %></h2>
	<h2><%= vo.getAge() %></h2>
	<h2><%= vo.getAddr() %></h2>
	
	<% };%>
	--%>
</body>
</html>