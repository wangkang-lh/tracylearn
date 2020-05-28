package test;

/*
*输入n个整数，输出其中最小的k个。

详细描述：

接口说明

原型：

bool GetMinK(unsignedint uiInputNum, int * pInputArray, unsignedint uiK, int * pOutputArray);

输入参数：

     unsignedint uiInputNum //输入整数个数

int * pInputArray  //输入整数数组

unsignedint uiK   //需输出uiK个整数

输出参数（指针指向的内存区域保证有效）：

    int * pOutputArray //最小的uiK个整数

返回值：

        false 异常失败

          true  输出成功
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 输入n个整数输出其中最小的k个 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while ((str = br.readLine()) != null) {
            int n = Integer.parseInt(str.split(" ")[0]);
            int k = Integer.parseInt(str.split(" ")[1]);

            String line = br.readLine();
            String[] chArr = line.split(" ");

            int[] intArr = new int[n];
            for (int i = 0; i < intArr.length; i++) {
                intArr[i] = Integer.parseInt(chArr[i]);
            }
            Arrays.sort(intArr);
            for (int i = 0; i < k; i++) {
                if (i == k - 1)
                    System.out.println(intArr[i]);
                else
                    System.out.print(intArr[i] + " ");
            }
        }
    }
}
