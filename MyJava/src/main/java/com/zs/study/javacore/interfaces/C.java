package com.zs.study.javacore.interfaces;

/**
 * Created by zhangsheng1 on 2016/7/15.
 * 接口可以多继承接口
 * 类只能多实现接口，和单继承类
 */
public interface C extends A, B {
    void print(String msg);// 接口中的方法默认都是public的，而且只能是public的

    String url = "www.google.com";// 接口中的变量都是静态final类型的，等价于static final String url = "www.google.com";
}
