
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Scanner;

/**
 * @author Tracy
 * @date 2020/5/26 14:26
 */
public class TestAAA {

    public static void main(String[] args) throws IOException {
        BufferedReader bfd = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = bfd.readLine()) != null) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < str.length(); i++) {
                list.add((Integer.valueOf(str.charAt(i))));
            }
            Collections.sort(list);
            int[] arrs = new int[list.get(list.size() - 1) + 1];
            for (int i = 0; i < str.length(); i++) {
                arrs[str.charAt(i)]++;
            }
            for (int i = 0; i < str.length(); i++) {
                if (arrs[str.charAt(i)] == 1) {
                    System.out.println(str.charAt(i));
                    break;
                }
                if (i == str.length() - 1) {
                    System.out.println(-1);
                }
            }
        }
    }
}
