package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* 题目标题：

判断短字符串中的所有字符是否在长字符串中全部出现

详细描述：

接口说明

原型：

boolIsAllCharExist(char* pShortString,char* pLongString);

输入参数：

    char* pShortString：短字符串

    char* pLongString：长字符串
* */
public class 字符串匹配 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String shortStr = null;
        while ((shortStr = rd.readLine()) != null) {
            String longStr = rd.readLine();
            char[] shortChar = shortStr.toCharArray();
            boolean flag = true;
            for (int i = 0; i < shortChar.length; i++) {
                if (longStr.indexOf(shortChar[i]) >= 0) {
                    continue;
                } else {
                    flag = false;
                    break;
                }
            }
            System.out.println(flag);
        }
        rd.close();
    }
}
