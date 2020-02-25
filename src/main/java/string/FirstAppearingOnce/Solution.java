package string.FirstAppearingOnce;

import java.util.*;

public class Solution {

    int[] charCount = new int[128];
    Queue<Character> queue = new LinkedList<Character>();

    public void Insert(char ch){

       int i = charCount[(int)ch]++;
        if(i == 0){
            queue.offer(ch);
        }

    }
    public char FirstAppearingOnce(){

        while(!queue.isEmpty()){
            char c = queue.peek();
            if(charCount[c] == 1){
                return c;
            }else{
                queue.remove();
            }
        }
        return '#';


}

    public static void main(String[] args) {
        int[] list=  new int[10];
        list[0] = 1;
//        list[1] = 2;
//        System.out.println(list.length);

        System.out.println(list[0]++ == 0);
        System.out.println(list[0]);
    }
}
