<%--
  Created by IntelliJ IDEA.
  User: Mayijun
  Date: 2016/9/9
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>自制小游戏</title>
</head>
<body>
<!--新加的返回主页的按钮-->

<span style="border:2px solid black;position:absolute;top:30%;left:3%;" onclick="back1()" onmousemove="backhomepage1()" onmouseout="backhomepage2()">
    <input type="image" id="backhomepage"  src="${pageContext.request.contextPath}/Game/New/backHomepage.jpg"/>
</span>

<div id="toNewid" style="position:absolute;left:600px;top:100px;background-color:#66ffff;height:370px;width:400px;border:1px solid #660000;">
    <div style=""><h2 style="color:#ff0033;">主角生成器</h2></div>
    <div id="divid" style="position:absolute;left:220px;top:25px;"></div>
    <!--<form  id="form" action="Play.html" method="post"> -->
    姓名:<input type="text" id="name"  maxlength="6" size="10" placeholder="不超过6个字"/><br/><br/>
    性别:男<input type="radio"  name="sex" checked=true value="男"/>女<input type="radio"  name="sex"  value="女"/><br/><br/>
    阵营:<select id="group" onchange="choice1(this.value);">
    <option value="请选择">-请选择-</option>
    <option value="联盟">联盟</option>
    <option value="部落">部落</option>

</select>

    种族:<select id="race" onchange="choice2(this.value);">
    <!--	<option value="人族">人族</option>
        <option value="暗夜精灵">暗夜精灵</option>
        <option value="兽族">兽族</option>
        <option value="被遗忘者">被遗忘者</option> -->
    <!--<option value="人族">人族</option>
    <option value="暗夜精灵">暗夜精灵</option> -->
    <option>----------</option>
</select>

    出生地:<select id="area">
    <option >----------</option>

</select><br/><br/>
    职业:&nbsp;咸鱼<input id="none" type="radio" name="job" value="咸鱼" checked=true onclick="CNon1();"/>&nbsp;战士<input id="warrior" type="radio" name="job" value="战士" onclick="CWar1();"/>&nbsp;法师<input id="mage" type="radio" name="job" value="法师" onclick="CMag1();"/>&nbsp;牧师(不可选)<input type="radio" name="job" value="牧师" disabled=true/>
    <br/><br/>
    可使用的属性点:<input type="text" id="att"  value="10" size="1" disabled=true/><br/>
    力量:<input type="text"  id="str" name="str" value="1" size="1" disabled=true/><button onclick="add1();">+</button><button onclick="sub1();">-</button><br/>
    智力:<input type="text" id="int" name="int" value="1" size="1" disabled=true/><button onclick="add2();">+</button><button onclick="sub2();">-</button><br/>
    耐力:<input type="text" id="end" name="end" value="3" size="1" disabled=true/><button onclick="add3();">+</button><button onclick="sub3();">-</button><br/>

    <div style="position:absolute;top:305px;left:300px"><button style="height:40px;width:50px" onclick="ok1();">提交</button></div>

    <!--<div style="position:absolute;left:20px;top:320px;"><input type="image" src="submit.jpg" style="height:40px;width:80px;"/></div>-->
    <!--</form>-->
</div>




<!-- 游戏界面！！！！-->

