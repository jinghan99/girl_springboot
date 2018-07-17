package com.yf.learning.sortTest;

import com.yf.learning.sort.SortTestHelper;

import java.util.Arrays;

/**
 * @ClassName MergeSortTest
 * @Description
 * @Date 2018/7/3 10:48
 * @Author jinghan
 * @Version 1.0
 */
public class MergeSortTest {

//    public static void main(String args[]) {
//        Integer[]  arry = SortTestHelper.generateNearlyOrderedArray(10000,2);
//        Integer[] arr2 = Arrays.copyOf(arry, arry.length);
//        SortTestHelper.testSort("com.yf.learning.sortTest.MergeSortTest", "sort",arr2);
//    }

    //外调借口
    public static void sort(Comparable[] arr) {
        int n = arr.length;
        sort(arr, 0, n - 1);
    }


    //递归循环
    private static void sort(Comparable[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merage(arr, l, mid, r);
    }

    private static void merage(Comparable[] arr, int l, int mid, int r) {

        Comparable aux[] = Arrays.copyOfRange(arr, l, r + 1);

        int i = l;//左边起始点
        int j = mid + 1;//右边起始点

        for (int k = l; k <= r; k++) {
            //若左边 已大于 mid 说明 已经遍历完左边
            if (i > mid) {
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {//右边的大于 边界 则右边已经遍历完 只需为左边移动
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l].compareTo(aux[j - l]) < 0) {//右边的大于左边的 先移动小的
                arr[k] = aux[i-l];
                i++;
            }else{
                arr[k] = aux[j-l];
                j++;
            }
        }
    }
}
