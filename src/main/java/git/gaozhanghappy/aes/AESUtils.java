package git.gaozhanghappy.aes;/**
 * Created by thinkpad on 2019/9/18.
 */

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author gaozhang
 * @ 2019/9/18 17:31
 */

public class AESUtils {
    //实际的加密解密操作
    private static byte[] Operation(byte[] src,String key,int mode) throws Exception{
        if (key==null) {
            System.out.println("Key不能为空");
            return null;
        }
        if (key.length()!=16) {
            System.out.println("Key需要16位长度");
            return null;
        }

        byte[] raw=key.getBytes("utf-8");
        SecretKeySpec keySpec=new SecretKeySpec(raw, "AES");
        Cipher cipher=Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(mode, keySpec);
        byte[] encrypted=cipher.doFinal(src);
        return encrypted;
    }

    public static byte[] Encrypt(byte[] src,String key) throws Exception{
        return Operation(src, key, Cipher.ENCRYPT_MODE);
    }

    public static byte[] Decrypt(byte[] src,String key) throws Exception{
        return Operation(src, key, Cipher.DECRYPT_MODE);
    }

}
