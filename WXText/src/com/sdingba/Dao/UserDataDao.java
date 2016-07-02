package com.sdingba.Dao;

import com.sdingba.Dao.Bean.UserData;

import java.util.List;

/**
 * Created by su on 16-7-1.
 */
public interface UserDataDao {
    /**
     * 获取最后一天的数据
     * @param userId
     * @return
     */
    public UserData findByLastTime(String userId);

    /**
     * limit 时间 查询
     * @param userId
     * @param timeNum
     * @return
     */
    public List<UserData> findByLimitTime(String userId, int timeNum);
}
