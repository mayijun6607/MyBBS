package loginFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Mayijun on 2016/9/11.
 */
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request=(HttpServletRequest)req;
        HttpSession session=request.getSession();
        HttpServletResponse response=(HttpServletResponse)resp;
        request.setAttribute("loginFilterWarn","请先登录!");
        if(session.getAttribute("username")==null){
            request.getRequestDispatcher("title/login/login.jsp").forward(request,response);
        }
        else {
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
