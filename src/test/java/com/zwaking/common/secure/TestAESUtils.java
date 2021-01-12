package com.zwaking.common.secure;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;

public class TestAESUtils {

    private static AESUtils aesUtils = new AESUtils();

    @Test
    public void testWechatDecryptToString() {
        String key = "Mano/Bq1z9h/sKYN2QnW6w==";
        String iv = "lK6Fze1oRBfzLBRpGXVo4Q==";
        String encryptedData =
            "IrQP2IINhLHhhtVOOhCDMW5/CssxcZten/LC9/l55pbFoS+vUPtgd2XG8/Z4Ieu6+NdMjEG1cF06Zl6LECnKuUGHq432rhPk1mN12KsxlSHpjh3PZPZtpdiSZV36+W4YdcjOu9G8TsksQvavIfQSKW3JFkbqtsDckefQ5jpifVQcpidLjl/xkv/UeqlGAMGSrCLIynyeOtrQEU5PU9CA7fbOKx1Bxgz6Z/E/jXrCDrKpJ1PmfHCw6xRb0i3Jg4LPXpM8snPMJI8UO22wivKdnnEYZI4OBo1P8soXLAbeDsk7SbuA4+smmbrFLovMjBdecutmnu5QO/AXCsZysmcEmmSfqlTQfHtECEuKZeHNxaDgLqZT0rp2pUuXaNW0fgvKIt+HsA24QvnT+e8J49GTU68tetpd7ogwDDk5A8O5w9K+e0zLmEpUZTwxJG2zKu6vk3OzkY4v5NemDhsvEsUf3wUBQZClBkWoHFqMItd1jw0=";
        System.out.println(aesUtils.decryptToString(key, iv, encryptedData));
    }
}
