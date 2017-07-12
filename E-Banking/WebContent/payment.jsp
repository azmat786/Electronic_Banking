<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment </title>
	<script type="text/javascript">
		function ValidateForm(form){
			ErrorText= "";
			if ( ( form.r[0].checked == false ) && ( form.r[1].checked == false ) && ( form.r[2].checked == false ) ) 
			{
				alert ( "Please select type of Card"); 
				return false;
			}
			if (ErrorText= "") { form.submit() }
		}
	</script>
</head>
<body>
	<div class="r"><h2 align="center">Payment procedure</h2></div>
		<form name="f" method="post" action="CustomerContr?id=payment">
			<h1 align="center">Select Type of card:</h1><br /><center><input type="radio" name="r" value="maestro" /><img src="image/maestro.jpg" height="50" width="144" />
			<input type="radio" name="r" value="master" /><img src="image/master.jpg" height="50" width="130" />
			<input type="radio" name="r" value="visa" /><img src="image/visa.jpg" height="60" width="150" /></center>
			<br /><br /><br /><br />
			<center>
				<a href="rechargeType.jsp"><input type="button" name="b" value="Back" /></a>
				<input type="submit" name="s" value="Proceed" onclick=" return ValidateForm(this.form)" />
			</center>
		</form>

<div class="r2"></div>

</body>
</html>