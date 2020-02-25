package tree.isSymmetrical;

import java.util.LinkedList;
import java.util.List;

public class Other_s {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    boolean isSymmetrical(TreeNode pRoot){
        if(pRoot == null){
            return true;
        }
        //只有LinkedList才有poll方法
        LinkedList<TreeNode> leftList = new LinkedList<TreeNode>();
        LinkedList<TreeNode> rightList = new LinkedList<TreeNode>();
        leftList.add(pRoot.left);
        rightList.add(pRoot.right);

        while(!leftList.isEmpty() && !rightList.isEmpty()){
            TreeNode left = leftList.poll();
            TreeNode right = rightList.poll();
            if(left == null & right ==null){
                continue;
            }
            if(left == null || right == null){
                return false;
            }
            if(left.val != right.val){
                return false;
            }
            leftList.add(left.left);
            leftList.add(left.right);
            rightList.add(right.right);
            rightList.add(right.left);
        }
        return leftList.isEmpty() && rightList.isEmpty();

    }

}
