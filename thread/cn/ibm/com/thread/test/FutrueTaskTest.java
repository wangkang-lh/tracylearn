package cn.ibm.com.thread.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FutrueTaskTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<FutureTask<String>> list = new ArrayList<>();
        FutureTask<String> task = new FutureTask<String>(new Callable() {
            @Override
            public String call() throws Exception {
                Thread.sleep(10000);
                return "I'm here";
            }
        });
        for (int i = 0; i < 10; i++) {
            list.add(task);
            new Thread(task).start();
        }
        for (FutureTask<String> item : list) {
            System.out.println("获取结果： " + item.get());
        }
    }
}
