package companys_questions.meituan;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int i =0;
        while(scanner.hasNextLine()){
            if(i == n){
                break;
            }
            arr[i] = scanner.nextInt();
            i++;
        }
        int maxLen = Integer.MIN_VALUE;
//        int mid = n>>1;
        for(i =0;i<n;i++){
            int left =0;
            int right =0;
            while(right < n){
                int addNum = 1;
            if(right+1 == 0){
                addNum++;
            }
                if(right+addNum >=n){
                    break;
                }
                if(arr[right] < arr[right+addNum]){
                    right+= addNum;
                    maxLen =maxLen>(right-left+1)?maxLen:right-left+1;

                }else{
                    maxLen =maxLen>(right-left+1)?maxLen:right-left+1;
                    left++;
                    right++;
                }
//                if(maxLen > (n>>1)){
//                    break;
//                }
            }
        }
        System.out.println(maxLen);
    }

    public class Solution {
        public int lengthOfLIS(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            int[] dp = new int[nums.length];
            dp[0] = 1;
            int maxans = 1;
            //注意这里的i==1
            for (int i = 1; i < dp.length; i++) {
                int maxval = 0;
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        maxval = Math.max(maxval, dp[j]);
                    }
                }
                dp[i] = maxval + 1;
                maxans = Math.max(maxans, dp[i]);
            }
            return maxans;
        }
    }


}
