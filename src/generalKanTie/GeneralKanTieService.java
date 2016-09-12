package generalKanTie;

import java.sql.Connection;
import java.sql.SQLException;

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
}
