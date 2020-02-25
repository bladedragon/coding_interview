package array.duplication;

import java.util.Arrays;

public class Solution {
    public boolean duplicate1(int numbers[],int length,int [] duplication) {

        duplication[0] = -1;
        for(int i =0;i<length;i++){

            for(int j =0;j < i;j++){
                if(numbers[i] == numbers[j]){
                    duplication[0] = numbers[j];
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 先排序然后判断是否有相同的数值
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplication2(int numbers[],int length,int[] duplication){
        Arrays.sort(numbers);
        for(int i=0;i<length;i++){
            if(numbers[i] == numbers[i+1]){
                duplication[0] = i;
                return true;
            }
        }
        return false;

    }

    /**
     * 哈希表的contianKey
     */

    /**
     * 归位思想
     * 一个萝卜一个坑
     */


    public boolean duplicate3(int numbers[], int length, int[] duplication) {
        if (length <= 0 || numbers == null) {
            return false;
        }

        int index = 0;
        while (index < length) {
            if (numbers[index] == index) { // 当前下标index的值刚好为index
                index++;
            } else {
                int tmp = numbers[index];
                if (tmp == numbers[tmp]) { // 要交换位置的两个数相同
                    duplication[0] = tmp;
                    return true;
                } else { // 交换位置
                    numbers[index] = numbers[tmp];
                    numbers[tmp] = tmp;
                }
            }
        }
        return false;
    }
}


