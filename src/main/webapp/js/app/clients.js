var clients = App.extend(App.Sys, {
	modelId: 'clients',
	httpUrl: './clients',
	responseTarget: 'ajax-content',
	columnModel: ['fullname', 'nationalid','clientsid','phonNo','email','town','country','box'],
	columnSeperator: '   -   ',
	model:[{
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
	},{
		id: 'client-town',
		label: 'Town',
		name: 'town',
		type: 'text',
		required: 'required'
	},{
		id: 'client-country',
		label: 'Country',
		name: 'country',
		type: 'select',
		options: [
		    {label: 'Kenya', value:'KEN'}, 
	        {label: 'Uganda', value:'UG'}, 
	        {label: 'Tanzania', value:'TZ'}
	     ]
	},{
		id: 'client-box',
		label: 'P.O BOX',
		name: 'box',
		type: 'text',
		required: 'required'
	},{
		id: 'client-id',
		label: '',
		name: 'id',
		hidden: true,
		type: 'hidden'
	}],
	removeRecord: true

});

(function(){
	clients.init();
})();