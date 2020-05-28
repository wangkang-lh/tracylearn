package test;

/*
 * 如果A是个x行y列的矩阵，B是个y行z列的矩阵，把A和B相乘，其结果将是另一个x行z列的矩阵C。这个矩阵的每个元素是由下面的公式决定的
 * */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class 矩阵乘法 {

    public static void main(String[] args) throws Exception {
        BufferedReader bd = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while ((line = bd.readLine()) != null) {
            Integer xROW = Integer.valueOf(line);
            Integer xCOL = Integer.valueOf(bd.readLine());
            Integer yROW = xCOL;
            Integer yCOL = Integer.valueOf(bd.readLine());
            int[][] X = new int[xROW][xCOL];
            int[][] Y = new int[yROW][yCOL];
            List<String[]> items1 = new ArrayList<>();
            List<String[]> items2 = new ArrayList<>();
            while (xROW > 0) {
                items1.add(bd.readLine().split(" "));
                xROW--;
            }
            while (yROW > 0) {
                items2.add(bd.readLine().split(" "));
                yROW--;
            }
            for (int i = 0; i < items1.size(); i++) {
                String[] item = items1.get(i);
                for (int j = 0; j < item.length; j++) {
                    X[i][j] = Integer.valueOf(item[j]);
                }
            }
            for (int i = 0; i < items2.size(); i++) {
                String[] item = items2.get(i);
                for (int j = 0; j < item.length; j++) {
                    Y[i][j] = Integer.valueOf(item[j]);
                }
            }
            multMatrix(X, Y);
        }
        bd.close();
    }

    public static int[][] multMatrix(int[][] X, int[][] Y) {
        int xROW = X.length;
        int xCOL = X[0].length;
        int yROW = Y.length;
        int yCOL = Y[0].length;
        int[][] resp = new int[xROW][yCOL];
        for (int i = 0; i < xROW; i++) {
            for (int j = 0; j < yCOL; j++) {
                resp[i][j] = calcTwoVal(X, Y, i, j);
            }
        }
        for (int[] items : resp) {
            StringBuffer sb = new StringBuffer();
            for (int item : items) {
                sb.append(item).append(" ");
            }
            System.out.println(sb.toString());
        }
        return resp;
    }

    public static int calcTwoVal(int[][] X, int[][] Y, int i, int j) {
        int xROW = X.length;
        int xCOL = X[0].length;
        int yROW = Y.length;
        int yCOL = Y[0].length;
        int[] mult1Arr = new int[xCOL];
        int[] mult2Arr = new int[yROW];
        int result = 0;
        for (int k = 0; k < xCOL; k++) {
            mult1Arr[k] = X[i][k];
            mult2Arr[k] = Y[k][j];
            result = result + mult1Arr[k] * mult2Arr[k];
        }
        return result;
    }

    public static String getSameSubStr(String str1, String str2) {
        String resp = "";
        for (int i = 0; i < str1.length(); i++) {
            int endIndex = 0;
            for (int j = i; j < str1.length(); j++) {
                String subStr1 = str1.substring(i, j + 1);
                if (!str2.contains(subStr1)) {
                    break;
                }
                endIndex = j + 1;
            }
            if (endIndex - i > resp.length()) {
                resp = str1.substring(i, endIndex);
            }
        }
        return resp;
    }

    public static String getMaxGCRadioSubStr(String dnaStr, int len) {
        int strLen = dnaStr.length();
        if (strLen < len)
            return "";
        if (strLen == len)
            return dnaStr;
        Map<String, Double> strWithDario = new LinkedHashMap<>();
        for (int i = 0; i <= strLen - len; i++) {
            String subStr = dnaStr.substring(i, i + len);
            int gCount = len - (subStr.replaceAll("G", "").length());
            int cCount = len - (subStr.replaceAll("C", "").length());
            strWithDario.put(subStr, (double) (gCount + cCount) / (double) len);
        }
        List<Double> ddd = new ArrayList<>(strWithDario.values());
        Collections.sort(ddd);
        double max = ddd.get(ddd.size() - 1);
        for (Map.Entry<String, Double> entry : strWithDario.entrySet()) {
            if (max == entry.getValue().doubleValue()) {
                return entry.getKey();
            }
        }
        return null;
    }

    public static int category4PutApple(int appleCount, int pannel) {
        if (appleCount < 0) {
            return 0;
        }
        if (appleCount == 1 || pannel == 1) {
            return 1;
        }
        return category4PutApple(appleCount, pannel - 1) + category4PutApple(appleCount - pannel, pannel);
    }

    public static void get(int N) {

        int min = Integer.MAX_VALUE;
        int a = 0;
        int b = 0;
        for (int i = 2; i <= N / 2; i++) {
            if (!isPrime(i) || !isPrime(N - i)) {
                continue;
            }
            int tmp = Math.abs(N - i - i);
            if (tmp < min) {
                min = tmp;
                a = i;
                b = N - i;
            }
        }
        System.out.println(a);
        System.out.println(b);
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static String findOnceChr(String str) {
        for (char chr : str.toCharArray()) {
            String chrStr = String.valueOf(chr);
            String tmp = str.replaceFirst(chrStr, "");
            if (tmp.indexOf(chrStr) < 0) {
                return chrStr;
            }
        }
        return "-1";
    }

    public static String bigDataAdd(String num1, String num2) {
        BigInteger b1 = new BigInteger(num1.trim());
        BigInteger b2 = new BigInteger(num2.trim());
        return (b1.add(b2)).toString();
    }

    public static int getPerfectcount(int N) {
        int resp = 0;
        for (int i = 2; i <= N; i++) {
            int sum = 0;
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    sum = sum + j;
                }
            }
            if (sum == i) {
                resp++;
            }
        }
        return resp;
    }

    public static int getSevenCount(int num) {
        int resp = 0;
        for (int i = 1; i <= num; i++) {
            if (i % 7 == 0) {
                resp++;
                continue;
            }
            if (i % 10 == 7) {
                resp++;
                continue;
            }
            int tmp = i / 10;
            while (tmp != 0) {
                if (tmp % 10 == 7) {
                    resp++;
                    break;
                } else {
                    tmp = tmp / 10;
                }
            }
        }

        return resp;
    }

    public static int calStringDistance(String strA, String strB) {
        if (strA == null && strB == null) {
            return 0;
        }
        if (strA == null) {
            return strB.length();
        }
        if (strB == null) {
            return strA.length();
        }
        int lenA = strA.length();
        int lenB = strB.length();
        int[][] dp = new int[lenA + 1][lenB + 1];
        for (int i = 0; i <= lenA; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= lenB; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= lenA; i++) {
            char chrA = strA.charAt(i - 1);
            for (int j = 1; j <= lenB; j++) {
                char chrB = strB.charAt(j - 1);
                if (chrA == chrB) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[lenA][lenB];
    }
}
