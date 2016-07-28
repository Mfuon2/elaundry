
(function(){
	var elem = document.createElement("img");
	elem.setAttribute("src", "js/app/helpdesk.jpg");
	elem.setAttribute("height", "400");
	elem.setAttribute("width", "500");
	elem.setAttribute("style","margin-left:auto;margin-right:auto");
	elem.setAttribute("alt", "Flower");
	document.getElementById("ajax-content").appendChild(elem);
	document.getElementById("ajax-content").style.padding = "0px 230px 0px";
	document.getElementById("ajax-content").style.marginLeft = "auto";
	document.getElementById("ajax-content").style.marginRight = "auto";
	
})();

function contactUs(){
	getElById('ajax-content').innerHTML = "Loading...";
		
	}
