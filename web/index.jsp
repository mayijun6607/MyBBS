<%--
  Created by IntelliJ IDEA.
  User: Mayijun
  Date: 2016/9/6
  Time: 13:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>MyBBS</title>
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

 <%-- 主页的正式内容--%>

  <%--放Mybbs>>XXX这个导航--%>
  <span style="height:5%;width:100%;font-weight: bold;font-size: larger;position: absolute;top:19%;">
   &nbsp;<img height:="2.5%" width="1%" src="<c:url value="/index/image/index-home.jpg"/>"/>  &gt;&gt;  <a href="<c:url value="/index.jsp"/>">MyBBS</a>
  </span>

  <%--日常区板块--%>
  <div style="background-color:#99d9ea;border:2px solid black;height:74%;width:50%;position:absolute;top:24%;left:2%;">

    <%--日常区横幅--%>
    <span ><img  src="<c:url value="/index/image/index-commonday.jpg"/> "/> <hr/></span>

    <%--官方公告--%>
    <div style="border:1px solid black;position:absolute;top:12%;left:1.5%;">
      <img  src="<c:url value="/index/image/index-official.jpg" />"/>
    </div>
      <span style="font-size: x-large;font-weight: bold;position:absolute;top:12.5%;left:17%;"><a href="">MyBBS|官方公告</a> </span>
      <span style="position:absolute;top:20%;left:17%;">官方信息发布<b>(>>未施工<<)</b></span>

    <%--综合讨论--%>
    <div style="position: absolute;top:12% ;left:50%;">
      <img width="40%" height="22%" src="<c:url value="/index/image/index-general.jpg"/> "/>
    </div>
      <span style="font-size: x-large;font-weight: bold;position:absolute;top:12.5%;left:72%;">
        <a href="<c:url value="/general/general.jsp"/> ">MyBBS|综合讨论</a>
      </span>
      <span style="position:absolute;top:20%;left:72%;">综合讨论，日常灌水</span>

  </div>

  <%--没想好，右上角板块--%>
  <div style="background-color:#99d9ea;border:2px solid black;height:34%;width:43%;position:absolute;top:24%;right:2%;">

  </div>

  <%--没想好，右下角板块--%>
  <div style="background-color:#99d9ea;border:2px solid black;height:38%;width:43%;position:absolute;top:60%;right:2%;">

  </div>
  </body>
</html>
