/**
 * Created by Mayijun on 2016/9/7.
 */
//******已经废弃********
function login1(){
    window.location.href="../login/login.jsp";
}

function return1(){
    window.history.back();
}


//拿到的关于用户名的元素
var username=document.getElementById("username");
var usernameWarn=document.getElementById("usernameWarn");

//检测用户名格式
function username1(){
    if(username.value.indexOf(" ")!=-1){
        usernameWarn.innerHTML="用户名不得包含空格!";
    }
    else if(username.value.length<2||username.value.length>6){
        usernameWarn.innerHTML="不得低于2位或超过6位!";
    }
    else{
        usernameWarn.innerHTML="√";
    }
}

//拿到的关于密码和确认密码的元素
var password=document.getElementById("password");
var passwordOk=document.getElementById("passwordOk");
var passwordWarn=document.getElementById("passwordWarn");
var passwordOkWarn=document.getElementById("passwordOkWarn");

//检测密码格式
//password;
function password1(){
    //var passwordPattern=/w/;
    if(password.value.indexOf(" ")!=-1){
        passwordWarn.innerHTML="密码不得包含空格!";
    }
    else if(password.value.length<6||password.value.length>10){
        passwordWarn.innerHTML="不得低于6位或超过10位!";
    }
    else{
        passwordWarn.innerHTML="√";
    }
}

//确认密码
function passwordOk1() {
    if(password.value.trim()==""){
        //alert(passwordOk.value);
        passwordOkWarn.innerHTML="";
    }
    else if (password.value != passwordOk.value) {
        passwordOkWarn.innerHTML = "二次输入密码不同!";
    }
    else {
        passwordOkWarn.innerHTML = "√";
    }
}

/*//拿到邮箱和验证码及警告的元素(取消邮箱)
//var email=document.getElementById("email");
//var emailWarn=document.getElementById("emailWarn");
var identify=document.getElementById("identify");
var identifyWarn=document.getElementById("identifyWarn");*/

/*//验证邮箱
function email1(){

}*/

/*//验证验证码
function identify1(){

}*/

/*//必须都填写才能确定注册
var Okcount=0;
function registOk1(){
    if(usernameWarn.value=="√"){
        Okcount=Okcount+1;
    }
    if(passwordWarn.value=="√"){
        Okcount=Okcount+1;
    }
    if(passwordOkWarn.value=="√"){
        Okcount=Okcount+1;
    }
    if(emailWarn.value=="√"){
        Okcount=Okcount+1;
    }
    if(identifyWarn.value=="√"){
        Okcount=Okcount+1;
    }

}*/
