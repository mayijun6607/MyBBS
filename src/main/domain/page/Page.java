package main.domain.page;

import main.domain.tiezi.Tiezi;

import java.util.List;

/**
 * Created by Mayijun on 2016/9/14.
 */
public class Page {
    private int currentPage;
    //private int totalPage;
    private int totalRecord;
    private int pageSize=10;//每页记录数，现在设定10行
    private List<Tiezi> tiezi;//当前页记录

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return ((int)Math.ceil(totalRecord/pageSize))+1;
    }

  /*  public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }*/

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public List<Tiezi> getTiezi() {
        return tiezi;
    }

    public void setTiezi(List<Tiezi> tiezi) {
        this.tiezi = tiezi;
    }

    public int getPageSize() {
        return pageSize;
    }

   /* public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }*/
}
