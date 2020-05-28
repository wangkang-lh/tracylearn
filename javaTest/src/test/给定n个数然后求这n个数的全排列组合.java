package test;

/*
 * 给定一个字符串数组，求字符串数组中所有字符串的全排列组合结果
 * */
public class 给定n个数然后求这n个数的全排列组合 {

    /**
     * 给定一个字符串数组，求字符串数组中所有字符串的全排列组合结果
     *
     * @param arr 需要排列组合的字符串数组
     * @param point 数组索引指针
     */
    private static StringBuffer fullPermutationResult = new StringBuffer();

    public static void fullPermutation(String arr[], int point) {
        if (point == arr.length) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
                fullPermutationResult.append(arr[i] + " ");
            }
            fullPermutationResult.append("|");
            System.out.println();
        }

        for (int i = point; i < arr.length; i++) {
            String temp1 = arr[point];
            arr[point] = arr[i];
            arr[i] = temp1;
            fullPermutation(arr, point + 1);
            String temp2 = arr[point];
            arr[point] = arr[i];
            arr[i] = temp2;
        }
    }

    public static void main(String[] args) {
        String[] strArr = new String[]{"12", "-5", "8"};
        fullPermutation(strArr, 0);
        fullPermutationResult.delete(fullPermutationResult.length() - 1, fullPermutationResult.length());
        System.out.println("================================");
        String[] split = fullPermutationResult.toString().split("\\|", -1);
        for (String s : split) {
            System.out.println(s);
        }
    }
}