package git.gaozhanghappy.aes;/**
 * Created by thinkpad on 2019/9/18.
 */

import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author gaozhang
 * @ 2019/9/18 19:01
 */

public class AESTest {

    // 加密
    public static String encry(String content, String key) throws Exception {
        String IV = key;
        if (key.length() > 16) {
            // IV为商户MD5密钥后16位
            IV = key.substring(key.length() - 16);
            // RES的KEY 为商户MD5密钥的前16位
            key = key.substring(0, 16);
        }

        return encryptData(content, key, IV);
    }

    // 加密
    public static String desEncry(String content, String key) throws Exception {
        String IV = key;
        if (key.length() > 16) {
            // IV为商户MD5密钥后16位
            IV = key.substring(key.length() - 16);
            // RES的KEY 为商户MD5密钥的前16位
            key = key.substring(0, 16);
        }
        return decryptData(content, key, IV);
    }

    /**
     * aes 加密
     *
     * @param data
     * @return
     */
    public static String encryptData(String data, String key, String IV) throws Exception {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            byte[] dataBytes = data.getBytes("UTF-8");
            int plaintextLength = dataBytes.length;
            // if (plaintextLength % blockSize != 0) {
            // plaintextLength = plaintextLength + (blockSize - (plaintextLength
            // % blockSize));
            // }
            byte[] plaintext = new byte[plaintextLength];
            System.arraycopy(dataBytes, 0, plaintext, 0, dataBytes.length);
            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), "AES");
            IvParameterSpec ivspec = new IvParameterSpec(IV.getBytes());
            cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
            byte[] encrypted = cipher.doFinal(plaintext);
            return new String(Base64.encodeBase64(encrypted));
        } catch (Exception e) {
            throw e;
        }

    }

    /**
     * aes 解密
     *
     * @param data
     *            密文
     * @return
     */
    public static String decryptData(String data, String key, String IV) throws Exception {
        try {
            byte[] encrypted1 = Base64.decodeBase64(data.getBytes("UTF-8"));
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), "AES");
            IvParameterSpec ivspec = new IvParameterSpec(IV.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);
            byte[] original = cipher.doFinal(encrypted1);
            String originalString = new String(original, "UTF-8");
            return originalString;
        } catch (Exception e) {
            throw e;
        }
    }

    public static void main(String[] args) throws Exception {
        String a = encry("admin", "EFNDMJS3KD23DKRF");
        final String s = decryptData("admin", "EFNDMJS3KD23DKRF", "EFNDMJS3KD23DKRF");

        System.out.println(a);
        System.out.println("---------------------------");
        System.out.println(s);

    }

}
