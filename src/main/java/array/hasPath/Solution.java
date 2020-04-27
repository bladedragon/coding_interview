package array.hasPath;

public class Solution {
    public boolean hasPath(char[] matrix,int rows,int cols,char[] str){
        char[][] matrix_r = new char[rows][cols];

        int k =0;
        for(int i =0;i<rows;i++){
            for(int j= 0;j<cols;j++){
                matrix_r [i][j] = matrix[k++];
            }
        }

        int[][] flag = new int[rows][cols];
        for (int i = 0; i < matrix_r.length; i++) {
            for (int j = 0; j < matrix_r[i].length; j++) {
                if (matrix_r[i][j] == str[0]) {
                    if (hasPath(matrix_r, flag, i, j, str, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean hasPath(char[][] matrix, int[][] flag, int x, int y, char[] str, int index) {
        if (x < 0 || y < 0) return false;
        if (x >= matrix.length || y >= matrix[0].length) return false;

        if (flag[x][y] == 1) return false;

        boolean subres = false;
        if (matrix[x][y] == str[index]) {

            if (index == str.length - 1) return true;
            //备忘录
            flag[x][y] = 1;

            boolean sub1 = hasPath(matrix, flag, x + 1, y + 1, str, index + 1);
            boolean sub2 = hasPath(matrix, flag, x + 1, y + 1, str, index + 1);
            boolean sub3 = hasPath(matrix, flag, x + 1, y + 1, str, index + 1);
            boolean sub4 = hasPath(matrix, flag, x + 1, y + 1, str, index + 1);

            subres = sub1| sub2| sub3| sub4;
            //全部走完，备忘录清零
            flag[x][y] = 0;
        }
        return subres;
    }
}
