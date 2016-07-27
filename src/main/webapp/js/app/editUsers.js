var editUsers = App.extend(App.Sys, {
	modelId: 'editUsers',
	httpUrl: './user',
	responseTarget: 'ajax-content',
	model:[{
		id: 'user-id',
		label: '',
		name: 'id',
		hidden: true,
		type: 'hidden'
	},{
		id: 'fullname',
		label: 'Fullname',
		name: 'fullname',
		type: 'text',
		required: 'required'
	},{
		id: 'username',
		label: 'Username',
		name: 'username',
		type: 'text',
		required: 'required'
	},{
		id: 'email',
		label: 'User Email',
		name: 'email',
		type: 'email',
		required: 'required'
	},{
		id: 'usertype',
		label: 'Choose Type :',
		name: 'usertype',
		type: 'select',
		options:[{
			label :"Client", value :"client"
		},{
			label :"Technician", value :"tech"
		},{
			label :"Customer Support", value :"admin"
		}],
		required: 'required'
	}],
	removeRecord: true

});
//(function(){
//	clients.init();
//})();
//(function(){
//	ticket.ajaxRequest.call({
//		httpMethod : 'GET',
//		httpUrl : './technician',
//		updateTarget : function(resp) {
//			var options = [];
//			//console.log(resp);
//			JSON.parse(resp).forEach(function(el){
//				options.push({
//					label: el.fullname+" ~ "+el.techid,
//					value: el.techid
//				});
//			});
//			
//			//console.log(ticket.model[5].options);
//			ticket.model[5].options = options;
//		}
//	})
//})();
//(function(){
//	ticket.ajaxRequest.call({
//		httpMethod : 'GET',
//		httpUrl : './clients',
//		updateTarget : function(resp) {
//			var options = [];
//			//console.log(resp);
//			JSON.parse(resp).forEach(function(el){
//				options.push({
//					label: el.clientid +"-"+ el.fullname,
//					value: el.fullname
//				});
//				
//			});
//			
//			//console.log(ticket.model[5].options);
//			ticket.model[2].options = options;
//		}
//	})
//})();


function clearDiv(){
	document.getElementById("ajax-content").style.padding = "0px 0px 0px";
};