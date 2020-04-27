package stack.IsPopOrder;

import java.util.Stack;

public class Solution {
    public boolean isPopOrder(int[] pushA,int[] popA){

        Stack<Integer> stack = new Stack<Integer>();
        int a  = 0;
        int b = 0;
        boolean res = true;
        while(b<popA.length){

            if(!stack.empty() && stack.peek() == popA[b]){
                stack.pop();
                b++;
            }else if(a < pushA.length){
                stack.push(pushA[a]);
                a++;
            }else{
                res = false;
                break;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5};
        int[] b = new int[]{4,5,3,2,1};
        int[] pushB = new int[]{3,2,1,5,4};
        Solution solution = new Solution();
        System.out.println(solution.isPopOrder(a,pushB));
    }
}

//if(a < pushA.length && pushA[a] == popA[b]){
//        a++;
//        b++;
//        }else