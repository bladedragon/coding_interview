package tree.FindPath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Others {

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        FindPath(res, new LinkedList<>(), root, 0, target);

        //数组进行排序
        res.sort(Comparator.comparingInt(list -> -list.size()));
//        Collections.sort(res, new Comparator<ArrayList<Integer>>() {
//            @Override
//            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
//                return o1.size()-o2.size();
//            }
//        });

        return res;
    }


    //使用LinkedList是为了能快速删除和添加尾节点
    private void FindPath(ArrayList<ArrayList<Integer>> res,
                          LinkedList<Integer> path,
                          TreeNode node,
                          int pathSum,
                          int target) {
        if (node == null) {
            return;
        }

        if (pathSum > target) {
            return;
        }

        //判断是否到底且sum达到target
        if (pathSum + node.val == target && node.right == null && node.left == null) {
            ArrayList<Integer> resPath = new ArrayList<>(path);
            resPath.add(node.val);
            res.add(resPath);
            return;
        }

        path.addLast(node.val);

        if (node.left != null) {
            FindPath(res, path, node.left, pathSum + node.val, target);
        }

        if (node.right != null) {
            FindPath(res, path, node.right, pathSum + node.val, target);
        }
        //将最后一个节点删除，因为需要递归？
        path.removeLast();
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {

    }
}
