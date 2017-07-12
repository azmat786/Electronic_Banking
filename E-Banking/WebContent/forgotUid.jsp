<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forgot UserId</title>
	<style type="text/css">
		.Uid{
			height: 380px;
			width: 450px;
			background-color: #B0C4DE;
			font-size:20px;
			margin-top:120px;
			padding-top:10px;
			
		}
	</style>
</head>
<body>
	<center><div class="Uid">
		<h2>Lost UserId</h2>
			<form action="CustomerContr?id=forgotUid" method="post">
					<table border=0 cellpadding="15">
						<tr>
							<td>Account Number:</td>
							<td><input type="number" name="account" required></td>
						</tr>
						<tr>
							<td>Password:</td>
							<td><input type="password" name="pass" required></td>
						</tr>
						<tr>
							<td>
								<a href="login.jsp"><input type="button" name="back" value="Back" style="margin:40px 0px 0px 60px;"></a>
							</td>
							<td>
								<input type="submit" name="submit" value="Submit" style="margin:40px 0px 0px 40px;">
							</td>
							
						</tr>
					</table>
			</form>	
	</div></center>

</body>
</html>