<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mayijun
  Date: 2016/9/12
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        String username="";
        String tieziTitle="";
        String tieziContent="";
        String tieziTime="";
        String[] tiezi={"","","",""};
        tiezi=(String[]) request.getAttribute("tiezi");
        username=tiezi[0];
        tieziTitle=tiezi[1];
        tieziContent=tiezi[2];
        tieziTime=tiezi[3];

    %>
    <title><%=tieziTitle%></title>
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
            &nbsp;<img height:="2.5%" width="1%" src="<c:url value="/index/image/index-home.jpg"/>"/>  &gt;&gt;  <a href="<c:url value="/index.jsp"/>">MyBBS</a>  &gt;&gt;
            <a href="<c:url value="/general/general.jsp" />">综合讨论</a>  &gt;&gt;  <%=tieziTitle%>
        </span>

    <%--帖子内容--%>
    <div style="background-color:#99d9ea;border:2px solid black;width:97.6%;position:absolute;top:24%;left:1%;">

        <%--帖子主要内容--%>
        <div style="width:50%;position: relative;left:20%;">
            <table style="border-collapse:   separate;   border-spacing:   25px;
            width: 100%;border: 2px solid black">
                <tr>
                    <td align="left"><%=username%></td>
                    <td><%=tieziContent%></td>
                </tr>
                <tr>
                    <td align="left"><%=tieziTime%></td>
                    <td align="right">1楼</td>
                </tr>
            </table>
        </div>

        <%--回帖 还没写 --%>
        <div style="position: relative;width:33.5%;bottom: 1%;left:25%">
            <br/>
            <span><b>发表回复:</b></span>
            <form action="<c:url value=""/> " method="post">
                <hr/>
                <%-- wrap="hard"代表文本内容带换行符--%>
            <textarea id="tieziReplyContent" name="tieziReplyContent" maxlength="500" wrap="hard" rows="15"
                      placeholder="请填写内容..."  style="height: 90%;width: 100%;" onkeyup="tieziReplyContentWarn1()"></textarea>

                <br/>
            <span id="tieziReplyContentWarn" hidden=true style="font-size: smaller;position: absolute;left:70%;">还可以输入
                <font id="tieziReplyContentCountWarn"  color="red" size="4" >-</font>个字</span>
                <br/>
                <input type="submit" value="发表" style="width:15%;height:30%;"/>
            </form>
        </div>

    </div>

</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/general/generalTiezi.js"></script>
</html>
