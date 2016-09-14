package main.Tiezi.generalTiezi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mayijun on 2016/9/11.
 */
public class GeneralTieziDAO {
    private String findSql="select * from general_tiezi";

    public Map<Integer,String[]> findTiezi(Connection connection) throws SQLException {
        ResultSet resultSet=null;
        try(PreparedStatement preparedStatement=connection.prepareStatement(findSql)){
            resultSet=preparedStatement.executeQuery();
            //用集合装返回结果,集合嵌套集合，外圈集合tiezi_id , 帖子内容map
            Map<Integer,String[]> idMap=new HashMap<>();
            while(resultSet.next()){
                idMap.put(resultSet.getInt("tiezi_id"),new String[]{resultSet.getString("username"),resultSet.getString("tiezi_title"),
                    resultSet.getString("tiezi_content"),resultSet.getString("tiezi_time")});
            }
            //System.out.println(idMap.get(1)[3]);
            return idMap;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
            //throw new RuntimeException("综合讨论区显示帖子DAO错误!");
        }
        finally {
            if(resultSet!=null){
                resultSet.close();
            }
        }
    }
}
