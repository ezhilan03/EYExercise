    
<%@page import="day25.User"%>
<%@ page 

	autoFlush="false"
	buffer="10kb"
	
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	
	session="true"
	
	errorPage="error.jsp"
	
	import="java.sql.Date"
 	
 	isThreadSafe="true"
 %>
    
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	
தமிழ்
	
	<%!
		String s="Hello";
	%>
	
<%-- 	<jsp:include page="header.jsp">
		<jsp:param value="Hello from header" name="cname"/> 
	</jsp:include> --%>
	<%
		User user = (User)session.getAttribute("userObj");
	%>
	<h1>Hello <%=user.getUname() %></h1>
	<%= application.getRealPath("/") %>
	
</body>
</html>