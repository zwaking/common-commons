package com.zwaking.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

public class TestDateTimeUtils {

    @Test
    public void testGetDateTimeForword() {
        System.out.println(DateTimeUtils.getDateTimeForword(new Date(), 1, "天"));
    }

    @Test
    public void test() {
        String time = "2021-01-10T21:47:44+08:00";
        try {
            System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                .format(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX").parse(time)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetRandomTimeInterval() {
        try {
            Date beginTime = DateTimeUtils.getToDateObject("2016-01-01 00:00:00");

            for (int i = 0; i < 5; i++) {
                Date[] dates = DateTimeUtils.randomDateTimeInterval(beginTime, 365 * 2);
                // System.out.println("1:" + DateTimeUtils.getFullDateTime(dates[0]));
                // System.out.println("2:" + DateTimeUtils.getFullDateTime(dates[1]));
                System.out.println(DateTimeUtils.getFullDateTime(dates[0]) + " < "
                    + ((dates[1].getTime() - dates[0].getTime()) / 1000 / 3600 / 24) + " > "
                    + DateTimeUtils.getFullDateTime(dates[1]));
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
