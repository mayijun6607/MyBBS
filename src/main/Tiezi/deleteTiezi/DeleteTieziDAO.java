package main.Tiezi.deleteTiezi;

import sun.reflect.annotation.ExceptionProxy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Mayijun on 2016/9/19.
 */
public class DeleteTieziDAO {
    //删记录
    private String deleteSql="delete from general_tiezi where tiezi_id=?";

    public void deleteTiezi(Connection connection,int deleteId) throws SQLException {
        try(PreparedStatement preparedStatement=connection.prepareStatement(deleteSql)){
            preparedStatement.setInt(1,deleteId);
            preparedStatement.execute();
        }
        catch (Exception e){
            //e.printStackTrace();
            throw new RuntimeException("删除帖子记录DAO出错！");
        }
    }

    //删表
    public void deleteTable(Connection connection,String tempTime) throws SQLException {
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
        String deleteTableSql="drop table "+tablename.toString();

        try(PreparedStatement preparedStatement=connection.prepareStatement(deleteTableSql)){
            preparedStatement.execute();
        }
        catch (Exception e){
            throw new RuntimeException("删除帖子表DAO出错！");
        }

    }
}
