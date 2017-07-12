/**
 * 
 */

function validate()
{
	
	if(document.f.t2.value.length<16)
	{
		alert("card number should not less than 16 digit");
		document.f.t2.focus();
		return false;
	}
	if(document.f.t2.value.length>16)
	{
		alert("card number should not greater than 16 digit");
		document.f.t2.focus();
		return false;
	}
	if(document.f.t3.value.length>3 || document.f.t3.value.length<3 )
	{
		alert("ccv number should be 3 digit only");
		document.f.t3.focus();
		return false;
	}
	if(document.f.t5.value.length<4)
	{
		alert("Atm PIN must be 4 character only");
		document.f.t5.focus();
		return false;
	}
	if(document.f.t5.value.length>4)
	{
		alert("Atm PIN must be 4 character only");
		document.f.t5.focus();
		return false;
	}

	return true;
	
} 

function checkNum(x)
{
		if (!(/^\d+$/.test(x.value)))
		{
			alert("Enter CCV Number in Numeric only");
			x.focus();
		 	return false;
		}

	return true;
}


function checkPin(x)
{
		if (!(/^\d+$/.test(x.value)))
		{
			alert("Enter Pin Number in Numeric only");
			x.focus();
		 	return false;
		}

	return true;
}

function checkName(x)
{
 		if (!(/^[A-Za-z]+$/.test(x.value)))
		{
			 alert("please enter letters only");
			 x.focus();
			 return false;	
			 
		}

	 return true;
}