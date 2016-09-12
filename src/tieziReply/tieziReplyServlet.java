package tieziReply;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.log.PackageNames;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import tiezi.ReplyTiezi;
import tiezi.Tiezi;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;

/**
 * Created by Mayijun on 2016/9/12.
 */
public class TieziReplyServlet extends HttpServlet {
    private TieziReplyService tieziReplyService;
    private ComboPooledDataSource comboPooledDataSource;
    private ReplyTiezi replyTiezi;

    public void setReplyTiezi(ReplyTiezi replyTiezi) {
        this.replyTiezi = replyTiezi;
    }

    public void setTieziReplyService(TieziReplyService tieziReplyService) {
        this.tieziReplyService = tieziReplyService;
    }

    public void setComboPooledDataSource(ComboPooledDataSource comboPooledDataSource) {
        this.comboPooledDataSource = comboPooledDataSource;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WebApplicationContext webApplicationContext= WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        tieziReplyService=webApplicationContext.getBean("tieziReplyService",TieziReplyService.class);
        comboPooledDataSource=webApplicationContext.getBean("dataSource",ComboPooledDataSource.class);
        replyTiezi=webApplicationContext.getBean("replyTiezi",ReplyTiezi.class);
        HttpSession session=request.getSession();


        if(request.getParameter("tieziId")!=null) {
            int tieziId = Integer.parseInt((String) request.getParameter("tieziId"));
            String tieziTime=(String)request.getParameter("tieziTime");
            //System.out.println(tieziId);
            String repleyUsername = (String) session.getAttribute("username");
            String replyContent = request.getParameter("tieziReplyContent");

            replyTiezi.setReplyUsername(repleyUsername);
            replyTiezi.setTieziId(tieziId);
            replyTiezi.setTieziReply(replyContent);
            try(Connection connection=comboPooledDataSource.getConnection()) {
                tieziReplyService.reply(connection,replyTiezi,tieziTime);
                request.setAttribute("tieziId",tieziId);
                request.getRequestDispatcher("/GeneralKanTieServlet").forward(request,response);
            }
            catch (Exception e){
                //e.printStackTrace();
                throw new RuntimeException("综合区回帖Servlet出错！");
            }
        }
        else {
            response.sendRedirect("");
        }


    }
}
