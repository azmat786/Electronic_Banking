<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>After Login</title>
	<style type="text/css">
	<%@include file="css/loginSuccess.css" %>
	</style>
<script type="text/javascript">
	
</script>

</head>


<body>
	<%
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Cache-Control", "no-store");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
	%>

	<%
	int sesn = 0;
		 sesn = (int)session.getAttribute("account");
		if(sesn==0){
			RequestDispatcher rd = request.getRequestDispatcher("sessionExp.jsp");
			rd.forward(request, response);
		}
	%>
	<div class="headerLS"><!-- start header -->
	<div style="margin-left:1000px;margin-top:90px; font-size:25px;"><a href="CustomerContr?id=sessn" style="color:#008B8B" > LogOut</a></div>
	</div><!--end header -->
	<table border=1px style="margin-left:120px">
		<tr>
			<td>
				<div class="left-body"><!--start body -->
					<div class="list-left"><center><a href="customer?id=customer"  style="text-decoration:none">Home</a></center></div>
					<div class="list-left"><center><a href="accountDetail.jsp" target="success" style="text-decoration:none">ACCOUNT</a></center></div>
					<div class="list-left"><center><a href="transactionType.jsp" target="success" style="text-decoration:none">FUND TRANSFER</a></center></div>
					<div class="list-left"><center><a href="miniStatement.jsp" target="success" style="text-decoration:none">MINI STATEMENT</a></center></div>
					<div class="list-left"><center><a href="mRecharge.jsp" target="success" style="text-decoration:none">MOB RECHARGE</a></center></div>
					<div class="list-left"><center><a href="insurance.jsp" target="success" style="text-decoration:none">INSURANCE</a></center></div>
					<div class="list-left"><center><a href="loan.jsp" target="success" style="text-decoration:none">LOANS</a></center></div>
				</div><!-- end body -->
			</td>
			<td>
				<div class="middle-body">

				<div style="font-size:25px;color:green;">Hello: <%=session.getAttribute("fname") %>&nbsp;<%=session.getAttribute("lname") %></div>
				
					<iframe src="welcomeLoginSuccess.jsp" width="820px" height="470px" name="success" style="border:none;">
					
					</iframe>
		
				</div>
				
			</td>
			
		</tr>
	</table>
	<div><!-- start footer -->
	</div><!-- end footer -->
</body>
</html>