package array.find;
public class Solution {
    /**
     * 最简单的二分查找
     * @param target
     * @param array
     * @return
     */
    public boolean Find(int target, int [][] array) {
        boolean ans = false;
        for(int i=0; i< array.length;i++){
            ans = findMid(target,0,array[i].length-1,array[i]);
            if(ans == true){
                return true;
            }
        }
        return ans;

    }

    boolean findMid(int target,int left,int right,int[] array){

        int mid = left + (right-left)/2;
        if(left<=right){
            if(target == array[mid]){
                return true;
            }
            if(target < array[mid]){
                return findMid(target,left,mid-1,array);
            }else if(target >  array[mid]){
                return findMid(target,mid+1,right,array);
            }
        }
        return false;
    }

    boolean fine2(int target, int[][] array){
        int rowCount = array.length;
        int columnCount = array[0].length;

        for(int i=rowCount-1 ,j =0; i < rowCount && j < columnCount;){
            if(target == array[i][j]){
                return true;
            }
            else if(target > array[i][j]){
                j++;
                continue;
            }
            else if(target < array[i][j]){
                i--;
                continue;
            }
        }
        return false;
    }



    public static void main(String[] args) {
        int[][] array = new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,5}};
//        int[][] array = new int[][]{{1,2,8,9},{4,7,10,13}};
        Solution solution = new Solution();
        System.out.println(solution.fine2(1,array));
    }
}