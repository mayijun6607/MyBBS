package main.Tiezi.generalKanTie;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import main.domain.page.ReplyPage;
import main.domain.tiezi.ReplyTiezi;
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
 * Created by Mayijun on 2016/9/12.
 */
public class GeneralKanTieServlet extends HttpServlet{
    private ComboPooledDataSource comboPooledDataSource;
    private GeneralKanTieService generalKanTieService;
    private ReplyPage replyPage;

    public void setReplyPage(ReplyPage replyPage) {
        this.replyPage = replyPage;
    }

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
        replyPage=webApplicationContext.getBean("replyPage",ReplyPage.class);
        HttpSession session=request.getSession();

        //得到返回的帖子ID和时间
        int tieziId=Integer.parseInt((String)request.getParameter("tieziId"));
        String tieziTime=(String)request.getParameter("tieziTime");
        //System.out.println(tieziId+"..."+tieziTime);

        try(Connection connection=comboPooledDataSource.getConnection()) {
            String[] tiezi=generalKanTieService.kanTie(connection,tieziId);
           /* Map<Integer,String[]> replyMap=generalKanTieService.displayReply(connection,tieziTime);*/

            if(tiezi[0]==null){
                //如果找不到，返回一个错误页面
                response.sendRedirect("/general/generalError.jsp");
            }
            else {
                //设置当前页，应该用getParameter获取
                if(request.getParameter("currentPage")!=null){
                    if(Integer.parseInt(request.getParameter("currentPage"))>0&&
                            Integer.parseInt(request.getParameter("currentPage"))<=replyPage.getTotalPage()) {
                        replyPage.setCurrentPage(Integer.parseInt(request.getParameter("currentPage")));
                    }
                    else {
                        replyPage.setCurrentPage(1);
                    }
                }
                else {
                    replyPage.setCurrentPage(1);
                }

                List<ReplyTiezi> reply=generalKanTieService.getReply(connection,replyPage,tieziTime);
                int totalRecord=generalKanTieService.getTotalRecord(connection,tieziTime);
                replyPage.setTotalRecord(totalRecord);

                String[] replyUsername=generalKanTieService.getReplyUsername(reply,replyPage);
                String[] replyContent=generalKanTieService.getReplyContent(reply,replyPage);
                String[] replyTime=generalKanTieService.getReplyTime(reply,replyPage);
                int[] floorId=generalKanTieService.getFloorId(reply,replyPage);

                request.setAttribute("replyUsername",replyUsername);
                request.setAttribute("replyContent",replyContent);
                request.setAttribute("replyTime",replyTime);
                request.setAttribute("floorId",floorId);

                request.setAttribute("totalPage",replyPage.getTotalPage());
                request.setAttribute("totalRecord",replyPage.getTotalRecord());
                request.setAttribute("pageSize",replyPage.getPageSize());
                request.setAttribute("currentPage",replyPage.getCurrentPage());

                request.setAttribute("tieziId",tieziId);
                request.setAttribute("tiezi",tiezi);
                //加入回复内容
                //request.setAttribute("replyMap",replyMap);
                request.getRequestDispatcher("/general/generalTiezi.jsp").forward(request,response);
            }
        }
        catch (Exception e){
            //e.printStackTrace();
            throw new RuntimeException("综合区看帖Servlet错误！");
        }
    }
}
