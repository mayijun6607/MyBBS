package generalTiezi;

import tiezi.Tiezi;

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

    public Map<Integer,String[]> showTiezi(Connection connection) throws SQLException {
        return generalTieziDAO.findTiezi(connection);

    }
}
