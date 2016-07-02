package com.sdingba.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by su on 16-7-1.
 */
public class StringDataListUuils {
    /**
     * @param datastr 设置日期
     * @param scheel  处理安排表
     * @return all 总共时间安排表  生成的安排表
     */
    public static String PullStringToDate(String datastr, String scheel) {

        try {
            Date date = new SimpleDateFormat("yyyyMMdd").parse(datastr);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);

            /**
             * 生成的安排表
             */
            StringBuffer anpaibiao = new StringBuffer();

            int allday = 0;

            String[] list = scheel.split("\\,");
            for (String foo : list) {

                String[] anPai = foo.split("\\:");

                int dayNum = Integer.parseInt(anPai[0]);

                allday += dayNum;

                calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + dayNum);//让日期加1
                SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");//设置日期格式

                String dayTime = df.format(calendar.getTime());
                anpaibiao.append(" * 时间到: "+dayTime + "之前，每天可吸烟数: " + anPai[1] + "根\n");
            }

            System.out.println(anpaibiao.toString());
            System.out.println("一共吸烟天使 ： " + allday);

            return anpaibiao.toString();

        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("cccc");
            return "";
        }
    }
}
