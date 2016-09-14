package main.Tiezi.generalTiezi;

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
import java.sql.SQLException;
import java.util.Map;

/**
 * Created by Mayijun on 2016/9/11.
 */
public class GeneralTieziServlet extends HttpServlet {
    private GeneralTieziService generalTieziService;
    private ComboPooledDataSource comboPooledDataSource;

    public void setComboPooledDataSource(ComboPooledDataSource comboPooledDataSource) {
        this.comboPooledDataSource = comboPooledDataSource;
    }

    public void setGeneralTieziService(GeneralTieziService generalTieziService) {
        this.generalTieziService = generalTieziService;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WebApplicationContext webApplicationContext= WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        comboPooledDataSource=webApplicationContext.getBean("dataSource",ComboPooledDataSource.class);
        generalTieziService=webApplicationContext.getBean("generalTieziService",GeneralTieziService.class);
        HttpSession session=request.getSession();

        try(Connection connection=comboPooledDataSource.getConnection()){
            Map<Integer,String[]> idMap=generalTieziService.showTiezi(connection);
            request.setAttribute("idMap",idMap);
            request.getRequestDispatcher("general/general.jsp").forward(request,response);
        }
        catch (SQLException e) {
            throw new RuntimeException("显示帖子页面Servlet出错！");
        }

    }
}
