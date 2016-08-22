package com.zs.study.javacore.basicType;

/**
 * Created by zhangsheng1 on 2016/7/28.
 * 基本类型
 */
public class TestBasic {

    public static void main(String[] args)
    {
        int basic = 2147483647;
        String comp = "2147483648";
        long a = Long.parseLong(comp);
        long b = basic;

        System.out.println("value is : " + (b - a));

        Integer c = 2147483647;// 最大值

        principle();

        StrToLong();

        String sss = "1";
        float as = Float.parseFloat(sss);
        as += 2;
        if (as - 1 >= 0) {
            System.out.println("big");
        }
        System.out.println(as);

    }

    /**
     * 基础原理4道题
     */
    private static void principle() {

        Integer a = 1000,b=1000;
        Integer c = 100,d=100;

        System.out.println(a == b);// false
        System.out.println(c == d);// true
        System.out.println(a.equals(b));//true  Integer是一个类
        System.out.println(a.intValue() == b.intValue());// true
    }

    private static void StrToLong() {
        String msg = "1";
        Integer a = 8;
        long b = Long.parseLong(msg) * a * 10000 / 1024;
        System.out.println("b:" + b);
    }

}
