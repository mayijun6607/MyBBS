package generalKanTie;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import generalTiezi.GeneralTieziService;
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

/**
 * Created by Mayijun on 2016/9/12.
 */
public class GeneralKanTieServlet extends HttpServlet{
    private ComboPooledDataSource comboPooledDataSource;
    private GeneralKanTieService generalKanTieService;

    public void setComboPooledDataSource(ComboPooledDataSource comboPooledDataSource) {
        this.comboPooledDataSource = comboPooledDataSource;
    }

    public void setGeneralKanTieService(GeneralKanTieService generalKanTieService) {
        this.generalKanTieService = generalKanTieService;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WebApplicationContext webApplicationContext= WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        comboPooledDataSource=webApplicationContext.getBean("dataSource",ComboPooledDataSource.class);
        generalKanTieService=webApplicationContext.getBean("generalKanTieService", GeneralKanTieService.class);
        HttpSession session=request.getSession();

        int tieziId=Integer.parseInt((String)request.getParameter("tieziId"));
        //System.out.println(tieziId);
        try(Connection connection=comboPooledDataSource.getConnection()) {
            String[] tiezi=generalKanTieService.kanTie(connection,tieziId);
            if(tiezi[0]==null){
                //还没写，如果找不到，返回一个错误页面
                response.sendRedirect("/general/generalError.jsp");
            }
            else {
                request.setAttribute("tiezi",tiezi);
                request.getRequestDispatcher("general/generalTiezi.jsp").forward(request,response);
            }
        }
        catch (SQLException e){
            throw new RuntimeException("综合区看帖Servlet错误！");
        }
    }
}