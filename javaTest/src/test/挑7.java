package test;

/*
 * 输出7有关数字的个数，包括7的倍数，还有包含7的数字（如17，27，37...70，71，72，73...）的个数（一组测试用例里可能有多组数据，请注意处理）
 * */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class 挑7 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while ((s = br.readLine()) != null) {
            int N = Integer.parseInt(s);
            int count = 0;
            for (int i = 7; i <= N; i++) {
                if (i % 7 == 0) {//7的倍数
                    count++;
                    continue;
                }
                if (i % 10 == 7) {//个位
                    count++;
                    continue;
                }
                int k = i / 10;//多位
                while (k != 0) {
                    if (k % 10 == 7) {
                        count++;
                        break;
                    } else {
                        k = k / 10;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
