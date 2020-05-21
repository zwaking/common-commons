package com.zwaking.common.secure;

import com.zwaking.common.utils.Base64Coder;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Security;

/**
 * @author zhouy
 */
public class DESUtils {

    public static final String TRANSFORMATION_3DESECBNOPADDING = "DESede/ECB/NoPadding";

    public static final String TRANSFORMATION_3DESECBPKCS7PADDING = "DESede/ECB/PKCS7Padding";

    public static final String TRANSFORMATION_DESCBCPKCS5PADDING = "DES/CBC/PKCS5Padding";

    public static final String TRANSFORMATION_DESECBPKCS5Padding = "DES/ECB/PKCS5Padding";

    private String transformation;

    public DESUtils(String transformation) {
        // 添加PKCS7Padding支持
        Security.addProvider(new BouncyCastleProvider());
        this.transformation = transformation;
    }

    public byte[] encrypt_3des(byte[] key, byte[] mingtext) throws Exception {
        byte[] mitext = null;

        SecretKey deskey = new SecretKeySpec(key, "DESede");
        Cipher cipher = Cipher.getInstance(transformation);
        cipher.init(Cipher.ENCRYPT_MODE, deskey);

        mitext = cipher.doFinal(mingtext);

        return mitext;
    }

    public byte[] decrypt_3des(byte[] key, byte[] mitext) throws Exception {
        byte[] mingtext = null;

        SecretKey deskey = new SecretKeySpec(key, "DESede");
        Cipher cipher = Cipher.getInstance(transformation);
        cipher.init(Cipher.DECRYPT_MODE, deskey);

        mingtext = cipher.doFinal(mitext);

        return mingtext;
    }

    public byte[] decrypt(byte[] key, byte[] mitext, byte[] iv) throws Exception {
        byte[] mingtext = null;

        SecretKey deskey = new SecretKeySpec(key, "DES");

        Cipher cipher = Cipher.getInstance(transformation);

        cipher.init(Cipher.DECRYPT_MODE, deskey, new IvParameterSpec(iv));

        mingtext = cipher.doFinal(mitext);

        return mingtext;
    }

    public byte[] encrypt(byte[] key, byte[] mingtext, byte[] iv) throws Exception {
        byte[] mitext = null;

        SecretKey deskey = new SecretKeySpec(key, "DES");
        Cipher cipher = Cipher.getInstance(transformation);
        cipher.init(Cipher.ENCRYPT_MODE, deskey, new IvParameterSpec(iv));

        mitext = cipher.doFinal(mingtext);

        return mitext;
    }

    public byte[] encrypt(byte[] key, byte[] mingtext) throws Exception {
        byte[] mitext = null;

        SecretKey deskey = new SecretKeySpec(key, "DES");
        Cipher cipher = Cipher.getInstance(transformation);
        cipher.init(Cipher.ENCRYPT_MODE, deskey);

        mitext = cipher.doFinal(mingtext);

        return mitext;
    }
}
