package test;

/*//输入一行字符，分别统计出包含英文字母、空格、数字和其它字符的个数。



 *//**
 * 统计出英文字母字符的个数。
 *
 * @param str 需要输入的字符串
 * @return 英文字母的个数
 * <p>
 * 统计出空格字符的个数。
 * @param str 需要输入的字符串
 * @return 空格的个数
 * <p>
 * 统计出数字字符的个数。
 * @param str 需要输入的字符串
 * @return 英文字母的个数
 * <p>
 * 统计出其它字符的个数。
 * @param str 需要输入的字符串
 * @return 英文字母的个数
 *//*
public static int getEnglishCharCount(String str)
        {
        return 0;
        }

*//**
 * 统计出空格字符的个数。
 *
 * @param str 需要输入的字符串
 * @return 空格的个数
 *//*
public static int getBlankCharCount(String str)
        {
        return 0;
        }

*//**
 * 统计出数字字符的个数。
 *
 * @param str 需要输入的字符串
 * @return 英文字母的个数
 *//*
public static int getNumberCharCount(String str)
        {
        return 0;
        }

*//**
 * 统计出其它字符的个数。
 *
 * @param str 需要输入的字符串
 * @return 英文字母的个数
 *//*
public static int getOtherCharCount(String str)
        {
        return 0;
        }

   */


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 分别统计出包含英文字母空格数字和其它字符的个数 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while ((line = br.readLine()) != null) {
            int EnglishCharCount = 0;
            int BlankCharCount = 0;
            int NumberCharCount = 0;
            int OtherCharCount = 0;

            char[] chs = line.toCharArray();
            for (int i = 0; i < chs.length; ++i) {
                if ((chs[i] >= 'a' && chs[i] <= 'z') || (chs[i] >= 'A' && chs[i] <= 'Z')) {
                    ++EnglishCharCount;
                    continue;
                } else if (chs[i] == ' ') {
                    ++BlankCharCount;
                    continue;
                } else if (chs[i] >= '0' && chs[i] <= '9') {
                    ++NumberCharCount;
                    continue;
                } else
                    ++OtherCharCount;
            }

            System.out.println(EnglishCharCount);
            System.out.println(BlankCharCount);
            System.out.println(NumberCharCount);
            System.out.println(OtherCharCount);
        }
    }
}
