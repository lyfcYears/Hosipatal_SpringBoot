package com.hospital.utils;

import cn.hutool.core.date.DateUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 2019年东软睿道实训项目-东软云医院项目
 *
 * @ClassName 时间的工具
 * @Description 请输入你的简化描述！
 * @Author 方聪
 * @Date 2019/6/13 13:45
 * @Version 1.0
 **/

public class DateUtils {
    public static java.sql.Timestamp getSqlDate(String date) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date nowDate;
        java.sql.Timestamp transdate = null;
        try {
            nowDate = simpleDateFormat.parse(date);
            transdate = new java.sql.Timestamp(nowDate.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transdate;
    }

    public static String getDate() {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date nowDate = new Date();
        String format = simpleDateFormat.format(nowDate);
        System.out.println(format);
        return format;
    }

}
