<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/myjsptags.tld" prefix="myproducts" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	.content{
		max-width: 500px;
		margin: auto;
	}
</style>
<title>Insert title here</title>
</head>
<body>
<div class="content">
	<myproducts:productlist />

	<form action="submit.action" method="get">
  		  <input type="submit"  name="action" value="Excel">
  		  <input type="submit"  name="action" value="Pdf">
  		  <input type="submit"  name="action" value="Mail">
  		  <input type="submit"  name="action" value="SMS">
	</form>
</div>
</body>
</html>