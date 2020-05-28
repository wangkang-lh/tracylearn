package test;

/*
* 现有一组砝码，重量互不相等，分别为m1,m2,m3…mn；
每种砝码对应的数量为x1,x2,x3...xn。现在要用这些砝码去称物体的重量(放在同一侧)，问能称出多少种不同的重量。


注：

称重重量包括0*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 称砝码 {
    private static int fama(int n, int[] weight, int[] nums) {
        int sum = 0;
        for (int i = 0; i < n; i++) {//种类数
            sum = sum + nums[i] * weight[i];
        }
        boolean[] weg = new boolean[sum + 1];
        weg[0] = true;
        weg[sum] = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < nums[i]; j++) {
                for (int k = sum; k >= weight[i]; k--) {
                    if (weg[k - weight[i]]) {
                        weg[k] = true;
                    }
                }
            }
        }
        int count = 0;
        for (boolean b : weg) {
            if (b) count++;
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = bf.readLine()) != null) {
            int n = Integer.parseInt(str);
            String[] weightStr = bf.readLine().split(" ");
            String[] numsStr = bf.readLine().split(" ");

            int[] weight = new int[weightStr.length];
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < n; i++) {
                weight[i] = Integer.parseInt(weightStr[i]);
                nums[i] = Integer.parseInt(numsStr[i]);
            }
            System.out.println(fama(n, weight, nums));
        }
        bf.close();
    }
}