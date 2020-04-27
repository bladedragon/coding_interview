package linkedList.quickSort;

public class Solution {
    class ListNode{
        private int val;
        private ListNode next;
    }
    public void quickSort(ListNode head){
        quickSort( head, null);
    }

    private void quickSort(ListNode begin, Object end) {
        if (begin != end && begin.next != end) {
            ListNode p = partition(begin, end);
            quickSort(begin, p);
            quickSort(p.next, end);
        }

    }

    private ListNode partition(ListNode begin, Object end) {
        int baseVal = begin.val;
        ListNode base = begin;
        ListNode cur = base.next;
        while(cur != end){
            if(cur.val < baseVal){
                base = base.next;
                swap(base,cur);
            }
            cur = cur.next;
        }
        swap(begin,base);
        return base;
    }

    private void swap(ListNode base, ListNode cur) {
        int temp = base.val;
        base.val = cur.val;
        cur.val = temp;
    }
}
