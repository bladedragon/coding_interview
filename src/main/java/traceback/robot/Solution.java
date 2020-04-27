package traceback.robot;

import java.math.BigDecimal;

public class Solution {

    public int movingCount(int threshold, int rows, int cols)
    {
        //边界条件
        if(threshold<0||rows<=0||cols<=0){
            return 0;
        }
        //标记数组，判断节点是否被访问,初始值都为false
        boolean[][] isVisited=new boolean[rows][cols];
        //dfs算法,格子数等于后面计算的加上（0，0）
        return depthFirstSearch(threshold,rows,cols,0,0,isVisited)+1;
    }
    //i与j为当前搜索节点在矩阵中的坐标
    private int depthFirstSearch(int threshold,int rows,int cols,int i,int j,boolean[][] isVisited){
        //边界条件
        if(i>=rows||j>=cols||i<0||j<0){
            return 0;
        }
        //设置当前节点被访问
        isVisited[i][j]=true;
        int number=0;
        //定义方向
        int[] dx={1,-1,0,0};
        int[] dy={0,0,1,-1};
        //访问（i，j）的下一个节点（X,Y）
        for(int k=0;k<4;k++){
            //(X,Y)为（i，j）的下一个移动的坐标
            int X=i+dx[k];
            int Y=j+dy[k];
            //(X,Y)节点满足1、阈值大小2、节点坐标未出界3、当前节点未被访问，再去访问下一个节点
            if(X>=0&&Y>=0&&(sumOfValue(X)+sumOfValue(Y))<=threshold&&X<rows&&Y<cols&&isVisited[X][Y]==false){
                //递归，格子数目等于后面递归的格子数+1；
                number+=depthFirstSearch(threshold,rows,cols,X,Y,isVisited)+1;
            }
        }
        return number;
    }

    //判断阈值大小哦
    private int sumOfValue(int number){
        int sum=0;
        while(number!=0){
            sum+=number%10;
            number=number/10;
        }
        return sum;
    }



    public static void main(String[] args) {
//        double s = 1.11111123;
//        BigDecimal big = new BigDecimal(s);
//        System.out.println(big.setScale(2,BigDecimal.ROUND_DOWN).doubleValue());

    }
}