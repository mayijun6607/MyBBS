package main.myRegist.regist;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import main.domain.user.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Mayijun on 2016/9/7.
 */
public class RegistServlet extends HttpServlet {
    private RegistService registService;
    private ComboPooledDataSource comboPooledDataSource;
    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    public void setComboPooledDataSource(ComboPooledDataSource comboPooledDataSource) {
        this.comboPooledDataSource = comboPooledDataSource;
    }

    public void setRegistService(RegistService registService) {
        this.registService = registService;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        WebApplicationContext webApplicationContext=WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        comboPooledDataSource=webApplicationContext.getBean("dataSource",ComboPooledDataSource.class);
        registService=webApplicationContext.getBean("registService",RegistService.class);
        user=webApplicationContext.getBean("user",User.class);

        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String passwordOk=request.getParameter("passwordOk");
        String identify=request.getParameter("identify");

        user.setUsername(username);
        user.setPassword(password);
        user.setPasswordOk(passwordOk);
        user.setIdentify(identify);

        HttpSession session=request.getSession();

        try(Connection connection=comboPooledDataSource.getConnection()){
            String codeString=(String)session.getAttribute("codeString");
            //验证用户信息格式，没问题就检测用户名是否重复
            String[] warnInfo=registService.validateInfo(user,codeString);

            if("".equals(warnInfo[0])&&"".equals(warnInfo[1])&&"".equals(warnInfo[2])&&"".equals(warnInfo[3])){
                int statusCount=registService.regist(connection,user);
                if(statusCount==-1){
                    request.setAttribute("warnInfo","用户名重复!");
                    request.getRequestDispatcher("title/regist/regist.jsp").forward(request,response);
                }
                else if( statusCount==1){
                    response.sendRedirect("title/regist/registOk.jsp");
                }
                else {
                    request.setAttribute("warnInfo","未知错误!");
                    request.getRequestDispatcher("title/regist/regist.jsp").forward(request,response);
                }
            }
            else{
                if("".equals(warnInfo[0])){
                    session.setAttribute("registUsername",username);
                }
                else{
                    request.setAttribute("warnInfo1",warnInfo[0]);
                }
                request.setAttribute("warnInfo2",warnInfo[1]);
                request.setAttribute("warnInfo3",warnInfo[2]);
                request.setAttribute("warnInfo4",warnInfo[3]);
                request.getRequestDispatcher("title/regist/regist.jsp").forward(request,response);
            }





        }
        catch (SQLException e){
            //e.printStackTrace();
            throw new RuntimeException("连接池给予连接失败！");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
