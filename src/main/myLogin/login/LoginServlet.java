package main.myLogin.login;

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
 * Created by Mayijun on 2016/9/8.
 */
public class LoginServlet extends HttpServlet {
    private LoginService loginService;
    private ComboPooledDataSource comboPooledDataSource;
    private User user;

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    public void setComboPooledDataSource(ComboPooledDataSource comboPooledDataSource) {
        this.comboPooledDataSource = comboPooledDataSource;
    }

    public void setUser(User user) {
        this.user = user;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        WebApplicationContext webApplicationContext= WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        comboPooledDataSource=webApplicationContext.getBean("dataSource",ComboPooledDataSource.class);
        loginService=webApplicationContext.getBean("loginService", main.myLogin.login.LoginService.class);
        user=webApplicationContext.getBean("user",User.class);

        HttpSession session=request.getSession();

        String username=request.getParameter("username");
        String password=request.getParameter("password");

        user.setUsername(username);
        user.setPassword(password);

        //session里loginUsername用来放密码错误时正确的用户名，username用来放登录成功的用户名
        try(Connection connection=comboPooledDataSource.getConnection()){
            int status=loginService.login(connection,user);
            if(status==-1){
                request.setAttribute("loginUsernameWarn","用户名错误!");
                session.setAttribute("loginUsername","");
                request.getRequestDispatcher("title/login/login.jsp").forward(request,response);
            }
            else if(status==-2){
                request.setAttribute("loginPasswordWarn","密码错误!");
                session.setAttribute("loginUsername",user.getUsername());
                request.getRequestDispatcher("title/login/login.jsp").forward(request,response);
            }
            else{
                session.setAttribute("username",user.getUsername());
                response.sendRedirect("/index.jsp");
            }
        }
        catch (SQLException e){
            throw new RuntimeException("登陆时连接池给予失败!");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
