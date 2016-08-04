package com.zs.study.javacore.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by zhangsheng1 on 2016/7/15.
 *
 */
public class TestArray {

    public static void main(String[] args)
    {
        TestArray ta = new TestArray();
        ta.sort();
        ta.arrReverse();
        ta.getMaxAndMinValue();
        ta.arrCombine();
        ta.arrFill();
        ta.arrExtend();
    }

    /**
     * 数组排序
     */
    private void sort()
    {
        int array[] = {2, 5, -2, 6, -3, 8, 0, -7, -9, 4};
        Arrays.sort(array);
        printArray("数组长度为：", array);
        int index = Arrays.binarySearch(array, 2);
        System.out.println("数组中2的位置是第" + index + "位");
    }

    /**
     * 数组反转
     */
    private void arrReverse()
    {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D");
        arrayList.add("E");
        System.out.println("原数组为：" + arrayList);
        Collections.reverse(arrayList);
        System.out.println("反转之后：" + arrayList);
    }

    /**
     * 获取数组最大和最小值
     */
    private void getMaxAndMinValue()
    {
        Integer[] numbers = {8, 2, 7, 1, 4, 9, 5};
        int min = Collections.min(Arrays.asList(numbers));
        int max = Collections.max(Arrays.asList(numbers));
        System.out.println("min value in array is: " + min);
        System.out.println("max value in array is: " + max);
    }

    /**
     * 数组去重合并
     */
    private void arrCombine()
    {
        String a[] = {"A", "E", "I"};
        String b[] = {"O", "U", "E"};
        List<String> list = new ArrayList<String>(Arrays.asList(a));

        list.removeAll(Arrays.asList(b));
        list.addAll(Arrays.asList(b));
        Object[] c = list.toArray();
        System.out.println(Arrays.toString(c));

    }

    /**
     * 数组填充
     */
    private void arrFill()
    {
        int array[] = new int[6];
        Arrays.fill(array, 100);// 初始化数组全部填充100，即有六个100

        for (int i : array) {
            System.out.println(i);
        }

        System.out.println("==================================");

        Arrays.fill(array, 3, 6, 50);// 数组从下标3开始到6填充50,截取方式是左包有开
        for (int i : array) {
            System.out.println(i);
        }
    }

    /**
     * 数组扩展
     */
    private void arrExtend()
    {
        String[] names = new String[]{"A", "B", "C"};
        String[] extended = new String[5];
        extended[3] = "D";
        extended[4] = "E";

        // 把names数组从数组下标1开始到最后
        // 拷贝到extended数组从下标0开始到names数组的长度减1
        System.arraycopy(names, 1, extended, 0, names.length - 1);
        for (String str : extended) {
            System.out.println(str);
        }
    }

    /**
     * 打印
     *
     * @param message 信息
     * @param array   数组
     */
    private void printArray(String message, int array[])
    {
        System.out.println(message + ": [length: " + array.length + "]");
        for (int i = 0; i < array.length; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(array[i]);
        }
        System.out.println();
    }
}
