package cn.ibm.com.rabbitmqdemo.thread;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class SemaphoreImpl {
    private static int i = 1;
    private static List<Thread> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Semaphore semaphore = new Semaphore(10);

        CyclicBarrier cyclicBarrier = new CyclicBarrier(1000);
        while (i <= 1000) {
            Mytask mytask = new Mytask(i++, cyclicBarrier, semaphore);
            list.add(mytask);
            mytask.start();
        }
        System.in.read();
    }

    public static class Mytask extends Thread {
        private int count = 0;
        private CyclicBarrier cyclicBarrier = null;
        private Semaphore semaphore = null;

        public Mytask(int count, CyclicBarrier cyclicBarrier, Semaphore semaphore) {
            this.count = count;
            this.cyclicBarrier = cyclicBarrier;
            this.semaphore = semaphore;
            this.setDaemon(true);
        }

        @Override
        public void run() {
            try {
                cyclicBarrier.await();
                semaphore.acquire();
                System.out.println("我抢到了,我是第" + (this.count + 1) + "线程");
                Thread.sleep(2000);
                semaphore.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void stopAll() {
        list.stream().forEach(item -> {
            if (item.getState().equals(Thread.State.BLOCKED)
                    || item.getState().equals(Thread.State.WAITING)
                    || item.getState().equals(Thread.State.TIMED_WAITING)) {
                item.stop();
            }
        });
    }
}
