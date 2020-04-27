package tree.VerifySquenceOfBST;

public class Solution {
    public boolean verifySqyenceOfBST(int[] sequence){
        if(sequence == null || sequence.length == 0){
            return false;
        }
        return BST(sequence, 0,sequence.length-1);
    }

    private boolean BST(int[] sequence, int start, int end) {
        if(start >= end){
            return true;
        }
        int key = sequence[end];
        int i;
        for(i=start;i<end;i++){
            if(sequence[i] > key){
                break;
            }
        }
        int j =i;
        for(;i<end;i++){
            if(sequence[i] < key){
                return false;
            }

        }
        return BST(sequence,start,j-1) && BST(sequence,j,end-1);

    }
}
