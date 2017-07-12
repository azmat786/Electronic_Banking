<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Activated Account Details</title>
<%@page import="com.e_banking.web.dao.BankingDAOFactory" %>
<%@page import="com.e_banking.web.dao.BankingDAO" %>
<%@page import="java.util.List" %>
<%@page import="java.util.*" %>
<%@page import="java.io.*" %>


</style>
</head>
<body>
	<%
		BankingDAO dao2 = BankingDAOFactory.getInstance();
		List li1 = dao2.activatedAccount();
		
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
					<th>State</th>
					<th>city</th>
					<th>Type-of-Account</th>
					<th>Adhar Number</th>
					<th>PAN Number</th>
					<th>Account Number</th>
					<th>Amount</th>
					
				</tr>
				<%
					Iterator itr1 = li1.iterator();
					while(itr1.hasNext())
					{
					
				%>
				<tr>
					<td><%=itr1.next() %></td>
					<td><%=itr1.next() %></td>
					<td><%=itr1.next() %></td>
					<td><%=itr1.next() %></td>
					<td><%=itr1.next() %></td>
					<td><%=itr1.next() %></td>
					<td><%=itr1.next() %></td>
					<td><%=itr1.next() %></td>
					<td><%=itr1.next() %></td>
					<td><%=itr1.next() %></td>
					<td><%=itr1.next() %></td>
					<td><%=itr1.next() %></td>
					<td><%=itr1.next() %></td>
					<td><%=itr1.next() %></td>
				</tr>
				<% }%>
			</table>
		</center>
	</div>
</body>
</html>