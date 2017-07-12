<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Close Account Details</title>
<%@page import="com.e_banking.web.dao.BankingDAOFactory" %>
<%@page import="com.e_banking.web.dao.BankingDAO" %>
<%@page import="java.util.List" %>
<%@page import="java.util.*" %>
<%@page import="java.io.*" %>
</style>
</head>
<body>
	
	<%
		BankingDAO dao3 = BankingDAOFactory.getInstance();
		List li3 = dao3.closeAccountD();
		
	%>
	
	<div >
		<center>
			<table border="1" style="margin-top:30px">
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Father Name</th>
					<th>Gender</th>
					<th>E-mail</th>
					<th>Phone Number</th>
					<th>Address</th>
					<th>Type-of-Account</th>
					<th>Account Number</th>
					
				</tr>
				<%
					Iterator itr3 = li3.iterator();
					while(itr3.hasNext())
					{
				%>
				<tr>
					<td><%=itr3.next() %></td>
					<td><%=itr3.next() %></td>
					<td><%=itr3.next() %></td>
					<td><%=itr3.next() %></td>
					<td><%=itr3.next() %></td>
					<td><%=itr3.next() %></td>
					<td><%=itr3.next() %></td>
					<td><%=itr3.next() %></td>
					<td><%=itr3.next() %></td>
					
				</tr>
				<%} %>
			</table>
		</center>
	</div>
</body>
</html>