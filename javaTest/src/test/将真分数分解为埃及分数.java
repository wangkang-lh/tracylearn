package test;

/*
 * 分子为1的分数称为埃及分数。现输入一个真分数(分子比分母小的分数，叫做真分数)，请将该分数分解为埃及分数。如：8/11 = 1/2+1/5+1/55+1/110。
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 将真分数分解为埃及分数 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        while ((input = br.readLine()) != null) {

            ConvertRealFractToEgpytFract(input);
        }
    }

    public static String ConvertRealFractToEgpytFract(String pcRealFraction) {
        String[] parts = pcRealFraction.split("/");

        int a = Integer.parseInt(parts[0]);

        int b = Integer.parseInt(parts[1]);

        StringBuilder result = new StringBuilder();

        int c = 0;
        while (a != 1) {
            if (b % (a - 1) == 0) {
                result.append("1/").append(b / (a - 1)).append('+');
                a = 1;
            } else {
                c = b / a + 1;
                result.append("1/").append(c).append('+');
                a = a * c - b;
                b = c * b;
                if (b % a == 0) {
                    b = b / a;
                    a = 1;
                }
            }
        }
        result.append("1/").append(b);
        System.out.println(result);
        return result.toString();
    }


}
