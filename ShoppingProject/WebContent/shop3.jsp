<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/myjsptags.tld" prefix="myproducts" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="green">
	<hr>
	<jsp:include page="logout.jsp"></jsp:include>
	<hr>
	
	<h1>Fruit shop</h1>
	<form action="shop.action;jsessionid=<%=session.getId()%>" method="post">
	<input type="hidden" name="action" value="Shop">
	<input type="hidden" name="shopid" value="shop3">
		<myproducts:product category="3" />
		<input type="submit"  value="Invoice">
	</form>
</body>
</html>