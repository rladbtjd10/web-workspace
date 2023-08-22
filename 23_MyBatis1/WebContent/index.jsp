<%@page import="model.vo.StudentVO"%>
<%@page import="model.service.StudentService"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	List<StudentVO> list = new StudentService().showStudent(null);
	request.setAttribute("list", list);
%>
<!-- 
	첫 페이지 리스트 뿌려주기~ <% %>
	service 호출해서 list에 담아
	request.setAttribute로 바인딩!
 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
<style>
	.container .row {
		margin-top:50px;
		margin-bottom:30px;
	}
</style>
</head>
<body>
<div class="container">

	<div class="row">
		<div class="col">
			<input id="word" type="text" class="form-control">
		</div>
		<div class="col">
			<input id="searchBtn" value="검색" type="button" class="searchBtn">
		</div>
	</div>
</div>
	<table class="table">
		<thead>
			<tr>
				<th>학번</th>
				<th>이름</th>
				<th>주소</th>
				<th>학과</th>
				<th>계열</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="student">
				<tr>
					<td>${student.studentNo}</td>
					<td>${student.studentName}</td>
					<td>${student.studentAddress}</td>
					<td>${student.department.departmentName}</td>
					<td>${student.department.category}</td>
				</tr>
			</c:forEach>	
		</tbody>
	</div>
	
	
	<script>
		$('#searchBtn').click(function() {
			const word = $('#word').val();
			$.ajax({
				type: 'get', <!--검색은 get으로-->
				url: 'find.do',
				data: 'word='+word,
				dataType: 'json', <!--요청부분-->
				
				success:function(data) { <!-- 응답부분 -->
					//console.log(data.result);
					const result = eval(data.result);
					//console.log(result);
					let resultHtml= '';
					for(let item of result){//자바에서 각각의 값 가져올때 of를 써야됨
						resultHtml += "<tr>" + 
						              "<td>" + item.studentNo + "</td>" +
						              "<td>" + item.studentName + "</td>" +
						              "<td>" + item.studentAddress + "</td>" +
						              "<td>" + item.department.departmentName + "</td>" +
						              "<td>" + item.department.category + "</td>" +
									  "</tr>";
					} 
					$('tbody').html(resultHtml);
				},
			});
		});
	</script>
</body>
</html>