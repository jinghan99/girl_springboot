package com.yf.learning.concurrent;

import java.util.Random;

/**
 * @Package com.yf.learning.concurrent
 * @Description: TODO
 * @author: jingh
 * @date 2018/9/19 15:24
 */
public class ThreadLocalOne {

    private static ThreadLocal<String> threadData = new ThreadLocal<>();

    /**
     * @param args
     */
    public static void main(String[] args) {
//        WordThread thread1 = new WordThread(threadData);
//        WordThread thread2 = new WordThread(threadData);
//        thread1.start();
//        thread2.start();
//        System.out.println(Thread.currentThread().getName() + " 执行完毕");

    }
}

class WordThread extends Thread {
    private ThreadLocal<Integer> mThreadData;

    public WordThread(ThreadLocal<Integer> threadData) {
        this.mThreadData = threadData;
    } /* (non-Javadoc) * @see java.lang.Thread#run() */

    @Override
    public void run() {
        super.run();
        System.out.println("WordThread:" + Thread.currentThread().getName());
        int dataIn = new Random().nextInt(10);
        mThreadData.set(dataIn); // 获取数据 int dataOut = mThreadData.get(); System.out.println(dataOut); }

    }
}

