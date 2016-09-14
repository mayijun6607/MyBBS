package main.myRegist.regist;


import main.domain.user.User;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Mayijun on 2016/9/7.
 */
public class RegistService {
    private RegistDAO registDAO;
    private String[] warnInfo={"","","",""};

    public void setRegistDAO(RegistDAO registDAO) {
        this.registDAO = registDAO;
    }

    //验证USER 信息格式
    public String[] validateInfo(User user,String codeString){
        String username=user.getUsername();
        String password=user.getPassword();
        String passwordOk=user.getPasswordOk();
        String identify=user.getIdentify();

        if(username==null||"".equals(username.trim())){
            warnInfo[0]="用户名不得为空!";
        }
        else if(username.contains(" ")){
            warnInfo[0]="用户名不得包含空格!";
        }
        else if(username.length()<2||username.length()>6){
            warnInfo[0]="用户名长度应在2~6位!";
        }

        if(password==null||"".equals(password.trim())){
            warnInfo[1]="密码不得为空!";
        }
        else if (password.contains(" ")) {
            warnInfo[1]="密码不得包含空格!";
        }
        else if(password.length()<6||password.length()>10){
            warnInfo[1]="密码长度应在6~10位!";
        }

        if(warnInfo[1]!=""){
            warnInfo[2]="";
        }
        else if(!passwordOk.equals(password)){
            warnInfo[2]="密码再次输入错误!";
        }

        if(!codeString.equals(identify.toUpperCase())){
            warnInfo[3]="验证码错误!";
        }

        return warnInfo;
    }

    //返回值1是成功，-1是用户名重复,0是其余错误
    public int regist(Connection connection, User user) throws SQLException {
        if(registDAO.findByUsername(connection,user.getUsername())==-1){
            registDAO.addUser(connection,user);
            return 1;
        }
        else if(registDAO.findByUsername(connection,user.getUsername())==1){
            return -1;
        }
        return 0;
    }
}
