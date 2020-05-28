package test;


/**
 * 题目描述
 * 找出给定字符串中大写字符(即'A'-'Z')的个数
 * 接口说明
 * 原型：int CalcCapital(String str);
 * 返回值：int
 * <p>
 * <p>
 * 输入描述:
 * 输入一个String数据
 * 输出描述:
 * 输出string中大写字母的个数
 * 示例1
 * 输入
 * <p>
 * add123#$%#%#O
 * 输出
 * <p>
 * 1
 *
 * @author Administrator
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 统计大写字母个数 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while ((line = br.readLine()) != null) {
            System.out.println(CalcCapital(line));
        }
    }

    private static int CalcCapital(String line) {
        int sum = 0;
        for (int i = 0; i < line.length(); ++i) {
            if (line.charAt(i) >= 'A' && line.charAt(i) <= 'Z') {
                sum++;
            }
        }
        return sum;
    }

}
