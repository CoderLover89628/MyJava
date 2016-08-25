package com.zs.study.javacore.classloader;

/**
 * @author zhangsheng1
 * @version V1.0.0
 * @description 类的构造器测试
 * @date 2016-08-25 14:45
 * @last-modifier
 * @last-modified
 * @class com.zs.study.javacore.classloader.TestConstructor
 * @see
 */
public class TestConstructor {
    int age = 0;
    String name = "zhangsan";
    static String test = "this is a static description";

    public TestConstructor(int age) {
        this.age = age;
    }

    public TestConstructor(String userName) {
//        name = userName; // 两种写法都可以
        this.name = userName;
    }

    public TestConstructor(int age,String userName) {
        this(age);
//        this(userName);// 只能调用一个构造器
        this.name = userName;
    }
    public TestConstructor()
    {
        this(20,"lisi");

        // 下面三行代码会出错，原因是构造器的调用，必须置于起始处，否则编译器会报错
//        int age = 20;
//        String userName = "lisi";
//        this(20,"lisi");
    }

    public static void main(String[] args)
    {
        TestConstructor tc = new TestConstructor();
        System.out.println(tc.name);
        System.out.println(tc.test);// 同下面效果一样，但使用还是下面最好
        System.out.println(TestConstructor.test);
    }
}
