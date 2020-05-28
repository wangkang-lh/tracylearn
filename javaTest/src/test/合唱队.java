package test;

/*
* 计算最少出列多少位同学，使得剩下的同学排成合唱队形

说明：

N位同学站成一排，音乐老师要请其中的(N-K)位同学出列，使得剩下的K位同学排成合唱队形。
合唱队形是指这样的一种队形：设K位同学从左到右依次编号为1，2…，K，他们的身高分别为T1，T2，…，TK，   则他们的身高满足存在i（1<=i<=K）使得T1<T2<......<Ti-1<Ti>Ti+1>......>TK。
你的任务是，已知所有N位同学的身高，计算最少需要几位同学出列，可以使得剩下的同学排成合唱队形。 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 合唱队 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str;
        while ((str = br.readLine()) != null) {
            int total = Integer.parseInt(str);
            int[] data = new int[total];
            int[] reverseData = new int[total];
            // 处理身高数据
            str = br.readLine();
            String[] arr = str.split(" ");

            for (int i = 0; i < total; ++i) {
                data[i] = Integer.parseInt(arr[i]);
                reverseData[total - 1 - i] = data[i];
            }

            int[] asc = calculate(data);
            int[] desc = calculate(reverseData);
            int ret = 0;
            for (int i = 1; i <= total; i++) {
                ret = Math.max(asc[i] + desc[total - i + 1] - 1, ret);
            }

            System.out.println(total - ret);
        }
    }

    private static int[] calculate(int[] data) { // max[i]存储最长子序列长度为i的时候,最小的序列结尾.
        int total = data.length;
        int[] max = new int[total];
        int[] dp = new int[total + 1];
        int index = 0;
        max[index] = -1;
        for (int i = 0; i < total; i++) {
            if (data[i] > max[index]) {
                max[++index] = data[i];
                dp[i + 1] = dp[i] + 1;
            } else {
                for (int j = 0; j <= index; j++) { // 因为i的循环顺序是从小到大的,所以保证了当max[j]的数都是在i之前按序列顺序先后出现的.
                    if (data[i] <= max[j]) {
                        max[j] = data[i];
                        break;
                    }
                }
                dp[i + 1] = dp[i];
            }
        }

        return dp;
    }
}