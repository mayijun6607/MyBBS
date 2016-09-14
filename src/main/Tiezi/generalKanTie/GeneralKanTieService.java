package main.Tiezi.generalKanTie;

import main.domain.page.ReplyPage;
import main.domain.tiezi.ReplyTiezi;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by Mayijun on 2016/9/12.
 */
public class GeneralKanTieService {
    private GeneralKanTieDAO generalKanTieDAO;

    public void setGeneralKanTieDAO(GeneralKanTieDAO generalKanTieDAO) {
        this.generalKanTieDAO = generalKanTieDAO;
    }

    public String[] kanTie(Connection connection,int tieziId) throws SQLException {
        return generalKanTieDAO.findTiezi(connection,tieziId);
    }
    /*public Map<Integer,String[]> displayReply(Connection connection, String tieziTime) throws SQLException {
        return generalKanTieDAO.findReply(connection,tieziTime);
    }*/
    //回复总数
    public int getTotalRecord(Connection connection,String tieziTime) throws SQLException {
        return generalKanTieDAO.getTotalRecord(connection,tieziTime);
    }
    //回复内容
    public List<ReplyTiezi> getReply(Connection connection, ReplyPage replyPage,String tieziTime) throws SQLException {
        return generalKanTieDAO.getReply(connection,replyPage,tieziTime);
    }
    //得到回复用户名数组
    public String[] getReplyUsername(List<ReplyTiezi> reply,ReplyPage replyPage){
        String[] replyUsername=new String[replyPage.getPageSize()];
        int i=0;
        for(ReplyTiezi replyTemp:reply){
            if(i<=replyPage.getPageSize()) {
                replyUsername[i]=replyTemp.getReplyUsername();
                i++;
            }
            else{
                return replyUsername;
            }
        }
        return replyUsername;
    }
    //得到回复内容数组
    public String[] getReplyContent(List<ReplyTiezi> reply,ReplyPage replyPage){
        String[] replyContent=new String[replyPage.getPageSize()];
        int i=0;
        for(ReplyTiezi replyTemp:reply){
            if(i<=replyPage.getPageSize()){
                replyContent[i]=replyTemp.getTieziReply();
                i++;
            }
            else {
                return replyContent;
            }
        }
        return replyContent;
    }
    //得到回复时间数组
    public String[] getReplyTime(List<ReplyTiezi> reply,ReplyPage replyPage){
        String[] replyTime=new String[replyPage.getPageSize()];
        int i=0;
        for(ReplyTiezi replyTemp:reply){
            if(i<=replyPage.getPageSize()){
                replyTime[i]=replyTemp.getReplyTime();
                i++;
            }
            else {
                return replyTime;
            }
        }
        return replyTime;
    }
    //得到楼层数组
    public int[] getFloorId(List<ReplyTiezi> reply,ReplyPage replyPage){
        int[] floorId=new int[replyPage.getPageSize()];
        int i=0;
        for(ReplyTiezi replyTemp:reply){
            if(i<=replyPage.getPageSize()){
                floorId[i]=replyTemp.getFloorId();
                i++;
            }
            else {
                return floorId;
            }
        }
        return floorId;
    }
}
