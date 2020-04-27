package companys_questions.jindong;

import java.util.Arrays;
import java.util.Scanner;




public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] site = new int[n][2];
        for(int i=0;i<n;i++){
            site[i][0] = scanner.nextInt();
            site[i][1] = scanner.nextInt();
            System.out.println(Arrays.toString(site[i]));
        }
        int min = 0;
        int num = 0;
        for(int i=0;i<n;i++){
           if(min == site[i][0]){
               num++;
            }else if(min > site[i][0]){
               min = site[i][0];
               num = 1;
           }
        }
        System.out.println(num);
    }
}
