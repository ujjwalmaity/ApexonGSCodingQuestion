import java.util.*;

// Given a matrix of size n * m,
// return the maximum path sum in the matrix.
// [You start from the top-left corner of the matrix and may up, down and diagonally].
//
// Example:
// Matrix 10 10 2 0 20 4
// 1 0 0 30 2 5
// 0 10 4 0 2 0
// 1 0 2 20 0 4
//
// Return 74 [The maximum sum path is 20-30-4-20]

public class Q23MaximumPathSumInMatrix {

    public void call() {
        int[][] matrix = {
                {10, 10, 2, 0, 20, 4},
                {1, 0, 0, 30, 2, 5},
                {0, 10, 4, 0, 2, 0},
                {1, 0, 2, 20, 0, 4}};

        int row = matrix.length;
        int column = matrix[0].length;

        int[][] dp = new int[row][column];
        for (int[] dpRow : dp) {
            Arrays.fill(dpRow, -1);
        }

        int maxi = Integer.MIN_VALUE; // (int) -1e9

        for (int j = 0; j < column; j++) {
            int maxPathValue = maxPath(row - 1, j, matrix, row, column, dp);
            maxi = Math.max(maxi, maxPathValue);
        }

        System.out.println(maxi);
    }

    // Recursion
    // Time Complexity without memorization: O(2^m*n)
    // Time Complexity with memorization: O(m*n)
    private int maxPath(int i, int j, int[][] matrix, int n, int m, int[][] dp) {
        if (j < 0 || j >= m) return Integer.MIN_VALUE;
        if (i == 0) return matrix[0][j];

        if (dp[i][j] != -1) return dp[i][j];

        int up = matrix[i][j] + maxPath(i - 1, j, matrix, n, m, dp);
        int leftDiagonal = matrix[i][j] + maxPath(i - 1, j - 1, matrix, n, m, dp);
        int rightDiagonal = matrix[i][j] + maxPath(i - 1, j + 1, matrix, n, m, dp);

        return dp[i][j] = Math.max(up, Math.max(leftDiagonal, rightDiagonal));
    }

    // Tabulation
    // Time Complexity: O(m*n)
    public void call2() {
        int[][] matrix = {
                {10, 10, 2, 0, 20, 4},
                {1, 0, 0, 30, 2, 5},
                {0, 10, 4, 0, 2, 0},
                {1, 0, 2, 20, 0, 4}};

        int row = matrix.length;
        int column = matrix[0].length;

        int[][] dp = new int[row][column];
        for (int j = 0; j < column; j++) {
            dp[0][j] = matrix[0][j];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 0; j < column; j++) {
                int up = matrix[i][j] + dp[i - 1][j];

                int leftDiagonal = matrix[i][j];
                if (j - 1 >= 0) leftDiagonal += dp[i - 1][j - 1];
                else leftDiagonal += Integer.MIN_VALUE;

                int rightDiagonal = matrix[i][j];
                if (j + 1 < column) rightDiagonal += dp[i - 1][j + 1];
                else rightDiagonal += Integer.MIN_VALUE;

                dp[i][j] = Math.max(up, Math.max(leftDiagonal, rightDiagonal));
            }
        }

        int maxi = Integer.MIN_VALUE;

        for (int j = 0; j < column; j++) {
            int maxPathValue = dp[row - 1][j];
            maxi = Math.max(maxi, maxPathValue);
        }

        System.out.println(maxi);
    }
}
