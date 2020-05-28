package test;

import java.util.Scanner;

//题目描述 计算字符串最后一个单词的长度，单词以空格隔开。
public class 字符串最后一个单词的长度 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s="";
        while(input.hasNextLine()){
            s=input.nextLine();
            String[] split = s.split(" ");
            int n =split[split.length-1].length();
            System.out.println(n);
        }
    }
}
