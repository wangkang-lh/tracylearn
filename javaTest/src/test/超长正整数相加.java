package test;

/*
* 请设计一个算法完成两个超长正整数的加法。



接口说明




 *//*
 请设计一个算法完成两个超长正整数的加法。
 输入参数：
 String addend：加数
 String augend：被加数
 返回值：加法结果
 *//*

public String AddLongInteger(String addend, String augend)
        {
        *//*在这里实现功能*//*


        return null;
        }*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 超长正整数相加 {

    public static void main(String[] args) throws IOException {
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        String str1;
        while ((str1 = bReader.readLine()) != null) {
            String str2 = bReader.readLine();
            StringBuilder sb1 = new StringBuilder(str1);
            StringBuilder sb2 = new StringBuilder(str2);
            int len1 = sb1.length();
            int len2 = sb2.length();
            if (len1 > len2) {
                for (int i = 0; i < len1 - len2; i++)
                    sb2.insert(0, "0");
            } else {
                for (int i = 0; i < len2 - len1; i++)
                    sb1.insert(0, "0");
            }
            StringBuilder sb = new StringBuilder();
            int temp = 0;
            for (int i = sb1.length() - 1; i >= 0; i--) {
                int m = sb1.charAt(i) - '0';
                int n = sb2.charAt(i) - '0';
                int sum = m + n + temp;
                sb.insert(0, sum % 10);
                temp = sum / 10;
            }
            if (temp != 0)
                sb.insert(0, temp);
            System.out.println(sb.toString());

        }
    }

}

