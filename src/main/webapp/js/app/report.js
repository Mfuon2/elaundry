var view = {
		list: function(){
	    	var ajax = new XMLHttpRequest();
	    	
	    	ajax.onreadystatechange = function(){
	    		
	    		if(ajax.readyState == 4){
	    			if(ajax.status == 200){
	    				document.getElementById('ajax-content').innerHTML = ajax.responseText;
	    				
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
	    						data+="<h3 class=\"panel-title\"> General Activity Report";
	    						data+="</h3>";
	    						data+="</header> <a class='btn btn-primary' onclick='view.printRep();'>Print</a>";
	    						data+="<div class=\"panel-body\">";
	    						data+="<div class=\"table-responsive\">";
	    						data+="<table class=\"table table-hover dataTable table-striped\" border=\"1\" id=\"exampleFixedHeader\">";
	    						data+="<thead>";
	    						data+="<tr style='background-color:black; color:white;'>";
	    						data+="<th>Title</th>";
	    						data+="<th>Trouble Description</th>";
	    						data+="<th>Client Name</th>";
	    						data+="<th>Ticket Status</th>";
	    						data+="<th>Last Updated</th>";
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
	    				
	    			}
	    		}
	    	
	    	
	    	ajax.open("GET", "./ticket", true);
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
