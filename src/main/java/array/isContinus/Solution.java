package array.isContinus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean isContinuous(int [] numbers) {
        Sort(numbers);
        System.out.println(Arrays.toString(numbers));
        int[] res = new int[numbers.length];
        int count  = 0;
        int i=0;
        int index = 0;
        Set<Integer> set = new HashSet<Integer>();
        for(i=0;i<numbers.length;i++){
            if(numbers[i]== 0){
                count++;
                index = i+1;
            }else{
//                if (set.contains(numbers[i])) {
//                    return false;
//                }
                set.add(numbers[i]);
            }
        }
        //去重
        if ((count + set.size()) != 5) {
            return false;
        }
        //没有重复的话只要和小于sum就可以
        if(numbers[numbers.length-1]-numbers[index] < numbers.length){
            return true;
        }
        return false;


    }

    public void Sort(int[] number){
        for(int i =0;i<number.length;i++){
            for(int j=0;j<i;j++){
                if(number[i] < number[j]){
                    int temp = number[i];
                    number[i] = number[j];
                    number[j] = temp;
                }
            }
        }
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = new int[]{1,3,2,6,4};
        System.out.println(solution.isContinuous(ints));
        ArrayList<Integer> list = new ArrayList<Integer>();

    }
}
