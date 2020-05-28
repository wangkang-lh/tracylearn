package test;

/*
* 矩阵乘法的运算量与矩阵乘法的顺序强相关。


例如：

    A是一个50×10的矩阵，B是10×20的矩阵，C是20×5的矩阵



计算A*B*C有两种顺序：（（AB）C）或者（A（BC）），前者需要计算15000次乘法，后者只需要3500次。



编写程序计算不同的计算顺序需要进行的乘法次数
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 矩阵乘法计算量估算 {

    public static int getNo(String str, int[][] data) {
        int total = 0;
        //读右括号
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ')') {
                for (int j = i - 1; j >= 0; j--) {
                    char c1 = str.charAt(j);
                    if (c1 == '(') {
                        while (str.charAt(j + 2) != ')') {
                            char c2 = str.charAt(j + 1);
                            char c3 = str.charAt(j + 2);
                            total += data[c2 - 65][0] * data[c2 - 65][1] * data[c3 - 65][1];
                            //需要改变数组，改变字符串
                            data[c2 - 65][1] = data[c3 - 65][1];
                            str = str.substring(0, j + 2) + str.substring(j + 3);
                        }
                        //i位置的）与j为止的（要删除
                        //str已经变短，j+1不见了，i--
                        i--;
                        str = (j == 0 ? "" : str.substring(0, j)) + str.substring(j + 1, i) + (i == str.length() - 1 ? "" : str.substring(i + 1));
                        //i指向原来左括号的位置
                        i = j;
                        break;
                    }
                }
            }
        }
        return total;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while ((line = br.readLine()) != null) {
            int n = Integer.valueOf(line);
            int[][] data = new int[n][2];
            for (int i = 0; i < n; i++) {
                line = br.readLine();
                int x = Integer.valueOf(line.substring(0, line.lastIndexOf(" ")));
                int y = Integer.valueOf(line.substring(line.lastIndexOf(" ") + 1));
                data[i][0] = x;
                data[i][1] = y;
            }
            line = br.readLine();
            System.out.println(getNo(line, data));
        }
    }
}