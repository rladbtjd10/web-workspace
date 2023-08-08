<%@page import="servlet.model.vo.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<%-- invalidate :파괴?? 로그아웃 하려면 파기를 해야되는게 먼저여서 --%>
<%
	MemberDTO dto = (MemberDTO) session.getAttribute("dto");
	if (dto != null) {
		session.invalidate();
%>
<body onload="return logout()">
	
	<script>
		function logout() {
			alert('Logout!');
			location.href="../index.jsp";
		}
	</script>
	
</body>
<% } %>

</html>