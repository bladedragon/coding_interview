package tree.isSymmetrical;

public class ReverseTree {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
        boolean isSymmetrical(TreeNode pRoot)
        {
            if(pRoot == null){
                return true;
            }
            return symmetrical(pRoot.left,pRoot.right);
        }

        boolean symmetrical(TreeNode node1,TreeNode node2){
            if(node1 == null&& node2 == null){
                return true;

            }
            if(node1 ==null || node2 ==null){
                return false;
            }
            if(node1.val != node2.val){
                return false;
            }
            return symmetrical(node1.left,node2.right) && symmetrical(node1.right,node2.left);
        }
}
