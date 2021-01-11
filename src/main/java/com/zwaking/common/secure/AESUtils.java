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
    private static final Provider bouncyCastleProvider = new BouncyCastleProvider();

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
    public String decryptToString(String key, String iv, String encryptedData) {
        byte[] keyBytes = Base64Coder.decodeBASE64(key);
        byte[] ivBytes = Base64Coder.decodeBASE64(iv);
        byte[] encryptedDataBytes = Base64Coder.decodeBASE64(encryptedData);

        SecretKeySpec skeySpec = new SecretKeySpec(keyBytes, ALGORITHM);
        try {
            Cipher cipher = Cipher.getInstance(TRANSFORMATION_AESCBCPKCS7PADDING, bouncyCastleProvider);
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
        return HexPlus.encode(this.getRawKey(provider, providerName));
    }

    /**
     * 获取aes密钥
     *
     * @param provider
     * @param providerName
     * @return
     */
    public byte[] getRawKey(Provider provider, String providerName) {
        try {
            Security.addProvider(provider);
            KeyGenerator kgen = KeyGenerator.getInstance(ALGORITHM, providerName);
            kgen.init(128);

            SecretKey skey = kgen.generateKey();
            return skey.getEncoded();
        } catch (Exception e) {
            throw new RuntimeException("获取RawKey发生异常", e);
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
