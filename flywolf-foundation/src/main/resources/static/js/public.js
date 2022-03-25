/**
 * 拓展表单对象：用于将对象序列化为JSON对象
*/
$.fn.serializeObject = function () {
    var o = {};
    var a = this.serializeArray();
    $.each(a, function () {
            if (o[this.name]) {
                if (!o[this.name].push) {
                    o[this.name] = [o[this.name]];
                }
                o[this.name].push(this.value || '');
            } else {
                o[this.name] = this.value || '';
            }
    });
    return o;
};

function commonAjax(request_method,sendUrl,sync,sendData){
    if(request_method != "POST" && request_method!= "GET"){
       return "";
    }
    var result ="";
    if(request_method == "GET"){
       $.ajax({
         type: "GET",
         url:   sendUrl,
         dataType : "json",
         async : sync,
         cache: false,
         headers : {'Content-Type' : 'application/json;charset=utf-8'},
         data: JSON.stringify(sendData),
         success:function(msg){
            result  = msg;
         }
       });
    }else{
       $.ajax({
            type: "POST",
            url:   sendUrl,
            data:  sendData,
            dataType : "json",
            async : sync,
            cache: false,
            headers : {'Content-Type' : 'application/json;charset=utf-8'},
            data: JSON.stringify(sendData),
            success:function(msg){
               result  = msg;
            }
     });
    }
    return result;
}