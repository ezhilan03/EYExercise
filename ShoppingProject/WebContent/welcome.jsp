<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/myjsptags.tld"  prefix="mytags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%-- <b>Welcome...<%= session.getAttribute("uname") %> </b><br> --%>
	<b>Welcome... <mytags:welcome key="uname"/></b><br>
	<hr>
	<jsp:include page="logout.jsp"></jsp:include>
	<hr>
	<form action="shopping.action;jsessionid=<%=session.getId()%>" method="get"  >
		<input type="submit" name="action" value="Shopping">
	</form>
	
</body>
</html>