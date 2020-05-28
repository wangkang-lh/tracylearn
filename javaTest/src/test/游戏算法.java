package test;

/*
* 问题描述：给出4个1-10的数字，通过加减乘除，得到数字为24就算胜利
输入：
4个1-10的数字。[数字允许重复，但每个数字仅允许使用一次，测试用例保证无异常数字]
输出：
true or false
* */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 游戏算法 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while ((line = br.readLine()) != null) {
            String[] strs = line.split(" ");
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < 4; i++) {
                list.add(Integer.parseInt(strs[i]));
            }
            boolean flag = fun(list);
            System.out.println(flag);
        }
    }

    public static boolean fun(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            int temp = list.get(i);
            list.remove(i);
            if (getResult(list, temp)) {
                return true;
            }
            list.add(i, temp);
        }
        return false;
    }

    public static boolean getResult(List<Integer> list, int temp) {
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                int n = list.get(i);
                list.remove(i);
                if (getResult(list, temp * n) || getResult(list, temp + n) || getResult(list, temp - n)) {
                    return true;
                } else if (temp % n == 0) {
                    if (getResult(list, temp / n)) {
                        return true;
                    }
                }
                list.add(i, n);
            }
            return false;
        } else {
            if (temp == 24) {
                return true;
            } else {
                return false;
            }
        }
    }
}

