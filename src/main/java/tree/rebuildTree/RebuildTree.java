package tree.rebuildTree;

import javax.swing.tree.TreeNode;
import java.util.Arrays;

public class RebuildTree {

  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {


        TreeNode root = new TreeNode(pre[0]);
        rebuild(root, pre, 0, pre.length, in, 0, in.length);
        return root;
    }

    public void rebuild(TreeNode root,int[] pre,int pl,int pr,int[] in ,int il,int ir){

      for(int i=il;i<ir;i++){
          if(in[i] == pre[pl]){
              int t = i-il;
              if(t>0) {
                  root.left = new TreeNode(pre[pl + 1]);
                  rebuild(root.left, pre, pl + 1, pl + 1+t, in, il, i);
              }
              if(pr-pl-1-t > 0) {
                  root.right = new TreeNode(pre[pl+1+t]);
                  rebuild(root.right,pre,pl+1+t,pr,in,i+1,ir);

              }
              break;
          }
      }
  }

    public static void main(String[] args) {

    }
}
