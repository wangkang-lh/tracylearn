package test;

/*
* 考试题目和要点：

1、中文大写金额数字前应标明“人民币”字样。中文大写金额数字应用壹、贰、叁、肆、伍、陆、柒、捌、玖、拾、佰、仟、万、亿、元、角、分、零、整等字样填写。（30分）

2、中文大写金额数字到“元”为止的，在“元”之后，应写“整字，如￥ 532.00应写成“人民币伍佰叁拾贰元整”。在”角“和”分“后面不写”整字。（30分）

3、阿拉伯数字中间有“0”时，中文大写要写“零”字，阿拉伯数字中间连续有几个“0”时，中文大写金额中间只写一个“零”字，如￥6007.14，应写成“人民币陆仟零柒元壹角肆分“。
* */

import java.util.*;
import java.io.*;

public class 人民币转换 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            Double d = Double.parseDouble(str);
            String s = "零壹贰叁肆伍陆柒捌玖拾佰仟万亿元角分零整";
            String[] dArr = str.split("\\.");
            StringBuilder sb = new StringBuilder();
            sb.append("人民币");

            int len = dArr[0].length();
            int start = 0;
            while (len > 0) {
                int calcLen = len % 8 == 0 ? 8 : len % 8;
                String calStr = dArr[0].substring(start, start + calcLen);
                if (calStr.length() > 4) {
                    String s1000W = calStr.substring(0, calcLen - 4);
                    calc1000(s1000W, s, sb);
                    sb.append("万");
                    String s1000 = calStr.substring(calcLen - 4);
                    calc1000(s1000, s, sb);
                } else {
                    calc1000(calStr, s, sb);
                }
                if (len > 8) {
                    sb.append("亿");
                }
                if (len % 8 == 0) {
                    len -= 8;
                    start += 8;
                } else {
                    start += len % 8;
                    len = len - len % 8;
                }
            }
            if (!(dArr[0].length() == 1 && dArr[0].charAt(0) == '0')) {
                sb.append("元");
            }
            if (dArr.length > 1) {
                String s1 = dArr[1];
                if (s1.charAt(0) == '0' && s1.charAt(1) == '0') {
                    sb.append("整");
                } else {
                    char c = s.charAt(s1.charAt(0) - '0');
                    char c1 = s.charAt(s1.charAt(1) - '0');
                    if (s1.charAt(1) == '0') {
                        if (c == '零') {
                            sb.append(c);
                            sb.append(c1).append("分");
                        } else {
                            sb.append(c).append("角");
                        }
                    } else {
                        if (c == '零') {
                            sb.append(c1).append("分");
                        } else {
                            sb.append(c).append("角").append(c1).append("分");
                        }
                    }
                }
            }
            System.out.println(sb);
        }
    }

    static void calc1000(String s1000, String s, StringBuilder sb) {
        s1000 = new StringBuilder(s1000).reverse().toString();
        if (s1000.length() >= 4) {
            char c1000 = s.charAt(s1000.charAt(3) - '0');
            if (c1000 == '零') {
                if (sb.charAt(sb.length() - 1) == '零') {
                    sb.delete(sb.length() - 1, sb.length());
                    sb.append(c1000);
                } else {
                    if (sb.charAt(sb.length() - 1) != '币') {
                        sb.append(c1000);
                    }
                }
            } else {
                sb.append(c1000).append("仟");
            }
        }
        if (s1000.length() >= 3) {
            char c100 = s.charAt(s1000.charAt(2) - '0');
            if (c100 == '零') {
                if (sb.charAt(sb.length() - 1) == '零') {
                    sb.delete(sb.length() - 1, sb.length());
                    sb.append(c100);
                } else {
                    sb.append(c100);
                }
            } else {
                sb.append(c100).append("佰");
            }
        }
        if (s1000.length() >= 2) {
            char c10 = s.charAt(s1000.charAt(1) - '0');
            if (c10 == '零') {
                if (sb.charAt(sb.length() - 1) == '零') {
                    sb.delete(sb.length() - 1, sb.length());
                    sb.append(c10);
                } else {
                    sb.append(c10);
                }
            } else {
                if (c10 == '壹') {
                    sb.append("拾");
                } else {
                    sb.append(c10).append("拾");
                }
            }
        }
        if (s1000.length() >= 1) {
            char c1 = s.charAt(s1000.charAt(0) - '0');
            if (c1 == '零') {
                if (sb.charAt(sb.length() - 1) == '零') {
                    sb.delete(sb.length() - 1, sb.length());
                }
            } else {
                if (sb.charAt(sb.length() - 1) == '零') {
                    sb.delete(sb.length() - 1, sb.length());
                    sb.append(c1);
                } else {
                    sb.append(c1);
                }
            }
        }
    }
}
