package com.sdingba.server.Impl;

import com.sdingba.Dao.*;
import com.sdingba.Dao.Bean.*;
import com.sdingba.factory.Factory;
import com.sdingba.server.weixinDService;
import com.sdingba.util.TimeUtils;

import java.sql.Date;
import java.util.List;

/**
 * Created by su on 16-7-1.
 */
public class weixinDServiceImpl implements weixinDService {
    weixinDao wxDao = Factory.getFactory().getInstance(weixinDao.class);

    @Override
    public weixinUser IsBingUserWX(String userId) {

//        weixinUser wxUser = wxDao.findByIdBingUser(userId);
        return wxDao.findByIdBingUser(userId);
//        if (wxUser == null) {
//            //绑定
//
//            return null;
//        }
//        return wxUser;
    }

    @Override
    public int BindwxAndUser(String wxId, String userId) {
        return wxDao.BingUserId(wxId, userId);
    }

    @Override
    public String lastTime(String userId) {
        UserDataDao uDdao = Factory.getFactory().getInstance(UserDataDao.class);
        UserData data = uDdao.findByLastTime(userId);
        //处理 data

        if (data == null) {
            return "该查询用户暂时没有最近一天的数据";
        }

        StringBuffer str = new StringBuffer();
        str.append("用户 ： " + data.getUserId() + "\n");
        str.append("时间 ： " + data.getDatetime() + "\n");
        str.append("吸烟数 ： " + data.getDataNumber() + "\n");
        str.append("剩余数量 ： " + data.getSurplusNumber() + "\n");


        return str.toString();
    }

    @Override
    public setDataYan getSchelloTable(String userId) {
        UUIDSetDateDao dao = Factory.getFactory().getInstance(UUIDSetDateDao.class);
        SettingsDao daoU = Factory.getFactory().getInstance(SettingsDao.class);

        Settings setdata = daoU.getLastTimeSetTimeSetNum(userId);

        if (setdata != null) {
            StringBuffer result = new StringBuffer();
            Date startTime = setdata.getBeginDatetime();
            Date endTime = setdata.getEndDatetime();

            String startTimeStr = startTime.toString().replace("-", "");

            String endTimeStr = endTime.toString().replace("-", "");

            String MaxNumberset = setdata.getTimeSetNum();

            String newDayTime = TimeUtils.getNewDay();

            if (Integer.parseInt(newDayTime) > Integer.parseInt(endTimeStr)) {
                return null;
            }

            ////  16-6-25 根据MaxNumberSet的值去 UserSet表中获取数据。。
            List<UUIDSetDate> daolist = dao.getListClassUUIDSETDate(MaxNumberset, userId);

            for (UUIDSetDate uuid : daolist) {
                result.append(uuid.getTimeCyc() + ":" + uuid.getYanNumber() + ",");
            }
            int leng = result.length();
            result.delete(leng - 1, leng);
//            System.out.println(result);

            setDataYan dataYan = new setDataYan();
            dataYan.setStartTime(startTimeStr);
            dataYan.setDataJiHua(result.toString());

            return dataYan;
        } else {
            return null;
        }

    }

    @Override
    public String limitTimeSctool(String userId, String timeUNum) {
        UserDataDao uDdao = Factory.getFactory().getInstance(UserDataDao.class);
        List<UserData> dataList = uDdao.findByLimitTime(userId, Integer.parseInt(timeUNum));

        if (dataList == null) {
            return "用户暂时没有数据；";
        }
        StringBuffer resultStr = new StringBuffer();
        resultStr.append("\n 查询用户 ： " + userId + "\n");

        for (UserData uu : dataList) {
            resultStr.append("===时间："+uu.getDatetime()+"==="+"\n");
            resultStr.append("  吸烟数 ： " + uu.getDataNumber() + "\n");
            resultStr.append("  剩余数量 ： " + uu.getSurplusNumber() + "\n");
//            resultStr.append("\n");
        }
        return resultStr.toString();
    }
}
