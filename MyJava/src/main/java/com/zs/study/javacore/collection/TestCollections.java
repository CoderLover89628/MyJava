package com.zs.study.javacore.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by zhangsheng1 on 2016/8/3.
 *
 */
public class TestCollections {
    public static void main(String[] args)
    {
        List<String> strList = new ArrayList<String>();
        strList.add("eaa");
        strList.add("baa");
        strList.add("aaa");
        strList.add("caa");
        strList.add("dea");
        Collections.sort(strList);
        for (int i = 0, n = strList.size(); i < n ; i++) {
            System.out.println(strList.get(i));
        }
    }
}
