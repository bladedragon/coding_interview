package num.LastRemaining;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int  LastRemaining_Solution(int n, int m) {
        if(m ==0 || n == 0){
            return -1;
        }

        List<Integer> list = new ArrayList<Integer>();
        for(int i =0;i<n;i++){
            list.add(i);
        }

        int index = -1;
        while(list.size() >1){
            index = (index +m)%list.size();
            list.remove(index);



        }
        return list.get(0);
    }

    public int LastRemaining(int n, int m) {
        if(n <1 || m<1){
            return -1;
        }
        int[] array = new int[n];
        int i =0,step =0,count = n;
        while(count >0){

            if(i == n){
                i =0;
            }
            if(array[i] == -1){
                continue;
            }
            step++;
            if(step == m){
                step =0;
                array[i] = -1;
                count --;
            }

        }
        return i;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.LastRemaining_Solution(5,3);
        System.out.println(i);

    }
}
