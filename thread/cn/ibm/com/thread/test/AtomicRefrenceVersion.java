package cn.ibm.com.thread.test;

import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.LockSupport;

public class AtomicRefrenceVersion {
    AtomicStampedReference<Node> top = new AtomicStampedReference<>(null, 0);
    //AtomicReference<Node> top = new AtomicReference<Node>();

    public void push(Node node) { // 入栈
        Node oldTop;
        int v;
        do {
            v = top.getStamp();
            oldTop = top.getReference();
            node.next = oldTop;
        }
        while (!top.compareAndSet(oldTop, node, v, v + 1)); // CAS 替换栈顶
    }


    // 出栈 -- 取出栈顶 ,为了演示ABA效果， 增加一个CAS操作的延时
    public Node pop(int time) {

        Node newTop;
        Node oldTop;
        int v;

        do {
            v = top.getStamp();
            oldTop = top.getReference();
            if (oldTop == null) {   //如果没有值，就返回null
                return null;
            }
            newTop = oldTop.next;
            if (time != 0) {    //模拟延时
                LockSupport.parkNanos(1000 * 1000 * time); // 休眠指定的时间
            }
        }
        while (!top.compareAndSet(oldTop, newTop, v, v + 1));     //将下一个节点设置为top
        return oldTop;      //将旧的Top作为值返回
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicRefrenceVersion stack = new AtomicRefrenceVersion();
        //ConcurrentStack stack = new ConcurrentStack();

        stack.push(new Node("B"));      //B入栈
        stack.push(new Node("A"));      //A入栈

        Thread thread1 = new Thread(() -> {
            Node node = stack.pop(800);
            System.out.println(Thread.currentThread().getName() + " " + node.toString());

            System.out.println("done...");
        });
        thread1.start();

        Thread thread2 = new Thread(() -> {
            LockSupport.parkNanos(1000 * 1000 * 300L);

            Node nodeA = stack.pop(0);      //取出A
            System.out.println(Thread.currentThread().getName() + " " + nodeA.toString());

            Node nodeB = stack.pop(0);      //取出B，之后B处于游离状态
            System.out.println(Thread.currentThread().getName() + " " + nodeB.toString());

            stack.push(new Node("D"));      //D入栈
            stack.push(new Node("C"));      //C入栈
            stack.push(nodeA);                    //A入栈

            System.out.println("done...");
        });
        thread2.start();

        LockSupport.parkNanos(1000 * 1000 * 1000 * 2L);


        System.out.println("开始遍历Stack：");
        Node node = null;
        while ((node = stack.pop(0)) != null) {
            System.out.println(node.value);
        }
    }
}
