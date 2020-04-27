package tree.getNext;

public class Others {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public TreeLinkNode GetNext(TreeLinkNode pNode){

        TreeLinkNode node = pNode;
        //右子树存在，
        if(pNode.right !=null){
            TreeLinkNode rightNode = pNode.right;
            while(rightNode.left!=null){
                rightNode = rightNode.left;
            }
            return rightNode;
        }
        if(pNode.next != null && pNode.next.left == pNode){
            return pNode.next;
        }
        if(pNode.next != null){
            TreeLinkNode nodeNext = pNode.next;
            while(nodeNext.next != null && nodeNext.next.left != nodeNext){
                nodeNext = nodeNext.next;
            }
            return nodeNext.next;
        }
        return null;
    }

    //上述代码可以合并

    public TreeLinkNode GetNext2(TreeLinkNode pNode){
        if(pNode == null) return null;

        if(pNode.right != null){
            pNode = pNode.right;
            while(pNode.left != null)
                {pNode = pNode.left;}
            return pNode;
        }

        //将两种情况合并
        while(pNode.next != null){
            if(pNode.next.left == pNode)
                {return pNode.next;}
            pNode = pNode.next;
        }
        return null;
    }

}
