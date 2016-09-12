/**
 * Created by Mayijun on 2016/9/7.
 */

//拿到的关于用户名的元素
var username=document.getElementById("username");
var usernameWarn=document.getElementById("usernameWarn");

//提示用户用户名怎么输入
function username1(){
    if(username.value.trim()==""){
        usernameWarn.innerHTML="长度应在2~6位,不包含空格";
    }
    else{
        usernameWarn.innerHTML="";
    }
}

//拿到的关于密码和确认密码的元素
var password=document.getElementById("password");
var passwordOk=document.getElementById("passwordOk");
var passwordWarn=document.getElementById("passwordWarn");
var passwordOkWarn=document.getElementById("passwordOkWarn");

//提示用户密码和确认密码输入
function password1(){
    //alert(password.value);
    if(password.value==""){
        passwordWarn.innerHTML="长度应在6~10位,不包含空格";
    }
    else{
        passwordWarn.innerHTML="";
    }
}

function passwordOk1(){
    if(passwordOk.value==""){
        passwordOkWarn.innerHTML="再次输入以确认密码";
    }
    else{
        passwordOkWarn.innerHTML="";
    }
}

//拿到的关于验证码的元素
var identify=document.getElementById("identify");
var identifyWarn=document.getElementById("identifyWarn");

//提示用户输入验证码
function identify1(){
    if(identify.value.trim()==""){
        identifyWarn.innerHTML="请填写验证码,不区分大小写";
    }
    else{
        identifyWarn.innerHTML="";
    }
}