<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Money Deposit</title>

<script type="text/javascript">
function check1()
{
	var currdate=new Date();
	var datef=currdate.toLocaleDateString()
	document.getElementById("date1").value=datef;
	
}
function checkNum(x)
{
 		if (!(/^[A-Za-z]+$/.test(x.value)))
		{
			 alert("please enter letters only");
			 x.focus();
			 return false;	
			 
		}

	 return true;
}
</script>
<%@page import="com.e_banking.web.dao.BankingDAOFactory" %>
<%@page import="com.e_banking.web.dao.BankingDAO" %>
<%@page import="java.util.Map" %>

</head>
<body onload="check1()">
	
	<div style="margin-top:60px;">
		
		<div style="margin-left:1100px;"><!-- activate account -->
		</div><!-- activate account -->
		<center><form action="AdminContr?id=deposit" method="post" class="frm">
			<input type="number" placeholder="Account Number" name="account"><br><br>
			<input type="text" placeholder="Name" name="name" onchange="checkNum(this)"><br><br>
			<input type="text" placeholder="Last Name" name="lname" onchange="checkNum(this)"><br><br>
			<input type="number" placeholder="Amount" name="amount"><br><br>
			<input type="text" placeholder="" name="date" id="date1" readonly="readonly"><br><br>
			<input type="submit" name="submit" value="Submit">
		</form></center>
	</div>
	
</body>
</html>