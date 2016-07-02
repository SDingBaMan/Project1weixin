package com.sdingba.Dao.Impl;

import com.sdingba.Dao.Bean.Settings;
import com.sdingba.Dao.SettingsDao;
import com.sdingba.util.DaoUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * Created by su on 16-7-1.
 */
public class SettingsDaoImpl implements SettingsDao {
    QueryRunner runner = new QueryRunner(DaoUtils
            .getSource());
    @Override
    public Settings getLastTimeSetTimeSetNum(String userId) {
//        String sql = "select * from Settings where userId=?";
        String sql = "select * from Settings where userId= ? and timeSetNum=(select max(timeSetNum) from Settings where userId = ?)";
        try {
            return runner.query(sql, new BeanHandler<Settings>(Settings.class),userId,userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
