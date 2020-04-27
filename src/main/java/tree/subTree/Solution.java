package tree.subTree;


public class Solution {
    public boolean isSubTree(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 == null || root2 == null){
            return false;
        }
        //这里的判断多余了
        if(root1.val == root2.val){
            return judgeTreeNode(root1,root2);
        }else{
            return isSubTree(root1,root2.left) || isSubTree(root1,root2.right);
        }
    }

    private boolean judgeTreeNode(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 == null || root2 == null){
            return false;
        }
        if(root1.val != root2.val){
            return false;
        }
        return judgeTreeNode(root1.left,root2.left) && judgeTreeNode(root1.right, root2.right);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }
        public TreeNode(int val,TreeNode left,TreeNode right){
            this.val = val;
            this.left = left;
            this.right  = right;
        }
    }
}
