var App = App || {};

App.extend = function(proto, literal){
	var newLiteral = Object.create(proto);
	Object.keys(literal).forEach(function(k) {
		newLiteral[k] = literal[k];
	})
	
	return newLiteral;
};

App.Sys = {
		responseTarget : '',
		httpMethod : 'GET',
		httpUrl : '',
		async : true,
		requestParams : '',
		getEl : function(elId){
			return document.getElementById(elId);
		},
		
		updateTarget : function(resp){
			var me = this;
			me.getEl(me.responseTarget).innerHTML = resp;
		},
		ajaxRequest : function(){
			var me = this;
			var ajax = new XMLHttpRequest();
			
			ajax.onreadystatechange = function(){
				
				if(ajax.readyState == 4){
					if(ajax.status == 200){
						me.updateTarget(ajax.responseText);
					}
				}
			}
			
			ajax.open(me.httpMethod, me.httpUrl, me.async);
			if (me.requestParams) {
				ajax.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
				ajax.send(me.requestParams);
			} else
				ajax.send();
		},
		validate : function() {

			var me = this;

			me.nullChecker();
			me.numberChecker();
			me.mailChecker();
			me.submitForm();
		},
		number : true,
		numberChecker : function() {
			var me = this;

			me.model.forEach(function(el) {
				var context = this;

				if (el.type == "number") {

					var numberValue = document.getElementById(el.id).value;
					var numberReg = /^\s*(\+|-)?\d+\s*$/;

					var valid = numberReg.test(numberValue);
					var fieldId = document.getElementById(el.id);
					if (valid == false) {

						me.ajaxRequest.call({
							updateTarget : function() {
								me.commonError("Incorrect Number format", el.id, fieldId);

							},
							httpMethod : 'POST',
							httpUrl : me.httpUrl
						});

						me.number = false;

					} else {
						me.commonOkay(el.id);
						me.number = true;

					}

				}

			});
			return me.number;
		},
		email : true,
		mailChecker : function() {
			var me = this;

			me.model.forEach(function(el) {
				var context = this;

				if (el.type == "email") {

					var compare = document.getElementById(el.id).value;

					var reg = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

					var tested = reg.test(compare);
					var fieldId = document.getElementById(el.id);
					if (tested == false) {

						me.ajaxRequest.call({
							updateTarget : function() {
								me.commonError("Incorrect Email format",
										el.id, fieldId);

							},
							httpMethod : 'POST',
							httpUrl: me.httpUrl

						});

						me.email = false;

					} else {
						me.commonOkay(el.id);
						me.email = true;

					}
				}
			});

			return me.email;
		},

		commonError : function(errorMsg, myId, fieldId) {

			var para = document.createElement("p");
			para.setAttribute('style', 'color:red; font-size:11');
			para.setAttribute('id', 'para');
			
			var errorMsg = document.createTextNode(errorMsg);
			para.appendChild(errorMsg);
			
			var parentDivId = fieldId.parentNode.id;
			var parentDiv = document.getElementById(parentDivId);
			var NumberOfchildren = parentDiv.childNodes.length;
			
			document.getElementById(myId).style.backgroundColor = "#f5dddd";
			document.getElementById(myId).style.borderColor = "red";
			document.getElementById(myId).style.color = "red";
		},

		commonOkay : function(myId) {
			document.getElementById(myId).style.backgroundColor = "#e1ffdc";
			document.getElementById(myId).style.borderColor = "#1b9506";
			document.getElementById(myId).style.color = "#1b9506";
		},
		Null : true,
		nullChecker : function() {
			var me = this;
			me.model.forEach(function(el) {
				if (el.required) {
					var field = me.getEl(el.id);
					var value = field.value;

					if (value) {
						me.commonOkay(el.id);
						me.Null = false;
					} else 
						me.commonError("required", el.id, field);
				}
			});

			return me.Null;

		},
		model : [],
		form : function() {
			var me = this;
			var form = '<form>';

			me.model.forEach(function(el) {
				form += '<div class="form-group">'
						+ '<div class="input-group" id="' + el.id + '_div">'
						+ '<div class="input-group-addon"> ' + el.label + '</div>';

				if (el.type == 'select' && el.options) {
					form += '<select class="form-control" name="' + el.name
							+ '" id="' + el.id + '">';
					el.options.forEach(function(opt) {
						form += '<option value=' + opt.value + '>' + opt.label
								+ '</option>'
					});
					form += '</select>';
				} else
					form += '<div id="errorM"></div><input type="' + el.type
							+ '" name="' + el.name + '" class="form-control" id="'
							+ el.id + '" <label id="messageErr"></label>'

				form += '</div></div>';
			})

			form += '</form><a class="btn btn-success" id="' + me.modelId
					+ '-save">Save</a>';

			me.updateTarget(form);
			me.getEl(me.modelId + '-save').addEventListener("click", function() {
				me.validate();
			});
		},
		submitForm : function() {
			var me = this;
			if (me.Null == false && me.email == true && me.number == true) {
				var formValues = me.model.filter(function(el) {
					var formEl = me.getEl(el.id);
					if (!formEl)
						return;

					if (!formEl.value)
						return;

					el.value = formEl.value;

					return el;

				}).map(function(el) {
					return encodeURIComponent(el.name) + '=' + encodeURIComponent(el.value);
				}).join('&');

				me.ajaxRequest.call({
					httpMethod : 'POST',
					httpUrl : me.httpUrl,
					requestParams : formValues,
					responseTarget : me.responseTarget,
					updateTarget : function(resp) {
						me.init();
					}
				});
			}
		},
		loadForm : function(id) {
			var me = this;

			me.ajaxRequest.call({
				httpMethod : me.httpMethod,
				httpUrl : me.httpUrl + '/load?id=' + id,
				responseTarget : me.responseTarget,
				updateTarget : function(resp) {
					me.form();
					var result = JSON.parse(resp);
					console.log(result);
					me.model.forEach(function(el) {
						Object.keys(result).forEach(function(k) {
							if (el.name == k) {
								console.log(el.id + '=' + result[k]);
								me.getEl(el.id).value = result[k];
							}
						})
					})
				}
			});

		},
		removeRec : function(id) {
			var me = this;

			me.ajaxRequest.call({
				httpMethod : 'DELETE',
				httpUrl : me.httpUrl + '?id=' + id,
				responseTarget : me.responseTarget,
				updateTarget : function(resp) {
					me.init();
				}
			});

		},
//		listView : function() {
//			var me = this;
//
//			me.ajaxRequest.call({
//				httpMethod : me.httpMethod,
//				httpUrl : me.httpUrl,
//				responseTarget : me.responseTarget,
//				updateTarget : function(resp) {
//					var listView = "<div class=\"text-right\">";
//					listView += "<a class=\"btn btn-success\"  id=\"" + me.modelId + "-create-add-form\">Add</a>";
//					listView += "</div>";
//
//					var jsonRecords = JSON.parse(resp);
//
//					jsonRecords.forEach(function(el) {
//						var editId = me.modelId + "-edit-" + el.id;
//						var delId = me.modelId + "-del-" + el.id;
//
//						listView += "<hr>";
//						listView += "<div class=\"row\">";
//						listView += "<div class=\"col-md-12\">";
//						
//						
//						if(me.columnModel)
//							var columnSeperator = ' ';
//							if(me.columnSeperator) 
//								columnSeperator = me.columnSeperator;
//							
//							var colSize = me.columnModel.length;
//							
//							me.columnModel.forEach(function(elCol){
//								listView += el[elCol];
//								
//								colSize--;
//								
//								if(colSize != 0)
//									listView += columnSeperator;
//							});
//						listView += "</div>";
//						listView += "</div>";
//						listView += "<div class=\"text-right\">";
//						listView += "<a class=\"btn btn-primary\"  id=\"" + editId + "\">Edit</a>";
//						listView += " | <a class=\"btn btn-danger\"  id=\""	+ delId + "\">Delete</a>";
//						listView += "</div>";
//					});
//
//					if (me.getEl(me.responseTarget).innerHTML = listView) {
//						jsonRecords.forEach(function(el) {
//							var editId = me.modelId + "-edit-" + el.id;
//							var delId = me.modelId + "-del-" + el.id;
//
//							me.getEl(editId).addEventListener('click', function() {
//								me.loadForm(el.id);
//							});
//
//							me.getEl(delId).addEventListener('click', function() {
//								me.removeRec(el.id);
//							});
//						});
//						
//						me.getEl(me.modelId + "-create-add-form").addEventListener('click', function() {
//							me.form();
//						});
//					}
//				}
//			});
//		},
		listView : function() {
            var me = this;

            me.ajaxRequest.call({
                httpMethod : me.httpMethod,
                httpUrl : me.httpUrl,
                responseTarget : me.responseTarget,
                updateTarget : function(resp) {
                	
                	var table = '<table class= "table table-bordered table-striped table-condensed">'
                	table += "<div class=\"text-right\">";
					table += "<a class=\"btn btn-success\"  id=\"" + me.modelId + "-create-add-form\">Add</a>";
					table += "</div>";
	                table += "<tr>";
	                
	                me.model.forEach(function (el){
	                    table += '<th>' +el.label+ '';
	                   
	                });
	                table+="</th>";
	                table+="<th></th>";
	                table+="<th></th></tr>";
	                
                    var jsonRecords = JSON.parse(resp);
                    
                    jsonRecords.forEach(function(el) {
                    	
                        var approve = "approve-"+el.id;
                        var disapprove ="disapprove-"+el.id;
                        var del ="del-" + el.id;
                        var edit="edit-" + el.id;
                        
                        table+='<tr>';
                        
                        me.model.forEach(function (model){
                        	table += '<td>'  +el[model.name] + '</td>' 	  
                        });
                        
                        if (me.modelId == "ticket"){
                        table += "<td> <a class=\"btn btn-danger\"  id=\""+ edit + "\">UPDATE TICKET</a></td>";
                        table += '</tr>';
                        }
                        
                        else if (me.modelId == "technician" || me.modelId == "clients"){
                            table += "<td> <a class=\"btn btn-primary\"  id=\"" + edit + "\">Edit</a></td>";;
                            table += "<td> <a class=\"btn btn-danger\"  id=\""+ del + "\">Delete</a></td>";
                            table += '</tr>';
                        }
                       
               
                });
                    table+="<table>";
               
                    me.getEl(me.responseTarget).innerHTML = table;
                   
                    if (me.getEl(me.responseTarget).innerHTML = table) {
                       
                        jsonRecords.forEach(function(el) {
       
                            var approve = "approve-"+el.id;
                            var disapprove ="disapprove-"+el.id;
                            var del ="del-" + el.id;
                            var edit="edit-" + el.id;
                           
                             if (me.modelId == "technician" || me.modelId == "clients"){
                            me.getEl(del).addEventListener('click', function() {
                            	me.removeRec(el.id);
                            });
                           
                            me.getEl(edit).addEventListener('click', function() {
                                me.loadForm(el.id);
                            });
                            
                            }
                             
                             else{
                                 
                            me.getEl(edit).addEventListener('click', function() {
                                me.loadForm(el.id);
                            });
                           
//                            me.getEl(disapprove).addEventListener('click', function() {
//                                me.disapprove(el.id);
//                                
//                            });
                            me.getEl(me.modelId + "-create-add-form").addEventListener('click', function() {
    							me.form();});
                             }
                             
                        });
                        
						me.getEl(me.modelId + "-create-add-form").addEventListener('click', function() {
							me.form();
						});
						
                    }
                }
            });
        },
		init : function() {
			this.listView(this.httpUrl);
		},
		formName : function(){
			var name = this.modelId;
			document.getElementById("formName").innerHTML = name;
			//document.write(this.modelId);
		}
}
