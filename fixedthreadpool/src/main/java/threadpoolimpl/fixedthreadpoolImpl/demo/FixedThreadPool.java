package threadpoolimpl.fixedthreadpoolImpl.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Tracy
 */
public class FixedThreadPool {
    //close or open
    private boolean isShutDown = false;
    //before the start
    //1、Task Queue
    private LinkedBlockingQueue<Thread> queue;
    //2、Collection of worker threads
    private List<Thread> threadWorkList;

    //3、work thread
    public static class WorkThread extends Thread {
        private FixedThreadPool fixedThreadPool;

        public WorkThread(FixedThreadPool pool) {
            this.fixedThreadPool = pool;
        }

        @Override
        public void run() {
            while (!this.fixedThreadPool.isShutDown || this.fixedThreadPool.queue.size() > 0) {
                Thread task = null;
                try {
                    if (!this.fixedThreadPool.isShutDown)
                        task = this.fixedThreadPool.queue.take();
                    else
                        task = this.fixedThreadPool.queue.poll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (task != null) {
                    task.run();
                }
            }
        }
    }

    //4 init thread pool
    public FixedThreadPool(int poolSize, int queueSize) {
        if (poolSize <= 0 || queueSize <= 0) {
            throw new IllegalArgumentException("illegal parameter");
        }
        this.threadWorkList = Collections.synchronizedList(new ArrayList<>(poolSize));
        this.queue = new LinkedBlockingQueue<>(queueSize);
        for (int i = 0; i < poolSize; i++) {
            WorkThread workThread = new WorkThread(this);
            workThread.start();
            this.threadWorkList.add(workThread);
        }
    }

    //5.1 non- block submit
    public boolean nonBlockSubmit(Thread thread) {
        if (this.isShutDown = false) {
            return false;
        }
        return this.queue.offer(thread);
    }

    //5.2 block submit
    public boolean blockSubmit(Thread thread) {
        try {
            if (this.isShutDown = false) {
                return false;
            }
            this.queue.put(thread);
            return true;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     *   //6  shutdown pool
     *     //a. Forbid to submit tasks to this queue
     *     //b. Waiting for tasks in the warehouse to execute, forbidding submission of new tasks
     *     //c. When it's closed, there's no need to block the next mission.
     *     //d. When closed, blocked/waiting threads are forced to interrupt
     * */
    public void shutdown() {
        this.isShutDown = true;
        for (Thread thread : this.threadWorkList) {
            if (thread.getState().equals(Thread.State.BLOCKED) || thread.getState().equals(Thread.State.WAITING)
                    || thread.getState().equals(Thread.State.TIMED_WAITING)) {
                thread.interrupt();
            }
        }
    }
}
