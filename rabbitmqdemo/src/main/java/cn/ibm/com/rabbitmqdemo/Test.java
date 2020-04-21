package cn.ibm.com.rabbitmqdemo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

//需求：从一个文件中读取文件的内容
public class Test {
    public static void main(String[] args) throws IOException {
        //1. 首先 你要知道文件的路径
        String path = "C:\\Users\\KangWang\\Desktop\\xiuqu.txt";
        // 创建字符流对象，并根据已创建的字节流对象创建字符流对象
        try (FileInputStream fis = new FileInputStream(path);
             InputStreamReader isr = new InputStreamReader(fis);
             BufferedReader raf = new BufferedReader(isr)) {
            String s = null;
            //读取文件内容，并将其打印
            while ((s = raf.readLine()) != null) {
                System.out.println(s);
            }
        }
    }
}
