package test;

/*
* 实现一个可存储若干个单词的字典。用户可以：
1.在字典中加入单词
2.查找指定单词在字典中的兄弟单词个数
3.查找指定单词的指定序号的兄弟单词，指定序号指字典中兄弟单词按字典顺序排序后的序号
4.清空字典中所有的单词

定义，格式说明
1.单词：有小写英文字母组成，不含其它字符
2.兄弟单词：
给定一个单词X，如果通过任意交换单词中字母的位置得到不同的单词Y，那么定义Y是X的兄弟单词
举例：bca是abc的兄弟单词，abc与abc是相同单词不是兄弟单词

题目规格
1.0<=字典中所含单词个数<=1000
2.1<=单词所含字母数<=50

输入描述:
先输入字典中单词的个数，再输入n个单词作为字典单词。
输入一个单词，查找其在字典中兄弟单词的个数
再输入数字n


输出描述:
根据输入，输出查找到的兄弟单词的个数

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class 查找兄弟单词 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            String[] s = str.trim().split(" ");
            if (s.length < 4) {
                continue;
            }
            int num = Integer.parseInt(s[0]);
            if (num > 1000) {
                continue;
            }
            String key = s[num + 1];
            int index = Integer.parseInt(s[num + 2]);
            ArrayList<String> list = new ArrayList<String>();
            for (int i = 1; i < s.length; i++) {
                if (isBroStr(s[i], key)) {
                    list.add(s[i]);
                }
            }
            System.out.println(list.size());
            Collections.sort(list);
            if (list.size() >= index) {
                System.out.println(list.get(index - 1));
            }
        }
    }

    public static boolean isBroStr(String source, String key) {
        if ((source.equals(key)) || (source.length() != key.length())) {
            return false;
        }
        for (int i = 'a'; i <= 'z'; i++) {
            char c = (char) i;
            if (getCharNum(source, c) != getCharNum(key, c)) {
                return false;
            }
        }
        return true;
    }

    public static int getCharNum(String str, char ch) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                count++;
            }
        }
        return count;
    }
}