package cn.ibm.com.rabbitmqdemo.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadPool {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService pool1 =  Executors.newFixedThreadPool(10);
        List<Callable<String>> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(new Task(++i));
        }
        List<Future<String>> resultList = pool1.invokeAll(list);
        for (Future<String> item : resultList) {
            System.out.println(item.get());
        }
        //同步队列作为工作线程 test
        ThreadPoolExecutor pool2 = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 10, TimeUnit.SECONDS, new SynchronousQueue<>());
        for (int i = 0; i < 10; i++) {
            pool2.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("hello");
                }
            });
        }
        while (true) {
            Thread.sleep(1000);
            System.out.println("线程数量：" + pool2.getPoolSize());
        }
    }
}

class Task implements Callable<String> {
    private int count = 0;

    public Task(int count) {
        this.count = count;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(100);
        return "hello, tracy" + this.count;
    }
}
