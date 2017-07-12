<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>

	<script type="text/javascript">
		function checkNum(x)
		{
	 		if (!(/^\d+$/.test(x.value)))
			{
				 alert("Enter userId in Numeric only");
				 x.focus();
				 return false;	
				 
			}

		 return true;
		}
		
		function checkUid(x){
			if(x.uid.value.length>7){
				alert("user id can not greter than 7 character");
				x.uid.focus();
				return false;
			}
			return true;
		}
</script>
<link href='http://fonts.googleapis.com/css?family=Droid+Sans' rel='stylesheet' type='text/css'>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
<!-- -->
<script>var __links = document.querySelectorAll('a');function __linkClick(e) { parent.window.postMessage(this.href, '*');} ;for (var i = 0, l = __links.length; i < l; i++) {if ( __links[i].getAttribute('data-t') == '_blank' ) { __links[i].addEventListener('click', __linkClick, false);}}</script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script>$(document).ready(function(c) {
	$('.alert-close').on('click', function(c){
		$('.message').fadeOut('slow', function(c){
	  		$('.message').remove();
		});
	});	  
});
</script>
</head>
<body>
	<%
	
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
	//response.sendRedirect("login.jsp");
	%>
	
	<div class="message warning">
<div class="inset">
	<div class="login-head">
		<h1>User Login Form</h1>
		 <a href="index.html"><div class="alert-close"> </div></a> 			
	</div>
		<form action="CustomerContr?id=log" method="post" onsubmit="return checkUid(this)">
			<li>
				<input type="text" class="text" placeholder="UserId" required name="uid" onchange="checkNum(this)" ><a href="#" class=" icon user"></a>
			</li>
				<div class="clear"> </div>
			<li>
				<input type="password" placeholder="Password" name="pass" required > <a href="#" class="icon lock"></a>
			</li>
			<div class="clear"> </div>
			<div class="submit">
				<input type="submit" onclick="myFunction()" value="Sign in" >
				<h4><a href="forgotPass.jsp">Lost your Password ?</a></h4>
				<h4><a href="forgotUid.jsp">Lost your UserId ?</a></h4>
						  <div class="clear">  </div>	
			</div>
				
		</form>
		</div>					
	</div>
	</div>
	<div class="clear"> </div>
</body>
</html>