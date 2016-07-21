var ticket = App.extend(App.Sys, {
	modelId: 'ticket',
	httpUrl: './ticket',
	responseTarget: 'ajax-content',
	columnModel: ['title','reportedby', 'desc','phonNo','email'],
	columnSeperator: '   -   ',
	model:[{
		id: 'ticket-id',
		label: '',
		name: 'id',
		hidden: true,
		type: 'hidden'
	},{
		id: 'title',
		label: 'Title',
		name: 'title',
		type: 'text',
		required: 'required'
	},{
		id: 'reportedby',
		label: 'Client',
		name: 'reportedby',
		type: 'select',
		options: [],
		required: 'required'
	},{
		id: 'descr',
		label: 'Description',
		name: 'descr',
		type: 'text',
		required: 'required'
	},{
		id: 'status',
		label: 'status :',
		name: 'status',
		type: 'select',
		options:[{
			label :"OPEN", value :"OPEN"
		},{
			label :"CLOSED", value :"CLOSED"
		}],
		required: 'required'
	},{
		id: 'assign',
		label: 'Assign',
		name: 'assign',
		type: 'select',
		options: [],
		required: 'required'
	}],
	removeRecord: true

});
//(function(){
//	clients.init();
//})();
(function(){
	ticket.ajaxRequest.call({
		httpMethod : 'GET',
		httpUrl : './technician',
		updateTarget : function(resp) {
			var options = [];
			//console.log(resp);
			JSON.parse(resp).forEach(function(el){
				options.push({
					label: el.techid +" - "+ el.fullname,
					value: el.fullname
				});
			});
			
			//console.log(ticket.model[5].options);
			ticket.model[5].options = options;
		}
	})
})();
(function(){
	ticket.ajaxRequest.call({
		httpMethod : 'GET',
		httpUrl : './clients',
		updateTarget : function(resp) {
			var options = [];
			//console.log(resp);
			JSON.parse(resp).forEach(function(el){
				options.push({
					label: el.clientid +" - "+ el.fullname,
					value: el.fullname
				});
				
			});
			
			//console.log(ticket.model[5].options);
			ticket.model[2].options = options;
		}
	})
})();

function clearDiv(){
	document.getElementById("ajax-content").style.padding = "0px 0px 0px";
};