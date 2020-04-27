package tree.FindPath;

import java.util.ArrayList;

public class Solution {
    private ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {

        if(root == null){
            //因为是在一个函数里递归，同时result是类变量，使用的相同的引用，因此只会返回函数最后的result
            return result;
        }
        list.add(root.val);
        target-= root.val;

        if(target == 0 && root.left ==null && root.right == null){
            //这步很关键，
            //因为result.add(list)是吧list这个对象的引用地址添加到result了，
            // result中的元素就会共用list，而list是我们用来存放当前路径的地方，因此我们需要复制一份之后加入result数组中
            result.add(new ArrayList<Integer>(list));
            //这里不能直接return，否则无法将list最后节点删除
        }

        FindPath(root.left,target);
        FindPath(root.right,target);
        //重点！！当所有函数递归到叶子节点时，回溯要删除上一个节点（因为要复用，使用的同一个list引用）
        list.remove(list.size()-1);

        //只有这个是有效的
        return result;
    }



    private ArrayList<ArrayList<Integer>> result2 = new ArrayList<ArrayList<Integer>>();
    public ArrayList<ArrayList<Integer>> FindPath2(TreeNode root,int target) {
        find(root,target,new ArrayList<Integer>());
        return result2;
    }
    public void find(TreeNode node,int target,ArrayList<Integer> list){
        if(node == null){
            return ;
        }
        list.add(node.val);
        if(target == node.val && node.left == null && node.right == null){
            result2.add(new ArrayList<Integer>(list));
        }
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        //保存左子树递归的轨迹
        list2.addAll(list);
        find(node.left,target-node.val,list);
        find(node.right,target-node.val,list2);
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
