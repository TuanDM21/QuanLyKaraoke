<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<h2>Update Customer</h2>
		<form action="update-customer" method="post">
			<div class="form-group">
				<label for="userName">UserName:</label> <input type="text"
					class="form-control" id="userName" value="${userName}"
					name="userName">
			</div>
			<input type="hidden" class="form-control" id="userName" value="${id}"
				name="id">
			<div class="form-group">
				<label for="password">Password:</label> <input type="text"
					class="form-control" id="password" value="${password}"
					name="password">
			</div>
			<div class="form-group">
				<label for="fullName">Full name:</label> <input type="text"
					class="form-control" id="fullName" value="${fullName}"
					name="fullName">
			</div>
			<div class="form-group">
				<label for="email">Email:</label> <input type="text"
					class="form-control" id="email" value="${email}" name="email">
			</div>
			<div class="form-group">
				<label for="phoneNumber">Phone number:</label> <input type="text"
					class="form-control" id="phoneNumber" value="${phoneNumber}"
					name="phoneNumber">
			</div>
			<div class="form-group">
				<label for="address">Address:</label> <input type="text"
					class="form-control" id="address" value="${address}" name="address">
			</div>

			<button type="submit" class="btn btn-primary">Submit</button>


		</form>
	</div>

</body>
</html>

