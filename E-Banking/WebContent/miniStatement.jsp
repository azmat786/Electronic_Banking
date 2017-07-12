<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mini Statement</title>
<%@page import="com.e_banking.web.dao.BankingDAOFactory" %>
<%@page import="com.e_banking.web.dao.BankingDAO" %>
<%@page import="java.util.List" %>
<%@page import="java.util.*" %>
<%@page import="java.io.*" %>
</head>
<body>
	<%
		int account1=(int)session.getAttribute("account");
		BankingDAO dao1 = BankingDAOFactory.getInstance();
		List li = dao1.miniStat(account1);
		
	%>
	<div style="margin-top:50px;"> 
	<div style="font-size:18px;color:black;margin-left:240px;">Name:  <%=session.getAttribute("fname") %>&nbsp;<%=session.getAttribute("lname") %></div>
	<div style="font-size:18px;color:black;margin-left:240px;">Account Number:  <%=session.getAttribute("account") %></div>
	<table border="1" align="center" >
		<tr>
			
			<th>Amount:</th>
			<th>Date:</th>
			<th>Description:</th>
			<th>Transfer Detail</th>
		</tr>
			
			<%
			int j=0;
			Iterator i=li.iterator();
			while(i.hasNext()){	
				//i.next();
			%>
		<tr>
			<td><%=i.next()%></td>
			<td><%=i.next()%></td>
			<td><%=i.next()%></td>
			<td><%=i.next()%></td>
			
		</tr>
		<%
		//j++;
		
		}
		%>
		
	
	</table>
	<div style="margin-left:600px;margin-top:50px;"><a href="miniStatement.jsp"><input type="button" onclick="print()" value="Print" style="font-size:20px;"></a></div>
</div>
</body>
</html>