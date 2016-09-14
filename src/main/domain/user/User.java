package main.domain.user;

/**
 * Created by Mayijun on 2016/9/7.
 */
public class User {
    private String username;
    private String password;
    private String passwordOk;
    private String identify;

    public User(){

    }
    //测试用
    public User(String username,String password){
        this.username=username;
        this.password=password;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordOk() {
        return passwordOk;
    }

    public void setPasswordOk(String passwordOk) {
        this.passwordOk = passwordOk;
    }

    public String getIdentify() {
        return identify;
    }

    public void setIdentify(String identify) {
        this.identify = identify;
    }
}
