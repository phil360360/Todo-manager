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
		<h2 class="row">Add a new ToDo</h2>
		<form action="/note/add-note" method="POST"
			enctype="multipart/form-data">
			<div class="row" style="padding-bottom: 10px;">
				<input type="text" name="name" placeholder="Name of new Task"
					class="form-control" />
			</div>
			<div class="row" style="padding-bottom: 10px;">
				<input class="form-control" name="executionDate" type="text"
					id="datepicker" placeholder="Execution Date" />
			</div>
			<div class="row">
				<label class="btn btn-primary btn-file"> Browse Files<input
					type="file" name="image" style="padding-bottom: 10px;" />
				</label>
			</div>
			<input style="margin-top: 10px;" type="submit"
				class="row btn btn-primary" value="Add Todo" />
		</form>
	</div>
</body>
</html>
