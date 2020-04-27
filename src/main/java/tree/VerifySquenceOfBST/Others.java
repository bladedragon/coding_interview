package tree.VerifySquenceOfBST;

import tree.heap.getMidian.Other;

import java.util.Stack;

public class Others {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length < 1){
            return false;
        }else if(sequence.length < 3){
            return true;
        }
        int size = sequence.length;
        Stack<Integer> roots = new Stack<Integer>();
        Stack<Integer> mins = new Stack<Integer>();
        Stack<Integer> maxs = new Stack<Integer>();

        roots.push(sequence[size-1]);
        mins.push(Integer.MIN_VALUE);
        maxs.push(Integer.MAX_VALUE);
        for(int i =size-2;i>=0;i--){
            if(sequence[i] > sequence[i+1]){
                if(sequence[i] > maxs.peek()){
                    return false;
                }else{
                    mins.push(roots.peek());
                    maxs.push(maxs.peek());
                    roots.push(sequence[i]);
                }
            }else{
                if(sequence[i] < mins.peek()){
                    while(sequence[i] < mins.peek()){
                        maxs.pop();
                        mins.pop();
                        roots.pop();
                    }

                }
                    mins.push(mins.peek());
                    maxs.push(roots.peek());
                    roots.push(sequence[i]);

            }
        }
        return true;
    }

    public static void main(String[] args) {
        Others other = new Others();
        int[] seq = new int[]{4,8,6,12,16,14,10};
        boolean res = other.VerifySquenceOfBST(seq);
        System.out.println(res);
    }
}
