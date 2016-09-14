<%--
  Created by IntelliJ IDEA.
  User: Mayijun
  Date: 2016/9/6
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>MyBBS注册</title>
</head>
<body>
    <div style="position: absolute;top:2.5%;left:30.5%;"><img width="100%" height="18%" src="<c:url value="/title/image/title-MyBBS.jpg"/> ">
        <%--<h1 style="font-weight: bold;font-size: xx-large">MyBBS</h1>--%>
    </div>

 <%--   每个都留了一个<td>做报错处理！验证码多一个<td>，放图片--%>
    <div style="border:3px solid black ;height:500px;width: 550px;position: absolute;top: 18%;left: 31%;">
        <br/><font size="6" color="black">&nbsp;注册 |</font><hr/>
        <div style="position: absolute;top:15%;left:7%;">

            <form action="<c:url value="/RegistServlet"/> " method="post">

               <%-- 格式验证防止出现NULL--%>
                <%
                    String warnInfo1="";
                    if((String)request.getAttribute("warnInfo1")!=null){
                        warnInfo1=(String)request.getAttribute("warnInfo1");
                    }
                    String warnInfo2="";
                    if((String)request.getAttribute("warnInfo2")!=null){
                        warnInfo2=(String)request.getAttribute("warnInfo2");
                    }
                    String warnInfo3="";
                    if((String)request.getAttribute("warnInfo3")!=null){
                        warnInfo3=(String)request.getAttribute("warnInfo3");
                    }
                    String warnInfo4="";
                    if((String)request.getAttribute("warnInfo4")!=null){
                        warnInfo4=(String)request.getAttribute("warnInfo4");
                    }

                    //用户名重复提示
                    String warnInfo="";
                    if((String)request.getAttribute("warnInfo")!=null){
                        warnInfo=(String)request.getAttribute("warnInfo");
                    }
                %>

               <%-- Session保存了格式正确的用户名--%>
                <%
                   String usernameOk="";
                    if((String)session.getAttribute("registUsername")!=null){
                        usernameOk=(String)session.getAttribute("registUsername");
                    }
                %>

                <table style="border-collapse:   separate;   border-spacing:   25px; ">
                    <tr >
                        <td align="right"><font color="red">*</font>用户名:</td>
                        <td><input type="text" placeholder="" id="username" name="username" size="20"
                                    onclick="username1();" value="<%=usernameOk%>"/></td>
                        <td ><font color="red" id="usernameWarn" size="1"><%=warnInfo1+warnInfo%></font></td>
                    </tr>
                    <tr>
                        <td align="right"><font color="red">*</font>密码:</td>
                        <td><input type="password" id="password" name="password" size="20"
                                   placeholder="" onclick="password1();"/> </td>
                        <td ><font color="red" id="passwordWarn" size="1"><%=warnInfo2%></font></td>
                    </tr>
                    <tr>
                        <td align="right"><font color="red">*</font>确认密码:</td>
                        <td><input type="password" id="passwordOk" name="passwordOk" size="20"
                                   placeholder="" onclick="passwordOk1();"/></td>
                        <td ><font color="red" id="passwordOkWarn" size="1"><%=warnInfo3%></font></td>
                    </tr>
                    <%--取消邮箱--%>
                   <%-- <tr>
                        <td align="right"><font color="red">*</font>邮箱:</td>
                        <td><input type="text" id="email" name="email" size="20" placeholder="请输入您的邮箱" </td>
                        <td align="center"><font color="red" id="emailWarn" size="1"></font></td>
                    </tr>--%>
                    <tr>
                        <td align="right"><font color="red">*</font>验证码:</td>
                        <td><input type="text" size="6" maxlength="4" id="identify" name="identify"
                                   onclick="identify1();" /></td>
                        <td ><font color="red" id="identifyWarn" size="1"><%=warnInfo4%></font></td>
                    </tr>
                    <%--用来放验证码--%>
                    <span style="position:absolute;top:210px;left:80px;">
                        <img id="verifyCode"  src="<c:url value="/VerifyCodeServlet"/> " border="1"/>
                        &nbsp;<button type="button" onclick="change1()">点击换一张</button>
                    </span>

                </table>

                  <span style="position: absolute;top:260px;left:90px;">
                    <button type="submit"><img  src="<c:url value="/title/image/regist-registOk.jpg"/> "></button>
                  </span>

            </form>
        </div>


       <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
        <hr/>

        <span style="position:absolute;top:85%;left:5%;">
            <input type="image" src="<c:url value="/title/image/regist-login.jpg"/> " onclick="login1();"/>
        </span>
        <span style="position:absolute;top:85%;left:45%;">
            <input type="image" src="<c:url value="/title/image/regist&login-return.jpg"/> " onclick="return1();"/>
        </span>
    </div>
</body>
<script type="application/javascript">
    function login1(){
        window.location.href="${pageContext.request.contextPath}/title/login/login.jsp";
    }

    function return1(){
        window.location.href="${pageContext.request.contextPath}/index.jsp";
    }
    //换一张验证码
    var verifyCodeImg=document.getElementById("verifyCode");
    function change1(){
        verifyCodeImg.src="<c:url value="/VerifyCodeServlet"/>?new="+new Date().getTime();
    }
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/title/regist/regist2.js"></script>

</html>
