package test;

/*
* 题目标题：

将两个整型数组按照升序合并，并且过滤掉重复数组元素[注: 题目更新了。输出之后有换行]

详细描述：

接口说明

原型：

voidCombineBySort(int* pArray1,intiArray1Num,int* pArray2,intiArray2Num,int* pOutputArray,int* iOutputNum);

输入参数：

int* pArray1 ：整型数组1

intiArray1Num：数组1元素个数

int* pArray2 ：整型数组2

intiArray2Num：数组2元素个数

输出参数（指针指向的内存区域保证有效）：

int* pOutputArray：合并后的数组

int* iOutputNum：合并后数组元素个数

返回值：

void
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class 整形数组合并 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            int n = Integer.parseInt(line);
            String[] a = br.readLine().split(" ");
            int m = Integer.parseInt(br.readLine());
            String[] b = br.readLine().split(" ");
            TreeSet<Integer> set = new TreeSet<>();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < n; i++) {
                set.add(Integer.parseInt(a[i]));
            }
            for (int i = 0; i < m; i++) {
                set.add(Integer.parseInt(b[i]));
            }
            for (Integer c : set) {
                sb.append(c);
            }
            System.out.println(sb);
        }
    }
}