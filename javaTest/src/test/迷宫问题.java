package test;

/*
定义一个二维数组N*M（其中2<=N<=10;2<=M<=10），如5 × 5数组下所示：


int maze[5][5] = {


        0, 1, 0, 0, 0,


        0, 1, 0, 1, 0,


        0, 0, 0, 0, 0,


        0, 1, 1, 1, 0,


        0, 0, 0, 1, 0,


};


它表示一个迷宫，其中的1表示墙壁，0表示可以走的路，只能横着走或竖着走，不能斜着走，要求编程序找出从左上角到右下角的最短路线。入口点为[0,0],既第一空格是可以走的路。

Input

一个N × M的二维数组，表示一个迷宫。数据保证有唯一解,不考虑有多解的情况，即迷宫只有一条通道。

Output

左上角到右下角的最短路径，格式如样例所示。

Sample Input

0 1 0 0 0

0 1 0 1 0

0 0 0 0 0

0 1 1 1 0

0 0 0 1 0

Sample Output

(0, 0)

(1, 0)

(2, 0)

(2, 1)

(2, 2)

(2, 3)

(2, 4)

(3, 4)

(4, 4)
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class 迷宫问题 {
    public static void main(String[] arsg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;

        while ((str = br.readLine()) != null) {
            String[] rowAndColumn = str.split(" ");

            int N = Integer.valueOf(rowAndColumn[0]);//行
            int M = Integer.valueOf(rowAndColumn[1]);//列
            if (N >= 2 && N <= 10 && M >= 2 && M <= 10) {
                int[][] maza = new int[N][M];
                int row = 0;
                while (row < N) {
                    str = br.readLine();
                    String[] inputs = str.split(" ");
                    if (inputs.length == M) {
                        for (int i = 0; i < M; i++) {
                            maza[row][i] = Integer.valueOf(inputs[i]);
                        }
                    }
                    row++;
                }

                findShortestPath(maza);
            }
        }
    }

    public static void findShortestPath(int[][] maza) {
        //不考虑多解情况，迷宫只有一条通道
        //可以横着走或者竖着走
        int i = 0;
        int j = 0;
        while (i < maza.length) {
            while (j < maza[0].length) {
                if (maza[i][j] == 0) {
                    printPath(i, j);
                    j++;//右
                } else {//下
                    j--;
                    i++;
                }
            }
            i++;
            if (j == maza[0].length) j--;//下
        }
    }

    public static void printPath(int i, int j) {
        System.out.println("(" + i + "," + j + ")");
    }
}
