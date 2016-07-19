var clients = App.extend(App.Sys, {
	modelId: 'clients',
	httpUrl: './clients',
	responseTarget: 'ajax-content',
	columnModel: ['fullname','clientsid', 'nationalid','phonNo','email'],
	columnSeperator: '   -   ',
	model:[{
		id: 'client-id',
		label: '',
		name: 'id',
		hidden: true,
		type: 'hidden'
	},{
		id: 'fullname',
		label: 'Full Name',
		name: 'fullname',
		type: 'text',
		required: 'required'
	},{
		id: 'clientid',
		label: 'Client ID',
		name: 'clientid',
		type: 'text',
		required: 'required'
	},{
		id: 'nationalid',
		label: 'National Id',
		name: 'nationalid',
		type: 'number',
		required: 'required'
	},{
		id: 'client-phone',
		label: 'Phone :',
		name: 'phoneNo',
		type: 'number',
		required: 'required'
	},{
		id: 'client-email',
		label: 'Email :',
		name: 'email',
		type: 'email',
		required: 'required'
	}],
	removeRecord: true

});

(function(){
	//clients.init();
})();