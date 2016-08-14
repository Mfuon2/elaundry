function getElById(el){
	return document.getElementById(el);
}

function formDisplay(form){
	var ajax = new XMLHttpRequest();
	ajax.onreadystatechange = function(){
		if(ajax.readyState<4)
			getElById('ajax-content').innerHTML = "Loading...";
		
		if(ajax.readyState == 4){
			if(ajax.status == 200){
				getElById('ajax-content').innerHTML = form;
			}
		}
	}
	
	ajax.open("GET", './client.jsp', true);
	ajax.send();
		
}

function createPerson(){
	
	var form = 	"<div class='panel'>" +
					"<div class='panel-heading'>" +
						"<h1 class='panel-title'>Clients Reporting Page Or <a href='contact.list()'>Contact Us</a></h1>" +
					"</div>" +
					"<div class='panel-body container-fluid'>" +
						"<form autocomplete='off' method='post' action='#'>" +

							"<div class='form-group form-material floating'>" +
							"<label class='floating-label'>Title</label>" +
							"<input type='text' class='form-control' id='title' name='title' />" +
							"</div>" +
							
							"<div class='form-group form-material floating'>" +
							"<label class='floating-label'>Your Client ID :</label>" +
							"<input type='text' class='form-control' id='reportedby' name='reportedby' />" +
							"</div>" +
							
							"<div class='form-group form-material floating'>" +
							"<label class='floating-label'>Priority</label><br>" +
								"<select class='c-select' id='priority' name='priority'>" +
								"<option selected></option>" +
								"<option value='LOW'>LOW</option>" +
								"<option value='MEDIUM'>MEDIUM</option>" +
								"<option value='HIGH'>HIGH</option>" +
								"</select>" +
								
							"</div>" +
							"<div class='form-group form-material floating'>" +
							"<label class='floating-label'>Problem Description</label>" +
							"<textarea class='form-control'id='descr' name='descr' rows='3'></textarea>" +
						"</div>"+
						
						"</form>" +
						"<a class='btn btn-primary' onclick='savePerson();'>Report Problem</a>" +
					"</div>" +
				"</div>";
	
	formDisplay(form);
}

function savePerson(){
	var title = getElById('title').value;
	var reportedby = getElById('reportedby').value;
	var priority = getElById('priority').value;
	var descr = getElById('descr').value;
	
	var params = 'title=' +encodeURIComponent(title) 
	+ '&reportedby=' + encodeURIComponent(reportedby) 
	+ '&priority=' + encodeURIComponent(priority) 
	+ '&descr=' + encodeURIComponent(descr); 
	
	var message = "Staff saved successfully!";
	save(params, "./repoticket/*", message);
}

function save(params, uri, message){
	var ajax = new XMLHttpRequest();
	ajax.onreadystatechange = function(){
		if(ajax.readyState<4)
			getElById('ajax-content').innerHTML = "Loading...";
		
		if(ajax.readyState == 4){
			if(ajax.status == 200){
				//getElById('ajax-form-content').innerHTML = ajax.responseText;
				swal("Thanks We will get back to You!", message, "success");
				createPerson();
			}
			else
				bootbox.alert("Failed!")
		}
	}
	ajax.open("POST", uri, true);
	ajax.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	ajax.send(params);
}