package com.zs.study.javacore.basicType;

/**
 * Created by zhangsheng1 on 2016/8/22.
 * 基本类型测试
 */
public class TestBasic001 {
    static int a;
    static char c;
    public static void main(String[] args)
    {
        System.out.println("a is: " + a + ", c is: " + c);// 类属性会自动初始化值

        showBasicSetValuePass();

        showObjectSetValuePass();

        showReturnInMethodVoid();
    }

    /**
     * void 方法的返回值
     */
    private static void showReturnInMethodVoid()
    {
        return;
    }

    /**
     * 对象赋值不一样，对象的赋值是对对象引用的赋值，
     * 那么，一个引用修改了对象数据，则其余的引用会读取到修改后的值
     */
    private static void showObjectSetValuePass()
    {
        Tank t1 = new Tank();
        Tank t2 = new Tank();
        t1.level = 9;
        t2.level = 10;
        System.out.println("t1 level value is:" + t1.level + "\n" +
                "t2 level value is:" + t2.level);

        t1 = t2;//对象引用传递
        System.out.println("t1 level value is:" + t1.level + "\n" +
                "t2 level value is:" + t2.level);

        t1.level = 19;
        System.out.println("t1 level value is:" + t1.level + "\n" +
                "t2 level value is:" + t2.level);
    }

    /**
     *
     * 基本数据类型的赋值是将值直接复制到另一个地方，
     * 例如，a=b;那么a就复制了b的内容
     * 这样修改了a的值，对于b来说没有任何影响
     */
    private static void showBasicSetValuePass()
    {
        int b = 110;
        int a = b;// 此处拷贝了b的值110
        a += a;// 进行倍增
        System.out.println("a's value is:" + a);// 220
        System.out.println("b's value is:" + b);// 110
    }
}

class Tank {
    int level;
}