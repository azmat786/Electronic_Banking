<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Login Success</title>
<style type="text/css">
	.header{
		width:1335px;
		height:120px;
		background: url(image/adminf.jpg);
	}

	.footer{
		height:120px;
		width:1335px;
		background-color:#A9A9A9;
	}
	.middle{
		height:420px;
		width:1335px;
		background-color:#008080;
		padding-top:20px;
		padding-bottom:50px;
		
	}
	
	.header ul{
		padding:80px 0 0 30px;
		display:block;
	}
	.header ul li{
		display:inline;
		padding-left:10px;
	}
	.header ul li a{
		color:white;
		font-size:25px;
		padding:0px 0 0 0px;
		background-color:#808080;;
	}
	.header ul li a:hover{
		background-color:black;
	}
</style>
<%@page import="com.e_banking.web.dao.BankingDAOFactory" %>
<%@page import="com.e_banking.web.dao.BankingDAO" %>
<%@page import="java.util.Map" %>
<%@page import="java.util.List" %>
<%@page import="java.util.*" %>
<%@page import="java.io.*" %>

</head>
<body>
	
	<%
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
	%>
	
	
	
	<div class="header">
		<ul>
			<li><a href="AdminC?id=admin" >HOME</a></li>			
			<li><a href="deposit.jsp" target="adminS">DEPOSIT MONEY</a></li>
			<li><a href="activateD.jsp" target="adminS">ACTIVATE ACCOUNT</a></li>
			<li><a href="activatedAD.jsp" target="adminS">ACTIVATED ACCOUNT</a></li>
			<li><a href="closeAccountD.jsp" target="adminS">CLOSE ACCOUNT DETAIL</a></li>
			<li><a href="AdminContr?id=sessn">LOGOUT</a></li>
		</ul>
		
	</div>
	<div class="middle">
		<%
		String name=(String)session.getAttribute("username"); 
		%>
		<div style="font-size:25px;">Welcome:<%= name %></div>
			<iframe src="" name="adminS" height="450px" width="1330px" style="border:none;">
			
				
			</iframe>
		
	</div>
	
	<div class="footer"></div>
</body>
</html>