<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
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
		<h2 style="padding: 40px;">Edit your ToDo</h2>
		<form method="POST" commandName="note">
			<div style="padding-bottom: 10px;">
				<input required="required" type="text" name="name"
					placeholder="Name of new Task" class="form-control"
					value="<c:out value='${note.name}'/>" />
			</div>
			<div style="padding-bottom: 10px;">
				<input required="required" class="form-control" name="executionDate"
					type="text" id="datepicker" placeholder="Execution Date"
					value="<spring:eval expression="note.executionDate" />" />
			</div>
			<input type="submit" class="btn btn-primary" value="Update ToDo" />
		</form>
	</div>
</body>
</html>
