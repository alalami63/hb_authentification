<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Animals</title>
</head>
<body>
	<h1>My animals :</h1><br/><br/>
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
					<form action="${pageContext.request.contextPath}/connected/DeleteAnimalServlet" method="POST">
						<input type="hidden" name="idAnimal" value="${animal.idAnimal}" />
						<input type="submit" value="delete" />
					</form>
				</td>
				<td>
					<form action="${pageContext.request.contextPath}/connected/UpdateAnimalServlet" method="POST">
						<input type="hidden" name="idAnimal" value="${animal.idAnimal}" />
						<input type="submit" value="update" />
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
	<br/><br/>
	<a href="${pageContext.request.contextPath}/connected/AddAnimalServlet">Add animal</a>
	<a href="${pageContext.request.contextPath}/connected/HomeServlet">Back to home</a>
</body>
</html>