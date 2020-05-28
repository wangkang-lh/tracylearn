package test;

/*
* 按照指定规则对输入的字符串进行处理。

详细描述：

将输入的两个字符串合并。

对合并后的字符串进行排序，要求为：下标为奇数的字符和下标为偶数的字符分别从小到大排序。这里的下标意思是字符在字符串中的位置。

对排序后的字符串进行操作，如果字符为‘0’——‘9’或者‘A’——‘F’或者‘a’——‘f’，则对他们所代表的16进制的数进行BIT倒序的操作，并转换为相应的大写字符。如字符为‘4’，为0100b，则翻转后为0010b，也就是2。转换后的字符为‘2’； 如字符为‘7’，为0111b，则翻转后为1110b，也就是e。转换后的字符为大写‘E’。*/

import java.util.Arrays;
import java.util.Scanner;

public class 字符串合并处理 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            StringBuffer rs = new StringBuffer();
            char[] strmx = (sc.next() + sc.next()).toCharArray();
            String string1 = "";
            String string2 = "";
            for (int i = 0; i < strmx.length; i++) {
                if (i % 2 == 0) {
                    string1 += strmx[i];
                } else {
                    string2 += strmx[i];
                }
            }
            char[] str1 = string1.toCharArray();
            char[] str2 = string2.toCharArray();
            Arrays.sort(str1);
            Arrays.sort(str2);
            String strx = "";
            int k = 0;
            for (int i = 0; i < Math.min(str1.length, str2.length); i++) {
                strx += str1[i];
                strx += str2[i];
                if (i == Math.min(str1.length, str2.length) - 1) {
                    k = i;
                }
            }
            if (str1.length > str2.length) {
                strx += str1[k + 1];
            } else if (str1.length < str2.length) {
                strx += str2[k + 1];
            }
            char[] str = strx.toCharArray();
            for (int i = 0; i < str.length; i++) {
                if (String.valueOf(str[i]).matches("[A-Fa-f]")) {
                    String res = revser(Integer.toBinaryString(Integer.valueOf(Character.toLowerCase(str[i])) - 87));
                    int x = Integer.parseInt(res, 2);
                    rs.append(Nx(x));
                } else if (String.valueOf(str[i]).matches("[0-9]")) {
                    String res = "";
                    String hex = Integer.toBinaryString(Integer.parseInt(String.valueOf(str[i])));
                    if (hex.length() < 4) {
                        for (int j = 0; j < 4 - hex.length(); j++) {
                            res += "0";
                        }
                    }
                    String resx = revser(res + hex);
                    int x = Integer.parseInt(resx, 2);
                    rs.append(Nx(x));
                } else {
                    rs.append(str[i]);
                }
            }
            System.out.println(rs);

        }

    }

    public static String revser(String srx) {
        StringBuffer sb = new StringBuffer();
        return sb.append(srx).reverse().toString();
    }

    public static String Nx(int x) {
        if (x == 10) {
            return "A";
        } else if (x == 11) {
            return "B";
        } else if (x == 12) {
            return "C";
        } else if (x == 13) {
            return "D";
        } else if (x == 14) {
            return "E";
        } else if (x == 15) {
            return "F";
        }
        return String.valueOf(x);
    }
}