<div hidden=true id="newid" style="width:50%;height:50%;position:absolute;top:5%;left:9%">

    <!--左边-->
    <div  id="background" style="border:3px solid black;height:400px;width:473px;position:absolute;top:150px;left:375px">
        <!--战斗界面-->
        <div style="border:2px solid black;height:250px;width:473px;position:absolute;">
            <img id="monimg1" src="${pageContext.request.contextPath}/Game/New/staticMonster.jpg"/>
            <!--怪物血量 -->
            <div id="monid" style="position:absolute;top:10px;">
                &nbsp;<b>怪物血量:</b>
                <input type="text" id="monhp1" size="5"/>&nbsp;/&nbsp;
                <input type="text" id="monhp2" size="5"/>
            </div>
            <!--BOSS血量 -->
            <div id="bossid" hidden=true style="position:absolute;top:10px;">
                &nbsp;<b>BOSS血量:</b>
                <input type="text" id="bosshp1" size="5"/>&nbsp;/&nbsp;
                <input type="text" id="bosshp2" size="5"/>
            </div>
            <!-- 怪物掉血-->
            <div style="position:absolute;top:20px;right:25px">
                <font id="attackhp" color="red" size="7"></font>
            </div>
            <!-- 玩家掉血-->
            <div style="position:absolute;top:90px;right:25px">
                <font id="byattackhp" color="red" size="7"></font>
            </div>

        </div>

        <!--技能界面-->
        <div style="border:2px solid black;height:150px;width:473px;position:absolute;top:250px;">
            <br/>&nbsp;<button id="commonskill" onclick="attack1();" style="height:40px;width:70px" disabled=true>攻击</button>
            &nbsp;<button id="MW1skill" onclick="MW1attack1();" style="height:40px;width:70px" disabled=true>突刺</button>
            &nbsp;<button id="MW3skill" onclick="MW3attack1();" style="height:40px;width:70px" disabled=true>火焰冲击</button>
            &nbsp;<button id="MW5skill" onclick="MW5attack1();" style="height:40px;width:70px" disabled=true>火球术</button>
            &nbsp;<button  onclick="GM1();" style="height:40px;width:70px" hidden=true >秒杀</button>
            <br/>
            <br/>
            &nbsp;<button id="SW2skill" onclick="SW2attack1();" style="height:40px;width:70px" disabled=true>二重打击</button>
            &nbsp;<button id="SW4skill" onclick="SW4attack1();" style="height:40px;width:70px" disabled=true>反弹</button>
        </div>


    </div>

    <!--右上角-->
    <div id="character" style="border:2px solid black;height:45%;width:50%;position:absolute;top:150px;left:855px">
        <br/>&nbsp;姓名:<input type="text"  disabled=true id="pname" value="" size="7"/>
        &nbsp;性别:<input type="text" disabled=true id="psex" value="" size="1"/>
        &nbsp;职业:<input type="text" disabled=true id="pjob" value="" size="4"/><hr/>
        &nbsp;可用的属性点<input type="text" disabled=true id="patt" size="1"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Level:<input type="text" disabled=true id="lv" size="1"></span><br/>
        <br/>
        &nbsp;力量:<input type="text"  disabled=true id="pstr" value="" size="1"/><button onclick="addns();">+</button>
        &nbsp;智力:<input type="text"  disabled=true id="pint" value="" size="1"/><button onclick="addni();">+</button>
        &nbsp;耐力:<input type="text"  disabled=true id="pend" value="" size="1"/><button onclick="addne();">+</button><hr/>
        &nbsp;<b>AD:</b><input type="text"  disabled=true id="pad" value="" size="1"/>
        &nbsp;<b>AP:</b><input type="text"  disabled=true id="pap" value="" size="1"/>
        &nbsp;<b>血量:</b><input type="text"  disabled=true id="php1" value="" size="3"/>&nbsp;/&nbsp;<input type="text"  disabled=true id="php2" value="" size="3"/>
    </div>

    <!--右下角-->
    <div id="fight" style="border:2px solid black;height:55%;width:50%;position:absolute;top:332px;left:855px">
        <br/>&nbsp;主武器:<select id="mainweapon" onchange="mainWeapon1(this.value);">
        <option id="MW1" value="烧火棍">烧火棍</option>
        <option id="MW2" value="铁剑">铁剑</option>
        <option id="MW3" value="学徒法杖">学徒法杖</option>
        <option id="MW4" value="钢剑">钢剑</option>
        <option id="MW5" value="火焰仪式剑">火焰仪式剑</option>
    </select>
        &nbsp;AD+<input type="text" id="MWad" disabled=true size="1" value="" />
        &nbsp;AP+<input type="text" id="MWap" disabled=true size="1" value="" /><br/>
        <!--力量+<input type="text" id="MWstr" disabled=true size="1" value="" /><br/>
        &nbsp;智力+<input type="text" id="MWint" disabled=true size="1" value="" />
        &nbsp;耐力+<input type="text" id="MWend" disabled=true size="1" value="" /> -->
        &nbsp;血量+<input type="text" id="MWhp" disabled=true size="3" value="" />
        &nbsp;技能:<input type="text" id="MWski" disabled=true size="16" value="" />
        =<input type="text" id="MWsd" disabled=true size="1" value="" />
        <br/>
        <br/>
        &nbsp;副武器:<select id="secweapon" onchange="secWeapon1(this.value);">
        <option id="SWnull" value="null" selected=true>null</option>
        <option id="SW1" value="咸鱼" hidden=true>咸鱼</option>
        <option id="SW2" value="匕首" hidden=true>匕首</option>
        <option id="SW3" value="火焰魔典" hidden=true>火焰魔典</option>
        <option id="SW4" value="长方盾" hidden=true>长方盾</option>
    </select>
        &nbsp;AD+<input type="text" id="SWad" disabled=true size="1" value="" />
        &nbsp;AP+<input type="text" id="SWap" disabled=true size="1" value="" /><br/>
        &nbsp;血量+<input type="text" id="SWhp" disabled=true size="3" value="" />
        &nbsp;技能:<input type="text" id="SWski" disabled=true size="16" value="" />
        =<input type="text" id="SWsd" disabled=true size="1" value="" />
        <hr/>
        <div style="position:absolute;top:155px;left:60px">
            <button  style="height:40px;width:70px" onclick="fight1();">战斗</button>
            <button onclick="bossfight1();" style="height:40px;width:70px" >BOSS</button>
            <button onclick="" style="height:40px;width:70px" disabled=true>商店</button>
        </div>
    </div>
</div>
</body>


