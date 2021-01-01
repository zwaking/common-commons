package com.zwaking.common.secure;

import java.security.Provider;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import com.zwaking.common.utils.Base64Coder;
import com.zwaking.common.utils.HexPlus;

/**
 * @author waking
 * @date 2020/11/25 11:25
 */
public class AESUtils {

    public static final String TRANSFORMATION_AESCBCPKCS7PADDING = "AES/CBC/PKCS7Padding";
    // 加密算法
    private static final String ALGORITHM = "AES";
    private static final Provider wechatProvider = new BouncyCastleProvider();

    public static void main(String[] args) {
        AESUtils aesUtils = new AESUtils();
        String key = "Mano/Bq1z9h/sKYN2QnW6w==";
        String iv = "lK6Fze1oRBfzLBRpGXVo4Q==";
        String encryptedData =
                "IrQP2IINhLHhhtVOOhCDMW5/CssxcZten/LC9/l55pbFoS+vUPtgd2XG8/Z4Ieu6+NdMjEG1cF06Zl6LECnKuUGHq432rhPk1mN12KsxlSHpjh3PZPZtpdiSZV36+W4YdcjOu9G8TsksQvavIfQSKW3JFkbqtsDckefQ5jpifVQcpidLjl/xkv/UeqlGAMGSrCLIynyeOtrQEU5PU9CA7fbOKx1Bxgz6Z/E/jXrCDrKpJ1PmfHCw6xRb0i3Jg4LPXpM8snPMJI8UO22wivKdnnEYZI4OBo1P8soXLAbeDsk7SbuA4+smmbrFLovMjBdecutmnu5QO/AXCsZysmcEmmSfqlTQfHtECEuKZeHNxaDgLqZT0rp2pUuXaNW0fgvKIt+HsA24QvnT+e8J49GTU68tetpd7ogwDDk5A8O5w9K+e0zLmEpUZTwxJG2zKu6vk3OzkY4v5NemDhsvEsUf3wUBQZClBkWoHFqMItd1jw0=";
        System.out.println(aesUtils.wechatDecryptToString(key, iv, encryptedData));
    }

    /**
     *
     * @param key
     *            base64的key
     * @param iv
     *            base64的iv
     * @param encryptedData
     *            base64的密文
     * @return
     */
    public String wechatDecryptToString(String key, String iv, String encryptedData) {
        byte[] keyBytes = Base64Coder.decodeBASE64(key);
        byte[] ivBytes = Base64Coder.decodeBASE64(iv);
        byte[] encryptedDataBytes = Base64Coder.decodeBASE64(encryptedData);

        SecretKeySpec skeySpec = new SecretKeySpec(keyBytes, ALGORITHM);
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance(TRANSFORMATION_AESCBCPKCS7PADDING, wechatProvider);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(ivBytes);
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, ivParameterSpec);

            byte[] mingtexts = cipher.doFinal(encryptedDataBytes);

            return new String(mingtexts);
        } catch (Exception e) {
            throw new RuntimeException("解密发生异常", e);
        }
    }

    /**
     * 获取aes密钥并转16进制
     *
     * @param provider
     * @param providerName
     * @return
     */
    public String getRawKeyToHex(Provider provider, String providerName) {
        try {
            Security.addProvider(provider);
            KeyGenerator kgen = KeyGenerator.getInstance(ALGORITHM, providerName);
            kgen.init(128);

            SecretKey skey = kgen.generateKey();
            byte[] raw = skey.getEncoded();
            return HexPlus.encode(raw);
        } catch (Exception e) {
            return null;
        }
    }

    public byte[] getRawKey(Provider provider, String providerName) {
        try {
            Security.addProvider(provider);
            KeyGenerator kgen = KeyGenerator.getInstance(ALGORITHM, providerName);
            kgen.init(128);

            SecretKey skey = kgen.generateKey();
            return skey.getEncoded();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * AES加密并转换成16进制的字符串形式
     *
     * @param mingTexts
     * @param keyHex
     * @return
     * @throws Exception
     */
    public byte[] encrypt(byte[] mingTexts, String keyHex) throws Exception {
        byte[] key = HexPlus.decode(keyHex);

        SecretKeySpec skeySpec = new SecretKeySpec(key, ALGORITHM);

        Cipher cipher = Cipher.getInstance(ALGORITHM);

        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);

        byte[] mitexts = cipher.doFinal(mingTexts);

        return mitexts;
    }

    /**
     * AES加密并转换成16进制的字符串形式
     *
     * @param mingTexts
     * @param keyHex
     * @return
     * @throws Exception
     */
    public String encryptToHex(byte[] mingTexts, String keyHex) throws Exception {
        byte[] key = HexPlus.decode(keyHex);

        SecretKeySpec skeySpec = new SecretKeySpec(key, ALGORITHM);

        Cipher cipher = Cipher.getInstance(ALGORITHM);

        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);

        byte[] mitexts = cipher.doFinal(mingTexts);

        return HexPlus.encode(mitexts);
    }

    /**
     * AES解密并转换成16进制的字符串形式
     *
     * @param miTexts
     * @param keyHex
     * @return
     * @throws Exception
     */
    public String decryptToHex(byte[] miTexts, String keyHex) throws Exception {
        byte[] key = HexPlus.decode(keyHex);

        SecretKeySpec skeySpec = new SecretKeySpec(key, ALGORITHM);

        Cipher cipher = Cipher.getInstance(ALGORITHM);

        cipher.init(Cipher.DECRYPT_MODE, skeySpec);

        byte[] mitexts = cipher.doFinal(miTexts);

        return HexPlus.encode(mitexts);
    }

    /**
     * AES加密并转换成16进制的字符串形式
     *
     * @param mingTexts
     * @param keySpec
     * @return
     * @throws Exception
     */
    public String encryptToHex(byte[] mingTexts, SecretKeySpec keySpec) throws Exception {

        Cipher cipher = Cipher.getInstance(ALGORITHM);

        cipher.init(Cipher.ENCRYPT_MODE, keySpec);

        byte[] mitexts = cipher.doFinal(mingTexts);

        return HexPlus.encode(mitexts);
    }

    /**
     * AES加密并转换成16进制的字符串形式
     *
     * @param mingTexts
     * @param keyHex
     * @return
     * @throws Exception
     */
    public byte[] encryptToHex(byte[] mingTexts, String keyHex, Provider provider, String algorithm,
        String providerName) throws Exception {
        byte[] key = HexPlus.decode(keyHex);

        SecretKeySpec skeySpec = new SecretKeySpec(key, ALGORITHM);
        Security.addProvider(provider);

        Cipher cipher = Cipher.getInstance(algorithm, providerName);

        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);

        byte[] mitexts = cipher.doFinal(mingTexts);

        return mitexts;
    }

    /**
     * AES解密并转换成16进制的字符串形式
     *
     * @param miTexts
     * @param keyHex
     * @return
     * @throws Exception
     */
    public String decryptToHex(byte[] miTexts, String keyHex, Provider provider, String algorithm, String providerName)
        throws Exception {
        byte[] key = HexPlus.decode(keyHex);

        SecretKeySpec skeySpec = new SecretKeySpec(key, ALGORITHM);
        Security.addProvider(provider);

        Cipher cipher = Cipher.getInstance(algorithm, providerName);

        cipher.init(Cipher.DECRYPT_MODE, skeySpec);

        byte[] mingtexts = cipher.doFinal(miTexts);

        return HexPlus.encode(mingtexts);
    }
}
