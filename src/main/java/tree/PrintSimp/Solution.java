package tree.PrintSimp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        int size = 1;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<ArrayList<Integer> > list = new ArrayList<ArrayList<Integer>>();

        if(pRoot ==null){
            return list;
        }
        queue.add(pRoot);
        while(!queue.isEmpty()){
            ArrayList<Integer> row = new ArrayList<Integer>();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(node == null){
                    continue;
                }
                row.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }

            if(row.size() !=0){
                list.add(row);
            }
            size = queue.size();
        }
        return list;
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
