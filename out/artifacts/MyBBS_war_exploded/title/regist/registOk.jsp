<%--
  Created by IntelliJ IDEA.
  User: Mayijun
  Date: 2016/9/8
  Time: 12:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>注册成功!</title>
</head>
<body>
<img src="<c:url value="/title/image/regist-success.jpg"/> "/>
<br/>
&nbsp;<a href="<c:url value="/title/login/login.jsp"/> "><font color="blue" size="3">&gt;&gt;&gt;3秒后自动跳转，若无跳转，点击此处跳转至登录页面</font> </a>
</body>
<script type="text/javascript">
    //自动跳转
    window.setTimeout("goto1();",3000);
    function goto1(){
        window.location.href="${pageContext.request.contextPath}/title/login/login.jsp";
    }
</script>
</html>
