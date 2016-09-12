package publishTiezi;

import tiezi.Tiezi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Mayijun on 2016/9/11.
 */
public class PublishTieziDAO {
    private String addSql="insert into general_tiezi values(null,?,?,?,?,1)";

    public void addTiezi(Connection connection, Tiezi tiezi) throws SQLException {
        try(PreparedStatement preparedStatement=connection.prepareStatement(addSql)){
            //转换发帖时间
            Date date=new Date();
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String sqlTime=simpleDateFormat.format(date);

            preparedStatement.setString(1,tiezi.getUsername());
            preparedStatement.setString(2,tiezi.getTieziTitle());
            preparedStatement.setString(3,tiezi.getTieziContent());
            preparedStatement.setString(4,sqlTime);

            preparedStatement.execute();
        }
        catch (Exception e){
            throw new RuntimeException("发表综合讨论区帖子DAO出错!");
        }
    }
}
