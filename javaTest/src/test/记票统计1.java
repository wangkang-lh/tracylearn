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
public class 记票统计1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while((line=br.readLine())!=null&&(line=line.trim())!=null )
        {
            int N = Integer.parseInt(line);
            String[] Candidates = br.readLine().trim().split(" ");   //候选人
            Map<String,Integer> map = new LinkedHashMap<String,Integer>();
            for(String s:Candidates) map.put(s,0);
            int VolitsCount = Integer.parseInt(br.readLine().trim());    //参见投票的人数
            String[] Volits = br.readLine().trim().split(" ");

            int InvalidC = 0;

            for(String s:Volits)
                if(map.containsKey(s))
                    map.put(s, map.get(s)+1);
                else
                    ++InvalidC;

            for(Map.Entry<String, Integer> entry:map.entrySet())
                System.out.println(entry.getKey()+" : "+entry.getValue());

            System.out.println("Invalid : "+InvalidC);
        }
    }
}
