package test;

import java.util.Scanner;

//编写一个函数，计算字符串中含有的不同字符的个数。字符在ACSII码范围内(0~127)，换行表示结束符，不算在字符里。不在范围内的不作统计。
public class 字符个数统计 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            int len = getLen(s);
            System.out.println(len);
        }
    }

    public static int getLen(String s) {
        int[] arr = new int[128];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)] = 1;
        }
        int len = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                len++;
            }
        }
        return len;
    }
}
