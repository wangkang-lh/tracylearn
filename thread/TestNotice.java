package cn.ibm.com.rabbitmqdemo.thread;

import java.util.concurrent.locks.LockSupport;

//死锁现象
public class TestNotice {
    private static String obj = new String("123");

    public static void main(String[] args) throws InterruptedException {
        TestNotice test = new TestNotice();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("开始进入挂起");
                synchronized (obj){
                    LockSupport.park();
                }
                System.out.println("结束挂起");
            }
        });
        thread.start();
        Thread.sleep(4000);
        synchronized (obj) {
            System.out.println("开始进入唤醒");
            LockSupport.unpark(thread);
        }
    }
}
