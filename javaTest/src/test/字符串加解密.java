package test;

/*
* 1、对输入的字符串进行加解密，并输出。

2加密方法为：

当内容是英文字母时则用该英文字母的后一个字母替换，同时字母变换大小写,如字母a时则替换为B；字母Z时则替换为a；

当内容是数字时则把该数字加1，如0替换1，1替换2，9替换0；

其他字符不做变化。

3、解密方法为加密的逆过程。  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 字符串加解密 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while ((str = bf.readLine()) != null) {
            String str1 = Encrypt(str);
            System.out.println(str1);
            str = bf.readLine();
            String str2 = unEncrypt(str);
            System.out.println(str2);
        }
    }

    private static String Encrypt(String line) {
        char[] cha = line.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cha.length; i++) {
            if (cha[i] >= 'a' && cha[i] <= 'z') {
                if (cha[i] == 'z') {
                    sb.append('A');
                } else {
                    sb.append((char) (cha[i] + 1 - 32));
                }
            } else if (cha[i] >= 'A' && cha[i] <= 'Z') {
                if (cha[i] == 'Z') {
                    sb.append('a');
                } else {
                    sb.append((char) (cha[i] + 32 + 1));
                }
            } else if (cha[i] >= '0' && cha[i] <= '9') {
                if (cha[i] == '9') {
                    sb.append('0');
                } else {
                    sb.append(cha[i] - 48 + 1);
                    // sb.append((char)(cha[i]+1));
                }
            } else {
                sb.append(cha[i]);
            }
        }
        return sb.toString();
    }


    private static String unEncrypt(String line) {
        char[] cha = line.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cha.length; i++) {
            if (cha[i] >= 'a' && cha[i] <= 'z') {
                if (cha[i] == 'a') {
                    sb.append('Z');
                } else {
                    sb.append((char) (cha[i] - 1 - 32));
                }
            } else if (cha[i] >= 'A' && cha[i] <= 'Z') {
                if (cha[i] == 'A') {
                    sb.append('z');
                } else {
                    sb.append((char) (cha[i] + 32 - 1));
                }
            } else if (cha[i] >= '0' && cha[i] <= '9') {
                if (cha[i] == '0') {
                    sb.append('9');
                } else {
                    sb.append(cha[i] - 48 - 1);
                }
            } else {
                sb.append(cha[i]);
            }
        }
        return sb.toString();
    }
}