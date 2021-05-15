package com.epoint.wxszsjh;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Encoder;

/**
 * [AES加密]
 *
 * @author 作者:dailin
 * @version 创建时间：2020年12月15日 下午2:51:46
 */

@SuppressWarnings("restriction")
public class AESUtil {
    /**
     * [进行AES加密]
     *
     * @param AESModel AES加密模式 模式有CBC(有向量模式)和ECB(无向量模式)
     * @param padding  填充模式 NoPadding: 加密内容不足8位用0补足8位； PKCS5P
     *                 adding: 加密内容不足8位用余位数补足8位
     * @param pwd      秘钥
     * @param iv       偏移量
     */

    public String AESEncrypt(String AESModel, String padding, String pwd, String iv, String data) {
        try {
            String cipherModel = "AES/" + AESModel + "/" + padding;
            // AES/ECB/PKCS5Padding
            Cipher cipher = Cipher.getInstance(cipherModel);
            SecretKey secretKey = new SecretKeySpec(pwd.getBytes(), "AES");

            if ("CBC".equals(AESModel)) {
                // 加密所需要的偏移向量 CBC模式下有效，否则报错
                IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes());
                cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivspec);
            } else {
                cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            }

            byte[] byte_encode = data.getBytes("utf-8");
            // 加密
            byte[] byte_AES = cipher.doFinal(byte_encode);
            return String.valueOf(new BASE64Encoder().encode(byte_AES));

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        AESUtil aesUtil = new AESUtil();
        String aes = aesUtil.AESEncrypt("ECB", "PKCS5Padding", "r9bbbp1YwmH9xVXt",
                "d22b0a851e014f7b", "a123456");
        System.out.println(aes);

    }
}

