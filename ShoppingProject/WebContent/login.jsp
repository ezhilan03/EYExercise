<!DOCTYPE html>
<%@page import="java.util.ResourceBundle"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/myjsptags.tld" prefix="mytags" %>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<%-- <%
	ResourceBundle rb = (ResourceBundle)session.getAttribute("rb");
%> --%>
	<b>Login</b>
	<form action="login.action;jsessionid=<%=session.getId()%>" method="get" >
		<%-- <br><%=rb.getString("username") %>:<input type="text" name="uname"><br>
		<%=rb.getString("password") %>:<input type="password" name="upass"><br> --%>
		
		<br><mytags:bundle key="username"/>:<input type="text" name="uname"><br>
		<mytags:bundle key="password"/>:<input type="password" name="upass"><br>
		<br><input type="submit" name="action" value="Login">
	</form>
</body>
</html>