package test;

import java.util.Scanner;

public class 查找输入整数二进制中1的个数 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            int num = input.nextInt();
            int count = findNumberOf1(num);
            System.out.println(count);
        }
    }

    public static int findNumberOf1(int num) {
        int count = 0;
        String str = Integer.toBinaryString(num);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }
}
