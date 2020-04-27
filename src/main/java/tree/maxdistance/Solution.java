package tree.maxdistance;

public class Solution {

    public static void maxDistance(TreeNode root, Result res){
        if(root == null)
            return;

        Result lhs = new Result();
        Result rhs = new Result();
        maxDistance(root.left, lhs); //左子树的最大高度及最远距离
        maxDistance(root.right, rhs); //右子树的最大高度及最远距离
        res.maxHeight = Math.max(lhs.maxHeight, rhs.maxHeight) + 1;
        res.maxDistance = Math.max(Math.max(lhs.maxDistance, rhs.maxDistance), lhs.maxHeight + rhs.maxHeight + 2);
    }

    private static class Result{
        private int maxDistance = 0;
        private int maxHeight = -1;
    }

    private static class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

}
