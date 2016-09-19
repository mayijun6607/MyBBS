package main.Tiezi.deleteReply;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;

/**
 * Created by Mayijun on 2016/9/19.
 */
public class DeleteReplyServlet extends HttpServlet {
    private ComboPooledDataSource comboPooledDataSource;
    private DeleteReplyService deleteReplyService;

    public void setDeleteReplyService(DeleteReplyService deleteReplyService) {
        this.deleteReplyService = deleteReplyService;
    }

    public void setComboPooledDataSource(ComboPooledDataSource comboPooledDataSource) {

        this.comboPooledDataSource = comboPooledDataSource;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WebApplicationContext webApplicationContext= WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        comboPooledDataSource=webApplicationContext.getBean("dataSource",ComboPooledDataSource.class);
        deleteReplyService=webApplicationContext.getBean("deleteReplyService",DeleteReplyService.class);
        HttpSession session=request.getSession();

        String tempTime=(String)request.getParameter("tempTime");
        String replyTime=(String)request.getParameter("replyTime");
        //int tieziId=Integer.parseInt((String)request.getParameter("tieziId"));

        //System.out.println(replyTime);

        try(Connection connection=comboPooledDataSource.getConnection()){
            deleteReplyService.deleteReply(connection,tempTime,replyTime);
            response.sendRedirect("/general/deleteOk.jsp");
        }
        catch (Exception e){
            throw new RuntimeException("删除回复Servlet出错！");
        }
    }
}
