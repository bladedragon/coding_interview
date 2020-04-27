package tree.maxdistance;


import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;
    int maxLeftLen;   // 从该节点向左走，最大距离
    int maxRightLen;  // 从该节点向右走，最大距离

    Node(int value) {
        this.data = value;
    }

}
public class Other {
    private int maxLen = 0;

    // 使用数组建立完全二叉树
    public Node buildTree(int[] datas) {
        Queue<Node> nodeQueue = new LinkedList<Node>();
        Node root = new Node(datas[0]);
        nodeQueue.add(root);

        for (int i = 1; i < datas.length; i++) {
            // 取出队列中的第一个元素
            Node current = nodeQueue.peek();
            if (current != null) {
                if (current.left == null) {
                    current.left = new Node(datas[i]);
                    nodeQueue.add(current.left);
                } else {
                    current.right = new Node(datas[i]);
                    nodeQueue.add(current.right);
                    nodeQueue.remove();
                }
            }
        }
        return root;
    }


    // findMaxLen能够计算出每个节点的左右子树的最大距离，并将该值+1保存在该节点的maxLeftLen和maxRightLen中
    public void findMaxLen(Node node) {
        if (node == null)
            return;

        // 如果该节点的左子树为空，则该从该节点向左走的最长距离为0
            if (node.left == null) {
                node.maxLeftLen = 0;
        }
        // 如果该节点的右子树为空，则该从该节点向右走的最长距离为0
        if (node.right == null) {
            node.maxRightLen = 0;
        }

        // 如果该节点的左子树不为空，递归的计算出该节点的左孩子节点的maxLeftLen和maxRightLen（并更新maxLen）
        if (node.left != null) {
            findMaxLen(node.left);
        }

        // 如果该节点的右子树不为空，递归的计算出该节点的右孩子节点的maxLeftLen和maxRightLen（并更新maxLen）
        if (node.right != null) {
            findMaxLen(node.right);
        }

        // 如果该节点的左子树不为空，那么该节点的maxLeftLen等于它的左孩子节点的maxLeftLen、maxRightLen中较大的那个 + 1
        if (node.left != null) {
            int maxLeftLenTemp = Math.max(node.left.maxLeftLen, node.left.maxRightLen) + 1;
            node.maxLeftLen = maxLeftLenTemp;
        }
        // 如果该节点的右子树不为空，那么该节点的maxRightLen等于它的右孩子节点的maxLeftLen、maxRightLen中较大的那个 + 1
        if (node.right != null) {
            int maxRightLenTemp = Math.max(node.right.maxLeftLen, node.right.maxRightLen) + 1;
            node.maxRightLen = maxRightLenTemp;
        }
        // 到这一步，当前处理的节点的maxLeftLen和maxLeftLen已经得到了，如果它的maxLeftLen+maxRightLen值比maxLen大，就可以更新maxLen
        if (maxLen < node.maxLeftLen + node.maxRightLen) {
            maxLen = node.maxLeftLen + node.maxRightLen;
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,5,6,7};
        Other solution = new Other();
        Node root = solution.buildTree(nums);
        solution.findMaxLen(root);
        System.out.println(solution.maxLen);
    }

}
