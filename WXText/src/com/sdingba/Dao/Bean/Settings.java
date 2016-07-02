package com.sdingba.Dao.Bean;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by su on 16-6-2.
 */
public class Settings implements Serializable {

    /**
     * SId   主键    不是 auto
     */
    private String sid;    //主键

    private String userId;

    /**
     * 吸烟时间（总共的时间）
     */
    private String timeNum;

    //    /**
//     * 设置的次数。
//     */
    private String timeSetNum;

    private Date beginDatetime;


    private Date endDatetime;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTimeNum() {
        return timeNum;
    }

    public void setTimeNum(String timeNum) {
        this.timeNum = timeNum;
    }

    public String getTimeSetNum() {
        return timeSetNum;
    }

    public void setTimeSetNum(String timeSetNum) {
        this.timeSetNum = timeSetNum;
    }

    public Date getBeginDatetime() {
        return beginDatetime;
    }

    public void setBeginDatetime(Date beginDatetime) {
        this.beginDatetime = beginDatetime;
    }

    public Date getEndDatetime() {
        return endDatetime;
    }

    public void setEndDatetime(Date endDatetime) {
        this.endDatetime = endDatetime;
    }
}
