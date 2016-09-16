package main.userConfig.setPassword;

import main.domain.user.User;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Mayijun on 2016/9/16.
 */
public class SetPasswordDAO {
    private String findSql="select password from user where username=?";

    //1是旧密码正确，-1是旧密码错误
    public int checkPassword(Connection connection,User user,String oldPassword) throws SQLException {
        ResultSet resultSet=null;
        try(PreparedStatement preparedStatement=connection.prepareStatement(findSql)){
            preparedStatement.setString(1,user.getUsername());
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                if(resultSet.getString("password").equals(oldPassword)){
                    //System.out.println(resultSet.getString("password").equals(oldPassword));
                    return  1;
                }
            }
            return -1;
        }
        catch(Exception e){
            /*e.printStackTrace();
            return -1;*/
            throw new RuntimeException("修改密码查询DAO出错!");
        }
        finally {
            if(resultSet!=null){
                resultSet.close();
            }
        }
    }

    private String setSql="update user set password=? where username=?";

    public void setPassword(Connection connection,User user) throws SQLException {
        try(PreparedStatement preparedStatement=connection.prepareStatement(setSql)){
            preparedStatement.setString(1,user.getPassword());
            preparedStatement.setString(2,user.getUsername());
            preparedStatement.execute();
        }
        catch(Exception e){
            throw new RuntimeException("修改密码修改DAO出错！");
        }
    }
}
