<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Neft Transfer</title>
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

function validate(x){
	 if(x.amount.value < 1 || x.amount.value > 1000000){
		 alert("amount can not be a less than 1Re and greater than 1000000Rs");
		 x.amount.focus();
		 return false;
	 }
	return true;	 
}

</script>

</head>
<body onload="check1()">
	<div>
		<center><h3>Neft Transfer</h3></center>
		<form action="CustomerContr?id=nftTransfer" method="post" onsubmit="return validate(this)">
			<table border="0" align="center" style="font-size:20px;" cellpadding="10" cellspacing="5">
				
				<tr>
					<td>Beneficiary Name:</td>
					<td><input type="text" name="bName" required onchange="return checkNum(this)"></td>
				</tr>
				<tr>
					<td>Beneficiary LastName:</td>
					<td><input type="text" name="lName" required onchange="checkNum(this)"></td>
				</tr>
				<tr>
					<td>Beneficiary AccountNo:</td>
					<td><input type="number" name="bNum" required></td>
				</tr>
				<tr>
					<td>Date:</td>
					<td><input type="text" name="dat" id="date1" readonly="readonly"></td>
				</tr>
				<tr>
					<td>Amount:</td>
					<td><input type="number" name="amount" required></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" name="s" value="Submit" style="font-size:20px; margin-left:150px;"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>