package queue.maxInWindows;

import java.util.*;
public class Solution {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        Queue<Integer> queue  = new LinkedList<Integer>();
        ArrayList<Integer> maxList = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        if(size > num.length || size ==0){
            return maxList;
        }
        for(int i=0;i<size;i++){
            queue.offer(num[i]);
            if(max < num[i]){
                max  = num[i];
            }
        }
        maxList.add(max);
        int flag =size-1;

        while(flag != num.length-1){
            flag++;
            int pollNum = queue.poll();
            queue.offer(num[flag]);
            if(max < num[flag]){
                max = num[flag];
                maxList.add(num[flag]);
            }else if(pollNum < max){
                maxList.add(max);
            }else{
                //注意size等于1的特殊情况，不要省事，要把flag的变量也加入计算
                max = num[flag];
                for(int i=0;i<size;i++){
                    max = max < num[flag-i]? num[flag-i] : max;
                }
                maxList.add(max);
            }
        }
        return maxList;
        }

    public static void main(String[] args) {
        int[] num = new int[]{10,14,12,11};
        Solution solution = new Solution();
        ArrayList<Integer> list = solution.maxInWindows(num,1);
        for(int i =0;i < list.size();i++){
            System.out.println(list.get(i));
        }
    }
    }