package tree.rebuildTree;

import java.util.Arrays;

public class Other_s {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 用法过期
     * 代码比较简洁
     */
//    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
//        if(pre.length == 0 || in.length ==0){
//            return null;
//        }
//        TreeNode root = new TreeNode(pre[0]);
//        for(int i =0;i<in.length;i++){
//            if(in[i] == pre[0]){
//                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1,i+1),
//                        Arrays.copyOfRange(in,0,i));
//                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre,i+1,pre.length),
//                        Arrays.copyOfRange(in,i+1,in.length));
//                break;
//            }
//        }
//        return root;
//
//    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in){
        if(pre.length == 0 || in.length ==0){
            return null;
        }
        //注意边界
        return rebuild(pre,0,pre.length-1,in,0,in.length-1);
    }

    private TreeNode rebuild(int[] pre, int pl, int pr, int[] in, int il, int ir) {

        if(pl>pr || il > ir){
            return null;
        }

        TreeNode root = new TreeNode(pre[pl]);
        int mid = 0;
        for(int i=il;i<=ir;i++){
            if(pre[pl] == in[i]){
                mid = i;
                break;
            }
        }

        int leftCount = mid-il;
        int rightCount = ir-mid;
        root.left = rebuild(pre,pl+1,pl+leftCount,in,il,mid-1);
        root.right = rebuild(pre,pr-rightCount+1,pr,in,mid+1,ir);
        return root;
    }

}
