
<!DOCTYPE html>
<%@page import="day25.User"%>
<html>
<head>

<title>Insert title here</title>
</head>
<body>
<%-- 	<%
		String uname = request.getParameter("uname");
		String upass = request.getParameter("upass");
		
		User user = new User();
		user.setUname(uname);
		user.setUpass(upass);
		
		session.setAttribute("user", user);
		
		RequestDispatcher rd = request.getRequestDispatcher("test.jsp");
		rd.forward(request,response);
	%> --%>
	<% System.out.print("asdsad"); %>
<jsp:useBean id="userObj" class="day25.User" scope="session">
	<jsp:setProperty name="userObj" property="*" />
</jsp:useBean>
<jsp:forward page="test.jsp" />
</body>
</html>