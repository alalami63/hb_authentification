<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Animals control</title>
</head>
<body>
	<h1>Animals :</h1><br/><br/>
	<table border="1">
		<tr>
			<td>NAME</td>
			<td>COLOR</td>
			<td>DANGEROUS</td>
		</tr>
		<c:forEach items="${animals}" var="animal">
			<tr>
				<td>${animal.name}</td>
				<td>${animal.color}</td>
				<td>${animal.dangerous}</td>
				<td>
					<form action="${pageContext.request.contextPath}/connected/admin/AnimalsControlServlet" method="POST">
						<input type="hidden" name="idAnimal" value="${animal.idAnimal}" />
						<input type="submit" value="delete" />
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
	<br/><br/>
	<a href="${pageContext.request.contextPath}/connected/HomeServlet">Back to home-admin</a>
</body>
</html>