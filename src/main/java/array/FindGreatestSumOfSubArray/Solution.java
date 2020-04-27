package array.FindGreatestSumOfSubArray;
public class Solution {

    public int FindGreatestSumOfSubArray(int[] array) {
        int res = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < array.length; i++) {
            //如果结果小于0，则从下一个数重新开始计算，代表之前都无效了
            if(sum < 0) {
                sum = array[i];
            } else {
                //只要大于0，一直累加就一直变大
                sum += array[i];
            }
            if(sum > res) {
                res = sum;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,-5,-4,56,-98};
        Solution solution = new Solution();
//        int[] array = new int[]{1,-2,3,10,-4,7,2,-5};

        System.out.println(solution.FindGreatestSumOfSubArray(array));
    }
}