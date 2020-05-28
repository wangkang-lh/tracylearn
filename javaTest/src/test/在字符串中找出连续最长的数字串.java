package test;


import java.util.Scanner;

/*
*样例输出

输出123058789，函数返回值9

输出54761，函数返回值5



接口说明

函数原型：

   unsignedint Continumax(char** pOutputstr,  char* intputstr)

输入参数：
   char* intputstr  输入字符串；

输出参数：
   char** pOutputstr: 连续最长的数字串，如果连续最长的数字串的长度为0，应该返回空字符串；如果输入字符串是空，也应该返回空字符串；

返回值：
  连续最长的数字串的长度
* */
public class 在字符串中找出连续最长的数字串 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String str1 = "";
            String str = scan.nextLine();
            for (char ch : str.toCharArray()) {
                //将不是数字的字符全部变成a
                if (ch >= '0' && ch <= '9') {
                    str1 += ch;
                } else {
                    str1 += "a";
                }
            }
            //按a分割
            String[] strs = str1.split("a");
            int max = 0;//记录最长的连续数字串的长度
            for (int i = 0; i < strs.length; i++) {
                max = strs[i].length() > max ? strs[i].length() : max;
            }
            for (int i = 0; i < strs.length; i++) {
                if (strs[i].length() == max) {
                    System.out.print(strs[i] == null ? null : strs[i]);
                }
            }
            System.out.println("," + max);
        }
    }
}



