var editUsers = App.extend(App.Sys, {
	modelId: 'editUsers',
	httpUrl: './user',
	responseTarget: 'ajax-content',
	model:[{
		id: 'user-id',
		label: 'Auto',
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
		id: 'password',
		label: 'Password',
		name: 'password',
		hidden: true,
		type: 'hidden'
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
		label: 'User Type :',
		name: 'usertype',
		type: 'select',
		options:[{
			label :"Client", value :"client"
		},{
			label :"Technician", value :"tech"
		},{
			label :"Customer Support", value :"support"
		}],
		required: 'required'
	}],
	removeRecord: true

});

function clearDiv(){
	document.getElementById("ajax-content").style.padding = "0px 0px 0px";
};