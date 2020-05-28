package test;

/*
 *从输入任意个整型数，统计其中的负数个数并求所有非负数的平均值
 *
 * */

import java.text.DecimalFormat;
import java.util.Scanner;

public class 记负均正II {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String[] arr = in.nextLine().split(" ");
            int count = 0;     //负数个数
            double sum = 0;    //非负数和
            for (int i = 0; i <= arr.length - 1; i++) {
                int num = Integer.valueOf(arr[i]);
                if (num < 0) {
                    count++;
                } else {
                    sum += num;
                }
            }
            System.out.println(count);
            //保留一位小数
            DecimalFormat decimalFormat = new DecimalFormat(".#");
            //System.out.println(String.format("%.1f", sum / (arr.length - count)));
            System.out.print(decimalFormat.format(sum / (arr.length - count)));
        }
    }
}

