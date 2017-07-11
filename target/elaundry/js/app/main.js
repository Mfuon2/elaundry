
//(function(){
//	var elem = document.createElement("img");
//	elem.setAttribute("src", "js/app/helpdesk.jpg");
//	elem.setAttribute("display", "block");
//	elem.setAttribute("height", "80%");
//	elem.setAttribute("width", "100%");
//	//elem.setAttribute("margin","auto");
//	elem.setAttribute("alt", "Flower");
//	document.getElementById("ajax-content").appendChild(elem);
//	document.getElementById("ajax-content").style.padding = "20px 25% 25%";
//	document.getElementById("ajax-content").style.marginLeft = "auto";
//	document.getElementById("ajax-content").style.marginRight = "auto";
//	
//})();

function contactUs(){
	getElById('ajax-content').innerHTML = "Loading...";
		
	}

(function(){
    var ajax = new XMLHttpRequest();
    
    ajax.onreadystatechange = function(){
       
       if(ajax.readyState == 4){
          if(ajax.status == 200){
             document.getElementById('open-tickets').innerHTML = ajax.responseText;
             console.log(ajax.responseText);
          }
       }
    }
    
    ajax.open("GET", "./search/list2", true);
    ajax.send();
})();

(function(){
    var ajax = new XMLHttpRequest();
    
    ajax.onreadystatechange = function(){
       
       if(ajax.readyState == 4){
          if(ajax.status == 200){
             document.getElementById('all-tickets').innerHTML = ajax.responseText;
             console.log(ajax.responseText);
          }
       }
    }
    
    ajax.open("GET", "./search/allTicktets", true);
    ajax.send();
})();

(function(){
    var ajax = new XMLHttpRequest();

    ajax.onreadystatechange = function(){

        if(ajax.readyState == 4){
            if(ajax.status == 200){
                document.getElementById('inactive-users').innerHTML = ajax.responseText;
                console.log(ajax.responseText);
            }
        }
    }

    ajax.open("GET", "./search/inActive", true);
    ajax.send();
})();
