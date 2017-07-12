<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.Map" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account open Successfully</title>
<style type="text/css">
	.success{
		color:green;
		font-size:25px;
	}	
	.msg{
		font-size:20px;
	}
</style>
</head>
<body>
<%Map map=(Map)request.getAttribute("map"); %>
	<div class="success"><center>You have successfully opened your Account</center></div>
	<div class="msg"><center>Name:<%=map.get("name") %></center></div>
	<div class="msg"><center>UserId: <%=map.get("userId") %></center></div>
	<div class="msg"><center>Account Number: <%=map.get("accountNo") %></center></div>
	<div class="success"><center><a href="login.jsp">Click Here to Login</a></center></div>
</body>
</html>