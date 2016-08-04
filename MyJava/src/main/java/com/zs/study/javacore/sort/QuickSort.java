package com.zs.study.javacore.sort;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {


    public static void main(String[] args)
    {

        int[] a = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62,
                99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};

        System.out.println("排序之前");
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");

        System.out.println();
        System.out.println("排序之后");

        new QuickSort().quickSort(a);
    }

    /**
     * 快速排序
     *
     * @param a 数组
     * @return 排序后数组
     */
    private int[] quickSort(int[] a)
    {
        if (a.length > 0) {// 查看数组是否为空
            _quickSort(a, 0, a.length - 1);
        }

        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        return a;
    }

    private void _quickSort(int[] list, int low, int high)
    {
        if (low < high) {
            int middle = getMiddle(list, low, high); // 将list数组进行一分为二
            _quickSort(list, low, middle - 1); // 对低字表进行递归排序
            _quickSort(list, middle + 1, high); // 对高字表进行递归排序
        }
    }

    private int getMiddle(int[] list, int low, int high)
    {
        int tmp = list[low]; // 数组的第一个作为中轴
        while (low < high) {
            while (low < high && list[high] >= tmp) {

                high--;
            }
            list[low] = list[high]; // 比中轴小的记录移到低端
            while (low < high && list[low] <= tmp) {
                low++;
            }
            list[high] = list[low]; // 比中轴大的记录移到高端
            System.out.println(Arrays.toString(list));
        }
        list[low] = tmp; // 中轴记录到尾
        return low; // 返回中轴的位置
    }
}
