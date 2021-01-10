package com.zwaking.common.secure;

import org.junit.jupiter.api.Test;

public class TestAESUtils {

    private static AESUtils aesUtils = new AESUtils();

    @Test
    public void testWechatDecryptToString() {
        String key = "Mano/Bq1z9h/sKYN2QnW6w==";
        String iv = "lK6Fze1oRBfzLBRpGXVo4Q==";
        String encryptedData =
            "IrQP2IINhLHhhtVOOhCDMW5/CssxcZten/LC9/l55pbFoS+vUPtgd2XG8/Z4Ieu6+NdMjEG1cF06Zl6LECnKuUGHq432rhPk1mN12KsxlSHpjh3PZPZtpdiSZV36+W4YdcjOu9G8TsksQvavIfQSKW3JFkbqtsDckefQ5jpifVQcpidLjl/xkv/UeqlGAMGSrCLIynyeOtrQEU5PU9CA7fbOKx1Bxgz6Z/E/jXrCDrKpJ1PmfHCw6xRb0i3Jg4LPXpM8snPMJI8UO22wivKdnnEYZI4OBo1P8soXLAbeDsk7SbuA4+smmbrFLovMjBdecutmnu5QO/AXCsZysmcEmmSfqlTQfHtECEuKZeHNxaDgLqZT0rp2pUuXaNW0fgvKIt+HsA24QvnT+e8J49GTU68tetpd7ogwDDk5A8O5w9K+e0zLmEpUZTwxJG2zKu6vk3OzkY4v5NemDhsvEsUf3wUBQZClBkWoHFqMItd1jw0=";
        System.out.println(aesUtils.wechatDecryptToString(key, iv, encryptedData));
    }

    @Test
    public void testWechatDecryptToString2() {
        String key = "Xv16JZzX4PDTz4QlVXxbhPX14NBPymSW";
        String nonce = "F1HYVu2s2gZm";
        String associated_data = "transaction";
        String encryptedData = "57KSsRuRATngNGeElQTWokUhA6TvFxpxEl132osa00L+kGA/7ErPV0LsoKsW+dFSmA1eYU89S4DYsiJ7WEiDYstr1/52brfvf1qMUDb9Zb4D5H2ln8dg08cls88tYb0M+GtaZk+LuxoF8qdl6YB5FRG21HBg9TZFFQMB8V05B1VRmrFZm/vvrlrWoMr1tGzTYgy5lduI6VNG/mm/5FEh3mgjkwPR2kjGm3kQ+2j7e3URkP4jQzColEcIMmvOHYr5YHX3zV3sbNFJTggg4wTC7goVPv+eU2ckgIymz+0kQ1BlwMOyl60edv9aB2Fx84AVlNAZtAOaRNhVOJ9ejrL8i/jcRCFrE/JK2bSuY8NFWlTeAmISd9WDlwSC69Jk+hvAxgd5Fc0hziO56Ys1M+w0HLMqqLawVBebdkKZpAClkjIy+GnD39ikNEMoeGE7OJgwmPCpcngJWBIslov5jtBW/dgLhk61H202IFVoU1KhUF2DDwgKWT/VUXVWwifXO/R6sStBgGPHJWoeqxyOypHpNHotN0h2TKez/VTZraH1GbPCP6wxgKLVt+y1vZ146NunFaJnl+jszX+FjvLgq93P";
        System.out.println(aesUtils.wechatDecryptToString(key, nonce, associated_data, encryptedData));
    }
}
