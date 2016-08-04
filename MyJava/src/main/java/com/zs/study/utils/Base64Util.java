package com.zs.study.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;

/**
 * Created by zhangsheng1 on 2016/7/29.
 * Base64加密解密
 */
public class Base64Util {

    /**
     * 加密
     *
     * @param str 待加密字符串
     * @return 加密字符串
     */
    public static String getBase64(String str) {
        byte[] b = null;
        String s = null;
        try {
            b = str.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (b != null) {
            s = new BASE64Encoder().encode(b);
        }
        return s;
    }

    /**
     * 解密
     *
     * @param s 加密字符串
     * @return 解密后的字符串
     */
    public static String getFromBase64(String s) {
        byte[] b;
        String result = null;
        if (s != null) {
            BASE64Decoder decoder = new BASE64Decoder();
            try {
                b = decoder.decodeBuffer(s);
                result = new String(b, "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
