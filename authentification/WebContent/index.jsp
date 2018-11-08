<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Index page</title>
</head>
<body>
	<h1>Welcome</h1>
	<div class="container col-xs-4">
		<p>
			<a href="${pageContext.request.contextPath}/unconnected/SubscribeServlet">Subscribe</a><br/>
			<a href="${pageContext.request.contextPath}/unconnected/ConnectionServlet">Connection</a><br/>
			<a href="${pageContext.request.contextPath}/connected/HomeServlet">Home</a><br/>
		</p>
	</div>
</body>
</html>