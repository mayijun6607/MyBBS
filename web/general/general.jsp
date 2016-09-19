<%@ page import="java.util.Map" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mayijun
  Date: 2016/9/9
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>综合讨论</title>
</head>
<body>
    <%--顶部锚点--%>
    <a name="top" id="top"></a>
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

    <%--综合讨论正式内容--%>
    <div style="background-color:#99d9ea;border:2px solid black;width:97.6%;position:absolute;top:24%;left:1%;">

    <%--综合讨论标题和页码选择--%>
    <span ><img  src="<c:url value="/general/image/general-title.jpg"/> "/> <hr/></span>
    <div style="position: absolute;left:50%;top:3%;">
        <form action="<c:url value="/GeneralTieziServlet"/> " method="get">
            <input type="button" value="首页" onclick="firstPage()"/>
            <input type="button" value="上一页" onclick="previousPage()"/>
            <%
                for(int t=1;t<=(Integer)request.getAttribute("totalPage");t++){
            %>
            <a href="${pageContext.request.contextPath}/GeneralTieziServlet?currentPage=<%=t%>"><%=t%></a>
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

    <%--Servlet传过来的Map的处理  放数组里，再分发下去--%>
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

        /*String[] temp={"","","",""};*/
      /*  Map<Integer, String[]> idMap = (Map<Integer,String[]>)request.getAttribute("idMap");
        int i=0;
            for (Map.Entry<Integer, String[]> entry : idMap.entrySet()) {
               for(int j=0;j<4;j++){
                   temp[j]=entry.getValue()[j];
               }
                if(i<10) {
                    tieziId[i]=entry.getKey();
                    username[i] = temp[0];
                    title[i] = temp[1];
                    content[i] = temp[2];
                    realTime[i]=temp[3];
                    time[i] = realTime[i].substring(0,16);
                    i++;
                }
                else{
                    break;
                }
            }*/
    %>

    <%--帖子标题预览 一页20条 做成表格，标题 、发帖人、发帖时间 --%>
    <div style="border:2px dashed black;width:70%;position:relative;bottom:10%;left:10%;">

        <table style="border-collapse:   separate;   border-spacing:   25px;width: 100%; ">
            <%
                for(int k=pageSize-1;k>=0;k--){
                    if(tieziId[k]!=0){
            %>
            <tr>
                <%--<td>&nbsp;&nbsp;</td>--%>
                <td align="center"><a href="${pageContext.request.contextPath}/GeneralKanTieServlet?tieziId=<%=tieziId[k]%>&tieziTime=<%=time[k]%>"
                                     style="font-size: x-large"><%out.print(title[k]);%></a> </td>
                <%--<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>--%>
                <td align="right"><%out.print(username[k]); %></td>
                <td><%=time[k].substring(0,16)%></td>
                <%
                    if(username[k].equals((String)session.getAttribute("username"))){
                        if(((String)session.getAttribute("username")).length()<7){
                %>
                <td>
                    <form action="/DeleteTieziServlet" method="post">
                        <input type="text" hidden name="tempTime" value="<%=time[k]%>"/>
                        <input type="text" hidden name="deleteId" value="<%=tieziId[k]%>"/>
                        <input type="submit" value="删除帖子"/>
                    </form>
                </td>
                <%}}%>
            </tr>
            <%
                    }
                }
            %>
        </table>

    </div>

    <%--发表主题  --%>
    <div style="position: relative;width:33.5%;bottom: 1%;left:25%">
        <br/>
        <span><b>发表主题:</b></span>

        <span id="tieziTitleWarn" hidden=true style="font-size: smaller;position: absolute;left:70%;">还可以输入
            <font id="tieziTitleCountWarn"  color="red" size="4" >-</font>个字</span>

        <form action="<c:url value="/PublishTieziServlet"/> " method="post">
            <input type="text" id="tieziTitle" name="tieziTitle" placeholder="请填写标题"
                   maxlength="30" size="70" style="height:100%;width:100%;" onkeyup="tieziTitleWarn1()"/>
            <hr/>
             <%-- wrap="hard"代表文本内容带换行符--%>
            <textarea id="tieziContent" name="tieziContent" maxlength="500" wrap="hard" rows="15"
                 placeholder="请填写内容..."  style="height: 90%;width: 100%;" onkeyup="tieziContentWarn1()"></textarea>

            <br/>
            <span id="tieziContentWarn" hidden=true style="font-size: smaller;position: absolute;left:70%;">还可以输入
                <font id="tieziContentCountWarn"  color="red" size="4" >-</font>个字</span>
            <br/>
            <input type="submit" value="发表" style="width:15%;height:30%;"/>
        </form>
    </div>

        <%--回到顶部--%>
        <div style="border:2px solid black;position:absolute;bottom:2%;left:90%;">
            <a href="#top" >
                <img id="returnTop" src="<c:url value="/general/image/return-top.jpg"/> " onmousemove="returnTop1()" onmouseout="returnTop2()"/>
            </a>
        </div>
    </div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/general/general.js"></script>
<script type="text/javascript">
    //首页
    function firstPage(){
        window.location.href="${pageContext.request.contextPath}/GeneralTieziServlet?currentPage=1";
    }
    //尾页
    function lastPage(){
        window.location.href="${pageContext.request.contextPath}/GeneralTieziServlet?currentPage="+
        <%=(Integer)request.getAttribute("totalPage")%>;
    }
    //上一页
    function previousPage(){
        window.location.href="${pageContext.request.contextPath}/GeneralTieziServlet?currentPage="+
                <%=(Integer)request.getAttribute("currentPage")-1%>;
    }
    //下一页
    function nextPage(){
        window.location.href="${pageContext.request.contextPath}/GeneralTieziServlet?currentPage="+
        <%=(Integer)request.getAttribute("currentPage")+1%>;
    }

    //返回顶部变色
    var returnTop=document.getElementById("returnTop");
    function returnTop1(){
        returnTop.src="${pageContext.request.contextPath}/general/image/focusReturn-top.jpg";
    }
    function returnTop2(){
        returnTop.src="${pageContext.request.contextPath}/general/image/return-top.jpg";
    }
</script>
</html>
