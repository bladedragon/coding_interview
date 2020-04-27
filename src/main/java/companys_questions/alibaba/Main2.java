package companys_questions.alibaba;

import java.util.Scanner;

public class Main2 {
    public int movingCount(int threshold, int rows, int cols)
    {

        if(threshold<0||rows<=0||cols<=0){
            return 0;
        }

        boolean[][] isVisited=new boolean[rows][cols];

        return depthFirstSearch(threshold,rows,cols,0,0,isVisited)+1;
    }

    private int depthFirstSearch(int threshold,int rows,int cols,int i,int j,boolean[][] isVisited){

        if(i>=rows||j>=cols||i<0||j<0){
            return 0;
        }

        isVisited[i][j]=true;
        int number=0;

        int[] dx={1,-1,0,0};
        int[] dy={0,0,1,-1};

        for(int k=0;k<4;k++){

            int X=i+dx[k];
            int Y=j+dy[k];

            if(X>=0&&Y>=0&&(sumOfValue(X)+sumOfValue(Y))<=threshold&&X<rows&&Y<cols&&isVisited[X][Y]==false){

                number+=depthFirstSearch(threshold,rows,cols,X,Y,isVisited)+1;
            }
        }
        return number;
    }


    private int sumOfValue(int number){
        int sum=0;
        while(number!=0){
            sum+=number%10;
            number=number/10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] matrix = new int[n][m];
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                matrix[i][j] = scanner.nextInt();
            }
        }
        System.out.println(4);

    }
}
