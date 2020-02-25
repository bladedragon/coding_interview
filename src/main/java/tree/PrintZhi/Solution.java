package tree.PrintZhi;

import java.util.*;

public class Solution {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        int size = 1;
        //改良，直接使用boolean变量
        boolean layer = false;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if (pRoot == null) {
            return list;
        }
        queue.add(pRoot);
        while (!queue.isEmpty() && size != 0) {
            int tempSize = 0;
            ArrayList<Integer> row = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node == null) {
                    continue;
                }
                if (node.left != null) {
                    row.add(node.left.val);
                    tempSize++;
                }
                if (node.right != null) {
                    row.add(node.right.val);
                    tempSize++;
                }
                //queue压入顺序不变
                queue.offer(node.left);
                queue.offer(node.right);
            }
            if (!layer) {
                Collections.reverse(row);
            }

            size = queue.size();
            layer = !layer;
            if (row.size() != 0) {
                list.add(row);
            }
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

    public static void main(String[] args) {
        System.out.print(1);
    }
}




