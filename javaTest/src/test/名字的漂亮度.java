package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
* 给出一个名字，该名字有26个字符串组成，定义这个字符串的“漂亮度”是其所有字母“漂亮度”的总和。
每个字母都有一个“漂亮度”，范围在1到26之间。没有任何两个字母拥有相同的“漂亮度”。字母忽略大小写。
给出多个名字，计算每个名字最大可能的“漂亮度”。
* */
public class 名字的漂亮度 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            int n = Integer.parseInt(str);
            for (int i = 0; i < n; i++) {
                int[] repeat = new int[26];
                String s = br.readLine();
                for (int j = 0; j < s.length(); j++) {
                    repeat[s.charAt(j) - 'a']++;
                }
                Arrays.sort(repeat);
                int k = 26;
                int value = 0;
                for (int j = repeat.length - 1; j >= 0; j--) {
                    if (repeat[j] == 0) {
                        break;
                    }
                    value += repeat[j] * k;
                    k--;
                }
                System.out.println(value);
            }

        }
    }
}
