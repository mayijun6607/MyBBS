package main.userConfig.userTiezi;

import main.domain.page.Page;
import main.domain.tiezi.Tiezi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mayijun on 2016/9/18.
 */
public class UserTieziDAO {
    //查找主题帖总数
    private String countSql="select count(*) from general_tiezi where username=?";

    public int getCount(Connection connection,String username) throws SQLException {
        ResultSet resultSet=null;
        try(PreparedStatement preparedStatement=connection.prepareStatement(countSql)){
            preparedStatement.setString(1,username);
            resultSet=preparedStatement.executeQuery();
            int totalRecord=0;
            if(resultSet.next()){
                totalRecord=resultSet.getInt("count(*)");
            }
            return totalRecord;
        }
        catch(Exception e){
            throw new RuntimeException("查看主题帖总数DAO出错！");
        }
        finally {
            if(resultSet!=null){
                resultSet.close();
            }
        }
    }


    //查找主题帖内容
    public List<Tiezi> getTiezi(Connection connection, String username,Page page) throws SQLException {
        //倒序看帖算法
        int limitRight=0;
        int limitLeft=page.getTotalRecord()-(page.getCurrentPage()*10-1)-1;
        if(page.getCurrentPage()!=page.getTotalPage()){
            limitRight=page.getPageSize();
        }
        else{
            limitLeft=0;
            limitRight=page.getTotalRecord()-(page.getCurrentPage()-1)*10;
        }
        String findSql="select * from general_tiezi where username=? limit "+limitLeft+","+limitRight;

        ResultSet resultSet=null;
        List<Tiezi> userTiezi=new ArrayList<>();
        try(PreparedStatement preparedStatement=connection.prepareStatement(findSql)){
            preparedStatement.setString(1,username);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                userTiezi.add(new Tiezi(username,resultSet.getString("tiezi_title"),resultSet.getString("tiezi_content")
                ,resultSet.getString("tiezi_time"),resultSet.getInt("tiezi_id"),resultSet.getInt("area_id")));
            }
            return userTiezi;
        }
        catch (Exception e){
            throw new RuntimeException("查看主题帖内容DAO出错!");
        }
        finally{
            if(resultSet!=null){
                resultSet.close();
            }
        }
    }

}
