package test;

/*
* 公元前五世纪，我国古代数学家张丘建在《算经》一书中提出了“百鸡问题”：鸡翁一值钱五，鸡母一值钱三，鸡雏三值钱一。百钱买百鸡，问鸡翁、鸡母、鸡雏各几何？

详细描述：

接口说明

原型：

int GetResult(vector &list)

输入参数：

        无

输出参数（指针指向的内存区域保证有效）：

    list  鸡翁、鸡母、鸡雏组合的列表

返回值：

     -1 失败

     0 成功
* */


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 百钱买百鸡问题 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while ((line = br.readLine()) != null) {
            int i;
            int j;
            for (i = 0; i <= 20; ++i) {
                for (j = 0; j <= 100 - i; ++j) {
                    int k = 100 - i - j;
                    if ((k % 3 == 0) && (5 * i + 3 * j + k / 3 == 100))
                        System.out.println(i + " " + j + " " + k);
                }
            }


        }
    }

}
