package test;

import java.util.Scanner;

//题目描述
//写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于5,向上取整；小于5，则向下取整。
public class 取近似值 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double d=scanner.nextDouble();
        System.out.println(getReturn(d));
    }

    public static int getReturn(double d) {
        int i=(int)d;
        return  (d-i)>=0.5?i+1:i;
    }
}
