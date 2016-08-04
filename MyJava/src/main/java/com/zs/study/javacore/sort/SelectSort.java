package com.zs.study.javacore.sort;

/**
 * 选择排序
 */
public class SelectSort {


    public static void main(String[] args)
    {

        int a[] = {1, 54, 6, 3, 78, 34, 12, 45};
        System.out.println("排序之前");

        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");

        System.out.println();
        System.out.println("排序之后");

        new SelectSort().selectSort(a);
    }

    /**
     * 选择排序
     *
     * @param args 数组
     * @return 排序后的数组
     */
    public int[] selectSort(int[] args)
    {

        int position = 0;
        for (int i = 0; i < args.length; i++) {

            int j = i + 1;
            position = i;
            int temp = args[i];
            for (; j < args.length; j++) {
                if (args[j] < temp) {
                    temp = args[j];
                    position = j;
                }
            }
            args[position] = args[i];
            args[i] = temp;
        }
        for (int i = 0; i < args.length; i++)
            System.out.print(args[i] + " ");
        return args;
    }

}
