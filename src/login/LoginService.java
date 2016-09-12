package login;

import user.User;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Mayijun on 2016/9/8.
 */
public class LoginService {
    private LoginDAO loginDAO;

    public void setLoginDAO(LoginDAO loginDAO) {
        this.loginDAO = loginDAO;
    }

    //1成功，-1用户名错误，-2密码错误
    public int login(Connection connection, User user) throws SQLException {
        return loginDAO.check(connection,user);
    }
}
