<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mayijun
  Date: 2016/9/19
  Time: 12:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除成功!</title>
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
            &nbsp;<img height:="2.5%" width="1%" src="<c:url value="/index/image/index-home.jpg"/>"/>  &gt;&gt;  <a href="<c:url value="/index.jsp"/>">MyBBS</a>  &gt;&gt;  综合讨论
        </span>

    <%--删除成功内容--%>
    <div style="background-color:#99d9ea;border:2px solid black;width:97.6%;height:74%;position:absolute;top:24%;left:1%;">
        <h1><b>删除成功！</b></h1>
    </div>
</body>
</html>
