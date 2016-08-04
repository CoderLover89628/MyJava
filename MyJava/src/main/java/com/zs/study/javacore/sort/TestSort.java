package com.zs.study.javacore.sort;

import java.util.Arrays;

/**
 * Created by zhangsheng1 on 2016/7/15.
 *
 */
public class TestSort {

    public static void main(String[] args)
    {
        TestSort testSort = new TestSort();
        int[] arr = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62,
                99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51 };

        System.out.println("排序之前数组如下：");
        print(arr);

        testSort.bubbleSort(arr);// 冒泡排序
    }

    /**
     * 冒泡排序
     *
     * @param arr 数组
     * @return 排序后数组
     */
    private int[] bubbleSort(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.println();
        System.out.println("排序之后数组如下：");
        print(arr);
        return arr;
    }

    /**
     * 堆排序
     * @param a 数组
     * @return 排序后的数组
     */
    public int[] heapSort(int[] a) {
        int arrayLength = a.length;

        // 循环建堆
        for (int i = 0; i < arrayLength - 1; i++) {
            // 建堆
            buildMaxHeap(a, arrayLength - 1 - i);

            // 交换堆顶和最后一个元素
            swap(a, 0, arrayLength - 1 - i);
            System.out.println(Arrays.toString(a));
        }

        System.out.println();
        System.out.println("排序之后数组如下：");
        print(a);
        return a;
    }

    private void swap(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    // 对data数组从0到lastIndex建大顶堆
    private void buildMaxHeap(int[] data, int lastIndex)
    {
        // 从lastIndex处节点(最后一个节点)的父节点开始
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            // k保存正在判断的节点
            int k = i;
            // 如果当前k节点的子节点存在
            while (k * 2 + 1 <= lastIndex) {
                // k节点的左子节点的索引
                int biggerIndex = 2 * k + 1;
                // 如果biggerIndex小于lastIndex，即biggerIndex+1代表的k节点的右子节点存在
                if (biggerIndex < lastIndex) {
                    // 若果右子节点的值较大
                    if (data[biggerIndex] < data[biggerIndex + 1]) {
                        // biggerIndex总是记录较大子节点的索引
                        biggerIndex++;
                    }
                }
                // 如果k节点的值小于其较大的子节点的值
                if (data[k] < data[biggerIndex]) {
                    // 交换他们
                    swap(data, k, biggerIndex);
                    // 将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值
                    k = biggerIndex;
                } else {
                    break;
                }
            }
        }
    }

    /**
     *  直接插入排序
     *
     * @param args 数组
     * @return 排序后数组
     */
    public int[] insertSort(int[] args) {
        int temp = 0;
        for (int i = 1; i < args.length; i++) {
            int j = i - 1;
            temp = args[i];
            for (; j >= 0 && temp < args[j]; j--) {
                args[j + 1] = args[j]; // 将大于temp的值整体后移一个单位
            }
            args[j + 1] = temp;
        }
        System.out.println();
        System.out.println("排序之后数组如下：");
        print(args);
        return args;

    }


    /**
     * 归并排序
     *
     * @param a 数组
     * @return 排序后的数组
     */
    public int[] mergingSort(int[] a) {
        sort(a, 0, a.length - 1);
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        return a;

    }

    public void sort(int[] data, int left, int right) {
        if (left < right) {
            // 找出中间索引
            int center = (left + right) / 2;
            // 对左边数组进行递归
            sort(data, left, center);
            // 对右边数组进行递归
            sort(data, center + 1, right);
            // 合并
            merge(data, left, center, right);
        }
    }

    public void merge(int[] data, int left, int center, int right) {
        int[] tmpArr = new int[data.length];
        int mid = center + 1;
        // third记录中间数组的索引
        int third = left;
        int tmp = left;
        while (left <= center && mid <= right) {

            // 从两个数组中取出最小的放入中间数组
            if (data[left] <= data[mid]) {
                tmpArr[third++] = data[left++];
            } else {
                tmpArr[third++] = data[mid++];
            }
        }
        // 剩余部分依次放入中间数组
        while (mid <= right) {
            tmpArr[third++] = data[mid++];
        }
        while (left <= center) {
            tmpArr[third++] = data[left++];
        }
        // 将中间数组中的内容复制回原数组
        while (tmp <= right) {
            data[tmp] = tmpArr[tmp++];
        }
        System.out.println(Arrays.toString(data));
    }

    /**
     * 打印数组
     * @param arr 数组
     */
    private static void print(int[] arr)
    {
        for (int i : arr)
            System.out.print(i + " ");
    }
}
