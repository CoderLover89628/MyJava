package com.zs.study.javacore.collection.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangsheng1 on 2016/7/18.
 *
 */
public class TestArrayList {

    public static void main(String[] args)
    {
        deleteItemOne();
    }

    private static void deleteItemOne() {
        List<String> al = new ArrayList<String>();
        al.add("a");
        al.add("b");
        //al.add("b");
        //al.add("c");
        //al.add("d");
        for (int i = 0; i < al.size(); i++) {
            if (al.get(i) == "b") {
                al.remove(i);
                i--;
            }
        }
        print(al);
    }

    private static void print(List<String> al)
    {
        for (String list : al)
            System.out.println(list);
    }
}
