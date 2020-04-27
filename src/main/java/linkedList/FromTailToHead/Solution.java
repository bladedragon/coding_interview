package linkedList.FromTailToHead;

import java.util.ArrayList;
import java.util.Stack;


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

    public ArrayList<Integer> printListFromTailToHead2(ListNode node){
             ListNode pre = null;
             Stack<Integer> stack = new Stack<Integer>();
             ArrayList<Integer> list = new ArrayList<Integer>();
             while(node.next != null){
                 stack.add(node.val);
             }
             while(!stack.isEmpty()){
                 list.add(stack.pop());
             }
            return list;
    }

}