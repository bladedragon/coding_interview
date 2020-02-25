package tree.getNext;

import java.util.*;

public class Solution {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    List<TreeLinkNode> list = new ArrayList<TreeLinkNode>();
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        TreeLinkNode root = pNode;
        while(root.next != null){
            root = root.next;
        }
        Dfs(root);
        for(int i =0;i<list.size();i++){
            if(pNode == list.get(i)){
                if(i+1 != list.size()){
                    return list.get(i+1);
                }
            }
        }
        return null;

    }
    public void Dfs(TreeLinkNode node ){

        if(node.left != null){
            Dfs(node.left);
        }

        list.add(node);

        if(node.right != null){
            Dfs(node.right);
        }
    }
}
