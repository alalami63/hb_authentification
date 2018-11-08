<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
</head>
	<body>
		<c:if test="${ empty user }">
			
		</c:if>
		<form method="POST" action="SubscribeServlet">
			Login : <input type="text" name="login" required /><br/><br/>
			Password : <input type="password" name="password" required /><br/><br/>
			Last name : <input type="text" name="lname" required /><br/><br/>
			First name : <input type="text" name="fname" required /><br/><br/>
			<input type="submit" value="Send" /><br/><br/>
		</form>
		<font color="red">${ errorMessage }</font>
		<hr/>
		<a href="${pageContext.request.contextPath}/index.jsp">Back</a><br/><br/>
	</body>
</html>