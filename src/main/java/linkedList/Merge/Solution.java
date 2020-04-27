package linkedList.Merge;

public class Solution {
    class ListNode{
        private  int val;
        private ListNode next;

        ListNode(int val,ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    private ListNode Merge(ListNode list1,ListNode list2){
        ListNode head = new ListNode(-1,null);
            ListNode node = head;
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                head.next = new ListNode(list1.val,null);
                list1 = list1.next;
            }else{
                head.next = new ListNode(list2.val,null);
                list2 = list2.next;
            }
            head = head.next;
        }
        if(list1 != null){
            head.next = list2.next;
        }else{
            head.next = list1.next;
        }
        return node.next;
    }
}
