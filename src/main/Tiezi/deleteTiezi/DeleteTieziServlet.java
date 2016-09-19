package main.Tiezi.deleteTiezi;

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
public class DeleteTieziServlet extends HttpServlet {
    private DeleteTieziService deleteTieziService;
    private ComboPooledDataSource comboPooledDataSource;

    public void setDeleteTieziService(DeleteTieziService deleteTieziService) {
        this.deleteTieziService = deleteTieziService;
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
        deleteTieziService=webApplicationContext.getBean("deleteTieziService",DeleteTieziService.class);
        HttpSession session=request.getSession();

        int deleteId=Integer.parseInt((String)request.getParameter("deleteId"));
        String tempTime=(String)request.getParameter("tempTime");
        //System.out.println(deleteId);
        try(Connection connection=comboPooledDataSource.getConnection()){
            deleteTieziService.deleteTiezi(connection,deleteId,tempTime);
            response.sendRedirect("/general/deleteOk.jsp");
        }
        catch (Exception e){
            //e.printStackTrace();
            throw new RuntimeException("删除帖子Servlet出错！");
        }
    }
}
