/**
 *
 */
package com.zwaking.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author waking
 * @date 2022/04/06 16:20
 * @title 时区工具类
 * @description 提供有关时区的常用静态操作方法
 */
public class TimeZoneUtils {

    public static String getDateStrByTimeZone(String timeZone, String zeroDate) throws ParseException {
        String format = DateTimeUtils.YYYYMMDDHHMMSSFormat;
        Date zDate = DateTimeUtils.convertDateTimeFormat(zeroDate, format);

        if (StringUtils.isEmpty(timeZone)) {
            timeZone = TimeZone.getDefault().getID();
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        sdf.setTimeZone(TimeZone.getTimeZone(timeZone));
        return sdf.format(zDate.getTime());
    }
}