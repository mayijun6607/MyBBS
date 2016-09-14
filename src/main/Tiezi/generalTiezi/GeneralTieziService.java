package main.Tiezi.generalTiezi;

import main.domain.page.Page;
import main.domain.tiezi.Tiezi;

import javax.swing.text.html.HTMLDocument;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by Mayijun on 2016/9/11.
 */
public class GeneralTieziService {
    private GeneralTieziDAO generalTieziDAO;

    public void setGeneralTieziDAO(GeneralTieziDAO generalTieziDAO) {
        this.generalTieziDAO = generalTieziDAO;
    }

   /* public Map<Integer,String[]> showTiezi(Connection connection) throws SQLException {
        return generalTieziDAO.findTiezi(connection);

    }*/
    public int getTotalRecord(Connection connection) throws SQLException {
        return generalTieziDAO.getTotalRecord(connection);
    }
    public List<Tiezi> getTiezi(Connection connection, Page page) throws SQLException {
        return generalTieziDAO.getTiezi(connection,page);
    }
    //得到title
    public String[] getTieziTitle(List<Tiezi> tiezi,Page page){
        String[] tieziTitle=new String[page.getPageSize()];
        int i=0;
        for(Tiezi tieziTemp:tiezi){
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
    public String[] getTieziUsername(List<Tiezi> tiezi,Page page){
        String[] tieziUsername=new String[page.getPageSize()];
        int i=0;
        for(Tiezi tieziTemp:tiezi){
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
    public String[] getTieziContent(List<Tiezi> tiezi,Page page){
        String[] tieziContent=new String[page.getPageSize()];
        int i=0;
        for(Tiezi tieziTemp:tiezi){
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
    public int[] getTieziId(List<Tiezi> tiezi,Page page){
        int[] tieziId=new int[page.getPageSize()];
        int i=0;
        for(Tiezi tieziTemp:tiezi){
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
    public String[] getTieziTime(List<Tiezi> tiezi,Page page){
        String[] tieziTime=new String[page.getPageSize()];
        int i=0;
        for(Tiezi tieziTemp:tiezi){
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
