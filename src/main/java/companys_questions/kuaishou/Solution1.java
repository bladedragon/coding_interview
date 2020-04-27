package companys_questions.kuaishou;

import java.util.Arrays;

public class Solution1 {

    public static int[] DistanceToHigher (int[] height) {
        // write code here
        int[] res = new int[height.length];
        if(height.length <=0){
            return res;
        }

            res[0] = 0;

        int maxHeight = 0;
        for(int i =1;i<height.length;i++){
                if(height[i-1] < height[i]){
                    if(height[i] < height[maxHeight]) {
                        res[i] = i-maxHeight ;
                    }else{
                        res[i] = 0;
                        maxHeight = i;
                    }
                }else{
                    res[i] = 1;
                }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{175,173,174,163,182,177};
        System.out.println(Arrays.toString(Solution1.DistanceToHigher(ints)));
    }
}
