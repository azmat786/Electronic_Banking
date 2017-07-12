<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		int uid = (int)session.getAttribute("uId");
		int account = (int)session.getAttribute("accountUd");
		
	%>
	<div style="font-size:20px;margin-top:100px;"><center><span style="color:green">Your UserId:</span>&nbsp;&nbsp;&nbsp;<%=uid %></center></div>
	<div style="font-size:20px;"><center><span style="color:green">for this account number:</span>&nbsp;&nbsp;&nbsp;<%=account %></center></div>
	
	<div style="font-size:25px;margin-top:50px;"><center><a href="login.jsp">Back</a></center></div>
	
</body>
</html>