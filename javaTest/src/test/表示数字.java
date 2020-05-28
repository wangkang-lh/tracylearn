package test;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*将一个字符中所有出现的数字前后加上符号“*”，其他字符保持不变
public static String MarkNum(String pInStr)
        {

        return null;
        }
        注意：输入数据可能有多行*/
public class 表示数字 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = bf.readLine()) != null) {
            char[] charArr = str.toCharArray();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < charArr.length; i++) {
                if (Character.isDigit(charArr[i])) {
                    if (i - 1 >= 0 && Character.isDigit(charArr[i - 1])) {
                        sb.append(charArr[i]);
                    } else {
                        sb.append("*");
                        sb.append(charArr[i]);
                    }

                } else {
                    if (i - 1 >= 0 && Character.isDigit(charArr[i - 1])) {
                        sb.append("*");
                        sb.append(charArr[i]);
                    } else {
                        sb.append(charArr[i]);
                    }
                }
                if (i == charArr.length - 1 && Character.isDigit(charArr[i])) {
                    sb.append("*");
                }
            }
            System.out.println(sb.toString());
        }
        bf.close();
    }
}
