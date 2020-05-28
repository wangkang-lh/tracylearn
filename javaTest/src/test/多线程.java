package test;

/*
问题描述：有4个线程和1个公共的字符数组。线程1的功能就是向数组输出A，线程2的功能就是向字符输出B，线程3的功能就是向数组输出C，线程4的功能就是向数组输出D。要求按顺序向数组赋值ABCDABCDABCD，ABCD的个数由线程函数1的参数指定。[注：C语言选手可使用WINDOWS SDK库函数]
接口说明：
void init();  //初始化函数
void Release(); //资源释放函数
unsignedint__stdcall ThreadFun1(PVOID pM)  ; //线程函数1，传入一个int类型的指针[取值范围：1 – 250，测试用例保证]，用于初始化输出A次数，资源需要线程释放
unsignedint__stdcall ThreadFun2(PVOID pM)  ;//线程函数2，无参数传入
unsignedint__stdcall ThreadFun3(PVOID pM)  ;//线程函数3，无参数传入
Unsigned int __stdcall ThreadFunc4(PVOID pM);//线程函数4，无参数传入
char  g_write[1032]; //线程1,2,3,4按顺序向该数组赋值。不用考虑数组是否越界，测试用例保证
* */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class 多线程 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while ((str = br.readLine()) != null) {
            int n = Integer.parseInt(str);
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < n; i++) {
                sb.append("ABCD");
            }
            System.out.println(sb.toString());
        }
    }
}



/*import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MyThreadPrinter2 implements Runnable {

    private String name;
    private Object prev;
    private Object self;
    private int count;
    private MyThreadPrinter2(String name, Object prev, Object self, int count) {
        this.name = name;
        this.prev = prev;
        this.self = self;
        this.count = count;
    }
    @Override
    public void run() {
        // int count = 10;
        while (count > 0) {
            synchronized (prev) {
                synchronized (self) {
                    System.out.print(name);
                    count--;
                    self.notify();
                }
                try {
                    prev.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        Object d = new Object();
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        int count = Integer.valueOf(br.readLine());
        MyThreadPrinter2 pa = new MyThreadPrinter2("A", d, a, count);
        MyThreadPrinter2 pb = new MyThreadPrinter2("B", a, b, count);
        MyThreadPrinter2 pc = new MyThreadPrinter2("C", b, c, count);
        MyThreadPrinter2 pd = new MyThreadPrinter2("D", c, d, count);

        new Thread(pa).start();
        Thread.sleep(100); // 确保按顺序A、B、C执行
        new Thread(pb).start();
        Thread.sleep(100);
        new Thread(pc).start();
        Thread.sleep(100);
        new Thread(pd).start();
    }
}*/
