  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>delete Student</h1>
	${msg}
	<form action="delete" method="post">
		ID: <input type="text" name="id"><br> <input
			type="submit" name="submit" value="Submit">
	</form>
</body>
</html>
