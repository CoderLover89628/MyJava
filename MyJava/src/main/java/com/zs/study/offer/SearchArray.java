package com.zs.study.offer;

/**
 * 二维数组查找
 *
 * @author zhangsheng1
 * @version V1.0.0
 *          Date 2016-10-28 14:22
 * @class com.zs.study.offer.SearchArray
 * @see
 */
public class SearchArray {

    public static void main(String[] args)
    {
        int[][] a = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(find(a,7));
        System.out.println(findByMy(a,7));
    }

    /**
     * 二维数组的查找
     *
     * @param a 已知数组
     * @param num 待查数字
     * @return true or false
     */
    private static boolean find(int[][] a, int num)
    {
        boolean flag = false;
        int rows = a.length;
        int columns = a[0].length;
        int row = 0;
        int column = columns - 1;
        int count = 0;
        while (row < rows && column >= 0) {
            count++;
            if (a[row][column] == num){
                flag = true;
                break;
            } else if (a[row][column] > num) {
                column--;
            } else {
                row++;
            }
        }
        System.out.println("search count is:" +count);
        return flag;
    }

    /**
     * 搜索二维数组
     * @param arr 已知数组
     * @param num 待查数字
     * @return true or false
     */
    private static boolean findByMy(int[][] arr, int num) {
        boolean flag = false;

        return flag;
    }
}
