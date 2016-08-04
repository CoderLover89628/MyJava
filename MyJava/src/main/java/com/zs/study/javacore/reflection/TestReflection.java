package com.zs.study.javacore.reflection;

import java.lang.reflect.*;
import java.util.Scanner;
/**
 * Created by zhangsheng1 on 2016/7/15.
 * 反射
 */
public class TestReflection {

    public static void main(String[] args)
    {

        String name = args.length != 0 ? args[0] : getScanner();

        // 通过反射获取类的信息
        getClassInfo(name);

        // 使用反射进行计算
        doCalculate();
    }

    private static String getScanner()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a class name(e.g. javacore.util.Date):");
        return in.next();
    }

    /**
     * 使用反射进行计算
     */
    private static void doCalculate()
    {
        try {
            Method square = TestReflection.class.getMethod("square", double.class);
            Method sqrt = Math.class.getMethod("sqrt", double.class);
            printTable(1, 10, 10, square);
            printTable(1, 10, 10, sqrt);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    private static void printTable(int from, int to, int n, Method m)
    {
        System.out.println(m);

        double dx = (to - from)/(n - 1);

        for(double x = from; x <= to; x += dx) {
            try {
                double y = (Double) m.invoke(null, x);
                System.out.printf("%10.4f | %10.4f%n", x, y);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 平方
     * @param x 参数
     * @return 结果
     */
    private static double square(double x) {
        return x * x;

    }
    /**
     * 通过反射获取类的信息
     */
    private static void getClassInfo(String className)
    {
        try {
            Class classFind = Class.forName(className); //通过名字获得类
            Class superClass = classFind.getSuperclass();// 获取该类的父类
            String modifiers = Modifier.toString(classFind.getModifiers());
            if(modifiers.length() > 0) System.out.print("modifiers are :" + modifiers + " ");
            System.out.print("class " + className);
            if(superClass != null && superClass != Object.class) System.out.print(" extends" + superClass.getName());
            System.out.println("\n{\n");

            printConstructors(classFind);
            System.out.println();

            printMethods(classFind);
            System.out.println();

            printFields(classFind);

            System.out.println("}");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * 打印该类的成员变量
     *
     * @param classFind 类
     */
    private static void printFields(Class classFind)
    {
        Field[] fields = classFind.getDeclaredFields();
        for(Field f : fields) {
            Class type = f.getType();// int ,long ,double ....
            String name = f.getName();// 变量名
            System.out.print(" ");
            // private static final等描述
            String modifiers = Modifier.toString(f.getModifiers());
            if(modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.println(type.getName() + " " + name + ";");
        }
    }

    /**
     *  打印该类的方法
     *
     * @param classFind 类
     */
    private static void printMethods(Class classFind)
    {
        Method[] methods = classFind.getDeclaredMethods();
        for(Method m : methods) {
            Class retType = m.getReturnType();// 返回类型
            String name = m.getName();// 方法名

            System.out.print(" ");

            // private、public、protected
            String modifiers = Modifier.toString(m.getModifiers());
            if(modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.print(retType.getName() + " " +name + "(");

            Class[] paramTypes = m.getParameterTypes();// 方法参数
            for(int j = 0; j < paramTypes.length; j++) {
                if(j > 0) System.out.print(", ");
                System.out.print(paramTypes[j].getName());// 参数名
            }

            System.out.println(");");
        }
    }

    /**
     *  打印该类的构造器
     *
     * @param classFind 类
     */
    private static void printConstructors(Class classFind)
    {
        Constructor[] constructor = classFind.getDeclaredConstructors();
        for(Constructor c : constructor) {
            String name = c.getName();// 类名字
            System.out.print(" ");
            String modifiers = Modifier.toString(c.getModifiers());// private、public、protected
            if(modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.print(name + "(");

            Class[] paramTypes = c.getParameterTypes();// 参数类型
            for(int j = 0; j < paramTypes.length; j++) {
                if(j > 0) System.out.print(", ");
                System.out.print(paramTypes[j].getName());// 参数名
            }

            System.out.println(");");
        }
    }
}

