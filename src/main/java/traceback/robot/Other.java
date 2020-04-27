package traceback.robot;

public class Other {
    public int movingCount(int threshold,int rows,int cols){
        boolean[][] visited = new boolean[rows][cols];
        int count = 0;
        if(threshold<0||rows<=0||cols<=0){
            return 0;
        }

        return dfs(threshold,rows,cols,0,0,visited)+1;
    }

    public int dfs(int threshold,int rows,int cols,int i,int j,boolean[][] isVistied){
        if(i >= rows || j >= cols || i < 0 || j < 0){
            return 0;
        }
        isVistied[i][j] = true;
        int number = 0;
        if (i + 1 > 0 && j > 0 && i+1 < rows && j < cols && allowDist(i+1,j) <= threshold && !isVistied[i+1][j]) {
            number += dfs(threshold,rows,cols,i+1,j,isVistied)+1;
        }
        if (i > 0 && j + 1 > 0 && i < rows && j +1 < cols && allowDist(i,j+1) <= threshold && !isVistied[i][j+1]) {
            number += dfs(threshold,rows,cols,i,j+1,isVistied)+1;
        }
        if (i - 1 > 0 && j > 0 && i-1 < rows && j < cols && allowDist(i-1,j) <= threshold && !isVistied[i-1][j]) {
            number += dfs(threshold,rows,cols,i-1,j,isVistied)+1;
        }
        if (i  > 0 && j - 1 > 0 && i < rows && j -1 < cols && allowDist(i,j-1) <= threshold && !isVistied[i][j-1]) {
            number += dfs(threshold,rows,cols,i,j-1,isVistied)+1;
        }
        return number;
    }

    public int allowDist(int x,int y){
        int sum = 0;
        for(int i = 1;i<=x;i*=10){
            int m = x/i;
            if(i ==1){
                int n = x %10;
                sum+=n;
                continue;
            }
            sum+=m;

        }

        for(int i = 1;i<=y;i*=10){
            int m = y/i;
            if(i ==1){
                int n = y %10;
                sum+=n;
                continue;
            }
            sum+=m;
        }
        return sum ;
    }

    public static void main(String[] args) {
        Other o = new Other();


    }
}
