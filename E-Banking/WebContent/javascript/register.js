/**
 * 
 */
var cities = new Array();
	cities['Andra Pradesh'] = new Array('Amaravati','Heydrebad','visakhapatnam','vijayawada');
	cities['Assam'] = new Array('Guwahati','Hojai','Silchar','Tezpur');
	cities['Bihar'] = new Array('Ara','Bihar Sharif','patna','Siwan');
	cities['Delhi'] = new Array('Delhi','New Delhi','Faridabad');
	cities['Goa'] = new Array('Anjuna','Baga','Colva','Dona Paula','Panaji');
	cities['Gujarat'] = new Array('Ahmedabad','Anand','Bhavnagar','Bharuch','Rajkot','Surat','Vapi','Vadodara'); 
	cities['Haryana'] = new Array('Ambala','Bahadurgarh','Chandigarh','Faridabad');
	cities['Himachal Pradesh'] = new Array('Baddi','Dharmasala','Manali','Shimla');
	cities['Jammu and Kashmir'] = new Array('Anantnag','Budgam','Jammu','Srinagar');
	cities['Jharkhand'] = new Array('Dhanbad','Jamshedpur','Ranchi');
	cities['Karnataka'] = new Array('Bangalore','Belgaum','Gulbarga','Hubli','Mangalore','Mysore');
	cities['Kerala'] = new Array('Alappuzha','Kochi','Kollam','Thiruvandrum');
	cities['Madhya Pradesh'] = new Array('Bhopal','Gwalior','Indore','Jabalpur');
	cities['Maharashtra'] = new Array('mumbai','Nagpur','pune');
	cities['Punjab'] = new Array('Amritsar','Mohali');
	cities['Rajasthan'] = new Array('Ajmer','Jaipur','Jodhpur','Kota','Udaipur');
	cities['Tamil Nadu'] = new Array('chennai','coimbatore');
	cities['Uttar Pradesh'] = new Array('Gorakhpur','Lucknow','Kanpur');
	
	
	
	function setCities(){
		stateSel = document.getElementById('state');
		cityList = cities[stateSel.value];
		changeSelect('city',cityList,cityList);
		
	}
	function changeSelect(fieldID,newOptions,newValues){
		selectField = document.getElementById(fieldID);
		selectField.options.length=0;
		for(i=0;i<newOptions.length;i++){
			selectField.options[selectField.length]=new Option(newOptions[i],newValues[i]);
			
		}
	}
	
	function addLoadEvent(func){
		var oldonload=window.onload;
		if(typeof window.onload!='function'){
			window.onload=func;
			
		}else{
			window.onload=function(){
				if(oldonload){
					oldonload();
				}
				func();
			}
		}
	}
	
	addLoadEvent(function(){
		setCities();
	});
	
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
	
	function passMatch(x){
		if(x.pass.value!=x.cpass.value){
			alert("Password doesn't match");
			return false;
			x.cpass.focus();
		}
		if(x.pass.value.length<6){
			alert("Password length must be atleat 6 digit ");
			x.pass.focus();
			return false;
			
		}
		return true;
	}
	
	function isPastDate(idate)
	{
		var today = new Date().getTime(),
    	idate = idate.split("-");
		idate = new Date(idate[0], idate[1] - 1, idate[2]).getTime();
		return ( today - idate) > 0 ? false : true;
	}

	function checkDate()
	{
		var idate = document.getElementById("date"),
    	dateReg = /201[4-9]|20[2-9][0-9][\-](0[1-9]|1[012])[\-](0[1-9]|[12][0-9]|3[01])/; 
		if(dateReg.test(idate.value))
		{
    		if(isPastDate(idate.value))
    		{
         		alert("please enter past date only");
         		return false;
        		
    		}
			
		} 
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
	
	function panValidate(x)
	{
			if (!(/10/.test(x.value.length)))
			{
			alert("PAN number must contain 10 digit");
			x.focus();
			return false;
		}
	 
	}
	
	function adharValidate(x)
	{
			if (!(/12/.test(x.value.length)))
			{
			alert("Adhar number must contain 12 digit");
			x.focus();
			return false;
		}
	 
	}