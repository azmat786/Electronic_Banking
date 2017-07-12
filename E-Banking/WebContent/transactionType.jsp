<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transaction Type</title>
	<style type="text/css">
		ul{
			display:block;
			
		}
		ul li{
			display:inline-block;
			padding-left:20px;
		}
		ul li a{
			background-color:#008080;
			font-size:30px;
			text-decoration: none;
			font-style: oblique;
			text-transform: inherit;
			color:#F5F5F5;
			text-align: center;
		}
		ul li a:hover{
			background-color:#4682B4;
		}
		
	</style>
	
</head>
<body>
	<div style="height:0px; width:0px;">
	<table border="0">
	<tr>
		<td><div style=" widht:200px; height:40px;">
			<ul>
				<li><a href="neftTransfer.jsp" target="transfer">NEFT</a></li>
				<li><a href="rtgsTransfer.jsp" target="transfer">RTGS</a></li>
			</ul>
			</div>
		</td>
		<td><div style="widht:200px; height:50px;"><a href="neftDes.jsp" target="transfer">What is NEFT?</a></div></td>
		<td><div style="widht:200px; height:50px;"><a href="rtgsDes.jsp" target="transfer">What is RTGS?</a></div></td>
	</tr>
		<tr>
		<td colspan="3">
			<div >
					
					<iframe src="" height="390px" width="750px" name="transfer" style="border:none"> 
					
					</iframe>
					
			</div>
		</td>

</tr>
	</table>
	</div>
</body>
</html>