package main.domain.tiezi;

/**
 * Created by Mayijun on 2016/9/11.
 */
public class Tiezi {
    private String username;
    private String tieziTitle;
    private String tieziContent;
    private String tieziDatetime;
    private int areaId;
    private int tieziId;

    public Tiezi(){

    }
    public Tiezi(String username,String tieziTitle,String tieziContent,String tieziDatetime,int tieziId){
        this.username=username;
        this.tieziTitle=tieziTitle;
        this.tieziContent=tieziContent;
        this.tieziDatetime=tieziDatetime;
        this.tieziId=tieziId;
        //this.areaId=areaId;
    }
    public Tiezi(String username,String tieziTitle,String tieziContent,String tieziDatetime,int tieziId,int areaId){
        this.username=username;
        this.tieziTitle=tieziTitle;
        this.tieziContent=tieziContent;
        this.tieziDatetime=tieziDatetime;
        this.tieziId=tieziId;
        this.areaId=areaId;
    }

    public int getTieziId() {
        return tieziId;
    }

    public void setTieziId(int tieziId) {
        this.tieziId = tieziId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTieziTitle() {
        return tieziTitle;
    }

    public void setTieziTitle(String tieziTitle) {
        this.tieziTitle = tieziTitle;
    }

    public String getTieziContent() {
        return tieziContent;
    }

    public void setTieziContent(String tieziContent) {
        this.tieziContent = tieziContent;
    }

    public String getTieziDatetime() {
        return tieziDatetime;
    }

    public void setTieziDatetime(String tieziDatetime) {
        this.tieziDatetime = tieziDatetime;
    }

    public int getTieziArea() {
        return areaId;
    }

    public void setTieziArea(int areaId) {
        this.areaId = areaId;
    }
}
