package cn.ibm.com.thread.test;

import java.io.IOException;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

//需求：从一个文件中读取文件的内容
public class ThreadLocalTest {
    private static ThreadLocal<String> local = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                local.set("hello");
                System.out.println(local.get());
            }
        });
        thread1.start();
        thread1.join();
        Thread thread2 =  new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(local.get());
            }
        });
        thread2.start();
    }
}
