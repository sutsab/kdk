<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Cat Details</title>
	</head>
	<body>
		<a href="<c:url value="../list" />">Return to list</a><br />
		<table border="1">
			<tbody>
				<tr>
					<th>Name</th>
					<td>${cat.name}</td>
				</tr>
				<tr>
					<th>Birth Date</th>
					<td><fmt:formatDate pattern="dd-MM-yyyy" value="${cat.birthDate}" /></td>
				</tr>
				<tr>
					<th>Weight</th>
					<td><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${cat.weight}" /> kg</td>
				</tr>
				<tr>
					<th>Owner's Name</th>
					<td>${cat.ownersName}</td>
				</tr>
			</tbody>
		</table>
		<br />
		<hr />
	</body>
</html>