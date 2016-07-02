package com.sdingba.Dao;

import com.sdingba.Dao.Bean.UUIDSetDate;

import java.util.List;

/**
 * Created by su on 16-7-1.
 */
public interface UUIDSetDateDao {
    /**
     * 根据 设置的次数 获取list集合
     *
     * @param setNum
     * @return
     */
    public List<UUIDSetDate> getListClassUUIDSETDate(String setNum, String userId);

}
