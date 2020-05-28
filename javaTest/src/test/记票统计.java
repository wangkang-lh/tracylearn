package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

/*
* 请实现接口：

unsigned int  AddCandidate (char* pCandidateName);
功能：设置候选人姓名
输入： char* pCandidateName 候选人姓名
输出：无
返回：输入值非法返回0，已经添加过返回0 ，添加成功返回1



Void Vote(char* pCandidateName);
功能：投票
输入： char* pCandidateName 候选人姓名
输出：无
返回：无


unsigned int  GetVoteResult (char* pCandidateName);

功能：获取候选人的票数。如果传入为空指针，返回无效的票数，同时说明本次投票活动结束，释放资源
输入： char* pCandidateName 候选人姓名。当输入一个空指针时，返回无效的票数

输出：无
返回：该候选人获取的票数



void Clear()

// 功能：清除投票结果，释放所有资源
// 输入：
// 输出：无
// 返回
* */
public class 记票统计 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while ((line = rd.readLine()) != null && (line = line.trim()) != null) {
            String[] joinArr = rd.readLine().trim().split(" ");
            LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();
            for (String item : joinArr) {
                map.put(item, 0);
            }
            int VolitsCount = Integer.parseInt(rd.readLine().trim());    //参见投票的人数
            String[] voteArr = rd.readLine().trim().split(" ");
            int noVoteCount = 0;
            for (String item : voteArr) {
                if (map.containsKey(item)) {
                    map.put(item, map.get(item) + 1);
                } else {
                    noVoteCount++;
                }
            }
            for (Map.Entry<String, Integer> item : map.entrySet()) {
                System.out.println(item.getKey() + " : " + item.getValue());
            }
            System.out.println("Invalid : " + noVoteCount);
        }
    }
}
