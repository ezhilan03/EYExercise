<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="logout.action;jsessionid=<%=session.getId()%>" method="get"  >
		<input type="submit" name="action" value="Logout">
	</form>
</body>
</html>