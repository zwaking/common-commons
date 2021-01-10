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

    @Test
    public void testWechatDecryptToString3() {
        String key = "Xv16JZzX4PDTz4QlVXxbhPX14NBPymSW";
        String nonce = "9512beb461b2";
        String associated_data = "certificate";
        String encryptedData = "7NkQtwGkMr2aCHe5kgCLELd5ur3xBaOtvcrSXmqUp+jRCds3VVbLAEUQY0OjYw7p00msHY8MoZCOy4VFhpK6p3qYhVdHRWFjiJeegbht1h15IazfoPn7giNUm9PjWcBkpuSNLzVO3LrDZRs+XvxWt0szvGTNzh9M8qSMVfEN42gZzSSHZb1l4w3BcLq0bRZXRNwd7/D7J/XQ7Y9Oh1MOjzvji0OYrTf+M2VM2oUw6p2qlkKhb9AtrUpNnHTIyHvzbB8PzGthjgG8MQL0OUa2jqzKen7p86sistbhaAWUEzm5z3D5+FJdAtlRAkJGN3f7cjBDJbcLVD4Fn5It+/GlnKc4fBK3UVC8Dv1xyL0FgOhm+/bbZPdZnJt1MtKu1AbhiSJt3ILDYz9+Agjuswft9paFvEXTFstd08sa1wNmadKW3+Y6wF+m4FykGfzNA0B1CglG4LSu8SE9s1MP0hhFuESQoJaHza65H50pmlBjoCp/kMvn+/ThvvJJ1A4hJDcCN7uO8UGcttAgRbBgbQPqkVPMQ1bVE6iwY0seXmAQsJBLglWfBptayWxsEfFAZIFtntTWQwkr6JjiKYghEE0hJ8A+4ReoNuof9aNNdyrCusbCrArbfTbOIhQg4Yr+qwp3F5ry8hJurgV9t3ZpjblmyNrY0lqiLdJ8MFjDZHXVgxYbp6dSwMNgY/Rn1HB/uihj1YOLrm/b+ezdt7K0y4eCcMWRlCxUludDlDqMhz3QJyuOn/KT7KZ041v34lt3ynJxyi3GXplYJalMHUxqOHpC0b60r0EcWG+mCaXS3/SNTRwCsHgPJsZ2S3uypnCHZWuGXPIIjsacZjTjfRssGELqz9Z46uPAk1PWaEzFyQQmNJ2tdcmis2lDzJ+uEKGKqUS+SzU+TEP6RUW89QCxcONuhY8i2AoM1Gl3nsnwGZvfnI5Ex6UhBWiblThyEjUmLlgeGskJCkrcrVFPyZGTdrN89RF4sG04Pktu2U3z1elJydvaLxzvCe1tUo4SytC3mW2C26aKuhMMhcggKhaSsZMgUttqkIapkoi3vC46qQ7InnrYNjWeqq9h5CFBcPKLB9BRYA6m/aIJd3MvB4xcAFc/efwzj2I24XAfbMODpImtbtZGkJRQgL4nV1o1tVJQPnEbUdrBDTzTK8d9nXtfwUU4gHlfA1+PI0OtnsgxHEayJhRRQy/ZMaGvcUESSp1QSFgpEtZzlP5MRhBauIAGZe5WI6bHyYqWNhmvihbgFSjkTNrXi0Eop5rwTbWaDvpWGx1TXVzp/giIIoqOzCWJGrQiyXsWhaXs/+Uey1kOUocop4RFnU1o6bobJ36dG3P7NFJJmHy1F5PdVB15m4TYwFZ0cjYkQxkR/TmzyP5gQ0wnKD6YpEjJN35CM7YweM7BYh0BxneVVOGKForIRHp4HIS/VQHfYdxSs1ve6NfImJzmlkn5apFrg4gsfl+Qc1bmlGNu84/R1/Tz3v45hUB+S8+rHXS6TdTYx0einnePJ4BTmhH0EapHrI2hjiAEM1OkE0wYY3zclJxN4J0a2fNc2qYJ+PteMoiJU7/HSwxhUtxd39x2Qb630/7YC6plxCVRKjAF51ckC49fqhocHIYz1VHNe00di+izcMzMb6zQzgYw/XQMGsCPZsXOCP132B5/BfS8sxEX96UQ2vKnUTppLFzfNMREYvikRscmWM7qHF4kPMY1jFylQ7sYLzOWfpLRXjcpUwhYGGGN5Fq+HpPFng4Vpl3qo/+2UOvkTsdkWEnsBF9y3tInovvioSOdVIBcU2Ea944iq8ZSww34Ax0WMDC7IGLoJuxeHQixR/ez+nESG9HBiAdRJFT/55bv35zNcGZnhmG1lcFfxx69PiojpyHfeN2FOgcvVw==";
        System.out.println(aesUtils.wechatDecryptToString(key, nonce, associated_data, encryptedData));
    }
}
