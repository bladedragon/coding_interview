package linkedList.FromTailToHead;

import java.util.ArrayList;

public class Other_s {
    /**
     * 非递归
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        ListNode tmp = listNode;
        while(tmp!=null){
            //关键在于这个add方法
            //add方法当插入的index已经有值的时候会将原来的元素向后搬移
            list.add(0,tmp.val);
            tmp = tmp.next;
        }
        return list;
    }

    /**
     * 递归方法
     * @param listNode
     * @return
     */
    ArrayList<Integer> list = new ArrayList<Integer>();
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        if(listNode!=null){
            printListFromTailToHead(listNode.next);
            list.add(listNode.val);
        }
        return list;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(0,1);
        list.add(0,2);
        for (Integer i : list) {
            System.out.println(i);

        }

    }
}
