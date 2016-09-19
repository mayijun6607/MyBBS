package main.Tiezi.deleteReply;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Mayijun on 2016/9/19.
 */
public class DeleteReplyService {
    private DeleteReplyDAO deleteReplyDAO;
    public void setDeleteReplyDAO(DeleteReplyDAO deleteReplyDAO) {
        this.deleteReplyDAO = deleteReplyDAO;
    }
    public void deleteReply(Connection connection,String tempTime,String replyTime) throws SQLException {
        deleteReplyDAO.deleteReply(connection,tempTime,replyTime);
    }
}
