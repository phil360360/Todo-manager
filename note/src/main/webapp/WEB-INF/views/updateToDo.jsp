<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>
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
		<h2 class="row">Edit your ToDo</h2>
		<form action="/note/edit-note" method="POST" modelAttribute="todo">
			<div class="row" style="padding-bottom: 10px;">
				<input required="required" type="text" name="name"
					placeholder="Name of new Task" class="form-control"
					value="<c:out value='${todo.name}'/>" />
			</div>
			<div class="row" style="padding-bottom: 10px;">
				<input required="required" class="form-control" name="executionDate"
					type="text" id="datepicker" placeholder="Execution Date"
					value="<spring:eval expression="todo.executionDate" />" />
			</div>
			<input type="hidden" name="id" value="<c:out value='${todo.id}'/>" />
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" /> <input type="hidden" name="image"
				value="<c:out value='${todo.image}'/>" /> <input type="submit"
				class="row btn btn-primary" value="Update ToDo" />
		</form>

	</div>
</body>
</html>
