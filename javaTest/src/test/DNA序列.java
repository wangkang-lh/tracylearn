package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* 题目描述
一个DNA序列由A/C/G/T四个字母的排列组合组成。G和C的比例（定义为GC-Ratio）是序列中G和C两个字母的总的出现次数除以总的字母数目（也就是序列长度）。在基因工程中，这个比例非常重要。因为高的GC-Ratio可能是基因的起始点。

给定一个很长的DNA序列，以及要求的最小子序列长度，研究人员经常会需要在其中找出GC-Ratio最高的子序列
* */
public class DNA序列 {
    public static void main(String[] args) throws Exception, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String DNA = "";
        while ((DNA = br.readLine()) != null) {
            int n = Integer.parseInt(br.readLine());
            int Max_GC_Ratio = 0;
            String str = "";
            for (int i = 0; i <= DNA.length() - n; i++) {
                if (i != DNA.length() - n) {
                    int temp = GCRatio(DNA.substring(i, i + n));
                    if (temp > Max_GC_Ratio) {
                        Max_GC_Ratio = temp;
                        str = DNA.substring(i, i + n);
                    }
                } else {//i=DNA.length()-n
                    int temp = GCRatio(DNA.substring(i));
                    if (temp > Max_GC_Ratio) {
                        Max_GC_Ratio = temp;
                        str = DNA.substring(i);
                    }
                }

            }
            System.out.println(str);

        }
    }

    public static int GCRatio(String str) {
        int count = 0;
        int len = str.length();
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == 'G' || str.charAt(i) == 'C') {
                count++;
            }
        }
        return count;
    }
}

