<%@page import="servlet.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<% MemberVO vo = (MemberVO) request.getAttribute("vo"); %>
	<h2>ȸ�� �˻� ���</h2>
	<ul>
		<li>�̸� : <%= vo.getName() %></li>
		<li>���� : <%= vo.getAge() %></li>
		<li>�ּ� : <%= vo.getAddr() %></li>
	</ul>
</body>
</html>