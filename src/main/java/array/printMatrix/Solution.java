package array.printMatrix;

import java.util.ArrayList;

public class Solution {
    ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<Integer> printMatrix(int[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }
        printM(list, matrix, 0, matrix.length - 1, 0, matrix[0].length - 1);
        return list;
    }

    public void printM(ArrayList<Integer> list, int[][] matrix, int rowl, int rowr,
                       int columnl, int columnr) {


        for (int i = columnl; i <= columnr; i++) {
                list.add(matrix[rowl][i]);
            }

        if(rowl+1 <= rowr) {
            for (int i = rowl+1; i <= rowr; i++) {
                list.add(matrix[i][columnr]);
            }
        }else{
            return;
        }

        if (columnl <= columnr - 1) {
            for (int i = columnr - 1; i >= columnl; i--) {
                list.add(matrix[rowr][i]);
            }
        }else{
            return;
        }

        if (rowl + 1 <= rowr - 1) {
            for (int i = rowr - 1; i >= rowl+1; i--) {
                list.add(matrix[i][columnl]);
            }
        }else{
            return;
        }

        if (columnl+1 <= columnr-1 ) {
            printM(list, matrix, rowl + 1, rowr - 1, columnl + 1, columnr - 1);
        }else{
            return;
        }
    }


    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] m = new int[1][1];
        m[0][0] = 1;
        Solution solution  = new Solution();
        solution.printMatrix(matrix);
        System.out.println(solution.list);
    }
}
