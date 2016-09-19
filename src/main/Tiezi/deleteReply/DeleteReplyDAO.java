package main.Tiezi.deleteReply;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Mayijun on 2016/9/19.
 */
public class DeleteReplyDAO {
    public void deleteReply(Connection connection,String tempTime,String replyTime) throws SQLException {
        char[] timeArray=tempTime.toCharArray();
        StringBuffer tablename=new StringBuffer();
        tablename.append("tiezi_");
        for(int i=0;i<timeArray.length;i++){
            if(timeArray[i]=='-'||timeArray[i]==' '||timeArray[i]==':'){
                continue;
            }
            else {
                tablename.append(timeArray[i]);
            }
        }
        String deleteSql="delete from "+tablename.toString()+" where reply_time=?";
        try(PreparedStatement preparedStatement=connection.prepareStatement(deleteSql)){
            preparedStatement.setString(1,replyTime);
            preparedStatement.execute();
        }
        catch (Exception e){
            throw new RuntimeException("删除回复DAO出错！");
        }
    }
}
