package com.zs.study.javacore.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by zhangsheng1 on 2016/7/15.
 *
 */
public class TestProxy {

    public static void main(String[] args)
    {
        Object[] elements = new Object[100];

        for(int i = 0; i < elements.length; i++) {
            Integer value = i + 1;
            InvocationHandler handler = new TraceHandler(value);

            Object proxy = Proxy.newProxyInstance(null, new Class[]{Comparable.class}, handler);
            elements[i] = proxy;
        }

        Integer key = new Random().nextInt(elements.length) + 1;// ��elements���鳤��+1 ���һ��int���͵�����
        System.out.println("key is:" + key);

        for(int j = 0; j < elements.length; j++)
        {
            System.out.println(elements[j]);
        }

        int result = Arrays.binarySearch(elements, key);
        System.out.println(elements[result]);
        if(result >= 0) System.out.println(elements[result]);
    }
}

class TraceHandler implements InvocationHandler {

    private Object target;

    public TraceHandler(Object t){
        target = t;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {

        System.out.print(target);
        System.out.print("." + method.getName() + "(");

        if(args != null)
        {
            for(int i = 0; i < args.length; i++)
            {
                System.out.print(args[i]);
                if(i < args.length - 1) System.out.print(", ");
            }
        }

        System.out.print(")");
        return method.invoke(target, args);
    }

}