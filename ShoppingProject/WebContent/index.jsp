<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Select language</h1>
	<form action="lang.action;jsessionid=<%=session.getId()%>" method="post">
	<input type="hidden" name="action" value="Lang">
		<select name="language">
			<option value="ta">Tamil</option>
			<option value="te">Telugu</option>
			<option value="hi">Hindi</option>
		</select>
		<input type="submit" value="Submit">
	</form>
</body>
</html>