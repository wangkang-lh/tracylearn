package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
/*开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。


        处理：


        1、 记录最多8条错误记录，循环记录（或者说最后只输出最后出现的八条错误记录），对相同的错误记录（净文件名称和行号完全匹配）只记录一条，错误计数增加；


        2、 超过16个字符的文件名称，只记录文件的最后有效16个字符；


        3、 输入的文件可能带路径，记录文件名称不能带路径。*/

public class 简单错误记录 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String messageLine = null;
        //使用有序的LinkedHashMap存储信息
        Map<String, Integer> map = new LinkedHashMap<String, Integer>();
        //循环读入数据
        while ((messageLine = bufferedReader.readLine()) != null) {
            String[] error_Message = messageLine.split(" ");
            String error = error_Message[0];
            String line_no = error_Message[1];
            //取文件名
            String file_Name = error.substring(error.lastIndexOf("\\") + 1);
            //处理长度超过16的情况
            if (file_Name.length() > 16) {
                file_Name = file_Name.substring(file_Name.length() - 16);
            }

            //将错误信息添加到map中
            String error_Name = file_Name + " " + line_no;
            if (map.containsKey(error_Name)) {
                map.put(error_Name, map.get(error_Name) + 1);
            } else {
                map.put(error_Name, 1);
            }
        }

        //输出错误信息,最多8条(后八条)
        int count = 0;
        for (String key : map.keySet()) {
            count++;
            if (count > (map.size() - 8))
                System.out.println(key + " " + map.get(key));
        }
    }
}

