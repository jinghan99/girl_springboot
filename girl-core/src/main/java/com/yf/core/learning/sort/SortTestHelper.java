package com.yf.core.learning.sort;

import java.lang.reflect.Method;

/**
 * @ClassName SortTestHelper
 * @Description
 * @Date 2018/4/11 14:21
 * @Author jinghan
 * @Version 1.0
 */
public class SortTestHelper {

    /**
     *@Description 交换数组元素
     *@Date 2018/4/11 15:06
     *@Author jinghan
     */
    public static void swap(Integer[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    // 生成有 n 个元素的随机数组,每个元素的随机范围为[rangeL, rangeR]
    public static Integer[] generateRandomArray(int n, int rangeL, int rangeR) {

        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++)
            arr[i] = new Integer((int) (Math.random() * (rangeR - rangeL + 1) + rangeL));
        return arr;
    }

    // 打印 arr 数组的所有内容
    public static void printArray(Object arr[]) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(' ');
        }
        System.out.println();
        return;
    }

    // 判断 arr 数组是否有序（从大到小排列）
    public static boolean isSorted(Integer[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }
    
    /**
     *@Description 对数组 随机交换 swapTimes 次数
     *@Date 2018/4/11 15:54
     *@Author jinghan
     * // 生成一个近乎有序的数组
    // 首先生成一个含有[0...n-1]的完全有序数组, 之后随机交换swapTimes对数据
    // swapTimes定义了数组的无序程度:
    // swapTimes == 0 时, 数组完全有序
    // swapTimes 越大, 数组越趋向于无序
     */ 
    public static Integer[] generateNearlyOrderedArray(Integer n, int swapTimes){
        Integer[] arr = new Integer[n];
        for(int i = 0 ; i < n ; i ++ ){
            arr[i] = i;
        }
        for( int i = 0 ; i < swapTimes ; i ++ ){
            int a = (int)(Math.random() * n);
            int b = (int)(Math.random() * n);
            int t = arr[a];
            arr[a] = arr[b];
            arr[b] = t;
        }
        return arr;
    }



    // 测试sortClassName所对应的排序算法排序arr数组所得到结果的正确性和算法运行时间
    public static void testSort(String sortClassName, String sortMethodByClass, Integer[] arr) {

        // 通过Java的反射机制，通过排序的类名，运行排序函数

        try {
            // 通过sortClassName获得排序函数的Class对象
            Class sortClass = Class.forName(sortClassName);

            // 通过排序函数的Class对象获得排序方法
            Method sortMethod = sortClass.getMethod(sortMethodByClass, new Class[] { Integer[].class });

            // 排序参数只有一个，是可比较数组arr
            Object[] params = new Object[] { arr };

            long startTime = System.currentTimeMillis();
            // 调用排序函数
            sortMethod.invoke(null, params);
            long endTime = System.currentTimeMillis();

            // 检验结果的正确性
            if (isSorted(arr)) {
                System.out.println("排序后的数组为有序数组");
            }

            // 输出测试的排序算法的运行时间
            System.out.println(sortClass.getSimpleName() +"."+sortMethodByClass+ " : " + (endTime - startTime) + "ms");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Integer[] copyIntegerArr(Integer[] arr){
        Integer[] newarr = arr.clone();
        return newarr;
    }
}
