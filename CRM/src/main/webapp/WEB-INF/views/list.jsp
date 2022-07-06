<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Relationship Management</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1> Customer Relationship Management</h1>
		<a href="/CRM/crm/add" class="btn btn-primary btn-sm mb-3">Add Customer</a>
			<table class="table table-bordered table-striped">
			<thead  class="thead-dark">
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email Id</th>
					<th>Action</th>	
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${result}" var="crm">
					<tr>
					<td hidden>value="${crm.id}"</td>
					<td><c:out value="${crm.firstName}"></c:out></td>
					<td><c:out value="${crm.lastName}"></c:out></td>
					<td><c:out value="${crm.emailId}"></c:out></td>
					<td><a href="/CRM/crm/update?id=${crm.id}" class="btn btn-info btn-sm">Update</a>
					<a href="/CRM/crm/delete?id=${crm.id}" class="btn btn-danger btn-sm" onclick="if(!(confirm('Are you sure to delete?'))) return false">Delete</a>
					</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>