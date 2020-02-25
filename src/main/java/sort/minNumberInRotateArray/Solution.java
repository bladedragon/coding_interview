package sort.minNumberInRotateArray;

public class Solution {
    public int minNumberInRotateArray(int [] array) {
        int min = array[0];
        for(int i=1;i < array.length;i++){
            min =  min < array[i] ? min : array[i];
        }
        return min;
    }

    int minNumberInRotateArray2(int[] rotateArray) {
        if(rotateArray.length == 0)
            return 0;
        int low = 0;
        int high = rotateArray.length - 1;
        int mid = 0;

        while(low < high){
            // 子数组是非递减的数组，10111
            if (rotateArray[low] < rotateArray[high]){
                return rotateArray[low];
            }
            mid = low + (high - low) / 2;
            if(rotateArray[mid] > rotateArray[low]){
                low = mid + 1;
            }
            else if(rotateArray[mid] < rotateArray[high]){
                high = mid;
            }
            else{
                //当出现相等情况的时候，mid一定会指向前面二者偏前面的值
                //low++使得low==high，这样就无法达成while条件，就会返回 low
                low++;
            }
        }
        return rotateArray[low];
    }

    public int minNumberInRotateArray3(int[] rotateArray) {
        int left = 0,low = 0;
        int right = rotateArray.length-1,height = rotateArray.length-1;

        while(rotateArray[low] == rotateArray[height]){
            low++;
            height--;
        }
        if(rotateArray[low] < rotateArray[height]){
            return rotateArray[low];
        }
        while(rotateArray[left] > rotateArray[right]){
            int mid = left + ((right-left)>>1);
            if(rotateArray[left] <= rotateArray[mid]){
                left = mid+1;
            }else if(rotateArray[mid] <= rotateArray[right]){
                right = mid;
            }
        }

        return rotateArray[left];
    }


    public static int minNumberInRotateArray4(int[] array) {
        if (array.length == 0)
            return 0;
        int left = 0;
        int right = array.length - 1;
        int middle = -1;
        while (array[left]>=array[right]) {
            if(right-left==1){
                middle = right;
                break;
            }
            middle = left + (right - left) / 2;
            if (array[middle] >= array[left]) {
                left = middle;
            }
            if (array[middle] <= array[right]) {
                right = middle;
            }
        }
        return array[middle];
    }

    public static void main(String[] args) {
        int[] array = new int[]{ 1,0,1,1,1};
        Solution solution = new Solution();
        int res = solution.minNumberInRotateArray2(array);
        System.out.println(res);
    }
}
