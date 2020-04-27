package array.InversePairs;

public class Solution {

    private static int count = 0;

    public int inversePair(int[] array){
        if (array == null) {
            return 0;
        }

        mergeSortCounting(array,0,array.length-1);
        return count;
    }

    private static void mergeSortCounting(int[] array, int left, int right) {
        int mid = left +((right-left)>>1);
        if(left >= right){
            return;
        }
        mergeSortCounting(array,left,mid);
        mergeSortCounting(array,mid+1,right);
        merge(array,left,mid,right);
    }

    private static void merge(int[] array, int left, int mid, int right) {

        int[] tmp  = new int[right-left+1];
        int i =left;
        int j = mid+1;
        int index = 0;
        while(i <=mid && j <=right){
            if(array[i] <= array[j]){
                tmp[index++] = array[i++];
            }else{
                tmp[index++] =  array[j++];
                count += mid-i+1;
            }
        }
        while(i <=mid){
            tmp[index++] = array[i++];
        }
        while(j <= right){
            tmp[index++] = array[j++];
        }
        for(i=0;i<=right-left;i++){
            array[left+i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        int[] ints = new int[]{2,4,3,1,5,6};
        Solution solution = new Solution();
        System.out.println(solution.inversePair(ints));

    }
}
