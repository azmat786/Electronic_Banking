<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Recharge Same from Bank</title>
</head>
<body>
	<center>
		<div style="font-size:20px;margin-top:150px;">
			<form action="CustomerContr?id=mRechSameBank" method="post">
				<input type="password" name="pass" placeholder="Password" >
				
				<div style="margin-top:15px;">
					<a href="rechargeType.jsp"><input type="button" value="Back"></a>
					<input type="submit" value="Submit">
				</div>
			</form>
			 
		</div>
		
	</center>
</body>
</html>