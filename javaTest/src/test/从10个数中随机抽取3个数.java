package test;

/*
 * 任意从键盘输入10个随机数字，数字范围为[-512,512]，然后从这10个数中随机抽取三个数，将这三个数x，y，z带入公式：x²+xy-y²+z中，要求必须保证输出的结果为所有组合结果的最小值。深入理解此题意，这个题其实是考数学中的排列组合问题，首先，需要先在10个输入的随机数中随机抽取三个数，那么10个数中取3个数，在排列组合保证不重复的情况下，会有120种排列组合结果，然后需要将每三个数为一组的排列组合对应带入x，y，z中进行公式值计算，那么问题又来了，比如这三个数某一种组合结果为2 1 3，那么请问：x，y，z分别应该对应哪个值呢？刚开始你会想如果都是正数的情况下，x取最小值，而对y取最大值，z取中间值，这样就能保证该公式带入计算的结果值为最小值，但是如果有负数或者全为负数的情况下，这个还成立吗？所以，我们又需要对这三个数 2 1 3进行x，y，z的全排列组合，不重复的排列组合结果一共有6种，然后我们将每一种的组合的值分别对应到x，y，z中，然后去计算带入该公式后的最小值，将所有结果进行保存到List中，然后最终计算完成，进行升序排序，取List中的第一个，即为所有排列组合带入公式计算出来的最小值！
 * */


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 从10个数中随机抽取3个数 {
    /**
     * 给定一个字符串数组，求字符串数组中所有字符串的全排列组合结果
     *
     * @param arr 需要排列组合的字符串数组
     * @param point 数组指针
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

    /**
     * 返回随机输入的整数数组
     *
     * @return
     */
    public static int[] getArray() {
        int[] arr = new int[10];
        int i = 0;
        while (i < 10) {
            System.out.println("请随意输入十个整数,范围是[-512,512] :");
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();
            if (num > 512 || num < -512) {
                System.out.println("您输入的数不合法，请输入一个范围在[-512,512]的整数!");
                continue;
            }
            arr[i] = num;
            i++;
        }
        return arr;
    }

    /**
     * 指定的数组中随机抽取三个数，然后带入公式:x的平方+xy-y的平方+z中，
     * 求出这十个数中随意随机出来的三个数带入这个公式的最小值
     *
     * @return
     */
    public static int getResult() {
        //存放每计算出来的三个随机数结果的集合
        ArrayList<Integer> resultList = new ArrayList<>();
        //从数组长度为10的数组中随机取出3个数，排列组合最终拿到的组合结果数组
        String[] combinationResult = extractPermutationResult.toString().split("\\|", -1);
        for (String c : combinationResult) {
            String[] strArr = c.split(",");
            //对每个随机抽取出来的三位数进行全排列组合
            fullPermutation(strArr, 0);
            //对每个随机抽取出来的三位数进行全排列组合之后的结果数组
            String[] fullPermutationResultArr = fullPermutationResult
                    //去掉fullPermutationResult字符串拼接的最后一个"|"
                    .delete(fullPermutationResult.length() - 1, fullPermutationResult.length())
                    .toString().split("\\|", -1);
            for (String s : fullPermutationResultArr) {
                String[] strNum = s.split(" ");
                int x = Integer.parseInt(strNum[0]);
                int y = Integer.parseInt(strNum[1]);
                int z = Integer.parseInt(strNum[2]);
                //带入华为题目中指定的公式对每个三位数组合进行结果值计算
                int result = (int) (Math.pow(x, 2) + x * y - Math.pow(y, 2) + z);
                //将每次计算的结果放入结果集合中进行保存
                resultList.add(result);
            }
        }
        //最终对结果集合进行升序排序
        Collections.sort(resultList);
        //返回所有排列组合计算出的最小结果值
        return resultList.get(0);
    }

    public static void main(String[] args) {
        int[] arr = getArray();
        extractPermutation(0, 3, arr);
        int result = getResult();
        System.out.println("结果是: " + result);
    }
}