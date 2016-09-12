<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mayijun
  Date: 2016/9/6
  Time: 13:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%--所有页面的最上面的页面，动态包含--%>
    <div style="border: 3px solid black ;height:10%;width:100%;background-color: #99d9ea;">
        <span  style="position: absolute;left: 2%;top: 3%;"><font size="5" color="black">制作人:马益钧</font></span>
        <span  id="time" style="position: absolute;left: 2%;top: 8%;font-weight: bold;font-size: large;">
        </span>
        <span  style="position: absolute;left: 80%;top: 5%;">
            <a href="${pageContext.request.contextPath}/title/login/login.jsp"><font size="6" color="blue">登录</font> </a>&nbsp;&nbsp;
            <a href="${pageContext.request.contextPath}/title/regist/regist.jsp"><font size="6" color="blue">注册</font> </a>
        </span>
        <span style="position: absolute;left: 45%;top: 4%;"><font size="10" color="black">MyBBS</font></span>
    </div>
<%--放首页、群聊、自制游戏的一栏--%>
<div style="border:2px solid black;height: 6%;width:99.1%;position:absolute;top:11.5%;background-color:#99d9ea">
        <span style="position:absolute;left:2%;" onmousemove="homepage1()" onmouseout="homepage2()" onclick="returnHomepage()">
            <input type="image" id="homepage" width="100%" height="100%" src="<c:url value="/title/image/title-homepage.jpg"/> "/>
        </span>
        <span style="position:absolute;left:10%;" onmousemove="groupchat1()" onmouseout="groupchat2()">
            <input type="image" id="groupchat" width="100%" height="100%" src="<c:url value="/title/image/title-groupchat.jpg"/> "/>
        </span>
        <span style="position:absolute;left:18%;" onmousemove="mygame1()" onmouseout="mygame2()" onclick="playgame()">
            <input type="image" id="mygame" width="100%" height="100%" src="<c:url value="/title/image/title-game.jpg"/> "/>
        </span>
        <span style="position:absolute;right:5%;" onmousemove="userconfig1()" onmouseout="userconfig2()" onclick="setConfig()">
            <input type="image" id="userconfig" width="100%" height="100%" src="<c:url value="/title/image/title-config.jpg"/> "/>
        </span>
</div>
</body>
<script type="text/javascript">
    var time=document.getElementById("time");
    var date,now;
    window.setInterval("flush();",100);
    function flush(){
        date=new Date();
        now=date.toLocaleString();
        time.innerHTML=now;
    }
    //标签换色
    //首页
    var homepage=document.getElementById("homepage");
    function homepage1(){
        homepage.src="${pageContext.request.contextPath}/title/image/title-focusHomepage.jpg";
    }
    function homepage2(){
        homepage.src="${pageContext.request.contextPath}/title/image/title-homepage.jpg";
    }
    function returnHomepage(){
        window.location.href="${pageContext.request.contextPath}/index.jsp";
    }

    //群聊
    var groupchat=document.getElementById("groupchat");
    function groupchat1(){
        groupchat.src="${pageContext.request.contextPath}/title/image/title-focusGroupchat.jpg";
    }
    function groupchat2(){
        groupchat.src="${pageContext.request.contextPath}/title/image/title-groupchat.jpg";
    }

    //游戏
    var mygame=document.getElementById("mygame");
    function  mygame1(){
        mygame.src="${pageContext.request.contextPath}/title/image/title-focusGame.jpg";
    }
    function  mygame2(){
        mygame.src="${pageContext.request.contextPath}/title/image/title-game.jpg";
    }
    function playgame(){
        window.location.href="${pageContext.request.contextPath}/Game/Major.jsp";
    }

    //用户设置
    var userconfig=document.getElementById("userconfig");
    function userconfig1(){
        userconfig.src="${pageContext.request.contextPath}/title/image/title-focusConfig.jpg";
    }
    function userconfig2(){
        userconfig.src="${pageContext.request.contextPath}/title/image/title-config.jpg";
    }
    function setConfig(){
        window.location.href="";
    }
</script>
</html>
