package array.reOrderArray;

import java.util.Arrays;

public class Solution {
    public void reOrderArray(int[] array){
        //第一行关系不大
        for(int i =0;i<array.length;i++){
            boolean flag = false;
            for(int j =0;j<array.length-1;j++){
                if(!isOrder(array,j,j+1)){
                    swap(array,j+1,j);
                    flag = true;
                }
            }
            if(!flag){
                break;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    /**
     * 归并方法实现的
     * @param array
     */
    public void reOrderArray2(int[] array){
        int left = 0;
        int right = array.length;
        reOrderMerge(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }

    public void reOrderMerge(int[] array,int left,int right){
        int mid = left+ ((right-left)>>1);
        if(left >= right){
            return ;
        }
        reOrderMerge(array,left,mid);
        reOrderMerge(array,mid+1,right);
        merge(array,left,mid,right);

    }

    private void merge(int[] array, int left, int mid, int right) {
        int[] temp = new int[right-left+1];
            int i = left;
            int j = mid+1;
            int k =0;
            while(i <=mid && j <= right){
                    if(isOrder(array,i,j)){
                        temp[k++] = array[i++];
                    }else{
                        temp[k++] = array[j++];
                    }
            }
            if(i <= mid){
                while(i <=mid){
                    temp[k++] = array[i++];
                }
            }
            if(j <= right){
                while(j <= right){
                    temp[k++] = array[j++];
                }
            }
            for(i =0;i<right-left+1;i++){
                array[left+i] = temp[i];
            }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i]  = array[j];
        array[j] = temp;
    }

    public boolean isOrder(int[] array,int i,int j){
        if((array[i] & 1) == 1 || (array[j] & 1) == 0){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,12,2,2,39,5};
        System.out.println(Arrays.toString(array));
        Solution solution = new Solution();
        solution.reOrderArray2(array);
    }
}
