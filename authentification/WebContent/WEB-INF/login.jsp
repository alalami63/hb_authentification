<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<h1>Login</h1><br/><br/>
	<form method="POST" action="${pageContext.request.contextPath}/unconnected/ConnectionServlet">
		Login : <input type="text" name="login" /><br/><br/>
		Password : <input type="password" name="password" /><br/><br/>
		<input type="submit" value="Connect" /><br/><br/>
		<font color="red">${errorMessage}</font>
	</form>
	<hr/>
	<a href="${pageContext.request.contextPath}/index.jsp">Back</a><br/><br/>
</body>
</html>