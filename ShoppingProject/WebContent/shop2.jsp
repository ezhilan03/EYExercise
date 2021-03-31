<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/myjsptags.tld" prefix="myproducts" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="yellow">
	<hr>
	<jsp:include page="logout.jsp;jsessionid=<%=session.getId()%>"></jsp:include>
	<hr>
	
	<h1>Grocery shop</h1>
	<form action="shop.action" method="post">
	<input type="hidden" name="action" value="Shop">
	<input type="hidden" name="shopid" value="shop2">
		<myproducts:product category="2" />
		<input type="submit" value="Next shop">
	</form>
</body>
</html>