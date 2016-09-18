/**
 * Created by Mayijun on 2016/9/16.
 */
//提交给一个确认框体的方法
var setPasswordForm=document.getElementById("setPasswordForm");
function confirm1(){
    var con=confirm("确认修改？");
    if(con==true){
        setPasswordForm.submit();
    }
}
//拿到的关于密码和确认密码的元素
var oldPassword=document.getElementById("oldPassword");
var oldPasswordWarn=document.getElementById("oldPasswordWarn");
var newPassword=document.getElementById("newPassword");
var newPasswordWarn=document.getElementById("newPasswordWarn");
var newPasswordOk=document.getElementById("newPasswordOk");
var newPasswordOkWarn=document.getElementById("newPasswordOkWarn");

//提示用户密码和确认密码输入
function oldPassword1(){
    //alert(password.value);
    if(oldPassword.value==""){
        oldPasswordWarn.innerHTML="请输入您以前的密码";
    }
    else{
        oldPasswordWarn.innerHTML="";
    }
}

function newPassword1(){
    if(newPassword.value==""){
        newPasswordWarn.innerHTML="新密码应在6~10位，不得包含空格";
    }
    else{
        newPasswordWarn.innerHTML="";
    }
}
function newPasswordOk1(){
    if(newPasswordOk.value==""){
        newPasswordOkWarn.innerHTML="再次输入以确认新密码";
    }
    else{
        newPasswordOkWarn.innerHTML="";
    }
}
