package com.zs.study.offer;

/**
 * @author zhangsheng1
 * @version V1.0.0
 *          Date 2016-12-20 18:45
 * @class com.zs.study.offer.TestStr
 * @see
 */
public class TestStr {
    static int a;
    public static void main(String[] args)
    {
        String msg = "zhangsan(89)";
        String name = msg.contains("(") ? msg.substring(0,msg.indexOf("(")) : msg;
        System.out.println("name is:" + name + ",a is:" + a);

        String msgg = "zhang,san,";
        System.out.println("msgg is:" + msgg.trim());

        char[] m = msgg.toCharArray();
        int count = 0;
        for (char c : m) {
            if (("" + c).equals(",")) {
                count++;
            }
        }
        System.out.println("count is:" + count);
        String[] mags = msgg.split(",");
        System.out.println("mags length:" + mags.length);
        for (String s : mags) {
            System.out.println("s is :" +s);
        }

        String sendSms = "1,2";
        if (sendSms.indexOf("1") > -1) {
            System.out.println("send email");
        }
        if(sendSms.indexOf("2") > -1){
            System.out.println("send sms");
        }
        if(sendSms.indexOf("3") > -1){
            System.out.println("send app");
        }
    }
}
