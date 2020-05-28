package test;

import java.util.Scanner;

//输入一个int型的正整数，计算出该int型数据在内存中存储时1的个数。
public class 求int型正整数在内存中存储时1的个数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            String a = Integer.toBinaryString(num);
            int count = 0;
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) == '1') {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
