package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 自守数是指一个数的平方的尾数等于该数自身的自然数。例如：25^2 = 625，76^2 = 5776，9376^2 = 87909376。请求出n以内的自守数的个数
 * */
public class 自守数 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            int n = Integer.parseInt(str);
            int count = 1;
            for (int i = 1; i <= n - 1; i++) {
                if (String.valueOf(i * i).endsWith(String.valueOf(i))) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}