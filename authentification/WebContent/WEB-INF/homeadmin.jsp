<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home admin</title>
</head>
<body>
	<a href="${pageContext.request.contextPath}/connected/admin/UsersControlServlet">Show users control</a><br/><br/>
	<a href="${pageContext.request.contextPath}/connected/admin/AnimalsControlServlet">Show animals control</a><br/><br/>
	<a href="${pageContext.request.contextPath}/connected/LogoutServlet">Logout</a><br/><br/>
</body>
</html>