<script type="text/javascript">
    //时间
    var date,now1;
    var time=document.getElementById("divid");

    window.setInterval("flush1();",100);
    function flush1(){
        date=new Date();
        now1=date.toLocaleString();

        time.innerHTML=now1;
    }
    //种族
    var group=document.getElementById("group");
    var race=document.getElementById("race");
    var area=document.getElementById("area");

    var arr=new Array();
    arr[0]=["联盟","人族","暗夜精灵"];
    arr[1]=["部落","兽人","被遗忘者"];
    arr[2]=["请选择",""];
    /*arr[0][0]=["人族","闪金镇","夜色镇"];
     arr[0][1]=["暗夜精灵","泰达希尔","黑海岸"];
     arr[1][0]=["兽族","剃刀岭","十字路口"];
     arr[1][1]=["被遗忘者","丧钟镇","塔伦米尔"];*/

    function choice1(val){
        for(var i=0;i<arr.length;i++){
            var arr1=arr[i];
            var first=arr1[0];
            if(first==val){
                race.innerHTML=null;
                var oo=document.createElement("option");
                oo.innerHTML="";
                race.appendChild(oo);
                area.innerHTML=null;
                for(var j=1;j<arr1.length;j++){
                    var op=document.createElement("option");
                    var arr2=arr1[j];
                    op.value=arr2;
                    op.innerHTML=arr2;
                    race.appendChild(op);
                }
            }
        }
    }

    var arrx=new Array();
    arrx[0]=["人族","闪金镇","夜色镇"];
    arrx[1]=["暗夜精灵","泰达希尔","黑海岸"];
    arrx[2]=["兽人","剃刀岭","十字路口"];
    arrx[3]=["被遗忘者","丧钟镇","塔伦米尔"];
    function choice2(val2){
        for(var i=0;i<arrx.length;i++){
            var arr1=arrx[i];
            var first=arr1[0];
            if(first==val2){
                area.innerHTML=null;
                /*var oo=document.createElement("option");
                 oo.innerHTML="----------";
                 area.appendChild(oo);*/
                for(var j=1;j<arr1.length;j++){
                    var op=document.createElement("option");
                    var arr2=arr1[j];
                    op.value=arr2;
                    op.innerHTML=arr2;
                    area.appendChild(op);
                }
            }
        }
    }

    //属性点
    var att=document.getElementById("att");

    var str=document.getElementById("str");
    var end=document.getElementById("end");
    var int=document.getElementById("int");

    var war=document.getElementById("warrior");
    var mag=document.getElementById("mage");
    //str
    function add1(){
        if(att.value>0){
            att.value-=1;

            str.value++;
        }
    }
    function sub1(){
        if(war.checked==true){

            if(str.value>5){
                att.value++;
                str.value--;
            }

        }
        else if(mag.checked==true){
            if(str.value>1){
                att.value++;
                str.value--;
            }
        }
        else{
            if(str.value>1){
                att.value++;
                //var str=document.getElementById("str");
                str.value--;
            }
        }
    }

    //int
    // var int=document.getElementById("int");
    function add2(){
        if(att.value>0){
            att.value-=1;

            int.value++;
        }
    }
    function sub2(){
        if(war.checked==true){
            if(int.value>1){
                att.value++;
                //var str=document.getElementById("str");
                int.value--;
            }
        }
        else if(mag.checked==true){
            if(int.value>7){
                att.value++;
                int.value--;
            }
        }
        else{
            if(int.value>1){
                att.value++;
                //var str=document.getElementById("str");
                int.value--;
            }
        }
    }

    //end
    // var agi=document.getElementById("agi");
    function add3(){
        if(att.value>0){
            att.value-=1;

            end.value++;
        }
    }
    function sub3(){
        if(war.checked==true){
            if(end.value>4){
                att.value++;
                //var str=document.getElementById("str");
                end.value--;
            }
        }
        else if(mag.checked==true){
            if(end.value>2){
                att.value++;
                end.value--;
            }
        }
        else{
            if(end.value>3){
                att.value++;
                //var str=document.getElementById("str");
                end.value--;
            }
        }
    }
    //武器技能
    var MW1skill=document.getElementById("MW1skill");
    var MW3skill=document.getElementById("MW3skill");
    var MW5skill=document.getElementById("MW5skill");
    //战士属性点
    function CWar1(){
        att.value="5";
        str.value="5";
        int.value="1";
        end.value="4";
        //主武器
        MW1.hidden=true;
        MW2.hidden=false;
        MW3.hidden=true;
        MW4.hidden=true;
        MW5.hidden=true;
        MW2.selected=true;
        MWad.value=arrMW[1][1];
        MWap.value=arrMW[1][2];
        MWhp.value=arrMW[1][3]
        MWski.value=arrMW[1][4];

        /*MW1skill.disabled=true;
         MW3skill.disabled=true;
         MW5skill.disabled=true;*/
    }
    //法师属性点
    function CMag1(){
        att.value="5";
        str.value="1";
        int.value="7";
        end.value="2";
        //主武器
        MW1.hidden=true;
        MW2.hidden=true;
        MW3.hidden=false;
        MW4.hidden=true;
        MW5.hidden=true;
        MW3.selected=true;
        MWad.value=arrMW[2][1];
        MWap.value=arrMW[2][2];
        MWhp.value=arrMW[2][3]
        MWski.value=arrMW[2][4];

        /*MW1skill.disabled=true;
         MW3skill.disabled=false;
         MW5skill.disabled=true;*/
    }
    //咸鱼属性点
    function CNon1(){
        att.value="10";
        str.value="1";
        int.value="1";
        end.value="3";
        //主武器
        MW1.hidden=false;
        MW2.hidden=true;
        MW3.hidden=true;
        MW4.hidden=true;
        MW5.hidden=true;
        MW1.selected=true;
        MWad.value=arrMW[0][1];
        MWap.value=arrMW[0][2];
        MWhp.value=arrMW[0][3]
        MWski.value=arrMW[0][4];

        /*	MW1skill.disabled=false;
         MW3skill.disabled=true;
         MW5skill.disabled=true;*/
    }
    //提交按钮
    function ok1(){

        var new1=document.getElementById("newid");
        var toNew=document.getElementById("toNewid");
        var con=window.confirm("确认提交？");
        //var form1=document.getElementById("from");
        if(con==true){
            toNew.hidden=true;
            new1.hidden=false;
            addValue1();
            //测试！！！
            //alert(basehp);
        }
    }
    //att
    var oatt=document.getElementById("att");
    var patt=document.getElementById("patt");
    //str
    var ostr=document.getElementById("str");
    var pstr=document.getElementById("pstr");
    //int
    var oint=document.getElementById("int");
    var pint=document.getElementById("pint");
    //end
    var oend=document.getElementById("end");
    var pend=document.getElementById("pend");

    //addValue1
    function addValue1(){
        //name
        //alert("12313");
        var pname=document.getElementById("pname");
        var oname=document.getElementById("name");
        if(oname.value==""){
            pname.value="player";
        }
        else{
            pname.value=oname.value;
        }
        //alert("1231");
        //sex
        var psex=document.getElementById("psex");
        var osex=document.getElementsByName("sex");
        for(var i=0;i<osex.length;i++){
            var osex1=osex[i];
            //alert("123");
            if(osex1.checked==true){
                psex.value=osex1.value;
            }
        }
        //job
        var pjob=document.getElementById("pjob");
        var ojob=document.getElementsByName("job");
        for(var j=0;j<ojob.length;j++){
            var ojob1=ojob[j];
            if(ojob1.checked==true){
                pjob.value=ojob1.value;
            }
        }

        patt.value=oatt.value;

        pstr.value=ostr.value;

        pint.value=oint.value;

        pend.value=oend.value;
    }
    function addns(){
        if(patt.value>0){
            pstr.value++;
            patt.value--;
        }
    }
    function addni(){
        if(patt.value>0){
            pint.value++;
            patt.value--;
        }
    }
    function addne(){
        if(patt.value>0){
            pend.value++;
            patt.value--;
        }
    }

    //BOSS FLAG  true=boss false=小怪
    var bossflag=false;

    //时时更新AD,AP,血量
    var pad=document.getElementById("pad");
    var pap=document.getElementById("pap");
    var php1=document.getElementById("php1");
    var php2=document.getElementById("php2");
    //基础血量
    //var basehp=(patt.value)


    setInterval("updateAD();updateAP();updateHp2();updateHp1();",10)
    var MWad1;
    var MWap1;
    var MWhp1;

    var SWad1;
    var SWap1;
    var SWhp1;
    /*var opstr=pstr.value;
     var opint=pint.value;
     var opend=pend.value;*/
    function updateAD(){
        padMW1();
        padSW1();
        var sum=Math.round((pstr.value)*1.3)+parseInt(MWad1)+parseInt(SWad1);
        pad.value=sum;
    }
    function updateAP(){

        var sum=Math.round((pint.value)*1.5)+parseInt(MWap1);
        var sum1=sum+parseInt(SWap1);
        pap.value=sum1;
    }
    function updateHp2(){

        var sum=(parseInt(pstr.value)+parseInt(pint.value)+parseInt(pend.value)+parseInt(patt.value))*10+parseInt(pend.value*20)+parseInt(MWhp1)+parseInt(SWhp1);
        php2.value=sum;
    }
    //var php2now=php2.value;
    //alert(php2now);
    //当前血量 目前还写不了!
    //setTimeout("updateHp1();",20);
    function updateHp1(){
        if(fightflag==false){
            php1.value=php2.value;
        }
        if(php1.value<=0){
            lose1();
        }
        //alert(php2.value);
    }
    //死亡
    function lose1(){
        alert("You Died!");
        location.reload();
    }

    //Level
    var lv=document.getElementById("lv");
    lv.value="0";
    //主武器
    var mainWAtt=document.getElementById("mainWAtt");
    var MWad=document.getElementById("MWad");
    var MWap=document.getElementById("MWap");
    /*	var MWstr=document.getElementById("MWstr");
     var MWint=document.getElementById("MWint");
     var MWend=document.getElementById("MWend");*/
    var MWhp=document.getElementById("MWhp");
    var MWski=document.getElementById("MWski");

    //武器属性 ad ap hp skill
    //技能先全2R
    var arrMW=new Array();
    arrMW[0]=["烧火棍","8","10","50","突刺(AD*0.7+AP*1.0)"];
    arrMW[1]=["铁剑","12","0","80",""];
    arrMW[2]=["学徒法杖","5","15","30","火焰冲击(AP*0.9)"];
    arrMW[3]=["钢剑","25","0","150",""];
    arrMW[4]=["火焰仪式剑","15","18","50","火球术(AP*2.5)"];
    function mainWeapon1(val){
        for(var i=0;i<arrMW.length;i++){
            var arrMW1=arrMW[i];
            var firstMW=arrMW1[0];
            if(firstMW==val){
                //mainWAtt.value=arrMW1[1]+arrMW1[2]+arrMW1[3]+arrMW1[4]+arrMW1[5];
                MWad.value=arrMW1[1];

                /*MWstr.value=arrMW1[2];

                 MWint.value=arrMW1[3];
                 MWend.value=arrMW1[4];*/
                MWap.value=arrMW1[2];
                MWhp.value=arrMW1[3]
                MWski.value=arrMW1[4];

            }
        }
    }
    //将武器属性写入人物属性
    //setInterval("updateMW1();",10);
    var MW1=document.getElementById("MW1");
    var MW2=document.getElementById("MW2");
    var MW3=document.getElementById("MW3");
    var MW4=document.getElementById("MW4");
    var MW5=document.getElementById("MW5");

    var SW1=document.getElementById("SW1");
    var SW2=document.getElementById("SW2");
    var SW3=document.getElementById("SW3");
    var SW4=document.getElementById("SW4");
    var SWnull=document.getElementById("SWnull");

    var SWad=document.getElementById("SWad");
    var SWap=document.getElementById("SWap");
    var SWhp=document.getElementById("SWhp");
    var SWski=document.getElementById("SWski");
    //副武器属性
    function padSW1(){
        if(SWnull.selected==true){
            SWad1=parseInt(arrSW[4][1]);
            SWap1=parseInt(arrSW[4][2]);
            SWhp1=parseInt(arrSW[4][3]);
        }
        else if(SW1.selected==true){
            SWad1=parseInt(arrSW[0][1]);
            SWap1=parseInt(arrSW[0][2]);
            SWhp1=parseInt(arrSW[0][3]);
        }
        else if(SW2.selected==true){
            SWad1=parseInt(arrSW[1][1]);
            SWap1=parseInt(arrSW[1][2]);
            SWhp1=parseInt(arrSW[1][3]);
        }
        else if(SW3.selected==true){
            SWad1=parseInt(arrSW[2][1]);
            SWap1=parseInt(arrSW[2][2]);
            SWhp1=parseInt(arrSW[2][3]);
        }
        else if(SW4.selected==true){
            SWad1=parseInt(arrSW[3][1]);
            SWap1=parseInt(arrSW[3][2]);
            SWhp1=parseInt(arrSW[3][3]);
        }
    }


    //默认咸鱼的时候
    MW1.hidden=false;
    MW2.hidden=true;
    MW3.hidden=true;
    MW4.hidden=true;
    MW5.hidden=true;
    MW1.selected=true;
    MWad.value=arrMW[0][1];
    MWap.value=arrMW[0][2];
    MWhp.value=arrMW[0][3]
    MWski.value=arrMW[0][4];

    //MW1skill.disabled=false;
    function padMW1(){
        if(MW1.selected==true){
            MWad1=parseInt(arrMW[0][1]);
            //alert(MWad);
            //pad.innerHTML=parseInt(pad.value)+parseInt(arrMW[0][1]);
            //pstr.value+=parseInt(arrMW[0][2]);
            MWap1=parseInt(arrMW[0][2]);
            MWhp1=parseInt(arrMW[0][3]);
            //武器技能
            /*MW1skill.disabled=false;
             MW3skill.disabled=true;
             MW5skill.disabled=true;*/
        }
        else if(MW2.selected==true){
            MWad1=parseInt(arrMW[1][1]);
            MWap1=parseInt(arrMW[1][2]);
            MWhp1=parseInt(arrMW[1][3]);
            //武器技能
            /*MW1skill.disabled=true;
             MW3skill.disabled=true;
             MW5skill.disabled=true;*/
        }
        else if(MW3.selected==true){
            MWad1=parseInt(arrMW[2][1]);
            MWap1=parseInt(arrMW[2][2]);
            MWhp1=parseInt(arrMW[2][3]);
            //武器技能
            /*MW1skill.disabled=true;
             MW3skill.disabled=false;
             MW5skill.disabled=true;*/
        }
        else if(MW4.selected==true){
            MWad1=parseInt(arrMW[3][1]);
            MWap1=parseInt(arrMW[3][2]);
            MWhp1=parseInt(arrMW[3][3]);
            //武器技能
            /*MW1skill.disabled=true;
             MW3skill.disabled=true;
             MW5skill.disabled=true;*/
        }
        else if(MW5.selected==true){
            MWad1=parseInt(arrMW[4][1]);
            MWap1=parseInt(arrMW[4][2]);
            MWhp1=parseInt(arrMW[4][3]);
            //武器技能
            /*MW1skill.disabled=true;
             MW3skill.disabled=true;
             MW5skill.disabled=false;*/
        }
    }
    //技能伤害
    setInterval("updateMWsd1();updateSWsd1();",10);
    var MWsd=document.getElementById("MWsd");
    //主武器技能
    function updateMWsd1(){
        //突刺
        if(MW1.selected==true){
            MWsd.value=Math.round(parseInt(pad.value)*0.7)+Math.round(parseInt(pap.value)*1.0);
        }
        else if(MW2.selected==true){
            MWsd.value="";
        }
        //火冲
        else if(MW3.selected==true){
            MWsd.value=Math.round(parseInt(pap.value)*0.9);
        }
        else if(MW4.selected==true){
            MWsd.value="";
        }
        //火球术
        else if(MW5.selected==true){
            MWsd.value=Math.round(parseInt(pap.value)*2.5);
        }

    }
    //副武器技能
    function updateSWsd1(){
        //二重打击
        if(SW2.selected==true){
            SWsd.value=parseInt(pad.value*2.0);
        }
    }

    //设定怪物血量
    var monhp1=document.getElementById("monhp1");
    var monhp2=document.getElementById("monhp2");
    monhp1.value="250";
    monhp2.value="250";
    //攻击
    var monimg1=document.getElementById("monimg1");
    var attackhp=document.getElementById("attackhp");
    //恢复
    function renew1(){
        if(bossflag==true){
            monimg1.src="${pageContext.request.contextPath}/Game/New/staticBOSS.jpg";
        }
        else{
            monimg1.src="${pageContext.request.contextPath}/Game/New/staticMonster.jpg";
        }
        attackhp.innerHTML="";
    }
    function renew2(){
        if(bossflag==true){
            monimg1.src="${pageContext.request.contextPath}/Game/New/staticBOSS.jpg";
        }
        else{
            monimg1.src="${pageContext.request.contextPath}/Game/New/staticMonster.jpg";
        }
        byattackhp.innerHTML="";

    }
    //旗子
    //var flag=true;

    //计数器
    var count=0;

    //GM技能
    function GM1(){
        monhp1.value=-1;
        win1();
    }


    //普通攻击
    function attack1(){
        if(bossflag==false){
            monimg1.src="${pageContext.request.contextPath}/Game/New/underAttackMonster.jpg";
            monhp1.value-=parseInt(pad.value);
        }
        else{
            monimg1.src="${pageContext.request.contextPath}/Game/New/underAttackBOSS.jpg";
            bosshp1.value-=parseInt(pad.value);
        }
        attackhp.innerHTML="-"+pad.value;
        //monhp1.value-=parseInt(pad.value);
        setTimeout("renew1();",300);
        win1();


        setTimeout("monsterAttack1();",400);
        setTimeout("renew2();",700);


    }
    //突刺
    function MW1attack1(){
        if(bossflag==false){
            monimg1.src="${pageContext.request.contextPath}/Game/New/rush.jpg";
            monhp1.value-=parseInt(MWsd.value);
        }
        else{
            monimg1.src="${pageContext.request.contextPath}/Game/New/rushBoss.jpg";
            bosshp1.value-=parseInt(MWsd.value);
        }
        setTimeout("renew1();",300);
        attackhp.innerHTML="-"+MWsd.value;
        //monhp1.value-=parseInt(MWsd.value);
        win1();


        setTimeout("monsterAttack1();",400);
        setTimeout("renew2();",700);

    }
    //火焰冲击
    function MW3attack1(){
        if(bossflag==false){
            monimg1.src="${pageContext.request.contextPath}/Game/New/fire.jpg";
            monhp1.value-=parseInt(MWsd.value);
        }
        else{
            monimg1.src="${pageContext.request.contextPath}/Game/New/fireImpactBOSS.jpg";
            bosshp1.value-=parseInt(MWsd.value);
        }
        setTimeout("renew1();",300);
        attackhp.innerHTML="-"+MWsd.value;
        //monhp1.value-=parseInt(MWsd.value);
        win1();

        setTimeout("monsterAttack1();",400);
        setTimeout("renew2();",700);

    }
    //火球术
    function MW5attack1(){
        if(SW3.selected==false){
            MW5skill.disabled=true;
        }
        if(bossflag==false){
            monimg1.src="${pageContext.request.contextPath}/Game/New/fireBall.jpg";
            monhp1.value-=parseInt(MWsd.value);
        }
        else{
            monimg1.src="${pageContext.request.contextPath}/Game/New/fireBallBOSS.jpg";
            bosshp1.value-=parseInt(MWsd.value);
        }
        setTimeout("renew1();",300);
        attackhp.innerHTML="-"+MWsd.value;
        //monhp1.value-=parseInt(MWsd.value);
        win1();


        setTimeout("monsterAttack1();",400);
        setTimeout("renew2();",700);

    }
    //二重打击
    function SW2attack1(){
        SW2skill.disabled=true;
        if(bossflag==false){
            monimg1.src="${pageContext.request.contextPath}/Game/New/doubleAttack.jpg";
            monhp1.value-=parseInt(SWsd.value);
        }
        else{
            monimg1.src="${pageContext.request.contextPath}/Game/New/doubleAttackBOSS.jpg";
            bosshp1.value-=parseInt(SWsd.value);
        }
        setTimeout("renew1();",300);
        attackhp.innerHTML="-"+SWsd.value;
        //monhp1.value-=parseInt(SWsd.value);
        win1();


        setTimeout("monsterAttack1();",400);
        setTimeout("renew2();",700);

    }
    //反弹
    function SW4attack1(){
        SW4skill.disabled=true
        if(bossflag==false){
            monimg1.src="${pageContext.request.contextPath}/Game/New/monsterAttack1.jpg";
        }
        else{
            monimg1.src="${pageContext.request.contextPath}/Game/New/Boss攻击1.jpg";
        }
        setTimeout("fantan1();",300)
        //setTimeout("renew1();",300);
        setTimeout("renew1();",700);

        win1();

    }
    //反弹效果
    function fantan1(){
        count++;
        if(bossflag==false){
            monimg1.src="${pageContext.request.contextPath}/Game/New/rebound.jpg";
            attackhp.innerHTML="-"+(monhp2.value)*0.05;
            monhp1.value-=parseInt((monhp2.value)*0.05);
        }
        else{
            monimg1.src="${pageContext.request.contextPath}/Game/New/reboundBoss.jpg";
            attackhp.innerHTML="-"+(bosshp2.value)*0.05;
            bosshp1.value-=parseInt((bosshp2.value)*0.05);
        }
        //attackhp.innerHTML="-"+(monhp2.value)*0.05;
        //monhp1.value-=parseInt((monhp2.value)*0.05);
    }

    //怪物是否死亡
    var lvcount=0;
    var commonskill=document.getElementById("commonskill");
    function win1(){
        if(parseInt(monhp1.value)<=0||parseInt(bosshp1.value)<=0){
            alert("你赢了!");
            var tempmonhp2=monhp2.value;
            var tempmonhp1=monhp1.value;
            php1.value=php2.value;
            var templv=lv.value;
            var temppatt=patt.value;
            if(bossflag==false){
                monhp2.value=parseInt(tempmonhp2)+30;

                monhp1.value=monhp2.value;

                lvcount++;

                if(lvcount%2==0&&lv.value<10){
                    lv.value=parseInt(templv)+1;
                    patt.value=parseInt(temppatt)+1;
                }
            }
            else{
                if(lv.value<10){
                    lv.value=parseInt(templv)+1;
                    patt.value=parseInt(temppatt)+1;
                }
            }
            //patt.value=parseInt(temppatt)+1;
            commonskill.disabled=true;
            MW1skill.disabled=true;
            MW3skill.disabled=true;
            MW5skill.disabled=true;


            var random1=Math.random()*10;
            if(bossflag==false){
                if(random1>=1&&random1<=2){
                    if(MW5.hidden==true){
                        alert("你获得了火焰仪式剑！");
                        MW5.hidden=false;
                        return;
                    }
                }
                if(random1>=7&&random1<=8){
                    if(MW4.hidden==true){
                        alert("你获得了钢剑！");
                        MW4.hidden=false;
                        return;
                    }
                }
                if(random1>=1&&random1<5){
                    if(MW3.hidden==true){
                        alert("你获得了学徒法杖！");
                        MW3.hidden=false;
                        return;
                    }
                }
                if(random1>5&&random1<=8){
                    if(MW2.hidden==true){
                        alert("你获得了铁剑！");
                        MW2.hidden=false;
                        return;
                    }
                }
                if(random1>=1&&random1<=9){
                    if(MW1.hidden==true){
                        alert("你获得了烧火棍！");
                        MW1.hidden=false;
                        return;
                    }
                }
                if(random1>=4&&random1<=6){
                    if(SW1.hidden==true){
                        alert("你获得了咸鱼！");
                        SW1.hidden=false;
                        return;
                    }

                }
            }
            else{


                if(random1>=0&&random1<2){
                    if(SW4.hidden==true){
                        alert("你获得了长方盾！");
                        SW4.hidden=false;
                        return;
                    }
                }
                if(random1>=6&&random1<=9){
                    if(SW2.hidden==true){
                        alert("你获得了匕首！");
                        SW2.hidden=false;
                        return;
                    }
                }
                if(random1>=2&&random1<6){
                    if(SW3.hidden==true){
                        alert("你获得了火焰魔典！");
                        SW3.hidden=false;
                        return;
                    }
                }
                if(true){
                    if(SW1.hidden==true){
                        alert("你获得了咸鱼！");
                        SW1.hidden=false;
                        return;
                    }
                }
            }
        }
    }

    //怪物攻击
    //进入战斗的旗子
    var fightflag=false;

    var byattackhp=document.getElementById("byattackhp");

    function monsterAttack1(){
        count++;
        //技能CD
        if(count%2==0){
            if(MW5.selected==true){
                MW5skill.disabled=false;
            }
            if(SW2.selected==true){
                SW2skill.disabled=false;
            }
            if(SW4.selected==true){
                SW4skill.disabled=false;
            }
        }
        if(bossflag==false){
            if(count%6==0&&count!=0){
                monimg1.src="${pageContext.request.contextPath}/Game/New/monsterAttack3.jpg";
                byattackhp.innerHTML="-"+50;
                php1.value-=50;
            }
            else if(count%3==0&&count!=0){
                monimg1.src="${pageContext.request.contextPath}/Game/New/monsterAttack2.jpg";
                byattackhp.innerHTML="-"+30;
                php1.value-=30;
            }
            else{
                monimg1.src="${pageContext.request.contextPath}/Game/New/monsterAttack1.jpg";
                byattackhp.innerHTML="-"+15;
                php1.value-=15;
            }
        }
        else{
            if(count%10==0&&count!=0){
                monimg1.src="${pageContext.request.contextPath}/Game/New/BOSSattack4.jpg";
                byattackhp.innerHTML="-"+100;
                php1.value-=100;
            }
            else if(count%6==0&&count!=0){
                monimg1.src="${pageContext.request.contextPath}/Game/New/BOSSattack3.jpg";
                byattackhp.innerHTML="-"+55;
                php1.value-=55;
            }
            else if(count%3==0&&count!=0){
                monimg1.src="${pageContext.request.contextPath}/Game/New/BOSSattack2.jpg";
                byattackhp.innerHTML="-"+35;
                php1.value-=35;
            }
            else{
                monimg1.src="${pageContext.request.contextPath}/Game/New/BOSSattack1.jpg";
                byattackhp.innerHTML="-"+20;
                php1.value-=20;
            }
        }
    }
    var mondiv=document.getElementById("monid");
    var bossdiv=document.getElementById("bossid");

    //副武器
    //arrSW[4]是null
    var arrSW=new Array();
    arrSW[0]=["咸鱼","10","10","200",""];
    arrSW[1]=["匕首","25","0","150","二重打击(AD*2.0)"];
    arrSW[2]=["火焰魔典","0","15","100","火球术没有CD"];
    arrSW[3]=["长方盾","0","0","300","反弹"];
    arrSW[4]=["null","0","0","0",""];
    function secWeapon1(val2){
        for(var i=0;i<arrSW.length;i++){
            var arrSW1=arrSW[i];
            var firstSW=arrSW1[0];
            if(firstSW==val2){
                SWad.value=arrSW1[1];
                SWap.value=arrSW1[2];
                SWhp.value=arrSW1[3];
                SWski.value=arrSW1[4];

            }
        }
    }
    //战斗
    var tempmonhp2=monhp2.value;
    var tempmonhp1=monhp1.value;
    var templv=lv.value;
    function fight1(){
        //升级和重置
        monimg1.src="${pageContext.request.contextPath}/Game/New/staticMonster.jpg";
        mondiv.hidden=false;
        bossdiv.hidden=true
        bossflag=false;

        php1.value=php2.value;
        count=0;

        commonskill.disabled=false;
        if(MW1.selected==true){
            MW1skill.disabled=false;
        }
        else{
            MW1skill.disabled=true;
        }
        if(MW3.selected==true){
            MW3skill.disabled=false;
        }
        else{
            MW3skill.disabled=true;
        }
        if(MW5.selected==true){
            MW5skill.disabled=false;
        }
        else{
            MW5skill.disabled=true;
        }
        if(SW2.selected==true){
            SW2skill.disabled=false;
        }
        else{
            SW2skill.disabled=true;
        }
        if(SW4.selected==true){
            SW4skill.disabled=false;
        }
        else{
            SW4skill.disabled=true;
        }

        fightflag=true;
    }
    //BOSS按钮
    var bosshp1=document.getElementById("bosshp1");
    var bosshp2=document.getElementById("bosshp2");
    function bossfight1(){
        mondiv.hidden=true;
        bossdiv.hidden=false;
        bossflag=true;
        php1.value=php2.value;
        count=0;
        monimg1.src="${pageContext.request.contextPath}/Game/New/staticBOSS.jpg";

        bosshp2.value="1000";
        bosshp1.value=bosshp2.value;


        fightflag=true;

        commonskill.disabled=false;
        if(MW1.selected==true){
            MW1skill.disabled=false;
        }
        else{
            MW1skill.disabled=true;
        }
        if(MW3.selected==true){
            MW3skill.disabled=false;
        }
        else{
            MW3skill.disabled=true;
        }
        if(MW5.selected==true){
            MW5skill.disabled=false;
        }
        else{
            MW5skill.disabled=true;
        }
        if(SW2.selected==true){
            SW2skill.disabled=false;
        }
        else{
            SW2skill.disabled=true;
        }
        if(SW4.selected==true){
            SW4skill.disabled=false;
        }
        else{
            SW4skill.disabled=true;
        }

    }
    //返回主页的方法
    var backhomepage=document.getElementById("backhomepage");
    function backhomepage1(){
        backhomepage.src="${pageContext.request.contextPath}/Game/New/focusBackHomepage.jpg";
    }
    function backhomepage2(){
        backhomepage.src="${pageContext.request.contextPath}/Game/New/backHomepage.jpg";
    }
    function back1(){
        window.history.back();
    }
</script>
</html>
