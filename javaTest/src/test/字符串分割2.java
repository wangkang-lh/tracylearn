package test;

/*
*
* 题目描述
连续输入字符串(输出次数为N,字符串长度小于100)，请按长度为8拆分每个字符串后输出到新的字符串数组，

长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。

首先输入一个整数，为要输入的字符串个数。

例如：

输入：2

      abc

      12345789

输出：abc00000

      12345678

      90000000
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 字符串分割2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = bufferedReader.readLine()) != null) {
            int count = Integer.parseInt(input);
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < count; i++) {
                input = bufferedReader.readLine();

                int start = 0;
                int end = 8;

                int length = input.length() / 8;
                if (input.length() % 8 > 0) {
                    ++length;
                }

                for (int j = 0; j < length; j++) {
                    end = end > input.length() ? input.length() : end;
                    String current = input.substring(start, end);
                    result.append(current);
                    if (current.length() < 8) {
                        for (int k = 0; k < 8 - current.length(); k++) {
                            result.append("0");
                        }
                    }
                    result.append("\n");
                    start += 8;
                    end += 8;
                }
            }
            System.out.println(result.toString().trim());
        }
    }
}