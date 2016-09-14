/**
 * Created by Mayijun on 2016/9/11.
 */
//监控标题字数
var tieziTitle=document.getElementById("tieziTitle");
var tieziTitleWarn=document.getElementById("tieziTitleWarn");
var tieziTitleCountWarn=document.getElementById("tieziTitleCountWarn");
function tieziTitleWarn1(){
    //alert(tieziTitle.value.length==0);
    if(tieziTitle.value.length<25) {
        tieziTitleWarn.hidden = true;
        tieziTitleCountWarn.innerHTML = " ";
    }
    if(tieziTitle.value.length==25){
        tieziTitleWarn.hidden=false;
        tieziTitleCountWarn.innerHTML="5";
    }
    if(tieziTitle.value.length==26){
        tieziTitleWarn.hidden=false;
        tieziTitleCountWarn.innerHTML="4";
    }
    if(tieziTitle.value.length==27){
        tieziTitleWarn.hidden=false;
        tieziTitleCountWarn.innerHTML="3";
    }
    if(tieziTitle.value.length==28){
        tieziTitleWarn.hidden=false;
        tieziTitleCountWarn.innerHTML="2";
    }
    if(tieziTitle.value.length==29){
        tieziTitleWarn.hidden=false;
        tieziTitleCountWarn.innerHTML="1";
    }
    if(tieziTitle.value.length==30){
        tieziTitleCountWarn.innerHTML="0";
    }

}

//监控内容字数
var tieziContent=document.getElementById("tieziContent");
var tieziContentWarn=document.getElementById("tieziContentWarn");
var tieziContentCountWarn=document.getElementById("tieziContentCountWarn");

function tieziContentWarn1(){
    //alert(tieziContent.value.length)
    if(tieziContent.value.length<495) {
        tieziContentWarn.hidden = true;
        tieziContentCountWarn.innerHTML = " ";
    }
    if(tieziContent.value.length==495){
        tieziContentWarn.hidden=false;
        tieziContentCountWarn.innerHTML="5";
    }
    if(tieziContent.value.length==496){
        tieziContentWarn.hidden=false;
        tieziContentCountWarn.innerHTML="4";
    }
    if(tieziContent.value.length==497){
        tieziContentWarn.hidden=false;
        tieziContentCountWarn.innerHTML="3";
    }
    if(tieziContent.value.length==498){
        tieziContentWarn.hidden=false;
        tieziContentCountWarn.innerHTML="2";
    }
    if(tieziContent.value.length==499){
        tieziContentWarn.hidden=false;
        tieziContentCountWarn.innerHTML="1";
    }
    if(tieziContent.value.length==500){
        tieziContentWarn.hidden=false;
        tieziContentCountWarn.innerHTML="0";
    }
}

