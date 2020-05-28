package test;


import java.io.*;
import java.util.Arrays;
import java.io.IOException;

//给定n个字符串，请对n个字符串按照字典序排列
public class 字串的连接最长路径查找 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String[] s = new String[num];
        for (int i = 0; i < num; i++) {
            s[i] = br.readLine();
        }
        Arrays.sort(s);
        for (int j = 0; j < num; j++) {
            System.out.println(s[j]);
        }
    }
}