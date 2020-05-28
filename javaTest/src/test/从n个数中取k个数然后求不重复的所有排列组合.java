package test;
/*
从n个数中取k个数，然后求不重复的所有排列组合
* */

import java.util.ArrayList;

public class 从n个数中取k个数然后求不重复的所有排列组合 {
    //临时保存结果的集合
    private static ArrayList<Integer> tmpList = new ArrayList<>();
    //保存结果的字符串
    private static StringBuffer extractPermutationResult = new StringBuffer();

    /**
     * 给一个长度为n任意数组，取其中k个数，求所有的排列组合
     *
     * @param index 首个索引下标
     * @param count 每次取几个数,即数组指针
     * @param arr   待取的长度任意数组
     */
    public static void extractPermutation(int index, int count, int[] arr) {
        if (count > arr.length || arr.length <= 0) {
            System.out.println("随机取数个数不能大于数组的长度或者数组不能为空!");
            return;
        }

        if (count == 1) {
            for (int i = index; i < arr.length; i++) {
                tmpList.add(arr[i]);
                for (Integer integer : tmpList) {
                    extractPermutationResult.append(integer).append(",");
                }
                extractPermutationResult.delete(extractPermutationResult.length() - 1, extractPermutationResult.length()).append("|");
                System.out.println(tmpList);
                tmpList.remove((Object) arr[i]);
            }
        } else if (count > 1) {
            for (int i = index; i <= arr.length - count; i++) {
                tmpList.add(arr[i]);
                extractPermutation(i + 1, count - 1, arr);
                tmpList.remove((Object) arr[i]);
            }
        } else {
            return;
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        extractPermutation(0, 3, arr);
        System.out.println(extractPermutationResult);
    }
}