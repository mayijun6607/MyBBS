package mytest;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.ConnectionCustomizer;
import regist.RegistDAO;
import user.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Mayijun on 2016/9/7.
 */
public class RegistDAOTest {
    private User user=new User("张三","123");



    public int fun() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/mybbs?useServerPrepStmts=true";
        String user1="root";
        String pass="m65860966";
        Connection connection= DriverManager.getConnection(url,user1,pass);
        RegistDAO registDAO=new RegistDAO();
        return registDAO.findByUsername(connection,"mayijun");
    }
    public void fun2() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/mybbs?useServerPrepStmts=true";
        String user1="root";
        String pass="m65860966";
        Connection connection= DriverManager.getConnection(url,user1,pass);
        RegistDAO registDAO=new RegistDAO();
        registDAO.addUser(connection,user);
    }

    public static void main(String[] args)throws Exception {
       RegistDAOTest registDAOTest=new RegistDAOTest();
        System.out.println(registDAOTest.fun());
        registDAOTest.fun2();

    }
}
