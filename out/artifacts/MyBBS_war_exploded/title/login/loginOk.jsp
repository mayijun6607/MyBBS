<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mayijun
  Date: 2016/9/8
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功!</title>
</head>
<body>
    <img src="<c:url value="/title/image/login-success.jpg"/> "/>
    <br/>
    &nbsp;<a href="<c:url value="/title/title.jsp"/> "><font color="blue" size="3">3秒后自动跳转，若无跳转，点击此处跳转至主页</font> </a>
</body>
<script type="text/javascript">
    //自动跳转
    window.setTimeout("goto1();",3000);
    function goto1(){
        window.location.href="${pageContext.request.contextPath}/title/title.jsp";
    }
</script>
</html>
