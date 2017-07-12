<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account Details</title>
<%@page import="com.e_banking.web.dao.BankingDAOFactory" %>
<%@page import="com.e_banking.web.dao.BankingDAO" %>
<%@page import="java.util.Map" %>
<%@page import="java.io.*" %>

<style type="text/css">
	.photo{
		border: 1px solid;
		height: 200px;
		width: 200px;
		float:right;
		margin-right:40px;

	}
</style>
</head>
<body>
<% 
int account=(int)session.getAttribute("account");
BankingDAO dao = BankingDAOFactory.getInstance();
Map mp = dao. accountdetail(account);

%>

<div class="photo"><img height="200px" width="200px" src="./db_image/<%=(String)mp.get("photo")%>" alt="log"> </div>
<div style="margin-top:150px;"> 
	<table border="1" align="center" >
	<tr>
		<th>First Name:</th>
		<th>Last Name:</th>
		<th>Father Name:</th>
		<th>Account Number:</th>
		<th>Balance:</th>
	</tr>
	<tr>
		<td><%=mp.get("fname") %></td>
		<td><%=mp.get("lname") %></td>
		<td><%=mp.get("faName") %></td>
		<td><%=mp.get("account") %></td>
		<td><%=mp.get("amount") %></td>
	</tr>

	</table>
	
</div>
</body>
</html>