package tieziReply;

import org.springframework.jca.cci.core.ConnectionCallback;
import tiezi.ReplyTiezi;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Mayijun on 2016/9/12.
 */
public class TieziReplyService {
    private TieziReplyDAO tieziReplyDAO;

    public void setTieziReplyDAO(TieziReplyDAO tieziReplyDAO) {
        this.tieziReplyDAO = tieziReplyDAO;
    }
    public void reply(Connection connection, ReplyTiezi replyTiezi,String tieziTime) throws SQLException {
        tieziReplyDAO.reply(connection,replyTiezi,tieziTime);
    }
}
