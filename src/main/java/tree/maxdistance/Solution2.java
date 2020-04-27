package tree.maxdistance;

public class Solution2 {

        private int maxLen = 0;

        // 该方法返回从root节点出发，向左或向右所能走的最远距离（该方法的返回值并非是整个树的最远距离，而是它的左子树最远距离和右子树最远距离两者中的较大值）
        // maxLen用于保存整个二叉树的最远距离
        public int findMaxLen(Node root) {
            if (root == null) {
                return 0;
            }
            if (root.left == null && root.right == null) {
                return 0;
            }
            int leftMaxLen = findMaxLen(root.left) + 1;
            int rightMaxLen = findMaxLen(root.right) + 1;

            int maxTemp = leftMaxLen + rightMaxLen;

            if (maxTemp > maxLen) {
                maxLen = maxTemp;
            }

            return leftMaxLen > rightMaxLen ? leftMaxLen : rightMaxLen;
        }

    class Node {
        int data;
        Node left;
        Node right;

        Node(int value) {
            this.data = value;
        }
    }

}
