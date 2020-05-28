package test;

/*
* 查找和排序

题目：输入任意（用户，成绩）序列，可以获得成绩从高到低或从低到高的排列,相同成绩
都按先录入排列在前的规则处理。

例示：
jack      70
peter     96
Tom       70
smith     67

从高到低  成绩
peter     96
jack      70
Tom       70
smith     67

从低到高

smith     67

Tom       70
jack      70

peter     96

注：0代表从高到低，1代表从低到高
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 成绩排序 {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String str;
            while ((str = reader.readLine()) != null) {
                //获取要排序的人的个数
                int count = Integer.parseInt(str);
                //获取输入的排序方法(升序还是降序),0为降序，1为升序
                int sortType = Integer.parseInt(reader.readLine());
                // 姓名和分数
                String[] users = new String[count];
                int[] scores = new int[count];

                // 遍历每一个人
                for (int i = 0; i < count; i++) {
                    String line = reader.readLine();
                    String[] parts = line.split(" ");  // 第i个人姓名加分数
                    String user = parts[0];   // 分离出第i个人的姓名
                    int score = Integer.parseInt(parts[1]);  // 分离出第i个人的分数
                    if (sortType == 0) {       // 降序情况
                        int j = 0;
                        for (j = i - 1; j >= 0; j--) {
                            if (scores[j] < score) {   //i前面一个人j的分数如果小于第i个人，则第j往后排一位，循环完后，j值减1
                                scores[j + 1] = scores[j];
                                users[j + 1] = users[j];
                            } else {
                                break;
                            }
                        }
                        //j+1的位置就是i要插入的位置
                        scores[j + 1] = score;
                        users[j + 1] = user;
                    } else {
                        int j = 0;
                        for (j = i - 1; j >= 0; j--) {
                            if (scores[j] > score) {
                                scores[j + 1] = scores[j];
                                users[j + 1] = users[j];
                            } else {
                                break;
                            }
                        }
                        scores[j + 1] = score;
                        users[j + 1] = user;
                    }
                }
                for (int i = 0; i < count; i++) {
                    System.out.println(users[i] + " " + scores[i]);
                }
            }
        } catch (IOException e) {
        }
    }
}