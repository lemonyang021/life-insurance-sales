





//表单提交
function submit() {
    //调用自己的保存业务
    let channelRegisterForm = $("#channelRegisterForm").serializeObject();
    url = "http://localhost:8091/sales-config/channel/register";
    var resultInfo = commonAjax("POST",url,false,channelRegisterForm);
    console.log(channelRegisterForm);
 }

 //表单回显（可编辑与不可编辑）
 function showForm() {
    //回显基础数据
    $("#channelRegisterForm").form({channelName:"代理人",channelCode:"18",categoryCode:"01"});
 }
