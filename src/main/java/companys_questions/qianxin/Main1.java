package companys_questions.qianxin;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] count = new int[]{2,3,1,5,4,3};
        int[] value = new int[]{2,2,3,1,5,2};
        int[][] state = new int[count.length][n+1];
        for(int i =0; i < count.length;i++){
            for(int j =0; j < n; j++){
                state[i][j] = -1;
            }
        }
        state[0][0] = 0;
        if(value[0] < n){
            state[0][value[0]] = count[0];
        }

        for(int i =1;i<count.length;i++){
            for(int j =0; j<n;j++){
                if(state[i-1][j] >=0){
                    state[i][j] = state[i-1][j];
                }
            }
            for(int j =0; j <= n-value[i] ;j++){
                if(state[i-1][j] >= 0){
                    int c = state[i-1][j] + count[i];
                    if(c > state[i][value[i]+j]){
                        state[i][j+value[i]] = c;
                    }
                }
            }
        }
        int maxCount = -1;
        for(int i =0;i<n+1;i++){
            if(state[count.length-1][i] > maxCount){
                maxCount = state[count.length-1][i];
            }
        }
        System.out.println(maxCount);

    }
}
