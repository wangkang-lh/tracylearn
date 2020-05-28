package test;

/*
* 信息社会，有海量的数据需要分析处理，比如公安局分析身份证号码、 QQ 用户、手机号码、银行帐号等信息及活动记录。

采集输入大数据和分类规则，通过大数据分类处理程序，将大数据分类输出。*/


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class 数据分类处理 {
    public static void main(String[] args) throws Exception {
        BufferedReader bd = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while ((line = bd.readLine()) != null) {
            System.out.println(mapReduceData(line, bd.readLine()));
        }
        bd.close();
    }

    public static String mapReduceData(String inputStr, String ruleStr) {
        Map<Integer, String> indexWithVal = new LinkedHashMap<Integer, String>();
        String[] inputArr = inputStr.split(" ");
        String[] ruleArr = ruleStr.split(" ");
        Set<Integer> ruleSet = new TreeSet<>();
        for (int i = 1; i < ruleArr.length; i++) {
            ruleSet.add(Integer.valueOf(ruleArr[i]));
        }
        int count = 0;
        StringBuilder respSb = new StringBuilder();
        for (Integer rule : ruleSet) {
            String ruleItem = String.valueOf(rule);
            StringBuffer itemSb = new StringBuffer();
            for (int i = 1; i < inputArr.length; i++) {
                if (inputArr[i].contains(ruleItem)) {
                    indexWithVal.put(i - 1, inputArr[i]);
                }
            }
            if (!indexWithVal.isEmpty()) {
                itemSb.append(" ").append(ruleItem).append(" ").append(indexWithVal.size());
                count += indexWithVal.size() * 2 + 2;
                for (Map.Entry<Integer, String> entry : indexWithVal.entrySet()) {
                    itemSb.append(" ").append(entry.getKey()).append(" ").append(entry.getValue());
                }
                respSb.append(itemSb);
                indexWithVal.clear();
            }
        }
        return count > 0 ? count + respSb.toString() : respSb.toString();
    }
}
