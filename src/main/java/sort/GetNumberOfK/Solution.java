package sort.GetNumberOfK;

public class Solution {
    //这里加静态测试就出问题了
    private static int count =0;
    public int GetNumberOfK(int[] array,int k){
        if(array.length == 0 || k < array[0] || k > array[array.length-1]){
            return 0;
        }
        midCount(array,0,array.length-1,k);
        return count;
    }
    public void midCount(int[] array, int left, int right,int k){
        if(left>right){
            return;
        }
        int mid = left+(right-left)/2;

        if(k < array[mid]){
            midCount(array,left,mid-1,k);
        }else if(k >array[mid]){
            midCount(array,mid+1,right,k);
        }else {
            count++;
            int tempMid = mid;
            for (int i = mid - 1; i >= 0 && array[i] == k; i--) {
                count++;

            }
            for (int i = mid + 1; i <= array.length - 1 && array[i] == k; i++) {
                count++;
            }
        }
    }

    public static void main(String[] args) {

        int[] array = new int[]{3,3,3,3,4,5};
        Solution solution = new Solution();
        int count  = solution.GetNumberOfK(array,3);
        System.out.println(count);
    }
}
