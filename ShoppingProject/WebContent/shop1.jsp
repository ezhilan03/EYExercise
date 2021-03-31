<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/myjsptags.tld" prefix="myproducts" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="red">
	<hr>
	<jsp:include page="logout.jsp"></jsp:include>
	<hr>
	
	<h1>Jewellery shop</h1>
	<form action="shop.action;jsessionid=<%=session.getId()%>" method="post">
	<input type="hidden" name="action" value="Shop">
	<input type="hidden" name="shopid" value="shop1">
	
		<myproducts:product category="1" />
	
		<input type="submit" value="Next shop">
	</form>
</body>
</html>