package linkedList.deleteDuplication;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * 要考虑头部重复删除头部的情况，最好使用哨兵进行优化
     * 注意同时删除两个的时候curNode要复原
     * 缺点：无法解决奇数次重复问题
     *
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication(ListNode pHead)
    {
        ListNode head = new ListNode(-1,null);
        ListNode prev = head;
        Map<Integer,ListNode> map = new HashMap<Integer,ListNode>();

        if(pHead == null || pHead.next == null){
            return pHead;
        }
        head.next = pHead;
        ListNode cur = pHead;
        while(prev.next != null && cur.next != null) {
            while(cur.next !=null && cur.next.val != prev.next.val){
                cur = cur.next;
            }
            if(cur.next != null){
                cur.next = cur.next.next;
                prev.next = prev.next.next;
                cur  = prev.next;
            }else{
                prev = prev.next;
                cur = prev.next;
            }
        }

        return head.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1,new ListNode(1,new ListNode(1,new ListNode(1,new ListNode(1,null)))));
        Solution solution = new Solution();
        ListNode res = solution.deleteDuplication(node);
        System.out.println(res.val);
    }
}