package test;

import java.util.Scanner;

//题目描述：写出一个程序，接受一个由字母和数字组成的字符串，和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写。
public class 计算字符个数{
    public static void main(String[] args)
    {
        int count = 0;
        Scanner sc=new Scanner(System.in);
        String str = sc.nextLine();
        String br = sc.nextLine();

        String string1=str.toUpperCase();
        String br1=br.toUpperCase();

        char a = br1.charAt(0);

        for(int i=0;i<string1.length();i++)
        {
            if(string1.charAt(i)==a)
                count++;
        }
        System.out.println(count);

    }
}

