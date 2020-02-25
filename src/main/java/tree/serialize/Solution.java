package tree.serialize;

import tree.rebuildTree.RebuildTree;

public class Solution {
    int index = -1;
    String Serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        if(root == null){
            return "#";
        }
        traverse(root,builder);
        return builder.toString();
    }



    TreeNode Deserialize(String str) {
        if(str == null || str == "#" ){
            return null;
        }
        String[] strs = str.split("!");
        TreeNode node = anti_traverse(strs);
        return node;
    }

    TreeNode anti_traverse(String[] strs){

        index++;
        if(strs.length == 0 || strs[index].equals("#")){
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(strs[index]));
        node.left = anti_traverse(strs);
        node.right = anti_traverse(strs);

        return node;
    }

    void traverse(TreeNode node,StringBuilder str){
        if(node == null){
            str.append("#!");
            return;
        }
        str.append(node.val);
        str.append("!");
        traverse(node.left,str);
        traverse(node.right,str);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        String s = "";
        s.toCharArray();
        char c = '1';
        s = s+c;

    }
}
