<%--
  Created by IntelliJ IDEA.
  User: Mayijun
  Date: 2016/9/6
  Time: 13:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>MyBBS登录</title>
</head>
<body>
    <div style="position: absolute;top:5.2%;left:34.5%;">
        <img width="100%" height="18%" src="<c:url value="/title/image/title-MyBBS.jpg"/> ">
    </div>
    <div style="border:3px solid black ;height:400px;width: 450px;position: absolute;top: 20.5%;left: 35%;">
        <br/><font size="6" color="black">&nbsp;登录 |</font><hr/>

        <%--错误信息，防止NULL--%>
        <%
            String usernameWarn="";
            if((String)request.getAttribute("loginUsernameWarn")!=null){
                usernameWarn=(String)request.getAttribute("loginUsernameWarn");
            }
            String passwordWarn="";
            if((String)request.getAttribute("loginPasswordWarn")!=null){
                passwordWarn=(String)request.getAttribute("loginPasswordWarn");
            }
            //session保存正确的用户名
            String usernameOk="";
            if((String)session.getAttribute("loginUsername")!=null){
                usernameOk=(String)session.getAttribute("loginUsername");
            }

            //main.myLogin.loginFilter
            String loginFilterWarn="";
            if((String)request.getAttribute("loginFilterWarn")!=null){
                loginFilterWarn=(String)request.getAttribute("loginFilterWarn");
            }
        %>

       <%-- 各自留了一个<td>写错误提示!验证码多一个用来放图片！--%>
        <div style="position: absolute;top:25%;left:10%;">
            <form action="<c:url value="/LoginServlet"/> " method="post">
                <table style="border-collapse:   separate;   border-spacing:   25px; ">
                    <tr>
                        <td align="right">用户名:</td>
                        <td><input type="text"  size="15" name="username" placeholder="请输入用户名" value="<%=usernameOk%>"/></td>
                        <td ><font color="red" size="1" ><%=usernameWarn+loginFilterWarn%></font> </td>
                    </tr>
                    <tr>
                        <td align="right">密码:</td>
                        <td><input type="password"  size="15" name="password" placeholder="请输入密码"/> </td>
                        <td ><font color="red" size="1" ><%=passwordWarn%></font> </td>
                    </tr>
                  <%--  <tr>
                        <td align="right">验证码:</td>
                        <td><input type="text" maxlength="4" size="6" name="identify"/> </td>
                        <td></td>
                        <td></td>
                    </tr>--%>
                </table>

                <span style="position: absolute;top:135px;left:80px;">
                    <button type="submit"><img src="<c:url value="/title/image/login-loginOk.jpg"/> "></button>
                </span>

            </form>
            <span style="position: absolute;left:75%;top:100%;">
            <form action="<c:url value="/LoginIPServlet"/> " method="post">
                <button  type="submit">游客登录</button>
            </form>
            </span>
        </div>

        <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
        <hr/>

        <span style="position:absolute;top:85%;left:5%;">
            <input type="image" src="<c:url value="/title/image/login-regist.jpg"/> " onclick="regist1();"/>
        </span>
        <span style="position:absolute;top:85%;left:45%;">
            <input type="image" src="<c:url value="/title/image/regist&login-return.jpg"/> " onclick="return1();"/>
        </span>
    </div>
</body>
<script type="text/javascript">

    function regist1(){
        window.location.href="${pageContext.request.contextPath}/title/regist/regist.jsp";
    }

    function return1(){
        window.location.href="${pageContext.request.contextPath}/index.jsp";
    }

</script>
</html>
