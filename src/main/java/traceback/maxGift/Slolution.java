package traceback.maxGift;

import java.util.Arrays;

public class Slolution {
    public int maxGift(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int a = i > 0 ? matrix[i - 1][j] : 0;
                int b = j > 0 ? matrix[i][j - 1] : 0;

                matrix[i][j] += Math.max(a, b);
            }
        }

        System.out.println(Arrays.deepToString(matrix));

        return matrix[matrix.length - 1][matrix[0].length - 1];
    }
}
