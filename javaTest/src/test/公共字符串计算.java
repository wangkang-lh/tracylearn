package test;

/*
* 题目标题：

计算两个字符串的最大公共字串的长度，字符不区分大小写

详细描述：

接口说明

原型：

int getCommonStrLength(char * pFirstStr, char * pSecondStr);

输入参数：

     char * pFirstStr //第一个字符串

     char * pSecondStr//第二个字符串
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 公共字符串计算 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String string1 = "";
        while ((string1 = bufferedReader.readLine()) != null) {
            String string2 = bufferedReader.readLine();
            char[] str1 = string1.toCharArray();
            char[] str2 = string2.toCharArray();
            int[][] dp = new int[str1.length][str2.length];
            for (int i = 0; i < str1.length; i++) {
                if (str1[i] == str2[0]) {
                    dp[i][0] = 1;
                }
            }
            for (int j = 1; j < str2.length; j++) {
                if (str2[j] == str1[0]) {
                    dp[0][j] = 1;
                }
            }
            int max = 0;
            for (int i = 1; i < str1.length; i++) {
                for (int j = 1; j < str2.length; j++) {
                    if (str1[i] == str2[j]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }
            System.out.println(max);
        }
    }
}
