package test;

/*
* 输入一个单向链表，输出该链表中倒数第k个结点，链表的倒数第1个结点为链表的尾指针。

链表结点定义如下：

struct ListNode

{

int       m_nKey;

ListNode* m_pNext;

};

详细描述：

接口说明

原型：

ListNode* FindKthToTail(ListNode* pListHead, unsignedint k);

输入参数：

ListNode* pListHead  单向链表

unsigned int k  倒数第k个结点

输出参数（指针指向的内存区域保证有效）：

无

返回值：

正常返回倒数第k个结点指针，异常返回空指针
* */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class 输出单向链表中倒数第k个结点 {

    public static void main(String[] args) throws IOException {
        BufferedReader bfd = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = bfd.readLine()) != null) {
            int num = Integer.parseInt(str);
            String[] strs = bfd.readLine().split(" ");
            String slen = bfd.readLine();
            int len = Integer.parseInt(slen);
            if (len > 0 && num - len >= 0) {
                System.out.println(strs[num - len]);
            } else {
                System.out.println(0);
            }
        }
    }
}
