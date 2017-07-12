<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mobile Recharge</title>
	<script type="text/javascript">
function check1()
{
	var currdate=new Date();
	var datef=currdate.toLocaleDateString()
	document.getElementById("date1").value=datef;
	
	
}
function phoneValidate(x)
{
		if (!(/10/.test(x.value.length)))
		{
		alert("phone number must contain 10 digit");
		x.focus();
		return false;
	}
 
}

function validate(x){
	 if(x.amount.value < 5 ){
		 alert("amount can not be a less than 5 Rs ");
		 x.amount.focus();
		 return false;
	 }
	return true;	 
}
</script>
</head >
<body onload="check1()">
	<div style="margin-top:100px;">
		<form action="CustomerContr?id=mRecharge" method="post" onsubmit="return validate(this)">
			<table border="0" align="center" style="font-size:20px;" cellpadding="10" cellspacing="5">
				
				<tr>
					<td>Mobile Number:</td>
					<td><input type="number" name="mNum" required onchange="phoneValidate(this)" ></td>
				</tr>
				<tr>
					<td>Select Network:</td>
					<td>
						<select name="s" required>
							<option value="">select</option>
							<option value="Airtel">Airtel</option>
							<option value="Vodafone">Vodafone</option>
							<option value="Idea">Idea</option>
						</select>
					</td>
				</tr>
				
				<tr>
					<td>Amount:</td>
					<td><input type="number" name="amount" required></td>
				</tr>
				<tr>
					<td>Date:</td>
					<td><input type="text" name="dat" id="date1" readonly="readonly"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" name="s" value="PayNow" style="font-size:18px; margin-left:150px;"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>