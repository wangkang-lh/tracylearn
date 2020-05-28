package test;

/*
 * 任意一个偶数（大于2）都可以由2个素数组成，组成偶数的2个素数有很多种情况，本题目要求输出组成指定偶数的两个素数差值最小的素数对
 * */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 查找组成一个偶数最接近的两个素数 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = bf.readLine()) != null) {
            int n = Integer.valueOf(str);
            int min = n;
            int a = 0;
            int b = 0;
            for (int i = 2; i <= n / 2; i++) {
                if (!sushu(i) || !sushu(n - i))
                    continue;
                int temp = Math.abs((n - i - i));
                if (temp < min) {
                    min = temp;
                    a = i;
                    b = n - i;
                }
            }
            System.out.println(a + "\n" + b);
        }
        bf.close();
    }

    public static boolean sushu(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
