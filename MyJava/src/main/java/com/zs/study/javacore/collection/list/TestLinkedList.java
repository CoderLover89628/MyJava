package com.zs.study.javacore.collection.list;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhangsheng1 on 2016/7/18.
 *
 */
public class TestLinkedList {
    public static void main(String[] args)
    {
        LinkedList<String> linkedListOne = new LinkedList<String>();
        linkedListOne.add("a");
        linkedListOne.add("c");
        linkedListOne.add("b");
        linkedListOne.add("d");
        linkedListOne.add("e");
        LinkedList<String> linkedListTwo = new LinkedList<String>();
        linkedListTwo.add("f");
        linkedListTwo.add("g");
        linkedListTwo.add("h");
        linkedListTwo.add("c");
        linkedListTwo.add("i");

        print("linkOne",linkedListOne);
        sortLinkedList(linkedListOne);// 排序
        System.out.println("============");
        print("linkOne",linkedListOne);

        checkTwoLinkedListhasSameValue(linkedListOne,linkedListTwo);
    }

    /**
     * 排序
     * @param linkedList linkedList
     */
    private static void sortLinkedList(LinkedList<String> linkedList)
    {
        Collections.sort(linkedList);
    }

    private static void checkTwoLinkedListhasSameValue(List<String> linkedListOne, List<String> linkedListTwo)
    {
        String message =  Collections.disjoint(linkedListOne,linkedListTwo) ? "两个列表没有相同值" : "两个列表有相同值";
        System.out.println("message is:" + message);
    }

    private static void print(String name,List<String> linkedListOne)
    {
        for (String one : linkedListOne) {
            System.out.println(name + " is:" + one);
        }
    }
}
