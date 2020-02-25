package bit.numbeOfOne;

public class Solution {
    public static int NumberOf1(int n) {
        int num = 0, flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0) {
                num++;
            }
            flag <<= 1;
        }
        return num;
    }

    public static void main(String[] args) {
        int n = Solution.NumberOf1(-1);
        System.out.println(n);
    }
}