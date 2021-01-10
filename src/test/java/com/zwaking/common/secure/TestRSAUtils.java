package com.zwaking.common.secure;

import org.junit.jupiter.api.Test;

public class TestRSAUtils {

    private static AESUtils aesUtils = new AESUtils();
    private final RSAUtils rsaUtils = new RSAUtils();

    @Test
    public void testWechatSignatureVerify() {

        String serial = "5F71DC18B29D9C3307F6A975336C55782D4918E9";
        String timestamp = "1610287313";
        String nonce = "b5rarpyTu7dpKexBa5k6yQhFYZSAFPhe";
        String body =
            "{\"id\":\"44a5f70b-3d52-567d-acbd-dab77ff070d0\",\"create_time\":\"2021-01-10T21:47:44+08:00\",\"resource_type\":\"encrypt-resource\",\"event_type\":\"TRANSACTION.SUCCESS\",\"summary\":\"支付成功\",\"resource\":{\"original_type\":\"transaction\",\"algorithm\":\"AEAD_AES_256_GCM\",\"ciphertext\":\"57KSsRuRATngNGeElQTWokUhA6TvFxpxEl132osa00L+kGA/7ErPV0LsoKsW+dFSmA1eYU89S4DYsiJ7WEiDYstr1/52brfvf1qMUDb9Zb4D5H2ln8dg08cls88tYb0M+GtaZk+LuxoF8qdl6YB5FRG21HBg9TZFFQMB8V05B1VRmrFZm/vvrlrWoMr1tGzTYgy5lduI6VNG/mm/5FEh3mgjkwPR2kjGm3kQ+2j7e3URkP4jQzColEcIMmvOHYr5YHX3zV3sbNFJTggg4wTC7goVPv+eU2ckgIymz+0kQ1BlwMOyl60edv9aB2Fx84AVlNAZtAOaRNhVOJ9ejrL8i/jcRCFrE/JK2bSuY8NFWlTeAmISd9WDlwSC69Jk+hvAxgd5Fc0hziO56Ys1M+w0HLMqqLawVBebdkKZpAClkjIy+GnD39ikNEMoeGE7OJgwmPCpcngJWBIslov5jtBW/dgLhk61H202IFVoU1KhUF2DDwgKWT/VUXVWwifXO/R6sStBgGPHJWoeqxyOypHpNHotN0h2TKez/VTZraH1GbPCP6wxgKLVt+y1vZ146NunFaJnl+jszX+FjvLgq93P\",\"associated_data\":\"transaction\",\"nonce\":\"F1HYVu2s2gZm\"}}";

        try {
            String pubKeyPath = "classpath:apiclient_pubkey.pem";
            String signature =
                "Ga+KdoKbqP9oId7u5g/rVemzFJWPISNbaaHnYRYvbjMdUPo3BH2VWWj9tjI4fnOLZJSG/XkmTljANv5YVpzUfXQA/zwKU7X+JJTkffeV6yUNQNx7+KSv6Tya7MUeOsexUdCauAhl0pjvfUr3eAhOBpMpIlEktL3CaMZHV3fT6vgpuOCc5Qavk9xUidl2hN0FeUMFwkc6hFdQOMxS+1llPZspWWnBMZiUtYa06v17x01HeY5acZZlfQdT2yqFbM7uC4PMAUkVS5G07qErrWJNw+1N2fMoGHJGyX5ZZz4Ufj26LBAOFdk9wH9WNbSB9F4v7/ypehn1OC28bNCyAleY+w==";

            System.out.println(rsaUtils.wechatSignatureVerify(timestamp, nonce, body, pubKeyPath, signature));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
