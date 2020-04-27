package array.PrintMinNumber;


import java.io.FileOutputStream;
import java.io.OutputStream;

public class Solution {

    public static void mergeSortCore(int[] arr, int lo, int hi) {
        if(lo == hi){
            return ;
        }
        int mid = lo +(hi-lo)>>1;
        mergeSortCore(arr,lo,mid);
        mergeSortCore(arr,mid+1,hi);
        merge(arr,lo,mid,hi);
    }

    private static void merge(int[] arr, int lo, int mid, int hi) {
        int[] temp = new int[hi-lo+1];
        int i=0, p1 = lo, p2 = mid+1;
        while(p1 <= mid && p2 <= hi){
            if(arr[p1] <= arr[p2]){
                temp[i++] = arr[p1++];
            }else{
                temp[i++] = arr[p2++];
            }
        }
        while(p1 <= mid){
            temp[i++] = arr[p1++];
        }
        while(p2 <= hi){
            temp[i++] = arr[p2++];
        }

        for(i =0;i<temp.length;i++){
            arr[lo+i] = temp[i];
        }

    }
}
