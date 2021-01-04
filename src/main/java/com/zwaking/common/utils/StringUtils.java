package com.zwaking.common.utils;

import java.util.Random;
import java.util.UUID;

/**
 * @author waking
 * @date 2020/11/25 11:25
 * @title 字符串工具类
 * @description 提供操作字符串的常用工具方法
 */
public class StringUtils {

    /**
     * 数组对象toString
     *
     * @param args
     * @return
     */
    public synchronized static String arrayToString(Object[] args) {
        StringBuffer bf = new StringBuffer();
        if (args != null) {
            int i = 0;
            for (Object obj : args) {
                if (i == 0) {
                    bf.append(obj);
                } else {
                    bf.append("," + obj);
                }
                i++;
            }
        }
        return bf.toString();
    }

    /**
     * 验证字符串是否为空字符
     *
     * @param str
     * @return
     */
    public static boolean isBlank(String str) {
        return str == null || str.trim().equals("") || str.trim().toLowerCase().equals("null");
    }

    /**
     * 如果为空,将字符串转换为NULL
     *
     * @param str
     * @return
     */
    public static String trimToNull(String str) {
        String s = null;
        if (isBlank(str)) {
            return s;
        }
        s = str.trim();
        return s;
    }

    /**
     * 如果为空,将字符串转换为""
     *
     * @param str
     * @return
     */
    public static String trimToBlank(String str) {
        boolean boo = str == null || str.trim().equals("") || str.trim().toLowerCase().equals("null");
        if (boo) {
            return "";
        }
        return str.trim();
    }

    /**
     * 生成一个指定长度的随机数
     *
     * @param length
     * @return
     */
    public static String createRandomStr(int length) {
        Random random = new Random();
        String str = "";
        for (int i = 0; i < length; i++) {
            str += random.nextInt(9);
        }
        return str;
    }

    /**
     * 验证str是否在array数组中
     *
     * @param array
     * @param str
     * @return
     */
    public static boolean valiArgInArray(Object[] array, Object str) {
        if (array != null && array.length > 0) {
            if (!array[0].getClass().equals(str.getClass())) {
                return false;
            }
            for (Object obj : array) {
                if (str.equals(obj)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isEmpty(String str) {
        str = trimToNull(str);
        return (str == null || "".equals(str));
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * 左补零方法
     */
    public static String leftFillZero(String str, int length) {
        if (str == null) {
            return null;
        }
        int count = length - str.length();
        for (int i = 0; i < count; i++) {
            str = "0" + str;
        }
        return str;
    }

    /**
     * 首字母转大写
     *
     * @param str
     * @return
     */
    public static String upperCaseFirstLetter(String str) {
        char[] ch = str.toCharArray();
        if (ch[0] >= 'a' && ch[0] <= 'z') {
            ch[0] = (char)(ch[0] - 32);
        }
        return new String(ch);
    }

    /**
     * 获取32位随机UUID
     * 
     * @return
     */
    public static String get32UUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
