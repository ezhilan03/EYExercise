<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<b>signup</b>
	<form action="register.action;jsessionid=<%=session.getId()%>" method="get" >
		<br>Name:<input type="text" name="uname"><br>
		Password:<input type="password" name="upass"><br>
		<br>&nbsp;<input type="submit" name="action" value="Register">
	</form>
</body>
</html>