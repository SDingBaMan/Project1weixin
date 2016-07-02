package com.sdingba.Dao;

import com.sdingba.Dao.Bean.Settings;

/**
 * Created by su on 16-7-1.
 */
public interface SettingsDao {
    /**
     * 根据userId查询，返回 是否 有 这 个  类
     * @param userId
     * @return
     */
    public Settings getLastTimeSetTimeSetNum(String userId);


}
