package linkedList.EntryNodeOfLoop;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        ListNode head = pHead;
        while(pHead != null){
            if(map.containsKey(pHead.val)){
                break;
            }
            map.put(pHead.val,1);
            pHead = pHead.next;
        }
        if(pHead == null){
            return null;
        }else{
            return pHead;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        Solution solution = new Solution();
        ListNode node = solution.EntryNodeOfLoop(head);
        System.out.println(node.val);
    }
}
