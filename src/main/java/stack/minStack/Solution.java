package stack.minStack;

import java.util.Stack;

/**
 * 注意加非空判断
 * 每次记录最小值。弹出的时候一并弹出
 */
public class Solution {
    private Stack<Integer> stack = new Stack<Integer>();
    private Stack<Integer> min = new Stack<Integer>();

    public void push(Integer node){

        if(min.peek() > node){
            min.push(node);
        }else{
            min.push(min.peek());
        }
        stack.push(node);
    }

    public Integer pop(){
        Integer node = stack.pop();
        min.pop();
        return node;
    }

    public Integer min(){
        return min.peek();
    }
}
