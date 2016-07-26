var technician = App.extend(App.Sys, {
	modelId: 'technician',
	httpUrl: './technician',
	responseTarget: 'ajax-content',
	columnModel: ['fullname','techid', 'nationalid','phonNo','email'],
	columnSeperator: '   -   ',
	model:[{
		id: 'tech-id',
		label: 'No#',
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
		type: 'text',
		required: 'required'
	},{
		id: 'tech-email',
		label: 'Email :',
		name: 'email',
		type: 'email',
		required: 'required'
	}],
	removeRecord: true

});

//(function(){
//	//technician.init();
//	//window.location.assign("inde.jsp")
//})();