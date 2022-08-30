//https://leetcode.com/problems/rotate-image/

public class RotateImageClockwise {
    public void rotate(int[][] matrix) {
        for(int i = 0; i < (matrix.length + 1) / 2; i++) {
            for(int j = i ; j < matrix[i].length - i - 1; j++) {
                int temp = matrix[j][matrix[i].length - 1 - i];
                matrix[j][matrix[i].length - 1 - i] = matrix[i][j];

                int temp2 = matrix[matrix.length - i - 1][matrix[i].length - j - 1];
                matrix[matrix.length - i - 1][matrix[i].length - j - 1] = temp;

                temp = matrix[matrix.length - j - 1][i];
                matrix[matrix.length - j - 1][i] = temp2;

                matrix[i][j] = temp;
            }
        }
    }
}