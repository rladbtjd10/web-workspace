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
	<h1>회원 정보 수정</h1>
	<form action="/UpdateServlet" method="post">
		<label for="id">아이디:</label> <input type="text" id="id" name="id"
			value="<c:out value="${dto.id}" />" readonly><br>
		<label for="name">이름:</label> <input type="text" id="name" name="name"
			value="<c:out value="${dto.name}" />"><br>
		<label for="address">주소:</label> <input type="text" id="address"
			name="address" value="<c:out value="${dto.address}" />"><br>
		<input type="submit" value="수정">
	</form>

	<a href=".. /index.jsp">첫 페이지로 이동</a>


</body>
</html>