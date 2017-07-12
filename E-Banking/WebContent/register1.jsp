<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Next Page</title>
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
				<td><div style="margin:70px 0 0 20px;"><a href="register.jsp" style="color:white;"><h2>Back</h2></a></div></td>
				<td >
					<div style="margin:30px 0px 0px 40px;">
						<span style="font-size:25px; color:white;">
							<span style="color:cyan;font-style: italic;"><u>Note:</u></span>After Registeration your Account will be activate within 2 working days.
							
						</span><br>
						<span style="font-size:25px; color:white; margin-left:60px;">Once the Account will activated you are able to perform online transaction.</span>
						
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
				<center><h1>OPEN NEW ACCOUNT</h1></center>
				<form action="CustomerContr?id=page2" method="post" onsubmit="return passMatch(this);">
					<table border="0" align="center" style="font-size:20px;"><!-- second tabel in form -->
					<tr>
						<td><div style="margin:10px;">State:&nbsp;&nbsp;</td>
						<td><select name="state" id="state" name="state" required onchange="setCities();">
							<option value="">Select State</option>
							<option value="Andra Pradesh">Andra Pradesh</option>
							<option value="Assam">Assam</option>
							<option value="Bihar">Bihar</option>
							<option value="Delhi">Delhi</option>
							<option value="Goa">Goa</option>
							<option value="Gujarat">Gujarat</option>
							<option value="Haryana">Haryana</option>
							<option value="Himachal Pradesh">Himachal Pradesh</option>
							<option value="Jammu and Kashmir">Jammu and Kashmir</option>
							<option value="Jharkhand">Jharkhand</option>
							<option value="Karnataka">Karnataka</option>
							<option value="Kerala">Kerala</option>
							<option value="Madhya Pradesh">Madhya Pradesh</option>
							<option value="Maharashtra">Maharashtra</option>
							<option value="Punjab">Punjab</option>
							<option value="Rajasthan">Rajasthan</option>
							<option value="Tamil Nadu">Tamil Nadu</option>
							<option value="Uttar Pradesh">Uttar Pradesh</option>
							
						</select><div></td>
						
					</tr>
					<tr>
						<td><div style="margin:10px;">City:&nbsp;&nbsp;</td>
						<td><select name="city" id="city" required>
							<option value='"'>Select city</option>
							
							</select>
							</div></td>
					</tr>
					<tr>
						<td><div style="margin:10px;">Type of Account:&nbsp;&nbsp;</td>
						<td><select name="account" required>
							<option value="">select</option>
							<option value="Saving">Saving</option>
							<option value="Deposit">Deposit</option>
						</select></div></td>
					</tr>
					<tr>
						<td><div style="margin:10px;">Adhar Number:&nbsp;&nbsp;</td>
						<td><input type="number" name="adhar" required onchange="return adharValidate(this)">
							
						</div></td>
					</tr>
					<tr>
						<td><div style="margin:10px;">PAN Number:&nbsp;&nbsp;</td>
						<td><input type="text" name="pan" required onchange="return panValidate(this)"></div></td>
					</tr>
					<tr>
						<td><div style="margin:10px;">Password:&nbsp;&nbsp;</td>
						<td><input type="password" name="pass" required></div></td>
					</tr>
					<tr>
						<td><div style="margin:10px;">Confirm Password:&nbsp;&nbsp;</td>
						<td><input type="password" name="cpass" required ></div></td>
					</tr>
					
					<tr>
						<td><div style="margin:10px;">Security Question:&nbsp;&nbsp;</td>
						<td><select name="sq" required>
							<option value="What is Your First School Name">What is Your First School Name</option>
							<option value="Which Place you Were Born">Which Place you Were Born</option>
							<option value="What is Your First Mobile Numbe">What is Your First Mobile Number</option>
							<option value="Who is Your First Class Teacher">Who is Your First Class Teacher</option>
						</select></div></td>
					</tr>
					<tr>
						<td><div style="margin:10px;">Answer:&nbsp;&nbsp;</td>
						<td><input type="text" name="ans" required></div></td>
					</tr>
					
						<tr>
							<td><div style="margin:20px;">
							<a href="register.jsp"><input type="button" name="back" value="Back"></a>
							</div></td>
							<td><div style="margin:20px;">
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