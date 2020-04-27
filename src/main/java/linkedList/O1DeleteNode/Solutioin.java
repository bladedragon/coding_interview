package linkedList.O1DeleteNode;

public class Solutioin {
    class ListNode{
        private int val;
        private ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }
    public void O1DeleteNode(ListNode head,ListNode needDelete){
        if(needDelete.next != null){
            needDelete.val = needDelete.next.val;
            needDelete.next = needDelete.next.next;
        }else{
            ListNode node = head;
            while(node.next != null){
                node.next = node.next.next;
            }
        }
    }
}
