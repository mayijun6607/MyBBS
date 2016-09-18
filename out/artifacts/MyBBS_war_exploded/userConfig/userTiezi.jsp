<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mayijun
  Date: 2016/9/18
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看主题帖</title>
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
            <input type="button" value="自己的主题帖" style="width:100%;height: 15%" disabled onclick="checkTiezi1()"/><br/><hr/>
        </div>
        <%--右边的显示框：查看主题帖--%>
        <div id="setPassword" style="border:2px solid black;position: absolute;left:30%;top:15%;width:50%;height:80%;">
            <%--查看主题帖标题--%>
            <br/>
            &nbsp;<span style="font-size: 150%"><b>查看主题帖</b><hr/></span>
                <%--页码选择--%>
                <div style="position: absolute;left:30%;top:3%;">
                    <form action="<c:url value="/UserTieziServlet"/> " method="get">
                        <input type="button" value="首页" onclick="firstPage()"/>
                        <input type="button" value="上一页" onclick="previousPage()"/>
                        <%
                            for(int t=1;t<=(Integer)request.getAttribute("totalPage");t++){
                        %>
                        <a href="${pageContext.request.contextPath}/UserTieziServlet?currentPage=<%=t%>"><%=t%></a>
                        <%
                            }
                        %>
                        <input type="button" value="下一页" onclick="nextPage()"/>
                        <input type="button" value="尾页" onclick="lastPage()"/>
                        当前页:<input type="text" value="<%=request.getAttribute("currentPage")%>" disabled size="1"/>
                        <input type="text" name="currentPage" size="1"/>/<%=request.getAttribute("totalPage")%>页
                        <input type="submit" value="go"/>
                    </form>
                </div>
                <%--Servlet传过来的数组--%>
                <%
                    int[] tieziId=new int[10];
                    String[] username=new String[10];
                    String[] title=new String[10];
                    String[] content=new String[10];
                    String[] time=new String[10];
                    //没剪切过的时间
                    // String[] realTime=new String[10];
                    for(int p=0;p<(Integer)request.getAttribute("pageSize");p++){
                        username[p]="";
                        title[p]="";
                        content[p]="";
                        time[p]="";
                        //realTime[p]="";
                    }
                    tieziId=(int[])request.getAttribute("tieziId");
                    username=(String[])request.getAttribute("tieziUsername");
                    title=(String[])request.getAttribute("tieziTitle");
                    content=(String[])request.getAttribute("tieziContent");
                    time=(String[])request.getAttribute("tieziTime");
                    int pageSize=(Integer)request.getAttribute("pageSize");
                %>
            <%--查看主题帖内容--%>
            <div  style="position:relative;left:12%;">

                <table style="border-collapse:   separate;   border-spacing:   12px;width: 100%; ">
                    <%
                        for(int k=pageSize-1;k>=0;k--){
                            if(tieziId[k]!=0){
                    %>
                    <tr>
                        <td><a href="${pageContext.request.contextPath}/GeneralKanTieServlet?tieziId=<%=tieziId[k]%>&tieziTime=<%=time[k]%>"
                                              style="font-size: medium"><%out.print(title[k]);%></a> </td>
                        <td><%=time[k].substring(0,16)%></td>
                    </tr>
                    <%
                            }
                        }
                    %>
                </table>

            </div>
        </div>

    </div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/userConfig/common.js"></script>
<script type="text/javascript">
    //首页
    function firstPage(){
        window.location.href="${pageContext.request.contextPath}/UserTieziServlet?currentPage=1";
    }
    //尾页
    function lastPage(){
        window.location.href="${pageContext.request.contextPath}/UserTieziServlet?currentPage="+
        <%=(Integer)request.getAttribute("totalPage")%>;
    }
    //上一页
    function previousPage(){
        window.location.href="${pageContext.request.contextPath}/UserTieziServlet?currentPage="+
        <%=(Integer)request.getAttribute("currentPage")-1%>;
    }
    //下一页
    function nextPage(){
        window.location.href="${pageContext.request.contextPath}/UserTieziServlet?currentPage="+
        <%=(Integer)request.getAttribute("currentPage")+1%>;
    }

</script>
</html>
