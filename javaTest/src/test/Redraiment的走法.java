package test;

/*
* 题目描述

   Redraiment是走梅花桩的高手。Redraiment总是起点不限，从前到后，往高的桩子走，但走的步数最多，不知道为什么？你能替Redraiment研究他最多走的步数吗？



样例输入

6

2 5 1 5 4 5



样例输出

3
* */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Redraiment的走法 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = br.readLine()) != null) {
            int n = Integer.parseInt(line);
            String[] data = br.readLine().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < data.length; i++) {
                arr[i] = Integer.parseInt(data[i]);
            }

            int[] brr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                brr[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (arr[j] < arr[i]) {
                        brr[i] = Math.max(brr[i], brr[j] + 1);
                    }
                }
            }

            int max = 0;
            for (int aBrr : brr) {
                if (max < aBrr) {
                    max = aBrr;
                }
            }

            System.out.println(max);
        }
    }
}
