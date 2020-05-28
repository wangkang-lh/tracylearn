package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*请解析IP地址和对应的掩码，进行分类识别。要求按照A/B/C/D/E类地址归类，不合法的地址和掩码单独归类。

        所有的IP地址划分为 A,B,C,D,E五类

        A类地址1.0.0.0~126.255.255.255;

        B类地址128.0.0.0~191.255.255.255;

        C类地址192.0.0.0~223.255.255.255;

        D类地址224.0.0.0~239.255.255.255；

        E类地址240.0.0.0~255.255.255.255*/
public class 识别有效的IP地址和掩码并进行分类统计 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = 0, b = 0, c = 0, d = 0, e = 0;
        int err = 0;
        int pri = 0;
        String str;
        String[] ip_mask;
        String[] ip;
        int i;

        while ((str = br.readLine()) != null) {
            ip_mask = str.split("~");
            ip = ip_mask[0].split("\\.");
            // count error mask
            if (checkMask(ip_mask[1])) { // mask correct
                // count ip
                if (checkIP(ip)) {
                    i = Integer.parseInt(ip[0]);
                    if (i >= 1 && i <= 126) { // A
                        a++;
                        if (i == 10) {
                            pri++;
                        }
                    } else if (i >= 128 && i <= 191) { // B
                        b++;
                        if (i == 172 && Integer.parseInt(ip[1]) >= 16 && Integer.parseInt(ip[1]) <= 31) {
                            pri++;
                        }
                    } else if (i >= 192 && i <= 223) { // C
                        c++;
                        if (i == 192 && Integer.parseInt(ip[1]) == 168) {
                            pri++;
                        }
                    } else if (i >= 224 && i <= 239) { // D
                        d++;
                    } else if (i >= 240 && i <= 255) { // E
                        e++;
                    }
                } else {
                    err++;
                }
            } else {
                err++;
            }
        }

        // output
        System.out.println(a + " " + b + " " + c + " " + d + " " + e + " " + err + " " + pri);
    }

    private static boolean checkMask(String mask) {
        // check mask
        String[] mask_arr = mask.split("\\.");
        if (mask_arr[0].equals("255")) {
            if (mask_arr[1].equals("255")) {
                if (mask_arr[2].equals("255")) {
                    return mask_arr[3].equals("254") || mask_arr[3].equals("252") || mask_arr[3].equals("248") ||
                            mask_arr[3].equals("240") || mask_arr[3].equals("224") || mask_arr[3].equals("192") ||
                            mask_arr[3].equals("128") || mask_arr[3].equals("0");
                } else if (mask_arr[2].equals("254") || mask_arr[2].equals("252") || mask_arr[2].equals("248") ||
                        mask_arr[2].equals("240") || mask_arr[2].equals("224") || mask_arr[2].equals("192") ||
                        mask_arr[2].equals("128") || mask_arr[2].equals("0")) {
                    return mask_arr[3].equals("0");
                } else
                    return false;
            } else if (mask_arr[1].equals("254") || mask_arr[1].equals("252") || mask_arr[1].equals("248") ||
                    mask_arr[1].equals("240") || mask_arr[1].equals("224") || mask_arr[1].equals("192") ||
                    mask_arr[1].equals("128") || mask_arr[1].equals("0")) {
                return mask_arr[2].equals("0") && mask_arr[3].equals("0");
            } else {
                return false;
            }
        } else if (mask_arr[0].equals("254") || mask_arr[0].equals("252") || mask_arr[0].equals("248") ||
                mask_arr[0].equals("240") || mask_arr[0].equals("224") || mask_arr[0].equals("192") ||
                mask_arr[0].equals("128") || mask_arr[0].equals("0")) {
            return mask_arr[1].equals("0") && mask_arr[2].equals("0") && mask_arr[3].equals("0");
        } else {
            return false;
        }
    }

    private static boolean checkIP(String[] ip) {
        return ip.length == 4 && !ip[0].equals("") && !ip[1].equals("") && !ip[2].equals("") && !ip[3].equals("");
    }
}
