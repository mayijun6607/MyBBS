package main.Tiezi.generalTiezi;

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
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by Mayijun on 2016/9/11.
 */
public class GeneralTieziServlet extends HttpServlet {
    private GeneralTieziService generalTieziService;
    private ComboPooledDataSource comboPooledDataSource;
    private Page page;

    public void setPage(Page page) {
        this.page = page;
    }

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
        page=webApplicationContext.getBean("page",Page.class);
        HttpSession session=request.getSession();

        try(Connection connection=comboPooledDataSource.getConnection()){
            /*Map<Integer,String[]> idMap=generalTieziService.showTiezi(connection);
            request.setAttribute("idMap",idMap);*/
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
            page.setTotalRecord(generalTieziService.getTotalRecord(connection));
            List<Tiezi> tiezi=generalTieziService.getTiezi(connection,page);

            //System.out.println(page.getTotalPage());

            request.setAttribute("tieziTitle",generalTieziService.getTieziTitle(tiezi,page));
            request.setAttribute("tieziUsername",generalTieziService.getTieziUsername(tiezi,page));
            request.setAttribute("tieziContent",generalTieziService.getTieziContent(tiezi,page));
            request.setAttribute("tieziId",generalTieziService.getTieziId(tiezi,page));
            request.setAttribute("tieziTime",generalTieziService.getTieziTime(tiezi,page));

            request.setAttribute("pageSize",page.getPageSize());
            request.setAttribute("totalPage",page.getTotalPage());
            request.setAttribute("currentPage",page.getCurrentPage());
            //System.out.println(page.getTotalPage()+"..."+page.getTotalRecord()+"..."+page.getPageSize());
            //System.out.println(page.getTotalPage());

            request.getRequestDispatcher("general/general.jsp").forward(request,response);
        }
        catch (SQLException e) {
            throw new RuntimeException("显示帖子页面Servlet出错！");
        }

    }
}
