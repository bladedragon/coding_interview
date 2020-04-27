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


    public ArrayList<Integer> maxInWindows2(int [] num, int size)
    {
        if(num.length < 1){
            return null;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        int maxIndex = 0;
        int lowIndex = 0;
        int highIndex = -1;
        if(size <1 || size >num.length){
            return list;
        }
        for(int i =0;i<size;i++){
            maxIndex = num[i] > num[maxIndex] ? i:maxIndex;
            highIndex++;
        }

        System.out.println("highIndex:"+highIndex+"-lowIndex:"+lowIndex+"-maxIndex"+maxIndex);
        while(highIndex <num.length){
            System.out.println("highIndex:"+highIndex+"-lowIndex:"+lowIndex+"-maxIndex"+maxIndex);
            if(num[highIndex] > num[maxIndex]){
                maxIndex = highIndex;
                list.add(num[maxIndex]);
                highIndex++;
                lowIndex++;
                continue;
            }
            if(maxIndex >= lowIndex){
            }else{
                maxIndex = lowIndex;
                for(int i =lowIndex;i<=highIndex;i++){
                    maxIndex = num[maxIndex] > num[i]? maxIndex: i;
                }
            }
            list.add(num[maxIndex]);
            highIndex++;
            lowIndex++;
        }
        return list;
    }

    public static void main(String[] args) {
        int[] num = new int[]{2,3,4,2,6,2,5,1};
        Solution solution = new Solution();
        ArrayList<Integer> list = solution.maxInWindows2(num,3);
        for(int i =0;i < list.size();i++){
            System.out.println(list.get(i));
        }
    }
    }