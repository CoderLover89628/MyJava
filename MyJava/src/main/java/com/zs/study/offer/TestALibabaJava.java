package com.zs.study.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangsheng1
 * @version V1.0.0
 *          Date 2017-02-20 10:01
 * @class com.zs.study.offer.TestALibabaJava
 * @see
 */
public class TestALibabaJava {
    public static void main(String[] args)
    {
//        List<Integer> aa = new ArrayList<Integer>();
//        aa.add(0);
//        aa.add(1);
//        aa.add(2);
//        aa.add(3);
//        aa.add(4);
//        aa.add(5);
//        List<Integer> subLis = aa.subList(0,3);
//
//        System.out.println("*********1****************");
//        print(subLis);
//        System.out.println("*********2****************");
//        subLis.add(6);
//        print(aa);
//        System.out.println("*********3****************");
//        print(subLis);
//        System.out.println("*********4****************");
//        aa.add(7);
//        print(subLis);



        List<String> a = new ArrayList<String>();
        a.add("1");
        a.add("2");
        print(a);
        for (String temp : a) {
            if("1".equals(temp)){
                a.remove(temp);
            }
        }
//        print(a);
        for (String temp : a) {
            if("1".equals(temp)){
                a.set(0,"3");
            }
        }
//        print(a);
    }

    private static void print(List<String> subLis)
    {
        for (String count : subLis) {
            System.out.println("count is:" + count);
        }
    }
}
