package tree.Convert;

import java.util.ArrayList;
import java.util.Stack;

//中序遍历非递归写法
//栈的弹出等于递归返回上一层
public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode Convert(TreeNode root) {
        if(root==null)
            return null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        TreeNode pre = null;// 用于保存中序遍历序列的上一节点
        boolean isFirst = true;
        while(p!=null||!stack.isEmpty()){
            //首先从最左开始压入栈
            while(p!=null){
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            if(isFirst){
                root = p;// 将中序遍历序列中的第一个节点记为root，
                pre = root;
                isFirst = false;
            }else{
                pre.right = p;
                p.left = pre;
                pre = p;
            }
            p = p.right;
        }
        return root;
    }

    //第二种方法
    TreeNode lastNodeList = null;
    public TreeNode Convert1(TreeNode pRootOfTree) {
        inOrderConvert(pRootOfTree);
        //寻找链表头节点
        while (lastNodeList != null && lastNodeList.left != null)
            lastNodeList = lastNodeList.left;
        return lastNodeList;
    }
    public void inOrderConvert(TreeNode root) {
        if (root == null)
            return;
        if (root != null) {
            inOrderConvert(root.left);
            //构建反向链表，反正遍历一遍不会再遍历到这个节点了，所以更改左节点不影响
            root.left = lastNodeList;
            if (lastNodeList != null)
                lastNodeList.right = root;
            //两个作用：1、头节点初始化 2、将节点向后位移，构建正向链表
            lastNodeList = root;
            inOrderConvert(root.right);
        }
    }

    //第三种方法，改进递归法

    // 记录子树链表的最后一个节点，终结点只可能为只含左子树的非叶节点与叶节点
    protected TreeNode leftLast = null;
    public TreeNode Convert2(TreeNode root) {
        if(root==null)
            return null;
        if(root.left==null&&root.right==null){
            leftLast = root;// 最后的一个节点可能为最右侧的叶节点
            return root;
        }
        // 1.将左子树构造成双链表，并返回链表头节点
        TreeNode left = Convert(root.left);
        // 3.如果左子树链表不为空的话，将当前root追加到左子树链表
        if(left!=null){
            leftLast.right = root;
            root.left = leftLast;
        }
        leftLast = root;// 当根节点只含左子树时，则该根节点为最后一个节点
        // 4.将右子树构造成双链表，并返回链表头节点
        TreeNode right = Convert(root.right);
        // 5.如果右子树链表不为空的话，将该链表追加到root节点之后
        if(right!=null){
            right.left = root;
            root.right = right;
        }
        return left!=null?left:root;
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        char[] chars = "".toCharArray();
    }

}
