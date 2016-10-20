package com.zs.study.javacore.collection.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author zhangsheng1
 * @version V1.0.0
 *          Date 2016-10-20 14:04
 * @class com.zs.study.javacore.collection.set.TestSet
 * @see
 */
public class TestSet {

    public static void main(String[] args)
    {
        Set<String> aSet = new HashSet<String>();
        aSet.add("a");
        aSet.add("b");

        Set<String> bSet = new HashSet<String>();
        bSet.add("a");
        bSet.add("c");
        aSet.addAll(bSet);
        Iterator<String> it = aSet.iterator();
        while (it.hasNext()) {
            // 使用迭代遍历的时候,需要将it.next()赋值给一个变量
            // 因为使用it.next()使用的时候容易出错,it.next()是下一个值,再
            // 一个it.next()就是下下一个值
            String value = it.next();
            System.out.println("value is:" + value);
        }
    }
}
