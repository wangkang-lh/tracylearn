package test;
/*
 * 正整数A和正整数B 的最小公倍数是指 能被A和B整除的最小的正整数值，设计一个算法，求输入A和B的最小公倍数。
 * */

import java.util.Scanner;

public class 求最小公倍数 {
    public static int getResult(int m, int n) {
        if (m < n) {
            int temp = m;
            m = n;
            n = temp;
        }
        int k;
        while (n != 0) {
            k = m % n;
            m = n;
            n = k;
        }
        return m;
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        while (reader.hasNext()) {
            int m = reader.nextInt();
            int n = reader.nextInt();
            System.out.println(m * n / getResult(m, n));
        }
    }

}
