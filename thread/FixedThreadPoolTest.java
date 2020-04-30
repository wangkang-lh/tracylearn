package cn.ibm.com.rabbitmqdemo.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

//手写线程池
//1.任务仓库
//2.工作队列，工作线程存放的集合
//3.工作线程，一个工作线程可以循环执行工作队列中的任务
//4.对外提供阻塞和非阻塞的提交方法
//5.线程池关闭
public class FixedThreadPoolTest {
    private LinkedBlockingQueue<Runnable> taskQueue = null;
    private List<WorkThread> workThreadList = null;
    private volatile boolean isRun = true;

    public FixedThreadPoolTest(int workSize, int taskSize) {
        this.taskQueue = new LinkedBlockingQueue<Runnable>(10);
        this.workThreadList = Collections.synchronizedList(new ArrayList<>(workSize));
        for (int i = 0; i < workSize; i++) {
            WorkThread workThread = new WorkThread(this);
            workThread.start();
            this.workThreadList.add(workThread);
        }
    }

    public static class WorkThread extends Thread {
        private FixedThreadPoolTest pool;

        public WorkThread(FixedThreadPoolTest pool) {
            this.pool = pool;
        }

        @Override
        public void run() {
            while (this.pool.isRun || this.pool.taskQueue.size() > 0) {
                try {
                    Runnable task = null;
                    if (this.pool.isRun) {
                        //阻塞
                        task = this.pool.taskQueue.take();
                    } else {
                        //非阻塞
                        task = this.pool.taskQueue.poll();
                    }
                    if (task != null) {
                        task.run();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void submit(Runnable runnable) throws InterruptedException {
        if (this.isRun) {
            this.taskQueue.put(runnable);
        }
    }

    public boolean submitNon(Runnable runnable) throws InterruptedException {
        if (this.isRun) {
            return this.taskQueue.offer(runnable);
        }
        return false;
    }

    public static void main(String[] args) throws InterruptedException {
        /*Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100000);
                    System.out.println("线程执行完毕");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("线程被中断，结束执行任务");
                }
            }
        });
        t.start();
        Thread.sleep(1000);
        System.out.println("线程状态中断前：" + t.getState());
        Thread.sleep(1000);
        t.interrupt();
        Thread.sleep(1000);
        System.out.println("线程状态中断后：" + t.getState());*/
        FixedThreadPoolTest test = new FixedThreadPoolTest(5, 10);
        for (int i = 0; i < 50; i++) {
            System.out.println("任务队列任务： " + test.taskQueue.size());
            System.out.println("任务队列剩余容量： " + test.taskQueue.remainingCapacity());
            test.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("正在工作");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("收到中断信号");
                    }
                    System.out.println("工作已完成");
                }
            });
            System.out.println("已经成功提交的任务数：" + (i + 1));
        }
        test.shutdown();
    }

    public void shutdown() {
        this.isRun = false;
        for (Thread thread : workThreadList) {
            if (thread.getState().equals(Thread.State.TIMED_WAITING) ||
                    thread.getState().equals(Thread.State.WAITING) ||
                    thread.getState().equals(Thread.State.BLOCKED)) {
                thread.interrupt();
            }
        }
    }
}
