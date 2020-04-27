package companys_questions.zhoashangBank;

import java.util.*;
import java.util.logging.LoggingPermission;

public class Solution2 {

    public static void main(String[] args) {
        Scanner sacnner = new Scanner(System.in);
        int t = sacnner.nextInt();
        List<Integer> list = new ArrayList<>();
        for(int i =0;i<t;i++){
            long num = sacnner.nextLong();
            int k = sacnner.nextInt();
            String str = String.valueOf(num);
            list.add(addNum(str,k));
        }
        for(int n : list){
            System.out.println(n);
        }
    }

    public static int addNum(String str,int k){
        int[] res = new int[1];
        res[0] = 0;
        char[] cs = str.toCharArray();
        int[] nums = changeToInteger(cs);
        int sum = 0;

        if(str.length() <1){
            return res[0];
        }
        dfs(nums,res,0,sum,k);
        return res[0];

    }

    public static void  dfs(int[] nums,int[] res,int i,int sum,int k){

        if(sum == k && i == nums.length){
            res[0]++;
            return ;
        }
        if(i >= nums.length){
            return ;
        }

       // System.out.println("+"+nums[i]);

        dfs(nums,res,i+1,sum+nums[i],k);



      //  System.out.println("-"+nums[i]);
        if(i !=0){
            dfs(nums,res,i+1,sum-nums[i],k);
        }


    }

    public static int[] changeToInteger(char[] cs){
        int[] ints = new int[cs.length];
        for(int i =0;i<cs.length;i++){
            ints[i] = cs[i] - '0';
        }
        return ints;
    }
}
