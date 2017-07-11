function getElById(el){
	return document.getElementById(el);
}

function formDisplay(form){
	var ajax = new XMLHttpRequest();
	ajax.onreadystatechange = function(){
		if(ajax.readyState<4){
			
			getElById('ajax-content').innerHTML = "Loading...";
			
			swal({
				  title: "Please Wait...",
				  timer: 500,
				  imageUrl: "js/app/loading.gif",
				  showConfirmButton: false
				});
		}
		
		if(ajax.readyState == 4){
			if(ajax.status == 200){
				getElById('ajax-content').innerHTML = form;
			}
		}
	}
	
	ajax.open("GET", './tech.jsp', true);
	ajax.send();
		
}

function searchPerson(){
	
	var form = 	"<div class='panel'>" +
					"<div class='panel-heading'>" +
						"<h1 class='panel-title'>View Occupied Technicians</h1>" +
					"</div>" +
					"<div class='panel-body container-fluid'>" +
						"<form method='#' action='./search/list1'>" +
							"<div class='form-group form-material floating'>" +
							"<label class='floating-label'>Search by Tech-Id: <i class='fa fa-search'></i></label>" +
							"<input type='text' class='form-control'  id='search' name='search'/>" +
							"</div>" +
							"<a class='btn btn-primary' onclick='searchTech()'>List Issues</a>" +
						"</form>" +
					"</div>" +
				"</div>";
	
	formDisplay(form);
}
//Dispaly Search Results
function searchResults(uri){
	var ajax = new XMLHttpRequest();
	
	ajax.onreadystatechange = function(){
		if(ajax.readyState<4){
			
			getElById('ajax-content').innerHTML = "Loading...";
		}		
		
		if(ajax.readyState == 4){
			if(ajax.status == 200){
				
				
			}
		}		
	}
	ajax.open('GET', uri, true);
	ajax.send();
}

////+++++++++++++++++++++++++++++++++++++++++++++++++++++

function searchTech(){
	var search = getElById('search').value;
	
	var params = 'search=' +encodeURIComponent(search); 
	
	var message = "Saved successfully!";
	save(params, "./search/list1", message);
}

function save(params, uri, message){
	var ajax = new XMLHttpRequest();
	ajax.onreadystatechange = function(){
		if(ajax.readyState == 4){
			if(ajax.status == 200){
				var response = ajax.responseText;
				//console.log(response);
				var jsonRecords = JSON.parse(response);
				console.log(jsonRecords);
				
				if(jsonRecords == 0){
					sweetAlert("Oops...","You have no Pending Issues or You Provided a wrong Tech ID e.g 1007", "error");
					
				}else{
					
					swal({
						  title: "Please Wait...",
						  timer: 500,
						  imageUrl: "js/app/loading.gif",
						  showConfirmButton: false
						});
					
					var data = "<div class=\"panel\">";
					data+="<header class=\"panel-heading\">";
					data+="<h3 class=\"panel-title\">";
					data+="Work List for "
					
					for (var i in jsonRecords){					
						var id = jsonRecords[i].id;   
				        
					}
					data+="<h3 style='color:red;'>"+ jsonRecords[i].assign +"</h3";
					data+="</h3>";
					data+="</header>";
					data+="<div class=\"panel-body\">";
					data+="<div class=\"table-responsive\">";
					data+="<table class=\"table table-hover dataTable table-striped\" id=\"exampleFixedHeader\">";
					data+="<thead>";
					data+="<tr>";
					data+="<th>Title</th>";
					data+="<th>Trouble Description</th>";
					data+="<th>Client Name</th>";
					data+="<th>Ticket Status</th>";
					data+="<th>Posted On</th>";
					data+="<th>Updated On</th>";
					data+="<th>Pedding Days</th>";
					data+="<th>Updated By</th>";
					data+="</tr>";
					data+="</thead>";
					data+="<tbody>";
					
					for (var i in jsonRecords){					
						var id = jsonRecords[i].id;
						data+="<tr>";
					    data+="<td>"+jsonRecords[i].title+"</td>";
					    data+="<td>"+jsonRecords[i].descr+"</td>";
				        data+="<td>"+jsonRecords[i].reportedby+"</td>";
				        data+="<td>"+jsonRecords[i].status+"</td>";
				        data+="<td>"+jsonRecords[i].postdate+"</td>";
				        data+="<td>"+jsonRecords[i].updatetime+"</td>";
				        if(jsonRecords[i].days >= 5){
				        	data+="<td style='color:red;'>"+jsonRecords[i].days+"Day(s)<i>[Urgent]</i></td>"
				        }else{
				        	data+="<td style='color:green;'>"+jsonRecords[i].days+"Day(s)</td>"
				        }
				        data+="<td>"+jsonRecords[i].updatedby+"</td>";
				        
				        data+="</tr>";
				        
					}						
						data+="</tbody>";
						data+="</table>";
						data+="</div>";
						data+="</div>";
						data+="</div>";	
			
					getElById('ajax-content').innerHTML = data;
					
				}
								
			}
			else
				sweetAlert("Your Session Expired ","Re-LogIn", "error");
		}
	}
	ajax.open("POST", uri, true);
	ajax.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	ajax.send(params);
}