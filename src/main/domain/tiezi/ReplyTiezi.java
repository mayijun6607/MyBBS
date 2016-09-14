package main.domain.tiezi;

/**
 * Created by Mayijun on 2016/9/12.
 */
public class ReplyTiezi {
    private String replyUsername;
    private int tieziId;
    private String tieziReply;
    private String replyTime;

    public String getReplyUsername() {
        return replyUsername;
    }

    public void setReplyUsername(String replyUsername) {
        this.replyUsername = replyUsername;
    }

    public int getTieziId() {
        return tieziId;
    }

    public void setTieziId(int tieziId) {
        this.tieziId = tieziId;
    }

    public String getTieziReply() {
        return tieziReply;
    }

    public void setTieziReply(String tieziReply) {
        this.tieziReply = tieziReply;
    }

    public String getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(String replyTime) {
        this.replyTime = replyTime;
    }
}
