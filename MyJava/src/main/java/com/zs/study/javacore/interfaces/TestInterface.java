package com.zs.study.javacore.interfaces;

/**
 * Created by zhangsheng1 on 2016/7/15.
 *
 */
public class TestInterface extends D implements C {
    private String name;
    public TestInterface() {

    }

    @Override
    public void print(String msg)
    {
        System.out.println(msg + ":" + url);
    }

    public static void main(String[] args)
    {
        TestInterface testInterface = new TestInterface();
        testInterface.print("this is a test");
    }
}
