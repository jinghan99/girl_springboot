package com.yf.learning.sort;


/**
 * @ClassName
 * @Description 排序算法
 * @Date 2018/4/11 11:17
 * @Author jinghan
 * @Version 1.0
 */
public class Sort {

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    /** 1
     *@Description Sort 选择排序 O（n^2）
     *@Date 2018/4/11 14:53
     *@Author jinghan
     */ 
    public static Integer[] selectionSort(Integer[]  arr) {

        int n = arr.length;
        for (int i = 0; i < n; i++) {
            // 寻找[i, n)区间里的最小值的索引
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            //最小值 与当前值 兑换
            swap(arr, i, minIndex);
        }
        return arr;
    }



    /** 2
     *@Description insertionSort 插入排序
     *@Date 2018/4/11 14:54
     *@Author jinghan
     */ 
    public static void insertionSort(Integer[]  arr){
        int n = arr.length;
        for(int i=1;i<n;i++){
            //将第0个元素标记为已排序
            //直接从第1个元素和第0个元素开始比较
            //若前一个元素大于后面元素 则交换位置
//            for(int j=i;j>0;j--){
//                if(arr[j-1] > arr[j]){
//                    swap(arr, j-1, j);
//                }
//            }
            //优化上方for 循环
//            for(int j=i;j>0 && arr[j-1] > arr[j];j--){
//                swap(arr, j-1, j);
//            }

            int e  = arr[i];
            int j;
            // j保存元素e应该插入的位置
            for(j=i;j>0 && arr[j-1] > e;j--){
                arr[j]=arr[j-1];
            }
            arr[j] =e;
        }
    }
//    public static void main(String args[]) {
//        Integer[]  arry = SortTestHelper.generateNearlyOrderedArray(10000,6);
//        Integer[] arr2 = Arrays.copyOf(arry, arry.length);
//        SortTestHelper.testSort("com.yf.learning.sort.Sort", "insertionSort",arry);
//
//        SortTestHelper.testSort("com.yf.learning.sort.Sort", "selectionSort",arr2);
//
//
//
//    }
}
