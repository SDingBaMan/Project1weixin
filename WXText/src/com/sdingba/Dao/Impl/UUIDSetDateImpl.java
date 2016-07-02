package com.sdingba.Dao.Impl;


import com.sdingba.Dao.Bean.UUIDSetDate;
import com.sdingba.Dao.UUIDSetDateDao;
import com.sdingba.util.DaoUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by su on 16-7-1.
 */
public class UUIDSetDateImpl implements UUIDSetDateDao {
    QueryRunner runner = new QueryRunner(DaoUtils.getSource());

    @Override
    public List<UUIDSetDate> getListClassUUIDSETDate(String setNum, String userId) {
        String sql = "select * from Alphabet.UUIDSetDate where setNum = ? and setId=? order by timeOrder";
        try {
            return runner.query(sql, new BeanListHandler<UUIDSetDate>(UUIDSetDate.class), setNum, userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
