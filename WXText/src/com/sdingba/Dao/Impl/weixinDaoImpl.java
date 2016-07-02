package com.sdingba.Dao.Impl;

import com.sdingba.Dao.Bean.UserData;
import com.sdingba.Dao.Bean.weixinUser;
import com.sdingba.Dao.weixinDao;
import com.sdingba.util.DaoUtils;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * Created by su on 16-7-1.
 */
public class weixinDaoImpl implements weixinDao {
    QueryRunner runner = new QueryRunner(DaoUtils.getSource());
    @Override
    public weixinUser findByIdBingUser(String UserId) {

        String sql = "select * from weixinUser where wxId = ?";
        try {
           return runner.query(sql, new BeanHandler<weixinUser>(weixinUser.class), UserId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int BingUserId(String WxId, String BingId) {
        String sql = "insert into weixinUser values(?,?)";
        try {
            return runner.update(sql, WxId, BingId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }



}
