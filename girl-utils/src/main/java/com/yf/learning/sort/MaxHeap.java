package com.yf.learning.sort;

/**
 * @Package com.yf.learning.sort
 * @Description: TODO
 * @author: jingh
 * @date 2018/11/23 22:10
 */
public class MaxHeap<Item> {
    private Item[] data;
    private int count;

    public MaxHeap(int count) {
        this.data = (Item[]) new Object[count +1];
        this.count = 0;
    }
    public int size(){
        return count;
    }
    public boolean isEmpty(){
        return count == 0;
    }

    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<>(100);
        System.out.println(maxHeap.size());
    }
}
