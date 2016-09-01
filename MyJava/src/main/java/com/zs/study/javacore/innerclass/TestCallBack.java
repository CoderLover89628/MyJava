package com.zs.study.javacore.innerclass;
import static java.lang.System.*;
/**
 * @author zhangsheng1
 * @version V1.0.0
 * @description 闭包和回调
 * @date 2016-09-01 9:55
 * @last-modifier
 * @last-modified
 * @class com.zs.study.javacore.innerclass.TestCallBack
 * @see
 */

interface Incrementable {
    void increment();
}

class Callee1 implements Incrementable {
    private int i = 0;

    public void increment()
    {
        i++;
        out.println(i);
    }
}

class MyIncrement {
    public void increment(){
        out.println("Other Operation");
    }
    static void f(MyIncrement mi) {
        mi.increment();
    }
}

// if your class must implements increment() in
// some other way,you must use an inner class
class Callee2 extends MyIncrement{
    private int i = 0;
    public void increment() {
        super.increment();
        i++;
        out.println(i);
    }

    private class Closure implements Incrementable{

        public void increment()
        {
            Callee2.this.increment();
        }
    }

    Incrementable getCallbackReference() {
        return new Closure();
    }
}

class Caller {
    private Incrementable callbackReference;
    Caller(Incrementable incrementable) {
        callbackReference = incrementable;
    }
    void go() {
        callbackReference.increment();
    }
}

public class TestCallBack {
    public static void main(String[] args)
    {
        out.println("hello world");

        Callee1 c1 = new Callee1();
        Callee2 c2 = new Callee2();
        MyIncrement.f(c2);
        out.println("=================");
        Caller caller1 = new Caller(c1);
        Caller caller2 = new Caller(c2.getCallbackReference());
        caller1.go();
        caller1.go();
        caller2.go();
        caller2.go();
    }
}
