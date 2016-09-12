package regist;


import org.springframework.stereotype.Component;
import user.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Mayijun on 2016/9/7.
 */
public class RegistDAO {

    //增加和查询语句
    private String addSql="insert into user values(null,?,?)";
    private String findSql="select username from user where username=?";

    //返回值，1是有，-1是无;
    public int findByUsername(Connection connection,String username) throws SQLException {
        ResultSet resultSet=null;
        try( PreparedStatement preparedStatement= connection.prepareStatement(findSql);){
            preparedStatement.setString(1,username);
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                return 1;
            }
            return -1;

        }
        catch (Exception e){
            /*e.printStackTrace();
            return -1;*/
            throw new RuntimeException("注册DAO查询出错！");
        }
        finally{
            if(resultSet!=null){
                resultSet.close();
            }
        }

    }
    public void addUser(Connection connection,User user) throws SQLException {
       try(PreparedStatement preparedStatement= connection.prepareStatement(addSql);){
           preparedStatement.setString(1,user.getUsername());
           preparedStatement.setString(2,user.getPassword());
           preparedStatement.execute();
       }
        catch (Exception e){
            throw new RuntimeException("注册DAO插入出错！");
        }
    }
}
