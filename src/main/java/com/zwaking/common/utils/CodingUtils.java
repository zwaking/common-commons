package com.zwaking.common.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author zhouy
 */
public class CodingUtils {

    protected static Logger logger = LogManager.getLogger();

    /**
     * 将字节数组进行md5签名
     *
     * @param source
     * @param isUpper
     * @return
     */
    public static synchronized String md5(byte[] source, boolean isUpper) {
        if (source == null) {
            return null;
        }
        String md5Str = "";
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(source);
            byte[] sources = messageDigest.digest();

            md5Str = HexPlus.encode(sources);
        } catch (NoSuchAlgorithmException e) {
            logger.error("将字节数组进行md5签名发生异常[source=" + new String(source) + "]", e);
        }
        return isUpper ? md5Str.toUpperCase() : md5Str.toLowerCase();
    }

    /**
     * 将字符串进行md5签名
     *
     * @param source
     * @param isUpper
     * @return
     */
    public static synchronized String md5(String source, String enCodeName, boolean isUpper) {
        String md5Str = "";
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(source.getBytes(enCodeName));
            byte[] sources = messageDigest.digest();

            md5Str = HexPlus.encode(sources);
        } catch (Exception e) {
            logger.error("将字符串进行md5签名发生异常[source=" + source + ",enCodeName=" + enCodeName + "]", e);
        }
        return isUpper ? md5Str.toUpperCase() : md5Str.toLowerCase();
    }

    /**
     * 将字符串进行SHA-256签名
     *
     * @param source
     * @param enCodeName
     * @param isUpper
     * @return
     */
    public static String sha_256(String source, String enCodeName, boolean isUpper) {
        return sha(source, enCodeName, isUpper, "SHA-256");
    }

    /**
     * 将字符串进行SHA-1签名
     *
     * @param source
     * @param enCodeName
     * @param isUpper
     * @return
     */
    public static synchronized String sha(String source, String enCodeName, boolean isUpper, String algorithm) {
        String shaStr = "";
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            messageDigest.update(source.getBytes(enCodeName));
            byte[] sources = messageDigest.digest();

            shaStr = HexPlus.encode(sources);
        } catch (Exception e) {
            logger.error("将字符串进行" + algorithm + "签名发生异常[source=" + source + ",enCodeName=" + enCodeName + "]", e);
        }
        return isUpper ? shaStr.toUpperCase() : shaStr.toLowerCase();
    }
}
