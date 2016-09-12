package mytest;

import verifycode.VerifyCode;

import java.io.IOException;

/**
 * Created by Mayijun on 2016/9/8.
 */
public class VerifyCodeTest {
    public static void main(String[] args) throws IOException {
        VerifyCode verifyCode=new VerifyCode();
        verifyCode.getVerifyCode("a.jpg");
    }
}
