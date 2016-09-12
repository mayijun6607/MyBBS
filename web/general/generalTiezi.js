/**
 * Created by Mayijun on 2016/9/12.
 */
//监控内容字数
var tieziReplyContent=document.getElementById("tieziReplyContent");
var tieziReplyContentWarn=document.getElementById("tieziReplyContentWarn");
var tieziReplyContentCountWarn=document.getElementById("tieziReplyContentCountWarn");

function tieziReplyContentWarn1(){
    //alert(tieziContent.value.length)
    if(tieziReplyContent.value.length<495) {
        tieziReplyContentWarn.hidden = true;
        tieziReplyContentCountWarn.innerHTML = " ";
    }
    if(tieziReplyContent.value.length==495){
        tieziReplyContentWarn.hidden=false;
        tieziReplyContentCountWarn.innerHTML="5";
    }
    if(tieziReplyContent.value.length==496){
        tieziReplyContentWarn.hidden=false;
        tieziReplyContentCountWarn.innerHTML="4";
    }
    if(tieziReplyContent.value.length==497){
        tieziReplyContentWarn.hidden=false;
        tieziReplyContentCountWarn.innerHTML="3";
    }
    if(tieziReplyContent.value.length==498){
        tieziReplyContentWarn.hidden=false;
        tieziReplyContentCountWarn.innerHTML="2";
    }
    if(tieziReplyContent.value.length==499){
        tieziReplyContentWarn.hidden=false;
        tieziReplyContentCountWarn.innerHTML="1";
    }
    if(tieziReplyContent.value.length==500){
        tieziReplyContentWarn.hidden=false;
        tieziReplyContentCountWarn.innerHTML="0";
    }
}