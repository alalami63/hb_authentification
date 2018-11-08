<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home user</title>
</head>
<body>
   	You are registered and connected as ${ user.lastname } ${ user.firstname }.
	<br/><br/><br/>
	<a href="${pageContext.request.contextPath}/connected/MyAnimalsServlet">See my animals</a><br/><br/>
	<a href="${pageContext.request.contextPath}/connected/AddAnimalServlet">Add a new animal</a><br/><br/>
	<a href="${pageContext.request.contextPath}/connected/LogoutServlet">Logout</a><br/><br/>
	<br/><br/>
</body>
</html>