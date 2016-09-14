package main.Tiezi.generalTiezi;

import main.domain.page.Page;
import main.domain.tiezi.Tiezi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Mayijun on 2016/9/11.
 */
public class GeneralTieziDAO {
   /* private String findSql="select * from general_tiezi";

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
    }*/

    //查询总记录数
    private String pageSql="select count(*) from general_tiezi";
    public int getTotalRecord(Connection connection) throws SQLException {
        ResultSet resultSet=null;
        try(PreparedStatement preparedStatement=connection.prepareStatement(pageSql)){
            int totalRecord=0;
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                totalRecord=resultSet.getInt("count(*)");
            }
            return totalRecord;
        }
        catch(Exception e){
            /*e.printStackTrace();
            return 0;*/
            throw new RuntimeException("查找帖子总数DAO出错!");
        }
        finally {
            if(resultSet!=null){
                resultSet.close();
            }
        }
    }

    //查询当前页记录
   //(page.getCurrentPage()-1)*page.getPageSize()+","+page.getPageSize();
    public List<Tiezi> getTiezi(Connection connection,Page page) throws SQLException {
        String tieziSql = "select * from general_tiezi limit " + (page.getCurrentPage() - 1) * page.getPageSize() + "," + page.getPageSize();
        ResultSet resultSet=null;
        List<Tiezi> tiezi=new ArrayList<>();
        try(PreparedStatement preparedStatement=connection.prepareStatement(tieziSql)){
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                tiezi.add(new Tiezi(resultSet.getString("username"),resultSet.getString("tiezi_title"),
                        resultSet.getString("tiezi_content"),resultSet.getString("tiezi_time"),resultSet.getInt("tiezi_id")));
            }
            return tiezi;

        }
        catch (Exception e){
            /*e.printStackTrace();
            return null;*/
            throw new RuntimeException("获取每页帖子内容DAO出错！");
        }
        finally {
            if(resultSet!=null){
                resultSet.close();
            }
        }
    }
}
