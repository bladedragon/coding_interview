package linkedList.deleteDuplication;

import java.util.HashSet;

public class Other {
    /**借助辅助空间
     *
     */

//    public ListNode deleteDuplication(ListNode pHead){
//        if(pHead == null){
//            return  null;
//        }
//        // 先找出相同结点，存入 set
//        HashSet<Integer> set = new HashSet<Integer>();
//        ListNode pre = pHead;
//        ListNode cur = pHead.next;
//        while(cur != null){
//            if(cur.val == pre.val){
//                set.add(cur.val);
//            }
//            pre = cur;
//            cur = cur.next;
//        }
//        // 再根据相同节点删除
//        // 先删头部
//        while(pHead != null && set.contains(pHead.val)){
//            pHead = pHead.next;
//        }
//        if(pHead == null){
//            return null;
//        }
//        // 再删中间结点
//        pre = pHead;
//        cur = pHead.next;
//        while(cur != null){
//            if(set.contains(cur.val)){
//                pre.next = cur.next;
//                cur = cur.next;
//            }else{
//                pre = cur;
//                cur = cur.next;
//            }
//        }
//        return pHead;
//    }
    public class Solution {
        public ListNode deleteDuplication(ListNode pHead){
            if(pHead == null || pHead.next == null){
                return pHead;
            }
            // 自己构建辅助头结点
            ListNode head = new ListNode(Integer.MIN_VALUE,null);
            head.next = pHead;
            ListNode pre = head;
            ListNode cur = head.next;
            while(cur!=null){
                if(cur.next != null && cur.next.val == cur.val){
                    // 相同结点一直前进
                    while(cur.next != null && cur.next.val == cur.val){
                        cur = cur.next;
                    }
                    // 退出循环时，cur 指向重复值，也需要删除，而 cur.next 指向第一个不重复的值
                    // cur 继续前进
                    cur = cur.next;
                    // pre 连接新结点
                    pre.next = cur;
                }else{
                    pre = cur;
                    cur = cur.next;
                }
            }
            return head.next;
        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1,new ListNode(1,new ListNode(1,new ListNode(2,new ListNode(2,null)))));
        linkedList.deleteDuplication.Solution solution = new linkedList.deleteDuplication.Solution();
        ListNode res = solution.deleteDuplication(node);
        System.out.println(res.val);
    }
}
