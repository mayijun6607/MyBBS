package main.userConfig.setPassword;

import main.domain.user.User;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Mayijun on 2016/9/16.
 */
public class SetPasswordService {
    private SetPasswordDAO setPasswordDAO;
    private String[] warnInfo={"","",""};

    public void setSetPasswordDAO(SetPasswordDAO setPasswordDAO) {
        this.setPasswordDAO = setPasswordDAO;
    }
    //验证密码格式
    public String[] check(User user){

        String password=user.getPassword();
        String passwordOk=user.getPasswordOk();

        if(password==null||"".equals(password.trim())){
            warnInfo[1]="密码不得为空!";
        }
        else if (password.contains(" ")) {
            warnInfo[1]="密码不得包含空格!";
        }
        else if(password.length()<6||password.length()>10){
            warnInfo[1]="密码长度应在6~10位!";
        }
        else{
            warnInfo[1]="";
        }

        if(warnInfo[1]!=""){
            warnInfo[2]="";
        }
        else if(!passwordOk.equals(password)){
            warnInfo[2]="密码再次输入错误!";
        }
        else {
            warnInfo[2]="";
        }
        return warnInfo;
    }
    //验证
    public String[] checkPassword(Connection connection, User user,String oldPassword) throws SQLException {
        if(setPasswordDAO.checkPassword(connection,user,oldPassword)==-1){
            warnInfo[0]="密码输入错误!";
            warnInfo[1]="";
            warnInfo[2]="";
            return warnInfo;
        }
        else{
            warnInfo=check(user);
            warnInfo[0]="";
            return warnInfo;
        }
    }
    //修改密码
    public void setPassword(Connection connection,User user) throws SQLException {
        setPasswordDAO.setPassword(connection,user);
    }
}
