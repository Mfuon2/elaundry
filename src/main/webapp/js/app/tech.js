var technician = App.extend(App.Sys, {
	modelId: 'technician',
	httpUrl: './technician',
	responseTarget: 'ajax-content',
	columnModel: ['fullname','techid', 'nationalid','phonNo','email'],
	columnSeperator: '   -   ',
	model:[{
		id: 'fullname',
		label: 'Full Name',
		name: 'fullname',
		type: 'text',
		required: 'required'
	},{
		id: 'techid',
		label: 'Tech ID',
		name: 'techid',
		type: 'text',
		required: 'required'
	},{
		id: 'nationalid',
		label: 'National Id',
		name: 'nationalid',
		type: 'number',
		required: 'required'
	},{
		id: 'tech-phone',
		label: 'Phone :',
		name: 'phoneNo',
		type: 'number',
		required: 'required'
	},{
		id: 'tech-email',
		label: 'Email :',
		name: 'email',
		type: 'email',
		required: 'required'
	},{
		id: 'tech-town',
		label: 'Town',
		name: 'town',
		type: 'text',
		required: 'required'
	},{
		id: 'tech-country',
		label: 'Country',
		name: 'country',
		type: 'select',
		options: [
		    {label: 'Kenya', value:'KEN'}, 
	        {label: 'Uganda', value:'UG'}, 
	        {label: 'Tanzania', value:'TZ'}
	     ]
	},{
		id: 'tech-box',
		label: 'P.O BOX',
		name: 'box',
		type: 'text',
		required: 'required'
	},{
		id: 'tech-id',
		label: '',
		name: 'id',
		hidden: true,
		type: 'hidden'
	}],
	removeRecord: true

});

(function(){
	//technician.init();
	//window.location.assign("inde.jsp")
})();