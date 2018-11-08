<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add animal</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/connected/AddAnimalServlet" method="post">
		Name : <input type="text" name="name" placeholder="name" /><br/><br/>
		Color : <input type="text" name="color" placeholder="color" /><br/><br/>
		dangerous : 
		<select name="dangerous">
			<option>true</option>
			<option selected>false</option>
		</select><br/><br/>
		<input type="submit" value="Send" /><br/><br/>
	</form>
	<font color="red">${errorMessage}</font>
	<br/><br/>
	<a href="${pageContext.request.contextPath}/connected/HomeServlet">Back to home</a>
</body>
</html>