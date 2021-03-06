package linkedList.EntryNodeOfLoop;

public class Other_s {


     public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }



        public ListNode EntryNodeOfLoop(ListNode pHead)
        {
            if(pHead == null){
                return null;
            }
            // 1.判断链表中有环
            ListNode l=pHead,r=pHead;
            boolean flag = false;
            while(r != null && r.next!=null){
                l=l.next;
                r=r.next.next;
                if(l==r){
                    flag=true;
                    break;
                }
            }
            if(!flag){
                return null;
            }else{
                // 2.得到环中节点的数目
                int n=1;
                r=r.next;
                while(l!=r){
                    r=r.next;
                    n++;
                }
                // 3.找到环中的入口节点
                l=r=pHead;
                for(int i=0;i<n;i++){
                    r=r.next;
                }
                while(l!=r){
                    l=l.next;
                    r=r.next;
                }
                return l;
            }

        }

}
