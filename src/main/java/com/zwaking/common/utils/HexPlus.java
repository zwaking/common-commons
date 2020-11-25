package com.zwaking.common.utils;

import org.apache.commons.codec.binary.Hex;

/**
 * @author waking
 * @date 2020/11/25 11:25
 */
public class HexPlus {
    public static String encode(byte[] data) {
        return new String(Hex.encodeHex(data));
    }

    public static byte[] decode(String data) throws Exception {
        return Hex.decodeHex(data.toCharArray());
    }
}
