package linkedList.complicateClone;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Solution {
    public static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }


    public RandomListNode clone(RandomListNode pHead){
        Map<Integer,RandomListNode> map =  new HashMap<Integer,RandomListNode>();
//        RandomListNode root = new RandomListNode(-1);
        RandomListNode node = new RandomListNode(pHead.label);
        map.put(pHead.label,node);
        if(pHead.random != null){
            node.random = new RandomListNode(pHead.random.label);
            //可能会覆盖
            map.put(pHead.label,node.random);
        }
        RandomListNode res = node;

        while(pHead.next != null){

            pHead = pHead.next;

            RandomListNode nNode;
            //添加节点
            if(map.containsKey(pHead.label)){
                node.next = map.get(pHead.label);
            }else{
                node.next = new RandomListNode(pHead.label);
                map.put(pHead.label,node.next);
            }

            //复制rnadom节点
            if(pHead.random != null){
                if(map.containsKey(pHead.random.label)){
                    node.next.random = map.get(pHead.random.label);
                }else{
                    RandomListNode rNode = new RandomListNode(pHead.random.label);
                    node.next.random = rNode;
                }
            }
            node = node.next;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        RandomListNode node= solution.clone(new RandomListNode(-1));
        System.out.println(node.label);
    }
}
