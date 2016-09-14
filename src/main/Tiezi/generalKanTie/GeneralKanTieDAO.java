package main.Tiezi.generalKanTie;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mayijun on 2016/9/12.
 */
public class GeneralKanTieDAO {
    private String findSql="select * from general_tiezi where tiezi_id=?";

    public String[] findTiezi(Connection connection,int tieziId) throws SQLException {
        ResultSet resultSet=null;
        try(PreparedStatement preparedStatement=connection.prepareStatement(findSql)){
            preparedStatement.setInt(1,tieziId);
            resultSet=preparedStatement.executeQuery();
            String[] tiezi=new String[4];
            if(resultSet.next()){
                tiezi[0]=resultSet.getString("username");
                tiezi[1]=resultSet.getString("tiezi_title");
                tiezi[2]=resultSet.getString("tiezi_content");
                tiezi[3]=resultSet.getString("tiezi_time");
            }
            return tiezi;
        }
        catch (Exception e){
            throw new RuntimeException("综合讨论区看帖DAO错误！");
        }
        finally {
            if(resultSet!=null){
                resultSet.close();
            }
        }
    }


    public Map<Integer,String[]> findReply(Connection connection, String tieziTime)throws SQLException{
        char[] timeArray=tieziTime.toCharArray();
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
        String replySql="select * from "+tablename.toString();
        ResultSet resultSet=null;
        try(PreparedStatement preparedStatement=connection.prepareStatement(replySql)){
            resultSet=preparedStatement.executeQuery();
            Map<Integer,String[]> replyMap=new HashMap<>();
            while(resultSet.next()){
                replyMap.put(resultSet.getInt("tiezi_floor"),new String[]{resultSet.getString("reply_username"),
                resultSet.getString("tiezi_reply"),resultSet.getString("reply_time")});
            }
            return replyMap;
        }
        catch (Exception e){
            throw new RuntimeException("综合区看回复DAO出错！");
        }
        finally {
            if(resultSet!=null){
                resultSet.close();
            }
        }
    }
}
