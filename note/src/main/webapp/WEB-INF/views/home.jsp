<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>
	$(function() {
		$("#datepicker").datepicker();
	});
</script>
<title></title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="container">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Name of ToDo</th>
					<th>Do this till</th>
					<th>Image</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${todos}" var="todo">
					<tr>
						<td>${todo.name}</td>
						<td><spring:eval expression="todo.executionDate" /></td>
						<td><img style="max-height: 40px;" src=${todo.image } /></td>
						<td class="text-right"><a
								href="/note/edit-note?id=${todo.id}" type="button"
								class="btn btn-secondary">Edit</a>
							<form style="display: inline;"
								action="/note/remove-note?id=${todo.id}" method="POST">
								<input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" /> <input type="submit"
									class="btn btn-danger" value="Delete" />
							</form></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<a href="/note/add-note" type="button" class="btn btn-primary">Add
				Todo</a>
		</div>
	</div>
</body>
</html>
