package main.userConfig.setPassword;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import main.domain.user.User;
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
 * Created by Mayijun on 2016/9/16.
 */
public class SetPasswordServlet extends HttpServlet {
    private ComboPooledDataSource comboPooledDataSource;
    private SetPasswordService setPasswordService;
    private User user;

    public void setComboPooledDataSource(ComboPooledDataSource comboPooledDataSource) {
        this.comboPooledDataSource = comboPooledDataSource;
    }

    public void setSetPasswordService(SetPasswordService setPasswordService) {
        this.setPasswordService = setPasswordService;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WebApplicationContext webApplicationContext= WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        comboPooledDataSource=webApplicationContext.getBean("dataSource",ComboPooledDataSource.class);
        setPasswordService=webApplicationContext.getBean("setPasswordService",SetPasswordService.class);
        user=webApplicationContext.getBean("user",User.class);
        HttpSession session=request.getSession();

        user.setUsername((String)session.getAttribute("username"));
        //System.out.println((String)session.getAttribute("username"));
        user.setPassword((String)request.getParameter("newPassword"));
        user.setPasswordOk((String)request.getParameter("newPasswordOk"));
       // System.out.println((String)request.getParameter("newPassword")+"..."+(String)request.getParameter("newPasswordOk")
        //+"..."+request.getParameter("oldPassword"));
        String oldPassword=request.getParameter("oldPassword");
        String[] warnInfo=null;

        try(Connection connection=comboPooledDataSource.getConnection()){
            warnInfo=setPasswordService.checkPassword(connection,user,oldPassword);
            if("".equals(warnInfo[0])&&"".equals(warnInfo[1])&&"".equals(warnInfo[2])){
                setPasswordService.setPassword(connection,user);
                //成功了切换界面 修改成功！并清空session username
                session.setAttribute("username",null);
                response.sendRedirect("/userConfig/setPasswordSuccess.jsp");
            }
            else{
                request.setAttribute("oldPasswordWarn",warnInfo[0]);
                request.setAttribute("newPasswordWarn",warnInfo[1]);
                request.setAttribute("newPasswordOkWarn",warnInfo[2]);
                request.getRequestDispatcher("/userConfig/setPassword.jsp").forward(request,response);
            }
        }
        catch (Exception e){
            //e.printStackTrace();
            throw new RuntimeException("修改密码Servlet出错！");
        }
    }
}
