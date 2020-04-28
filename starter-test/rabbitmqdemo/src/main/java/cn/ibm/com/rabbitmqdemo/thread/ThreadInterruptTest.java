package cn.ibm.com.rabbitmqdemo.thread;

public class ThreadInterruptTest {
    public static void main(String[] args) throws InterruptedException {
        MythreadTest test = new MythreadTest();
        test.start();
        Thread.sleep(1000);
        //test.stop(); 会引起线程安全
        test.interrupt();
        //flag的标志位
        while (test.isAlive()) {

        }
        test.print();
    }
}

class MythreadTest extends Thread {
    private int i = 0, j = 0;
    public volatile boolean isRun = true;

    @Override
    public void run() {
        synchronized (this) {
            while (isRun) {
                i++;
                try {
                    Thread.sleep(10000);//time_waiting/waiting
                } catch (InterruptedException e) {
                    //捕获异常优雅处理线程终止
                    System.out.println("中断信号");
                    //isRun = false;
                }
                j++;
                System.out.println("中断状态：" + Thread.currentThread().interrupted());
            }
        }
    }

    public void print() {
        System.out.println("i = " + i + ", j =" + j);
    }
}
