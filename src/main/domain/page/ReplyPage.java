package main.domain.page;

import main.domain.tiezi.ReplyTiezi;

import java.util.List;

/**
 * Created by Mayijun on 2016/9/14.
 */
public class ReplyPage {
    private int currentPage;
    //private int totalPage;
    private int totalRecord;
    private int pageSize=10;//每页记录数，现在设定10行
    private List<ReplyTiezi> reply;//当前页记录

    public int getTotalPage(){
        return ((int)Math.ceil(totalRecord/pageSize))+1;
    }
    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getPageSize() {
        return pageSize;
    }

    public List<ReplyTiezi> getReply() {
        return reply;
    }

    public void setReply(List<ReplyTiezi> reply) {
        this.reply = reply;
    }
}
