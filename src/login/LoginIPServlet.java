package login;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Mayijun on 2016/9/11.
 */
public class LoginIPServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();

        String userIP = request.getRemoteAddr();
        //System.out.println(userIP);
        String[] userIPTemp = userIP.split("[.]");
        String userIPLater = userIPTemp[0] + "." + userIPTemp[1] + "." + userIPTemp[2] + ".*";
        //System.out.println(userIPLater);
        session.setAttribute("username", userIPLater);
        response.sendRedirect("index.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
