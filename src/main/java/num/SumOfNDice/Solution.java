package num.SumOfNDice;

import java.text.DecimalFormat;
import java.util.Arrays;

public class Solution {

    public void SumOfNDice(int n) {
        if (n < 1) {
            return;
        }

        int[][] nums = new int[2][n * 6 + 1];

        int flag = 0;

        //初始化第一个骰子各总和出现的次数
        int maxLen = nums[0].length;
        for (int i = 1; i < maxLen; i++) {
            nums[flag][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            int newFlag = flag ^ 0x01;
            //使用完的数组归零
            Arrays.fill(nums[newFlag], 0);

            for (int j = i; j < maxLen; j++) {
                int sum = 0;

                //注意这里，这一个数组的和值是由上一个数组的值叠加得到的
                for (int k = 1; k <= 6 && (j - k >= 0); k++) {
                    sum += nums[flag][j - k];
                }

                nums[newFlag][j] = sum;
            }
            flag = newFlag;
        }

        //debug out
        System.out.println(Arrays.toString(nums[flag]));

        int sum = 0;
        for (int i : nums[flag]) {
            sum += i;
        }

        for (int i = 0; i < nums[flag].length; i++) {
            System.out.println(i + ":" + nums[flag][i] * 1.0 / sum);
        }
    }


    public void printProbability(int number) {  //number为骰子的个数
        if (number < 1)  return;

        int g_maxValue = 6;    //骰子的最大点数为6

        int[][] probabilities = new int[2][];   //定义两个数组用于保存前一循环的数据供下一阶段使用
        probabilities[0] = new int[g_maxValue * number + 1];
        probabilities[1] = new int[g_maxValue * number + 1];

        int flag = 0;    //用于表示轮数交换的表示，当前阶段的信息做下一阶段的输入，上一阶段的信息清空，表示下阶段的输出
        //初始化骰子为1时，F(1,s) 的频数
        for (int i = 1; i <= g_maxValue; i++)
            probabilities[0][i] = 1;

        // n表示s要加上第n个骰子朝上的数，也表示n轮大循环
        for (int n = 2; n <= number; ++n) {

            // 归零操作，因为随着s的变大，F(1,0), F(2,1), F(3,2),...,F(6,5)都不会出现，但是前面计算出现过F(1,1), F(2,2), F(3,3),...,F(5,5)，
            //因为我们是交替使用前一个数组，所以必须作归零处理
            for (int i = 0; i < n; ++i)
                probabilities[1 - flag][i] = 0;

            //第n轮数据之和为s∈[n, g_maxValue*n]，然后计算每一个s的频数
            for (int s = n; s <= g_maxValue * n; ++s) {
                probabilities[1 - flag][s] = 0;   //  第n轮第n个数据初始化为0

                //计算F(n, s) = F(n-1, s-1) + F(n-1, s-2) + F(n-1, s-3) + F(n-1, s-4) + F(n-1, s-5) + F(n-1, s-6)
                //注意s >= j
                for (int j = 1; j <= s && j <= g_maxValue; ++j)
                    probabilities[1 - flag][s] += probabilities[flag][s - j];
            }
            flag = 1 - flag;
        }
        double total = Math.pow(g_maxValue, number);
        for (int i = number; i <= g_maxValue * number; i++) {
            double ratio = (double) probabilities[flag][i] / total;
            System.out.println(i);
            System.out.println(ratio);
        }
    }

    public void test(int n){
        int g_max = 6;

        int[][] nums = new int[2][n*g_max+1];

        for(int i =1;i<=g_max;i++){
            nums[0][i] = 1;
        }
        int flag = 0;
        for(int i =2;i<n;i++){
            int newFlag = 1-flag;
            Arrays.fill(nums[newFlag],0);

            for(int j = i;j<=i*g_max;j++){

                for(int k =1;k<=g_max && j >=k;k++){
                    nums[newFlag][j] +=  nums[flag][j-k];
                }

                flag=  newFlag;
            }
        }
    }

    public static void main(String[] args) {
//        int flag = 6;
//        flag = flag ^ 0x01;
//        System.out.println(flag);

        Solution solution = new Solution();
        solution.SumOfNDice(3);
    }
}
