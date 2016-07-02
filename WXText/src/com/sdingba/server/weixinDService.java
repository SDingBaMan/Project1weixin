package com.sdingba.server;

import com.sdingba.Dao.Bean.setDataYan;
import com.sdingba.Dao.Bean.weixinUser;

/**
 * Created by su on 16-7-1.
 */
public interface weixinDService {
    public weixinUser IsBingUserWX(String userId);

    public int BindwxAndUser(String wxId, String userId);

    public String lastTime(String userId);

    /**
     * 根据 userId 返回是否 有计划表
     * @param userId
     * @return
     */
    public setDataYan getSchelloTable(String userId);


    public String limitTimeSctool(String userId,String timeUNum);

}
