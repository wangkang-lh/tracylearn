package test;

/*
* 验证尼科彻斯定理，即：任何一个整数m的立方都可以写成m个连续奇数之和。

例如：

1^3=1

2^3=3+5

3^3=7+9+11

4^3=13+15+17+19
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 尼科彻斯定理 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null && str.trim() != null) {
            int num = Integer.parseInt(str);
            int total = 0;
            for (int i = 1; i <= num; i++) {
                total = total + i;
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < num; j++) {
                sb.append(total * 2 - 2 * (num - j) + 1);
                if (j != num - 1)
                    sb.append("+");
            }
            System.out.println(sb.toString());
        }
    }
}