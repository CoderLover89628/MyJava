package com.zs.study.javacore.string;


/**
 * Created by zhangsheng1 on 2016/7/15.
 *
 */
public class TestString {

    public static void main(String[] args)
    {
        String s = "hi,hello world!";
        System.out.println(getResult(s));
        StrReverseExample();
        StrReplaceExample();
        System.out.println(getParam(s,"hi","nice to meet U"));
        String ss = "zhangsh,kuaile,";
        System.out.println(ss.substring(0,ss.lastIndexOf(",")));
    }

    /**
     *  变参
     * @param params 变参相当于是数组
     * @return 参数组合
     */
    private static String getParam(String... params) {
        return params[0];
    }
    /**
     *  字符串反转之一
     * @param msg 字符串
     * @return 反转之后的字符串
     */
    private static String getResult(String msg)
    {
        if(msg == null || msg.length() == 0)
            return "";
        return getResult(msg.substring(1)) + msg.charAt(0);
    }

    /**
     * 字符串反转之二
     */
    private static void StrReverseExample() {
        String string = "abcdef";
        String reverse = new StringBuffer(string).reverse().toString();
        System.out.println("String before reverse:" + string);
        System.out.println("String after reverse:" + reverse);
    }

    /**
     * 字符串置换
     */
    private static void StrReplaceExample() {
        String msg = "crazyBoy（cb880），hello（h7385）";
        System.out.println(msg);
        msg = msg.replaceAll("d","(");
        msg = msg.replaceAll("f",")");
        System.out.println(msg);
    }

}
