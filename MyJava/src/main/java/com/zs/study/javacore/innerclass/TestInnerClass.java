package com.zs.study.javacore.innerclass;

import com.zs.study.javacore.interfaces.B;

/**
 * @author zhangsheng1
 * @version V1.0.0
 * @description 内部类的使用
 * @date 2016-08-31 10:04
 * @last-modifier
 * @last-modified
 * @class com.zs.study.javacore.innerclass.TestInnerClass
 * @see
 */
public class TestInnerClass {

    static void takeA(InnerClass innerClass){}
    static void takeC(B b) {}
    public static void main(String[] args)
    {
        A a = new A();
        C c = new C();
        takeA(a);
        takeA(c);
        takeC(a);
        takeC(c.makeB());

    }
}

class A implements InnerClass,B{}

class C implements InnerClass {
    B makeB() {
        return new B() {
        };
    }
}
