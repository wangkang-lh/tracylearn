package test;

import java.util.*;

/*
 * 给定一个正整数N代表火车数量，0<N<10，接下来输入火车入站的序列，一共N辆火车，每辆火车以数字1-9编号。要求以字典序排序输出火车出站的序列号
 * */
import java.util.*;

public class 火车进站 {
    private static Stack<String> stack = new Stack<String>();
    private static Stack<String> list = new Stack<String>();
    private static List<String> results = new ArrayList<String>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        process(str);
        sc.close();
    }

    public static void process(String str) {
        String[] trains = str.split(" ");
        for (int i = trains.length - 1; i >= 0; --i) {
            list.push(trains[i]);
        }
        foo("");
        Collections.sort(results);
        for (String result : results) {
            System.out.println(result);
        }
    }

    public static void foo(String out) {
        if (stack.isEmpty() && list.isEmpty()) {
            results.add(out.trim());
            return;
        }
        if (!stack.isEmpty()) {
            String str = stack.pop();
            foo(out + " " + str);
            stack.push(str);
        }
        if (!list.isEmpty()) {
            String str = list.pop();
            stack.push(str);
            foo(out);
            stack.pop();
            list.push(str);
        }
    }


}
