package test;

/*
* 题目说明

蛇形矩阵是由1开始的自然数依次排列成的一个矩阵上三角形。







样例输入

5

样例输出

1 3 6 10 15

2 5 9 14

4 8 13

7 12

11

接口说明

原型

void GetResult(int Num, char * pResult);

输入参数：

        int Num：输入的正整数N

输出参数：

        int * pResult：指向存放蛇形矩阵的字符串指针

        指针指向的内存区域保证有效

返回值：

        void
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 蛇形矩阵 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            int num = Integer.parseInt(line);
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= num; i++) {
                int start = i * (i - 1) / 2 + 1;
                int step = i + 1;
                for (int j = 1; j <= num - i + 1; j++) {
                    sb.append(start).append(" ");
                    start += step;
                    step++;
                }
                sb.setCharAt(sb.length() - 1, '\n');
            }
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb.toString());
        }
    }
}

