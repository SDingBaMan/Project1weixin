package com.sdingba.Dao;

import com.sdingba.Dao.Bean.weixinUser;

/**
 * Created by su on 16-7-1.
 */
public interface weixinDao {

    /**
     * 判断是否绑定用户的。
     * @param UserId
     * @return
     */
    public weixinUser findByIdBingUser(String UserId);

    /**
     * 绑定用户的
     *
     * @param WxId
     * @param BingId
     * @return
     */
    public int BingUserId(String WxId, String BingId);
}
