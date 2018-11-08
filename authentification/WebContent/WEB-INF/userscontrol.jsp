<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Users control</title>
</head>
<body>
	<h1>Users :</h1><br/><br/>
	<table border="1">
		<tr>
			<td>LOGIN</td>
			<td>F. NAME</td>
			<td>L. NAME</td>
		</tr>
		<c:forEach items="${users}" var="user">
			<tr>
				<td>${user.login}</td>
				<td>${user.firstname}</td>
				<td>${user.lastname}</td>
				<td>
					<c:if test="${user.login != 'admin'}">
						<form action="${pageContext.request.contextPath}/connected/admin/UsersControlServlet" method="POST">
							<input type="hidden" name="login" value="${user.login}" />
							<input type="submit" value="delete" />
						</form>
					</c:if>
				</td>
			</tr>
		</c:forEach>
	</table>
	<br/><br/>
	<a href="${pageContext.request.contextPath}/connected/HomeServlet">Back to home-admin</a>
</body>
</html>