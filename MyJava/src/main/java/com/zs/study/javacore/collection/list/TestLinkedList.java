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

        System.out.println("===========排序前================================");
        print("linkOne",linkedListOne);
        sortLinkedList(linkedListOne);// 排序
        System.out.println("===========排序后================================");
        print("linkOne",linkedListOne);

        System.out.println("===========判断两个linkedList是否有相同值==========");
        checkTwoLinkedListhasSameValue(linkedListOne,linkedListTwo);// 合并

        // 取集合第一个元素的集中方式
        // 前两个如果list为空，则抛出NoSuchElementException异常
        // peek()方法如果list为空，则返回null
        System.out.println("===========返回linkedList的第一条数据=============");
        System.out.println("get the first element by getFirst():" + linkedListOne.getFirst());
        System.out.println("get the first element by element():" + linkedListOne.element());
        System.out.println("get the first element by peek(): " + linkedListOne.peek());

        System.out.println("===========删除linkedList的第一条数据并返回该值====");
        // 删除list第一个元素，并返回该值
        // remove(),removeFirst()如果list为空的时候,抛出NoSuchElementException异常
        // poll()在list为空的时候,返回null
        System.out.println("remove the first element by remove():" + linkedListOne.remove());
        System.out.println("remove the first element by removeFirst():" + linkedListOne.removeFirst());
        System.out.println("remove the first element by poll():" + linkedListOne.poll());

        System.out.println("===========打印linkedList的最后一条数据===========");
        // 取list最后一个元素
        System.out.println("the last element is: " + linkedListOne.getLast());

        System.out.println("===========添加到链表尾一条数据===================");
        linkedListOne.add("f");
        linkedListOne.addFirst("g");
        linkedListOne.addLast("h");

        System.out.println("===========删除linkedList的最后一条数据===========");
        System.out.println("remove the last element by removeLast():" + linkedListOne.removeLast());

        System.out.println("test hashMap");
        Map<String,String> aMap = new HashMap<String, String>();
        aMap.put("a","hello");
        aMap.put("b","hello");

        if (aMap.containsKey("b")) {
            System.out.println("b is:" + aMap.get("b"));
        } else {
            System.out.println("aMap is no b");
        }

        System.out.println("===========链表实现栈===========================");
        LinkedList<String> linkedListThr = new LinkedList<String>();
        linkedListThr.add("a");
        linkedListThr.add("c");
        linkedListThr.add("b");
        linkedListThr.add("d");
        linkedListThr.add("e");
        print("原链表",linkedListThr);
        System.out.println("===========实现后=============================");
        implStackByLinkedList(linkedListThr);// 用链表实现栈
    }

    private static void implStackByLinkedList(LinkedList<String> initList)
    {
        LinkedList<String> firList = new LinkedList<String>();
        LinkedList<String> secList = new LinkedList<String>();

        for (String value : initList) {
            firList.add(value);
        }

        while (firList.size() > 0) {
            secList.add(firList.removeLast());
        }

        print("linkedList implement stact", secList);

        System.out.println("===========栈实现第二种方式===================");
        while (initList.size() > 0) {
            System.out.println("stack is:" + initList.removeLast());
        }
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
