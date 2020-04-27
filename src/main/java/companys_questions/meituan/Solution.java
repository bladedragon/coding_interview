package companys_questions.meituan;

import java.util.Arrays;
import java.util.Scanner;

public class Solution  {
//    public static void main(String[] args) {
//        int[] arr = new int[]{1,3,2,4,5};
//        int maxLen =0;
//        int n =5;
//        int right =0;
//        int left = 0;
//        while(right < n){
//            int addNum = 1;
////            if(right+1 == 0){
////                addNum++;
////            }
//
//            if(right+addNum >=n){
//                break;
//            }
//            if(arr[right] < arr[right+addNum]){
//                right+= addNum;
//                maxLen = Math.max(maxLen,right-left);
//            }else{
//                maxLen = Math.max(maxLen,right-left+1);
//                left++;
//                right++;
//            }
//
//        }
//        System.out.println(maxLen);
//    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int m = scanner.nextInt();
        int p = scanner.nextInt();
        int q  =scanner.nextInt();
        int[] childTime = new int[k];
        for(int i =0;i<k;i++){
            childTime[i] = scanner.nextInt();
        }
        Arrays.sort(childTime);
        System.out.println(work(n,m,p,q,childTime));
    }

    public static int work(int n,int m,int p,int q,int[] childTime){
        int score = 0;
        int workTime =0;
        int flag =0;
        for(int i =0;i<childTime.length;i++){
            if(workTime+childTime[i] <m){
                workTime+= childTime[i];
                score += p;
            }else{
                flag++;
                break;
            }
        }
        if(flag!=0){
            return score;
        }
        score+=q;
        int d = m/workTime;
        d = d<n-1?d:n-1;
        if(d >1){
            score+=p*childTime.length+q;
        }
        int remain = m%workTime;
        for(int i =0;i<childTime.length;i++){
            remain-= childTime[i];
            if(remain >=0){
                score+=p;
            }
            break;
        }

        return score;
    }


}
