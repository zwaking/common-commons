package com.zwaking.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

import com.zwaking.common.utils.DateTimeUtils;

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
}
