package linkedList.FromTailToHead;

import java.util.ArrayList;



public class Solution {

         public class ListNode {
             int val;
             ListNode next = null;

             ListNode(int val) {
                 this.val = val;
             }
         }


    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ListNode pre = null;
        while(listNode!= null){
            ListNode next = listNode.next;
            listNode.next = pre;
            pre = listNode;
            listNode = next;

        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        while(listNode.next!= null){
            list.add(listNode.val);
            listNode = listNode.next;
        }
        return list;
    }

}