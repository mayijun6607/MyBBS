package publishTiezi;

import tiezi.Tiezi;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Mayijun on 2016/9/11.
 */
public class PublishTieziService {
    private PublishTieziDAO publishTieziDAO;

    public void setPublishTieziDAO(PublishTieziDAO publishTieziDAO) {
        this.publishTieziDAO = publishTieziDAO;
    }

    public void publishTiezi(Connection connection, Tiezi tiezi) throws SQLException {
        publishTieziDAO.addTiezi(connection,tiezi);
    }
}
