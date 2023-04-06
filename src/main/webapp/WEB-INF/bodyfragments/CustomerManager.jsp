<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Customer-manager</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
<style>
.table1 {
	border-collapse: collapse;
	width: 100%;
}

.table1 td {
	padding: 5px;
}

.table1 td:first-child {
	padding-right: 40px;
}

.table1 td:last-child {
	padding-left: 20px;
}
</style>
</head>
<body>
	<%
	if (request.getAttribute("checkFlag") != null) {
	%>
	<script type="text/javascript">
		alert(" Bạn đã đăng ký thành công ")
	</script>
	<%
	}
	%>

	<div class="container">
		<h2>Thông tin khách hàng</h2>
		<div>
			<table class="table1">
				<tr>
					<td colspan="2"><a href="add-customer"><img
							style="width: 20px"
							src="data:image/jpeg;base64,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" />
							Add new customer</a></td>
					<td>
						<form action="search-customer" method="post">
							<div class="input-group" style="background-color: darkgray;">
								<input type="text" class="form-control" placeholder="Search"
									name="key">
								<div class="input-group-btn">
									<button class="btn btn-default" type="submit">
										<i class="fa fa-search" aria-hidden="true"></i>
									</button>
								</div>
							</div>
						</form>
					</td>
				</tr>
			</table>

		</div>
		<table class="table">
			<thead>
				<tr>
					<th>Id</th>
					<th>UserName</th>
					<th>Password</th>
					<th>fullName</th>
					<th>Email</th>
					<th>phoneNumber</th>
					<th>Address</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listCustomer}" var="c">
					<tr>
						<td>${c.id}</td>
						<td>${c.userName}</td>
						<td>${c.password}</td>
						<td>${c.fullName}</td>
						<td>${c.email}</td>
						<td>${c.phoneNumber}</td>
						<td>${c.address}</td>
						<td><a href="delete-customer?id=${c.id}"><img
								style="width: 20px"
								src="https://thumbs.dreamstime.com/z/delete-glyph-vector-line-icon-delete-icon-102291534.jpg" /></a>
						</td>
						<td><a
							href="update-customer?id=${c.id}&userName=${c.userName}&password=${c.password}&fullName=${c.fullName}&email=${c.email}&phoneNumber=${c.phoneNumber}&address=${c.address}"><img
								style="width: 20px"
								src="data:image/jpeg;base64,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" /></a>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>

