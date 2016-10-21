/**
 * Created by root on 10/21/16.
 */
var listUsers= {
    list: function(){
        var thisInstance = this;
        var ajax = new XMLHttpRequest();
        ajax.onreadystatechange = function(){

            if(ajax.readyState == 4){
                if(ajax.status == 200){
                    document.getElementById('ajax-content').innerHTML = ajax.responseText;
                }
            }
        }

        ajax.open("GET", "./mappings/users", true);
        ajax.send();

    }
}