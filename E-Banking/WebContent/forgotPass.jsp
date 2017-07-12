<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forgot password</title>
	<style type="text/css">
		.fpass{
			height: 410px;
			width: 450px;
			background-color: #B0C4DE;
			font-size:20px;
			margin-top:60px;
			padding-top:10px;
			
		}
	</style>
	<script type="text/javascript">
		function checkPass(x){
			if(x.rePass.value.length<6){
				alert("Password must be atleast 6 character ");
				x.rePass.focus();
				return false;
			}
			return true;
		}
	</script>
</head>
<body>
	<center><div class="fpass">
			<h2>Forgot Password</h2>
			
		<form action="CustomerContr?id=forgotPass" method="post" onsubmit="return checkPass(this)">	
		<table border=0 cellpadding="10">
			<tr>
				<td>Account Number:</td>
				<td><input type="number" name="account" required></td>
			</tr>
			<tr>
				<td>Security Question:</td>
				<td><select name="sq" required>
					<option value="What is Your First School Name">What is Your First School Name</option>
					<option value="Which Place you Were Born">Which Place you Were Born</option>
					<option value="What is Your First Mobile Numbe">What is Your First Mobile Number</option>
					<option value="Who is Your First Class Teacher">Who is Your First Class Teacher</option>
				</select></td>
				
			</tr>
			<tr>
				<td>Answer:</td>
				<td><input type="text" name="ans" required></td>
			</tr>
			<tr>
				<td>New Password:</td>
				<td><input type="text" name="rePass" required ></td>
			</tr>
			
			<tr>
				<td>
					<a href="login.jsp"><input type="button" name="back" value="Back" style="margin:40px 0px 0px 60px;"></a>
				</td>
				<td>
					<input type="submit" name="submit" value="Submit" style="margin:40px 0px 0px 40px;">
				</td>
							
			</tr>
			
		</table></form>
	</div></center>

</body>
</html>