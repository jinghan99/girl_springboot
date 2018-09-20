package com.yf.learning.concurrent;

import java.util.concurrent.BlockingQueue;

/**
 * @Package com.ljg.concurrent
 * @Description: TODO
 * @author: jingh
 * @date 2018/9/19 10:19
 */
public class Producer implements Runnable {
    protected BlockingQueue queue = null;

    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }

    /**
     * 以下是 Producer 类。注意它在每次 put()
     * 调用时是如何休眠一秒钟的。这将导致 Consumer 在等待队列中对象的时候发生阻塞。
     */
    public void run() {
        try {
            queue.put("1");
            Thread.sleep(1000);
            queue.put("2");
            Thread.sleep(1000);
            queue.put("3");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
