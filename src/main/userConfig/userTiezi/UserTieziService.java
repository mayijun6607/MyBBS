package main.userConfig.userTiezi;

import main.domain.page.Page;
import main.domain.tiezi.Tiezi;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Mayijun on 2016/9/18.
 */
public class UserTieziService {
    private UserTieziDAO userTieziDAO;

    public void setUserTieziDAO(UserTieziDAO userTieziDAO) {
        this.userTieziDAO = userTieziDAO;
    }

    public int getTotalRecord(Connection connection,String username) throws SQLException {
        return userTieziDAO.getCount(connection,username);
    }
    public List<Tiezi> getTiezi(Connection connection,String username,Page page) throws SQLException {
        return userTieziDAO.getTiezi(connection,username,page);

    }
    //帖子标题
    public String[] getTieziTitle(List<Tiezi> userTiezi,Page page){
        String[] tieziTitle=new String[page.getPageSize()];
        int i=0;
        for(Tiezi tieziTemp:userTiezi){
            if(i<=page.getPageSize()) {
                tieziTitle[i]=tieziTemp.getTieziTitle();
                i++;
            }
            else{
                return tieziTitle;
            }
        }
        return tieziTitle;
    }
    //得到username
    public String[] getTieziUsername(List<Tiezi> userTiezi,Page page){
        String[] tieziUsername=new String[page.getPageSize()];
        int i=0;
        for(Tiezi tieziTemp:userTiezi){
            if(i<=page.getPageSize()) {
                tieziUsername[i]=tieziTemp.getUsername();
                i++;
            }
            else{
                return tieziUsername;
            }
        }
        return tieziUsername;
    }
    //得到content
    public String[] getTieziContent(List<Tiezi> userTiezi,Page page){
        String[] tieziContent=new String[page.getPageSize()];
        int i=0;
        for(Tiezi tieziTemp:userTiezi){
            if(i<=page.getPageSize()) {
                tieziContent[i]=tieziTemp.getTieziContent();
                i++;
            }
            else{
                return tieziContent;
            }
        }
        return tieziContent;
    }
    //得到id
    public int[] getTieziId(List<Tiezi> userTiezi,Page page){
        int[] tieziId=new int[page.getPageSize()];
        int i=0;
        for(Tiezi tieziTemp:userTiezi){
            if(i<=page.getPageSize()) {
                tieziId[i]=tieziTemp.getTieziId();
                i++;
            }
            else{
                return tieziId;
            }
        }
        return tieziId;
    }
    //得到时间
    public String[] getTieziTime(List<Tiezi> userTiezi,Page page){
        String[] tieziTime=new String[page.getPageSize()];
        int i=0;
        for(Tiezi tieziTemp:userTiezi){
            if(i<=page.getPageSize()) {
                tieziTime[i]=tieziTemp.getTieziDatetime();
                i++;
            }
            else{
                return tieziTime;
            }
        }
        return tieziTime;
    }
}
