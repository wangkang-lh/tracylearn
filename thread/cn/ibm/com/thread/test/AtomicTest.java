package cn.ibm.com.thread.test;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.LongBinaryOperator;

public class AtomicTest {
    private int i = 0;
    private static Unsafe unsafe = null;
    private static long offset;

    static {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            unsafe = (Unsafe) theUnsafe.get(null);
            //获取指定修改的字段的偏移量
            Field field = AtomicTest.class.getDeclaredField("i");
            offset = unsafe.objectFieldOffset(field);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void add() {
        while (!unsafe.compareAndSwapInt(this, offset, i, i + 1)) {
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final AtomicTest ct = new AtomicTest();
        for (int i = 0; i < 6; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        ct.add();
                    }
                    System.out.println("done...");
                }
            }).start();
        }

        Thread.sleep(6000L);
        System.out.println(ct.i);

        LongBinaryOperator longBinaryOperator = new LongBinaryOperator() {
            @Override
            public long applyAsLong(long left, long right) {
                return left + right;
            }
        };
        LongAccumulator longAccumulator = new LongAccumulator(longBinaryOperator, 0);
        for (int i = 0; i < 3; i++) {
            longAccumulator.accumulate(1);
        }
        System.out.println("最后结果： " + longAccumulator.get());

        LongAdder lacount = new LongAdder();
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                long starttime = System.currentTimeMillis();
                while (System.currentTimeMillis() - starttime < 2000) { // 运行两秒
                    lacount.increment();
                }
                long endtime = System.currentTimeMillis();
            }).start();
        }
        Thread.sleep(3000);
        System.out.println("最终结果: " + lacount.sum());
    }
}
