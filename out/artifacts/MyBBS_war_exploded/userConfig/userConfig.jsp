<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mayijun
  Date: 2016/9/16
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户设置</title>
</head>
<body>
    <%--登录后和登录前不同的TITLE.JSP--%>
    <%
        if(session.getAttribute("username")!=null){%>
    <jsp:include page="${pageContext.request.contextPath}/title/titleSuccess.jsp"/>
    <%
    }
    else {
    %>
    <jsp:include page="${pageContext.request.contextPath}/title/title.jsp"/>
    <%
        }
    %>

    <%--放Mybbs>>XXX这个导航--%>
        <span style="height:5%;width:100%;font-weight: bold;font-size: larger;position: absolute;top:19%;">
            &nbsp;<img height:="2.5%" width="1%" src="<c:url value="/index/image/index-home.jpg"/>"/>  &gt;&gt;  <a href="<c:url value="/index.jsp"/>">MyBBS</a>  &gt;&gt;  用户设置
        </span>

    <%--用户设置正式内容--%>
    <div style="background-color:#99d9ea;border:2px solid black;width:97.6%;height:74%;position:absolute;top:24%;left:1%;">
        <%-- 用户设置标题--%>
        <br/>
        &nbsp;<span style="font-size: 220%"><b>用户设置</b><hr/></span>
        <%--左边的选项栏--%>
        <div style="border:2px solid black;position: absolute;left:10%;top:15%;width:15%;height:75%;">
            <hr/><input type="button" value="修改密码" style="width:100%;height: 15%"
                        onclick="setPassword1()"/><br/><hr/>
            <input type="button" value="自己的主题帖" style="width:100%;height: 15%"/><br/><hr/>
        </div>
        <%--右边的显示框：修改密码--%>
        <div id="setPassword"
                <%
                   /* if("no".equals(request.getAttribute("success"))){
                        //System.out.println("no".equals(request.getAttribute("success")));
                        out.print(" hidden=false ");
                    }
                    else{
                        out.print(" hidden ");
                    }*/
                %>
              style="border:2px solid black;position: absolute;left:30%;top:15%;width:50%;height:80%;">
            <%--修改密码标题--%>
                <br/>
                &nbsp;<span style="font-size: 150%"><b>修改密码</b><hr/></span>
            <%--修改密码内容--%>
                <%
                    //修改密码的警告
                    String oldPasswordWarn="";
                    if((String)request.getAttribute("oldPasswordWarn")!=null){
                        oldPasswordWarn=(String)request.getAttribute("oldPasswordWarn");
                    }
                    String newPasswordWarn="";
                    if((String)request.getAttribute("newPasswordWarn")!=null){
                        newPasswordWarn=(String)request.getAttribute("newPasswordWarn");
                    }
                    String newPasswordOkWarn="";
                    if((String)request.getAttribute("newPasswordOkWarn")!=null){
                        newPasswordOkWarn=(String)request.getAttribute("newPasswordOkWarn");
                    }
                %>
            <div id="setPasswordContent" style="position:relative;left:5%;">
                <form id="setPasswordForm" action="<c:url value="/SetPasswordServlet"/> " method="post">
                    <table style="border-collapse:   separate;   border-spacing:   25px; ">
                        <tr>
                            <td align="right">旧密码:</td>
                            <td><input id="oldPassword" name="oldPassword" type="text" size="15" onclick="oldPassword1()"/> </td>
                            <td ><font color="red" id="oldPasswordWarn" size="1"><%=oldPasswordWarn%></font></td>
                        </tr>
                        <tr>
                            <td align="right">新密码:</td>
                            <td><input id="newPassword" name="newPassword" type="text" size="15" onclick="newPassword1()"/> </td>
                            <td><font color="red" id="newPasswordWarn" size="1"><%=newPasswordWarn%></font></td>
                        </tr>
                        <tr>
                            <td align="right">再次输入新密码:</td>
                            <td><input id="newPasswordOk" name="newPasswordOk" type="text" size="15" onclick="newPasswordOk1()"/> </td>
                            <td><font color="red" id="newPasswordOkWarn" size="1"><%=newPasswordOkWarn%></font></td>
                        </tr>
                    </table>
                    <span style="position:relative;left:15%;"><input type="button" value="提交"
                                                                     style="width:20%;height:5%;" onclick="confirm1()" /></span>
                </form>
            </div>
        </div>
    </div>
</body>
<script type="text/javascript">
    //拿到修改密码的框体
    var setPassword=document.getElementById("setPassword");
    function setPassword1(){
        setPassword.hidden=false;
    }
    //提交给一个确认框体的方法
    var setPasswordForm=document.getElementById("setPasswordForm");
    function confirm1(){
        var con=confirm("确认修改？");
        if(con==true){
            setPasswordForm.submit();
        }
    }
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/userConfig/userConfig.js"></script>
</html>
