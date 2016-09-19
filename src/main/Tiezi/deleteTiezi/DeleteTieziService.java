package main.Tiezi.deleteTiezi;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Mayijun on 2016/9/19.
 */
public class DeleteTieziService {
    private DeleteTieziDAO deleteTieziDAO;

    public void setDeleteTieziDAO(DeleteTieziDAO deleteTieziDAO) {
        this.deleteTieziDAO = deleteTieziDAO;
    }

    //先删帖子的表，再删general_tiezi里的记录
    public void deleteTiezi(Connection connection,int deleteId,String tempTime) throws SQLException {
        deleteTieziDAO.deleteTable(connection,tempTime);
        deleteTieziDAO.deleteTiezi(connection,deleteId);
    }
}
