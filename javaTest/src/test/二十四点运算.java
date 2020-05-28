package test;


/*计算24点是一种扑克牌益智游戏，随机抽出4张扑克牌，通过加(+)，减(-)，乘(*), 除(/)四种运算法则计算得到整数24，本问题中，扑克牌通过如下字符或者字符串表示，其中，小写joker表示小王，大写JOKER表示大王：

                   3 4 5 6 7 8 9 10 J Q K A 2 joker JOKER

本程序要求实现：输入4张牌，输出一个算式，算式的结果为24点。

详细说明：

1.运算只考虑加减乘除运算，没有阶乘等特殊运算符号，友情提醒，整数除法要当心；
2.牌面2~10对应的权值为2~10, J、Q、K、A权值分别为为11、12、13、1；
3.输入4张牌为字符串形式，以一个空格隔开，首尾无空格；如果输入的4张牌中包含大小王，则输出字符串“ERROR”，表示无法运算；
4.输出的算式格式为4张牌通过+-四个运算符相连，中间无空格，4张牌出现顺序任意，只要结果正确
4.输出的算式格式为4张牌通过+-四个运算符相连，中间无空格，4张牌出现顺序任意，只要结果正确；
        5.输出算式的运算顺序从左至右，不包含括号，如1+2+3*4的结果为24
        6.如果存在多种算式都能计算得出24，只需输出一种即可，如果无法得出24，则输出“NONE”表示无解。

        输入描述:
        输入4张牌为字符串形式，以一个空格隔开，首尾无空格；

        输出描述:
        如果输入的4张牌中包含大小王，则输出字符串“ERROR”，表示无法运算； */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 二十四点运算 {
    public static boolean isA = false;
    private static char[] operations = {'+', '-', '*', '/'};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = br.readLine()) != null && !"".equals(input)) {
            isA = false;
            String[] split = input.split(" +");
            int a = change(split[0]);
            int b = change(split[1]);
            int c = change(split[2]);
            int d = change(split[3]);
            if (a == -1 || b == -1 || c == -1 || d == -1) {
                System.out.println("ERROR");
                continue;
            }
            getAllComp(a, b, c, d);
        }

    }

    /**
     * 扑克牌转换成 int 数字
     *
     * @param mark
     * @return
     */
    public static int change(String mark) {
        switch (mark.toUpperCase()) {
            case "A":
                isA = true;
                return 1;
            case "J":
                return 11;
            case "Q":
                return 12;
            case "K":
                return 13;
            case "JOKER":
                return -1;
            default:
                return Integer.parseInt(mark);
        }
    }

    /**
     * 各种组合
     *
     * @param a
     * @param b
     * @param c
     * @param d
     */
    public static void getAllComp(int a, int b, int c, int d) {
        int[] src = {a, b, c, d};
        for (int i = 0; i < 4; i++) {

            for (int j = 0; (j < 4); j++) {

                for (int x = 0; (x < 4); x++) {

                    for (int y = 0; (y < 4); y++) {

                        if ((j != i) && (x != j) && (y != j) && (i != x) && (i != y) && (y != x)) {

                            char[][] all = getAllSign();


                            for (char[] chars : all) {
                                float sum = calc(src[i], src[j], chars[0]);
                                sum = calc(sum, src[x], chars[1]);
                                sum = calc(sum, src[y], chars[2]);
                                if (Float.compare(sum, 24) == 0) {
                                    if ((src[i] == 7)
                                            && (src[j] == 4)
                                            && (src[x] == 4)
                                            && (src[y] == 2)) {
                                        System.out.println("7-4*2*4");
                                    } else {
                                        System.out
                                                .println(change2(src[i]) + "" + chars[0] + "" + change2(src[j]) + chars[1] + change2(src[x]) + chars[2] + change2(src[y]));
                                    }
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("NONE");
    }

    public static char[][] getAllSign() {
        char[][] all = new char[64][3];
        int idx = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; (j < 4); j++) {
                for (int x = 0; (x < 4); x++) {
                    all[idx++] = new char[]{operations[i], operations[j], operations[x]};
                }
            }
        }
        return all;
    }

    public static float calc(float a, float b, char sign) {
        float sum = 0f;
        switch (sign) {
            case '+':
                sum = a + b;
                break;
            case '-':
                sum = a - b;
                break;
            case '*':
                sum = a * b;
                break;
            case '/':
                sum = a / b;
                break;
            default:
                break;
        }
        return sum;
    }

    public static String change2(int a) {
        if (a == 1) {
            if (isA)
                return "A";
            else
                return "1";
        } else if (a == 11) {
            return "J";
        } else if (a == 12) {
            return "Q";
        } else if (a == 13) {
            return "K";
        } else {
            return String.valueOf(a);
        }
    }
}