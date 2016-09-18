package main.userConfig.userTiezi;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import main.domain.page.Page;
import main.domain.tiezi.Tiezi;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

/**
 * Created by Mayijun on 2016/9/18.
 */
public class UserTieziServlet extends HttpServlet {
    private ComboPooledDataSource comboPooledDataSource;
    private UserTieziService userTieziService;
    private Page page;

    public void setPage(Page page) {
        this.page = page;
    }

    public void setComboPooledDataSource(ComboPooledDataSource comboPooledDataSource) {
        this.comboPooledDataSource = comboPooledDataSource;
    }

    public void setUserTieziService(UserTieziService userTieziService) {
        this.userTieziService = userTieziService;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WebApplicationContext webApplicationContext= WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        comboPooledDataSource=webApplicationContext.getBean("dataSource",ComboPooledDataSource.class);
        userTieziService=webApplicationContext.getBean("userTieziService",UserTieziService.class);
        page=webApplicationContext.getBean("page",Page.class);
        HttpSession session=request.getSession();

        try(Connection connection=comboPooledDataSource.getConnection()){
            //设置当前页，应该用getParameter获取
            if(request.getParameter("currentPage")!=null){
                if(Integer.parseInt(request.getParameter("currentPage"))>0&&
                        Integer.parseInt(request.getParameter("currentPage"))<=page.getTotalPage()) {
                    page.setCurrentPage(Integer.parseInt(request.getParameter("currentPage")));
                }
                else {
                    page.setCurrentPage(1);
                }
            }
            else {
                page.setCurrentPage(1);
            }

            String username=(String)session.getAttribute("username");
            page.setTotalRecord(userTieziService.getTotalRecord(connection,username));
            List<Tiezi> userTiezi=userTieziService.getTiezi(connection,username,page);

            request.setAttribute("tieziTitle",userTieziService.getTieziTitle(userTiezi,page));
            request.setAttribute("tieziUsername",userTieziService.getTieziUsername(userTiezi,page));
            request.setAttribute("tieziContent",userTieziService.getTieziContent(userTiezi,page));
            request.setAttribute("tieziId",userTieziService.getTieziId(userTiezi,page));
            request.setAttribute("tieziTime",userTieziService.getTieziTime(userTiezi,page));

            request.setAttribute("pageSize",page.getPageSize());
            request.setAttribute("totalPage",page.getTotalPage());
            request.setAttribute("currentPage",page.getCurrentPage());

            request.getRequestDispatcher("/userConfig/userTiezi.jsp").forward(request,response);
        }
        catch (Exception e){
            throw new RuntimeException("查看主题帖Servlet出错！");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
