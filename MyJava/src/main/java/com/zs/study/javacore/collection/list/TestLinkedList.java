package com.zs.study.javacore.collection.list;

import java.util.*;

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

//        print("linkOne",linkedListOne);
//        sortLinkedList(linkedListOne);// 排序
//        System.out.println("============");
//        print("linkOne",linkedListOne);

//        checkTwoLinkedListhasSameValue(linkedListOne,linkedListTwo);// 合并

        // 取集合第一个元素的集中方式
        // 前两个如果list为空，则抛出NoSuchElementException异常
        // peek()方法如果list为空，则返回null
        System.out.println("the first element is:" + linkedListOne.getFirst());
        System.out.println("the first element is:" + linkedListOne.element());
        System.out.println("the last element is: " + linkedListOne.peek());

        // 取list最后一个元素
        System.out.println("the last element is: " + linkedListOne.getLast());

        // 删除list第一个元素，并返回该值
        // remove(),removeFirst()如果list为空的时候,抛出NoSuchElementException异常
        // poll()在list为空的时候,返回null
        System.out.println("remove the first element is:" + linkedListOne.remove());
        System.out.println("remove the first element is:" + linkedListOne.removeFirst());
        System.out.println("remove the first element is:" + linkedListOne.poll());

        System.out.println("test hashMap");
        Map<String,String> aMap = new HashMap<String, String>();
        aMap.put("a","hello");
        aMap.put("b","hello");

        if (aMap.containsKey("b")) {
            System.out.println("b is:" + aMap.get("b"));
        } else {
            System.out.println("aMap is no b");
        }






//        for (String value : linkedListOne) {
//
//        }
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
