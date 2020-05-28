package test;

import java.util.Scanner;

/*
* 将一个字符串str的内容颠倒过来，并输出。str的长度不超过100个字符。 如：输入“I am a student”，输出“tneduts a ma I”。
* */
public class 字符逆序 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.nextLine();
            byte[] b = s.getBytes();
            for (int i = b.length-1; i >= 0; i--) {
                System.out.print((char)b[i]);
            }
        }
    }
}