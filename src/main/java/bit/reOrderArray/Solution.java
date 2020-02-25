package bit.reOrderArray;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {
    //插入排序，优化的化还可以将位移变成交换
    public void reOrderArray(int [] array) {
        if(array.length <= 1){
            return;
        }
        int k = 0;
        for(int i=0;i<array.length;i++){
            if((array[i] & 1) == 1){
                int j =i;
                int temp = array[i];
                while(j > k){
                    //这里可以改成交换
                    array[j] = array[j-1];
                    j--;
                }
                array[k] = temp;
                k++;
            }
        }
    }
    public void reOrderArray2(int [] array) {

        int[] extra = new int[array.length];
        int k =0;
        for(int i=0;i<array.length;i++){
            if(array[i] %2 == 1){
                extra[k] = array[i];
                k++;
            }
        }
        for(int i =0;i<array.length;i++){
            if(array[i] %2 ==0){
                extra[k] = array[i];
                k++;
            }
        }
        k = array.length-1;
        while(k != -1){
            array[k] = extra[k];
            k--;
        }
    }

    public void swap(int a, int b,int[] arr){
        int temp = arr[a];
        arr[a] =arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = {2,4,6,1,3,5,7};
        System.out.println(Arrays.toString(a));
        solution.reOrderArray2(a);
        System.out.println(Arrays.toString(a));
    }
}
