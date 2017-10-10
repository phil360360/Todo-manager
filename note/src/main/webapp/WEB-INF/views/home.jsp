<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/note/resources/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	$(function() {
		$("#datepicker").datepicker();
	});
</script>
<title></title>
</head>
<body>
	<div class="container">
		<h1 style="padding: 40px;">ToDo-List Manager</h1>
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
						<td><img style="max-height:40px;" src=${todo.image }/></td>
						<td class="text-right"><a
								href="/note/edit-note?id=${todo.id}" type="button"
								class="btn btn-secondary">Edit</a>
							<form style="display: inline;"
								action="/note/remove-note?id=${todo.id}" method="POST">
								<input type="submit" class="btn btn-danger" value="Delete" />
							</form></td>				
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<form style="display: inline;" action="add-note" method="GET">
				<input type="submit" class="btn btn-primary" value="Add a ToTo" />
			</form>
		</div>
	</div>
</body>
</html>
