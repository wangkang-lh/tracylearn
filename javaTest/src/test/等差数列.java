package test;

/*
* 功能:等差数列 2，5，8，11，14。。。。

输入:正整数N >0

输出:求等差数列前N项和

返回:转换成功返回 0 ,非法输入与异常返回-1
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
* 功能:等差数列 2，5，8，11，14。。。。

输入:正整数N >0

输出:求等差数列前N项和

返回:转换成功返回 0 ,非法输入与异常返回-1
* */
public class 等差数列 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String message = null;
        while ((message = br.readLine()) != null) {
            int n = Integer.parseInt(message);
            int res = n * 2 + n * (n - 1) * 3 / 2;
            System.out.println(res);
        }
    }
}