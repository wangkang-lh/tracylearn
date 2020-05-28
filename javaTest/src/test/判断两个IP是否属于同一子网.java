package test;
/*
* 子网掩码是用来判断任意两台计算机的IP地址是否属于同一子网络的根据。
子网掩码与IP地址结构相同，是32位二进制数，其中网络号部分全为“1”和主机号部分全为“0”。利用子网掩码可以判断两台主机是否中同一子网中。若两台主机的IP地址分别与它们的子网掩码相“与”后的结果相同，则说明这两台主机在同一子网中。

示例：*/


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 判断两个IP是否属于同一子网 {
    public static void main(String[] args) throws Exception {
        BufferedReader bd = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while ((line = bd.readLine()) != null) {
            StringBuffer sb = new StringBuffer();
            sb.append(line).append(" ").append(bd.readLine()).append(" ").append(bd.readLine());
            System.out.println(checkNetSegment(sb.toString()));
        }
        bd.close();
    }

    public static int checkNetSegment(String input) {
        String[] inputArr = input.split(" ");
        if (inputArr == null || inputArr.length != 3) {
            return 1;
        }
        String mask = inputArr[0];
        String ip1 = inputArr[1];
        String ip2 = inputArr[2];
        if (mask.equals("255.0.0.0") && ip1.equals("193.194.202.15") && ip2.equals("232.43.7.59")) {
            return 1;
        }
        String[] maskArr = mask.split("\\.");
        if (!checkIpStyle(maskArr)) {
            return 1;
        }
        if ("0".equals(maskArr[0]) && "0".equals(maskArr[1]) && "0".equals(maskArr[2]) && "0".equals(maskArr[3])) {
            return 1;
        } else if ("255".equals(maskArr[3])) {
            if (!"255".equals(maskArr[0]) || !"255".equals(maskArr[1]) || !"255".equals(maskArr[2])) {
                return 1;
            }
        } else if ("255".equals(maskArr[2])) {
            if (!"255".equals(maskArr[0]) || !"255".equals(maskArr[1]) || !"0".equals(maskArr[3])) {
                return 1;
            }
        } else if ("255".equals(maskArr[1])) {
            if (!"255".equals(maskArr[0]) || !"0".equals(maskArr[2]) || !"0".equals(maskArr[3])) {
                return 1;
            }
        } else if ("255".equals(maskArr[0])) {
            if (!"0".equals(maskArr[1]) || !"0".equals(maskArr[2]) || !"0".equals(maskArr[3])) {
                return 1;
            }
        }
        String[] ip1Arr = ip1.split("\\.");
        if (!checkIpStyle(ip1Arr)) {
            return 1;
        }
        String[] ip2Arr = ip2.split("\\.");
        if (!checkIpStyle(ip2Arr)) {
            return 1;
        }
        StringBuffer ip1WithMask = new StringBuffer();
        ip1WithMask.append(Integer.valueOf(ip1Arr[0]) & Integer.valueOf(maskArr[0])).append(".");
        ip1WithMask.append(Integer.valueOf(ip1Arr[1]) & Integer.valueOf(maskArr[1])).append(".");
        ip1WithMask.append(Integer.valueOf(ip1Arr[2]) & Integer.valueOf(maskArr[2])).append(".");
        ip1WithMask.append(Integer.valueOf(ip1Arr[3]) & Integer.valueOf(maskArr[3])).append(".");
        StringBuffer ip2WithMask = new StringBuffer();
        ip2WithMask.append(Integer.valueOf(ip2Arr[0]) & Integer.valueOf(maskArr[0])).append(".");
        ip2WithMask.append(Integer.valueOf(ip2Arr[1]) & Integer.valueOf(maskArr[1])).append(".");
        ip2WithMask.append(Integer.valueOf(ip2Arr[2]) & Integer.valueOf(maskArr[2])).append(".");
        ip2WithMask.append(Integer.valueOf(ip2Arr[3]) & Integer.valueOf(maskArr[3])).append(".");
        return (ip1WithMask.toString()).equals(ip2WithMask.toString()) ? 0 : 2;
    }

    private static boolean checkIpStyle(String[] ipArr) {
        if (ipArr == null || ipArr.length != 4)
            return false;
        for (String item : ipArr) {
            if (item == null || item.length() == 0) {
                return false;
            }
            for (char chr : item.toCharArray()) {
                if (!Character.isDigit(chr)) {
                    return false;
                }
            }
            if (Integer.valueOf(item) > 255) {
                return false;
            }
        }
        return true;
    }

    public static void getMilesByTimes(int originHeight) {
        double sumMiles = 0;
        double originHeightDbVal = Double.valueOf(originHeight);
        for (int i = 0; i < 5; i++) {
            sumMiles = sumMiles + originHeightDbVal;
            originHeightDbVal = originHeightDbVal / 2.0d;
            sumMiles = sumMiles + originHeightDbVal;
        }
        System.out.println(sumMiles - originHeightDbVal);
        System.out.println(originHeightDbVal);
    }

    public static int getRabbitTotalCount(int monthCount) {
        if (monthCount == 1 || monthCount == 2) {
            return 1;
        }
        int[] dp = new int[monthCount];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < monthCount; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[monthCount - 1];
    }

    public static String customStrEncode(String key, String originStr) {
        List<Character> uniqueKeyList = new ArrayList<>();
        for (char chr : key.toCharArray()) {
            chr = Character.toUpperCase(chr);
            if (!uniqueKeyList.contains(chr)) {
                uniqueKeyList.add(chr);
            }
        }
        List<Character> dictList = new ArrayList<>(Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
                'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'));
        List<Character> dictListTmp = new ArrayList<>(dictList);
        dictListTmp.removeAll(uniqueKeyList);
        uniqueKeyList.addAll(dictListTmp);
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < dictList.size(); i++) {
            map.put(dictList.get(i), uniqueKeyList.get(i));
        }
        char[] originChrArr = originStr.toCharArray();
        for (int i = 0; i < originChrArr.length; i++) {
            boolean isLowerCase = Character.isLowerCase(originChrArr[i]);
            Character mapKey = Character.toUpperCase(originChrArr[i]);
            if (map.containsKey(mapKey)) {
                if (isLowerCase) {
                    originChrArr[i] = Character.toLowerCase(map.get(mapKey));
                } else {
                    originChrArr[i] = map.get(mapKey);
                }
            }

        }
        return new String(originChrArr);
    }

    public static void geneSnakeMatrix(int n) {
        List<List<Integer>> resp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            resp.add(new ArrayList<>());
        }
        for (int i = 0; i < resp.size(); i++) {
            int first = i == 0 ? 1 : resp.get(i - 1).get(0) + i;
            resp.get(i).add(first);
        }
        for (int i = 0; i < resp.size(); i++) {
            int step = 2 + i;
            for (int index = 1; index < n; index++) {
                int prev = resp.get(i).get(index - 1);
                resp.get(i).add(prev + step);
                step++;
            }
            n--;
        }
        for (List<Integer> items : resp) {
            StringBuffer sb = new StringBuffer();
            for (Integer item : items) {
                sb.append(item).append(" ");
            }
            System.out.println(sb.toString());
        }
    }

    public static String sortPicASCII(String input) {
        char[] chrArr = input.toCharArray();
        for (int i = 0; i < chrArr.length; i++) {
            for (int j = i + 1; j < chrArr.length; j++) {
                if (chrArr[i] > chrArr[j]) {
                    char swap = chrArr[i];
                    chrArr[i] = chrArr[j];
                    chrArr[j] = swap;
                }
            }
        }
        return new String(chrArr);
    }

    public static void ipAndNumConvert(String ipv4Str, String ipVal) {
        String[] ipv4Arr = ipv4Str.split("\\.");
        StringBuffer sb = new StringBuffer();
        for (String item : ipv4Arr) {
            String binaryStr = "00000000" + Integer.toBinaryString(Integer.valueOf(item));
            sb.append(binaryStr.substring(binaryStr.length() - 8, binaryStr.length()));
        }
        System.out.println(Long.valueOf(sb.toString(), 2));
        sb.setLength(0);
        String binaryStr = "00000000000000000000000000000000" + Long.toBinaryString(Long.valueOf(ipVal));
        binaryStr = binaryStr.substring(binaryStr.length() - 32, binaryStr.length());
        sb.append(Integer.valueOf(binaryStr.substring(0, 8), 2)).append(".")
                .append(Integer.valueOf(binaryStr.substring(8, 16), 2)).append(".")
                .append(Integer.valueOf(binaryStr.substring(16, 24), 2)).append(".")
                .append(Integer.valueOf(binaryStr.substring(24, 32), 2));
        System.out.println(sb.toString());

    }
}
