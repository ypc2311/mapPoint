package com.mapdemo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    private static final Logger logger = LoggerFactory.getLogger(DateUtil.class);
    /** 日期格式yyyy-MM-dd字符串常量 */
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    /** 日期格式yyyy MM dd字符串常量 */
    public static final String DATE_FORMAT_BANK = "yyyy MM dd";
    /** 日期格式HH:mm:ss字符串常量 */
    public static final String HOUR_FORMAT = "HH:mm:ss";
    /** 日期格式yyyy-MM-dd HH:mm:ss字符串常量 */
    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private static SimpleDateFormat sdf_date_format = new SimpleDateFormat(DATE_FORMAT);
    private static SimpleDateFormat sdf_date_format_bank = new SimpleDateFormat(DATE_FORMAT_BANK);
    private static SimpleDateFormat sdf_hour_format = new SimpleDateFormat(HOUR_FORMAT);
    private static SimpleDateFormat sdf_datetime_format = new SimpleDateFormat(DATETIME_FORMAT);

    /**
     * 获得服务器当前日期及时间，以格式为：yyyy-MM-dd HH:mm:ss的日期字符串形式返回
     *
     * @author ypc
     * @date 20190419
     * @return
     */
    public static String getDateTime() {
        try {
            return sdf_datetime_format.format(Calendar.getInstance().getTime());
        } catch (Exception e) {
            logger.debug("DateUtil.getDateTime():" + e.getMessage());
            return "";
        }
    }

    /**
     * 获得服务器当前日期，以格式为：yyyy-MM-dd的日期字符串形式返回
     *
     * @author ypc
     * @date 20190419
     * @return
     */
    public static String getDate() {
        try {
            return sdf_date_format.format(Calendar.getInstance().getTime());
        } catch (Exception e) {
            logger.debug("DateUtil.getDate():" + e.getMessage());
            return "";
        }
    }

    /**
     * 获得服务器当前日期，以格式为：yyyy MM dd的日期字符串形式返回
     *
     * @author ypc
     * @date 20190419
     * @return
     */
    public static String getDateWithBank() {
        try {
            return sdf_date_format_bank.format(Calendar.getInstance().getTime());
        } catch (Exception e) {
            logger.debug("DateUtil.getDateWithBank():" + e.getMessage());
            return "";
        }
    }

    /**
     * 获得服务器当前时间，以格式为：HH:mm:ss的日期字符串形式返回
     *
     * @author ypc
     * @date 20190419
     * @return
     */
    public static String getTime() {
        String temp = " ";
        try {
            temp += sdf_hour_format.format(Calendar.getInstance().getTime());
            return temp;
        } catch (Exception e) {
            logger.debug("DateUtil.getTime():" + e.getMessage());
            return "";
        }
    }

    /**
     * 返回一个JAVA简单类型的日期字符串
     *
     * @author ypc
     * @date 20190419
     * @return
     */
    public static String getSimpleDateFormat() {
        SimpleDateFormat formatter = new SimpleDateFormat();
        String NDateTime = formatter.format(new Date());
        return NDateTime;
    }

    /**
     * 取得当前时间的日戳
     *
     * @author ypc
     * @date 20190419
     * @return
     */
    @SuppressWarnings("deprecation")
    public static String getTimestamp() {
        Date date = Calendar.getInstance().getTime();
        String timestamp = "" + (date.getYear() + 1900) + date.getMonth() + date.getDate() + date.getMinutes()
                + date.getSeconds() + date.getTime();
        return timestamp;
    }

    /**
     * 取得指定时间的日戳
     *
     * @return
     */
    @SuppressWarnings("deprecation")
    public static String getTimestamp(Date date) {
        String timestamp = "" + (date.getYear() + 1900) + date.getMonth() + date.getDate() + date.getMinutes()
                + date.getSeconds() + date.getTime();
        return timestamp;
    }
}
