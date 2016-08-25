package com.zs.study.javacore.classloader;

/**
 * Created by zhangsheng1 on 2016/8/24.
 *  类初始化的时候，静态代码块，非静态代码块，构造器的优先级
 *  静态代码块儿先执行，父类静态代码块，子类静态代码块，父类代码块，父类构造器，子类代码块，
 *  子类构造器。
 *
 *  tc= new TestClass()的时候，静态代码块已经进行了加载，所以只执行父类代码块，父类构造器，子类代码块，
 *  子类构造器。
 *
 */
public class TestClass extends SubClass{

    String name;
    int age;

    static{
        System.out.println("this is a static");
    }

    {
        this.name="zhangsan";
        this.age=24;
        System.out.println("this is a common");
    }

    public TestClass()
    {
        System.out.println("this a TestClass constructor");
    }

    public static void main(String[] args)
    {

        TestClass tc = new TestClass();
        System.out.println("==================");
        tc = new TestClass();

    }
}

class SubClass {
    public SubClass()
    {
        System.out.println("this is a father Class Constructor");
    }

    static {
        System.out.println("this is a static father part");
    }

    {
        System.out.println("this is a common part");
    }
}