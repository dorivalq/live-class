/*
 * http://www.java2s.com/Code/Java/Security/EncryptingaStringwithDES.htm
 * https://stackoverflow.com/questions/23561104/how-to-encrypt-and-decrypt-string-with-my-passphrase-in-java-pc-not-mobile-plat
 */
package com.silva.liveclass.service;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;


/**
 *
 * @author zchumager
 */
public class EncryptionDemo {

    Cipher ecipher;
    Cipher dcipher;

    public EncryptionDemo() {
    }

    public EncryptionDemo(SecretKey key) throws Exception {
        ecipher = Cipher.getInstance("AES");
        dcipher = Cipher.getInstance("AES");
        ecipher.init(Cipher.ENCRYPT_MODE, key);
        dcipher.init(Cipher.DECRYPT_MODE, key);
    }

    public String encrypt(String str) throws Exception {
        // Encode the string into bytes using utf-8
        byte[] utf8 = str.getBytes("UTF8");

        // Encrypt
        byte[] enc = ecipher.doFinal(utf8);

        // Encode bytes to base64 to get a string
        return new sun.misc.BASE64Encoder().encode(enc);
    }

    public String decrypt(String str) throws Exception {
        // Decode base64 to get bytes
        byte[] dec = new sun.misc.BASE64Decoder().decodeBuffer(str);

        byte[] utf8 = dcipher.doFinal(dec);

        // Decode using utf-8
        return new String(utf8, "UTF8");
    }


    public static void main(String args []) throws Exception
    {
        new EncryptionDemo().execute();
    }

    public void execute() {
        String data = "MIIEowIBAAKCAQEAkB1Xvjd7RVoABV9k9qz35dOF3hh2HOto9O1iC49XiSRHBGaRm7xubvd3YShV\n" +
                "4mwwLLmmIsbAWdhzniaTIq2sUl204I3enC4Vfd1cRP1hU2lZ+JTnajUtrIucsgagFLw55xcGJlr1\n" +
                "H5V30AbOsPfCYTre/87iz8WnALQnUZjjfR2QImvt06dQ7x41RyKSstxQKuCWTbfCMX6g6EgGPxS4\n" +
                "Qo05MuT2doBK9Qu4AjoyzuufAGJY6Y3JLVJecNUk6y+7RGg3K2TAZypahxnQJVJUB5aY+WrUh4QV\n" +
                "ImNh+KWcECZntpvFP3FETxE+SILxgDqdyEd60HRDkRJBbUJJ+Eq2zQIDAQABAoIBABw1YiNdgMeG\n" +
                "YlKq5XxTRwK5cI6UgyoN+jFW9cYFfMDfVPdLjFzLeWJHFhryZj03qAZZIGfWN3heoeLm8g3rqLtG\n" +
                "lE0P9+7iJlrIpXLrlc1Z5b5+hv2HAzWu7jD6kwL8BOly3EVNsIVKIHWbn4GMPYQCnfu8ZzD8I0BE\n" +
                "Ax45qu2mPBq7QvbsY5ML4HHuum8hFvkJv9NLufd4GvTE0f1dpuSWZbkDkQmHNKh/EnAxUUsLElaQ\n" +
                "wvb53t54uYBGEWApv6eBtIYI8UEmT3Y7PSXrFbbTx8Erei3gDcIfPp2ceIZeYpDZnKIduYtxUp5B\n" +
                "XF3ma/euH4+8tubVDoyRhFK2qgECgYEA1e4VINQY3+9A2fxh2IVTG3iY8uCZX8J1rZu/ZtWKv2uu\n" +
                "IdRJHCZK2U6W5ilum9LdFIOrON5710LfmdNBBV3Qmov0bMsogt3xT542Pii+XDtaR4AHwzEvWLfV\n" +
                "APfBZRtxKpGra1PJVIGtYMdh6xSh9wCA2yrCx83/0ZITsgUGEC0CgYEArHSIBOmJmh7tfdH+WFrO\n" +
                "c8u6zyZSkKsulF5/tQBWFJLqD6NkfixIUaVsigTIr7kn5drEgVsJ2IZGi5ms/vBfXvWSSIFVZkj4\n" +
                "2c5psHTzNPxXKvq4LLC6hUsVv3/pcMXK2lXyt2bHjenALp2MGTGq0HyywyHlZajPb5WSrUJQxSEC\n" +
                "gYEAxLKt1otte6jedg+qX4zmxyFxcA+2ted0j/XeXM0HT83QQ+aOekVzGK8769A4lSmigNQ3wIhA\n" +
                "UcJ5GVS2OhryTMdWLBn326v5znzn3utTbDZeYdOET6KPqAEO5l7nAPHkcYGSnZJiUUMSiSOKEr3b\n" +
                "1eIumFWO1mvARY8McOhRlNkCgYBEHpen0RPAZB0NSQh9oAjSppO4xXtxl5yDkLxDI8ncwJdh6/mC\n" +
                "+TzruzsfXXpkJvAClCJwsiQ2efudous5nHsfiELrDuNLzuE1L5qB0ABNWquX14cuZ/SVOC50ATOV\n" +
                "jxtsmOyR0zBZ9w4pm6O+Q+ckCU2XVGlHeaHOgrd4Zqx+4QKBgGWsDB4m4hDxYa+tYgqjkLjNl8gi\n" +
                "HGxUHpHcryRchVZCoVPa+a6faAyChoUaCYE/vZTueiYmRGxRKnAg0r2BAUzwFdFrRlRUWJlBNX79\n" +
                "QC6vJzgX1YdkkYL6RUk6w3EqndItwq+tIOwSHPtJtwI5QeV1meoDpP4ggOmYul9TDTzj";
        String k = "Bar12345Bar12345";

        //SecretKey key = KeyGenerator.getInstance("AES").generateKey();
        SecretKey key = new SecretKeySpec(k.getBytes(), "AES");
        String decrypted = null;
        try {
            EncryptionDemo encrypter = new EncryptionDemo(key);

            System.out.println("Original String:  " + data);

            String encrypted = encrypter.encrypt(data);

            System.out.println("Encrypted String: " + encrypted);

            decrypted = encrypter.decrypt(encrypted);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Decrypted String: " + decrypted);
    }
}
