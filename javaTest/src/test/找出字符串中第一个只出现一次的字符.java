package test;

/*
 * 找出字符串中第一个只出现一次的字符
 * */


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class 找出字符串中第一个只出现一次的字符 {
    public static void main(String[] args) throws IOException {
        BufferedReader bfd = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = bfd.readLine()) != null) {
            int[] arrs = new int[128];
            for (int i = 0; i < str.length(); i++) {
                arrs[str.charAt(i)]++;
            }
            for (int i = 0; i < str.length(); i++) {
                if (arrs[str.charAt(i)] == 1) {
                    System.out.println(str.charAt(i));
                    break;
                }
                if (i == str.length() - 1) {
                    System.out.println(-1);
                }
            }
        }
    }
}

