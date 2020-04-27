package array.MoreThanHalfNum_Solution;

public class Solution {

    public int MoreThanHalfNum_Solution(int[] array){
        int start = 0;
        int end = array.length-1;

        int mid  = start + ((end-start) >>1);
        int index = partition(array,start,end);
        if(index == mid){
            return array[mid];
        }
        
        while(index != mid && start <= end){
            if(index > mid){
                end = index -1;
                index = partition(array,start,end);
            }else{
                start = index +1;
                index = partition(array,start,end);
            }
        }
        if(checkIsHalf(array,index)){
            return array[index];
        }
        return 0;
    }

    private boolean checkIsHalf(int[] array, int index) {
        if (index < 0) {
            return false;
        }

        int count = 0;
        for (int i : array) {
            if (array[index] == i) {
                count++;
            }
        }
        return count > array.length / 2;
    }

    private int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int j =start;
        for(int i = start;i<end;i++){
            if(array[i] < pivot){
                if(array[i] != array[j]){
                    int temp = array[i];
                    array[i] =array[j];
                    array[j] = temp;
                    j++;
                }else{
                    j++;
                }
            }
        }
        int temp = array[j];
        array[j] = array[end];
        array[end] = temp;
        return j;
    }
}
