<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment1</title>
<style type="text/css">
li{
	display:inline;
}
.frm{

	font-size:18px;
	margin-top:60px;
	padding-top:10px;
}

	
</style>
<script type="text/javascript">
	<%@include file="javascript/payment1.js"%>
</script>

</head>

<body>
	<div class="frm">
	<center><form name="f" method="post" action="CustomerContr?id=payment1" onsubmit="return validate();">
		<table  cellpadding=10>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="t1" placeholder="as per the card" onchange="checkName(this)"  required  /></td>
			</tr>
			
			<tr>
				<td>Card Number:</td>
				<td><input type="number" name="t2" onchange="checkNum(this)" required/></td>
			</tr>
			
			<tr>
				<td>CCV Number:</td>
				<td><input type="password" name="t3" size="5px" onchange="checkNum(this)" required/></td>
			</tr>
			
			<tr>
				<td>Valid Through:</td>
				<td>
					<li><select  name="ccExpiryMonth" required >
                		<option value="0">MM</option>
						<option value="01">01</option>
						<option value="02">02</option>
						<option value="03">03</option>
						<option value="04">04</option>
						<option value="05">05</option>
						<option value="06">06</option>
						<option value="07">07</option>
						<option value="08">08</option>
						<option value="09">09</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
               		</select></li>
                    <li>
                    <select  name="ccExpiryYear"  required>
             				<option value="0">YY</option>
                            <option value="2014">2014</option>
                            <option value="2015">2015</option>
                            <option value="2016">2016</option>
                            <option value="2017">2017</option>
                            <option value="2018">2018</option>
                            <option value="2019">2019</option>
                            <option value="2020">2020</option>
                            <option value="2021">2021</option>
                            <option value="2022">2022</option>
                            <option value="2023">2023</option>
                            <option value="2024">2024</option>
                            <option value="2025">2025</option>
                            <option value="2026">2026</option>
                            <option value="2027">2027</option>
                            <option value="2028">2028</option>
                            <option value="2029">2029</option>
                            <option value="2030">2030</option>
                            <option value="2031">2031</option>
                            <option value="2032">2032</option>
                            <option value="2033">2033</option>
                            <option value="2034">2034</option>
                            <option value="2035">2035</option>
                            <option value="2036">2036</option>
                            <option value="2037">2037</option>
                            <option value="2038">2038</option>
                            <option value="2039">2039</option>
                            <option value="2040">2040</option>
                            <option value="2041">2041</option>
                            <option value="2042">2042</option>
                            <option value="2043">2043</option>
                            <option value="2044">2044</option>
                            <option value="2045">2045</option>
                            <option value="2046">2046</option>
                            <option value="2047">2047</option>
                            <option value="2048">2048</option>
                            <option value="2049">2049</option>
                	</select></li>
				</td>
				
			</tr>
			
			<tr>
				<td>ATM PIN:</td>
				<td><input type="password" size="7px" name="t5" onchange="checkPin(this)" /></td>
			</tr>
		</table>
			<a href="payment.jsp"><input type="button" name="b" value="Back" /></a>
			<input type="submit" name="s" value="Submit"/ style="margin-top:30px;">   
	</form></center>    
	</div>
</body>
</html>