package com.zwaking.common.utils;

import org.apache.commons.codec.binary.Base64;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;

/**
 * @author waking
 */
public class Base64Coder {
    /**
     * 进行BASE64解码
     *
     * @param content
     * @return
     */
    public static byte[] decodeBASE64(String content) {
        Base64 base64 = new Base64();
        byte[] decodeBytes = null;
        try {
            decodeBytes = base64.decode(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decodeBytes;
    }

    /**
     * 进行BASE64编码
     *
     * @param bytes
     * @return
     */
    public static String encoderBASE64(byte[] bytes, boolean isOneLine) {
        String str = "";
        Base64 base64 = new Base64();
        byte[] decodeBytes = null;
        try {
            decodeBytes = base64.encode(bytes);
            if (isOneLine) {
                ByteArrayInputStream bis = new ByteArrayInputStream(decodeBytes);
                BufferedReader br = new BufferedReader(new InputStreamReader(bis));
                String temp = "";
                while (null != (temp = br.readLine())) {
                    str += temp;
                }
                bis.close();
                br.close();
            } else {
                str = new String(decodeBytes);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }
}
