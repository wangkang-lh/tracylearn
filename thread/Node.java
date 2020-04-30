package cn.ibm.com.rabbitmqdemo.thread;

public class Node {
    public final String value;
    public Node next;

    public Node(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "value=" + value;
    }
}
