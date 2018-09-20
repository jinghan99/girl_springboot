package com.yf.learning.concurrent;

import java.util.concurrent.BlockingQueue;

/**
 * @Package com.ljg.concurrent
 * @Description: TODO
 * @author: jingh
 * @date 2018/9/19 10:21
 */
public class Consumer implements Runnable {
    protected BlockingQueue queue = null;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    /**
     * 以下是 Consumer 类。它只是把对象从队列中抽取出来，然后将它们打印到 System.out。
     */
    public void run() {
        try {
            System.out.println(queue.take());
            System.out.println(queue.take());
            System.out.println(queue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
