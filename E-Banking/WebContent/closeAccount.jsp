<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Close Account</title>
<style type="text/css">
	<%@include file="css/register.css" %>
	
</style>
<script type="text/javascript">
	<%@include file="javascript/register.js"%>
</script>
</head>
<body bgcolor="#008080">
	<div id="header">
		<table border="0">
			<tr>
				<td><div style="margin:70px 0 0 20px;"><a href="index.html" style="color:white;"><h2>HOME</h2></a></div></td>
				<td >
					<div style="margin:30px 0px 0px 40px;">
						<span style="font-size:25px; color:white;">
							<span style="color:cyan;font-style: italic;"><u>Note:</u></span>Once you Close your Account then you are not a member of this Bank.
							
						</span>
						
					</div>
				</td>
			</tr>
		</table>
	</div>
	
	<div class="body">
		<table border="1"><!-- first tabel -->
			<tr>
				<td><div class="left-body"></div></td><!-- first div -->
				
				<td><div class="middle-body"> <!-- second div -->
				<center><h1>CLOSE ACCOUNT</h1></center>
				<form action="CustomerContr?id=close" method="post" >
					<table border="0" align="center" style="font-size:20px;"><!-- second tabel in form -->
					<tr>
						<td><div style="margin:14px;">First Name:&nbsp;&nbsp;</td>
						<td><input type="text" name="fname" required onchange="checkNum(this)"></div></td>
						
					</tr>
					<tr>
						<td><div style="margin:14px;">Last Name:&nbsp;&nbsp;</td>
						<td><input type="text" name="lname" onchange="checkNum(this)"></div></td>
						
					</tr>
					<tr>
						<td><div style="margin:14px;">Father Name:&nbsp;&nbsp;</td>
						<td><input type="text" name="faname" required onchange="checkNum(this)"></div></td>
					</tr>
					<tr>
						<td><div style="margin:14px;">Account Number:&nbsp;&nbsp;</td>
						<td><input type="number" name="account" required>
						</div></td>
					</tr>
					<tr>
						<td><div style="margin:14px;">Date of Birth:&nbsp;&nbsp;</td>
						<td><input type="date" name="date" required id="date" onchange="checkDate()"></div></td>
					</tr>
					<tr>
						<td><div style="margin:14px;">UserId:&nbsp;&nbsp;</td>
						<td><input type="number" name="uid" required></div></td>
					</tr>
					
						<tr>
							<td><div style="margin:30px;">
							<input type="reset" name="clear" value="Clear" style="float:left;"  >
							</div></td>
							<td><div style="margin:30px;">
							<input type="submit" name="submit" value="Submit" style="float:right;" >
							</div></td>
							
						</tr>
						
					</table>
				</form>
				
				</div></td>
				<td><div class="right-body"></div></td><!-- third div -->
			</tr>
		</table>
	</div>
	
	<div class="footer"></div>
</body>
</html>