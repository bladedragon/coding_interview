package string.LeftRotateString;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public String LeftRotateString(String str,int n){
        StringBuilder build = new StringBuilder();
        build.append(str.substring(n,str.length()));
        build.append(str.substring(0,n));

        return build.toString();

    }

    public String ReverseSentence(String str) {
        if(str == null || str.equals(" ")){
            return "";
        }
        String[] strs = str.split(" ");
        StringBuilder build = new StringBuilder();
        for(int i =strs.length-1;i>=0;i--){
            build.append(strs[i]);
            if(i != 0)
                build.append(" ");
        }
        if(build == null){
            return " ";
        }else{
            return build.toString();
        }

    }

        public String LeftRotateString2(String str,int n) {
            Queue<Character> queue = new LinkedList<Character>();
            if(str == ""){
                return null;
            }
            if(n<=0 || n >= str.length()){
                return null;
            }
            int index =0;
            char[] strs = str.toCharArray();
            while(index < n){
                queue.offer(strs[index]);
                index++;
            }
            StringBuilder string = new StringBuilder();
            for(int i =n-1;i<strs.length;i++){
                string.append(strs[i]);
            }
            while(!queue.isEmpty()){
                string.append(queue.poll());
            }
            return string.toString();
        }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String res = solution.LeftRotateString2("sadasd",3);
        System.out.println(res);
    }

}
