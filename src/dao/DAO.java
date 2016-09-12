package dao;

import java.sql.Connection;

/**
 * Created by Mayijun on 2016/9/7.
 */
//先放着，回头再抽象
public interface DAO {
    public Connection getConnection();
    public void insert();
}
