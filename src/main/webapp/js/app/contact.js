var contact = {
		list: function(){
	    	var ajax = new XMLHttpRequest();
	    	
	    	ajax.onreadystatechange = function(){
	    		
	    		if(ajax.readyState == 4){
	    			if(ajax.status == 200){
	    				//document.getElementById('ajax-content').innerHTML = ajax.responseText;
	    				
	    					var response = ajax.responseText;
	    					//console.log(response);
	    					var jsonRecords = JSON.parse(response);
	    					console.log(jsonRecords);
	    						
	    						swal({
	    							  title: "Please Wait...",
	    							  timer: 500,
	    							  imageUrl: "js/app/loading.gif",
	    							  showConfirmButton: false
	    							});
	    						
	    						var data = "<div class=\"panel\">";
	    						data+="<header class=\"panel-heading\">";
	    						data+="<h3 class=\"panel-title\"> Companies Contact List";
	    						data+="</h3>";
	    						data+="</header> <a class='btn btn-primary' onclick='contact.printRep();'>Print</a>";
	    						data+="<div class=\"panel-body\">";
	    						data+="<div class=\"table-responsive\">";
	    						data+="<table class=\"table table-hover dataTable table-striped\" border=\"0.1\" id=\"exampleFixedHeader\">";
	    						data+="<thead>";
	    						data+="<tr style='background-color:black; color:white;'>";
	    						data+="<th>Full Name</th>";
	    						data+="<th>Email</th>";
	    						data+="<th>User Type</th>";
	    						data+="</tr>";
	    						data+="</thead>";
	    						data+="<tbody>";
	    						
	    						for (var i in jsonRecords){

	    						    var user = jsonRecords[i].usertype;
	    						    
	    						    if(user == "client" || user == "admin" ){
	    						    	data+="<tr>";
		    						    data+="<td></td>";
		    						    data+="<td></td>";
		    					        data+="<td></td></tr>";
	    						    	
	    						    }else{
	    						    	var id = jsonRecords[i].id;
		    							data+="<tr>";
		    						    data+="<td>"+jsonRecords[i].fullname+"</td>";
		    						    data+="<td><a href="+"mailto:+"+jsonRecords[i].email+">"+jsonRecords[i].email+"</a></td>";
		    					        data+="<td>"+ user +"</td></tr>";
	    						    }
	    							
	    						}						
	    							data+="</tbody>";
	    							data+="</table>";
	    							data+="</div>";
	    							data+="</div>";
	    							data+="</div>";	
	    				
	    						getElById('ajax-content').innerHTML = data;
	    						
	    					}
	    									
	    				}
	    				
	    	}
	    	
	    	
	    	ajax.open("GET", "./user", true);
	    	ajax.send();
	    	
		
},
		printRep: function(){
            var divContents = document.getElementById("ajax-content").innerHTML
            var printWindow = window.open('', '', 'height=400,width=800');
            printWindow.document.write('<html><head><title>General Report</title>');
            printWindow.document.write('</head><body >');
            printWindow.document.write(divContents);
            printWindow.document.write('</body></html>');
            printWindow.document.close();
            printWindow.print();
        }
}
