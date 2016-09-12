package publishTiezi;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import tiezi.Tiezi;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Mayijun on 2016/9/11.
 */
public class PublishTieziServlet extends HttpServlet {
    private ComboPooledDataSource comboPooledDataSource;
    private PublishTieziService publishTieziService;
    private Tiezi tiezi;

    public void setComboPooledDataSource(ComboPooledDataSource comboPooledDataSource) {
        this.comboPooledDataSource = comboPooledDataSource;
    }

    public void setPublishTieziService(PublishTieziService publishTieziService) {
        this.publishTieziService = publishTieziService;
    }

    public void setTiezi(Tiezi tiezi) {
        this.tiezi = tiezi;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WebApplicationContext webApplicationContext= WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        comboPooledDataSource=webApplicationContext.getBean("dataSource",ComboPooledDataSource.class);
        publishTieziService=webApplicationContext.getBean("publishTieziService", PublishTieziService.class);
        tiezi=webApplicationContext.getBean("tiezi",Tiezi.class);

        HttpSession session=request.getSession();

        tiezi.setUsername((String)session.getAttribute("username"));
        tiezi.setTieziTitle((String)request.getParameter("tieziTitle"));
        tiezi.setTieziContent((String)request.getParameter("tieziContent"));

        try(Connection connection=comboPooledDataSource.getConnection()){
            publishTieziService.publishTiezi(connection,tiezi);
            response.sendRedirect("general/general.jsp");
        }
        catch (SQLException e){
            throw new RuntimeException("发表综合讨论区帖子Servlet出错!");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
