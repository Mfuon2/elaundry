var user = {
		
		save : function(){
			var ajax = new XMLHttpRequest();
			

	    	var fullname = document.getElementById("fullname").value;
	    	var username = document.getElementById('username').value;
	    	var email = document.getElementById('email').value;
	    	var password = document.getElementById("password").value;
	    	console.log(password);
	    	var confirmpassword = document.getElementById('confirmpassword').value;
	    	
	    	var params = 'fullname=' + encodeURIComponent(fullname) 
	    		+ '&username=' + encodeURIComponent(username)
	    		+ '&email=' + encodeURIComponent(email)
	    		+ '&password=' + encodeURIComponent(password)
	    		+ '&confirmpassword=' + encodeURIComponent(confirmpassword);
	    	
	    	if(password == confirmpassword){
	    		
	    		ajax.onreadystatechange = function(){
					if(ajax.readyState == 4){
						if(ajax.status == 200){
							document.getElementById('register-ajax-content').innerHTML = ajax.responseText;
							document.getElementById('register-success').innerHTML = "Registration Successful";		
							document.getElementById('register-success').innerHTML = "Please Login";	
							
						}
					}
				}
	    		
	    		ajax.open("POST", "./user/*", true);
	    		ajax.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	    		ajax.send(params);
	    		
	    	}else{
	    		console.log("Password Missmatch");
	    		document.getElementById('register-ajax-content').innerHTML = "Please enter passwords that match";	    		
	    	}
		},
		
		login: function(){
			var thisInstance = this;
	    	var ajax = new XMLHttpRequest();
	    	var username = document.getElementById('username').value;
	    	var password = document.getElementById('password').value;
	    	
	    	var params = 'username=' + encodeURIComponent(username)
	    		+ '&password=' + encodeURIComponent(password);
	    		ajax.onreadystatechange = function(){
		    		
		    		if(ajax.readyState == 4){
		    			if(ajax.status == 200){
		    				
		    					document.getElementById('login-ajax-content').innerHTML = ajax.responseText;
		    				
		    			}
		    		}
		    	}
		    	
		    	ajax.open("POST", "./welcome", true);
		    	ajax.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		    	ajax.send(params);
	    		
		},
}

function hala(){
	
};
