package com.yf.learning.concurrent;

/**
 * @Package com.yf.learning.concurrent
 * @Description: TODO
 * @author: jingh
 * @date 2018/9/19 14:49
 */
public class ThreadLocalTest {
    ThreadLocal<Long> longLocal = new ThreadLocal<Long>(){
        protected Long initialValue() {
            return Thread.currentThread().getId();
        }
    };
    ThreadLocal<String> stringLocal = new ThreadLocal<String>(){
        protected String initialValue() {
            return Thread.currentThread().getName();
        }
    };


    public void set() {
        longLocal.set(Thread.currentThread().getId());
        stringLocal.set(Thread.currentThread().getName());
    }

    public long getLong() {
        return longLocal.get();
    }

    public String getString() {
        return stringLocal.get();
    }

    /**
     * 1）实际的通过ThreadLocal创建的副本是存储在每个线程自己的threadLocals中的；

     　　2）为何threadLocals的类型ThreadLocalMap的键值为ThreadLocal对象
     ，因为每个线程中可有多个threadLocal变量，就像上面代码中的longLocal和stringLocal；

     　　3）在进行get之前，必须先set，否则会报空指针异常；

     　　    如果想在get之前不需要调用set就能正常访问的话，必须重写initialValue()方法。
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        final ThreadLocalTest test = new ThreadLocalTest();

//        test.set();
        System.out.println(test.getLong());
        System.out.println(test.getString());


        Thread thread1 = new Thread(){
            public void run() {
//                test.set();
                System.out.println(test.getLong());
                System.out.println(test.getString());
            };
        };
        thread1.start();
        thread1.join();

        System.out.println(test.getLong());
        System.out.println(test.getString());
    }
}
