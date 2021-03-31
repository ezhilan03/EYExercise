<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/myjsptags.tld" prefix="mytags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%-- 	<%
		String num = request.getParameter("number");
		int n = Integer.parseInt(num);
		if(n%2==0){
			out.println("<h1>even number</h1>");
		}
		else{
			out.println("<h1>odd number</h1>");
		}
	%> --%>
	
	<mytags:checkNumber number="<%=request.getParameter(\"number\") %>"/>
	
</body>
</html>