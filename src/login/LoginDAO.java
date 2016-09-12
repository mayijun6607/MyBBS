package login;

import user.User;

import java.sql.*;

/**
 * Created by Mayijun on 2016/9/8.
 */
public class LoginDAO {
    private String checkSql="select password from user where username=?";

    //返回值 1是成功，-1是用户名错误，-2是密码错误
    public int check(Connection connection, User user) throws SQLException {
        ResultSet resultSet=null;
        try(PreparedStatement preparedStatement=connection.prepareStatement(checkSql)){
            preparedStatement.setString(1,user.getUsername());
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                if(resultSet.getString("password").equals(user.getPassword())){
                    return 1;
                }
                else {
                    return -2;
                }
            }
            return -1;
        }
        catch (Exception e){
            throw new RuntimeException("登录查询失败!");
        }
        finally {

            if(resultSet!=null){
                resultSet.close();
            }

        }
    }
}
