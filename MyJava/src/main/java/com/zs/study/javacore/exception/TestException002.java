package com.zs.study.javacore.exception;

/**
 * @author zhangsheng1
 * @version V1.0.0
 * @description
 * @date 2016-08-25 16:21
 * @last-modifier
 * @last-modified
 * @class com.zs.study.javacore.exception.TestException002
 * @see
 */
public class TestException002 {
    public static void main(String[] args)
    {
        A a = new A();
        System.out.println(a);

        String msg = "zhangsan" + "\n" + "lisi";
        String[] names = msg.split("\n");
        for (String name : names) {
            System.out.println("name is :" + name);
        }
    }
}

class A {}