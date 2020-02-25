package tree.kthMinNode;

import java.util.ArrayList;

public class Solution {
    ArrayList<TreeNode> list=  new ArrayList<TreeNode>();
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(pRoot == null){
            return null;
        }
        helper(pRoot);
        if(k>0 && k <= list.size())
            if(list.get(k-1) != null){
                return list.get(k-1);
            }
        return null;


    }

    void helper(TreeNode node){
        if(node == null){
            return;
        }
        helper(node.left);
        list.add(node);
        helper(node.right);
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
}
