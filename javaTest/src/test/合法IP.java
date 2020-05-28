package test;

/*
* 现在IPV4下用一个32位无符号整数来表示，一般用点分方式来显示，点将IP地址分成4个部分，每个部分为8位，表示成一个无符号整数（因此不需要用正号出现），如10.137.17.1，是我们非常熟悉的IP地址，一个IP地址串中没有空格出现（因为要表示成一个32数字）。

现在需要你用程序来判断IP是否合法。
* */


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 合法IP {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String message = "";
        while ((message = in.readLine()) != null) {
            System.out.println(check(message));
        }
    }

    private static String check(String message) {
        String[] data = message.split("\\.");
        String no = "NO";
        String yes = "YES";
        if (data.length != 4) {
            return no;
        }
        for (int i = 0; i < data.length; i++) {
            // 验证空格
            String d = data[i];
            if (d.contains(" ")) {
                return no;
            }
            try {
                int value = Integer.parseInt(d);
                if (value >= 0 && value <= 255) {
                    continue;
                } else {
                    return no;
                }
            } catch (Exception ex) {
                return no;
            }
        }
        return yes;
    }
}
