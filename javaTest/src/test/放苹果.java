package test;



/*
* 题目描述

把M个同样的苹果放在N个同样的盘子里，允许有的盘子空着不放，问共有多少种不同的分法？（用K表示）5，1，1和1，5，1 是同一种分法。


输入

每个用例包含二个整数M和N。0<=m<=10，1<=n<=10。


样例输入

7 3


样例输出

8
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 放苹果 {
    public static void main(String[] args) throws IOException {
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = bReader.readLine()) != null) {
            String[] strs = str.split(" ");
            int m = Integer.parseInt(strs[0]);
            int n = Integer.parseInt(strs[1]);
            System.out.println(getResult(m, n));
        }
    }

    private static int getResult(int m, int n) {
        if ((m == 0) || (n == 1))
            return 1;
        if (m < n)
            return getResult(m, m);
        return getResult(m, n - 1) + getResult(m - n, n);
    }

}
