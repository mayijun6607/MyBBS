package tieziReply;

import tiezi.ReplyTiezi;
import tiezi.Tiezi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Mayijun on 2016/9/12.
 */
public class TieziReplyDAO {


    public void reply(Connection connection, ReplyTiezi replyTiezi,String tieziTime) throws SQLException {
        //将发帖时间转换成表格名字
        char[] time=tieziTime.toCharArray();
        StringBuffer tablename=new StringBuffer();
        tablename.append("table_");
        for(int i=0;i<time.length;i++){
            if(time[i]=='-'||time[i]==' '||time[i]==':'){
                continue;
            }
            else {
                tablename.append(time[i]);
            }
        }
        //语句只能放方法里
         String addSql="insert into "+tablename.toString()+" values(null,?,?,?,?)";

        try(PreparedStatement preparedStatement=connection.prepareStatement(addSql)){
            //preparedStatement.setString(1,tablename.toString());
            preparedStatement.setString(1,replyTiezi.getReplyUsername());
            preparedStatement.setInt(2,replyTiezi.getTieziId());
            preparedStatement.setString(3,replyTiezi.getTieziReply());
            //转换回帖时间
            Date date=new Date();
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String sqlTime=simpleDateFormat.format(date);
            preparedStatement.setString(4,sqlTime);
            preparedStatement.execute();
        }
        catch (Exception e){
            throw new RuntimeException("综合区回帖DAO出错！");
        }
    }
}
