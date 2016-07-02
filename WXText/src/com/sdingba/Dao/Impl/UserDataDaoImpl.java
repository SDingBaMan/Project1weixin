package com.sdingba.Dao.Impl;

import com.sdingba.Dao.Bean.UserData;
import com.sdingba.Dao.UserDataDao;
import com.sdingba.util.DaoUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by su on 16-7-1.
 */
public class UserDataDaoImpl implements UserDataDao {

    @Override
    public UserData findByLastTime(String userId) {
        QueryRunner runner = new QueryRunner(DaoUtils.getSource());
        String sql = "select * from UserData where userId = ? " +
                "and datetime=(select max(datetime) from UserData where userId = ?)";
        try {
            return runner.query(sql, new BeanHandler<UserData>(UserData.class), userId, userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<UserData> findByLimitTime(String userId, int timeNum) {
        QueryRunner runner = new QueryRunner(DaoUtils.getSource());

        String sql = "select * from UserData where userId=? order by datetime desc limit ?";

        try {
            return runner.query(sql, new BeanListHandler<UserData>(UserData.class),userId,timeNum);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
