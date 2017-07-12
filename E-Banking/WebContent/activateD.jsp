<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Activate Account Details</title>
<%@page import="com.e_banking.web.dao.BankingDAOFactory" %>
<%@page import="com.e_banking.web.dao.BankingDAO" %>
<%@page import="java.util.List" %>
<%@page import="java.util.*" %>
<%@page import="java.io.*" %>


</head>
<body>
	<%
		BankingDAO dao1 = BankingDAOFactory.getInstance();
		List li = dao1.activateDis();
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
					<th>Address</th>
					<th>Type-of-Account</th>
					<th>Adhar Number</th>
					<th>PAN Number</th>
					<th>Account Number</th>
					<th>Click to Activate</th>
					
				</tr>
				<%
					Iterator itr = li.iterator(); 
					while(itr.hasNext()){
				%>
				<tr>
					<td><%=itr.next() %></td>
					<td><%=itr.next() %></td>
					<td><%=itr.next() %></td>
					<td><%=itr.next() %></td>
					<td><%=itr.next() %></td>
					<td><%=itr.next() %></td>
					<td><%=itr.next() %></td>
					<td><%=itr.next() %></td>
					<td><%=itr.next() %></td>
					<%int accountA = (int)itr.next(); %>
					<td><%=accountA %></td>
					<td><a href="AdminContr?id=activateAccount&ac=<%session.setAttribute("acA",accountA);%>">Activate</</a></td>
				</tr>
				<%} %>
			</table>
		</center>
	</div>
</body>
</html>