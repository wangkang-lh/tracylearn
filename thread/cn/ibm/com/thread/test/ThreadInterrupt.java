package cn.ibm.com.thread.test;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.LockSupport;

public class ThreadInterrupt {
    public static void main(String[] args) throws InterruptedException {
        /*Thread testThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    LockSupport.park();
                    System.out.println("here i am...");
                }
            }
        });

        testThread.start();
        Thread.sleep(1000L);
        testThread.interrupt();
        System.out.println("main end");*/

        Thread testThread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        System.out.println("runing...");
                        Thread.sleep(1000L);
                        System.out.println("fasdfads");
                    } catch (InterruptedException e) {
                        //e.printStackTrace();
                        System.out.println("当前子线程中断状态： " + Thread.currentThread().isInterrupted());
                        break;
                    }
                }
            }
        };
        testThread.start();


        Thread.sleep(1000);
        testThread.interrupt();
        Map<Thread, String> map = new HashMap<>();
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < countDownLatch.getCount(); i++) {
            Thread thread = new Thread(new FutureTask<String>(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    map.put(Thread.currentThread(), "I'm here");
                    countDownLatch.countDown();
                    //return "I'm here";
                    return null;
                }
            }));
            thread.start();

        }
        countDownLatch.await();
        map.values().stream().forEach(item -> {
            System.out.println(item.toString());
        });
    }
}
