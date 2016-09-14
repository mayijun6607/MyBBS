package main.myRegist.regist;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import main.myRegist.verifycode.VerifyCode;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Mayijun on 2016/9/8.
 */
public class VerifyCodeServlet extends HttpServlet {
    private VerifyCode verifyCode;

    public void setVerifyCode(VerifyCode verifyCode) {
        this.verifyCode = verifyCode;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WebApplicationContext webApplicationContext= WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        verifyCode=webApplicationContext.getBean("verifyCode", main.myRegist.verifycode.VerifyCode.class);

        HttpSession session=request.getSession();
        BufferedImage codeImage=verifyCode.getVerifyCode(session.getId());
        String codeString=verifyCode.getCodeString();
        session.setAttribute("codeString",codeString);
        VerifyCode.output(codeImage,response.getOutputStream());
        //System.out.println(codeString);
    }
}
