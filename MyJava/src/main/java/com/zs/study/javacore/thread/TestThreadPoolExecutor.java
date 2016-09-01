package com.zs.study.javacore.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhangsheng1 on 2016/7/15.
 * 为什么要用线程池:

 1.减少了创建和销毁线程的次数，每个工作线程都可以被重复利用，可执行多个任务。

 2.可以根据系统的承受能力，调整线程池中工作线线程的数目，防止因为消耗过多的内存，
   而把服务器累趴下(每个线程需要大约1MB内存，线程开的越多，消耗的内存也就越大，
   最后死机)。

  Java里面线程池的顶级接口是Executor，但是严格意义上讲Executor并不是一个线程池，
  而只是一个执行线程的工具。真正的线程池接口是ExecutorService。
 *
 */
public class TestThreadPoolExecutor {

    public static void main(String[] args)
    {
        newCachedThreadPoll();

        newFixedThreadPool();

        newScheduledThreadPool();

        newSingleThreadExecutor();
    }

    /**
     * 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，
     * 保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
     * 如果这个唯一的线程因为异常结束，那么会有一个新的线程来替代它
     */
    private static void newSingleThreadExecutor() {
        ExecutorService singleThreadExecutor = Executors
                .newSingleThreadExecutor();
        // for (int i = 0; i < 10; i++) {
        // final int index = i;
        // singleThreadExecutor.execute(new Runnable() {
        // public void run() {
        // try {
        // System.out.println(index);
        // Thread.sleep(2000);
        // } catch (InterruptedException e) {
        // e.printStackTrace();
        // }
        // }
        // });
        // }

        for (int i = 0; i < 100; i++) {
            final int index = i;
            singleThreadExecutor.execute(new Runnable() {
                public void run() {
                    try {
                        while (true) {
                            System.out.println(index);
                            Thread.sleep(10 * 1000);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 创建一个定长线程池，支持定时及周期性任务执行
     */
    private static void newScheduledThreadPool() {
        ScheduledExecutorService scheduledThreadPool = Executors
                .newScheduledThreadPool(5);
        scheduledThreadPool.schedule(new Runnable() {
            public void run() {
                System.out.println("delay 3 seconds");
            }
        }, 3, TimeUnit.SECONDS);
    }

    /**
     * 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待
     */
    private static void newFixedThreadPool() {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int index = i;
            fixedThreadPool.execute(new Runnable() {
                public void run() {
                    try {
                        System.out.println(index);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    /**
     * 创建一个可缓存线程池，如果线程池长度超过处理需要，
     * 可灵活回收空闲线程，若无可回收，则新建线程
     */
    private static void newCachedThreadPoll() {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            try {
                Thread.sleep(index * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cachedThreadPool.execute(new Runnable() {
                public void run() {
                    System.out.println(index);
                }
            });
        }
    }
}
