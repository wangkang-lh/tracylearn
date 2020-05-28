package test;

/*
* 功能: 求一个byte数字对应的二进制数字中1的最大连续数，例如3的二进制为00000011，最大连续2个1

输入: 一个byte型的数字

输出: 无

返回: 对应的二进制数字中1的最大连续数
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 求最大连续bit数 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while ((line = br.readLine()) != null) {
            int n = Integer.parseInt(line);
            getOneNumber(n);
        }
    }

    public static void getOneNumber(int n) {
        char[] chs = Integer.toBinaryString(n).toCharArray();
        int count = 0;
        for (int i = 0; i < chs.length; ) {
            while (i < chs.length && chs[i] != '1') {
                i++;
            }
            int j = i;
            while (j < chs.length && chs[j] == '1') {
                j++;
                if ((j - i) > count) {
                    count = j - i;
                }
            }
            i = j;
        }
        System.out.println(count);
    }
}